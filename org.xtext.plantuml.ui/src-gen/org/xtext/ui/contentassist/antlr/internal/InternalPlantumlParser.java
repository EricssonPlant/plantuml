package org.xtext.ui.contentassist.antlr.internal; 

import java.util.Map;
import java.util.HashMap;

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
    public String getGrammarFileName() { return "../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g"; }


     
     	private PlantumlGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("QuotationMark", "'\"'");
    		tokenNameToValue.put("NumberSign", "'#'");
    		tokenNameToValue.put("LeftParenthesis", "'('");
    		tokenNameToValue.put("RightParenthesis", "')'");
    		tokenNameToValue.put("Comma", "','");
    		tokenNameToValue.put("Colon", "':'");
    		tokenNameToValue.put("LessThanSignLessThanSign", "'<<'");
    		tokenNameToValue.put("EqualsSignEqualsSign", "'=='");
    		tokenNameToValue.put("GreaterThanSignGreaterThanSign", "'>>'");
    		tokenNameToValue.put("Of", "'of'");
    		tokenNameToValue.put("VerticalLineVerticalLine", "'||'");
    		tokenNameToValue.put("FullStopFullStopFullStop", "'...'");
    		tokenNameToValue.put("Red", "'Red'");
    		tokenNameToValue.put("Tan", "'Tan'");
    		tokenNameToValue.put("Alt", "'alt'");
    		tokenNameToValue.put("Box", "'box'");
    		tokenNameToValue.put("End", "'end'");
    		tokenNameToValue.put("Opt", "'opt'");
    		tokenNameToValue.put("Par", "'par'");
    		tokenNameToValue.put("Ref", "'ref'");
    		tokenNameToValue.put("VerticalLineVerticalLineVerticalLine", "'|||'");
    		tokenNameToValue.put("Aqua", "'Aqua'");
    		tokenNameToValue.put("Blue", "'Blue'");
    		tokenNameToValue.put("Cyan", "'Cyan'");
    		tokenNameToValue.put("Gold", "'Gold'");
    		tokenNameToValue.put("Gray", "'Gray'");
    		tokenNameToValue.put("Grey", "'Grey'");
    		tokenNameToValue.put("Lime", "'Lime'");
    		tokenNameToValue.put("Navy", "'Navy'");
    		tokenNameToValue.put("Peru", "'Peru'");
    		tokenNameToValue.put("Pink", "'Pink'");
    		tokenNameToValue.put("Plum", "'Plum'");
    		tokenNameToValue.put("Snow", "'Snow'");
    		tokenNameToValue.put("Teal", "'Teal'");
    		tokenNameToValue.put("Else", "'else'");
    		tokenNameToValue.put("Hide", "'hide'");
    		tokenNameToValue.put("Left", "'left'");
    		tokenNameToValue.put("Loop", "'loop'");
    		tokenNameToValue.put("Note", "'note'");
    		tokenNameToValue.put("Over", "'over'");
    		tokenNameToValue.put("Azure", "'Azure'");
    		tokenNameToValue.put("Beige", "'Beige'");
    		tokenNameToValue.put("Black", "'Black'");
    		tokenNameToValue.put("Brown", "'Brown'");
    		tokenNameToValue.put("Coral", "'Coral'");
    		tokenNameToValue.put("Green", "'Green'");
    		tokenNameToValue.put("Ivory", "'Ivory'");
    		tokenNameToValue.put("Khaki", "'Khaki'");
    		tokenNameToValue.put("Linen", "'Linen'");
    		tokenNameToValue.put("Olive", "'Olive'");
    		tokenNameToValue.put("Wheat", "'Wheat'");
    		tokenNameToValue.put("White", "'White'");
    		tokenNameToValue.put("Actor", "'actor'");
    		tokenNameToValue.put("Break", "'break'");
    		tokenNameToValue.put("Group", "'group'");
    		tokenNameToValue.put("Right", "'right'");
    		tokenNameToValue.put("Title", "'title'");
    		tokenNameToValue.put("Bisque", "'Bisque'");
    		tokenNameToValue.put("Indigo", "'Indigo'");
    		tokenNameToValue.put("Maroon", "'Maroon'");
    		tokenNameToValue.put("Orchid", "'Orchid'");
    		tokenNameToValue.put("Purple", "'Purple'");
    		tokenNameToValue.put("Salmon", "'Salmon'");
    		tokenNameToValue.put("Sienna", "'Sienna'");
    		tokenNameToValue.put("Silver", "'Silver'");
    		tokenNameToValue.put("Tomato", "'Tomato'");
    		tokenNameToValue.put("Violet", "'Violet'");
    		tokenNameToValue.put("Yellow", "'Yellow'");
    		tokenNameToValue.put("Center", "'center'");
    		tokenNameToValue.put("Create", "'create'");
    		tokenNameToValue.put("Entity", "'entity'");
    		tokenNameToValue.put("Legend", "'legend'");
    		tokenNameToValue.put("Crimson", "'Crimson'");
    		tokenNameToValue.put("DarkRed", "'DarkRed'");
    		tokenNameToValue.put("DimGray", "'DimGray'");
    		tokenNameToValue.put("DimGrey", "'DimGrey'");
    		tokenNameToValue.put("Fuchsia", "'Fuchsia'");
    		tokenNameToValue.put("HotPink", "'HotPink'");
    		tokenNameToValue.put("Magenta", "'Magenta'");
    		tokenNameToValue.put("OldLace", "'OldLace'");
    		tokenNameToValue.put("SkyBlue", "'SkyBlue'");
    		tokenNameToValue.put("Thistle", "'Thistle'");
    		tokenNameToValue.put("Control", "'control'");
    		tokenNameToValue.put("Destroy", "'destroy'");
    		tokenNameToValue.put("Footbox", "'footbox'");
    		tokenNameToValue.put("Newpage", "'newpage'");
    		tokenNameToValue.put("Cornsilk", "'Cornsilk'");
    		tokenNameToValue.put("DarkBlue", "'DarkBlue'");
    		tokenNameToValue.put("DarkCyan", "'DarkCyan'");
    		tokenNameToValue.put("DarkGray", "'DarkGray'");
    		tokenNameToValue.put("DarkGrey", "'DarkGrey'");
    		tokenNameToValue.put("DeepPink", "'DeepPink'");
    		tokenNameToValue.put("HoneyDew", "'HoneyDew'");
    		tokenNameToValue.put("Lavender", "'Lavender'");
    		tokenNameToValue.put("Moccasin", "'Moccasin'");
    		tokenNameToValue.put("SeaGreen", "'SeaGreen'");
    		tokenNameToValue.put("Activate", "'activate'");
    		tokenNameToValue.put("Boundary", "'boundary'");
    		tokenNameToValue.put("Critical", "'critical'");
    		tokenNameToValue.put("Database", "'database'");
    		tokenNameToValue.put("AliceBlue", "'AliceBlue'");
    		tokenNameToValue.put("BurlyWood", "'BurlyWood'");
    		tokenNameToValue.put("CadetBlue", "'CadetBlue'");
    		tokenNameToValue.put("Chocolate", "'Chocolate'");
    		tokenNameToValue.put("DarkGreen", "'DarkGreen'");
    		tokenNameToValue.put("DarkKhaki", "'DarkKhaki'");
    		tokenNameToValue.put("DarkSalmo", "'DarkSalmo'");
    		tokenNameToValue.put("FireBrick", "'FireBrick'");
    		tokenNameToValue.put("Gainsboro", "'Gainsboro'");
    		tokenNameToValue.put("GoldenRod", "'GoldenRod'");
    		tokenNameToValue.put("IndianRed", "'IndianRed'");
    		tokenNameToValue.put("LawnGreen", "'LawnGreen'");
    		tokenNameToValue.put("LightBlue", "'LightBlue'");
    		tokenNameToValue.put("LightCyan", "'LightCyan'");
    		tokenNameToValue.put("LightGray", "'LightGray'");
    		tokenNameToValue.put("LightGrey", "'LightGrey'");
    		tokenNameToValue.put("LightPink", "'LightPink'");
    		tokenNameToValue.put("LimeGreen", "'LimeGreen'");
    		tokenNameToValue.put("MintCream", "'MintCream'");
    		tokenNameToValue.put("MistyRose", "'MistyRose'");
    		tokenNameToValue.put("OliveDrab", "'OliveDrab'");
    		tokenNameToValue.put("OrangeRed", "'OrangeRed'");
    		tokenNameToValue.put("PaleGreen", "'PaleGreen'");
    		tokenNameToValue.put("PeachPuff", "'PeachPuff'");
    		tokenNameToValue.put("RosyBrown", "'RosyBrown'");
    		tokenNameToValue.put("RoyalBlue", "'RoyalBlue'");
    		tokenNameToValue.put("SlateBlue", "'SlateBlue'");
    		tokenNameToValue.put("SlateGray", "'SlateGray'");
    		tokenNameToValue.put("SlateGrey", "'SlateGrey'");
    		tokenNameToValue.put("SteelBlue", "'SteelBlue'");
    		tokenNameToValue.put("Turquoise", "'Turquoise'");
    		tokenNameToValue.put("Endlegend", "'endlegend'");
    		tokenNameToValue.put("Aquamarine", "'Aquamarine'");
    		tokenNameToValue.put("BlueViolet", "'BlueViolet'");
    		tokenNameToValue.put("Chartreuse", "'Chartreuse'");
    		tokenNameToValue.put("DarkOrchid", "'DarkOrchid'");
    		tokenNameToValue.put("DarkViolet", "'DarkViolet'");
    		tokenNameToValue.put("Darkorange", "'Darkorange'");
    		tokenNameToValue.put("DodgerBlue", "'DodgerBlue'");
    		tokenNameToValue.put("GhostWhite", "'GhostWhite'");
    		tokenNameToValue.put("LightCoral", "'LightCoral'");
    		tokenNameToValue.put("LightGreen", "'LightGreen'");
    		tokenNameToValue.put("MediumBlue", "'MediumBlue'");
    		tokenNameToValue.put("PapayaWhip", "'PapayaWhip'");
    		tokenNameToValue.put("PowderBlue", "'PowderBlue'");
    		tokenNameToValue.put("SandyBrown", "'SandyBrown'");
    		tokenNameToValue.put("WhiteSmoke", "'WhiteSmoke'");
    		tokenNameToValue.put("Autonumber", "'autonumber'");
    		tokenNameToValue.put("Deactivate", "'deactivate'");
    		tokenNameToValue.put("DarkMagenta", "'DarkMagenta'");
    		tokenNameToValue.put("DeepSkyBlue", "'DeepSkyBlue'");
    		tokenNameToValue.put("FloralWhite", "'FloralWhite'");
    		tokenNameToValue.put("ForestGreen", "'ForestGreen'");
    		tokenNameToValue.put("GreenYellow", "'GreenYellow'");
    		tokenNameToValue.put("LightSalmon", "'LightSalmon'");
    		tokenNameToValue.put("LightYellow", "'LightYellow'");
    		tokenNameToValue.put("NavajoWhite", "'NavajoWhite'");
    		tokenNameToValue.put("SaddleBrown", "'SaddleBrown'");
    		tokenNameToValue.put("SpringGreen", "'SpringGreen'");
    		tokenNameToValue.put("YellowGreen", "'YellowGreen'");
    		tokenNameToValue.put("Participant", "'participant'");
    		tokenNameToValue.put("AntiqueWhite", "'AntiqueWhite'");
    		tokenNameToValue.put("DarkSeaGreen", "'DarkSeaGreen'");
    		tokenNameToValue.put("LemonChiffon", "'LemonChiffon'");
    		tokenNameToValue.put("LightSkyBlue", "'LightSkyBlue'");
    		tokenNameToValue.put("MediumOrchid", "'MediumOrchid'");
    		tokenNameToValue.put("MediumPurple", "'MediumPurple'");
    		tokenNameToValue.put("MidnightBlue", "'MidnightBlue'");
    		tokenNameToValue.put("DarkGoldenRod", "'DarkGoldenRod'");
    		tokenNameToValue.put("DarkSlateBlue", "'DarkSlateBlue'");
    		tokenNameToValue.put("DarkSlateGray", "'DarkSlateGray'");
    		tokenNameToValue.put("DarkSlateGrey", "'DarkSlateGrey'");
    		tokenNameToValue.put("DarkTurquoise", "'DarkTurquoise'");
    		tokenNameToValue.put("LavenderBlush", "'LavenderBlush'");
    		tokenNameToValue.put("LightSeaGreen", "'LightSeaGreen'");
    		tokenNameToValue.put("PaleGoldenRod", "'PaleGoldenRod'");
    		tokenNameToValue.put("PaleTurquoise", "'PaleTurquoise'");
    		tokenNameToValue.put("PaleVioletRed", "'PaleVioletRed'");
    		tokenNameToValue.put("BlanchedAlmond", "'BlanchedAlmond'");
    		tokenNameToValue.put("CornflowerBlue", "'CornflowerBlue'");
    		tokenNameToValue.put("DarkOliveGreen", "'DarkOliveGreen'");
    		tokenNameToValue.put("LightSlateGray", "'LightSlateGray'");
    		tokenNameToValue.put("LightSlateGrey", "'LightSlateGrey'");
    		tokenNameToValue.put("LightSteelBlue", "'LightSteelBlue'");
    		tokenNameToValue.put("MediumSeaGreen", "'MediumSeaGreen'");
    		tokenNameToValue.put("MediumSlateBlue", "'MediumSlateBlue'");
    		tokenNameToValue.put("MediumTurquoise", "'MediumTurquoise'");
    		tokenNameToValue.put("MediumVioletRed", "'MediumVioletRed'");
    		tokenNameToValue.put("MediumAquaMarine", "'MediumAquaMarine'");
    		tokenNameToValue.put("MediumSpringGreen", "'MediumSpringGreen'");
    		tokenNameToValue.put("LightGoldenRodYellow", "'LightGoldenRodYellow'");
     	}
     	
        public void setGrammarAccess(PlantumlGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }

    	@Override
        protected String getValueForTokenName(String tokenName) {
        	String result = tokenNameToValue.get(tokenName);
        	if (result == null)
        		result = tokenName;
        	return result;
        }



    // $ANTLR start "entryRulePlantuml"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:254:1: entryRulePlantuml : rulePlantuml EOF ;
    public final void entryRulePlantuml() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:255:1: ( rulePlantuml EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:256:1: rulePlantuml EOF
            {
             before(grammarAccess.getPlantumlRule()); 
            pushFollow(FOLLOW_rulePlantuml_in_entryRulePlantuml54);
            rulePlantuml();

            state._fsp--;

             after(grammarAccess.getPlantumlRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePlantuml61); 

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
    // $ANTLR end "entryRulePlantuml"


    // $ANTLR start "rulePlantuml"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:263:1: rulePlantuml : ( ( rule__Plantuml__DiagramsAssignment )* ) ;
    public final void rulePlantuml() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:267:5: ( ( ( rule__Plantuml__DiagramsAssignment )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:268:1: ( ( rule__Plantuml__DiagramsAssignment )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:268:1: ( ( rule__Plantuml__DiagramsAssignment )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:269:1: ( rule__Plantuml__DiagramsAssignment )*
            {
             before(grammarAccess.getPlantumlAccess().getDiagramsAssignment()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:270:1: ( rule__Plantuml__DiagramsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_START) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:270:2: rule__Plantuml__DiagramsAssignment
            	    {
            	    pushFollow(FOLLOW_rule__Plantuml__DiagramsAssignment_in_rulePlantuml91);
            	    rule__Plantuml__DiagramsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getPlantumlAccess().getDiagramsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePlantuml"


    // $ANTLR start "entryRuleDiagram"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:282:1: entryRuleDiagram : ruleDiagram EOF ;
    public final void entryRuleDiagram() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:283:1: ( ruleDiagram EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:284:1: ruleDiagram EOF
            {
             before(grammarAccess.getDiagramRule()); 
            pushFollow(FOLLOW_ruleDiagram_in_entryRuleDiagram119);
            ruleDiagram();

            state._fsp--;

             after(grammarAccess.getDiagramRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDiagram126); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:291:1: ruleDiagram : ( ( rule__Diagram__Group__0 ) ) ;
    public final void ruleDiagram() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:295:5: ( ( ( rule__Diagram__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:296:1: ( ( rule__Diagram__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:296:1: ( ( rule__Diagram__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:297:1: ( rule__Diagram__Group__0 )
            {
             before(grammarAccess.getDiagramAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:298:1: ( rule__Diagram__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:298:2: rule__Diagram__Group__0
            {
            pushFollow(FOLLOW_rule__Diagram__Group__0_in_ruleDiagram156);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:310:1: entryRuleInstruction : ruleInstruction EOF ;
    public final void entryRuleInstruction() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:311:1: ( ruleInstruction EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:312:1: ruleInstruction EOF
            {
             before(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction183);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getInstructionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction190); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:319:1: ruleInstruction : ( ( rule__Instruction__Group__0 ) ) ;
    public final void ruleInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:323:5: ( ( ( rule__Instruction__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:324:1: ( ( rule__Instruction__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:324:1: ( ( rule__Instruction__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:325:1: ( rule__Instruction__Group__0 )
            {
             before(grammarAccess.getInstructionAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:326:1: ( rule__Instruction__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:326:2: rule__Instruction__Group__0
            {
            pushFollow(FOLLOW_rule__Instruction__Group__0_in_ruleInstruction220);
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


    // $ANTLR start "entryRuleArrow"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:338:1: entryRuleArrow : ruleArrow EOF ;
    public final void entryRuleArrow() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:339:1: ( ruleArrow EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:340:1: ruleArrow EOF
            {
             before(grammarAccess.getArrowRule()); 
            pushFollow(FOLLOW_ruleArrow_in_entryRuleArrow247);
            ruleArrow();

            state._fsp--;

             after(grammarAccess.getArrowRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrow254); 

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
    // $ANTLR end "entryRuleArrow"


    // $ANTLR start "ruleArrow"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:347:1: ruleArrow : ( ( rule__Arrow__Group__0 ) ) ;
    public final void ruleArrow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:351:5: ( ( ( rule__Arrow__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:352:1: ( ( rule__Arrow__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:352:1: ( ( rule__Arrow__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:353:1: ( rule__Arrow__Group__0 )
            {
             before(grammarAccess.getArrowAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:354:1: ( rule__Arrow__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:354:2: rule__Arrow__Group__0
            {
            pushFollow(FOLLOW_rule__Arrow__Group__0_in_ruleArrow284);
            rule__Arrow__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArrow"


    // $ANTLR start "entryRuleDefinition"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:366:1: entryRuleDefinition : ruleDefinition EOF ;
    public final void entryRuleDefinition() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:367:1: ( ruleDefinition EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:368:1: ruleDefinition EOF
            {
             before(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition311);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition318); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:375:1: ruleDefinition : ( ( rule__Definition__Alternatives ) ) ;
    public final void ruleDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:379:5: ( ( ( rule__Definition__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:380:1: ( ( rule__Definition__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:380:1: ( ( rule__Definition__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:381:1: ( rule__Definition__Alternatives )
            {
             before(grammarAccess.getDefinitionAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:382:1: ( rule__Definition__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:382:2: rule__Definition__Alternatives
            {
            pushFollow(FOLLOW_rule__Definition__Alternatives_in_ruleDefinition348);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:394:1: entryRuleAutoNumber : ruleAutoNumber EOF ;
    public final void entryRuleAutoNumber() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:395:1: ( ruleAutoNumber EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:396:1: ruleAutoNumber EOF
            {
             before(grammarAccess.getAutoNumberRule()); 
            pushFollow(FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber375);
            ruleAutoNumber();

            state._fsp--;

             after(grammarAccess.getAutoNumberRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAutoNumber382); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:403:1: ruleAutoNumber : ( ( rule__AutoNumber__Group__0 ) ) ;
    public final void ruleAutoNumber() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:407:5: ( ( ( rule__AutoNumber__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:408:1: ( ( rule__AutoNumber__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:408:1: ( ( rule__AutoNumber__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:409:1: ( rule__AutoNumber__Group__0 )
            {
             before(grammarAccess.getAutoNumberAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:410:1: ( rule__AutoNumber__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:410:2: rule__AutoNumber__Group__0
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0_in_ruleAutoNumber412);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:422:1: entryRuleColor : ruleColor EOF ;
    public final void entryRuleColor() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:423:1: ( ruleColor EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:424:1: ruleColor EOF
            {
             before(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor439);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getColorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor446); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:431:1: ruleColor : ( ( rule__Color__Group__0 ) ) ;
    public final void ruleColor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:435:5: ( ( ( rule__Color__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:436:1: ( ( rule__Color__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:436:1: ( ( rule__Color__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:437:1: ( rule__Color__Group__0 )
            {
             before(grammarAccess.getColorAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:438:1: ( rule__Color__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:438:2: rule__Color__Group__0
            {
            pushFollow(FOLLOW_rule__Color__Group__0_in_ruleColor476);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:450:1: entryRuleTitle : ruleTitle EOF ;
    public final void entryRuleTitle() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:451:1: ( ruleTitle EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:452:1: ruleTitle EOF
            {
             before(grammarAccess.getTitleRule()); 
            pushFollow(FOLLOW_ruleTitle_in_entryRuleTitle503);
            ruleTitle();

            state._fsp--;

             after(grammarAccess.getTitleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTitle510); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:459:1: ruleTitle : ( ( rule__Title__Group__0 ) ) ;
    public final void ruleTitle() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:463:5: ( ( ( rule__Title__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:464:1: ( ( rule__Title__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:464:1: ( ( rule__Title__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:465:1: ( rule__Title__Group__0 )
            {
             before(grammarAccess.getTitleAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:466:1: ( rule__Title__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:466:2: rule__Title__Group__0
            {
            pushFollow(FOLLOW_rule__Title__Group__0_in_ruleTitle540);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:478:1: entryRuleLegend : ruleLegend EOF ;
    public final void entryRuleLegend() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:479:1: ( ruleLegend EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:480:1: ruleLegend EOF
            {
             before(grammarAccess.getLegendRule()); 
            pushFollow(FOLLOW_ruleLegend_in_entryRuleLegend567);
            ruleLegend();

            state._fsp--;

             after(grammarAccess.getLegendRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLegend574); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:487:1: ruleLegend : ( ( rule__Legend__Group__0 ) ) ;
    public final void ruleLegend() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:491:5: ( ( ( rule__Legend__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:492:1: ( ( rule__Legend__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:492:1: ( ( rule__Legend__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:493:1: ( rule__Legend__Group__0 )
            {
             before(grammarAccess.getLegendAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:494:1: ( rule__Legend__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:494:2: rule__Legend__Group__0
            {
            pushFollow(FOLLOW_rule__Legend__Group__0_in_ruleLegend604);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:506:1: entryRuleNewpage : ruleNewpage EOF ;
    public final void entryRuleNewpage() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:507:1: ( ruleNewpage EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:508:1: ruleNewpage EOF
            {
             before(grammarAccess.getNewpageRule()); 
            pushFollow(FOLLOW_ruleNewpage_in_entryRuleNewpage631);
            ruleNewpage();

            state._fsp--;

             after(grammarAccess.getNewpageRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNewpage638); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:515:1: ruleNewpage : ( ( rule__Newpage__Group__0 ) ) ;
    public final void ruleNewpage() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:519:5: ( ( ( rule__Newpage__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:520:1: ( ( rule__Newpage__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:520:1: ( ( rule__Newpage__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:521:1: ( rule__Newpage__Group__0 )
            {
             before(grammarAccess.getNewpageAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:522:1: ( rule__Newpage__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:522:2: rule__Newpage__Group__0
            {
            pushFollow(FOLLOW_rule__Newpage__Group__0_in_ruleNewpage668);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:534:1: entryRuleAltElse : ruleAltElse EOF ;
    public final void entryRuleAltElse() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:535:1: ( ruleAltElse EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:536:1: ruleAltElse EOF
            {
             before(grammarAccess.getAltElseRule()); 
            pushFollow(FOLLOW_ruleAltElse_in_entryRuleAltElse695);
            ruleAltElse();

            state._fsp--;

             after(grammarAccess.getAltElseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltElse702); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:543:1: ruleAltElse : ( ( rule__AltElse__Group__0 ) ) ;
    public final void ruleAltElse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:547:5: ( ( ( rule__AltElse__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:548:1: ( ( rule__AltElse__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:548:1: ( ( rule__AltElse__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:549:1: ( rule__AltElse__Group__0 )
            {
             before(grammarAccess.getAltElseAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:550:1: ( rule__AltElse__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:550:2: rule__AltElse__Group__0
            {
            pushFollow(FOLLOW_rule__AltElse__Group__0_in_ruleAltElse732);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:562:1: entryRuleElse : ruleElse EOF ;
    public final void entryRuleElse() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:563:1: ( ruleElse EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:564:1: ruleElse EOF
            {
             before(grammarAccess.getElseRule()); 
            pushFollow(FOLLOW_ruleElse_in_entryRuleElse759);
            ruleElse();

            state._fsp--;

             after(grammarAccess.getElseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElse766); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:571:1: ruleElse : ( ( rule__Else__Group__0 ) ) ;
    public final void ruleElse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:575:5: ( ( ( rule__Else__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:576:1: ( ( rule__Else__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:576:1: ( ( rule__Else__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:577:1: ( rule__Else__Group__0 )
            {
             before(grammarAccess.getElseAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:578:1: ( rule__Else__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:578:2: rule__Else__Group__0
            {
            pushFollow(FOLLOW_rule__Else__Group__0_in_ruleElse796);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:590:1: entryRuleGroupingMessages : ruleGroupingMessages EOF ;
    public final void entryRuleGroupingMessages() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:591:1: ( ruleGroupingMessages EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:592:1: ruleGroupingMessages EOF
            {
             before(grammarAccess.getGroupingMessagesRule()); 
            pushFollow(FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages823);
            ruleGroupingMessages();

            state._fsp--;

             after(grammarAccess.getGroupingMessagesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroupingMessages830); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:599:1: ruleGroupingMessages : ( ( rule__GroupingMessages__Group__0 ) ) ;
    public final void ruleGroupingMessages() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:603:5: ( ( ( rule__GroupingMessages__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:604:1: ( ( rule__GroupingMessages__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:604:1: ( ( rule__GroupingMessages__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:605:1: ( rule__GroupingMessages__Group__0 )
            {
             before(grammarAccess.getGroupingMessagesAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:606:1: ( rule__GroupingMessages__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:606:2: rule__GroupingMessages__Group__0
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__0_in_ruleGroupingMessages860);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:618:1: entryRuleNote : ruleNote EOF ;
    public final void entryRuleNote() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:619:1: ( ruleNote EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:620:1: ruleNote EOF
            {
             before(grammarAccess.getNoteRule()); 
            pushFollow(FOLLOW_ruleNote_in_entryRuleNote887);
            ruleNote();

            state._fsp--;

             after(grammarAccess.getNoteRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNote894); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:627:1: ruleNote : ( ( rule__Note__Group__0 ) ) ;
    public final void ruleNote() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:631:5: ( ( ( rule__Note__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:632:1: ( ( rule__Note__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:632:1: ( ( rule__Note__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:633:1: ( rule__Note__Group__0 )
            {
             before(grammarAccess.getNoteAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:634:1: ( rule__Note__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:634:2: rule__Note__Group__0
            {
            pushFollow(FOLLOW_rule__Note__Group__0_in_ruleNote924);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:646:1: entryRuleDivider : ruleDivider EOF ;
    public final void entryRuleDivider() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:647:1: ( ruleDivider EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:648:1: ruleDivider EOF
            {
             before(grammarAccess.getDividerRule()); 
            pushFollow(FOLLOW_ruleDivider_in_entryRuleDivider951);
            ruleDivider();

            state._fsp--;

             after(grammarAccess.getDividerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDivider958); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:655:1: ruleDivider : ( ( rule__Divider__Group__0 ) ) ;
    public final void ruleDivider() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:659:5: ( ( ( rule__Divider__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:660:1: ( ( rule__Divider__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:660:1: ( ( rule__Divider__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:661:1: ( rule__Divider__Group__0 )
            {
             before(grammarAccess.getDividerAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:662:1: ( rule__Divider__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:662:2: rule__Divider__Group__0
            {
            pushFollow(FOLLOW_rule__Divider__Group__0_in_ruleDivider988);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:674:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:675:1: ( ruleReference EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:676:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference1015);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference1022); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:683:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:687:5: ( ( ( rule__Reference__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:688:1: ( ( rule__Reference__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:688:1: ( ( rule__Reference__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:689:1: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:690:1: ( rule__Reference__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:690:2: rule__Reference__Group__0
            {
            pushFollow(FOLLOW_rule__Reference__Group__0_in_ruleReference1052);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:702:1: entryRuleDelay : ruleDelay EOF ;
    public final void entryRuleDelay() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:703:1: ( ruleDelay EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:704:1: ruleDelay EOF
            {
             before(grammarAccess.getDelayRule()); 
            pushFollow(FOLLOW_ruleDelay_in_entryRuleDelay1079);
            ruleDelay();

            state._fsp--;

             after(grammarAccess.getDelayRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDelay1086); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:711:1: ruleDelay : ( ( rule__Delay__Group__0 ) ) ;
    public final void ruleDelay() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:715:5: ( ( ( rule__Delay__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:716:1: ( ( rule__Delay__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:716:1: ( ( rule__Delay__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:717:1: ( rule__Delay__Group__0 )
            {
             before(grammarAccess.getDelayAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:718:1: ( rule__Delay__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:718:2: rule__Delay__Group__0
            {
            pushFollow(FOLLOW_rule__Delay__Group__0_in_ruleDelay1116);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:730:1: entryRuleSpace : ruleSpace EOF ;
    public final void entryRuleSpace() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:731:1: ( ruleSpace EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:732:1: ruleSpace EOF
            {
             before(grammarAccess.getSpaceRule()); 
            pushFollow(FOLLOW_ruleSpace_in_entryRuleSpace1143);
            ruleSpace();

            state._fsp--;

             after(grammarAccess.getSpaceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpace1150); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:739:1: ruleSpace : ( ( rule__Space__Alternatives ) ) ;
    public final void ruleSpace() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:743:5: ( ( ( rule__Space__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:744:1: ( ( rule__Space__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:744:1: ( ( rule__Space__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:745:1: ( rule__Space__Alternatives )
            {
             before(grammarAccess.getSpaceAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:746:1: ( rule__Space__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:746:2: rule__Space__Alternatives
            {
            pushFollow(FOLLOW_rule__Space__Alternatives_in_ruleSpace1180);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:758:1: entryRuleHidefootbox : ruleHidefootbox EOF ;
    public final void entryRuleHidefootbox() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:759:1: ( ruleHidefootbox EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:760:1: ruleHidefootbox EOF
            {
             before(grammarAccess.getHidefootboxRule()); 
            pushFollow(FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox1207);
            ruleHidefootbox();

            state._fsp--;

             after(grammarAccess.getHidefootboxRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHidefootbox1214); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:767:1: ruleHidefootbox : ( ( rule__Hidefootbox__Group__0 ) ) ;
    public final void ruleHidefootbox() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:771:5: ( ( ( rule__Hidefootbox__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:772:1: ( ( rule__Hidefootbox__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:772:1: ( ( rule__Hidefootbox__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:773:1: ( rule__Hidefootbox__Group__0 )
            {
             before(grammarAccess.getHidefootboxAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:774:1: ( rule__Hidefootbox__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:774:2: rule__Hidefootbox__Group__0
            {
            pushFollow(FOLLOW_rule__Hidefootbox__Group__0_in_ruleHidefootbox1244);
            rule__Hidefootbox__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHidefootboxAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleActivate"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:786:1: entryRuleActivate : ruleActivate EOF ;
    public final void entryRuleActivate() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:787:1: ( ruleActivate EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:788:1: ruleActivate EOF
            {
             before(grammarAccess.getActivateRule()); 
            pushFollow(FOLLOW_ruleActivate_in_entryRuleActivate1271);
            ruleActivate();

            state._fsp--;

             after(grammarAccess.getActivateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActivate1278); 

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
    // $ANTLR end "entryRuleActivate"


    // $ANTLR start "ruleActivate"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:795:1: ruleActivate : ( ( rule__Activate__Group__0 ) ) ;
    public final void ruleActivate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:799:5: ( ( ( rule__Activate__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:800:1: ( ( rule__Activate__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:800:1: ( ( rule__Activate__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:801:1: ( rule__Activate__Group__0 )
            {
             before(grammarAccess.getActivateAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:802:1: ( rule__Activate__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:802:2: rule__Activate__Group__0
            {
            pushFollow(FOLLOW_rule__Activate__Group__0_in_ruleActivate1308);
            rule__Activate__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActivateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleActivate"


    // $ANTLR start "entryRuleDeactivate"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:814:1: entryRuleDeactivate : ruleDeactivate EOF ;
    public final void entryRuleDeactivate() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:815:1: ( ruleDeactivate EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:816:1: ruleDeactivate EOF
            {
             before(grammarAccess.getDeactivateRule()); 
            pushFollow(FOLLOW_ruleDeactivate_in_entryRuleDeactivate1335);
            ruleDeactivate();

            state._fsp--;

             after(grammarAccess.getDeactivateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeactivate1342); 

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
    // $ANTLR end "entryRuleDeactivate"


    // $ANTLR start "ruleDeactivate"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:823:1: ruleDeactivate : ( ( rule__Deactivate__Group__0 ) ) ;
    public final void ruleDeactivate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:827:5: ( ( ( rule__Deactivate__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:828:1: ( ( rule__Deactivate__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:828:1: ( ( rule__Deactivate__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:829:1: ( rule__Deactivate__Group__0 )
            {
             before(grammarAccess.getDeactivateAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:830:1: ( rule__Deactivate__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:830:2: rule__Deactivate__Group__0
            {
            pushFollow(FOLLOW_rule__Deactivate__Group__0_in_ruleDeactivate1372);
            rule__Deactivate__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDeactivateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeactivate"


    // $ANTLR start "entryRuleParticipantCreation"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:842:1: entryRuleParticipantCreation : ruleParticipantCreation EOF ;
    public final void entryRuleParticipantCreation() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:843:1: ( ruleParticipantCreation EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:844:1: ruleParticipantCreation EOF
            {
             before(grammarAccess.getParticipantCreationRule()); 
            pushFollow(FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation1399);
            ruleParticipantCreation();

            state._fsp--;

             after(grammarAccess.getParticipantCreationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParticipantCreation1406); 

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
    // $ANTLR end "entryRuleParticipantCreation"


    // $ANTLR start "ruleParticipantCreation"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:851:1: ruleParticipantCreation : ( ( rule__ParticipantCreation__Group__0 ) ) ;
    public final void ruleParticipantCreation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:855:5: ( ( ( rule__ParticipantCreation__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:856:1: ( ( rule__ParticipantCreation__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:856:1: ( ( rule__ParticipantCreation__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:857:1: ( rule__ParticipantCreation__Group__0 )
            {
             before(grammarAccess.getParticipantCreationAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:858:1: ( rule__ParticipantCreation__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:858:2: rule__ParticipantCreation__Group__0
            {
            pushFollow(FOLLOW_rule__ParticipantCreation__Group__0_in_ruleParticipantCreation1436);
            rule__ParticipantCreation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParticipantCreationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParticipantCreation"


    // $ANTLR start "entryRuleBox"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:870:1: entryRuleBox : ruleBox EOF ;
    public final void entryRuleBox() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:871:1: ( ruleBox EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:872:1: ruleBox EOF
            {
             before(grammarAccess.getBoxRule()); 
            pushFollow(FOLLOW_ruleBox_in_entryRuleBox1463);
            ruleBox();

            state._fsp--;

             after(grammarAccess.getBoxRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBox1470); 

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
    // $ANTLR end "entryRuleBox"


    // $ANTLR start "ruleBox"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:879:1: ruleBox : ( ( rule__Box__Group__0 ) ) ;
    public final void ruleBox() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:883:5: ( ( ( rule__Box__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:884:1: ( ( rule__Box__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:884:1: ( ( rule__Box__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:885:1: ( rule__Box__Group__0 )
            {
             before(grammarAccess.getBoxAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:886:1: ( rule__Box__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:886:2: rule__Box__Group__0
            {
            pushFollow(FOLLOW_rule__Box__Group__0_in_ruleBox1500);
            rule__Box__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBoxAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBox"


    // $ANTLR start "rule__Instruction__Alternatives_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:898:1: rule__Instruction__Alternatives_0 : ( ( ruleArrow ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) | ( ruleAltElse ) | ( ruleGroupingMessages ) | ( ruleNote ) | ( ruleDivider ) | ( ruleReference ) | ( ruleDelay ) | ( ruleSpace ) | ( ruleHidefootbox ) | ( ruleActivate ) | ( ruleDeactivate ) | ( ruleParticipantCreation ) | ( ruleBox ) );
    public final void rule__Instruction__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:902:1: ( ( ruleArrow ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) | ( ruleAltElse ) | ( ruleGroupingMessages ) | ( ruleNote ) | ( ruleDivider ) | ( ruleReference ) | ( ruleDelay ) | ( ruleSpace ) | ( ruleHidefootbox ) | ( ruleActivate ) | ( ruleDeactivate ) | ( ruleParticipantCreation ) | ( ruleBox ) )
            int alt2=18;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt2=1;
                }
                break;
            case Participant:
            case Boundary:
            case Database:
            case Control:
            case Entity:
            case Actor:
                {
                alt2=2;
                }
                break;
            case Autonumber:
                {
                alt2=3;
                }
                break;
            case Title:
                {
                alt2=4;
                }
                break;
            case Legend:
                {
                alt2=5;
                }
                break;
            case Newpage:
                {
                alt2=6;
                }
                break;
            case Alt:
                {
                alt2=7;
                }
                break;
            case Critical:
            case Break:
            case Group:
            case Loop:
            case Opt:
            case Par:
                {
                alt2=8;
                }
                break;
            case Note:
                {
                alt2=9;
                }
                break;
            case EqualsSignEqualsSign:
                {
                alt2=10;
                }
                break;
            case Ref:
                {
                alt2=11;
                }
                break;
            case FullStopFullStopFullStop:
                {
                alt2=12;
                }
                break;
            case VerticalLineVerticalLineVerticalLine:
            case VerticalLineVerticalLine:
                {
                alt2=13;
                }
                break;
            case Hide:
                {
                alt2=14;
                }
                break;
            case Activate:
                {
                alt2=15;
                }
                break;
            case Deactivate:
            case Destroy:
                {
                alt2=16;
                }
                break;
            case Create:
                {
                alt2=17;
                }
                break;
            case Box:
                {
                alt2=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:903:1: ( ruleArrow )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:903:1: ( ruleArrow )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:904:1: ruleArrow
                    {
                     before(grammarAccess.getInstructionAccess().getArrowParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_ruleArrow_in_rule__Instruction__Alternatives_01536);
                    ruleArrow();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getArrowParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:909:6: ( ( rule__Instruction__Group_0_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:909:6: ( ( rule__Instruction__Group_0_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:910:1: ( rule__Instruction__Group_0_1__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_0_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:911:1: ( rule__Instruction__Group_0_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:911:2: rule__Instruction__Group_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_1__0_in_rule__Instruction__Alternatives_01553);
                    rule__Instruction__Group_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:915:6: ( ruleAutoNumber )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:915:6: ( ruleAutoNumber )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:916:1: ruleAutoNumber
                    {
                     before(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 
                    pushFollow(FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives_01571);
                    ruleAutoNumber();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:921:6: ( ruleTitle )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:921:6: ( ruleTitle )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:922:1: ruleTitle
                    {
                     before(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 
                    pushFollow(FOLLOW_ruleTitle_in_rule__Instruction__Alternatives_01588);
                    ruleTitle();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:927:6: ( ruleLegend )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:927:6: ( ruleLegend )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:928:1: ruleLegend
                    {
                     before(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 
                    pushFollow(FOLLOW_ruleLegend_in_rule__Instruction__Alternatives_01605);
                    ruleLegend();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:933:6: ( ruleNewpage )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:933:6: ( ruleNewpage )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:934:1: ruleNewpage
                    {
                     before(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 
                    pushFollow(FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives_01622);
                    ruleNewpage();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:939:6: ( ruleAltElse )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:939:6: ( ruleAltElse )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:940:1: ruleAltElse
                    {
                     before(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 
                    pushFollow(FOLLOW_ruleAltElse_in_rule__Instruction__Alternatives_01639);
                    ruleAltElse();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:945:6: ( ruleGroupingMessages )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:945:6: ( ruleGroupingMessages )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:946:1: ruleGroupingMessages
                    {
                     before(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 
                    pushFollow(FOLLOW_ruleGroupingMessages_in_rule__Instruction__Alternatives_01656);
                    ruleGroupingMessages();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:951:6: ( ruleNote )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:951:6: ( ruleNote )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:952:1: ruleNote
                    {
                     before(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 
                    pushFollow(FOLLOW_ruleNote_in_rule__Instruction__Alternatives_01673);
                    ruleNote();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:957:6: ( ruleDivider )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:957:6: ( ruleDivider )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:958:1: ruleDivider
                    {
                     before(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 
                    pushFollow(FOLLOW_ruleDivider_in_rule__Instruction__Alternatives_01690);
                    ruleDivider();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:963:6: ( ruleReference )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:963:6: ( ruleReference )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:964:1: ruleReference
                    {
                     before(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 
                    pushFollow(FOLLOW_ruleReference_in_rule__Instruction__Alternatives_01707);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:969:6: ( ruleDelay )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:969:6: ( ruleDelay )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:970:1: ruleDelay
                    {
                     before(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 
                    pushFollow(FOLLOW_ruleDelay_in_rule__Instruction__Alternatives_01724);
                    ruleDelay();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:975:6: ( ruleSpace )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:975:6: ( ruleSpace )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:976:1: ruleSpace
                    {
                     before(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 
                    pushFollow(FOLLOW_ruleSpace_in_rule__Instruction__Alternatives_01741);
                    ruleSpace();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:981:6: ( ruleHidefootbox )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:981:6: ( ruleHidefootbox )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:982:1: ruleHidefootbox
                    {
                     before(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 
                    pushFollow(FOLLOW_ruleHidefootbox_in_rule__Instruction__Alternatives_01758);
                    ruleHidefootbox();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:987:6: ( ruleActivate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:987:6: ( ruleActivate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:988:1: ruleActivate
                    {
                     before(grammarAccess.getInstructionAccess().getActivateParserRuleCall_0_14()); 
                    pushFollow(FOLLOW_ruleActivate_in_rule__Instruction__Alternatives_01775);
                    ruleActivate();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getActivateParserRuleCall_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:993:6: ( ruleDeactivate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:993:6: ( ruleDeactivate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:994:1: ruleDeactivate
                    {
                     before(grammarAccess.getInstructionAccess().getDeactivateParserRuleCall_0_15()); 
                    pushFollow(FOLLOW_ruleDeactivate_in_rule__Instruction__Alternatives_01792);
                    ruleDeactivate();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDeactivateParserRuleCall_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:999:6: ( ruleParticipantCreation )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:999:6: ( ruleParticipantCreation )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1000:1: ruleParticipantCreation
                    {
                     before(grammarAccess.getInstructionAccess().getParticipantCreationParserRuleCall_0_16()); 
                    pushFollow(FOLLOW_ruleParticipantCreation_in_rule__Instruction__Alternatives_01809);
                    ruleParticipantCreation();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getParticipantCreationParserRuleCall_0_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1005:6: ( ruleBox )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1005:6: ( ruleBox )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1006:1: ruleBox
                    {
                     before(grammarAccess.getInstructionAccess().getBoxParserRuleCall_0_17()); 
                    pushFollow(FOLLOW_ruleBox_in_rule__Instruction__Alternatives_01826);
                    ruleBox();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getBoxParserRuleCall_0_17()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1016:1: rule__Definition__Alternatives : ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) | ( ( rule__Definition__Group_5__0 ) ) );
    public final void rule__Definition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1020:1: ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) | ( ( rule__Definition__Group_5__0 ) ) )
            int alt3=6;
            switch ( input.LA(1) ) {
            case Actor:
                {
                alt3=1;
                }
                break;
            case Boundary:
                {
                alt3=2;
                }
                break;
            case Control:
                {
                alt3=3;
                }
                break;
            case Entity:
                {
                alt3=4;
                }
                break;
            case Database:
                {
                alt3=5;
                }
                break;
            case Participant:
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1021:1: ( ( rule__Definition__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1021:1: ( ( rule__Definition__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1022:1: ( rule__Definition__Group_0__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1023:1: ( rule__Definition__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1023:2: rule__Definition__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives1858);
                    rule__Definition__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1027:6: ( ( rule__Definition__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1027:6: ( ( rule__Definition__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1028:1: ( rule__Definition__Group_1__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1029:1: ( rule__Definition__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1029:2: rule__Definition__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1876);
                    rule__Definition__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1033:6: ( ( rule__Definition__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1033:6: ( ( rule__Definition__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1034:1: ( rule__Definition__Group_2__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1035:1: ( rule__Definition__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1035:2: rule__Definition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives1894);
                    rule__Definition__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1039:6: ( ( rule__Definition__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1039:6: ( ( rule__Definition__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1040:1: ( rule__Definition__Group_3__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1041:1: ( rule__Definition__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1041:2: rule__Definition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives1912);
                    rule__Definition__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1045:6: ( ( rule__Definition__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1045:6: ( ( rule__Definition__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1046:1: ( rule__Definition__Group_4__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1047:1: ( rule__Definition__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1047:2: rule__Definition__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1930);
                    rule__Definition__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1051:6: ( ( rule__Definition__Group_5__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1051:6: ( ( rule__Definition__Group_5__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1052:1: ( rule__Definition__Group_5__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_5()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1053:1: ( rule__Definition__Group_5__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1053:2: rule__Definition__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5__0_in_rule__Definition__Alternatives1948);
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


    // $ANTLR start "rule__Definition__Alternatives_5_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1062:1: rule__Definition__Alternatives_5_2_1 : ( ( ( rule__Definition__Group_5_2_1_0__0 ) ) | ( ( rule__Definition__Group_5_2_1_1__0 ) ) | ( RULE_ID ) );
    public final void rule__Definition__Alternatives_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1066:1: ( ( ( rule__Definition__Group_5_2_1_0__0 ) ) | ( ( rule__Definition__Group_5_2_1_1__0 ) ) | ( RULE_ID ) )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1067:1: ( ( rule__Definition__Group_5_2_1_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1067:1: ( ( rule__Definition__Group_5_2_1_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1068:1: ( rule__Definition__Group_5_2_1_0__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_5_2_1_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1069:1: ( rule__Definition__Group_5_2_1_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1069:2: rule__Definition__Group_5_2_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__0_in_rule__Definition__Alternatives_5_2_11981);
                    rule__Definition__Group_5_2_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_5_2_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1073:6: ( ( rule__Definition__Group_5_2_1_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1073:6: ( ( rule__Definition__Group_5_2_1_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1074:1: ( rule__Definition__Group_5_2_1_1__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_5_2_1_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1075:1: ( rule__Definition__Group_5_2_1_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1075:2: rule__Definition__Group_5_2_1_1__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__0_in_rule__Definition__Alternatives_5_2_11999);
                    rule__Definition__Group_5_2_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_5_2_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1079:6: ( RULE_ID )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1079:6: ( RULE_ID )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1080:1: RULE_ID
                    {
                     before(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_2()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__Alternatives_5_2_12017); 
                     after(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_2()); 

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
    // $ANTLR end "rule__Definition__Alternatives_5_2_1"


    // $ANTLR start "rule__Color__Alternatives_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1090:1: rule__Color__Alternatives_1 : ( ( AliceBlue ) | ( AntiqueWhite ) | ( Aqua ) | ( Aquamarine ) | ( Azure ) | ( Beige ) | ( Bisque ) | ( Black ) | ( BlanchedAlmond ) | ( Blue ) | ( BlueViolet ) | ( Brown ) | ( BurlyWood ) | ( CadetBlue ) | ( Chartreuse ) | ( Chocolate ) | ( Coral ) | ( CornflowerBlue ) | ( Cornsilk ) | ( Crimson ) | ( Cyan ) | ( DarkBlue ) | ( DarkCyan ) | ( DarkGoldenRod ) | ( DarkGray ) | ( DarkGreen ) | ( DarkGrey ) | ( DarkKhaki ) | ( DarkMagenta ) | ( DarkOliveGreen ) | ( DarkOrchid ) | ( DarkRed ) | ( DarkSalmo ) | ( DarkSeaGreen ) | ( DarkSlateBlue ) | ( DarkSlateGray ) | ( DarkSlateGrey ) | ( DarkTurquoise ) | ( DarkViolet ) | ( Darkorange ) | ( DeepPink ) | ( DeepSkyBlue ) | ( DimGray ) | ( DimGrey ) | ( DodgerBlue ) | ( FireBrick ) | ( FloralWhite ) | ( ForestGreen ) | ( Fuchsia ) | ( Gainsboro ) | ( GhostWhite ) | ( Gold ) | ( GoldenRod ) | ( Gray ) | ( Green ) | ( GreenYellow ) | ( Grey ) | ( HoneyDew ) | ( HotPink ) | ( IndianRed ) | ( Indigo ) | ( Ivory ) | ( Khaki ) | ( Lavender ) | ( LavenderBlush ) | ( LawnGreen ) | ( LemonChiffon ) | ( LightBlue ) | ( LightCoral ) | ( LightCyan ) | ( LightGoldenRodYellow ) | ( LightGray ) | ( LightGreen ) | ( LightGrey ) | ( LightPink ) | ( LightSalmon ) | ( LightSeaGreen ) | ( LightSkyBlue ) | ( LightSlateGray ) | ( LightSlateGrey ) | ( LightSteelBlue ) | ( LightYellow ) | ( Lime ) | ( LimeGreen ) | ( Linen ) | ( Magenta ) | ( Maroon ) | ( MediumAquaMarine ) | ( MediumBlue ) | ( MediumOrchid ) | ( MediumPurple ) | ( MediumSeaGreen ) | ( MediumSlateBlue ) | ( MediumSpringGreen ) | ( MediumTurquoise ) | ( MediumVioletRed ) | ( MidnightBlue ) | ( MintCream ) | ( MistyRose ) | ( Moccasin ) | ( NavajoWhite ) | ( Navy ) | ( OldLace ) | ( Olive ) | ( OliveDrab ) | ( OrangeRed ) | ( Orchid ) | ( PaleGoldenRod ) | ( PaleGreen ) | ( PaleTurquoise ) | ( PaleVioletRed ) | ( PapayaWhip ) | ( PeachPuff ) | ( Peru ) | ( Pink ) | ( Plum ) | ( PowderBlue ) | ( Purple ) | ( Red ) | ( RosyBrown ) | ( RoyalBlue ) | ( SaddleBrown ) | ( Salmon ) | ( SandyBrown ) | ( SeaGreen ) | ( Sienna ) | ( Silver ) | ( SkyBlue ) | ( SlateBlue ) | ( SlateGray ) | ( SlateGrey ) | ( Snow ) | ( SpringGreen ) | ( SteelBlue ) | ( Tan ) | ( Teal ) | ( Thistle ) | ( Tomato ) | ( Turquoise ) | ( Violet ) | ( Wheat ) | ( White ) | ( WhiteSmoke ) | ( Yellow ) | ( YellowGreen ) );
    public final void rule__Color__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1094:1: ( ( AliceBlue ) | ( AntiqueWhite ) | ( Aqua ) | ( Aquamarine ) | ( Azure ) | ( Beige ) | ( Bisque ) | ( Black ) | ( BlanchedAlmond ) | ( Blue ) | ( BlueViolet ) | ( Brown ) | ( BurlyWood ) | ( CadetBlue ) | ( Chartreuse ) | ( Chocolate ) | ( Coral ) | ( CornflowerBlue ) | ( Cornsilk ) | ( Crimson ) | ( Cyan ) | ( DarkBlue ) | ( DarkCyan ) | ( DarkGoldenRod ) | ( DarkGray ) | ( DarkGreen ) | ( DarkGrey ) | ( DarkKhaki ) | ( DarkMagenta ) | ( DarkOliveGreen ) | ( DarkOrchid ) | ( DarkRed ) | ( DarkSalmo ) | ( DarkSeaGreen ) | ( DarkSlateBlue ) | ( DarkSlateGray ) | ( DarkSlateGrey ) | ( DarkTurquoise ) | ( DarkViolet ) | ( Darkorange ) | ( DeepPink ) | ( DeepSkyBlue ) | ( DimGray ) | ( DimGrey ) | ( DodgerBlue ) | ( FireBrick ) | ( FloralWhite ) | ( ForestGreen ) | ( Fuchsia ) | ( Gainsboro ) | ( GhostWhite ) | ( Gold ) | ( GoldenRod ) | ( Gray ) | ( Green ) | ( GreenYellow ) | ( Grey ) | ( HoneyDew ) | ( HotPink ) | ( IndianRed ) | ( Indigo ) | ( Ivory ) | ( Khaki ) | ( Lavender ) | ( LavenderBlush ) | ( LawnGreen ) | ( LemonChiffon ) | ( LightBlue ) | ( LightCoral ) | ( LightCyan ) | ( LightGoldenRodYellow ) | ( LightGray ) | ( LightGreen ) | ( LightGrey ) | ( LightPink ) | ( LightSalmon ) | ( LightSeaGreen ) | ( LightSkyBlue ) | ( LightSlateGray ) | ( LightSlateGrey ) | ( LightSteelBlue ) | ( LightYellow ) | ( Lime ) | ( LimeGreen ) | ( Linen ) | ( Magenta ) | ( Maroon ) | ( MediumAquaMarine ) | ( MediumBlue ) | ( MediumOrchid ) | ( MediumPurple ) | ( MediumSeaGreen ) | ( MediumSlateBlue ) | ( MediumSpringGreen ) | ( MediumTurquoise ) | ( MediumVioletRed ) | ( MidnightBlue ) | ( MintCream ) | ( MistyRose ) | ( Moccasin ) | ( NavajoWhite ) | ( Navy ) | ( OldLace ) | ( Olive ) | ( OliveDrab ) | ( OrangeRed ) | ( Orchid ) | ( PaleGoldenRod ) | ( PaleGreen ) | ( PaleTurquoise ) | ( PaleVioletRed ) | ( PapayaWhip ) | ( PeachPuff ) | ( Peru ) | ( Pink ) | ( Plum ) | ( PowderBlue ) | ( Purple ) | ( Red ) | ( RosyBrown ) | ( RoyalBlue ) | ( SaddleBrown ) | ( Salmon ) | ( SandyBrown ) | ( SeaGreen ) | ( Sienna ) | ( Silver ) | ( SkyBlue ) | ( SlateBlue ) | ( SlateGray ) | ( SlateGrey ) | ( Snow ) | ( SpringGreen ) | ( SteelBlue ) | ( Tan ) | ( Teal ) | ( Thistle ) | ( Tomato ) | ( Turquoise ) | ( Violet ) | ( Wheat ) | ( White ) | ( WhiteSmoke ) | ( Yellow ) | ( YellowGreen ) )
            int alt5=145;
            switch ( input.LA(1) ) {
            case AliceBlue:
                {
                alt5=1;
                }
                break;
            case AntiqueWhite:
                {
                alt5=2;
                }
                break;
            case Aqua:
                {
                alt5=3;
                }
                break;
            case Aquamarine:
                {
                alt5=4;
                }
                break;
            case Azure:
                {
                alt5=5;
                }
                break;
            case Beige:
                {
                alt5=6;
                }
                break;
            case Bisque:
                {
                alt5=7;
                }
                break;
            case Black:
                {
                alt5=8;
                }
                break;
            case BlanchedAlmond:
                {
                alt5=9;
                }
                break;
            case Blue:
                {
                alt5=10;
                }
                break;
            case BlueViolet:
                {
                alt5=11;
                }
                break;
            case Brown:
                {
                alt5=12;
                }
                break;
            case BurlyWood:
                {
                alt5=13;
                }
                break;
            case CadetBlue:
                {
                alt5=14;
                }
                break;
            case Chartreuse:
                {
                alt5=15;
                }
                break;
            case Chocolate:
                {
                alt5=16;
                }
                break;
            case Coral:
                {
                alt5=17;
                }
                break;
            case CornflowerBlue:
                {
                alt5=18;
                }
                break;
            case Cornsilk:
                {
                alt5=19;
                }
                break;
            case Crimson:
                {
                alt5=20;
                }
                break;
            case Cyan:
                {
                alt5=21;
                }
                break;
            case DarkBlue:
                {
                alt5=22;
                }
                break;
            case DarkCyan:
                {
                alt5=23;
                }
                break;
            case DarkGoldenRod:
                {
                alt5=24;
                }
                break;
            case DarkGray:
                {
                alt5=25;
                }
                break;
            case DarkGreen:
                {
                alt5=26;
                }
                break;
            case DarkGrey:
                {
                alt5=27;
                }
                break;
            case DarkKhaki:
                {
                alt5=28;
                }
                break;
            case DarkMagenta:
                {
                alt5=29;
                }
                break;
            case DarkOliveGreen:
                {
                alt5=30;
                }
                break;
            case DarkOrchid:
                {
                alt5=31;
                }
                break;
            case DarkRed:
                {
                alt5=32;
                }
                break;
            case DarkSalmo:
                {
                alt5=33;
                }
                break;
            case DarkSeaGreen:
                {
                alt5=34;
                }
                break;
            case DarkSlateBlue:
                {
                alt5=35;
                }
                break;
            case DarkSlateGray:
                {
                alt5=36;
                }
                break;
            case DarkSlateGrey:
                {
                alt5=37;
                }
                break;
            case DarkTurquoise:
                {
                alt5=38;
                }
                break;
            case DarkViolet:
                {
                alt5=39;
                }
                break;
            case Darkorange:
                {
                alt5=40;
                }
                break;
            case DeepPink:
                {
                alt5=41;
                }
                break;
            case DeepSkyBlue:
                {
                alt5=42;
                }
                break;
            case DimGray:
                {
                alt5=43;
                }
                break;
            case DimGrey:
                {
                alt5=44;
                }
                break;
            case DodgerBlue:
                {
                alt5=45;
                }
                break;
            case FireBrick:
                {
                alt5=46;
                }
                break;
            case FloralWhite:
                {
                alt5=47;
                }
                break;
            case ForestGreen:
                {
                alt5=48;
                }
                break;
            case Fuchsia:
                {
                alt5=49;
                }
                break;
            case Gainsboro:
                {
                alt5=50;
                }
                break;
            case GhostWhite:
                {
                alt5=51;
                }
                break;
            case Gold:
                {
                alt5=52;
                }
                break;
            case GoldenRod:
                {
                alt5=53;
                }
                break;
            case Gray:
                {
                alt5=54;
                }
                break;
            case Green:
                {
                alt5=55;
                }
                break;
            case GreenYellow:
                {
                alt5=56;
                }
                break;
            case Grey:
                {
                alt5=57;
                }
                break;
            case HoneyDew:
                {
                alt5=58;
                }
                break;
            case HotPink:
                {
                alt5=59;
                }
                break;
            case IndianRed:
                {
                alt5=60;
                }
                break;
            case Indigo:
                {
                alt5=61;
                }
                break;
            case Ivory:
                {
                alt5=62;
                }
                break;
            case Khaki:
                {
                alt5=63;
                }
                break;
            case Lavender:
                {
                alt5=64;
                }
                break;
            case LavenderBlush:
                {
                alt5=65;
                }
                break;
            case LawnGreen:
                {
                alt5=66;
                }
                break;
            case LemonChiffon:
                {
                alt5=67;
                }
                break;
            case LightBlue:
                {
                alt5=68;
                }
                break;
            case LightCoral:
                {
                alt5=69;
                }
                break;
            case LightCyan:
                {
                alt5=70;
                }
                break;
            case LightGoldenRodYellow:
                {
                alt5=71;
                }
                break;
            case LightGray:
                {
                alt5=72;
                }
                break;
            case LightGreen:
                {
                alt5=73;
                }
                break;
            case LightGrey:
                {
                alt5=74;
                }
                break;
            case LightPink:
                {
                alt5=75;
                }
                break;
            case LightSalmon:
                {
                alt5=76;
                }
                break;
            case LightSeaGreen:
                {
                alt5=77;
                }
                break;
            case LightSkyBlue:
                {
                alt5=78;
                }
                break;
            case LightSlateGray:
                {
                alt5=79;
                }
                break;
            case LightSlateGrey:
                {
                alt5=80;
                }
                break;
            case LightSteelBlue:
                {
                alt5=81;
                }
                break;
            case LightYellow:
                {
                alt5=82;
                }
                break;
            case Lime:
                {
                alt5=83;
                }
                break;
            case LimeGreen:
                {
                alt5=84;
                }
                break;
            case Linen:
                {
                alt5=85;
                }
                break;
            case Magenta:
                {
                alt5=86;
                }
                break;
            case Maroon:
                {
                alt5=87;
                }
                break;
            case MediumAquaMarine:
                {
                alt5=88;
                }
                break;
            case MediumBlue:
                {
                alt5=89;
                }
                break;
            case MediumOrchid:
                {
                alt5=90;
                }
                break;
            case MediumPurple:
                {
                alt5=91;
                }
                break;
            case MediumSeaGreen:
                {
                alt5=92;
                }
                break;
            case MediumSlateBlue:
                {
                alt5=93;
                }
                break;
            case MediumSpringGreen:
                {
                alt5=94;
                }
                break;
            case MediumTurquoise:
                {
                alt5=95;
                }
                break;
            case MediumVioletRed:
                {
                alt5=96;
                }
                break;
            case MidnightBlue:
                {
                alt5=97;
                }
                break;
            case MintCream:
                {
                alt5=98;
                }
                break;
            case MistyRose:
                {
                alt5=99;
                }
                break;
            case Moccasin:
                {
                alt5=100;
                }
                break;
            case NavajoWhite:
                {
                alt5=101;
                }
                break;
            case Navy:
                {
                alt5=102;
                }
                break;
            case OldLace:
                {
                alt5=103;
                }
                break;
            case Olive:
                {
                alt5=104;
                }
                break;
            case OliveDrab:
                {
                alt5=105;
                }
                break;
            case OrangeRed:
                {
                alt5=106;
                }
                break;
            case Orchid:
                {
                alt5=107;
                }
                break;
            case PaleGoldenRod:
                {
                alt5=108;
                }
                break;
            case PaleGreen:
                {
                alt5=109;
                }
                break;
            case PaleTurquoise:
                {
                alt5=110;
                }
                break;
            case PaleVioletRed:
                {
                alt5=111;
                }
                break;
            case PapayaWhip:
                {
                alt5=112;
                }
                break;
            case PeachPuff:
                {
                alt5=113;
                }
                break;
            case Peru:
                {
                alt5=114;
                }
                break;
            case Pink:
                {
                alt5=115;
                }
                break;
            case Plum:
                {
                alt5=116;
                }
                break;
            case PowderBlue:
                {
                alt5=117;
                }
                break;
            case Purple:
                {
                alt5=118;
                }
                break;
            case Red:
                {
                alt5=119;
                }
                break;
            case RosyBrown:
                {
                alt5=120;
                }
                break;
            case RoyalBlue:
                {
                alt5=121;
                }
                break;
            case SaddleBrown:
                {
                alt5=122;
                }
                break;
            case Salmon:
                {
                alt5=123;
                }
                break;
            case SandyBrown:
                {
                alt5=124;
                }
                break;
            case SeaGreen:
                {
                alt5=125;
                }
                break;
            case Sienna:
                {
                alt5=126;
                }
                break;
            case Silver:
                {
                alt5=127;
                }
                break;
            case SkyBlue:
                {
                alt5=128;
                }
                break;
            case SlateBlue:
                {
                alt5=129;
                }
                break;
            case SlateGray:
                {
                alt5=130;
                }
                break;
            case SlateGrey:
                {
                alt5=131;
                }
                break;
            case Snow:
                {
                alt5=132;
                }
                break;
            case SpringGreen:
                {
                alt5=133;
                }
                break;
            case SteelBlue:
                {
                alt5=134;
                }
                break;
            case Tan:
                {
                alt5=135;
                }
                break;
            case Teal:
                {
                alt5=136;
                }
                break;
            case Thistle:
                {
                alt5=137;
                }
                break;
            case Tomato:
                {
                alt5=138;
                }
                break;
            case Turquoise:
                {
                alt5=139;
                }
                break;
            case Violet:
                {
                alt5=140;
                }
                break;
            case Wheat:
                {
                alt5=141;
                }
                break;
            case White:
                {
                alt5=142;
                }
                break;
            case WhiteSmoke:
                {
                alt5=143;
                }
                break;
            case Yellow:
                {
                alt5=144;
                }
                break;
            case YellowGreen:
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1095:1: ( AliceBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1095:1: ( AliceBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1096:1: AliceBlue
                    {
                     before(grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 
                    match(input,AliceBlue,FOLLOW_AliceBlue_in_rule__Color__Alternatives_12050); 
                     after(grammarAccess.getColorAccess().getAliceBlueKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1103:6: ( AntiqueWhite )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1103:6: ( AntiqueWhite )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1104:1: AntiqueWhite
                    {
                     before(grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 
                    match(input,AntiqueWhite,FOLLOW_AntiqueWhite_in_rule__Color__Alternatives_12070); 
                     after(grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1111:6: ( Aqua )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1111:6: ( Aqua )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1112:1: Aqua
                    {
                     before(grammarAccess.getColorAccess().getAquaKeyword_1_2()); 
                    match(input,Aqua,FOLLOW_Aqua_in_rule__Color__Alternatives_12090); 
                     after(grammarAccess.getColorAccess().getAquaKeyword_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1119:6: ( Aquamarine )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1119:6: ( Aquamarine )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1120:1: Aquamarine
                    {
                     before(grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 
                    match(input,Aquamarine,FOLLOW_Aquamarine_in_rule__Color__Alternatives_12110); 
                     after(grammarAccess.getColorAccess().getAquamarineKeyword_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1127:6: ( Azure )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1127:6: ( Azure )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1128:1: Azure
                    {
                     before(grammarAccess.getColorAccess().getAzureKeyword_1_4()); 
                    match(input,Azure,FOLLOW_Azure_in_rule__Color__Alternatives_12130); 
                     after(grammarAccess.getColorAccess().getAzureKeyword_1_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1135:6: ( Beige )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1135:6: ( Beige )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1136:1: Beige
                    {
                     before(grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 
                    match(input,Beige,FOLLOW_Beige_in_rule__Color__Alternatives_12150); 
                     after(grammarAccess.getColorAccess().getBeigeKeyword_1_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1143:6: ( Bisque )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1143:6: ( Bisque )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1144:1: Bisque
                    {
                     before(grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 
                    match(input,Bisque,FOLLOW_Bisque_in_rule__Color__Alternatives_12170); 
                     after(grammarAccess.getColorAccess().getBisqueKeyword_1_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1151:6: ( Black )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1151:6: ( Black )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1152:1: Black
                    {
                     before(grammarAccess.getColorAccess().getBlackKeyword_1_7()); 
                    match(input,Black,FOLLOW_Black_in_rule__Color__Alternatives_12190); 
                     after(grammarAccess.getColorAccess().getBlackKeyword_1_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1159:6: ( BlanchedAlmond )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1159:6: ( BlanchedAlmond )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1160:1: BlanchedAlmond
                    {
                     before(grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 
                    match(input,BlanchedAlmond,FOLLOW_BlanchedAlmond_in_rule__Color__Alternatives_12210); 
                     after(grammarAccess.getColorAccess().getBlanchedAlmondKeyword_1_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1167:6: ( Blue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1167:6: ( Blue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1168:1: Blue
                    {
                     before(grammarAccess.getColorAccess().getBlueKeyword_1_9()); 
                    match(input,Blue,FOLLOW_Blue_in_rule__Color__Alternatives_12230); 
                     after(grammarAccess.getColorAccess().getBlueKeyword_1_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1175:6: ( BlueViolet )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1175:6: ( BlueViolet )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1176:1: BlueViolet
                    {
                     before(grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 
                    match(input,BlueViolet,FOLLOW_BlueViolet_in_rule__Color__Alternatives_12250); 
                     after(grammarAccess.getColorAccess().getBlueVioletKeyword_1_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1183:6: ( Brown )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1183:6: ( Brown )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1184:1: Brown
                    {
                     before(grammarAccess.getColorAccess().getBrownKeyword_1_11()); 
                    match(input,Brown,FOLLOW_Brown_in_rule__Color__Alternatives_12270); 
                     after(grammarAccess.getColorAccess().getBrownKeyword_1_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1191:6: ( BurlyWood )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1191:6: ( BurlyWood )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1192:1: BurlyWood
                    {
                     before(grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 
                    match(input,BurlyWood,FOLLOW_BurlyWood_in_rule__Color__Alternatives_12290); 
                     after(grammarAccess.getColorAccess().getBurlyWoodKeyword_1_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1199:6: ( CadetBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1199:6: ( CadetBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1200:1: CadetBlue
                    {
                     before(grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 
                    match(input,CadetBlue,FOLLOW_CadetBlue_in_rule__Color__Alternatives_12310); 
                     after(grammarAccess.getColorAccess().getCadetBlueKeyword_1_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1207:6: ( Chartreuse )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1207:6: ( Chartreuse )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1208:1: Chartreuse
                    {
                     before(grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 
                    match(input,Chartreuse,FOLLOW_Chartreuse_in_rule__Color__Alternatives_12330); 
                     after(grammarAccess.getColorAccess().getChartreuseKeyword_1_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1215:6: ( Chocolate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1215:6: ( Chocolate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1216:1: Chocolate
                    {
                     before(grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 
                    match(input,Chocolate,FOLLOW_Chocolate_in_rule__Color__Alternatives_12350); 
                     after(grammarAccess.getColorAccess().getChocolateKeyword_1_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1223:6: ( Coral )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1223:6: ( Coral )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1224:1: Coral
                    {
                     before(grammarAccess.getColorAccess().getCoralKeyword_1_16()); 
                    match(input,Coral,FOLLOW_Coral_in_rule__Color__Alternatives_12370); 
                     after(grammarAccess.getColorAccess().getCoralKeyword_1_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1231:6: ( CornflowerBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1231:6: ( CornflowerBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1232:1: CornflowerBlue
                    {
                     before(grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 
                    match(input,CornflowerBlue,FOLLOW_CornflowerBlue_in_rule__Color__Alternatives_12390); 
                     after(grammarAccess.getColorAccess().getCornflowerBlueKeyword_1_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1239:6: ( Cornsilk )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1239:6: ( Cornsilk )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1240:1: Cornsilk
                    {
                     before(grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 
                    match(input,Cornsilk,FOLLOW_Cornsilk_in_rule__Color__Alternatives_12410); 
                     after(grammarAccess.getColorAccess().getCornsilkKeyword_1_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1247:6: ( Crimson )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1247:6: ( Crimson )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1248:1: Crimson
                    {
                     before(grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 
                    match(input,Crimson,FOLLOW_Crimson_in_rule__Color__Alternatives_12430); 
                     after(grammarAccess.getColorAccess().getCrimsonKeyword_1_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1255:6: ( Cyan )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1255:6: ( Cyan )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1256:1: Cyan
                    {
                     before(grammarAccess.getColorAccess().getCyanKeyword_1_20()); 
                    match(input,Cyan,FOLLOW_Cyan_in_rule__Color__Alternatives_12450); 
                     after(grammarAccess.getColorAccess().getCyanKeyword_1_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1263:6: ( DarkBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1263:6: ( DarkBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1264:1: DarkBlue
                    {
                     before(grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 
                    match(input,DarkBlue,FOLLOW_DarkBlue_in_rule__Color__Alternatives_12470); 
                     after(grammarAccess.getColorAccess().getDarkBlueKeyword_1_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1271:6: ( DarkCyan )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1271:6: ( DarkCyan )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1272:1: DarkCyan
                    {
                     before(grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 
                    match(input,DarkCyan,FOLLOW_DarkCyan_in_rule__Color__Alternatives_12490); 
                     after(grammarAccess.getColorAccess().getDarkCyanKeyword_1_22()); 

                    }


                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1279:6: ( DarkGoldenRod )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1279:6: ( DarkGoldenRod )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1280:1: DarkGoldenRod
                    {
                     before(grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 
                    match(input,DarkGoldenRod,FOLLOW_DarkGoldenRod_in_rule__Color__Alternatives_12510); 
                     after(grammarAccess.getColorAccess().getDarkGoldenRodKeyword_1_23()); 

                    }


                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1287:6: ( DarkGray )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1287:6: ( DarkGray )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1288:1: DarkGray
                    {
                     before(grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 
                    match(input,DarkGray,FOLLOW_DarkGray_in_rule__Color__Alternatives_12530); 
                     after(grammarAccess.getColorAccess().getDarkGrayKeyword_1_24()); 

                    }


                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1295:6: ( DarkGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1295:6: ( DarkGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1296:1: DarkGreen
                    {
                     before(grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 
                    match(input,DarkGreen,FOLLOW_DarkGreen_in_rule__Color__Alternatives_12550); 
                     after(grammarAccess.getColorAccess().getDarkGreenKeyword_1_25()); 

                    }


                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1303:6: ( DarkGrey )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1303:6: ( DarkGrey )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1304:1: DarkGrey
                    {
                     before(grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 
                    match(input,DarkGrey,FOLLOW_DarkGrey_in_rule__Color__Alternatives_12570); 
                     after(grammarAccess.getColorAccess().getDarkGreyKeyword_1_26()); 

                    }


                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1311:6: ( DarkKhaki )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1311:6: ( DarkKhaki )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1312:1: DarkKhaki
                    {
                     before(grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 
                    match(input,DarkKhaki,FOLLOW_DarkKhaki_in_rule__Color__Alternatives_12590); 
                     after(grammarAccess.getColorAccess().getDarkKhakiKeyword_1_27()); 

                    }


                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1319:6: ( DarkMagenta )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1319:6: ( DarkMagenta )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1320:1: DarkMagenta
                    {
                     before(grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 
                    match(input,DarkMagenta,FOLLOW_DarkMagenta_in_rule__Color__Alternatives_12610); 
                     after(grammarAccess.getColorAccess().getDarkMagentaKeyword_1_28()); 

                    }


                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1327:6: ( DarkOliveGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1327:6: ( DarkOliveGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1328:1: DarkOliveGreen
                    {
                     before(grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 
                    match(input,DarkOliveGreen,FOLLOW_DarkOliveGreen_in_rule__Color__Alternatives_12630); 
                     after(grammarAccess.getColorAccess().getDarkOliveGreenKeyword_1_29()); 

                    }


                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1335:6: ( DarkOrchid )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1335:6: ( DarkOrchid )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1336:1: DarkOrchid
                    {
                     before(grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 
                    match(input,DarkOrchid,FOLLOW_DarkOrchid_in_rule__Color__Alternatives_12650); 
                     after(grammarAccess.getColorAccess().getDarkOrchidKeyword_1_30()); 

                    }


                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1343:6: ( DarkRed )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1343:6: ( DarkRed )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1344:1: DarkRed
                    {
                     before(grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 
                    match(input,DarkRed,FOLLOW_DarkRed_in_rule__Color__Alternatives_12670); 
                     after(grammarAccess.getColorAccess().getDarkRedKeyword_1_31()); 

                    }


                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1351:6: ( DarkSalmo )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1351:6: ( DarkSalmo )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1352:1: DarkSalmo
                    {
                     before(grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 
                    match(input,DarkSalmo,FOLLOW_DarkSalmo_in_rule__Color__Alternatives_12690); 
                     after(grammarAccess.getColorAccess().getDarkSalmoKeyword_1_32()); 

                    }


                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1359:6: ( DarkSeaGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1359:6: ( DarkSeaGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1360:1: DarkSeaGreen
                    {
                     before(grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 
                    match(input,DarkSeaGreen,FOLLOW_DarkSeaGreen_in_rule__Color__Alternatives_12710); 
                     after(grammarAccess.getColorAccess().getDarkSeaGreenKeyword_1_33()); 

                    }


                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1367:6: ( DarkSlateBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1367:6: ( DarkSlateBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1368:1: DarkSlateBlue
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 
                    match(input,DarkSlateBlue,FOLLOW_DarkSlateBlue_in_rule__Color__Alternatives_12730); 
                     after(grammarAccess.getColorAccess().getDarkSlateBlueKeyword_1_34()); 

                    }


                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1375:6: ( DarkSlateGray )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1375:6: ( DarkSlateGray )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1376:1: DarkSlateGray
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 
                    match(input,DarkSlateGray,FOLLOW_DarkSlateGray_in_rule__Color__Alternatives_12750); 
                     after(grammarAccess.getColorAccess().getDarkSlateGrayKeyword_1_35()); 

                    }


                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1383:6: ( DarkSlateGrey )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1383:6: ( DarkSlateGrey )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1384:1: DarkSlateGrey
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 
                    match(input,DarkSlateGrey,FOLLOW_DarkSlateGrey_in_rule__Color__Alternatives_12770); 
                     after(grammarAccess.getColorAccess().getDarkSlateGreyKeyword_1_36()); 

                    }


                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1391:6: ( DarkTurquoise )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1391:6: ( DarkTurquoise )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1392:1: DarkTurquoise
                    {
                     before(grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 
                    match(input,DarkTurquoise,FOLLOW_DarkTurquoise_in_rule__Color__Alternatives_12790); 
                     after(grammarAccess.getColorAccess().getDarkTurquoiseKeyword_1_37()); 

                    }


                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1399:6: ( DarkViolet )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1399:6: ( DarkViolet )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1400:1: DarkViolet
                    {
                     before(grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 
                    match(input,DarkViolet,FOLLOW_DarkViolet_in_rule__Color__Alternatives_12810); 
                     after(grammarAccess.getColorAccess().getDarkVioletKeyword_1_38()); 

                    }


                    }
                    break;
                case 40 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1407:6: ( Darkorange )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1407:6: ( Darkorange )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1408:1: Darkorange
                    {
                     before(grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 
                    match(input,Darkorange,FOLLOW_Darkorange_in_rule__Color__Alternatives_12830); 
                     after(grammarAccess.getColorAccess().getDarkorangeKeyword_1_39()); 

                    }


                    }
                    break;
                case 41 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1415:6: ( DeepPink )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1415:6: ( DeepPink )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1416:1: DeepPink
                    {
                     before(grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 
                    match(input,DeepPink,FOLLOW_DeepPink_in_rule__Color__Alternatives_12850); 
                     after(grammarAccess.getColorAccess().getDeepPinkKeyword_1_40()); 

                    }


                    }
                    break;
                case 42 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1423:6: ( DeepSkyBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1423:6: ( DeepSkyBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1424:1: DeepSkyBlue
                    {
                     before(grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 
                    match(input,DeepSkyBlue,FOLLOW_DeepSkyBlue_in_rule__Color__Alternatives_12870); 
                     after(grammarAccess.getColorAccess().getDeepSkyBlueKeyword_1_41()); 

                    }


                    }
                    break;
                case 43 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1431:6: ( DimGray )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1431:6: ( DimGray )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1432:1: DimGray
                    {
                     before(grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 
                    match(input,DimGray,FOLLOW_DimGray_in_rule__Color__Alternatives_12890); 
                     after(grammarAccess.getColorAccess().getDimGrayKeyword_1_42()); 

                    }


                    }
                    break;
                case 44 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1439:6: ( DimGrey )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1439:6: ( DimGrey )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1440:1: DimGrey
                    {
                     before(grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 
                    match(input,DimGrey,FOLLOW_DimGrey_in_rule__Color__Alternatives_12910); 
                     after(grammarAccess.getColorAccess().getDimGreyKeyword_1_43()); 

                    }


                    }
                    break;
                case 45 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1447:6: ( DodgerBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1447:6: ( DodgerBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1448:1: DodgerBlue
                    {
                     before(grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 
                    match(input,DodgerBlue,FOLLOW_DodgerBlue_in_rule__Color__Alternatives_12930); 
                     after(grammarAccess.getColorAccess().getDodgerBlueKeyword_1_44()); 

                    }


                    }
                    break;
                case 46 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1455:6: ( FireBrick )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1455:6: ( FireBrick )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1456:1: FireBrick
                    {
                     before(grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 
                    match(input,FireBrick,FOLLOW_FireBrick_in_rule__Color__Alternatives_12950); 
                     after(grammarAccess.getColorAccess().getFireBrickKeyword_1_45()); 

                    }


                    }
                    break;
                case 47 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1463:6: ( FloralWhite )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1463:6: ( FloralWhite )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1464:1: FloralWhite
                    {
                     before(grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 
                    match(input,FloralWhite,FOLLOW_FloralWhite_in_rule__Color__Alternatives_12970); 
                     after(grammarAccess.getColorAccess().getFloralWhiteKeyword_1_46()); 

                    }


                    }
                    break;
                case 48 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1471:6: ( ForestGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1471:6: ( ForestGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1472:1: ForestGreen
                    {
                     before(grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 
                    match(input,ForestGreen,FOLLOW_ForestGreen_in_rule__Color__Alternatives_12990); 
                     after(grammarAccess.getColorAccess().getForestGreenKeyword_1_47()); 

                    }


                    }
                    break;
                case 49 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1479:6: ( Fuchsia )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1479:6: ( Fuchsia )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1480:1: Fuchsia
                    {
                     before(grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 
                    match(input,Fuchsia,FOLLOW_Fuchsia_in_rule__Color__Alternatives_13010); 
                     after(grammarAccess.getColorAccess().getFuchsiaKeyword_1_48()); 

                    }


                    }
                    break;
                case 50 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1487:6: ( Gainsboro )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1487:6: ( Gainsboro )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1488:1: Gainsboro
                    {
                     before(grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 
                    match(input,Gainsboro,FOLLOW_Gainsboro_in_rule__Color__Alternatives_13030); 
                     after(grammarAccess.getColorAccess().getGainsboroKeyword_1_49()); 

                    }


                    }
                    break;
                case 51 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1495:6: ( GhostWhite )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1495:6: ( GhostWhite )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1496:1: GhostWhite
                    {
                     before(grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 
                    match(input,GhostWhite,FOLLOW_GhostWhite_in_rule__Color__Alternatives_13050); 
                     after(grammarAccess.getColorAccess().getGhostWhiteKeyword_1_50()); 

                    }


                    }
                    break;
                case 52 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1503:6: ( Gold )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1503:6: ( Gold )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1504:1: Gold
                    {
                     before(grammarAccess.getColorAccess().getGoldKeyword_1_51()); 
                    match(input,Gold,FOLLOW_Gold_in_rule__Color__Alternatives_13070); 
                     after(grammarAccess.getColorAccess().getGoldKeyword_1_51()); 

                    }


                    }
                    break;
                case 53 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1511:6: ( GoldenRod )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1511:6: ( GoldenRod )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1512:1: GoldenRod
                    {
                     before(grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 
                    match(input,GoldenRod,FOLLOW_GoldenRod_in_rule__Color__Alternatives_13090); 
                     after(grammarAccess.getColorAccess().getGoldenRodKeyword_1_52()); 

                    }


                    }
                    break;
                case 54 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1519:6: ( Gray )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1519:6: ( Gray )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1520:1: Gray
                    {
                     before(grammarAccess.getColorAccess().getGrayKeyword_1_53()); 
                    match(input,Gray,FOLLOW_Gray_in_rule__Color__Alternatives_13110); 
                     after(grammarAccess.getColorAccess().getGrayKeyword_1_53()); 

                    }


                    }
                    break;
                case 55 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1527:6: ( Green )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1527:6: ( Green )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1528:1: Green
                    {
                     before(grammarAccess.getColorAccess().getGreenKeyword_1_54()); 
                    match(input,Green,FOLLOW_Green_in_rule__Color__Alternatives_13130); 
                     after(grammarAccess.getColorAccess().getGreenKeyword_1_54()); 

                    }


                    }
                    break;
                case 56 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1535:6: ( GreenYellow )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1535:6: ( GreenYellow )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1536:1: GreenYellow
                    {
                     before(grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 
                    match(input,GreenYellow,FOLLOW_GreenYellow_in_rule__Color__Alternatives_13150); 
                     after(grammarAccess.getColorAccess().getGreenYellowKeyword_1_55()); 

                    }


                    }
                    break;
                case 57 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1543:6: ( Grey )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1543:6: ( Grey )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1544:1: Grey
                    {
                     before(grammarAccess.getColorAccess().getGreyKeyword_1_56()); 
                    match(input,Grey,FOLLOW_Grey_in_rule__Color__Alternatives_13170); 
                     after(grammarAccess.getColorAccess().getGreyKeyword_1_56()); 

                    }


                    }
                    break;
                case 58 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1551:6: ( HoneyDew )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1551:6: ( HoneyDew )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1552:1: HoneyDew
                    {
                     before(grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 
                    match(input,HoneyDew,FOLLOW_HoneyDew_in_rule__Color__Alternatives_13190); 
                     after(grammarAccess.getColorAccess().getHoneyDewKeyword_1_57()); 

                    }


                    }
                    break;
                case 59 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1559:6: ( HotPink )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1559:6: ( HotPink )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1560:1: HotPink
                    {
                     before(grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 
                    match(input,HotPink,FOLLOW_HotPink_in_rule__Color__Alternatives_13210); 
                     after(grammarAccess.getColorAccess().getHotPinkKeyword_1_58()); 

                    }


                    }
                    break;
                case 60 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1567:6: ( IndianRed )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1567:6: ( IndianRed )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1568:1: IndianRed
                    {
                     before(grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 
                    match(input,IndianRed,FOLLOW_IndianRed_in_rule__Color__Alternatives_13230); 
                     after(grammarAccess.getColorAccess().getIndianRedKeyword_1_59()); 

                    }


                    }
                    break;
                case 61 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1575:6: ( Indigo )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1575:6: ( Indigo )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1576:1: Indigo
                    {
                     before(grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 
                    match(input,Indigo,FOLLOW_Indigo_in_rule__Color__Alternatives_13250); 
                     after(grammarAccess.getColorAccess().getIndigoKeyword_1_60()); 

                    }


                    }
                    break;
                case 62 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1583:6: ( Ivory )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1583:6: ( Ivory )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1584:1: Ivory
                    {
                     before(grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 
                    match(input,Ivory,FOLLOW_Ivory_in_rule__Color__Alternatives_13270); 
                     after(grammarAccess.getColorAccess().getIvoryKeyword_1_61()); 

                    }


                    }
                    break;
                case 63 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1591:6: ( Khaki )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1591:6: ( Khaki )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1592:1: Khaki
                    {
                     before(grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 
                    match(input,Khaki,FOLLOW_Khaki_in_rule__Color__Alternatives_13290); 
                     after(grammarAccess.getColorAccess().getKhakiKeyword_1_62()); 

                    }


                    }
                    break;
                case 64 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1599:6: ( Lavender )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1599:6: ( Lavender )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1600:1: Lavender
                    {
                     before(grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 
                    match(input,Lavender,FOLLOW_Lavender_in_rule__Color__Alternatives_13310); 
                     after(grammarAccess.getColorAccess().getLavenderKeyword_1_63()); 

                    }


                    }
                    break;
                case 65 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1607:6: ( LavenderBlush )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1607:6: ( LavenderBlush )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1608:1: LavenderBlush
                    {
                     before(grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 
                    match(input,LavenderBlush,FOLLOW_LavenderBlush_in_rule__Color__Alternatives_13330); 
                     after(grammarAccess.getColorAccess().getLavenderBlushKeyword_1_64()); 

                    }


                    }
                    break;
                case 66 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1615:6: ( LawnGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1615:6: ( LawnGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1616:1: LawnGreen
                    {
                     before(grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 
                    match(input,LawnGreen,FOLLOW_LawnGreen_in_rule__Color__Alternatives_13350); 
                     after(grammarAccess.getColorAccess().getLawnGreenKeyword_1_65()); 

                    }


                    }
                    break;
                case 67 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1623:6: ( LemonChiffon )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1623:6: ( LemonChiffon )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1624:1: LemonChiffon
                    {
                     before(grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 
                    match(input,LemonChiffon,FOLLOW_LemonChiffon_in_rule__Color__Alternatives_13370); 
                     after(grammarAccess.getColorAccess().getLemonChiffonKeyword_1_66()); 

                    }


                    }
                    break;
                case 68 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1631:6: ( LightBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1631:6: ( LightBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1632:1: LightBlue
                    {
                     before(grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 
                    match(input,LightBlue,FOLLOW_LightBlue_in_rule__Color__Alternatives_13390); 
                     after(grammarAccess.getColorAccess().getLightBlueKeyword_1_67()); 

                    }


                    }
                    break;
                case 69 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1639:6: ( LightCoral )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1639:6: ( LightCoral )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1640:1: LightCoral
                    {
                     before(grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 
                    match(input,LightCoral,FOLLOW_LightCoral_in_rule__Color__Alternatives_13410); 
                     after(grammarAccess.getColorAccess().getLightCoralKeyword_1_68()); 

                    }


                    }
                    break;
                case 70 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1647:6: ( LightCyan )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1647:6: ( LightCyan )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1648:1: LightCyan
                    {
                     before(grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 
                    match(input,LightCyan,FOLLOW_LightCyan_in_rule__Color__Alternatives_13430); 
                     after(grammarAccess.getColorAccess().getLightCyanKeyword_1_69()); 

                    }


                    }
                    break;
                case 71 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1655:6: ( LightGoldenRodYellow )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1655:6: ( LightGoldenRodYellow )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1656:1: LightGoldenRodYellow
                    {
                     before(grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 
                    match(input,LightGoldenRodYellow,FOLLOW_LightGoldenRodYellow_in_rule__Color__Alternatives_13450); 
                     after(grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_1_70()); 

                    }


                    }
                    break;
                case 72 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1663:6: ( LightGray )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1663:6: ( LightGray )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1664:1: LightGray
                    {
                     before(grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 
                    match(input,LightGray,FOLLOW_LightGray_in_rule__Color__Alternatives_13470); 
                     after(grammarAccess.getColorAccess().getLightGrayKeyword_1_71()); 

                    }


                    }
                    break;
                case 73 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1671:6: ( LightGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1671:6: ( LightGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1672:1: LightGreen
                    {
                     before(grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 
                    match(input,LightGreen,FOLLOW_LightGreen_in_rule__Color__Alternatives_13490); 
                     after(grammarAccess.getColorAccess().getLightGreenKeyword_1_72()); 

                    }


                    }
                    break;
                case 74 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1679:6: ( LightGrey )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1679:6: ( LightGrey )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1680:1: LightGrey
                    {
                     before(grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 
                    match(input,LightGrey,FOLLOW_LightGrey_in_rule__Color__Alternatives_13510); 
                     after(grammarAccess.getColorAccess().getLightGreyKeyword_1_73()); 

                    }


                    }
                    break;
                case 75 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1687:6: ( LightPink )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1687:6: ( LightPink )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1688:1: LightPink
                    {
                     before(grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 
                    match(input,LightPink,FOLLOW_LightPink_in_rule__Color__Alternatives_13530); 
                     after(grammarAccess.getColorAccess().getLightPinkKeyword_1_74()); 

                    }


                    }
                    break;
                case 76 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1695:6: ( LightSalmon )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1695:6: ( LightSalmon )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1696:1: LightSalmon
                    {
                     before(grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 
                    match(input,LightSalmon,FOLLOW_LightSalmon_in_rule__Color__Alternatives_13550); 
                     after(grammarAccess.getColorAccess().getLightSalmonKeyword_1_75()); 

                    }


                    }
                    break;
                case 77 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1703:6: ( LightSeaGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1703:6: ( LightSeaGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1704:1: LightSeaGreen
                    {
                     before(grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 
                    match(input,LightSeaGreen,FOLLOW_LightSeaGreen_in_rule__Color__Alternatives_13570); 
                     after(grammarAccess.getColorAccess().getLightSeaGreenKeyword_1_76()); 

                    }


                    }
                    break;
                case 78 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1711:6: ( LightSkyBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1711:6: ( LightSkyBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1712:1: LightSkyBlue
                    {
                     before(grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 
                    match(input,LightSkyBlue,FOLLOW_LightSkyBlue_in_rule__Color__Alternatives_13590); 
                     after(grammarAccess.getColorAccess().getLightSkyBlueKeyword_1_77()); 

                    }


                    }
                    break;
                case 79 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1719:6: ( LightSlateGray )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1719:6: ( LightSlateGray )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1720:1: LightSlateGray
                    {
                     before(grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 
                    match(input,LightSlateGray,FOLLOW_LightSlateGray_in_rule__Color__Alternatives_13610); 
                     after(grammarAccess.getColorAccess().getLightSlateGrayKeyword_1_78()); 

                    }


                    }
                    break;
                case 80 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1727:6: ( LightSlateGrey )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1727:6: ( LightSlateGrey )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1728:1: LightSlateGrey
                    {
                     before(grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 
                    match(input,LightSlateGrey,FOLLOW_LightSlateGrey_in_rule__Color__Alternatives_13630); 
                     after(grammarAccess.getColorAccess().getLightSlateGreyKeyword_1_79()); 

                    }


                    }
                    break;
                case 81 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1735:6: ( LightSteelBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1735:6: ( LightSteelBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1736:1: LightSteelBlue
                    {
                     before(grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 
                    match(input,LightSteelBlue,FOLLOW_LightSteelBlue_in_rule__Color__Alternatives_13650); 
                     after(grammarAccess.getColorAccess().getLightSteelBlueKeyword_1_80()); 

                    }


                    }
                    break;
                case 82 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1743:6: ( LightYellow )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1743:6: ( LightYellow )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1744:1: LightYellow
                    {
                     before(grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 
                    match(input,LightYellow,FOLLOW_LightYellow_in_rule__Color__Alternatives_13670); 
                     after(grammarAccess.getColorAccess().getLightYellowKeyword_1_81()); 

                    }


                    }
                    break;
                case 83 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1751:6: ( Lime )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1751:6: ( Lime )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1752:1: Lime
                    {
                     before(grammarAccess.getColorAccess().getLimeKeyword_1_82()); 
                    match(input,Lime,FOLLOW_Lime_in_rule__Color__Alternatives_13690); 
                     after(grammarAccess.getColorAccess().getLimeKeyword_1_82()); 

                    }


                    }
                    break;
                case 84 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1759:6: ( LimeGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1759:6: ( LimeGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1760:1: LimeGreen
                    {
                     before(grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 
                    match(input,LimeGreen,FOLLOW_LimeGreen_in_rule__Color__Alternatives_13710); 
                     after(grammarAccess.getColorAccess().getLimeGreenKeyword_1_83()); 

                    }


                    }
                    break;
                case 85 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1767:6: ( Linen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1767:6: ( Linen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1768:1: Linen
                    {
                     before(grammarAccess.getColorAccess().getLinenKeyword_1_84()); 
                    match(input,Linen,FOLLOW_Linen_in_rule__Color__Alternatives_13730); 
                     after(grammarAccess.getColorAccess().getLinenKeyword_1_84()); 

                    }


                    }
                    break;
                case 86 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1775:6: ( Magenta )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1775:6: ( Magenta )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1776:1: Magenta
                    {
                     before(grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 
                    match(input,Magenta,FOLLOW_Magenta_in_rule__Color__Alternatives_13750); 
                     after(grammarAccess.getColorAccess().getMagentaKeyword_1_85()); 

                    }


                    }
                    break;
                case 87 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1783:6: ( Maroon )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1783:6: ( Maroon )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1784:1: Maroon
                    {
                     before(grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 
                    match(input,Maroon,FOLLOW_Maroon_in_rule__Color__Alternatives_13770); 
                     after(grammarAccess.getColorAccess().getMaroonKeyword_1_86()); 

                    }


                    }
                    break;
                case 88 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1791:6: ( MediumAquaMarine )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1791:6: ( MediumAquaMarine )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1792:1: MediumAquaMarine
                    {
                     before(grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 
                    match(input,MediumAquaMarine,FOLLOW_MediumAquaMarine_in_rule__Color__Alternatives_13790); 
                     after(grammarAccess.getColorAccess().getMediumAquaMarineKeyword_1_87()); 

                    }


                    }
                    break;
                case 89 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1799:6: ( MediumBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1799:6: ( MediumBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1800:1: MediumBlue
                    {
                     before(grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 
                    match(input,MediumBlue,FOLLOW_MediumBlue_in_rule__Color__Alternatives_13810); 
                     after(grammarAccess.getColorAccess().getMediumBlueKeyword_1_88()); 

                    }


                    }
                    break;
                case 90 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1807:6: ( MediumOrchid )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1807:6: ( MediumOrchid )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1808:1: MediumOrchid
                    {
                     before(grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 
                    match(input,MediumOrchid,FOLLOW_MediumOrchid_in_rule__Color__Alternatives_13830); 
                     after(grammarAccess.getColorAccess().getMediumOrchidKeyword_1_89()); 

                    }


                    }
                    break;
                case 91 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1815:6: ( MediumPurple )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1815:6: ( MediumPurple )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1816:1: MediumPurple
                    {
                     before(grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 
                    match(input,MediumPurple,FOLLOW_MediumPurple_in_rule__Color__Alternatives_13850); 
                     after(grammarAccess.getColorAccess().getMediumPurpleKeyword_1_90()); 

                    }


                    }
                    break;
                case 92 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1823:6: ( MediumSeaGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1823:6: ( MediumSeaGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1824:1: MediumSeaGreen
                    {
                     before(grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 
                    match(input,MediumSeaGreen,FOLLOW_MediumSeaGreen_in_rule__Color__Alternatives_13870); 
                     after(grammarAccess.getColorAccess().getMediumSeaGreenKeyword_1_91()); 

                    }


                    }
                    break;
                case 93 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1831:6: ( MediumSlateBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1831:6: ( MediumSlateBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1832:1: MediumSlateBlue
                    {
                     before(grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 
                    match(input,MediumSlateBlue,FOLLOW_MediumSlateBlue_in_rule__Color__Alternatives_13890); 
                     after(grammarAccess.getColorAccess().getMediumSlateBlueKeyword_1_92()); 

                    }


                    }
                    break;
                case 94 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1839:6: ( MediumSpringGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1839:6: ( MediumSpringGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1840:1: MediumSpringGreen
                    {
                     before(grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 
                    match(input,MediumSpringGreen,FOLLOW_MediumSpringGreen_in_rule__Color__Alternatives_13910); 
                     after(grammarAccess.getColorAccess().getMediumSpringGreenKeyword_1_93()); 

                    }


                    }
                    break;
                case 95 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1847:6: ( MediumTurquoise )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1847:6: ( MediumTurquoise )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1848:1: MediumTurquoise
                    {
                     before(grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 
                    match(input,MediumTurquoise,FOLLOW_MediumTurquoise_in_rule__Color__Alternatives_13930); 
                     after(grammarAccess.getColorAccess().getMediumTurquoiseKeyword_1_94()); 

                    }


                    }
                    break;
                case 96 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1855:6: ( MediumVioletRed )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1855:6: ( MediumVioletRed )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1856:1: MediumVioletRed
                    {
                     before(grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 
                    match(input,MediumVioletRed,FOLLOW_MediumVioletRed_in_rule__Color__Alternatives_13950); 
                     after(grammarAccess.getColorAccess().getMediumVioletRedKeyword_1_95()); 

                    }


                    }
                    break;
                case 97 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1863:6: ( MidnightBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1863:6: ( MidnightBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1864:1: MidnightBlue
                    {
                     before(grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 
                    match(input,MidnightBlue,FOLLOW_MidnightBlue_in_rule__Color__Alternatives_13970); 
                     after(grammarAccess.getColorAccess().getMidnightBlueKeyword_1_96()); 

                    }


                    }
                    break;
                case 98 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1871:6: ( MintCream )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1871:6: ( MintCream )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1872:1: MintCream
                    {
                     before(grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 
                    match(input,MintCream,FOLLOW_MintCream_in_rule__Color__Alternatives_13990); 
                     after(grammarAccess.getColorAccess().getMintCreamKeyword_1_97()); 

                    }


                    }
                    break;
                case 99 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1879:6: ( MistyRose )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1879:6: ( MistyRose )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1880:1: MistyRose
                    {
                     before(grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 
                    match(input,MistyRose,FOLLOW_MistyRose_in_rule__Color__Alternatives_14010); 
                     after(grammarAccess.getColorAccess().getMistyRoseKeyword_1_98()); 

                    }


                    }
                    break;
                case 100 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1887:6: ( Moccasin )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1887:6: ( Moccasin )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1888:1: Moccasin
                    {
                     before(grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 
                    match(input,Moccasin,FOLLOW_Moccasin_in_rule__Color__Alternatives_14030); 
                     after(grammarAccess.getColorAccess().getMoccasinKeyword_1_99()); 

                    }


                    }
                    break;
                case 101 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1895:6: ( NavajoWhite )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1895:6: ( NavajoWhite )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1896:1: NavajoWhite
                    {
                     before(grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 
                    match(input,NavajoWhite,FOLLOW_NavajoWhite_in_rule__Color__Alternatives_14050); 
                     after(grammarAccess.getColorAccess().getNavajoWhiteKeyword_1_100()); 

                    }


                    }
                    break;
                case 102 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1903:6: ( Navy )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1903:6: ( Navy )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1904:1: Navy
                    {
                     before(grammarAccess.getColorAccess().getNavyKeyword_1_101()); 
                    match(input,Navy,FOLLOW_Navy_in_rule__Color__Alternatives_14070); 
                     after(grammarAccess.getColorAccess().getNavyKeyword_1_101()); 

                    }


                    }
                    break;
                case 103 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1911:6: ( OldLace )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1911:6: ( OldLace )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1912:1: OldLace
                    {
                     before(grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 
                    match(input,OldLace,FOLLOW_OldLace_in_rule__Color__Alternatives_14090); 
                     after(grammarAccess.getColorAccess().getOldLaceKeyword_1_102()); 

                    }


                    }
                    break;
                case 104 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1919:6: ( Olive )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1919:6: ( Olive )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1920:1: Olive
                    {
                     before(grammarAccess.getColorAccess().getOliveKeyword_1_103()); 
                    match(input,Olive,FOLLOW_Olive_in_rule__Color__Alternatives_14110); 
                     after(grammarAccess.getColorAccess().getOliveKeyword_1_103()); 

                    }


                    }
                    break;
                case 105 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1927:6: ( OliveDrab )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1927:6: ( OliveDrab )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1928:1: OliveDrab
                    {
                     before(grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 
                    match(input,OliveDrab,FOLLOW_OliveDrab_in_rule__Color__Alternatives_14130); 
                     after(grammarAccess.getColorAccess().getOliveDrabKeyword_1_104()); 

                    }


                    }
                    break;
                case 106 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1935:6: ( OrangeRed )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1935:6: ( OrangeRed )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1936:1: OrangeRed
                    {
                     before(grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 
                    match(input,OrangeRed,FOLLOW_OrangeRed_in_rule__Color__Alternatives_14150); 
                     after(grammarAccess.getColorAccess().getOrangeRedKeyword_1_105()); 

                    }


                    }
                    break;
                case 107 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1943:6: ( Orchid )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1943:6: ( Orchid )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1944:1: Orchid
                    {
                     before(grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 
                    match(input,Orchid,FOLLOW_Orchid_in_rule__Color__Alternatives_14170); 
                     after(grammarAccess.getColorAccess().getOrchidKeyword_1_106()); 

                    }


                    }
                    break;
                case 108 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1951:6: ( PaleGoldenRod )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1951:6: ( PaleGoldenRod )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1952:1: PaleGoldenRod
                    {
                     before(grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 
                    match(input,PaleGoldenRod,FOLLOW_PaleGoldenRod_in_rule__Color__Alternatives_14190); 
                     after(grammarAccess.getColorAccess().getPaleGoldenRodKeyword_1_107()); 

                    }


                    }
                    break;
                case 109 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1959:6: ( PaleGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1959:6: ( PaleGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1960:1: PaleGreen
                    {
                     before(grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 
                    match(input,PaleGreen,FOLLOW_PaleGreen_in_rule__Color__Alternatives_14210); 
                     after(grammarAccess.getColorAccess().getPaleGreenKeyword_1_108()); 

                    }


                    }
                    break;
                case 110 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1967:6: ( PaleTurquoise )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1967:6: ( PaleTurquoise )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1968:1: PaleTurquoise
                    {
                     before(grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 
                    match(input,PaleTurquoise,FOLLOW_PaleTurquoise_in_rule__Color__Alternatives_14230); 
                     after(grammarAccess.getColorAccess().getPaleTurquoiseKeyword_1_109()); 

                    }


                    }
                    break;
                case 111 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1975:6: ( PaleVioletRed )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1975:6: ( PaleVioletRed )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1976:1: PaleVioletRed
                    {
                     before(grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 
                    match(input,PaleVioletRed,FOLLOW_PaleVioletRed_in_rule__Color__Alternatives_14250); 
                     after(grammarAccess.getColorAccess().getPaleVioletRedKeyword_1_110()); 

                    }


                    }
                    break;
                case 112 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1983:6: ( PapayaWhip )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1983:6: ( PapayaWhip )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1984:1: PapayaWhip
                    {
                     before(grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 
                    match(input,PapayaWhip,FOLLOW_PapayaWhip_in_rule__Color__Alternatives_14270); 
                     after(grammarAccess.getColorAccess().getPapayaWhipKeyword_1_111()); 

                    }


                    }
                    break;
                case 113 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1991:6: ( PeachPuff )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1991:6: ( PeachPuff )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1992:1: PeachPuff
                    {
                     before(grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 
                    match(input,PeachPuff,FOLLOW_PeachPuff_in_rule__Color__Alternatives_14290); 
                     after(grammarAccess.getColorAccess().getPeachPuffKeyword_1_112()); 

                    }


                    }
                    break;
                case 114 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1999:6: ( Peru )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1999:6: ( Peru )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2000:1: Peru
                    {
                     before(grammarAccess.getColorAccess().getPeruKeyword_1_113()); 
                    match(input,Peru,FOLLOW_Peru_in_rule__Color__Alternatives_14310); 
                     after(grammarAccess.getColorAccess().getPeruKeyword_1_113()); 

                    }


                    }
                    break;
                case 115 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2007:6: ( Pink )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2007:6: ( Pink )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2008:1: Pink
                    {
                     before(grammarAccess.getColorAccess().getPinkKeyword_1_114()); 
                    match(input,Pink,FOLLOW_Pink_in_rule__Color__Alternatives_14330); 
                     after(grammarAccess.getColorAccess().getPinkKeyword_1_114()); 

                    }


                    }
                    break;
                case 116 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2015:6: ( Plum )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2015:6: ( Plum )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2016:1: Plum
                    {
                     before(grammarAccess.getColorAccess().getPlumKeyword_1_115()); 
                    match(input,Plum,FOLLOW_Plum_in_rule__Color__Alternatives_14350); 
                     after(grammarAccess.getColorAccess().getPlumKeyword_1_115()); 

                    }


                    }
                    break;
                case 117 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2023:6: ( PowderBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2023:6: ( PowderBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2024:1: PowderBlue
                    {
                     before(grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 
                    match(input,PowderBlue,FOLLOW_PowderBlue_in_rule__Color__Alternatives_14370); 
                     after(grammarAccess.getColorAccess().getPowderBlueKeyword_1_116()); 

                    }


                    }
                    break;
                case 118 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2031:6: ( Purple )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2031:6: ( Purple )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2032:1: Purple
                    {
                     before(grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 
                    match(input,Purple,FOLLOW_Purple_in_rule__Color__Alternatives_14390); 
                     after(grammarAccess.getColorAccess().getPurpleKeyword_1_117()); 

                    }


                    }
                    break;
                case 119 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2039:6: ( Red )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2039:6: ( Red )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2040:1: Red
                    {
                     before(grammarAccess.getColorAccess().getRedKeyword_1_118()); 
                    match(input,Red,FOLLOW_Red_in_rule__Color__Alternatives_14410); 
                     after(grammarAccess.getColorAccess().getRedKeyword_1_118()); 

                    }


                    }
                    break;
                case 120 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2047:6: ( RosyBrown )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2047:6: ( RosyBrown )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2048:1: RosyBrown
                    {
                     before(grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 
                    match(input,RosyBrown,FOLLOW_RosyBrown_in_rule__Color__Alternatives_14430); 
                     after(grammarAccess.getColorAccess().getRosyBrownKeyword_1_119()); 

                    }


                    }
                    break;
                case 121 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2055:6: ( RoyalBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2055:6: ( RoyalBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2056:1: RoyalBlue
                    {
                     before(grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 
                    match(input,RoyalBlue,FOLLOW_RoyalBlue_in_rule__Color__Alternatives_14450); 
                     after(grammarAccess.getColorAccess().getRoyalBlueKeyword_1_120()); 

                    }


                    }
                    break;
                case 122 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2063:6: ( SaddleBrown )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2063:6: ( SaddleBrown )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2064:1: SaddleBrown
                    {
                     before(grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 
                    match(input,SaddleBrown,FOLLOW_SaddleBrown_in_rule__Color__Alternatives_14470); 
                     after(grammarAccess.getColorAccess().getSaddleBrownKeyword_1_121()); 

                    }


                    }
                    break;
                case 123 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2071:6: ( Salmon )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2071:6: ( Salmon )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2072:1: Salmon
                    {
                     before(grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 
                    match(input,Salmon,FOLLOW_Salmon_in_rule__Color__Alternatives_14490); 
                     after(grammarAccess.getColorAccess().getSalmonKeyword_1_122()); 

                    }


                    }
                    break;
                case 124 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2079:6: ( SandyBrown )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2079:6: ( SandyBrown )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2080:1: SandyBrown
                    {
                     before(grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 
                    match(input,SandyBrown,FOLLOW_SandyBrown_in_rule__Color__Alternatives_14510); 
                     after(grammarAccess.getColorAccess().getSandyBrownKeyword_1_123()); 

                    }


                    }
                    break;
                case 125 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2087:6: ( SeaGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2087:6: ( SeaGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2088:1: SeaGreen
                    {
                     before(grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 
                    match(input,SeaGreen,FOLLOW_SeaGreen_in_rule__Color__Alternatives_14530); 
                     after(grammarAccess.getColorAccess().getSeaGreenKeyword_1_124()); 

                    }


                    }
                    break;
                case 126 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2095:6: ( Sienna )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2095:6: ( Sienna )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2096:1: Sienna
                    {
                     before(grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 
                    match(input,Sienna,FOLLOW_Sienna_in_rule__Color__Alternatives_14550); 
                     after(grammarAccess.getColorAccess().getSiennaKeyword_1_125()); 

                    }


                    }
                    break;
                case 127 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2103:6: ( Silver )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2103:6: ( Silver )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2104:1: Silver
                    {
                     before(grammarAccess.getColorAccess().getSilverKeyword_1_126()); 
                    match(input,Silver,FOLLOW_Silver_in_rule__Color__Alternatives_14570); 
                     after(grammarAccess.getColorAccess().getSilverKeyword_1_126()); 

                    }


                    }
                    break;
                case 128 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2111:6: ( SkyBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2111:6: ( SkyBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2112:1: SkyBlue
                    {
                     before(grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 
                    match(input,SkyBlue,FOLLOW_SkyBlue_in_rule__Color__Alternatives_14590); 
                     after(grammarAccess.getColorAccess().getSkyBlueKeyword_1_127()); 

                    }


                    }
                    break;
                case 129 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2119:6: ( SlateBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2119:6: ( SlateBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2120:1: SlateBlue
                    {
                     before(grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 
                    match(input,SlateBlue,FOLLOW_SlateBlue_in_rule__Color__Alternatives_14610); 
                     after(grammarAccess.getColorAccess().getSlateBlueKeyword_1_128()); 

                    }


                    }
                    break;
                case 130 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2127:6: ( SlateGray )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2127:6: ( SlateGray )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2128:1: SlateGray
                    {
                     before(grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 
                    match(input,SlateGray,FOLLOW_SlateGray_in_rule__Color__Alternatives_14630); 
                     after(grammarAccess.getColorAccess().getSlateGrayKeyword_1_129()); 

                    }


                    }
                    break;
                case 131 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2135:6: ( SlateGrey )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2135:6: ( SlateGrey )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2136:1: SlateGrey
                    {
                     before(grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 
                    match(input,SlateGrey,FOLLOW_SlateGrey_in_rule__Color__Alternatives_14650); 
                     after(grammarAccess.getColorAccess().getSlateGreyKeyword_1_130()); 

                    }


                    }
                    break;
                case 132 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2143:6: ( Snow )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2143:6: ( Snow )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2144:1: Snow
                    {
                     before(grammarAccess.getColorAccess().getSnowKeyword_1_131()); 
                    match(input,Snow,FOLLOW_Snow_in_rule__Color__Alternatives_14670); 
                     after(grammarAccess.getColorAccess().getSnowKeyword_1_131()); 

                    }


                    }
                    break;
                case 133 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2151:6: ( SpringGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2151:6: ( SpringGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2152:1: SpringGreen
                    {
                     before(grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 
                    match(input,SpringGreen,FOLLOW_SpringGreen_in_rule__Color__Alternatives_14690); 
                     after(grammarAccess.getColorAccess().getSpringGreenKeyword_1_132()); 

                    }


                    }
                    break;
                case 134 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2159:6: ( SteelBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2159:6: ( SteelBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2160:1: SteelBlue
                    {
                     before(grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 
                    match(input,SteelBlue,FOLLOW_SteelBlue_in_rule__Color__Alternatives_14710); 
                     after(grammarAccess.getColorAccess().getSteelBlueKeyword_1_133()); 

                    }


                    }
                    break;
                case 135 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2167:6: ( Tan )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2167:6: ( Tan )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2168:1: Tan
                    {
                     before(grammarAccess.getColorAccess().getTanKeyword_1_134()); 
                    match(input,Tan,FOLLOW_Tan_in_rule__Color__Alternatives_14730); 
                     after(grammarAccess.getColorAccess().getTanKeyword_1_134()); 

                    }


                    }
                    break;
                case 136 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2175:6: ( Teal )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2175:6: ( Teal )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2176:1: Teal
                    {
                     before(grammarAccess.getColorAccess().getTealKeyword_1_135()); 
                    match(input,Teal,FOLLOW_Teal_in_rule__Color__Alternatives_14750); 
                     after(grammarAccess.getColorAccess().getTealKeyword_1_135()); 

                    }


                    }
                    break;
                case 137 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2183:6: ( Thistle )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2183:6: ( Thistle )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2184:1: Thistle
                    {
                     before(grammarAccess.getColorAccess().getThistleKeyword_1_136()); 
                    match(input,Thistle,FOLLOW_Thistle_in_rule__Color__Alternatives_14770); 
                     after(grammarAccess.getColorAccess().getThistleKeyword_1_136()); 

                    }


                    }
                    break;
                case 138 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2191:6: ( Tomato )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2191:6: ( Tomato )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2192:1: Tomato
                    {
                     before(grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 
                    match(input,Tomato,FOLLOW_Tomato_in_rule__Color__Alternatives_14790); 
                     after(grammarAccess.getColorAccess().getTomatoKeyword_1_137()); 

                    }


                    }
                    break;
                case 139 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2199:6: ( Turquoise )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2199:6: ( Turquoise )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2200:1: Turquoise
                    {
                     before(grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 
                    match(input,Turquoise,FOLLOW_Turquoise_in_rule__Color__Alternatives_14810); 
                     after(grammarAccess.getColorAccess().getTurquoiseKeyword_1_138()); 

                    }


                    }
                    break;
                case 140 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2207:6: ( Violet )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2207:6: ( Violet )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2208:1: Violet
                    {
                     before(grammarAccess.getColorAccess().getVioletKeyword_1_139()); 
                    match(input,Violet,FOLLOW_Violet_in_rule__Color__Alternatives_14830); 
                     after(grammarAccess.getColorAccess().getVioletKeyword_1_139()); 

                    }


                    }
                    break;
                case 141 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2215:6: ( Wheat )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2215:6: ( Wheat )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2216:1: Wheat
                    {
                     before(grammarAccess.getColorAccess().getWheatKeyword_1_140()); 
                    match(input,Wheat,FOLLOW_Wheat_in_rule__Color__Alternatives_14850); 
                     after(grammarAccess.getColorAccess().getWheatKeyword_1_140()); 

                    }


                    }
                    break;
                case 142 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2223:6: ( White )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2223:6: ( White )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2224:1: White
                    {
                     before(grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 
                    match(input,White,FOLLOW_White_in_rule__Color__Alternatives_14870); 
                     after(grammarAccess.getColorAccess().getWhiteKeyword_1_141()); 

                    }


                    }
                    break;
                case 143 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2231:6: ( WhiteSmoke )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2231:6: ( WhiteSmoke )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2232:1: WhiteSmoke
                    {
                     before(grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 
                    match(input,WhiteSmoke,FOLLOW_WhiteSmoke_in_rule__Color__Alternatives_14890); 
                     after(grammarAccess.getColorAccess().getWhiteSmokeKeyword_1_142()); 

                    }


                    }
                    break;
                case 144 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2239:6: ( Yellow )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2239:6: ( Yellow )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2240:1: Yellow
                    {
                     before(grammarAccess.getColorAccess().getYellowKeyword_1_143()); 
                    match(input,Yellow,FOLLOW_Yellow_in_rule__Color__Alternatives_14910); 
                     after(grammarAccess.getColorAccess().getYellowKeyword_1_143()); 

                    }


                    }
                    break;
                case 145 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2247:6: ( YellowGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2247:6: ( YellowGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2248:1: YellowGreen
                    {
                     before(grammarAccess.getColorAccess().getYellowGreenKeyword_1_144()); 
                    match(input,YellowGreen,FOLLOW_YellowGreen_in_rule__Color__Alternatives_14930); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2260:1: rule__Legend__Alternatives_1 : ( ( Right ) | ( Left ) | ( Center ) );
    public final void rule__Legend__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2264:1: ( ( Right ) | ( Left ) | ( Center ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case Right:
                {
                alt6=1;
                }
                break;
            case Left:
                {
                alt6=2;
                }
                break;
            case Center:
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2265:1: ( Right )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2265:1: ( Right )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2266:1: Right
                    {
                     before(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                    match(input,Right,FOLLOW_Right_in_rule__Legend__Alternatives_14965); 
                     after(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2273:6: ( Left )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2273:6: ( Left )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2274:1: Left
                    {
                     before(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                    match(input,Left,FOLLOW_Left_in_rule__Legend__Alternatives_14985); 
                     after(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2281:6: ( Center )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2281:6: ( Center )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2282:1: Center
                    {
                     before(grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                    match(input,Center,FOLLOW_Center_in_rule__Legend__Alternatives_15005); 
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


    // $ANTLR start "rule__GroupingMessages__Alternatives_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2294:1: rule__GroupingMessages__Alternatives_1 : ( ( Opt ) | ( Loop ) | ( Par ) | ( Break ) | ( Critical ) | ( Group ) );
    public final void rule__GroupingMessages__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2298:1: ( ( Opt ) | ( Loop ) | ( Par ) | ( Break ) | ( Critical ) | ( Group ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case Opt:
                {
                alt7=1;
                }
                break;
            case Loop:
                {
                alt7=2;
                }
                break;
            case Par:
                {
                alt7=3;
                }
                break;
            case Break:
                {
                alt7=4;
                }
                break;
            case Critical:
                {
                alt7=5;
                }
                break;
            case Group:
                {
                alt7=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2299:1: ( Opt )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2299:1: ( Opt )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2300:1: Opt
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getOptKeyword_1_0()); 
                    match(input,Opt,FOLLOW_Opt_in_rule__GroupingMessages__Alternatives_15040); 
                     after(grammarAccess.getGroupingMessagesAccess().getOptKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2307:6: ( Loop )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2307:6: ( Loop )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2308:1: Loop
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getLoopKeyword_1_1()); 
                    match(input,Loop,FOLLOW_Loop_in_rule__GroupingMessages__Alternatives_15060); 
                     after(grammarAccess.getGroupingMessagesAccess().getLoopKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2315:6: ( Par )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2315:6: ( Par )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2316:1: Par
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getParKeyword_1_2()); 
                    match(input,Par,FOLLOW_Par_in_rule__GroupingMessages__Alternatives_15080); 
                     after(grammarAccess.getGroupingMessagesAccess().getParKeyword_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2323:6: ( Break )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2323:6: ( Break )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2324:1: Break
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getBreakKeyword_1_3()); 
                    match(input,Break,FOLLOW_Break_in_rule__GroupingMessages__Alternatives_15100); 
                     after(grammarAccess.getGroupingMessagesAccess().getBreakKeyword_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2331:6: ( Critical )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2331:6: ( Critical )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2332:1: Critical
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_1_4()); 
                    match(input,Critical,FOLLOW_Critical_in_rule__GroupingMessages__Alternatives_15120); 
                     after(grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_1_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2339:6: ( Group )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2339:6: ( Group )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2340:1: Group
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getGroupKeyword_1_5()); 
                    match(input,Group,FOLLOW_Group_in_rule__GroupingMessages__Alternatives_15140); 
                     after(grammarAccess.getGroupingMessagesAccess().getGroupKeyword_1_5()); 

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
    // $ANTLR end "rule__GroupingMessages__Alternatives_1"


    // $ANTLR start "rule__Note__Alternatives_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2352:1: rule__Note__Alternatives_2 : ( ( ( rule__Note__Group_2_0__0 ) ) | ( ( rule__Note__Group_2_1__0 ) ) | ( ( rule__Note__Group_2_2__0 ) ) );
    public final void rule__Note__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2356:1: ( ( ( rule__Note__Group_2_0__0 ) ) | ( ( rule__Note__Group_2_1__0 ) ) | ( ( rule__Note__Group_2_2__0 ) ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case Right:
                {
                alt8=1;
                }
                break;
            case Left:
                {
                alt8=2;
                }
                break;
            case Over:
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2357:1: ( ( rule__Note__Group_2_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2357:1: ( ( rule__Note__Group_2_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2358:1: ( rule__Note__Group_2_0__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_2_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2359:1: ( rule__Note__Group_2_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2359:2: rule__Note__Group_2_0__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_2_0__0_in_rule__Note__Alternatives_25174);
                    rule__Note__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2363:6: ( ( rule__Note__Group_2_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2363:6: ( ( rule__Note__Group_2_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2364:1: ( rule__Note__Group_2_1__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_2_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2365:1: ( rule__Note__Group_2_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2365:2: rule__Note__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_2_1__0_in_rule__Note__Alternatives_25192);
                    rule__Note__Group_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2369:6: ( ( rule__Note__Group_2_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2369:6: ( ( rule__Note__Group_2_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2370:1: ( rule__Note__Group_2_2__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_2_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2371:1: ( rule__Note__Group_2_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2371:2: rule__Note__Group_2_2__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_2_2__0_in_rule__Note__Alternatives_25210);
                    rule__Note__Group_2_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_2_2()); 

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
    // $ANTLR end "rule__Note__Alternatives_2"


    // $ANTLR start "rule__Note__Alternatives_4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2380:1: rule__Note__Alternatives_4 : ( ( ( rule__Note__Group_4_0__0 ) ) | ( ( rule__Note__Group_4_1__0 ) ) );
    public final void rule__Note__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2384:1: ( ( ( rule__Note__Group_4_0__0 ) ) | ( ( rule__Note__Group_4_1__0 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Colon) ) {
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2385:1: ( ( rule__Note__Group_4_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2385:1: ( ( rule__Note__Group_4_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2386:1: ( rule__Note__Group_4_0__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_4_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2387:1: ( rule__Note__Group_4_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2387:2: rule__Note__Group_4_0__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_4_0__0_in_rule__Note__Alternatives_45243);
                    rule__Note__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2391:6: ( ( rule__Note__Group_4_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2391:6: ( ( rule__Note__Group_4_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2392:1: ( rule__Note__Group_4_1__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_4_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2393:1: ( rule__Note__Group_4_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2393:2: rule__Note__Group_4_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_4_1__0_in_rule__Note__Alternatives_45261);
                    rule__Note__Group_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_4_1()); 

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
    // $ANTLR end "rule__Note__Alternatives_4"


    // $ANTLR start "rule__Reference__Alternatives_4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2402:1: rule__Reference__Alternatives_4 : ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ( rule__Reference__Group_4_1__0 ) ) );
    public final void rule__Reference__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2406:1: ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ( rule__Reference__Group_4_1__0 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Colon) ) {
                alt10=1;
            }
            else if ( (LA10_0==End||LA10_0==RULE_NEWLINE) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2407:1: ( ( rule__Reference__Group_4_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2407:1: ( ( rule__Reference__Group_4_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2408:1: ( rule__Reference__Group_4_0__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_4_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2409:1: ( rule__Reference__Group_4_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2409:2: rule__Reference__Group_4_0__0
                    {
                    pushFollow(FOLLOW_rule__Reference__Group_4_0__0_in_rule__Reference__Alternatives_45294);
                    rule__Reference__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceAccess().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2413:6: ( ( rule__Reference__Group_4_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2413:6: ( ( rule__Reference__Group_4_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2414:1: ( rule__Reference__Group_4_1__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_4_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2415:1: ( rule__Reference__Group_4_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2415:2: rule__Reference__Group_4_1__0
                    {
                    pushFollow(FOLLOW_rule__Reference__Group_4_1__0_in_rule__Reference__Alternatives_45312);
                    rule__Reference__Group_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceAccess().getGroup_4_1()); 

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
    // $ANTLR end "rule__Reference__Alternatives_4"


    // $ANTLR start "rule__Space__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2424:1: rule__Space__Alternatives : ( ( VerticalLineVerticalLineVerticalLine ) | ( ( rule__Space__Group_1__0 ) ) );
    public final void rule__Space__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2428:1: ( ( VerticalLineVerticalLineVerticalLine ) | ( ( rule__Space__Group_1__0 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==VerticalLineVerticalLineVerticalLine) ) {
                alt11=1;
            }
            else if ( (LA11_0==VerticalLineVerticalLine) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2429:1: ( VerticalLineVerticalLineVerticalLine )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2429:1: ( VerticalLineVerticalLineVerticalLine )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2430:1: VerticalLineVerticalLineVerticalLine
                    {
                     before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 
                    match(input,VerticalLineVerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLineVerticalLine_in_rule__Space__Alternatives5346); 
                     after(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2437:6: ( ( rule__Space__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2437:6: ( ( rule__Space__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2438:1: ( rule__Space__Group_1__0 )
                    {
                     before(grammarAccess.getSpaceAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2439:1: ( rule__Space__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2439:2: rule__Space__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Space__Group_1__0_in_rule__Space__Alternatives5365);
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


    // $ANTLR start "rule__Deactivate__Alternatives_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2448:1: rule__Deactivate__Alternatives_0 : ( ( Deactivate ) | ( Destroy ) );
    public final void rule__Deactivate__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2452:1: ( ( Deactivate ) | ( Destroy ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Deactivate) ) {
                alt12=1;
            }
            else if ( (LA12_0==Destroy) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2453:1: ( Deactivate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2453:1: ( Deactivate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2454:1: Deactivate
                    {
                     before(grammarAccess.getDeactivateAccess().getDeactivateKeyword_0_0()); 
                    match(input,Deactivate,FOLLOW_Deactivate_in_rule__Deactivate__Alternatives_05399); 
                     after(grammarAccess.getDeactivateAccess().getDeactivateKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2461:6: ( Destroy )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2461:6: ( Destroy )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2462:1: Destroy
                    {
                     before(grammarAccess.getDeactivateAccess().getDestroyKeyword_0_1()); 
                    match(input,Destroy,FOLLOW_Destroy_in_rule__Deactivate__Alternatives_05419); 
                     after(grammarAccess.getDeactivateAccess().getDestroyKeyword_0_1()); 

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
    // $ANTLR end "rule__Deactivate__Alternatives_0"


    // $ANTLR start "rule__Diagram__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2476:1: rule__Diagram__Group__0 : rule__Diagram__Group__0__Impl rule__Diagram__Group__1 ;
    public final void rule__Diagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2480:1: ( rule__Diagram__Group__0__Impl rule__Diagram__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2481:2: rule__Diagram__Group__0__Impl rule__Diagram__Group__1
            {
            pushFollow(FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__05451);
            rule__Diagram__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__05454);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2488:1: rule__Diagram__Group__0__Impl : ( () ) ;
    public final void rule__Diagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2492:1: ( ( () ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2493:1: ( () )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2493:1: ( () )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2494:1: ()
            {
             before(grammarAccess.getDiagramAccess().getDiagramAction_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2495:1: ()
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2497:1: 
            {
            }

             after(grammarAccess.getDiagramAccess().getDiagramAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__0__Impl"


    // $ANTLR start "rule__Diagram__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2507:1: rule__Diagram__Group__1 : rule__Diagram__Group__1__Impl rule__Diagram__Group__2 ;
    public final void rule__Diagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2511:1: ( rule__Diagram__Group__1__Impl rule__Diagram__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2512:2: rule__Diagram__Group__1__Impl rule__Diagram__Group__2
            {
            pushFollow(FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__15512);
            rule__Diagram__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__15515);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2519:1: rule__Diagram__Group__1__Impl : ( RULE_START ) ;
    public final void rule__Diagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2523:1: ( ( RULE_START ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2524:1: ( RULE_START )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2524:1: ( RULE_START )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2525:1: RULE_START
            {
             before(grammarAccess.getDiagramAccess().getSTARTTerminalRuleCall_1()); 
            match(input,RULE_START,FOLLOW_RULE_START_in_rule__Diagram__Group__1__Impl5542); 
             after(grammarAccess.getDiagramAccess().getSTARTTerminalRuleCall_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2536:1: rule__Diagram__Group__2 : rule__Diagram__Group__2__Impl rule__Diagram__Group__3 ;
    public final void rule__Diagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2540:1: ( rule__Diagram__Group__2__Impl rule__Diagram__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2541:2: rule__Diagram__Group__2__Impl rule__Diagram__Group__3
            {
            pushFollow(FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__25571);
            rule__Diagram__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__3_in_rule__Diagram__Group__25574);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2548:1: rule__Diagram__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Diagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2552:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2553:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2553:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2554:1: RULE_NEWLINE
            {
             before(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__2__Impl5601); 
             after(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2565:1: rule__Diagram__Group__3 : rule__Diagram__Group__3__Impl rule__Diagram__Group__4 ;
    public final void rule__Diagram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2569:1: ( rule__Diagram__Group__3__Impl rule__Diagram__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2570:2: rule__Diagram__Group__3__Impl rule__Diagram__Group__4
            {
            pushFollow(FOLLOW_rule__Diagram__Group__3__Impl_in_rule__Diagram__Group__35630);
            rule__Diagram__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__4_in_rule__Diagram__Group__35633);
            rule__Diagram__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2577:1: rule__Diagram__Group__3__Impl : ( ( rule__Diagram__InstructionsAssignment_3 )* ) ;
    public final void rule__Diagram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2581:1: ( ( ( rule__Diagram__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2582:1: ( ( rule__Diagram__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2582:1: ( ( rule__Diagram__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2583:1: ( rule__Diagram__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getDiagramAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2584:1: ( rule__Diagram__InstructionsAssignment_3 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==Participant||(LA13_0>=Autonumber && LA13_0<=Deactivate)||(LA13_0>=Activate && LA13_0<=Database)||(LA13_0>=Control && LA13_0<=Destroy)||LA13_0==Newpage||(LA13_0>=Create && LA13_0<=Legend)||(LA13_0>=Actor && LA13_0<=Group)||LA13_0==Title||LA13_0==Hide||(LA13_0>=Loop && LA13_0<=Note)||LA13_0==FullStopFullStopFullStop||(LA13_0>=Alt && LA13_0<=Box)||(LA13_0>=Opt && LA13_0<=VerticalLineVerticalLineVerticalLine)||LA13_0==EqualsSignEqualsSign||LA13_0==VerticalLineVerticalLine||LA13_0==RULE_NEWLINE||LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2584:2: rule__Diagram__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Diagram__InstructionsAssignment_3_in_rule__Diagram__Group__3__Impl5660);
            	    rule__Diagram__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getDiagramAccess().getInstructionsAssignment_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Diagram__Group__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2594:1: rule__Diagram__Group__4 : rule__Diagram__Group__4__Impl rule__Diagram__Group__5 ;
    public final void rule__Diagram__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2598:1: ( rule__Diagram__Group__4__Impl rule__Diagram__Group__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2599:2: rule__Diagram__Group__4__Impl rule__Diagram__Group__5
            {
            pushFollow(FOLLOW_rule__Diagram__Group__4__Impl_in_rule__Diagram__Group__45691);
            rule__Diagram__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__5_in_rule__Diagram__Group__45694);
            rule__Diagram__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__4"


    // $ANTLR start "rule__Diagram__Group__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2606:1: rule__Diagram__Group__4__Impl : ( RULE_END ) ;
    public final void rule__Diagram__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2610:1: ( ( RULE_END ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2611:1: ( RULE_END )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2611:1: ( RULE_END )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2612:1: RULE_END
            {
             before(grammarAccess.getDiagramAccess().getENDTerminalRuleCall_4()); 
            match(input,RULE_END,FOLLOW_RULE_END_in_rule__Diagram__Group__4__Impl5721); 
             after(grammarAccess.getDiagramAccess().getENDTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__4__Impl"


    // $ANTLR start "rule__Diagram__Group__5"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2623:1: rule__Diagram__Group__5 : rule__Diagram__Group__5__Impl ;
    public final void rule__Diagram__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2627:1: ( rule__Diagram__Group__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2628:2: rule__Diagram__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Diagram__Group__5__Impl_in_rule__Diagram__Group__55750);
            rule__Diagram__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__5"


    // $ANTLR start "rule__Diagram__Group__5__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2634:1: rule__Diagram__Group__5__Impl : ( ( RULE_NEWLINE )* ) ;
    public final void rule__Diagram__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2638:1: ( ( ( RULE_NEWLINE )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2639:1: ( ( RULE_NEWLINE )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2639:1: ( ( RULE_NEWLINE )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2640:1: ( RULE_NEWLINE )*
            {
             before(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_5()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2641:1: ( RULE_NEWLINE )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_NEWLINE) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2641:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__5__Impl5778); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__5__Impl"


    // $ANTLR start "rule__Instruction__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2663:1: rule__Instruction__Group__0 : rule__Instruction__Group__0__Impl rule__Instruction__Group__1 ;
    public final void rule__Instruction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2667:1: ( rule__Instruction__Group__0__Impl rule__Instruction__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2668:2: rule__Instruction__Group__0__Impl rule__Instruction__Group__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group__0__Impl_in_rule__Instruction__Group__05821);
            rule__Instruction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group__1_in_rule__Instruction__Group__05824);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2675:1: rule__Instruction__Group__0__Impl : ( ( rule__Instruction__Alternatives_0 )? ) ;
    public final void rule__Instruction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2679:1: ( ( ( rule__Instruction__Alternatives_0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2680:1: ( ( rule__Instruction__Alternatives_0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2680:1: ( ( rule__Instruction__Alternatives_0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2681:1: ( rule__Instruction__Alternatives_0 )?
            {
             before(grammarAccess.getInstructionAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2682:1: ( rule__Instruction__Alternatives_0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==Participant||(LA15_0>=Autonumber && LA15_0<=Deactivate)||(LA15_0>=Activate && LA15_0<=Database)||(LA15_0>=Control && LA15_0<=Destroy)||LA15_0==Newpage||(LA15_0>=Create && LA15_0<=Legend)||(LA15_0>=Actor && LA15_0<=Group)||LA15_0==Title||LA15_0==Hide||(LA15_0>=Loop && LA15_0<=Note)||LA15_0==FullStopFullStopFullStop||(LA15_0>=Alt && LA15_0<=Box)||(LA15_0>=Opt && LA15_0<=VerticalLineVerticalLineVerticalLine)||LA15_0==EqualsSignEqualsSign||LA15_0==VerticalLineVerticalLine||LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2682:2: rule__Instruction__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Alternatives_0_in_rule__Instruction__Group__0__Impl5851);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2692:1: rule__Instruction__Group__1 : rule__Instruction__Group__1__Impl ;
    public final void rule__Instruction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2696:1: ( rule__Instruction__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2697:2: rule__Instruction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group__1__Impl_in_rule__Instruction__Group__15882);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2703:1: rule__Instruction__Group__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Instruction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2707:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2708:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2708:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2709:1: RULE_NEWLINE
            {
             before(grammarAccess.getInstructionAccess().getNEWLINETerminalRuleCall_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Instruction__Group__1__Impl5909); 
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


    // $ANTLR start "rule__Instruction__Group_0_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2724:1: rule__Instruction__Group_0_1__0 : rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1 ;
    public final void rule__Instruction__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2728:1: ( rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2729:2: rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_1__0__Impl_in_rule__Instruction__Group_0_1__05942);
            rule__Instruction__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_1__1_in_rule__Instruction__Group_0_1__05945);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2736:1: rule__Instruction__Group_0_1__0__Impl : ( ruleDefinition ) ;
    public final void rule__Instruction__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2740:1: ( ( ruleDefinition ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2741:1: ( ruleDefinition )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2741:1: ( ruleDefinition )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2742:1: ruleDefinition
            {
             before(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Instruction__Group_0_1__0__Impl5972);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2753:1: rule__Instruction__Group_0_1__1 : rule__Instruction__Group_0_1__1__Impl ;
    public final void rule__Instruction__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2757:1: ( rule__Instruction__Group_0_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2758:2: rule__Instruction__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_1__1__Impl_in_rule__Instruction__Group_0_1__16001);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2764:1: rule__Instruction__Group_0_1__1__Impl : ( ( ruleColor )? ) ;
    public final void rule__Instruction__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2768:1: ( ( ( ruleColor )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2769:1: ( ( ruleColor )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2769:1: ( ( ruleColor )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2770:1: ( ruleColor )?
            {
             before(grammarAccess.getInstructionAccess().getColorParserRuleCall_0_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2771:1: ( ruleColor )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==NumberSign) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2771:3: ruleColor
                    {
                    pushFollow(FOLLOW_ruleColor_in_rule__Instruction__Group_0_1__1__Impl6029);
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


    // $ANTLR start "rule__Arrow__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2785:1: rule__Arrow__Group__0 : rule__Arrow__Group__0__Impl rule__Arrow__Group__1 ;
    public final void rule__Arrow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2789:1: ( rule__Arrow__Group__0__Impl rule__Arrow__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2790:2: rule__Arrow__Group__0__Impl rule__Arrow__Group__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group__0__Impl_in_rule__Arrow__Group__06064);
            rule__Arrow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group__1_in_rule__Arrow__Group__06067);
            rule__Arrow__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__0"


    // $ANTLR start "rule__Arrow__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2797:1: rule__Arrow__Group__0__Impl : ( ( rule__Arrow__NameAssignment_0 ) ) ;
    public final void rule__Arrow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2801:1: ( ( ( rule__Arrow__NameAssignment_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2802:1: ( ( rule__Arrow__NameAssignment_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2802:1: ( ( rule__Arrow__NameAssignment_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2803:1: ( rule__Arrow__NameAssignment_0 )
            {
             before(grammarAccess.getArrowAccess().getNameAssignment_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2804:1: ( rule__Arrow__NameAssignment_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2804:2: rule__Arrow__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Arrow__NameAssignment_0_in_rule__Arrow__Group__0__Impl6094);
            rule__Arrow__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__0__Impl"


    // $ANTLR start "rule__Arrow__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2814:1: rule__Arrow__Group__1 : rule__Arrow__Group__1__Impl rule__Arrow__Group__2 ;
    public final void rule__Arrow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2818:1: ( rule__Arrow__Group__1__Impl rule__Arrow__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2819:2: rule__Arrow__Group__1__Impl rule__Arrow__Group__2
            {
            pushFollow(FOLLOW_rule__Arrow__Group__1__Impl_in_rule__Arrow__Group__16124);
            rule__Arrow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group__2_in_rule__Arrow__Group__16127);
            rule__Arrow__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__1"


    // $ANTLR start "rule__Arrow__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2826:1: rule__Arrow__Group__1__Impl : ( RULE_SEQUENCE ) ;
    public final void rule__Arrow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2830:1: ( ( RULE_SEQUENCE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2831:1: ( RULE_SEQUENCE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2831:1: ( RULE_SEQUENCE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2832:1: RULE_SEQUENCE
            {
             before(grammarAccess.getArrowAccess().getSEQUENCETerminalRuleCall_1()); 
            match(input,RULE_SEQUENCE,FOLLOW_RULE_SEQUENCE_in_rule__Arrow__Group__1__Impl6154); 
             after(grammarAccess.getArrowAccess().getSEQUENCETerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__1__Impl"


    // $ANTLR start "rule__Arrow__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2843:1: rule__Arrow__Group__2 : rule__Arrow__Group__2__Impl rule__Arrow__Group__3 ;
    public final void rule__Arrow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2847:1: ( rule__Arrow__Group__2__Impl rule__Arrow__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2848:2: rule__Arrow__Group__2__Impl rule__Arrow__Group__3
            {
            pushFollow(FOLLOW_rule__Arrow__Group__2__Impl_in_rule__Arrow__Group__26183);
            rule__Arrow__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group__3_in_rule__Arrow__Group__26186);
            rule__Arrow__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__2"


    // $ANTLR start "rule__Arrow__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2855:1: rule__Arrow__Group__2__Impl : ( ( rule__Arrow__NameAssignment_2 ) ) ;
    public final void rule__Arrow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2859:1: ( ( ( rule__Arrow__NameAssignment_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2860:1: ( ( rule__Arrow__NameAssignment_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2860:1: ( ( rule__Arrow__NameAssignment_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2861:1: ( rule__Arrow__NameAssignment_2 )
            {
             before(grammarAccess.getArrowAccess().getNameAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2862:1: ( rule__Arrow__NameAssignment_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2862:2: rule__Arrow__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__Arrow__NameAssignment_2_in_rule__Arrow__Group__2__Impl6213);
            rule__Arrow__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__2__Impl"


    // $ANTLR start "rule__Arrow__Group__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2872:1: rule__Arrow__Group__3 : rule__Arrow__Group__3__Impl ;
    public final void rule__Arrow__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2876:1: ( rule__Arrow__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2877:2: rule__Arrow__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group__3__Impl_in_rule__Arrow__Group__36243);
            rule__Arrow__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__3"


    // $ANTLR start "rule__Arrow__Group__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2883:1: rule__Arrow__Group__3__Impl : ( ( rule__Arrow__Group_3__0 )? ) ;
    public final void rule__Arrow__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2887:1: ( ( ( rule__Arrow__Group_3__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2888:1: ( ( rule__Arrow__Group_3__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2888:1: ( ( rule__Arrow__Group_3__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2889:1: ( rule__Arrow__Group_3__0 )?
            {
             before(grammarAccess.getArrowAccess().getGroup_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2890:1: ( rule__Arrow__Group_3__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==Colon) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2890:2: rule__Arrow__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Arrow__Group_3__0_in_rule__Arrow__Group__3__Impl6270);
                    rule__Arrow__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getArrowAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__3__Impl"


    // $ANTLR start "rule__Arrow__Group_3__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2908:1: rule__Arrow__Group_3__0 : rule__Arrow__Group_3__0__Impl rule__Arrow__Group_3__1 ;
    public final void rule__Arrow__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2912:1: ( rule__Arrow__Group_3__0__Impl rule__Arrow__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2913:2: rule__Arrow__Group_3__0__Impl rule__Arrow__Group_3__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group_3__0__Impl_in_rule__Arrow__Group_3__06309);
            rule__Arrow__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_3__1_in_rule__Arrow__Group_3__06312);
            rule__Arrow__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_3__0"


    // $ANTLR start "rule__Arrow__Group_3__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2920:1: rule__Arrow__Group_3__0__Impl : ( Colon ) ;
    public final void rule__Arrow__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2924:1: ( ( Colon ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2925:1: ( Colon )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2925:1: ( Colon )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2926:1: Colon
            {
             before(grammarAccess.getArrowAccess().getColonKeyword_3_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Arrow__Group_3__0__Impl6340); 
             after(grammarAccess.getArrowAccess().getColonKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_3__0__Impl"


    // $ANTLR start "rule__Arrow__Group_3__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2939:1: rule__Arrow__Group_3__1 : rule__Arrow__Group_3__1__Impl ;
    public final void rule__Arrow__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2943:1: ( rule__Arrow__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2944:2: rule__Arrow__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group_3__1__Impl_in_rule__Arrow__Group_3__16371);
            rule__Arrow__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_3__1"


    // $ANTLR start "rule__Arrow__Group_3__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2950:1: rule__Arrow__Group_3__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Arrow__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2954:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2955:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2955:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2956:1: ( RULE_ID )*
            {
             before(grammarAccess.getArrowAccess().getIDTerminalRuleCall_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2957:1: ( RULE_ID )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2957:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Arrow__Group_3__1__Impl6399); 

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getArrowAccess().getIDTerminalRuleCall_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_3__1__Impl"


    // $ANTLR start "rule__Definition__Group_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2971:1: rule__Definition__Group_0__0 : rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 ;
    public final void rule__Definition__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2975:1: ( rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2976:2: rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__06434);
            rule__Definition__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__06437);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2983:1: rule__Definition__Group_0__0__Impl : ( Actor ) ;
    public final void rule__Definition__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2987:1: ( ( Actor ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2988:1: ( Actor )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2988:1: ( Actor )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2989:1: Actor
            {
             before(grammarAccess.getDefinitionAccess().getActorKeyword_0_0()); 
            match(input,Actor,FOLLOW_Actor_in_rule__Definition__Group_0__0__Impl6465); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3002:1: rule__Definition__Group_0__1 : rule__Definition__Group_0__1__Impl ;
    public final void rule__Definition__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3006:1: ( rule__Definition__Group_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3007:2: rule__Definition__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__16496);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3013:1: rule__Definition__Group_0__1__Impl : ( ( rule__Definition__NameAssignment_0_1 ) ) ;
    public final void rule__Definition__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3017:1: ( ( ( rule__Definition__NameAssignment_0_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3018:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3018:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3019:1: ( rule__Definition__NameAssignment_0_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3020:1: ( rule__Definition__NameAssignment_0_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3020:2: rule__Definition__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl6523);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3034:1: rule__Definition__Group_1__0 : rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 ;
    public final void rule__Definition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3038:1: ( rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3039:2: rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__06557);
            rule__Definition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__06560);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3046:1: rule__Definition__Group_1__0__Impl : ( Boundary ) ;
    public final void rule__Definition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3050:1: ( ( Boundary ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3051:1: ( Boundary )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3051:1: ( Boundary )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3052:1: Boundary
            {
             before(grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0()); 
            match(input,Boundary,FOLLOW_Boundary_in_rule__Definition__Group_1__0__Impl6588); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3065:1: rule__Definition__Group_1__1 : rule__Definition__Group_1__1__Impl ;
    public final void rule__Definition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3069:1: ( rule__Definition__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3070:2: rule__Definition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__16619);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3076:1: rule__Definition__Group_1__1__Impl : ( ( rule__Definition__NameAssignment_1_1 ) ) ;
    public final void rule__Definition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3080:1: ( ( ( rule__Definition__NameAssignment_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3081:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3081:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3082:1: ( rule__Definition__NameAssignment_1_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3083:1: ( rule__Definition__NameAssignment_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3083:2: rule__Definition__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl6646);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3097:1: rule__Definition__Group_2__0 : rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 ;
    public final void rule__Definition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3101:1: ( rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3102:2: rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__06680);
            rule__Definition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__06683);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3109:1: rule__Definition__Group_2__0__Impl : ( Control ) ;
    public final void rule__Definition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3113:1: ( ( Control ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3114:1: ( Control )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3114:1: ( Control )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3115:1: Control
            {
             before(grammarAccess.getDefinitionAccess().getControlKeyword_2_0()); 
            match(input,Control,FOLLOW_Control_in_rule__Definition__Group_2__0__Impl6711); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3128:1: rule__Definition__Group_2__1 : rule__Definition__Group_2__1__Impl ;
    public final void rule__Definition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3132:1: ( rule__Definition__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3133:2: rule__Definition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__16742);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3139:1: rule__Definition__Group_2__1__Impl : ( ( rule__Definition__NameAssignment_2_1 ) ) ;
    public final void rule__Definition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3143:1: ( ( ( rule__Definition__NameAssignment_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3144:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3144:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3145:1: ( rule__Definition__NameAssignment_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3146:1: ( rule__Definition__NameAssignment_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3146:2: rule__Definition__NameAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl6769);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3160:1: rule__Definition__Group_3__0 : rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 ;
    public final void rule__Definition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3164:1: ( rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3165:2: rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__06803);
            rule__Definition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__06806);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3172:1: rule__Definition__Group_3__0__Impl : ( Entity ) ;
    public final void rule__Definition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3176:1: ( ( Entity ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3177:1: ( Entity )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3177:1: ( Entity )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3178:1: Entity
            {
             before(grammarAccess.getDefinitionAccess().getEntityKeyword_3_0()); 
            match(input,Entity,FOLLOW_Entity_in_rule__Definition__Group_3__0__Impl6834); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3191:1: rule__Definition__Group_3__1 : rule__Definition__Group_3__1__Impl ;
    public final void rule__Definition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3195:1: ( rule__Definition__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3196:2: rule__Definition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__16865);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3202:1: rule__Definition__Group_3__1__Impl : ( ( rule__Definition__NameAssignment_3_1 ) ) ;
    public final void rule__Definition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3206:1: ( ( ( rule__Definition__NameAssignment_3_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3207:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3207:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3208:1: ( rule__Definition__NameAssignment_3_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3209:1: ( rule__Definition__NameAssignment_3_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3209:2: rule__Definition__NameAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl6892);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3223:1: rule__Definition__Group_4__0 : rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 ;
    public final void rule__Definition__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3227:1: ( rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3228:2: rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__06926);
            rule__Definition__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__06929);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3235:1: rule__Definition__Group_4__0__Impl : ( Database ) ;
    public final void rule__Definition__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3239:1: ( ( Database ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3240:1: ( Database )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3240:1: ( Database )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3241:1: Database
            {
             before(grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0()); 
            match(input,Database,FOLLOW_Database_in_rule__Definition__Group_4__0__Impl6957); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3254:1: rule__Definition__Group_4__1 : rule__Definition__Group_4__1__Impl ;
    public final void rule__Definition__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3258:1: ( rule__Definition__Group_4__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3259:2: rule__Definition__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__16988);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3265:1: rule__Definition__Group_4__1__Impl : ( ( rule__Definition__NameAssignment_4_1 ) ) ;
    public final void rule__Definition__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3269:1: ( ( ( rule__Definition__NameAssignment_4_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3270:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3270:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3271:1: ( rule__Definition__NameAssignment_4_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_4_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3272:1: ( rule__Definition__NameAssignment_4_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3272:2: rule__Definition__NameAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl7015);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3286:1: rule__Definition__Group_5__0 : rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1 ;
    public final void rule__Definition__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3290:1: ( rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3291:2: rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5__0__Impl_in_rule__Definition__Group_5__07049);
            rule__Definition__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5__1_in_rule__Definition__Group_5__07052);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3298:1: rule__Definition__Group_5__0__Impl : ( Participant ) ;
    public final void rule__Definition__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3302:1: ( ( Participant ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3303:1: ( Participant )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3303:1: ( Participant )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3304:1: Participant
            {
             before(grammarAccess.getDefinitionAccess().getParticipantKeyword_5_0()); 
            match(input,Participant,FOLLOW_Participant_in_rule__Definition__Group_5__0__Impl7080); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3317:1: rule__Definition__Group_5__1 : rule__Definition__Group_5__1__Impl rule__Definition__Group_5__2 ;
    public final void rule__Definition__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3321:1: ( rule__Definition__Group_5__1__Impl rule__Definition__Group_5__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3322:2: rule__Definition__Group_5__1__Impl rule__Definition__Group_5__2
            {
            pushFollow(FOLLOW_rule__Definition__Group_5__1__Impl_in_rule__Definition__Group_5__17111);
            rule__Definition__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5__2_in_rule__Definition__Group_5__17114);
            rule__Definition__Group_5__2();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3329:1: rule__Definition__Group_5__1__Impl : ( ( rule__Definition__NameAssignment_5_1 ) ) ;
    public final void rule__Definition__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3333:1: ( ( ( rule__Definition__NameAssignment_5_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3334:1: ( ( rule__Definition__NameAssignment_5_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3334:1: ( ( rule__Definition__NameAssignment_5_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3335:1: ( rule__Definition__NameAssignment_5_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_5_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3336:1: ( rule__Definition__NameAssignment_5_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3336:2: rule__Definition__NameAssignment_5_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_5_1_in_rule__Definition__Group_5__1__Impl7141);
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


    // $ANTLR start "rule__Definition__Group_5__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3346:1: rule__Definition__Group_5__2 : rule__Definition__Group_5__2__Impl ;
    public final void rule__Definition__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3350:1: ( rule__Definition__Group_5__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3351:2: rule__Definition__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5__2__Impl_in_rule__Definition__Group_5__27171);
            rule__Definition__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5__2"


    // $ANTLR start "rule__Definition__Group_5__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3357:1: rule__Definition__Group_5__2__Impl : ( ( rule__Definition__Group_5_2__0 )? ) ;
    public final void rule__Definition__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3361:1: ( ( ( rule__Definition__Group_5_2__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3362:1: ( ( rule__Definition__Group_5_2__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3362:1: ( ( rule__Definition__Group_5_2__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3363:1: ( rule__Definition__Group_5_2__0 )?
            {
             before(grammarAccess.getDefinitionAccess().getGroup_5_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3364:1: ( rule__Definition__Group_5_2__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LessThanSignLessThanSign) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3364:2: rule__Definition__Group_5_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5_2__0_in_rule__Definition__Group_5__2__Impl7198);
                    rule__Definition__Group_5_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDefinitionAccess().getGroup_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5__2__Impl"


    // $ANTLR start "rule__Definition__Group_5_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3380:1: rule__Definition__Group_5_2__0 : rule__Definition__Group_5_2__0__Impl rule__Definition__Group_5_2__1 ;
    public final void rule__Definition__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3384:1: ( rule__Definition__Group_5_2__0__Impl rule__Definition__Group_5_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3385:2: rule__Definition__Group_5_2__0__Impl rule__Definition__Group_5_2__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2__0__Impl_in_rule__Definition__Group_5_2__07235);
            rule__Definition__Group_5_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2__1_in_rule__Definition__Group_5_2__07238);
            rule__Definition__Group_5_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__0"


    // $ANTLR start "rule__Definition__Group_5_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3392:1: rule__Definition__Group_5_2__0__Impl : ( LessThanSignLessThanSign ) ;
    public final void rule__Definition__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3396:1: ( ( LessThanSignLessThanSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3397:1: ( LessThanSignLessThanSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3397:1: ( LessThanSignLessThanSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3398:1: LessThanSignLessThanSign
            {
             before(grammarAccess.getDefinitionAccess().getLessThanSignLessThanSignKeyword_5_2_0()); 
            match(input,LessThanSignLessThanSign,FOLLOW_LessThanSignLessThanSign_in_rule__Definition__Group_5_2__0__Impl7266); 
             after(grammarAccess.getDefinitionAccess().getLessThanSignLessThanSignKeyword_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__0__Impl"


    // $ANTLR start "rule__Definition__Group_5_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3411:1: rule__Definition__Group_5_2__1 : rule__Definition__Group_5_2__1__Impl rule__Definition__Group_5_2__2 ;
    public final void rule__Definition__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3415:1: ( rule__Definition__Group_5_2__1__Impl rule__Definition__Group_5_2__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3416:2: rule__Definition__Group_5_2__1__Impl rule__Definition__Group_5_2__2
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2__1__Impl_in_rule__Definition__Group_5_2__17297);
            rule__Definition__Group_5_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2__2_in_rule__Definition__Group_5_2__17300);
            rule__Definition__Group_5_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__1"


    // $ANTLR start "rule__Definition__Group_5_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3423:1: rule__Definition__Group_5_2__1__Impl : ( ( rule__Definition__Alternatives_5_2_1 ) ) ;
    public final void rule__Definition__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3427:1: ( ( ( rule__Definition__Alternatives_5_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3428:1: ( ( rule__Definition__Alternatives_5_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3428:1: ( ( rule__Definition__Alternatives_5_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3429:1: ( rule__Definition__Alternatives_5_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getAlternatives_5_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3430:1: ( rule__Definition__Alternatives_5_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3430:2: rule__Definition__Alternatives_5_2_1
            {
            pushFollow(FOLLOW_rule__Definition__Alternatives_5_2_1_in_rule__Definition__Group_5_2__1__Impl7327);
            rule__Definition__Alternatives_5_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getAlternatives_5_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__1__Impl"


    // $ANTLR start "rule__Definition__Group_5_2__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3440:1: rule__Definition__Group_5_2__2 : rule__Definition__Group_5_2__2__Impl ;
    public final void rule__Definition__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3444:1: ( rule__Definition__Group_5_2__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3445:2: rule__Definition__Group_5_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2__2__Impl_in_rule__Definition__Group_5_2__27357);
            rule__Definition__Group_5_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__2"


    // $ANTLR start "rule__Definition__Group_5_2__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3451:1: rule__Definition__Group_5_2__2__Impl : ( GreaterThanSignGreaterThanSign ) ;
    public final void rule__Definition__Group_5_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3455:1: ( ( GreaterThanSignGreaterThanSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3456:1: ( GreaterThanSignGreaterThanSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3456:1: ( GreaterThanSignGreaterThanSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3457:1: GreaterThanSignGreaterThanSign
            {
             before(grammarAccess.getDefinitionAccess().getGreaterThanSignGreaterThanSignKeyword_5_2_2()); 
            match(input,GreaterThanSignGreaterThanSign,FOLLOW_GreaterThanSignGreaterThanSign_in_rule__Definition__Group_5_2__2__Impl7385); 
             after(grammarAccess.getDefinitionAccess().getGreaterThanSignGreaterThanSignKeyword_5_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__2__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3476:1: rule__Definition__Group_5_2_1_0__0 : rule__Definition__Group_5_2_1_0__0__Impl rule__Definition__Group_5_2_1_0__1 ;
    public final void rule__Definition__Group_5_2_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3480:1: ( rule__Definition__Group_5_2_1_0__0__Impl rule__Definition__Group_5_2_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3481:2: rule__Definition__Group_5_2_1_0__0__Impl rule__Definition__Group_5_2_1_0__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__0__Impl_in_rule__Definition__Group_5_2_1_0__07422);
            rule__Definition__Group_5_2_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__1_in_rule__Definition__Group_5_2_1_0__07425);
            rule__Definition__Group_5_2_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_0__0"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3488:1: rule__Definition__Group_5_2_1_0__0__Impl : ( LeftParenthesis ) ;
    public final void rule__Definition__Group_5_2_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3492:1: ( ( LeftParenthesis ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3493:1: ( LeftParenthesis )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3493:1: ( LeftParenthesis )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3494:1: LeftParenthesis
            {
             before(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_0_0()); 
            match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_rule__Definition__Group_5_2_1_0__0__Impl7453); 
             after(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_0__0__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3507:1: rule__Definition__Group_5_2_1_0__1 : rule__Definition__Group_5_2_1_0__1__Impl rule__Definition__Group_5_2_1_0__2 ;
    public final void rule__Definition__Group_5_2_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3511:1: ( rule__Definition__Group_5_2_1_0__1__Impl rule__Definition__Group_5_2_1_0__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3512:2: rule__Definition__Group_5_2_1_0__1__Impl rule__Definition__Group_5_2_1_0__2
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__1__Impl_in_rule__Definition__Group_5_2_1_0__17484);
            rule__Definition__Group_5_2_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__2_in_rule__Definition__Group_5_2_1_0__17487);
            rule__Definition__Group_5_2_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_0__1"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3519:1: rule__Definition__Group_5_2_1_0__1__Impl : ( RULE_ID ) ;
    public final void rule__Definition__Group_5_2_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3523:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3524:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3524:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3525:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__Group_5_2_1_0__1__Impl7514); 
             after(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_0__1__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3536:1: rule__Definition__Group_5_2_1_0__2 : rule__Definition__Group_5_2_1_0__2__Impl rule__Definition__Group_5_2_1_0__3 ;
    public final void rule__Definition__Group_5_2_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3540:1: ( rule__Definition__Group_5_2_1_0__2__Impl rule__Definition__Group_5_2_1_0__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3541:2: rule__Definition__Group_5_2_1_0__2__Impl rule__Definition__Group_5_2_1_0__3
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__2__Impl_in_rule__Definition__Group_5_2_1_0__27543);
            rule__Definition__Group_5_2_1_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__3_in_rule__Definition__Group_5_2_1_0__27546);
            rule__Definition__Group_5_2_1_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_0__2"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3548:1: rule__Definition__Group_5_2_1_0__2__Impl : ( Comma ) ;
    public final void rule__Definition__Group_5_2_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3552:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3553:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3553:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3554:1: Comma
            {
             before(grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_0_2()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Definition__Group_5_2_1_0__2__Impl7574); 
             after(grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_0__2__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3567:1: rule__Definition__Group_5_2_1_0__3 : rule__Definition__Group_5_2_1_0__3__Impl rule__Definition__Group_5_2_1_0__4 ;
    public final void rule__Definition__Group_5_2_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3571:1: ( rule__Definition__Group_5_2_1_0__3__Impl rule__Definition__Group_5_2_1_0__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3572:2: rule__Definition__Group_5_2_1_0__3__Impl rule__Definition__Group_5_2_1_0__4
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__3__Impl_in_rule__Definition__Group_5_2_1_0__37605);
            rule__Definition__Group_5_2_1_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__4_in_rule__Definition__Group_5_2_1_0__37608);
            rule__Definition__Group_5_2_1_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_0__3"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3579:1: rule__Definition__Group_5_2_1_0__3__Impl : ( ruleColor ) ;
    public final void rule__Definition__Group_5_2_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3583:1: ( ( ruleColor ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3584:1: ( ruleColor )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3584:1: ( ruleColor )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3585:1: ruleColor
            {
             before(grammarAccess.getDefinitionAccess().getColorParserRuleCall_5_2_1_0_3()); 
            pushFollow(FOLLOW_ruleColor_in_rule__Definition__Group_5_2_1_0__3__Impl7635);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getColorParserRuleCall_5_2_1_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_0__3__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3596:1: rule__Definition__Group_5_2_1_0__4 : rule__Definition__Group_5_2_1_0__4__Impl ;
    public final void rule__Definition__Group_5_2_1_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3600:1: ( rule__Definition__Group_5_2_1_0__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3601:2: rule__Definition__Group_5_2_1_0__4__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__4__Impl_in_rule__Definition__Group_5_2_1_0__47664);
            rule__Definition__Group_5_2_1_0__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_0__4"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3607:1: rule__Definition__Group_5_2_1_0__4__Impl : ( RightParenthesis ) ;
    public final void rule__Definition__Group_5_2_1_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3611:1: ( ( RightParenthesis ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3612:1: ( RightParenthesis )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3612:1: ( RightParenthesis )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3613:1: RightParenthesis
            {
             before(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_0_4()); 
            match(input,RightParenthesis,FOLLOW_RightParenthesis_in_rule__Definition__Group_5_2_1_0__4__Impl7692); 
             after(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_0__4__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3636:1: rule__Definition__Group_5_2_1_1__0 : rule__Definition__Group_5_2_1_1__0__Impl rule__Definition__Group_5_2_1_1__1 ;
    public final void rule__Definition__Group_5_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3640:1: ( rule__Definition__Group_5_2_1_1__0__Impl rule__Definition__Group_5_2_1_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3641:2: rule__Definition__Group_5_2_1_1__0__Impl rule__Definition__Group_5_2_1_1__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__0__Impl_in_rule__Definition__Group_5_2_1_1__07733);
            rule__Definition__Group_5_2_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__1_in_rule__Definition__Group_5_2_1_1__07736);
            rule__Definition__Group_5_2_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_1__0"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3648:1: rule__Definition__Group_5_2_1_1__0__Impl : ( LeftParenthesis ) ;
    public final void rule__Definition__Group_5_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3652:1: ( ( LeftParenthesis ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3653:1: ( LeftParenthesis )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3653:1: ( LeftParenthesis )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3654:1: LeftParenthesis
            {
             before(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_1_0()); 
            match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_rule__Definition__Group_5_2_1_1__0__Impl7764); 
             after(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_1__0__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3667:1: rule__Definition__Group_5_2_1_1__1 : rule__Definition__Group_5_2_1_1__1__Impl rule__Definition__Group_5_2_1_1__2 ;
    public final void rule__Definition__Group_5_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3671:1: ( rule__Definition__Group_5_2_1_1__1__Impl rule__Definition__Group_5_2_1_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3672:2: rule__Definition__Group_5_2_1_1__1__Impl rule__Definition__Group_5_2_1_1__2
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__1__Impl_in_rule__Definition__Group_5_2_1_1__17795);
            rule__Definition__Group_5_2_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__2_in_rule__Definition__Group_5_2_1_1__17798);
            rule__Definition__Group_5_2_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_1__1"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3679:1: rule__Definition__Group_5_2_1_1__1__Impl : ( RULE_ID ) ;
    public final void rule__Definition__Group_5_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3683:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3684:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3684:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3685:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__Group_5_2_1_1__1__Impl7825); 
             after(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_1__1__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3696:1: rule__Definition__Group_5_2_1_1__2 : rule__Definition__Group_5_2_1_1__2__Impl rule__Definition__Group_5_2_1_1__3 ;
    public final void rule__Definition__Group_5_2_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3700:1: ( rule__Definition__Group_5_2_1_1__2__Impl rule__Definition__Group_5_2_1_1__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3701:2: rule__Definition__Group_5_2_1_1__2__Impl rule__Definition__Group_5_2_1_1__3
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__2__Impl_in_rule__Definition__Group_5_2_1_1__27854);
            rule__Definition__Group_5_2_1_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__3_in_rule__Definition__Group_5_2_1_1__27857);
            rule__Definition__Group_5_2_1_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_1__2"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3708:1: rule__Definition__Group_5_2_1_1__2__Impl : ( Comma ) ;
    public final void rule__Definition__Group_5_2_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3712:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3713:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3713:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3714:1: Comma
            {
             before(grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_1_2()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Definition__Group_5_2_1_1__2__Impl7885); 
             after(grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_1__2__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3727:1: rule__Definition__Group_5_2_1_1__3 : rule__Definition__Group_5_2_1_1__3__Impl rule__Definition__Group_5_2_1_1__4 ;
    public final void rule__Definition__Group_5_2_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3731:1: ( rule__Definition__Group_5_2_1_1__3__Impl rule__Definition__Group_5_2_1_1__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3732:2: rule__Definition__Group_5_2_1_1__3__Impl rule__Definition__Group_5_2_1_1__4
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__3__Impl_in_rule__Definition__Group_5_2_1_1__37916);
            rule__Definition__Group_5_2_1_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__4_in_rule__Definition__Group_5_2_1_1__37919);
            rule__Definition__Group_5_2_1_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_1__3"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3739:1: rule__Definition__Group_5_2_1_1__3__Impl : ( ruleColor ) ;
    public final void rule__Definition__Group_5_2_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3743:1: ( ( ruleColor ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3744:1: ( ruleColor )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3744:1: ( ruleColor )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3745:1: ruleColor
            {
             before(grammarAccess.getDefinitionAccess().getColorParserRuleCall_5_2_1_1_3()); 
            pushFollow(FOLLOW_ruleColor_in_rule__Definition__Group_5_2_1_1__3__Impl7946);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getColorParserRuleCall_5_2_1_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_1__3__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3756:1: rule__Definition__Group_5_2_1_1__4 : rule__Definition__Group_5_2_1_1__4__Impl rule__Definition__Group_5_2_1_1__5 ;
    public final void rule__Definition__Group_5_2_1_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3760:1: ( rule__Definition__Group_5_2_1_1__4__Impl rule__Definition__Group_5_2_1_1__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3761:2: rule__Definition__Group_5_2_1_1__4__Impl rule__Definition__Group_5_2_1_1__5
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__4__Impl_in_rule__Definition__Group_5_2_1_1__47975);
            rule__Definition__Group_5_2_1_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__5_in_rule__Definition__Group_5_2_1_1__47978);
            rule__Definition__Group_5_2_1_1__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_1__4"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3768:1: rule__Definition__Group_5_2_1_1__4__Impl : ( RightParenthesis ) ;
    public final void rule__Definition__Group_5_2_1_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3772:1: ( ( RightParenthesis ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3773:1: ( RightParenthesis )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3773:1: ( RightParenthesis )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3774:1: RightParenthesis
            {
             before(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_1_4()); 
            match(input,RightParenthesis,FOLLOW_RightParenthesis_in_rule__Definition__Group_5_2_1_1__4__Impl8006); 
             after(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_1__4__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__5"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3787:1: rule__Definition__Group_5_2_1_1__5 : rule__Definition__Group_5_2_1_1__5__Impl ;
    public final void rule__Definition__Group_5_2_1_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3791:1: ( rule__Definition__Group_5_2_1_1__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3792:2: rule__Definition__Group_5_2_1_1__5__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__5__Impl_in_rule__Definition__Group_5_2_1_1__58037);
            rule__Definition__Group_5_2_1_1__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_1__5"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__5__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3798:1: rule__Definition__Group_5_2_1_1__5__Impl : ( RULE_ID ) ;
    public final void rule__Definition__Group_5_2_1_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3802:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3803:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3803:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3804:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_1_5()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__Group_5_2_1_1__5__Impl8064); 
             after(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_1_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1_1__5__Impl"


    // $ANTLR start "rule__AutoNumber__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3827:1: rule__AutoNumber__Group__0 : rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 ;
    public final void rule__AutoNumber__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3831:1: ( rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3832:2: rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__08105);
            rule__AutoNumber__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__08108);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3839:1: rule__AutoNumber__Group__0__Impl : ( Autonumber ) ;
    public final void rule__AutoNumber__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3843:1: ( ( Autonumber ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3844:1: ( Autonumber )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3844:1: ( Autonumber )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3845:1: Autonumber
            {
             before(grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
            match(input,Autonumber,FOLLOW_Autonumber_in_rule__AutoNumber__Group__0__Impl8136); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3858:1: rule__AutoNumber__Group__1 : rule__AutoNumber__Group__1__Impl ;
    public final void rule__AutoNumber__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3862:1: ( rule__AutoNumber__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3863:2: rule__AutoNumber__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__18167);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3869:1: rule__AutoNumber__Group__1__Impl : ( ( rule__AutoNumber__Group_1__0 )? ) ;
    public final void rule__AutoNumber__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3873:1: ( ( ( rule__AutoNumber__Group_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3874:1: ( ( rule__AutoNumber__Group_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3874:1: ( ( rule__AutoNumber__Group_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3875:1: ( rule__AutoNumber__Group_1__0 )?
            {
             before(grammarAccess.getAutoNumberAccess().getGroup_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3876:1: ( rule__AutoNumber__Group_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_INT) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3876:2: rule__AutoNumber__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl8194);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3890:1: rule__AutoNumber__Group_1__0 : rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 ;
    public final void rule__AutoNumber__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3894:1: ( rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3895:2: rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__08229);
            rule__AutoNumber__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__08232);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3902:1: rule__AutoNumber__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__AutoNumber__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3906:1: ( ( RULE_INT ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3907:1: ( RULE_INT )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3907:1: ( RULE_INT )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3908:1: RULE_INT
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl8259); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3919:1: rule__AutoNumber__Group_1__1 : rule__AutoNumber__Group_1__1__Impl ;
    public final void rule__AutoNumber__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3923:1: ( rule__AutoNumber__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3924:2: rule__AutoNumber__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__18288);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3930:1: rule__AutoNumber__Group_1__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__AutoNumber__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3934:1: ( ( ( RULE_INT )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3935:1: ( ( RULE_INT )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3935:1: ( ( RULE_INT )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3936:1: ( RULE_INT )?
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3937:1: ( RULE_INT )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_INT) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3937:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl8316); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3951:1: rule__Color__Group__0 : rule__Color__Group__0__Impl rule__Color__Group__1 ;
    public final void rule__Color__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3955:1: ( rule__Color__Group__0__Impl rule__Color__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3956:2: rule__Color__Group__0__Impl rule__Color__Group__1
            {
            pushFollow(FOLLOW_rule__Color__Group__0__Impl_in_rule__Color__Group__08351);
            rule__Color__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Color__Group__1_in_rule__Color__Group__08354);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3963:1: rule__Color__Group__0__Impl : ( NumberSign ) ;
    public final void rule__Color__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3967:1: ( ( NumberSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3968:1: ( NumberSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3968:1: ( NumberSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3969:1: NumberSign
            {
             before(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 
            match(input,NumberSign,FOLLOW_NumberSign_in_rule__Color__Group__0__Impl8382); 
             after(grammarAccess.getColorAccess().getNumberSignKeyword_0()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3982:1: rule__Color__Group__1 : rule__Color__Group__1__Impl ;
    public final void rule__Color__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3986:1: ( rule__Color__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3987:2: rule__Color__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Color__Group__1__Impl_in_rule__Color__Group__18413);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3993:1: rule__Color__Group__1__Impl : ( ( rule__Color__Alternatives_1 ) ) ;
    public final void rule__Color__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3997:1: ( ( ( rule__Color__Alternatives_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3998:1: ( ( rule__Color__Alternatives_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3998:1: ( ( rule__Color__Alternatives_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3999:1: ( rule__Color__Alternatives_1 )
            {
             before(grammarAccess.getColorAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4000:1: ( rule__Color__Alternatives_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4000:2: rule__Color__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Color__Alternatives_1_in_rule__Color__Group__1__Impl8440);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4014:1: rule__Title__Group__0 : rule__Title__Group__0__Impl rule__Title__Group__1 ;
    public final void rule__Title__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4018:1: ( rule__Title__Group__0__Impl rule__Title__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4019:2: rule__Title__Group__0__Impl rule__Title__Group__1
            {
            pushFollow(FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__08474);
            rule__Title__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Title__Group__1_in_rule__Title__Group__08477);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4026:1: rule__Title__Group__0__Impl : ( Title ) ;
    public final void rule__Title__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4030:1: ( ( Title ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4031:1: ( Title )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4031:1: ( Title )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4032:1: Title
            {
             before(grammarAccess.getTitleAccess().getTitleKeyword_0()); 
            match(input,Title,FOLLOW_Title_in_rule__Title__Group__0__Impl8505); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4045:1: rule__Title__Group__1 : rule__Title__Group__1__Impl ;
    public final void rule__Title__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4049:1: ( rule__Title__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4050:2: rule__Title__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__18536);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4056:1: rule__Title__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Title__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4060:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4061:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4061:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4062:1: ( RULE_ID )*
            {
             before(grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4063:1: ( RULE_ID )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4063:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl8564); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4077:1: rule__Legend__Group__0 : rule__Legend__Group__0__Impl rule__Legend__Group__1 ;
    public final void rule__Legend__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4081:1: ( rule__Legend__Group__0__Impl rule__Legend__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4082:2: rule__Legend__Group__0__Impl rule__Legend__Group__1
            {
            pushFollow(FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__08599);
            rule__Legend__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__08602);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4089:1: rule__Legend__Group__0__Impl : ( Legend ) ;
    public final void rule__Legend__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4093:1: ( ( Legend ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4094:1: ( Legend )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4094:1: ( Legend )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4095:1: Legend
            {
             before(grammarAccess.getLegendAccess().getLegendKeyword_0()); 
            match(input,Legend,FOLLOW_Legend_in_rule__Legend__Group__0__Impl8630); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4108:1: rule__Legend__Group__1 : rule__Legend__Group__1__Impl rule__Legend__Group__2 ;
    public final void rule__Legend__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4112:1: ( rule__Legend__Group__1__Impl rule__Legend__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4113:2: rule__Legend__Group__1__Impl rule__Legend__Group__2
            {
            pushFollow(FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__18661);
            rule__Legend__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__18664);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4120:1: rule__Legend__Group__1__Impl : ( ( rule__Legend__Alternatives_1 )? ) ;
    public final void rule__Legend__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4124:1: ( ( ( rule__Legend__Alternatives_1 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4125:1: ( ( rule__Legend__Alternatives_1 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4125:1: ( ( rule__Legend__Alternatives_1 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4126:1: ( rule__Legend__Alternatives_1 )?
            {
             before(grammarAccess.getLegendAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4127:1: ( rule__Legend__Alternatives_1 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Center||LA23_0==Right||LA23_0==Left) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4127:2: rule__Legend__Alternatives_1
                    {
                    pushFollow(FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl8691);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4137:1: rule__Legend__Group__2 : rule__Legend__Group__2__Impl rule__Legend__Group__3 ;
    public final void rule__Legend__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4141:1: ( rule__Legend__Group__2__Impl rule__Legend__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4142:2: rule__Legend__Group__2__Impl rule__Legend__Group__3
            {
            pushFollow(FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__28722);
            rule__Legend__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__28725);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4149:1: rule__Legend__Group__2__Impl : ( ( rule__Legend__Group_2__0 )* ) ;
    public final void rule__Legend__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4153:1: ( ( ( rule__Legend__Group_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4154:1: ( ( rule__Legend__Group_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4154:1: ( ( rule__Legend__Group_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4155:1: ( rule__Legend__Group_2__0 )*
            {
             before(grammarAccess.getLegendAccess().getGroup_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4156:1: ( rule__Legend__Group_2__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_NEWLINE) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4156:2: rule__Legend__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Legend__Group_2__0_in_rule__Legend__Group__2__Impl8752);
            	    rule__Legend__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getLegendAccess().getGroup_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4166:1: rule__Legend__Group__3 : rule__Legend__Group__3__Impl ;
    public final void rule__Legend__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4170:1: ( rule__Legend__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4171:2: rule__Legend__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__38783);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4177:1: rule__Legend__Group__3__Impl : ( Endlegend ) ;
    public final void rule__Legend__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4181:1: ( ( Endlegend ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4182:1: ( Endlegend )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4182:1: ( Endlegend )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4183:1: Endlegend
            {
             before(grammarAccess.getLegendAccess().getEndlegendKeyword_3()); 
            match(input,Endlegend,FOLLOW_Endlegend_in_rule__Legend__Group__3__Impl8811); 
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


    // $ANTLR start "rule__Legend__Group_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4204:1: rule__Legend__Group_2__0 : rule__Legend__Group_2__0__Impl rule__Legend__Group_2__1 ;
    public final void rule__Legend__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4208:1: ( rule__Legend__Group_2__0__Impl rule__Legend__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4209:2: rule__Legend__Group_2__0__Impl rule__Legend__Group_2__1
            {
            pushFollow(FOLLOW_rule__Legend__Group_2__0__Impl_in_rule__Legend__Group_2__08850);
            rule__Legend__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group_2__1_in_rule__Legend__Group_2__08853);
            rule__Legend__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group_2__0"


    // $ANTLR start "rule__Legend__Group_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4216:1: rule__Legend__Group_2__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Legend__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4220:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4221:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4221:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4222:1: RULE_NEWLINE
            {
             before(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Legend__Group_2__0__Impl8880); 
             after(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group_2__0__Impl"


    // $ANTLR start "rule__Legend__Group_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4233:1: rule__Legend__Group_2__1 : rule__Legend__Group_2__1__Impl ;
    public final void rule__Legend__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4237:1: ( rule__Legend__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4238:2: rule__Legend__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group_2__1__Impl_in_rule__Legend__Group_2__18909);
            rule__Legend__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group_2__1"


    // $ANTLR start "rule__Legend__Group_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4244:1: rule__Legend__Group_2__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Legend__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4248:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4249:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4249:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4250:1: ( RULE_ID )*
            {
             before(grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4251:1: ( RULE_ID )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4251:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Legend__Group_2__1__Impl8937); 

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group_2__1__Impl"


    // $ANTLR start "rule__Newpage__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4265:1: rule__Newpage__Group__0 : rule__Newpage__Group__0__Impl rule__Newpage__Group__1 ;
    public final void rule__Newpage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4269:1: ( rule__Newpage__Group__0__Impl rule__Newpage__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4270:2: rule__Newpage__Group__0__Impl rule__Newpage__Group__1
            {
            pushFollow(FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__08972);
            rule__Newpage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__08975);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4277:1: rule__Newpage__Group__0__Impl : ( Newpage ) ;
    public final void rule__Newpage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4281:1: ( ( Newpage ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4282:1: ( Newpage )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4282:1: ( Newpage )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4283:1: Newpage
            {
             before(grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
            match(input,Newpage,FOLLOW_Newpage_in_rule__Newpage__Group__0__Impl9003); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4296:1: rule__Newpage__Group__1 : rule__Newpage__Group__1__Impl ;
    public final void rule__Newpage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4300:1: ( rule__Newpage__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4301:2: rule__Newpage__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__19034);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4307:1: rule__Newpage__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Newpage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4311:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4312:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4312:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4313:1: ( RULE_ID )*
            {
             before(grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4314:1: ( RULE_ID )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4314:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl9062); 

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4328:1: rule__AltElse__Group__0 : rule__AltElse__Group__0__Impl rule__AltElse__Group__1 ;
    public final void rule__AltElse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4332:1: ( rule__AltElse__Group__0__Impl rule__AltElse__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4333:2: rule__AltElse__Group__0__Impl rule__AltElse__Group__1
            {
            pushFollow(FOLLOW_rule__AltElse__Group__0__Impl_in_rule__AltElse__Group__09097);
            rule__AltElse__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__1_in_rule__AltElse__Group__09100);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4340:1: rule__AltElse__Group__0__Impl : ( () ) ;
    public final void rule__AltElse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4344:1: ( ( () ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4345:1: ( () )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4345:1: ( () )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4346:1: ()
            {
             before(grammarAccess.getAltElseAccess().getAltElseAction_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4347:1: ()
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4349:1: 
            {
            }

             after(grammarAccess.getAltElseAccess().getAltElseAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__0__Impl"


    // $ANTLR start "rule__AltElse__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4359:1: rule__AltElse__Group__1 : rule__AltElse__Group__1__Impl rule__AltElse__Group__2 ;
    public final void rule__AltElse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4363:1: ( rule__AltElse__Group__1__Impl rule__AltElse__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4364:2: rule__AltElse__Group__1__Impl rule__AltElse__Group__2
            {
            pushFollow(FOLLOW_rule__AltElse__Group__1__Impl_in_rule__AltElse__Group__19158);
            rule__AltElse__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__2_in_rule__AltElse__Group__19161);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4371:1: rule__AltElse__Group__1__Impl : ( Alt ) ;
    public final void rule__AltElse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4375:1: ( ( Alt ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4376:1: ( Alt )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4376:1: ( Alt )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4377:1: Alt
            {
             before(grammarAccess.getAltElseAccess().getAltKeyword_1()); 
            match(input,Alt,FOLLOW_Alt_in_rule__AltElse__Group__1__Impl9189); 
             after(grammarAccess.getAltElseAccess().getAltKeyword_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4390:1: rule__AltElse__Group__2 : rule__AltElse__Group__2__Impl rule__AltElse__Group__3 ;
    public final void rule__AltElse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4394:1: ( rule__AltElse__Group__2__Impl rule__AltElse__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4395:2: rule__AltElse__Group__2__Impl rule__AltElse__Group__3
            {
            pushFollow(FOLLOW_rule__AltElse__Group__2__Impl_in_rule__AltElse__Group__29220);
            rule__AltElse__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__3_in_rule__AltElse__Group__29223);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4402:1: rule__AltElse__Group__2__Impl : ( ( RULE_ID )* ) ;
    public final void rule__AltElse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4406:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4407:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4407:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4408:1: ( RULE_ID )*
            {
             before(grammarAccess.getAltElseAccess().getIDTerminalRuleCall_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4409:1: ( RULE_ID )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4409:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AltElse__Group__2__Impl9251); 

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getAltElseAccess().getIDTerminalRuleCall_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4419:1: rule__AltElse__Group__3 : rule__AltElse__Group__3__Impl rule__AltElse__Group__4 ;
    public final void rule__AltElse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4423:1: ( rule__AltElse__Group__3__Impl rule__AltElse__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4424:2: rule__AltElse__Group__3__Impl rule__AltElse__Group__4
            {
            pushFollow(FOLLOW_rule__AltElse__Group__3__Impl_in_rule__AltElse__Group__39282);
            rule__AltElse__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__4_in_rule__AltElse__Group__39285);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4431:1: rule__AltElse__Group__3__Impl : ( RULE_NEWLINE ) ;
    public final void rule__AltElse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4435:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4436:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4436:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4437:1: RULE_NEWLINE
            {
             before(grammarAccess.getAltElseAccess().getNEWLINETerminalRuleCall_3()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__AltElse__Group__3__Impl9312); 
             after(grammarAccess.getAltElseAccess().getNEWLINETerminalRuleCall_3()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4448:1: rule__AltElse__Group__4 : rule__AltElse__Group__4__Impl rule__AltElse__Group__5 ;
    public final void rule__AltElse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4452:1: ( rule__AltElse__Group__4__Impl rule__AltElse__Group__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4453:2: rule__AltElse__Group__4__Impl rule__AltElse__Group__5
            {
            pushFollow(FOLLOW_rule__AltElse__Group__4__Impl_in_rule__AltElse__Group__49341);
            rule__AltElse__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__5_in_rule__AltElse__Group__49344);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4460:1: rule__AltElse__Group__4__Impl : ( ( rule__AltElse__InstructionsAssignment_4 )* ) ;
    public final void rule__AltElse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4464:1: ( ( ( rule__AltElse__InstructionsAssignment_4 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4465:1: ( ( rule__AltElse__InstructionsAssignment_4 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4465:1: ( ( rule__AltElse__InstructionsAssignment_4 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4466:1: ( rule__AltElse__InstructionsAssignment_4 )*
            {
             before(grammarAccess.getAltElseAccess().getInstructionsAssignment_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4467:1: ( rule__AltElse__InstructionsAssignment_4 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==Participant||(LA28_0>=Autonumber && LA28_0<=Deactivate)||(LA28_0>=Activate && LA28_0<=Database)||(LA28_0>=Control && LA28_0<=Destroy)||LA28_0==Newpage||(LA28_0>=Create && LA28_0<=Legend)||(LA28_0>=Actor && LA28_0<=Group)||LA28_0==Title||LA28_0==Hide||(LA28_0>=Loop && LA28_0<=Note)||LA28_0==FullStopFullStopFullStop||(LA28_0>=Alt && LA28_0<=Box)||(LA28_0>=Opt && LA28_0<=VerticalLineVerticalLineVerticalLine)||LA28_0==EqualsSignEqualsSign||LA28_0==VerticalLineVerticalLine||LA28_0==RULE_NEWLINE||LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4467:2: rule__AltElse__InstructionsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__AltElse__InstructionsAssignment_4_in_rule__AltElse__Group__4__Impl9371);
            	    rule__AltElse__InstructionsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getAltElseAccess().getInstructionsAssignment_4()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4477:1: rule__AltElse__Group__5 : rule__AltElse__Group__5__Impl rule__AltElse__Group__6 ;
    public final void rule__AltElse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4481:1: ( rule__AltElse__Group__5__Impl rule__AltElse__Group__6 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4482:2: rule__AltElse__Group__5__Impl rule__AltElse__Group__6
            {
            pushFollow(FOLLOW_rule__AltElse__Group__5__Impl_in_rule__AltElse__Group__59402);
            rule__AltElse__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__6_in_rule__AltElse__Group__59405);
            rule__AltElse__Group__6();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4489:1: rule__AltElse__Group__5__Impl : ( ( rule__AltElse__ElsesAssignment_5 )* ) ;
    public final void rule__AltElse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4493:1: ( ( ( rule__AltElse__ElsesAssignment_5 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4494:1: ( ( rule__AltElse__ElsesAssignment_5 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4494:1: ( ( rule__AltElse__ElsesAssignment_5 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4495:1: ( rule__AltElse__ElsesAssignment_5 )*
            {
             before(grammarAccess.getAltElseAccess().getElsesAssignment_5()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4496:1: ( rule__AltElse__ElsesAssignment_5 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==Else) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4496:2: rule__AltElse__ElsesAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__AltElse__ElsesAssignment_5_in_rule__AltElse__Group__5__Impl9432);
            	    rule__AltElse__ElsesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getAltElseAccess().getElsesAssignment_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__AltElse__Group__6"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4506:1: rule__AltElse__Group__6 : rule__AltElse__Group__6__Impl ;
    public final void rule__AltElse__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4510:1: ( rule__AltElse__Group__6__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4511:2: rule__AltElse__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__AltElse__Group__6__Impl_in_rule__AltElse__Group__69463);
            rule__AltElse__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__6"


    // $ANTLR start "rule__AltElse__Group__6__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4517:1: rule__AltElse__Group__6__Impl : ( End ) ;
    public final void rule__AltElse__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4521:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4522:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4522:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4523:1: End
            {
             before(grammarAccess.getAltElseAccess().getEndKeyword_6()); 
            match(input,End,FOLLOW_End_in_rule__AltElse__Group__6__Impl9491); 
             after(grammarAccess.getAltElseAccess().getEndKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__6__Impl"


    // $ANTLR start "rule__Else__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4550:1: rule__Else__Group__0 : rule__Else__Group__0__Impl rule__Else__Group__1 ;
    public final void rule__Else__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4554:1: ( rule__Else__Group__0__Impl rule__Else__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4555:2: rule__Else__Group__0__Impl rule__Else__Group__1
            {
            pushFollow(FOLLOW_rule__Else__Group__0__Impl_in_rule__Else__Group__09536);
            rule__Else__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__1_in_rule__Else__Group__09539);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4562:1: rule__Else__Group__0__Impl : ( () ) ;
    public final void rule__Else__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4566:1: ( ( () ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4567:1: ( () )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4567:1: ( () )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4568:1: ()
            {
             before(grammarAccess.getElseAccess().getElseAction_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4569:1: ()
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4571:1: 
            {
            }

             after(grammarAccess.getElseAccess().getElseAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Else__Group__0__Impl"


    // $ANTLR start "rule__Else__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4581:1: rule__Else__Group__1 : rule__Else__Group__1__Impl rule__Else__Group__2 ;
    public final void rule__Else__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4585:1: ( rule__Else__Group__1__Impl rule__Else__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4586:2: rule__Else__Group__1__Impl rule__Else__Group__2
            {
            pushFollow(FOLLOW_rule__Else__Group__1__Impl_in_rule__Else__Group__19597);
            rule__Else__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__2_in_rule__Else__Group__19600);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4593:1: rule__Else__Group__1__Impl : ( Else ) ;
    public final void rule__Else__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4597:1: ( ( Else ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4598:1: ( Else )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4598:1: ( Else )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4599:1: Else
            {
             before(grammarAccess.getElseAccess().getElseKeyword_1()); 
            match(input,Else,FOLLOW_Else_in_rule__Else__Group__1__Impl9628); 
             after(grammarAccess.getElseAccess().getElseKeyword_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4612:1: rule__Else__Group__2 : rule__Else__Group__2__Impl rule__Else__Group__3 ;
    public final void rule__Else__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4616:1: ( rule__Else__Group__2__Impl rule__Else__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4617:2: rule__Else__Group__2__Impl rule__Else__Group__3
            {
            pushFollow(FOLLOW_rule__Else__Group__2__Impl_in_rule__Else__Group__29659);
            rule__Else__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__3_in_rule__Else__Group__29662);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4624:1: rule__Else__Group__2__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Else__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4628:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4629:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4629:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4630:1: ( RULE_ID )*
            {
             before(grammarAccess.getElseAccess().getIDTerminalRuleCall_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4631:1: ( RULE_ID )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4631:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Else__Group__2__Impl9690); 

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getElseAccess().getIDTerminalRuleCall_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4641:1: rule__Else__Group__3 : rule__Else__Group__3__Impl rule__Else__Group__4 ;
    public final void rule__Else__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4645:1: ( rule__Else__Group__3__Impl rule__Else__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4646:2: rule__Else__Group__3__Impl rule__Else__Group__4
            {
            pushFollow(FOLLOW_rule__Else__Group__3__Impl_in_rule__Else__Group__39721);
            rule__Else__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__4_in_rule__Else__Group__39724);
            rule__Else__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4653:1: rule__Else__Group__3__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Else__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4657:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4658:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4658:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4659:1: RULE_NEWLINE
            {
             before(grammarAccess.getElseAccess().getNEWLINETerminalRuleCall_3()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Else__Group__3__Impl9751); 
             after(grammarAccess.getElseAccess().getNEWLINETerminalRuleCall_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Else__Group__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4670:1: rule__Else__Group__4 : rule__Else__Group__4__Impl ;
    public final void rule__Else__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4674:1: ( rule__Else__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4675:2: rule__Else__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Else__Group__4__Impl_in_rule__Else__Group__49780);
            rule__Else__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Else__Group__4"


    // $ANTLR start "rule__Else__Group__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4681:1: rule__Else__Group__4__Impl : ( ( rule__Else__InstructionsAssignment_4 )* ) ;
    public final void rule__Else__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4685:1: ( ( ( rule__Else__InstructionsAssignment_4 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4686:1: ( ( rule__Else__InstructionsAssignment_4 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4686:1: ( ( rule__Else__InstructionsAssignment_4 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4687:1: ( rule__Else__InstructionsAssignment_4 )*
            {
             before(grammarAccess.getElseAccess().getInstructionsAssignment_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4688:1: ( rule__Else__InstructionsAssignment_4 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==Participant||(LA31_0>=Autonumber && LA31_0<=Deactivate)||(LA31_0>=Activate && LA31_0<=Database)||(LA31_0>=Control && LA31_0<=Destroy)||LA31_0==Newpage||(LA31_0>=Create && LA31_0<=Legend)||(LA31_0>=Actor && LA31_0<=Group)||LA31_0==Title||LA31_0==Hide||(LA31_0>=Loop && LA31_0<=Note)||LA31_0==FullStopFullStopFullStop||(LA31_0>=Alt && LA31_0<=Box)||(LA31_0>=Opt && LA31_0<=VerticalLineVerticalLineVerticalLine)||LA31_0==EqualsSignEqualsSign||LA31_0==VerticalLineVerticalLine||LA31_0==RULE_NEWLINE||LA31_0==RULE_ID) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4688:2: rule__Else__InstructionsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Else__InstructionsAssignment_4_in_rule__Else__Group__4__Impl9807);
            	    rule__Else__InstructionsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getElseAccess().getInstructionsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Else__Group__4__Impl"


    // $ANTLR start "rule__GroupingMessages__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4708:1: rule__GroupingMessages__Group__0 : rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1 ;
    public final void rule__GroupingMessages__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4712:1: ( rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4713:2: rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__0__Impl_in_rule__GroupingMessages__Group__09848);
            rule__GroupingMessages__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__1_in_rule__GroupingMessages__Group__09851);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4720:1: rule__GroupingMessages__Group__0__Impl : ( () ) ;
    public final void rule__GroupingMessages__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4724:1: ( ( () ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4725:1: ( () )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4725:1: ( () )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4726:1: ()
            {
             before(grammarAccess.getGroupingMessagesAccess().getGroupingMessageAction_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4727:1: ()
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4729:1: 
            {
            }

             after(grammarAccess.getGroupingMessagesAccess().getGroupingMessageAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__Group__0__Impl"


    // $ANTLR start "rule__GroupingMessages__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4739:1: rule__GroupingMessages__Group__1 : rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2 ;
    public final void rule__GroupingMessages__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4743:1: ( rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4744:2: rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__1__Impl_in_rule__GroupingMessages__Group__19909);
            rule__GroupingMessages__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__2_in_rule__GroupingMessages__Group__19912);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4751:1: rule__GroupingMessages__Group__1__Impl : ( ( rule__GroupingMessages__Alternatives_1 ) ) ;
    public final void rule__GroupingMessages__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4755:1: ( ( ( rule__GroupingMessages__Alternatives_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4756:1: ( ( rule__GroupingMessages__Alternatives_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4756:1: ( ( rule__GroupingMessages__Alternatives_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4757:1: ( rule__GroupingMessages__Alternatives_1 )
            {
             before(grammarAccess.getGroupingMessagesAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4758:1: ( rule__GroupingMessages__Alternatives_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4758:2: rule__GroupingMessages__Alternatives_1
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Alternatives_1_in_rule__GroupingMessages__Group__1__Impl9939);
            rule__GroupingMessages__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getGroupingMessagesAccess().getAlternatives_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4768:1: rule__GroupingMessages__Group__2 : rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3 ;
    public final void rule__GroupingMessages__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4772:1: ( rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4773:2: rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__2__Impl_in_rule__GroupingMessages__Group__29969);
            rule__GroupingMessages__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__3_in_rule__GroupingMessages__Group__29972);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4780:1: rule__GroupingMessages__Group__2__Impl : ( ( RULE_ID )* ) ;
    public final void rule__GroupingMessages__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4784:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4785:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4785:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4786:1: ( RULE_ID )*
            {
             before(grammarAccess.getGroupingMessagesAccess().getIDTerminalRuleCall_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4787:1: ( RULE_ID )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4787:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__GroupingMessages__Group__2__Impl10000); 

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getGroupingMessagesAccess().getIDTerminalRuleCall_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4797:1: rule__GroupingMessages__Group__3 : rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4 ;
    public final void rule__GroupingMessages__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4801:1: ( rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4802:2: rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__3__Impl_in_rule__GroupingMessages__Group__310031);
            rule__GroupingMessages__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__4_in_rule__GroupingMessages__Group__310034);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4809:1: rule__GroupingMessages__Group__3__Impl : ( RULE_NEWLINE ) ;
    public final void rule__GroupingMessages__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4813:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4814:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4814:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4815:1: RULE_NEWLINE
            {
             before(grammarAccess.getGroupingMessagesAccess().getNEWLINETerminalRuleCall_3()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__GroupingMessages__Group__3__Impl10061); 
             after(grammarAccess.getGroupingMessagesAccess().getNEWLINETerminalRuleCall_3()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4826:1: rule__GroupingMessages__Group__4 : rule__GroupingMessages__Group__4__Impl rule__GroupingMessages__Group__5 ;
    public final void rule__GroupingMessages__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4830:1: ( rule__GroupingMessages__Group__4__Impl rule__GroupingMessages__Group__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4831:2: rule__GroupingMessages__Group__4__Impl rule__GroupingMessages__Group__5
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__4__Impl_in_rule__GroupingMessages__Group__410090);
            rule__GroupingMessages__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__5_in_rule__GroupingMessages__Group__410093);
            rule__GroupingMessages__Group__5();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4838:1: rule__GroupingMessages__Group__4__Impl : ( ( rule__GroupingMessages__InstructionsAssignment_4 )* ) ;
    public final void rule__GroupingMessages__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4842:1: ( ( ( rule__GroupingMessages__InstructionsAssignment_4 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4843:1: ( ( rule__GroupingMessages__InstructionsAssignment_4 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4843:1: ( ( rule__GroupingMessages__InstructionsAssignment_4 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4844:1: ( rule__GroupingMessages__InstructionsAssignment_4 )*
            {
             before(grammarAccess.getGroupingMessagesAccess().getInstructionsAssignment_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4845:1: ( rule__GroupingMessages__InstructionsAssignment_4 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==Participant||(LA33_0>=Autonumber && LA33_0<=Deactivate)||(LA33_0>=Activate && LA33_0<=Database)||(LA33_0>=Control && LA33_0<=Destroy)||LA33_0==Newpage||(LA33_0>=Create && LA33_0<=Legend)||(LA33_0>=Actor && LA33_0<=Group)||LA33_0==Title||LA33_0==Hide||(LA33_0>=Loop && LA33_0<=Note)||LA33_0==FullStopFullStopFullStop||(LA33_0>=Alt && LA33_0<=Box)||(LA33_0>=Opt && LA33_0<=VerticalLineVerticalLineVerticalLine)||LA33_0==EqualsSignEqualsSign||LA33_0==VerticalLineVerticalLine||LA33_0==RULE_NEWLINE||LA33_0==RULE_ID) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4845:2: rule__GroupingMessages__InstructionsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__GroupingMessages__InstructionsAssignment_4_in_rule__GroupingMessages__Group__4__Impl10120);
            	    rule__GroupingMessages__InstructionsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getGroupingMessagesAccess().getInstructionsAssignment_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__GroupingMessages__Group__5"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4855:1: rule__GroupingMessages__Group__5 : rule__GroupingMessages__Group__5__Impl ;
    public final void rule__GroupingMessages__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4859:1: ( rule__GroupingMessages__Group__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4860:2: rule__GroupingMessages__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__5__Impl_in_rule__GroupingMessages__Group__510151);
            rule__GroupingMessages__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__Group__5"


    // $ANTLR start "rule__GroupingMessages__Group__5__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4866:1: rule__GroupingMessages__Group__5__Impl : ( End ) ;
    public final void rule__GroupingMessages__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4870:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4871:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4871:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4872:1: End
            {
             before(grammarAccess.getGroupingMessagesAccess().getEndKeyword_5()); 
            match(input,End,FOLLOW_End_in_rule__GroupingMessages__Group__5__Impl10179); 
             after(grammarAccess.getGroupingMessagesAccess().getEndKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__Group__5__Impl"


    // $ANTLR start "rule__Note__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4897:1: rule__Note__Group__0 : rule__Note__Group__0__Impl rule__Note__Group__1 ;
    public final void rule__Note__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4901:1: ( rule__Note__Group__0__Impl rule__Note__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4902:2: rule__Note__Group__0__Impl rule__Note__Group__1
            {
            pushFollow(FOLLOW_rule__Note__Group__0__Impl_in_rule__Note__Group__010222);
            rule__Note__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__1_in_rule__Note__Group__010225);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4909:1: rule__Note__Group__0__Impl : ( () ) ;
    public final void rule__Note__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4913:1: ( ( () ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4914:1: ( () )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4914:1: ( () )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4915:1: ()
            {
             before(grammarAccess.getNoteAccess().getNoteAction_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4916:1: ()
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4918:1: 
            {
            }

             after(grammarAccess.getNoteAccess().getNoteAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group__0__Impl"


    // $ANTLR start "rule__Note__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4928:1: rule__Note__Group__1 : rule__Note__Group__1__Impl rule__Note__Group__2 ;
    public final void rule__Note__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4932:1: ( rule__Note__Group__1__Impl rule__Note__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4933:2: rule__Note__Group__1__Impl rule__Note__Group__2
            {
            pushFollow(FOLLOW_rule__Note__Group__1__Impl_in_rule__Note__Group__110283);
            rule__Note__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__2_in_rule__Note__Group__110286);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4940:1: rule__Note__Group__1__Impl : ( Note ) ;
    public final void rule__Note__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4944:1: ( ( Note ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4945:1: ( Note )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4945:1: ( Note )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4946:1: Note
            {
             before(grammarAccess.getNoteAccess().getNoteKeyword_1()); 
            match(input,Note,FOLLOW_Note_in_rule__Note__Group__1__Impl10314); 
             after(grammarAccess.getNoteAccess().getNoteKeyword_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4959:1: rule__Note__Group__2 : rule__Note__Group__2__Impl rule__Note__Group__3 ;
    public final void rule__Note__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4963:1: ( rule__Note__Group__2__Impl rule__Note__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4964:2: rule__Note__Group__2__Impl rule__Note__Group__3
            {
            pushFollow(FOLLOW_rule__Note__Group__2__Impl_in_rule__Note__Group__210345);
            rule__Note__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__3_in_rule__Note__Group__210348);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4971:1: rule__Note__Group__2__Impl : ( ( rule__Note__Alternatives_2 ) ) ;
    public final void rule__Note__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4975:1: ( ( ( rule__Note__Alternatives_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4976:1: ( ( rule__Note__Alternatives_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4976:1: ( ( rule__Note__Alternatives_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4977:1: ( rule__Note__Alternatives_2 )
            {
             before(grammarAccess.getNoteAccess().getAlternatives_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4978:1: ( rule__Note__Alternatives_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4978:2: rule__Note__Alternatives_2
            {
            pushFollow(FOLLOW_rule__Note__Alternatives_2_in_rule__Note__Group__2__Impl10375);
            rule__Note__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getAlternatives_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4988:1: rule__Note__Group__3 : rule__Note__Group__3__Impl rule__Note__Group__4 ;
    public final void rule__Note__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4992:1: ( rule__Note__Group__3__Impl rule__Note__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4993:2: rule__Note__Group__3__Impl rule__Note__Group__4
            {
            pushFollow(FOLLOW_rule__Note__Group__3__Impl_in_rule__Note__Group__310405);
            rule__Note__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__4_in_rule__Note__Group__310408);
            rule__Note__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5000:1: rule__Note__Group__3__Impl : ( ( ruleColor )* ) ;
    public final void rule__Note__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5004:1: ( ( ( ruleColor )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5005:1: ( ( ruleColor )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5005:1: ( ( ruleColor )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5006:1: ( ruleColor )*
            {
             before(grammarAccess.getNoteAccess().getColorParserRuleCall_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5007:1: ( ruleColor )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==NumberSign) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5007:3: ruleColor
            	    {
            	    pushFollow(FOLLOW_ruleColor_in_rule__Note__Group__3__Impl10436);
            	    ruleColor();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getColorParserRuleCall_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Note__Group__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5017:1: rule__Note__Group__4 : rule__Note__Group__4__Impl ;
    public final void rule__Note__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5021:1: ( rule__Note__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5022:2: rule__Note__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group__4__Impl_in_rule__Note__Group__410467);
            rule__Note__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group__4"


    // $ANTLR start "rule__Note__Group__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5028:1: rule__Note__Group__4__Impl : ( ( rule__Note__Alternatives_4 ) ) ;
    public final void rule__Note__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5032:1: ( ( ( rule__Note__Alternatives_4 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5033:1: ( ( rule__Note__Alternatives_4 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5033:1: ( ( rule__Note__Alternatives_4 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5034:1: ( rule__Note__Alternatives_4 )
            {
             before(grammarAccess.getNoteAccess().getAlternatives_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5035:1: ( rule__Note__Alternatives_4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5035:2: rule__Note__Alternatives_4
            {
            pushFollow(FOLLOW_rule__Note__Alternatives_4_in_rule__Note__Group__4__Impl10494);
            rule__Note__Alternatives_4();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group__4__Impl"


    // $ANTLR start "rule__Note__Group_2_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5055:1: rule__Note__Group_2_0__0 : rule__Note__Group_2_0__0__Impl rule__Note__Group_2_0__1 ;
    public final void rule__Note__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5059:1: ( rule__Note__Group_2_0__0__Impl rule__Note__Group_2_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5060:2: rule__Note__Group_2_0__0__Impl rule__Note__Group_2_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_2_0__0__Impl_in_rule__Note__Group_2_0__010534);
            rule__Note__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_2_0__1_in_rule__Note__Group_2_0__010537);
            rule__Note__Group_2_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_0__0"


    // $ANTLR start "rule__Note__Group_2_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5067:1: rule__Note__Group_2_0__0__Impl : ( Right ) ;
    public final void rule__Note__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5071:1: ( ( Right ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5072:1: ( Right )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5072:1: ( Right )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5073:1: Right
            {
             before(grammarAccess.getNoteAccess().getRightKeyword_2_0_0()); 
            match(input,Right,FOLLOW_Right_in_rule__Note__Group_2_0__0__Impl10565); 
             after(grammarAccess.getNoteAccess().getRightKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_0__0__Impl"


    // $ANTLR start "rule__Note__Group_2_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5086:1: rule__Note__Group_2_0__1 : rule__Note__Group_2_0__1__Impl ;
    public final void rule__Note__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5090:1: ( rule__Note__Group_2_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5091:2: rule__Note__Group_2_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_2_0__1__Impl_in_rule__Note__Group_2_0__110596);
            rule__Note__Group_2_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_0__1"


    // $ANTLR start "rule__Note__Group_2_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5097:1: rule__Note__Group_2_0__1__Impl : ( ( rule__Note__Group_2_0_1__0 )? ) ;
    public final void rule__Note__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5101:1: ( ( ( rule__Note__Group_2_0_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5102:1: ( ( rule__Note__Group_2_0_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5102:1: ( ( rule__Note__Group_2_0_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5103:1: ( rule__Note__Group_2_0_1__0 )?
            {
             before(grammarAccess.getNoteAccess().getGroup_2_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5104:1: ( rule__Note__Group_2_0_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==Of) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5104:2: rule__Note__Group_2_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_2_0_1__0_in_rule__Note__Group_2_0__1__Impl10623);
                    rule__Note__Group_2_0_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNoteAccess().getGroup_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_0__1__Impl"


    // $ANTLR start "rule__Note__Group_2_0_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5118:1: rule__Note__Group_2_0_1__0 : rule__Note__Group_2_0_1__0__Impl rule__Note__Group_2_0_1__1 ;
    public final void rule__Note__Group_2_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5122:1: ( rule__Note__Group_2_0_1__0__Impl rule__Note__Group_2_0_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5123:2: rule__Note__Group_2_0_1__0__Impl rule__Note__Group_2_0_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_2_0_1__0__Impl_in_rule__Note__Group_2_0_1__010658);
            rule__Note__Group_2_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_2_0_1__1_in_rule__Note__Group_2_0_1__010661);
            rule__Note__Group_2_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_0_1__0"


    // $ANTLR start "rule__Note__Group_2_0_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5130:1: rule__Note__Group_2_0_1__0__Impl : ( Of ) ;
    public final void rule__Note__Group_2_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5134:1: ( ( Of ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5135:1: ( Of )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5135:1: ( Of )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5136:1: Of
            {
             before(grammarAccess.getNoteAccess().getOfKeyword_2_0_1_0()); 
            match(input,Of,FOLLOW_Of_in_rule__Note__Group_2_0_1__0__Impl10689); 
             after(grammarAccess.getNoteAccess().getOfKeyword_2_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_0_1__0__Impl"


    // $ANTLR start "rule__Note__Group_2_0_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5149:1: rule__Note__Group_2_0_1__1 : rule__Note__Group_2_0_1__1__Impl rule__Note__Group_2_0_1__2 ;
    public final void rule__Note__Group_2_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5153:1: ( rule__Note__Group_2_0_1__1__Impl rule__Note__Group_2_0_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5154:2: rule__Note__Group_2_0_1__1__Impl rule__Note__Group_2_0_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_2_0_1__1__Impl_in_rule__Note__Group_2_0_1__110720);
            rule__Note__Group_2_0_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_2_0_1__2_in_rule__Note__Group_2_0_1__110723);
            rule__Note__Group_2_0_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_0_1__1"


    // $ANTLR start "rule__Note__Group_2_0_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5161:1: rule__Note__Group_2_0_1__1__Impl : ( ( rule__Note__RidAssignment_2_0_1_1 ) ) ;
    public final void rule__Note__Group_2_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5165:1: ( ( ( rule__Note__RidAssignment_2_0_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5166:1: ( ( rule__Note__RidAssignment_2_0_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5166:1: ( ( rule__Note__RidAssignment_2_0_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5167:1: ( rule__Note__RidAssignment_2_0_1_1 )
            {
             before(grammarAccess.getNoteAccess().getRidAssignment_2_0_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5168:1: ( rule__Note__RidAssignment_2_0_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5168:2: rule__Note__RidAssignment_2_0_1_1
            {
            pushFollow(FOLLOW_rule__Note__RidAssignment_2_0_1_1_in_rule__Note__Group_2_0_1__1__Impl10750);
            rule__Note__RidAssignment_2_0_1_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getRidAssignment_2_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_0_1__1__Impl"


    // $ANTLR start "rule__Note__Group_2_0_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5178:1: rule__Note__Group_2_0_1__2 : rule__Note__Group_2_0_1__2__Impl ;
    public final void rule__Note__Group_2_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5182:1: ( rule__Note__Group_2_0_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5183:2: rule__Note__Group_2_0_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_2_0_1__2__Impl_in_rule__Note__Group_2_0_1__210780);
            rule__Note__Group_2_0_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_0_1__2"


    // $ANTLR start "rule__Note__Group_2_0_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5189:1: rule__Note__Group_2_0_1__2__Impl : ( ( rule__Note__Group_2_0_1_2__0 )* ) ;
    public final void rule__Note__Group_2_0_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5193:1: ( ( ( rule__Note__Group_2_0_1_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5194:1: ( ( rule__Note__Group_2_0_1_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5194:1: ( ( rule__Note__Group_2_0_1_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5195:1: ( rule__Note__Group_2_0_1_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_2_0_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5196:1: ( rule__Note__Group_2_0_1_2__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==Comma) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5196:2: rule__Note__Group_2_0_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_2_0_1_2__0_in_rule__Note__Group_2_0_1__2__Impl10807);
            	    rule__Note__Group_2_0_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getGroup_2_0_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_0_1__2__Impl"


    // $ANTLR start "rule__Note__Group_2_0_1_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5212:1: rule__Note__Group_2_0_1_2__0 : rule__Note__Group_2_0_1_2__0__Impl rule__Note__Group_2_0_1_2__1 ;
    public final void rule__Note__Group_2_0_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5216:1: ( rule__Note__Group_2_0_1_2__0__Impl rule__Note__Group_2_0_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5217:2: rule__Note__Group_2_0_1_2__0__Impl rule__Note__Group_2_0_1_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_2_0_1_2__0__Impl_in_rule__Note__Group_2_0_1_2__010844);
            rule__Note__Group_2_0_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_2_0_1_2__1_in_rule__Note__Group_2_0_1_2__010847);
            rule__Note__Group_2_0_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_0_1_2__0"


    // $ANTLR start "rule__Note__Group_2_0_1_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5224:1: rule__Note__Group_2_0_1_2__0__Impl : ( Comma ) ;
    public final void rule__Note__Group_2_0_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5228:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5229:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5229:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5230:1: Comma
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_2_0_1_2_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Note__Group_2_0_1_2__0__Impl10875); 
             after(grammarAccess.getNoteAccess().getCommaKeyword_2_0_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_0_1_2__0__Impl"


    // $ANTLR start "rule__Note__Group_2_0_1_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5243:1: rule__Note__Group_2_0_1_2__1 : rule__Note__Group_2_0_1_2__1__Impl ;
    public final void rule__Note__Group_2_0_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5247:1: ( rule__Note__Group_2_0_1_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5248:2: rule__Note__Group_2_0_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_2_0_1_2__1__Impl_in_rule__Note__Group_2_0_1_2__110906);
            rule__Note__Group_2_0_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_0_1_2__1"


    // $ANTLR start "rule__Note__Group_2_0_1_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5254:1: rule__Note__Group_2_0_1_2__1__Impl : ( ( rule__Note__RidsAssignment_2_0_1_2_1 ) ) ;
    public final void rule__Note__Group_2_0_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5258:1: ( ( ( rule__Note__RidsAssignment_2_0_1_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5259:1: ( ( rule__Note__RidsAssignment_2_0_1_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5259:1: ( ( rule__Note__RidsAssignment_2_0_1_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5260:1: ( rule__Note__RidsAssignment_2_0_1_2_1 )
            {
             before(grammarAccess.getNoteAccess().getRidsAssignment_2_0_1_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5261:1: ( rule__Note__RidsAssignment_2_0_1_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5261:2: rule__Note__RidsAssignment_2_0_1_2_1
            {
            pushFollow(FOLLOW_rule__Note__RidsAssignment_2_0_1_2_1_in_rule__Note__Group_2_0_1_2__1__Impl10933);
            rule__Note__RidsAssignment_2_0_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getRidsAssignment_2_0_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_0_1_2__1__Impl"


    // $ANTLR start "rule__Note__Group_2_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5275:1: rule__Note__Group_2_1__0 : rule__Note__Group_2_1__0__Impl rule__Note__Group_2_1__1 ;
    public final void rule__Note__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5279:1: ( rule__Note__Group_2_1__0__Impl rule__Note__Group_2_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5280:2: rule__Note__Group_2_1__0__Impl rule__Note__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_2_1__0__Impl_in_rule__Note__Group_2_1__010967);
            rule__Note__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_2_1__1_in_rule__Note__Group_2_1__010970);
            rule__Note__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_1__0"


    // $ANTLR start "rule__Note__Group_2_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5287:1: rule__Note__Group_2_1__0__Impl : ( Left ) ;
    public final void rule__Note__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5291:1: ( ( Left ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5292:1: ( Left )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5292:1: ( Left )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5293:1: Left
            {
             before(grammarAccess.getNoteAccess().getLeftKeyword_2_1_0()); 
            match(input,Left,FOLLOW_Left_in_rule__Note__Group_2_1__0__Impl10998); 
             after(grammarAccess.getNoteAccess().getLeftKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_1__0__Impl"


    // $ANTLR start "rule__Note__Group_2_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5306:1: rule__Note__Group_2_1__1 : rule__Note__Group_2_1__1__Impl ;
    public final void rule__Note__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5310:1: ( rule__Note__Group_2_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5311:2: rule__Note__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_2_1__1__Impl_in_rule__Note__Group_2_1__111029);
            rule__Note__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_1__1"


    // $ANTLR start "rule__Note__Group_2_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5317:1: rule__Note__Group_2_1__1__Impl : ( ( rule__Note__Group_2_1_1__0 )? ) ;
    public final void rule__Note__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5321:1: ( ( ( rule__Note__Group_2_1_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5322:1: ( ( rule__Note__Group_2_1_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5322:1: ( ( rule__Note__Group_2_1_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5323:1: ( rule__Note__Group_2_1_1__0 )?
            {
             before(grammarAccess.getNoteAccess().getGroup_2_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5324:1: ( rule__Note__Group_2_1_1__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==Of) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5324:2: rule__Note__Group_2_1_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_2_1_1__0_in_rule__Note__Group_2_1__1__Impl11056);
                    rule__Note__Group_2_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNoteAccess().getGroup_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_1__1__Impl"


    // $ANTLR start "rule__Note__Group_2_1_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5338:1: rule__Note__Group_2_1_1__0 : rule__Note__Group_2_1_1__0__Impl rule__Note__Group_2_1_1__1 ;
    public final void rule__Note__Group_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5342:1: ( rule__Note__Group_2_1_1__0__Impl rule__Note__Group_2_1_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5343:2: rule__Note__Group_2_1_1__0__Impl rule__Note__Group_2_1_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_2_1_1__0__Impl_in_rule__Note__Group_2_1_1__011091);
            rule__Note__Group_2_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_2_1_1__1_in_rule__Note__Group_2_1_1__011094);
            rule__Note__Group_2_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_1_1__0"


    // $ANTLR start "rule__Note__Group_2_1_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5350:1: rule__Note__Group_2_1_1__0__Impl : ( Of ) ;
    public final void rule__Note__Group_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5354:1: ( ( Of ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5355:1: ( Of )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5355:1: ( Of )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5356:1: Of
            {
             before(grammarAccess.getNoteAccess().getOfKeyword_2_1_1_0()); 
            match(input,Of,FOLLOW_Of_in_rule__Note__Group_2_1_1__0__Impl11122); 
             after(grammarAccess.getNoteAccess().getOfKeyword_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_1_1__0__Impl"


    // $ANTLR start "rule__Note__Group_2_1_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5369:1: rule__Note__Group_2_1_1__1 : rule__Note__Group_2_1_1__1__Impl rule__Note__Group_2_1_1__2 ;
    public final void rule__Note__Group_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5373:1: ( rule__Note__Group_2_1_1__1__Impl rule__Note__Group_2_1_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5374:2: rule__Note__Group_2_1_1__1__Impl rule__Note__Group_2_1_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_2_1_1__1__Impl_in_rule__Note__Group_2_1_1__111153);
            rule__Note__Group_2_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_2_1_1__2_in_rule__Note__Group_2_1_1__111156);
            rule__Note__Group_2_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_1_1__1"


    // $ANTLR start "rule__Note__Group_2_1_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5381:1: rule__Note__Group_2_1_1__1__Impl : ( ( rule__Note__LidAssignment_2_1_1_1 ) ) ;
    public final void rule__Note__Group_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5385:1: ( ( ( rule__Note__LidAssignment_2_1_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5386:1: ( ( rule__Note__LidAssignment_2_1_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5386:1: ( ( rule__Note__LidAssignment_2_1_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5387:1: ( rule__Note__LidAssignment_2_1_1_1 )
            {
             before(grammarAccess.getNoteAccess().getLidAssignment_2_1_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5388:1: ( rule__Note__LidAssignment_2_1_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5388:2: rule__Note__LidAssignment_2_1_1_1
            {
            pushFollow(FOLLOW_rule__Note__LidAssignment_2_1_1_1_in_rule__Note__Group_2_1_1__1__Impl11183);
            rule__Note__LidAssignment_2_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getLidAssignment_2_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_1_1__1__Impl"


    // $ANTLR start "rule__Note__Group_2_1_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5398:1: rule__Note__Group_2_1_1__2 : rule__Note__Group_2_1_1__2__Impl ;
    public final void rule__Note__Group_2_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5402:1: ( rule__Note__Group_2_1_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5403:2: rule__Note__Group_2_1_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_2_1_1__2__Impl_in_rule__Note__Group_2_1_1__211213);
            rule__Note__Group_2_1_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_1_1__2"


    // $ANTLR start "rule__Note__Group_2_1_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5409:1: rule__Note__Group_2_1_1__2__Impl : ( ( rule__Note__Group_2_1_1_2__0 )* ) ;
    public final void rule__Note__Group_2_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5413:1: ( ( ( rule__Note__Group_2_1_1_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5414:1: ( ( rule__Note__Group_2_1_1_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5414:1: ( ( rule__Note__Group_2_1_1_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5415:1: ( rule__Note__Group_2_1_1_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_2_1_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5416:1: ( rule__Note__Group_2_1_1_2__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==Comma) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5416:2: rule__Note__Group_2_1_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_2_1_1_2__0_in_rule__Note__Group_2_1_1__2__Impl11240);
            	    rule__Note__Group_2_1_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getGroup_2_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_1_1__2__Impl"


    // $ANTLR start "rule__Note__Group_2_1_1_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5432:1: rule__Note__Group_2_1_1_2__0 : rule__Note__Group_2_1_1_2__0__Impl rule__Note__Group_2_1_1_2__1 ;
    public final void rule__Note__Group_2_1_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5436:1: ( rule__Note__Group_2_1_1_2__0__Impl rule__Note__Group_2_1_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5437:2: rule__Note__Group_2_1_1_2__0__Impl rule__Note__Group_2_1_1_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_2_1_1_2__0__Impl_in_rule__Note__Group_2_1_1_2__011277);
            rule__Note__Group_2_1_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_2_1_1_2__1_in_rule__Note__Group_2_1_1_2__011280);
            rule__Note__Group_2_1_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_1_1_2__0"


    // $ANTLR start "rule__Note__Group_2_1_1_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5444:1: rule__Note__Group_2_1_1_2__0__Impl : ( Comma ) ;
    public final void rule__Note__Group_2_1_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5448:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5449:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5449:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5450:1: Comma
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_2_1_1_2_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Note__Group_2_1_1_2__0__Impl11308); 
             after(grammarAccess.getNoteAccess().getCommaKeyword_2_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_1_1_2__0__Impl"


    // $ANTLR start "rule__Note__Group_2_1_1_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5463:1: rule__Note__Group_2_1_1_2__1 : rule__Note__Group_2_1_1_2__1__Impl ;
    public final void rule__Note__Group_2_1_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5467:1: ( rule__Note__Group_2_1_1_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5468:2: rule__Note__Group_2_1_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_2_1_1_2__1__Impl_in_rule__Note__Group_2_1_1_2__111339);
            rule__Note__Group_2_1_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_1_1_2__1"


    // $ANTLR start "rule__Note__Group_2_1_1_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5474:1: rule__Note__Group_2_1_1_2__1__Impl : ( ( rule__Note__LidsAssignment_2_1_1_2_1 ) ) ;
    public final void rule__Note__Group_2_1_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5478:1: ( ( ( rule__Note__LidsAssignment_2_1_1_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5479:1: ( ( rule__Note__LidsAssignment_2_1_1_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5479:1: ( ( rule__Note__LidsAssignment_2_1_1_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5480:1: ( rule__Note__LidsAssignment_2_1_1_2_1 )
            {
             before(grammarAccess.getNoteAccess().getLidsAssignment_2_1_1_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5481:1: ( rule__Note__LidsAssignment_2_1_1_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5481:2: rule__Note__LidsAssignment_2_1_1_2_1
            {
            pushFollow(FOLLOW_rule__Note__LidsAssignment_2_1_1_2_1_in_rule__Note__Group_2_1_1_2__1__Impl11366);
            rule__Note__LidsAssignment_2_1_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getLidsAssignment_2_1_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_1_1_2__1__Impl"


    // $ANTLR start "rule__Note__Group_2_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5495:1: rule__Note__Group_2_2__0 : rule__Note__Group_2_2__0__Impl rule__Note__Group_2_2__1 ;
    public final void rule__Note__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5499:1: ( rule__Note__Group_2_2__0__Impl rule__Note__Group_2_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5500:2: rule__Note__Group_2_2__0__Impl rule__Note__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_2_2__0__Impl_in_rule__Note__Group_2_2__011400);
            rule__Note__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_2_2__1_in_rule__Note__Group_2_2__011403);
            rule__Note__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_2__0"


    // $ANTLR start "rule__Note__Group_2_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5507:1: rule__Note__Group_2_2__0__Impl : ( Over ) ;
    public final void rule__Note__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5511:1: ( ( Over ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5512:1: ( Over )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5512:1: ( Over )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5513:1: Over
            {
             before(grammarAccess.getNoteAccess().getOverKeyword_2_2_0()); 
            match(input,Over,FOLLOW_Over_in_rule__Note__Group_2_2__0__Impl11431); 
             after(grammarAccess.getNoteAccess().getOverKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_2__0__Impl"


    // $ANTLR start "rule__Note__Group_2_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5526:1: rule__Note__Group_2_2__1 : rule__Note__Group_2_2__1__Impl rule__Note__Group_2_2__2 ;
    public final void rule__Note__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5530:1: ( rule__Note__Group_2_2__1__Impl rule__Note__Group_2_2__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5531:2: rule__Note__Group_2_2__1__Impl rule__Note__Group_2_2__2
            {
            pushFollow(FOLLOW_rule__Note__Group_2_2__1__Impl_in_rule__Note__Group_2_2__111462);
            rule__Note__Group_2_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_2_2__2_in_rule__Note__Group_2_2__111465);
            rule__Note__Group_2_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_2__1"


    // $ANTLR start "rule__Note__Group_2_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5538:1: rule__Note__Group_2_2__1__Impl : ( ( rule__Note__OidAssignment_2_2_1 ) ) ;
    public final void rule__Note__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5542:1: ( ( ( rule__Note__OidAssignment_2_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5543:1: ( ( rule__Note__OidAssignment_2_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5543:1: ( ( rule__Note__OidAssignment_2_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5544:1: ( rule__Note__OidAssignment_2_2_1 )
            {
             before(grammarAccess.getNoteAccess().getOidAssignment_2_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5545:1: ( rule__Note__OidAssignment_2_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5545:2: rule__Note__OidAssignment_2_2_1
            {
            pushFollow(FOLLOW_rule__Note__OidAssignment_2_2_1_in_rule__Note__Group_2_2__1__Impl11492);
            rule__Note__OidAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getOidAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_2__1__Impl"


    // $ANTLR start "rule__Note__Group_2_2__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5555:1: rule__Note__Group_2_2__2 : rule__Note__Group_2_2__2__Impl ;
    public final void rule__Note__Group_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5559:1: ( rule__Note__Group_2_2__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5560:2: rule__Note__Group_2_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_2_2__2__Impl_in_rule__Note__Group_2_2__211522);
            rule__Note__Group_2_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_2__2"


    // $ANTLR start "rule__Note__Group_2_2__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5566:1: rule__Note__Group_2_2__2__Impl : ( ( rule__Note__Group_2_2_2__0 )* ) ;
    public final void rule__Note__Group_2_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5570:1: ( ( ( rule__Note__Group_2_2_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5571:1: ( ( rule__Note__Group_2_2_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5571:1: ( ( rule__Note__Group_2_2_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5572:1: ( rule__Note__Group_2_2_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_2_2_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5573:1: ( rule__Note__Group_2_2_2__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==Comma) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5573:2: rule__Note__Group_2_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_2_2_2__0_in_rule__Note__Group_2_2__2__Impl11549);
            	    rule__Note__Group_2_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getGroup_2_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_2__2__Impl"


    // $ANTLR start "rule__Note__Group_2_2_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5589:1: rule__Note__Group_2_2_2__0 : rule__Note__Group_2_2_2__0__Impl rule__Note__Group_2_2_2__1 ;
    public final void rule__Note__Group_2_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5593:1: ( rule__Note__Group_2_2_2__0__Impl rule__Note__Group_2_2_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5594:2: rule__Note__Group_2_2_2__0__Impl rule__Note__Group_2_2_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_2_2_2__0__Impl_in_rule__Note__Group_2_2_2__011586);
            rule__Note__Group_2_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_2_2_2__1_in_rule__Note__Group_2_2_2__011589);
            rule__Note__Group_2_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_2_2__0"


    // $ANTLR start "rule__Note__Group_2_2_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5601:1: rule__Note__Group_2_2_2__0__Impl : ( Comma ) ;
    public final void rule__Note__Group_2_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5605:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5606:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5606:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5607:1: Comma
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_2_2_2_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Note__Group_2_2_2__0__Impl11617); 
             after(grammarAccess.getNoteAccess().getCommaKeyword_2_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_2_2__0__Impl"


    // $ANTLR start "rule__Note__Group_2_2_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5620:1: rule__Note__Group_2_2_2__1 : rule__Note__Group_2_2_2__1__Impl ;
    public final void rule__Note__Group_2_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5624:1: ( rule__Note__Group_2_2_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5625:2: rule__Note__Group_2_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_2_2_2__1__Impl_in_rule__Note__Group_2_2_2__111648);
            rule__Note__Group_2_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_2_2__1"


    // $ANTLR start "rule__Note__Group_2_2_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5631:1: rule__Note__Group_2_2_2__1__Impl : ( ( rule__Note__OidsAssignment_2_2_2_1 ) ) ;
    public final void rule__Note__Group_2_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5635:1: ( ( ( rule__Note__OidsAssignment_2_2_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5636:1: ( ( rule__Note__OidsAssignment_2_2_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5636:1: ( ( rule__Note__OidsAssignment_2_2_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5637:1: ( rule__Note__OidsAssignment_2_2_2_1 )
            {
             before(grammarAccess.getNoteAccess().getOidsAssignment_2_2_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5638:1: ( rule__Note__OidsAssignment_2_2_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5638:2: rule__Note__OidsAssignment_2_2_2_1
            {
            pushFollow(FOLLOW_rule__Note__OidsAssignment_2_2_2_1_in_rule__Note__Group_2_2_2__1__Impl11675);
            rule__Note__OidsAssignment_2_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getOidsAssignment_2_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_2_2_2__1__Impl"


    // $ANTLR start "rule__Note__Group_4_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5652:1: rule__Note__Group_4_0__0 : rule__Note__Group_4_0__0__Impl rule__Note__Group_4_0__1 ;
    public final void rule__Note__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5656:1: ( rule__Note__Group_4_0__0__Impl rule__Note__Group_4_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5657:2: rule__Note__Group_4_0__0__Impl rule__Note__Group_4_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_4_0__0__Impl_in_rule__Note__Group_4_0__011709);
            rule__Note__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_4_0__1_in_rule__Note__Group_4_0__011712);
            rule__Note__Group_4_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_0__0"


    // $ANTLR start "rule__Note__Group_4_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5664:1: rule__Note__Group_4_0__0__Impl : ( Colon ) ;
    public final void rule__Note__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5668:1: ( ( Colon ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5669:1: ( Colon )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5669:1: ( Colon )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5670:1: Colon
            {
             before(grammarAccess.getNoteAccess().getColonKeyword_4_0_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Note__Group_4_0__0__Impl11740); 
             after(grammarAccess.getNoteAccess().getColonKeyword_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_0__0__Impl"


    // $ANTLR start "rule__Note__Group_4_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5683:1: rule__Note__Group_4_0__1 : rule__Note__Group_4_0__1__Impl ;
    public final void rule__Note__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5687:1: ( rule__Note__Group_4_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5688:2: rule__Note__Group_4_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_4_0__1__Impl_in_rule__Note__Group_4_0__111771);
            rule__Note__Group_4_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_0__1"


    // $ANTLR start "rule__Note__Group_4_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5694:1: rule__Note__Group_4_0__1__Impl : ( RULE_ID ) ;
    public final void rule__Note__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5698:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5699:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5699:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5700:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__Group_4_0__1__Impl11798); 
             after(grammarAccess.getNoteAccess().getIDTerminalRuleCall_4_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_0__1__Impl"


    // $ANTLR start "rule__Note__Group_4_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5715:1: rule__Note__Group_4_1__0 : rule__Note__Group_4_1__0__Impl rule__Note__Group_4_1__1 ;
    public final void rule__Note__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5719:1: ( rule__Note__Group_4_1__0__Impl rule__Note__Group_4_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5720:2: rule__Note__Group_4_1__0__Impl rule__Note__Group_4_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_4_1__0__Impl_in_rule__Note__Group_4_1__011831);
            rule__Note__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_4_1__1_in_rule__Note__Group_4_1__011834);
            rule__Note__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_1__0"


    // $ANTLR start "rule__Note__Group_4_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5727:1: rule__Note__Group_4_1__0__Impl : ( ( rule__Note__Group_4_1_0__0 )* ) ;
    public final void rule__Note__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5731:1: ( ( ( rule__Note__Group_4_1_0__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5732:1: ( ( rule__Note__Group_4_1_0__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5732:1: ( ( rule__Note__Group_4_1_0__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5733:1: ( rule__Note__Group_4_1_0__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_4_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5734:1: ( rule__Note__Group_4_1_0__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_NEWLINE) ) {
                    int LA40_1 = input.LA(2);

                    if ( (LA40_1==RULE_NEWLINE||LA40_1==RULE_ID) ) {
                        alt40=1;
                    }


                }


                switch (alt40) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5734:2: rule__Note__Group_4_1_0__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_4_1_0__0_in_rule__Note__Group_4_1__0__Impl11861);
            	    rule__Note__Group_4_1_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getGroup_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_1__0__Impl"


    // $ANTLR start "rule__Note__Group_4_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5744:1: rule__Note__Group_4_1__1 : rule__Note__Group_4_1__1__Impl rule__Note__Group_4_1__2 ;
    public final void rule__Note__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5748:1: ( rule__Note__Group_4_1__1__Impl rule__Note__Group_4_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5749:2: rule__Note__Group_4_1__1__Impl rule__Note__Group_4_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_4_1__1__Impl_in_rule__Note__Group_4_1__111892);
            rule__Note__Group_4_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_4_1__2_in_rule__Note__Group_4_1__111895);
            rule__Note__Group_4_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_1__1"


    // $ANTLR start "rule__Note__Group_4_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5756:1: rule__Note__Group_4_1__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Note__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5760:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5761:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5761:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5762:1: RULE_NEWLINE
            {
             before(grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_4_1_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Note__Group_4_1__1__Impl11922); 
             after(grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_1__1__Impl"


    // $ANTLR start "rule__Note__Group_4_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5773:1: rule__Note__Group_4_1__2 : rule__Note__Group_4_1__2__Impl rule__Note__Group_4_1__3 ;
    public final void rule__Note__Group_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5777:1: ( rule__Note__Group_4_1__2__Impl rule__Note__Group_4_1__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5778:2: rule__Note__Group_4_1__2__Impl rule__Note__Group_4_1__3
            {
            pushFollow(FOLLOW_rule__Note__Group_4_1__2__Impl_in_rule__Note__Group_4_1__211951);
            rule__Note__Group_4_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_4_1__3_in_rule__Note__Group_4_1__211954);
            rule__Note__Group_4_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_1__2"


    // $ANTLR start "rule__Note__Group_4_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5785:1: rule__Note__Group_4_1__2__Impl : ( End ) ;
    public final void rule__Note__Group_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5789:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5790:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5790:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5791:1: End
            {
             before(grammarAccess.getNoteAccess().getEndKeyword_4_1_2()); 
            match(input,End,FOLLOW_End_in_rule__Note__Group_4_1__2__Impl11982); 
             after(grammarAccess.getNoteAccess().getEndKeyword_4_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_1__2__Impl"


    // $ANTLR start "rule__Note__Group_4_1__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5804:1: rule__Note__Group_4_1__3 : rule__Note__Group_4_1__3__Impl ;
    public final void rule__Note__Group_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5808:1: ( rule__Note__Group_4_1__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5809:2: rule__Note__Group_4_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_4_1__3__Impl_in_rule__Note__Group_4_1__312013);
            rule__Note__Group_4_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_1__3"


    // $ANTLR start "rule__Note__Group_4_1__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5815:1: rule__Note__Group_4_1__3__Impl : ( Note ) ;
    public final void rule__Note__Group_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5819:1: ( ( Note ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5820:1: ( Note )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5820:1: ( Note )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5821:1: Note
            {
             before(grammarAccess.getNoteAccess().getNoteKeyword_4_1_3()); 
            match(input,Note,FOLLOW_Note_in_rule__Note__Group_4_1__3__Impl12041); 
             after(grammarAccess.getNoteAccess().getNoteKeyword_4_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_1__3__Impl"


    // $ANTLR start "rule__Note__Group_4_1_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5842:1: rule__Note__Group_4_1_0__0 : rule__Note__Group_4_1_0__0__Impl rule__Note__Group_4_1_0__1 ;
    public final void rule__Note__Group_4_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5846:1: ( rule__Note__Group_4_1_0__0__Impl rule__Note__Group_4_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5847:2: rule__Note__Group_4_1_0__0__Impl rule__Note__Group_4_1_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_4_1_0__0__Impl_in_rule__Note__Group_4_1_0__012080);
            rule__Note__Group_4_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_4_1_0__1_in_rule__Note__Group_4_1_0__012083);
            rule__Note__Group_4_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_1_0__0"


    // $ANTLR start "rule__Note__Group_4_1_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5854:1: rule__Note__Group_4_1_0__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Note__Group_4_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5858:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5859:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5859:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5860:1: RULE_NEWLINE
            {
             before(grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_4_1_0_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Note__Group_4_1_0__0__Impl12110); 
             after(grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_4_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_1_0__0__Impl"


    // $ANTLR start "rule__Note__Group_4_1_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5871:1: rule__Note__Group_4_1_0__1 : rule__Note__Group_4_1_0__1__Impl ;
    public final void rule__Note__Group_4_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5875:1: ( rule__Note__Group_4_1_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5876:2: rule__Note__Group_4_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_4_1_0__1__Impl_in_rule__Note__Group_4_1_0__112139);
            rule__Note__Group_4_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_1_0__1"


    // $ANTLR start "rule__Note__Group_4_1_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5882:1: rule__Note__Group_4_1_0__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Note__Group_4_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5886:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5887:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5887:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5888:1: ( RULE_ID )*
            {
             before(grammarAccess.getNoteAccess().getIDTerminalRuleCall_4_1_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5889:1: ( RULE_ID )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_ID) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5889:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__Group_4_1_0__1__Impl12167); 

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getIDTerminalRuleCall_4_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_4_1_0__1__Impl"


    // $ANTLR start "rule__Divider__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5903:1: rule__Divider__Group__0 : rule__Divider__Group__0__Impl rule__Divider__Group__1 ;
    public final void rule__Divider__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5907:1: ( rule__Divider__Group__0__Impl rule__Divider__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5908:2: rule__Divider__Group__0__Impl rule__Divider__Group__1
            {
            pushFollow(FOLLOW_rule__Divider__Group__0__Impl_in_rule__Divider__Group__012202);
            rule__Divider__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Divider__Group__1_in_rule__Divider__Group__012205);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5915:1: rule__Divider__Group__0__Impl : ( EqualsSignEqualsSign ) ;
    public final void rule__Divider__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5919:1: ( ( EqualsSignEqualsSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5920:1: ( EqualsSignEqualsSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5920:1: ( EqualsSignEqualsSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5921:1: EqualsSignEqualsSign
            {
             before(grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_0()); 
            match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__0__Impl12233); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5934:1: rule__Divider__Group__1 : rule__Divider__Group__1__Impl rule__Divider__Group__2 ;
    public final void rule__Divider__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5938:1: ( rule__Divider__Group__1__Impl rule__Divider__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5939:2: rule__Divider__Group__1__Impl rule__Divider__Group__2
            {
            pushFollow(FOLLOW_rule__Divider__Group__1__Impl_in_rule__Divider__Group__112264);
            rule__Divider__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Divider__Group__2_in_rule__Divider__Group__112267);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5946:1: rule__Divider__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Divider__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5950:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5951:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5951:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5952:1: ( RULE_ID )*
            {
             before(grammarAccess.getDividerAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5953:1: ( RULE_ID )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_ID) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5953:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Divider__Group__1__Impl12295); 

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5963:1: rule__Divider__Group__2 : rule__Divider__Group__2__Impl ;
    public final void rule__Divider__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5967:1: ( rule__Divider__Group__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5968:2: rule__Divider__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Divider__Group__2__Impl_in_rule__Divider__Group__212326);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5974:1: rule__Divider__Group__2__Impl : ( EqualsSignEqualsSign ) ;
    public final void rule__Divider__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5978:1: ( ( EqualsSignEqualsSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5979:1: ( EqualsSignEqualsSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5979:1: ( EqualsSignEqualsSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5980:1: EqualsSignEqualsSign
            {
             before(grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_2()); 
            match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__2__Impl12354); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5999:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6003:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6004:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__012391);
            rule__Reference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__012394);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6011:1: rule__Reference__Group__0__Impl : ( Ref ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6015:1: ( ( Ref ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6016:1: ( Ref )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6016:1: ( Ref )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6017:1: Ref
            {
             before(grammarAccess.getReferenceAccess().getRefKeyword_0()); 
            match(input,Ref,FOLLOW_Ref_in_rule__Reference__Group__0__Impl12422); 
             after(grammarAccess.getReferenceAccess().getRefKeyword_0()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6030:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6034:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6035:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
            {
            pushFollow(FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__112453);
            rule__Reference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__112456);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6042:1: rule__Reference__Group__1__Impl : ( Over ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6046:1: ( ( Over ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6047:1: ( Over )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6047:1: ( Over )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6048:1: Over
            {
             before(grammarAccess.getReferenceAccess().getOverKeyword_1()); 
            match(input,Over,FOLLOW_Over_in_rule__Reference__Group__1__Impl12484); 
             after(grammarAccess.getReferenceAccess().getOverKeyword_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6061:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6065:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6066:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
            {
            pushFollow(FOLLOW_rule__Reference__Group__2__Impl_in_rule__Reference__Group__212515);
            rule__Reference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__212518);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6073:1: rule__Reference__Group__2__Impl : ( ( rule__Reference__IdAssignment_2 ) ) ;
    public final void rule__Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6077:1: ( ( ( rule__Reference__IdAssignment_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6078:1: ( ( rule__Reference__IdAssignment_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6078:1: ( ( rule__Reference__IdAssignment_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6079:1: ( rule__Reference__IdAssignment_2 )
            {
             before(grammarAccess.getReferenceAccess().getIdAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6080:1: ( rule__Reference__IdAssignment_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6080:2: rule__Reference__IdAssignment_2
            {
            pushFollow(FOLLOW_rule__Reference__IdAssignment_2_in_rule__Reference__Group__2__Impl12545);
            rule__Reference__IdAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getIdAssignment_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6090:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6094:1: ( rule__Reference__Group__3__Impl rule__Reference__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6095:2: rule__Reference__Group__3__Impl rule__Reference__Group__4
            {
            pushFollow(FOLLOW_rule__Reference__Group__3__Impl_in_rule__Reference__Group__312575);
            rule__Reference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__312578);
            rule__Reference__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6102:1: rule__Reference__Group__3__Impl : ( ( rule__Reference__Group_3__0 )* ) ;
    public final void rule__Reference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6106:1: ( ( ( rule__Reference__Group_3__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6107:1: ( ( rule__Reference__Group_3__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6107:1: ( ( rule__Reference__Group_3__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6108:1: ( rule__Reference__Group_3__0 )*
            {
             before(grammarAccess.getReferenceAccess().getGroup_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6109:1: ( rule__Reference__Group_3__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==Comma) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6109:2: rule__Reference__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Reference__Group_3__0_in_rule__Reference__Group__3__Impl12605);
            	    rule__Reference__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getGroup_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Reference__Group__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6119:1: rule__Reference__Group__4 : rule__Reference__Group__4__Impl ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6123:1: ( rule__Reference__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6124:2: rule__Reference__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group__4__Impl_in_rule__Reference__Group__412636);
            rule__Reference__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__4"


    // $ANTLR start "rule__Reference__Group__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6130:1: rule__Reference__Group__4__Impl : ( ( rule__Reference__Alternatives_4 ) ) ;
    public final void rule__Reference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6134:1: ( ( ( rule__Reference__Alternatives_4 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6135:1: ( ( rule__Reference__Alternatives_4 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6135:1: ( ( rule__Reference__Alternatives_4 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6136:1: ( rule__Reference__Alternatives_4 )
            {
             before(grammarAccess.getReferenceAccess().getAlternatives_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6137:1: ( rule__Reference__Alternatives_4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6137:2: rule__Reference__Alternatives_4
            {
            pushFollow(FOLLOW_rule__Reference__Alternatives_4_in_rule__Reference__Group__4__Impl12663);
            rule__Reference__Alternatives_4();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__4__Impl"


    // $ANTLR start "rule__Reference__Group_3__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6157:1: rule__Reference__Group_3__0 : rule__Reference__Group_3__0__Impl rule__Reference__Group_3__1 ;
    public final void rule__Reference__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6161:1: ( rule__Reference__Group_3__0__Impl rule__Reference__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6162:2: rule__Reference__Group_3__0__Impl rule__Reference__Group_3__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_3__0__Impl_in_rule__Reference__Group_3__012703);
            rule__Reference__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_3__1_in_rule__Reference__Group_3__012706);
            rule__Reference__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3__0"


    // $ANTLR start "rule__Reference__Group_3__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6169:1: rule__Reference__Group_3__0__Impl : ( Comma ) ;
    public final void rule__Reference__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6173:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6174:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6174:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6175:1: Comma
            {
             before(grammarAccess.getReferenceAccess().getCommaKeyword_3_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Reference__Group_3__0__Impl12734); 
             after(grammarAccess.getReferenceAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3__0__Impl"


    // $ANTLR start "rule__Reference__Group_3__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6188:1: rule__Reference__Group_3__1 : rule__Reference__Group_3__1__Impl ;
    public final void rule__Reference__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6192:1: ( rule__Reference__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6193:2: rule__Reference__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_3__1__Impl_in_rule__Reference__Group_3__112765);
            rule__Reference__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3__1"


    // $ANTLR start "rule__Reference__Group_3__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6199:1: rule__Reference__Group_3__1__Impl : ( ( rule__Reference__IdsAssignment_3_1 ) ) ;
    public final void rule__Reference__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6203:1: ( ( ( rule__Reference__IdsAssignment_3_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6204:1: ( ( rule__Reference__IdsAssignment_3_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6204:1: ( ( rule__Reference__IdsAssignment_3_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6205:1: ( rule__Reference__IdsAssignment_3_1 )
            {
             before(grammarAccess.getReferenceAccess().getIdsAssignment_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6206:1: ( rule__Reference__IdsAssignment_3_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6206:2: rule__Reference__IdsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Reference__IdsAssignment_3_1_in_rule__Reference__Group_3__1__Impl12792);
            rule__Reference__IdsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getIdsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3__1__Impl"


    // $ANTLR start "rule__Reference__Group_4_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6220:1: rule__Reference__Group_4_0__0 : rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1 ;
    public final void rule__Reference__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6224:1: ( rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6225:2: rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_0__0__Impl_in_rule__Reference__Group_4_0__012826);
            rule__Reference__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_0__1_in_rule__Reference__Group_4_0__012829);
            rule__Reference__Group_4_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__0"


    // $ANTLR start "rule__Reference__Group_4_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6232:1: rule__Reference__Group_4_0__0__Impl : ( Colon ) ;
    public final void rule__Reference__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6236:1: ( ( Colon ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6237:1: ( Colon )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6237:1: ( Colon )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6238:1: Colon
            {
             before(grammarAccess.getReferenceAccess().getColonKeyword_4_0_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Reference__Group_4_0__0__Impl12857); 
             after(grammarAccess.getReferenceAccess().getColonKeyword_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__0__Impl"


    // $ANTLR start "rule__Reference__Group_4_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6251:1: rule__Reference__Group_4_0__1 : rule__Reference__Group_4_0__1__Impl ;
    public final void rule__Reference__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6255:1: ( rule__Reference__Group_4_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6256:2: rule__Reference__Group_4_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_0__1__Impl_in_rule__Reference__Group_4_0__112888);
            rule__Reference__Group_4_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__1"


    // $ANTLR start "rule__Reference__Group_4_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6262:1: rule__Reference__Group_4_0__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Reference__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6266:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6267:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6267:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6268:1: ( RULE_ID )*
            {
             before(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_4_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6269:1: ( RULE_ID )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_ID) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6269:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__Group_4_0__1__Impl12916); 

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_4_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__1__Impl"


    // $ANTLR start "rule__Reference__Group_4_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6283:1: rule__Reference__Group_4_1__0 : rule__Reference__Group_4_1__0__Impl rule__Reference__Group_4_1__1 ;
    public final void rule__Reference__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6287:1: ( rule__Reference__Group_4_1__0__Impl rule__Reference__Group_4_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6288:2: rule__Reference__Group_4_1__0__Impl rule__Reference__Group_4_1__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1__0__Impl_in_rule__Reference__Group_4_1__012951);
            rule__Reference__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_1__1_in_rule__Reference__Group_4_1__012954);
            rule__Reference__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1__0"


    // $ANTLR start "rule__Reference__Group_4_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6295:1: rule__Reference__Group_4_1__0__Impl : ( ( rule__Reference__Group_4_1_0__0 )* ) ;
    public final void rule__Reference__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6299:1: ( ( ( rule__Reference__Group_4_1_0__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6300:1: ( ( rule__Reference__Group_4_1_0__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6300:1: ( ( rule__Reference__Group_4_1_0__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6301:1: ( rule__Reference__Group_4_1_0__0 )*
            {
             before(grammarAccess.getReferenceAccess().getGroup_4_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6302:1: ( rule__Reference__Group_4_1_0__0 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_NEWLINE) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6302:2: rule__Reference__Group_4_1_0__0
            	    {
            	    pushFollow(FOLLOW_rule__Reference__Group_4_1_0__0_in_rule__Reference__Group_4_1__0__Impl12981);
            	    rule__Reference__Group_4_1_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getGroup_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1__0__Impl"


    // $ANTLR start "rule__Reference__Group_4_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6312:1: rule__Reference__Group_4_1__1 : rule__Reference__Group_4_1__1__Impl rule__Reference__Group_4_1__2 ;
    public final void rule__Reference__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6316:1: ( rule__Reference__Group_4_1__1__Impl rule__Reference__Group_4_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6317:2: rule__Reference__Group_4_1__1__Impl rule__Reference__Group_4_1__2
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1__1__Impl_in_rule__Reference__Group_4_1__113012);
            rule__Reference__Group_4_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_1__2_in_rule__Reference__Group_4_1__113015);
            rule__Reference__Group_4_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1__1"


    // $ANTLR start "rule__Reference__Group_4_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6324:1: rule__Reference__Group_4_1__1__Impl : ( End ) ;
    public final void rule__Reference__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6328:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6329:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6329:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6330:1: End
            {
             before(grammarAccess.getReferenceAccess().getEndKeyword_4_1_1()); 
            match(input,End,FOLLOW_End_in_rule__Reference__Group_4_1__1__Impl13043); 
             after(grammarAccess.getReferenceAccess().getEndKeyword_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1__1__Impl"


    // $ANTLR start "rule__Reference__Group_4_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6343:1: rule__Reference__Group_4_1__2 : rule__Reference__Group_4_1__2__Impl ;
    public final void rule__Reference__Group_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6347:1: ( rule__Reference__Group_4_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6348:2: rule__Reference__Group_4_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1__2__Impl_in_rule__Reference__Group_4_1__213074);
            rule__Reference__Group_4_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1__2"


    // $ANTLR start "rule__Reference__Group_4_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6354:1: rule__Reference__Group_4_1__2__Impl : ( Ref ) ;
    public final void rule__Reference__Group_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6358:1: ( ( Ref ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6359:1: ( Ref )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6359:1: ( Ref )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6360:1: Ref
            {
             before(grammarAccess.getReferenceAccess().getRefKeyword_4_1_2()); 
            match(input,Ref,FOLLOW_Ref_in_rule__Reference__Group_4_1__2__Impl13102); 
             after(grammarAccess.getReferenceAccess().getRefKeyword_4_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1__2__Impl"


    // $ANTLR start "rule__Reference__Group_4_1_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6379:1: rule__Reference__Group_4_1_0__0 : rule__Reference__Group_4_1_0__0__Impl rule__Reference__Group_4_1_0__1 ;
    public final void rule__Reference__Group_4_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6383:1: ( rule__Reference__Group_4_1_0__0__Impl rule__Reference__Group_4_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6384:2: rule__Reference__Group_4_1_0__0__Impl rule__Reference__Group_4_1_0__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1_0__0__Impl_in_rule__Reference__Group_4_1_0__013139);
            rule__Reference__Group_4_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_1_0__1_in_rule__Reference__Group_4_1_0__013142);
            rule__Reference__Group_4_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1_0__0"


    // $ANTLR start "rule__Reference__Group_4_1_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6391:1: rule__Reference__Group_4_1_0__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Reference__Group_4_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6395:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6396:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6396:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6397:1: RULE_NEWLINE
            {
             before(grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_4_1_0_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Reference__Group_4_1_0__0__Impl13169); 
             after(grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_4_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1_0__0__Impl"


    // $ANTLR start "rule__Reference__Group_4_1_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6408:1: rule__Reference__Group_4_1_0__1 : rule__Reference__Group_4_1_0__1__Impl ;
    public final void rule__Reference__Group_4_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6412:1: ( rule__Reference__Group_4_1_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6413:2: rule__Reference__Group_4_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1_0__1__Impl_in_rule__Reference__Group_4_1_0__113198);
            rule__Reference__Group_4_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1_0__1"


    // $ANTLR start "rule__Reference__Group_4_1_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6419:1: rule__Reference__Group_4_1_0__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Reference__Group_4_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6423:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6424:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6424:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6425:1: ( RULE_ID )*
            {
             before(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_4_1_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6426:1: ( RULE_ID )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6426:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__Group_4_1_0__1__Impl13226); 

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_4_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1_0__1__Impl"


    // $ANTLR start "rule__Delay__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6440:1: rule__Delay__Group__0 : rule__Delay__Group__0__Impl rule__Delay__Group__1 ;
    public final void rule__Delay__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6444:1: ( rule__Delay__Group__0__Impl rule__Delay__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6445:2: rule__Delay__Group__0__Impl rule__Delay__Group__1
            {
            pushFollow(FOLLOW_rule__Delay__Group__0__Impl_in_rule__Delay__Group__013261);
            rule__Delay__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Delay__Group__1_in_rule__Delay__Group__013264);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6452:1: rule__Delay__Group__0__Impl : ( FullStopFullStopFullStop ) ;
    public final void rule__Delay__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6456:1: ( ( FullStopFullStopFullStop ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6457:1: ( FullStopFullStopFullStop )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6457:1: ( FullStopFullStopFullStop )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6458:1: FullStopFullStopFullStop
            {
             before(grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_0()); 
            match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group__0__Impl13292); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6471:1: rule__Delay__Group__1 : rule__Delay__Group__1__Impl ;
    public final void rule__Delay__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6475:1: ( rule__Delay__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6476:2: rule__Delay__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Delay__Group__1__Impl_in_rule__Delay__Group__113323);
            rule__Delay__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6482:1: rule__Delay__Group__1__Impl : ( ( rule__Delay__Group_1__0 )? ) ;
    public final void rule__Delay__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6486:1: ( ( ( rule__Delay__Group_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6487:1: ( ( rule__Delay__Group_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6487:1: ( ( rule__Delay__Group_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6488:1: ( rule__Delay__Group_1__0 )?
            {
             before(grammarAccess.getDelayAccess().getGroup_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6489:1: ( rule__Delay__Group_1__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==FullStopFullStopFullStop||LA47_0==RULE_ID) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6489:2: rule__Delay__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Delay__Group_1__0_in_rule__Delay__Group__1__Impl13350);
                    rule__Delay__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDelayAccess().getGroup_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Delay__Group_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6503:1: rule__Delay__Group_1__0 : rule__Delay__Group_1__0__Impl rule__Delay__Group_1__1 ;
    public final void rule__Delay__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6507:1: ( rule__Delay__Group_1__0__Impl rule__Delay__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6508:2: rule__Delay__Group_1__0__Impl rule__Delay__Group_1__1
            {
            pushFollow(FOLLOW_rule__Delay__Group_1__0__Impl_in_rule__Delay__Group_1__013385);
            rule__Delay__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Delay__Group_1__1_in_rule__Delay__Group_1__013388);
            rule__Delay__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Delay__Group_1__0"


    // $ANTLR start "rule__Delay__Group_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6515:1: rule__Delay__Group_1__0__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Delay__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6519:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6520:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6520:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6521:1: ( RULE_ID )*
            {
             before(grammarAccess.getDelayAccess().getIDTerminalRuleCall_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6522:1: ( RULE_ID )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_ID) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6522:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Delay__Group_1__0__Impl13416); 

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

             after(grammarAccess.getDelayAccess().getIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Delay__Group_1__0__Impl"


    // $ANTLR start "rule__Delay__Group_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6532:1: rule__Delay__Group_1__1 : rule__Delay__Group_1__1__Impl ;
    public final void rule__Delay__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6536:1: ( rule__Delay__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6537:2: rule__Delay__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Delay__Group_1__1__Impl_in_rule__Delay__Group_1__113447);
            rule__Delay__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Delay__Group_1__1"


    // $ANTLR start "rule__Delay__Group_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6543:1: rule__Delay__Group_1__1__Impl : ( FullStopFullStopFullStop ) ;
    public final void rule__Delay__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6547:1: ( ( FullStopFullStopFullStop ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6548:1: ( FullStopFullStopFullStop )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6548:1: ( FullStopFullStopFullStop )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6549:1: FullStopFullStopFullStop
            {
             before(grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_1_1()); 
            match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group_1__1__Impl13475); 
             after(grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Delay__Group_1__1__Impl"


    // $ANTLR start "rule__Space__Group_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6566:1: rule__Space__Group_1__0 : rule__Space__Group_1__0__Impl rule__Space__Group_1__1 ;
    public final void rule__Space__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6570:1: ( rule__Space__Group_1__0__Impl rule__Space__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6571:2: rule__Space__Group_1__0__Impl rule__Space__Group_1__1
            {
            pushFollow(FOLLOW_rule__Space__Group_1__0__Impl_in_rule__Space__Group_1__013510);
            rule__Space__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Space__Group_1__1_in_rule__Space__Group_1__013513);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6578:1: rule__Space__Group_1__0__Impl : ( VerticalLineVerticalLine ) ;
    public final void rule__Space__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6582:1: ( ( VerticalLineVerticalLine ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6583:1: ( VerticalLineVerticalLine )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6583:1: ( VerticalLineVerticalLine )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6584:1: VerticalLineVerticalLine
            {
             before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_0()); 
            match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__0__Impl13541); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6597:1: rule__Space__Group_1__1 : rule__Space__Group_1__1__Impl rule__Space__Group_1__2 ;
    public final void rule__Space__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6601:1: ( rule__Space__Group_1__1__Impl rule__Space__Group_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6602:2: rule__Space__Group_1__1__Impl rule__Space__Group_1__2
            {
            pushFollow(FOLLOW_rule__Space__Group_1__1__Impl_in_rule__Space__Group_1__113572);
            rule__Space__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Space__Group_1__2_in_rule__Space__Group_1__113575);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6609:1: rule__Space__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__Space__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6613:1: ( ( RULE_INT ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6614:1: ( RULE_INT )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6614:1: ( RULE_INT )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6615:1: RULE_INT
            {
             before(grammarAccess.getSpaceAccess().getINTTerminalRuleCall_1_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Space__Group_1__1__Impl13602); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6626:1: rule__Space__Group_1__2 : rule__Space__Group_1__2__Impl ;
    public final void rule__Space__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6630:1: ( rule__Space__Group_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6631:2: rule__Space__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Space__Group_1__2__Impl_in_rule__Space__Group_1__213631);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6637:1: rule__Space__Group_1__2__Impl : ( VerticalLineVerticalLine ) ;
    public final void rule__Space__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6641:1: ( ( VerticalLineVerticalLine ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6642:1: ( VerticalLineVerticalLine )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6642:1: ( VerticalLineVerticalLine )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6643:1: VerticalLineVerticalLine
            {
             before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_2()); 
            match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__2__Impl13659); 
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


    // $ANTLR start "rule__Hidefootbox__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6662:1: rule__Hidefootbox__Group__0 : rule__Hidefootbox__Group__0__Impl rule__Hidefootbox__Group__1 ;
    public final void rule__Hidefootbox__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6666:1: ( rule__Hidefootbox__Group__0__Impl rule__Hidefootbox__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6667:2: rule__Hidefootbox__Group__0__Impl rule__Hidefootbox__Group__1
            {
            pushFollow(FOLLOW_rule__Hidefootbox__Group__0__Impl_in_rule__Hidefootbox__Group__013696);
            rule__Hidefootbox__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Hidefootbox__Group__1_in_rule__Hidefootbox__Group__013699);
            rule__Hidefootbox__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Hidefootbox__Group__0"


    // $ANTLR start "rule__Hidefootbox__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6674:1: rule__Hidefootbox__Group__0__Impl : ( Hide ) ;
    public final void rule__Hidefootbox__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6678:1: ( ( Hide ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6679:1: ( Hide )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6679:1: ( Hide )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6680:1: Hide
            {
             before(grammarAccess.getHidefootboxAccess().getHideKeyword_0()); 
            match(input,Hide,FOLLOW_Hide_in_rule__Hidefootbox__Group__0__Impl13727); 
             after(grammarAccess.getHidefootboxAccess().getHideKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Hidefootbox__Group__0__Impl"


    // $ANTLR start "rule__Hidefootbox__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6693:1: rule__Hidefootbox__Group__1 : rule__Hidefootbox__Group__1__Impl ;
    public final void rule__Hidefootbox__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6697:1: ( rule__Hidefootbox__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6698:2: rule__Hidefootbox__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Hidefootbox__Group__1__Impl_in_rule__Hidefootbox__Group__113758);
            rule__Hidefootbox__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Hidefootbox__Group__1"


    // $ANTLR start "rule__Hidefootbox__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6704:1: rule__Hidefootbox__Group__1__Impl : ( Footbox ) ;
    public final void rule__Hidefootbox__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6708:1: ( ( Footbox ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6709:1: ( Footbox )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6709:1: ( Footbox )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6710:1: Footbox
            {
             before(grammarAccess.getHidefootboxAccess().getFootboxKeyword_1()); 
            match(input,Footbox,FOLLOW_Footbox_in_rule__Hidefootbox__Group__1__Impl13786); 
             after(grammarAccess.getHidefootboxAccess().getFootboxKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Hidefootbox__Group__1__Impl"


    // $ANTLR start "rule__Activate__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6727:1: rule__Activate__Group__0 : rule__Activate__Group__0__Impl rule__Activate__Group__1 ;
    public final void rule__Activate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6731:1: ( rule__Activate__Group__0__Impl rule__Activate__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6732:2: rule__Activate__Group__0__Impl rule__Activate__Group__1
            {
            pushFollow(FOLLOW_rule__Activate__Group__0__Impl_in_rule__Activate__Group__013821);
            rule__Activate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Activate__Group__1_in_rule__Activate__Group__013824);
            rule__Activate__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activate__Group__0"


    // $ANTLR start "rule__Activate__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6739:1: rule__Activate__Group__0__Impl : ( Activate ) ;
    public final void rule__Activate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6743:1: ( ( Activate ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6744:1: ( Activate )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6744:1: ( Activate )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6745:1: Activate
            {
             before(grammarAccess.getActivateAccess().getActivateKeyword_0()); 
            match(input,Activate,FOLLOW_Activate_in_rule__Activate__Group__0__Impl13852); 
             after(grammarAccess.getActivateAccess().getActivateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activate__Group__0__Impl"


    // $ANTLR start "rule__Activate__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6758:1: rule__Activate__Group__1 : rule__Activate__Group__1__Impl rule__Activate__Group__2 ;
    public final void rule__Activate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6762:1: ( rule__Activate__Group__1__Impl rule__Activate__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6763:2: rule__Activate__Group__1__Impl rule__Activate__Group__2
            {
            pushFollow(FOLLOW_rule__Activate__Group__1__Impl_in_rule__Activate__Group__113883);
            rule__Activate__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Activate__Group__2_in_rule__Activate__Group__113886);
            rule__Activate__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activate__Group__1"


    // $ANTLR start "rule__Activate__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6770:1: rule__Activate__Group__1__Impl : ( ( ruleColor )? ) ;
    public final void rule__Activate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6774:1: ( ( ( ruleColor )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6775:1: ( ( ruleColor )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6775:1: ( ( ruleColor )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6776:1: ( ruleColor )?
            {
             before(grammarAccess.getActivateAccess().getColorParserRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6777:1: ( ruleColor )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==NumberSign) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6777:3: ruleColor
                    {
                    pushFollow(FOLLOW_ruleColor_in_rule__Activate__Group__1__Impl13914);
                    ruleColor();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActivateAccess().getColorParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activate__Group__1__Impl"


    // $ANTLR start "rule__Activate__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6787:1: rule__Activate__Group__2 : rule__Activate__Group__2__Impl ;
    public final void rule__Activate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6791:1: ( rule__Activate__Group__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6792:2: rule__Activate__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Activate__Group__2__Impl_in_rule__Activate__Group__213945);
            rule__Activate__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activate__Group__2"


    // $ANTLR start "rule__Activate__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6798:1: rule__Activate__Group__2__Impl : ( ( rule__Activate__NameAssignment_2 ) ) ;
    public final void rule__Activate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6802:1: ( ( ( rule__Activate__NameAssignment_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6803:1: ( ( rule__Activate__NameAssignment_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6803:1: ( ( rule__Activate__NameAssignment_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6804:1: ( rule__Activate__NameAssignment_2 )
            {
             before(grammarAccess.getActivateAccess().getNameAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6805:1: ( rule__Activate__NameAssignment_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6805:2: rule__Activate__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__Activate__NameAssignment_2_in_rule__Activate__Group__2__Impl13972);
            rule__Activate__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getActivateAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activate__Group__2__Impl"


    // $ANTLR start "rule__Deactivate__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6821:1: rule__Deactivate__Group__0 : rule__Deactivate__Group__0__Impl rule__Deactivate__Group__1 ;
    public final void rule__Deactivate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6825:1: ( rule__Deactivate__Group__0__Impl rule__Deactivate__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6826:2: rule__Deactivate__Group__0__Impl rule__Deactivate__Group__1
            {
            pushFollow(FOLLOW_rule__Deactivate__Group__0__Impl_in_rule__Deactivate__Group__014008);
            rule__Deactivate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Deactivate__Group__1_in_rule__Deactivate__Group__014011);
            rule__Deactivate__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Deactivate__Group__0"


    // $ANTLR start "rule__Deactivate__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6833:1: rule__Deactivate__Group__0__Impl : ( ( rule__Deactivate__Alternatives_0 ) ) ;
    public final void rule__Deactivate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6837:1: ( ( ( rule__Deactivate__Alternatives_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6838:1: ( ( rule__Deactivate__Alternatives_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6838:1: ( ( rule__Deactivate__Alternatives_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6839:1: ( rule__Deactivate__Alternatives_0 )
            {
             before(grammarAccess.getDeactivateAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6840:1: ( rule__Deactivate__Alternatives_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6840:2: rule__Deactivate__Alternatives_0
            {
            pushFollow(FOLLOW_rule__Deactivate__Alternatives_0_in_rule__Deactivate__Group__0__Impl14038);
            rule__Deactivate__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getDeactivateAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Deactivate__Group__0__Impl"


    // $ANTLR start "rule__Deactivate__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6850:1: rule__Deactivate__Group__1 : rule__Deactivate__Group__1__Impl ;
    public final void rule__Deactivate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6854:1: ( rule__Deactivate__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6855:2: rule__Deactivate__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Deactivate__Group__1__Impl_in_rule__Deactivate__Group__114068);
            rule__Deactivate__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Deactivate__Group__1"


    // $ANTLR start "rule__Deactivate__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6861:1: rule__Deactivate__Group__1__Impl : ( ( rule__Deactivate__IdAssignment_1 ) ) ;
    public final void rule__Deactivate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6865:1: ( ( ( rule__Deactivate__IdAssignment_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6866:1: ( ( rule__Deactivate__IdAssignment_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6866:1: ( ( rule__Deactivate__IdAssignment_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6867:1: ( rule__Deactivate__IdAssignment_1 )
            {
             before(grammarAccess.getDeactivateAccess().getIdAssignment_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6868:1: ( rule__Deactivate__IdAssignment_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6868:2: rule__Deactivate__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__Deactivate__IdAssignment_1_in_rule__Deactivate__Group__1__Impl14095);
            rule__Deactivate__IdAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDeactivateAccess().getIdAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Deactivate__Group__1__Impl"


    // $ANTLR start "rule__ParticipantCreation__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6882:1: rule__ParticipantCreation__Group__0 : rule__ParticipantCreation__Group__0__Impl rule__ParticipantCreation__Group__1 ;
    public final void rule__ParticipantCreation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6886:1: ( rule__ParticipantCreation__Group__0__Impl rule__ParticipantCreation__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6887:2: rule__ParticipantCreation__Group__0__Impl rule__ParticipantCreation__Group__1
            {
            pushFollow(FOLLOW_rule__ParticipantCreation__Group__0__Impl_in_rule__ParticipantCreation__Group__014129);
            rule__ParticipantCreation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParticipantCreation__Group__1_in_rule__ParticipantCreation__Group__014132);
            rule__ParticipantCreation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParticipantCreation__Group__0"


    // $ANTLR start "rule__ParticipantCreation__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6894:1: rule__ParticipantCreation__Group__0__Impl : ( Create ) ;
    public final void rule__ParticipantCreation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6898:1: ( ( Create ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6899:1: ( Create )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6899:1: ( Create )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6900:1: Create
            {
             before(grammarAccess.getParticipantCreationAccess().getCreateKeyword_0()); 
            match(input,Create,FOLLOW_Create_in_rule__ParticipantCreation__Group__0__Impl14160); 
             after(grammarAccess.getParticipantCreationAccess().getCreateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParticipantCreation__Group__0__Impl"


    // $ANTLR start "rule__ParticipantCreation__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6913:1: rule__ParticipantCreation__Group__1 : rule__ParticipantCreation__Group__1__Impl ;
    public final void rule__ParticipantCreation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6917:1: ( rule__ParticipantCreation__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6918:2: rule__ParticipantCreation__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParticipantCreation__Group__1__Impl_in_rule__ParticipantCreation__Group__114191);
            rule__ParticipantCreation__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParticipantCreation__Group__1"


    // $ANTLR start "rule__ParticipantCreation__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6924:1: rule__ParticipantCreation__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__ParticipantCreation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6928:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6929:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6929:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6930:1: RULE_ID
            {
             before(grammarAccess.getParticipantCreationAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParticipantCreation__Group__1__Impl14218); 
             after(grammarAccess.getParticipantCreationAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParticipantCreation__Group__1__Impl"


    // $ANTLR start "rule__Box__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6945:1: rule__Box__Group__0 : rule__Box__Group__0__Impl rule__Box__Group__1 ;
    public final void rule__Box__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6949:1: ( rule__Box__Group__0__Impl rule__Box__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6950:2: rule__Box__Group__0__Impl rule__Box__Group__1
            {
            pushFollow(FOLLOW_rule__Box__Group__0__Impl_in_rule__Box__Group__014251);
            rule__Box__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__1_in_rule__Box__Group__014254);
            rule__Box__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__0"


    // $ANTLR start "rule__Box__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6957:1: rule__Box__Group__0__Impl : ( () ) ;
    public final void rule__Box__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6961:1: ( ( () ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6962:1: ( () )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6962:1: ( () )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6963:1: ()
            {
             before(grammarAccess.getBoxAccess().getBoxAction_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6964:1: ()
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6966:1: 
            {
            }

             after(grammarAccess.getBoxAccess().getBoxAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__0__Impl"


    // $ANTLR start "rule__Box__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6976:1: rule__Box__Group__1 : rule__Box__Group__1__Impl rule__Box__Group__2 ;
    public final void rule__Box__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6980:1: ( rule__Box__Group__1__Impl rule__Box__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6981:2: rule__Box__Group__1__Impl rule__Box__Group__2
            {
            pushFollow(FOLLOW_rule__Box__Group__1__Impl_in_rule__Box__Group__114312);
            rule__Box__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__2_in_rule__Box__Group__114315);
            rule__Box__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__1"


    // $ANTLR start "rule__Box__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6988:1: rule__Box__Group__1__Impl : ( Box ) ;
    public final void rule__Box__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6992:1: ( ( Box ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6993:1: ( Box )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6993:1: ( Box )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6994:1: Box
            {
             before(grammarAccess.getBoxAccess().getBoxKeyword_1()); 
            match(input,Box,FOLLOW_Box_in_rule__Box__Group__1__Impl14343); 
             after(grammarAccess.getBoxAccess().getBoxKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__1__Impl"


    // $ANTLR start "rule__Box__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7007:1: rule__Box__Group__2 : rule__Box__Group__2__Impl rule__Box__Group__3 ;
    public final void rule__Box__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7011:1: ( rule__Box__Group__2__Impl rule__Box__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7012:2: rule__Box__Group__2__Impl rule__Box__Group__3
            {
            pushFollow(FOLLOW_rule__Box__Group__2__Impl_in_rule__Box__Group__214374);
            rule__Box__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__3_in_rule__Box__Group__214377);
            rule__Box__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__2"


    // $ANTLR start "rule__Box__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7019:1: rule__Box__Group__2__Impl : ( QuotationMark ) ;
    public final void rule__Box__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7023:1: ( ( QuotationMark ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7024:1: ( QuotationMark )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7024:1: ( QuotationMark )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7025:1: QuotationMark
            {
             before(grammarAccess.getBoxAccess().getQuotationMarkKeyword_2()); 
            match(input,QuotationMark,FOLLOW_QuotationMark_in_rule__Box__Group__2__Impl14405); 
             after(grammarAccess.getBoxAccess().getQuotationMarkKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__2__Impl"


    // $ANTLR start "rule__Box__Group__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7038:1: rule__Box__Group__3 : rule__Box__Group__3__Impl rule__Box__Group__4 ;
    public final void rule__Box__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7042:1: ( rule__Box__Group__3__Impl rule__Box__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7043:2: rule__Box__Group__3__Impl rule__Box__Group__4
            {
            pushFollow(FOLLOW_rule__Box__Group__3__Impl_in_rule__Box__Group__314436);
            rule__Box__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__4_in_rule__Box__Group__314439);
            rule__Box__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__3"


    // $ANTLR start "rule__Box__Group__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7050:1: rule__Box__Group__3__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Box__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7054:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7055:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7055:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7056:1: ( RULE_ID )*
            {
             before(grammarAccess.getBoxAccess().getIDTerminalRuleCall_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7057:1: ( RULE_ID )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7057:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Box__Group__3__Impl14467); 

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

             after(grammarAccess.getBoxAccess().getIDTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__3__Impl"


    // $ANTLR start "rule__Box__Group__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7067:1: rule__Box__Group__4 : rule__Box__Group__4__Impl rule__Box__Group__5 ;
    public final void rule__Box__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7071:1: ( rule__Box__Group__4__Impl rule__Box__Group__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7072:2: rule__Box__Group__4__Impl rule__Box__Group__5
            {
            pushFollow(FOLLOW_rule__Box__Group__4__Impl_in_rule__Box__Group__414498);
            rule__Box__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__5_in_rule__Box__Group__414501);
            rule__Box__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__4"


    // $ANTLR start "rule__Box__Group__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7079:1: rule__Box__Group__4__Impl : ( QuotationMark ) ;
    public final void rule__Box__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7083:1: ( ( QuotationMark ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7084:1: ( QuotationMark )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7084:1: ( QuotationMark )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7085:1: QuotationMark
            {
             before(grammarAccess.getBoxAccess().getQuotationMarkKeyword_4()); 
            match(input,QuotationMark,FOLLOW_QuotationMark_in_rule__Box__Group__4__Impl14529); 
             after(grammarAccess.getBoxAccess().getQuotationMarkKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__4__Impl"


    // $ANTLR start "rule__Box__Group__5"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7098:1: rule__Box__Group__5 : rule__Box__Group__5__Impl rule__Box__Group__6 ;
    public final void rule__Box__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7102:1: ( rule__Box__Group__5__Impl rule__Box__Group__6 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7103:2: rule__Box__Group__5__Impl rule__Box__Group__6
            {
            pushFollow(FOLLOW_rule__Box__Group__5__Impl_in_rule__Box__Group__514560);
            rule__Box__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__6_in_rule__Box__Group__514563);
            rule__Box__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__5"


    // $ANTLR start "rule__Box__Group__5__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7110:1: rule__Box__Group__5__Impl : ( ( ruleColor )? ) ;
    public final void rule__Box__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7114:1: ( ( ( ruleColor )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7115:1: ( ( ruleColor )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7115:1: ( ( ruleColor )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7116:1: ( ruleColor )?
            {
             before(grammarAccess.getBoxAccess().getColorParserRuleCall_5()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7117:1: ( ruleColor )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==NumberSign) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7117:3: ruleColor
                    {
                    pushFollow(FOLLOW_ruleColor_in_rule__Box__Group__5__Impl14591);
                    ruleColor();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBoxAccess().getColorParserRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__5__Impl"


    // $ANTLR start "rule__Box__Group__6"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7127:1: rule__Box__Group__6 : rule__Box__Group__6__Impl rule__Box__Group__7 ;
    public final void rule__Box__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7131:1: ( rule__Box__Group__6__Impl rule__Box__Group__7 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7132:2: rule__Box__Group__6__Impl rule__Box__Group__7
            {
            pushFollow(FOLLOW_rule__Box__Group__6__Impl_in_rule__Box__Group__614622);
            rule__Box__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__7_in_rule__Box__Group__614625);
            rule__Box__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__6"


    // $ANTLR start "rule__Box__Group__6__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7139:1: rule__Box__Group__6__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Box__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7143:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7144:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7144:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7145:1: RULE_NEWLINE
            {
             before(grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_6()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Box__Group__6__Impl14652); 
             after(grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__6__Impl"


    // $ANTLR start "rule__Box__Group__7"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7156:1: rule__Box__Group__7 : rule__Box__Group__7__Impl rule__Box__Group__8 ;
    public final void rule__Box__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7160:1: ( rule__Box__Group__7__Impl rule__Box__Group__8 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7161:2: rule__Box__Group__7__Impl rule__Box__Group__8
            {
            pushFollow(FOLLOW_rule__Box__Group__7__Impl_in_rule__Box__Group__714681);
            rule__Box__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__8_in_rule__Box__Group__714684);
            rule__Box__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__7"


    // $ANTLR start "rule__Box__Group__7__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7168:1: rule__Box__Group__7__Impl : ( ( rule__Box__Group_7__0 )* ) ;
    public final void rule__Box__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7172:1: ( ( ( rule__Box__Group_7__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7173:1: ( ( rule__Box__Group_7__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7173:1: ( ( rule__Box__Group_7__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7174:1: ( rule__Box__Group_7__0 )*
            {
             before(grammarAccess.getBoxAccess().getGroup_7()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7175:1: ( rule__Box__Group_7__0 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==Participant||LA52_0==Boundary||LA52_0==Database||LA52_0==Control||LA52_0==Entity||LA52_0==Actor||LA52_0==RULE_NEWLINE) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7175:2: rule__Box__Group_7__0
            	    {
            	    pushFollow(FOLLOW_rule__Box__Group_7__0_in_rule__Box__Group__7__Impl14711);
            	    rule__Box__Group_7__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

             after(grammarAccess.getBoxAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__7__Impl"


    // $ANTLR start "rule__Box__Group__8"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7185:1: rule__Box__Group__8 : rule__Box__Group__8__Impl rule__Box__Group__9 ;
    public final void rule__Box__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7189:1: ( rule__Box__Group__8__Impl rule__Box__Group__9 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7190:2: rule__Box__Group__8__Impl rule__Box__Group__9
            {
            pushFollow(FOLLOW_rule__Box__Group__8__Impl_in_rule__Box__Group__814742);
            rule__Box__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__9_in_rule__Box__Group__814745);
            rule__Box__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__8"


    // $ANTLR start "rule__Box__Group__8__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7197:1: rule__Box__Group__8__Impl : ( End ) ;
    public final void rule__Box__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7201:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7202:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7202:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7203:1: End
            {
             before(grammarAccess.getBoxAccess().getEndKeyword_8()); 
            match(input,End,FOLLOW_End_in_rule__Box__Group__8__Impl14773); 
             after(grammarAccess.getBoxAccess().getEndKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__8__Impl"


    // $ANTLR start "rule__Box__Group__9"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7216:1: rule__Box__Group__9 : rule__Box__Group__9__Impl ;
    public final void rule__Box__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7220:1: ( rule__Box__Group__9__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7221:2: rule__Box__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__Box__Group__9__Impl_in_rule__Box__Group__914804);
            rule__Box__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__9"


    // $ANTLR start "rule__Box__Group__9__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7227:1: rule__Box__Group__9__Impl : ( Box ) ;
    public final void rule__Box__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7231:1: ( ( Box ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7232:1: ( Box )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7232:1: ( Box )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7233:1: Box
            {
             before(grammarAccess.getBoxAccess().getBoxKeyword_9()); 
            match(input,Box,FOLLOW_Box_in_rule__Box__Group__9__Impl14832); 
             after(grammarAccess.getBoxAccess().getBoxKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__9__Impl"


    // $ANTLR start "rule__Box__Group_7__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7266:1: rule__Box__Group_7__0 : rule__Box__Group_7__0__Impl rule__Box__Group_7__1 ;
    public final void rule__Box__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7270:1: ( rule__Box__Group_7__0__Impl rule__Box__Group_7__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7271:2: rule__Box__Group_7__0__Impl rule__Box__Group_7__1
            {
            pushFollow(FOLLOW_rule__Box__Group_7__0__Impl_in_rule__Box__Group_7__014883);
            rule__Box__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group_7__1_in_rule__Box__Group_7__014886);
            rule__Box__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group_7__0"


    // $ANTLR start "rule__Box__Group_7__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7278:1: rule__Box__Group_7__0__Impl : ( ( rule__Box__DefinitionsAssignment_7_0 )? ) ;
    public final void rule__Box__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7282:1: ( ( ( rule__Box__DefinitionsAssignment_7_0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7283:1: ( ( rule__Box__DefinitionsAssignment_7_0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7283:1: ( ( rule__Box__DefinitionsAssignment_7_0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7284:1: ( rule__Box__DefinitionsAssignment_7_0 )?
            {
             before(grammarAccess.getBoxAccess().getDefinitionsAssignment_7_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7285:1: ( rule__Box__DefinitionsAssignment_7_0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==Participant||LA53_0==Boundary||LA53_0==Database||LA53_0==Control||LA53_0==Entity||LA53_0==Actor) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7285:2: rule__Box__DefinitionsAssignment_7_0
                    {
                    pushFollow(FOLLOW_rule__Box__DefinitionsAssignment_7_0_in_rule__Box__Group_7__0__Impl14913);
                    rule__Box__DefinitionsAssignment_7_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBoxAccess().getDefinitionsAssignment_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group_7__0__Impl"


    // $ANTLR start "rule__Box__Group_7__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7295:1: rule__Box__Group_7__1 : rule__Box__Group_7__1__Impl ;
    public final void rule__Box__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7299:1: ( rule__Box__Group_7__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7300:2: rule__Box__Group_7__1__Impl
            {
            pushFollow(FOLLOW_rule__Box__Group_7__1__Impl_in_rule__Box__Group_7__114944);
            rule__Box__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group_7__1"


    // $ANTLR start "rule__Box__Group_7__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7306:1: rule__Box__Group_7__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Box__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7310:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7311:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7311:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7312:1: RULE_NEWLINE
            {
             before(grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_7_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Box__Group_7__1__Impl14971); 
             after(grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group_7__1__Impl"


    // $ANTLR start "rule__Plantuml__DiagramsAssignment"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7328:1: rule__Plantuml__DiagramsAssignment : ( ruleDiagram ) ;
    public final void rule__Plantuml__DiagramsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7332:1: ( ( ruleDiagram ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7333:1: ( ruleDiagram )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7333:1: ( ruleDiagram )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7334:1: ruleDiagram
            {
             before(grammarAccess.getPlantumlAccess().getDiagramsDiagramParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDiagram_in_rule__Plantuml__DiagramsAssignment15009);
            ruleDiagram();

            state._fsp--;

             after(grammarAccess.getPlantumlAccess().getDiagramsDiagramParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Plantuml__DiagramsAssignment"


    // $ANTLR start "rule__Diagram__InstructionsAssignment_3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7343:1: rule__Diagram__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__Diagram__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7347:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7348:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7348:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7349:1: ruleInstruction
            {
             before(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_315040);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__InstructionsAssignment_3"


    // $ANTLR start "rule__Arrow__NameAssignment_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7358:1: rule__Arrow__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Arrow__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7362:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7363:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7363:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7364:1: RULE_ID
            {
             before(grammarAccess.getArrowAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Arrow__NameAssignment_015071); 
             after(grammarAccess.getArrowAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__NameAssignment_0"


    // $ANTLR start "rule__Arrow__NameAssignment_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7373:1: rule__Arrow__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Arrow__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7377:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7378:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7378:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7379:1: RULE_ID
            {
             before(grammarAccess.getArrowAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Arrow__NameAssignment_215102); 
             after(grammarAccess.getArrowAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__NameAssignment_2"


    // $ANTLR start "rule__Definition__NameAssignment_0_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7388:1: rule__Definition__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7392:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7393:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7393:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7394:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_115133); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7403:1: rule__Definition__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7407:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7408:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7408:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7409:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_115164); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7418:1: rule__Definition__NameAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7422:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7423:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7423:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7424:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_115195); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7433:1: rule__Definition__NameAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7437:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7438:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7438:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7439:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_115226); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7448:1: rule__Definition__NameAssignment_4_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7452:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7453:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7453:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7454:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_4_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_115257); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7463:1: rule__Definition__NameAssignment_5_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7467:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7468:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7468:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7469:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_5_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_5_115288); 
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


    // $ANTLR start "rule__AltElse__InstructionsAssignment_4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7478:1: rule__AltElse__InstructionsAssignment_4 : ( ruleInstruction ) ;
    public final void rule__AltElse__InstructionsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7482:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7483:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7483:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7484:1: ruleInstruction
            {
             before(grammarAccess.getAltElseAccess().getInstructionsInstructionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__AltElse__InstructionsAssignment_415319);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getAltElseAccess().getInstructionsInstructionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__InstructionsAssignment_4"


    // $ANTLR start "rule__AltElse__ElsesAssignment_5"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7493:1: rule__AltElse__ElsesAssignment_5 : ( ruleElse ) ;
    public final void rule__AltElse__ElsesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7497:1: ( ( ruleElse ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7498:1: ( ruleElse )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7498:1: ( ruleElse )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7499:1: ruleElse
            {
             before(grammarAccess.getAltElseAccess().getElsesElseParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleElse_in_rule__AltElse__ElsesAssignment_515350);
            ruleElse();

            state._fsp--;

             after(grammarAccess.getAltElseAccess().getElsesElseParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__ElsesAssignment_5"


    // $ANTLR start "rule__Else__InstructionsAssignment_4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7508:1: rule__Else__InstructionsAssignment_4 : ( ruleInstruction ) ;
    public final void rule__Else__InstructionsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7512:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7513:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7513:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7514:1: ruleInstruction
            {
             before(grammarAccess.getElseAccess().getInstructionsInstructionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Else__InstructionsAssignment_415381);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getElseAccess().getInstructionsInstructionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Else__InstructionsAssignment_4"


    // $ANTLR start "rule__GroupingMessages__InstructionsAssignment_4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7523:1: rule__GroupingMessages__InstructionsAssignment_4 : ( ruleInstruction ) ;
    public final void rule__GroupingMessages__InstructionsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7527:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7528:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7528:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7529:1: ruleInstruction
            {
             before(grammarAccess.getGroupingMessagesAccess().getInstructionsInstructionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__GroupingMessages__InstructionsAssignment_415412);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getGroupingMessagesAccess().getInstructionsInstructionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__InstructionsAssignment_4"


    // $ANTLR start "rule__Note__RidAssignment_2_0_1_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7538:1: rule__Note__RidAssignment_2_0_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__RidAssignment_2_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7542:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7543:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7543:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7544:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getRidDefinitionCrossReference_2_0_1_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7545:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7546:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getRidDefinitionIDTerminalRuleCall_2_0_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__RidAssignment_2_0_1_115447); 
             after(grammarAccess.getNoteAccess().getRidDefinitionIDTerminalRuleCall_2_0_1_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getRidDefinitionCrossReference_2_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__RidAssignment_2_0_1_1"


    // $ANTLR start "rule__Note__RidsAssignment_2_0_1_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7557:1: rule__Note__RidsAssignment_2_0_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__RidsAssignment_2_0_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7561:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7562:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7562:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7563:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getRidsDefinitionCrossReference_2_0_1_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7564:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7565:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getRidsDefinitionIDTerminalRuleCall_2_0_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__RidsAssignment_2_0_1_2_115486); 
             after(grammarAccess.getNoteAccess().getRidsDefinitionIDTerminalRuleCall_2_0_1_2_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getRidsDefinitionCrossReference_2_0_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__RidsAssignment_2_0_1_2_1"


    // $ANTLR start "rule__Note__LidAssignment_2_1_1_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7576:1: rule__Note__LidAssignment_2_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__LidAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7580:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7581:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7581:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7582:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getLidDefinitionCrossReference_2_1_1_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7583:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7584:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getLidDefinitionIDTerminalRuleCall_2_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__LidAssignment_2_1_1_115525); 
             after(grammarAccess.getNoteAccess().getLidDefinitionIDTerminalRuleCall_2_1_1_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getLidDefinitionCrossReference_2_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__LidAssignment_2_1_1_1"


    // $ANTLR start "rule__Note__LidsAssignment_2_1_1_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7595:1: rule__Note__LidsAssignment_2_1_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__LidsAssignment_2_1_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7599:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7600:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7600:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7601:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getLidsDefinitionCrossReference_2_1_1_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7602:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7603:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getLidsDefinitionIDTerminalRuleCall_2_1_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__LidsAssignment_2_1_1_2_115564); 
             after(grammarAccess.getNoteAccess().getLidsDefinitionIDTerminalRuleCall_2_1_1_2_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getLidsDefinitionCrossReference_2_1_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__LidsAssignment_2_1_1_2_1"


    // $ANTLR start "rule__Note__OidAssignment_2_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7614:1: rule__Note__OidAssignment_2_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__OidAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7618:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7619:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7619:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7620:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getOidDefinitionCrossReference_2_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7621:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7622:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getOidDefinitionIDTerminalRuleCall_2_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__OidAssignment_2_2_115603); 
             after(grammarAccess.getNoteAccess().getOidDefinitionIDTerminalRuleCall_2_2_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getOidDefinitionCrossReference_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__OidAssignment_2_2_1"


    // $ANTLR start "rule__Note__OidsAssignment_2_2_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7633:1: rule__Note__OidsAssignment_2_2_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__OidsAssignment_2_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7637:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7638:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7638:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7639:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getOidsDefinitionCrossReference_2_2_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7640:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7641:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getOidsDefinitionIDTerminalRuleCall_2_2_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__OidsAssignment_2_2_2_115642); 
             after(grammarAccess.getNoteAccess().getOidsDefinitionIDTerminalRuleCall_2_2_2_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getOidsDefinitionCrossReference_2_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__OidsAssignment_2_2_2_1"


    // $ANTLR start "rule__Reference__IdAssignment_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7652:1: rule__Reference__IdAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__IdAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7656:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7657:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7657:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7658:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAccess().getIdDefinitionCrossReference_2_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7659:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7660:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getIdDefinitionIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__IdAssignment_215681); 
             after(grammarAccess.getReferenceAccess().getIdDefinitionIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getReferenceAccess().getIdDefinitionCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__IdAssignment_2"


    // $ANTLR start "rule__Reference__IdsAssignment_3_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7671:1: rule__Reference__IdsAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__IdsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7675:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7676:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7676:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7677:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAccess().getIdsDefinitionCrossReference_3_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7678:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7679:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getIdsDefinitionIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__IdsAssignment_3_115720); 
             after(grammarAccess.getReferenceAccess().getIdsDefinitionIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getReferenceAccess().getIdsDefinitionCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__IdsAssignment_3_1"


    // $ANTLR start "rule__Activate__NameAssignment_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7690:1: rule__Activate__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Activate__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7694:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7695:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7695:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7696:1: RULE_ID
            {
             before(grammarAccess.getActivateAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Activate__NameAssignment_215755); 
             after(grammarAccess.getActivateAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activate__NameAssignment_2"


    // $ANTLR start "rule__Deactivate__IdAssignment_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7705:1: rule__Deactivate__IdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Deactivate__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7709:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7710:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7710:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7711:1: ( RULE_ID )
            {
             before(grammarAccess.getDeactivateAccess().getIdActivateCrossReference_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7712:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7713:1: RULE_ID
            {
             before(grammarAccess.getDeactivateAccess().getIdActivateIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Deactivate__IdAssignment_115790); 
             after(grammarAccess.getDeactivateAccess().getIdActivateIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getDeactivateAccess().getIdActivateCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Deactivate__IdAssignment_1"


    // $ANTLR start "rule__Box__DefinitionsAssignment_7_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7724:1: rule__Box__DefinitionsAssignment_7_0 : ( ruleDefinition ) ;
    public final void rule__Box__DefinitionsAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7728:1: ( ( ruleDefinition ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7729:1: ( ruleDefinition )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7729:1: ( ruleDefinition )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7730:1: ruleDefinition
            {
             before(grammarAccess.getBoxAccess().getDefinitionsDefinitionParserRuleCall_7_0_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Box__DefinitionsAssignment_7_015825);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getBoxAccess().getDefinitionsDefinitionParserRuleCall_7_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__DefinitionsAssignment_7_0"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\u009a\uffff";
    static final String DFA4_eofS =
        "\u009a\uffff";
    static final String DFA4_minS =
        "\1\u00bf\1\u00c6\1\uffff\1\u00c1\1\u00be\1\4\u0091\u00c0\1\u00ba"+
        "\2\uffff";
    static final String DFA4_maxS =
        "\2\u00c6\1\uffff\1\u00c1\1\u00be\1\u00b0\u0091\u00c0\1\u00c6\2"+
        "\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\3\u0095\uffff\1\2\1\1";
    static final String DFA4_specialS =
        "\u009a\uffff}>";
    static final String[] DFA4_transitionS = {
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

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1062:1: rule__Definition__Alternatives_5_2_1 : ( ( ( rule__Definition__Group_5_2_1_0__0 ) ) | ( ( rule__Definition__Group_5_2_1_1__0 ) ) | ( RULE_ID ) );";
        }
    }
 

    public static final BitSet FOLLOW_rulePlantuml_in_entryRulePlantuml54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlantuml61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Plantuml__DiagramsAssignment_in_rulePlantuml91 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0_in_ruleDiagram156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__0_in_ruleInstruction220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_entryRuleArrow247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrow254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__0_in_ruleArrow284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Alternatives_in_ruleDefinition348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAutoNumber382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0_in_ruleAutoNumber412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Group__0_in_ruleColor476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_entryRuleTitle503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTitle510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__0_in_ruleTitle540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_entryRuleLegend567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLegend574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__0_in_ruleLegend604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_entryRuleNewpage631 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNewpage638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__0_in_ruleNewpage668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltElse_in_entryRuleAltElse695 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltElse702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__0_in_ruleAltElse732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_entryRuleElse759 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElse766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__0_in_ruleElse796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroupingMessages830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__0_in_ruleGroupingMessages860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_entryRuleNote887 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNote894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__0_in_ruleNote924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_entryRuleDivider951 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDivider958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__0_in_ruleDivider988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0_in_ruleReference1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_entryRuleDelay1079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDelay1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group__0_in_ruleDelay1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_entryRuleSpace1143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpace1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Alternatives_in_ruleSpace1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox1207 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHidefootbox1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__0_in_ruleHidefootbox1244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivate_in_entryRuleActivate1271 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActivate1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__0_in_ruleActivate1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeactivate_in_entryRuleDeactivate1335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeactivate1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__0_in_ruleDeactivate1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation1399 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParticipantCreation1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__0_in_ruleParticipantCreation1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBox_in_entryRuleBox1463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBox1470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__0_in_ruleBox1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_rule__Instruction__Alternatives_01536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__0_in_rule__Instruction__Alternatives_01553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives_01571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_rule__Instruction__Alternatives_01588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_rule__Instruction__Alternatives_01605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives_01622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltElse_in_rule__Instruction__Alternatives_01639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_rule__Instruction__Alternatives_01656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_rule__Instruction__Alternatives_01673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_rule__Instruction__Alternatives_01690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rule__Instruction__Alternatives_01707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_rule__Instruction__Alternatives_01724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_rule__Instruction__Alternatives_01741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_rule__Instruction__Alternatives_01758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivate_in_rule__Instruction__Alternatives_01775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeactivate_in_rule__Instruction__Alternatives_01792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_rule__Instruction__Alternatives_01809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBox_in_rule__Instruction__Alternatives_01826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__0_in_rule__Definition__Alternatives1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__0_in_rule__Definition__Alternatives_5_2_11981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__0_in_rule__Definition__Alternatives_5_2_11999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__Alternatives_5_2_12017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AliceBlue_in_rule__Color__Alternatives_12050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AntiqueWhite_in_rule__Color__Alternatives_12070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Aqua_in_rule__Color__Alternatives_12090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Aquamarine_in_rule__Color__Alternatives_12110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Azure_in_rule__Color__Alternatives_12130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Beige_in_rule__Color__Alternatives_12150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bisque_in_rule__Color__Alternatives_12170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Black_in_rule__Color__Alternatives_12190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlanchedAlmond_in_rule__Color__Alternatives_12210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Blue_in_rule__Color__Alternatives_12230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlueViolet_in_rule__Color__Alternatives_12250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Brown_in_rule__Color__Alternatives_12270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BurlyWood_in_rule__Color__Alternatives_12290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CadetBlue_in_rule__Color__Alternatives_12310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Chartreuse_in_rule__Color__Alternatives_12330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Chocolate_in_rule__Color__Alternatives_12350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Coral_in_rule__Color__Alternatives_12370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CornflowerBlue_in_rule__Color__Alternatives_12390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Cornsilk_in_rule__Color__Alternatives_12410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Crimson_in_rule__Color__Alternatives_12430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Cyan_in_rule__Color__Alternatives_12450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkBlue_in_rule__Color__Alternatives_12470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkCyan_in_rule__Color__Alternatives_12490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGoldenRod_in_rule__Color__Alternatives_12510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGray_in_rule__Color__Alternatives_12530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGreen_in_rule__Color__Alternatives_12550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGrey_in_rule__Color__Alternatives_12570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkKhaki_in_rule__Color__Alternatives_12590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkMagenta_in_rule__Color__Alternatives_12610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkOliveGreen_in_rule__Color__Alternatives_12630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkOrchid_in_rule__Color__Alternatives_12650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkRed_in_rule__Color__Alternatives_12670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSalmo_in_rule__Color__Alternatives_12690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSeaGreen_in_rule__Color__Alternatives_12710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateBlue_in_rule__Color__Alternatives_12730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateGray_in_rule__Color__Alternatives_12750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateGrey_in_rule__Color__Alternatives_12770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkTurquoise_in_rule__Color__Alternatives_12790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkViolet_in_rule__Color__Alternatives_12810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Darkorange_in_rule__Color__Alternatives_12830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DeepPink_in_rule__Color__Alternatives_12850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DeepSkyBlue_in_rule__Color__Alternatives_12870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DimGray_in_rule__Color__Alternatives_12890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DimGrey_in_rule__Color__Alternatives_12910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DodgerBlue_in_rule__Color__Alternatives_12930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FireBrick_in_rule__Color__Alternatives_12950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FloralWhite_in_rule__Color__Alternatives_12970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ForestGreen_in_rule__Color__Alternatives_12990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Fuchsia_in_rule__Color__Alternatives_13010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gainsboro_in_rule__Color__Alternatives_13030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GhostWhite_in_rule__Color__Alternatives_13050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gold_in_rule__Color__Alternatives_13070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GoldenRod_in_rule__Color__Alternatives_13090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gray_in_rule__Color__Alternatives_13110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Green_in_rule__Color__Alternatives_13130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GreenYellow_in_rule__Color__Alternatives_13150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Grey_in_rule__Color__Alternatives_13170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HoneyDew_in_rule__Color__Alternatives_13190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HotPink_in_rule__Color__Alternatives_13210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IndianRed_in_rule__Color__Alternatives_13230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Indigo_in_rule__Color__Alternatives_13250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ivory_in_rule__Color__Alternatives_13270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Khaki_in_rule__Color__Alternatives_13290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lavender_in_rule__Color__Alternatives_13310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LavenderBlush_in_rule__Color__Alternatives_13330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LawnGreen_in_rule__Color__Alternatives_13350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LemonChiffon_in_rule__Color__Alternatives_13370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightBlue_in_rule__Color__Alternatives_13390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightCoral_in_rule__Color__Alternatives_13410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightCyan_in_rule__Color__Alternatives_13430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGoldenRodYellow_in_rule__Color__Alternatives_13450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGray_in_rule__Color__Alternatives_13470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGreen_in_rule__Color__Alternatives_13490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGrey_in_rule__Color__Alternatives_13510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightPink_in_rule__Color__Alternatives_13530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSalmon_in_rule__Color__Alternatives_13550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSeaGreen_in_rule__Color__Alternatives_13570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSkyBlue_in_rule__Color__Alternatives_13590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSlateGray_in_rule__Color__Alternatives_13610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSlateGrey_in_rule__Color__Alternatives_13630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSteelBlue_in_rule__Color__Alternatives_13650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightYellow_in_rule__Color__Alternatives_13670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lime_in_rule__Color__Alternatives_13690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LimeGreen_in_rule__Color__Alternatives_13710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Linen_in_rule__Color__Alternatives_13730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Magenta_in_rule__Color__Alternatives_13750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Maroon_in_rule__Color__Alternatives_13770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumAquaMarine_in_rule__Color__Alternatives_13790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumBlue_in_rule__Color__Alternatives_13810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumOrchid_in_rule__Color__Alternatives_13830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumPurple_in_rule__Color__Alternatives_13850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSeaGreen_in_rule__Color__Alternatives_13870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSlateBlue_in_rule__Color__Alternatives_13890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSpringGreen_in_rule__Color__Alternatives_13910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumTurquoise_in_rule__Color__Alternatives_13930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumVioletRed_in_rule__Color__Alternatives_13950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MidnightBlue_in_rule__Color__Alternatives_13970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MintCream_in_rule__Color__Alternatives_13990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MistyRose_in_rule__Color__Alternatives_14010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Moccasin_in_rule__Color__Alternatives_14030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NavajoWhite_in_rule__Color__Alternatives_14050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Navy_in_rule__Color__Alternatives_14070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OldLace_in_rule__Color__Alternatives_14090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Olive_in_rule__Color__Alternatives_14110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OliveDrab_in_rule__Color__Alternatives_14130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OrangeRed_in_rule__Color__Alternatives_14150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Orchid_in_rule__Color__Alternatives_14170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleGoldenRod_in_rule__Color__Alternatives_14190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleGreen_in_rule__Color__Alternatives_14210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleTurquoise_in_rule__Color__Alternatives_14230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleVioletRed_in_rule__Color__Alternatives_14250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PapayaWhip_in_rule__Color__Alternatives_14270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PeachPuff_in_rule__Color__Alternatives_14290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Peru_in_rule__Color__Alternatives_14310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Pink_in_rule__Color__Alternatives_14330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plum_in_rule__Color__Alternatives_14350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PowderBlue_in_rule__Color__Alternatives_14370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Purple_in_rule__Color__Alternatives_14390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Red_in_rule__Color__Alternatives_14410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RosyBrown_in_rule__Color__Alternatives_14430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RoyalBlue_in_rule__Color__Alternatives_14450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SaddleBrown_in_rule__Color__Alternatives_14470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Salmon_in_rule__Color__Alternatives_14490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SandyBrown_in_rule__Color__Alternatives_14510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SeaGreen_in_rule__Color__Alternatives_14530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Sienna_in_rule__Color__Alternatives_14550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Silver_in_rule__Color__Alternatives_14570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SkyBlue_in_rule__Color__Alternatives_14590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateBlue_in_rule__Color__Alternatives_14610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateGray_in_rule__Color__Alternatives_14630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateGrey_in_rule__Color__Alternatives_14650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Snow_in_rule__Color__Alternatives_14670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SpringGreen_in_rule__Color__Alternatives_14690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SteelBlue_in_rule__Color__Alternatives_14710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Tan_in_rule__Color__Alternatives_14730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Teal_in_rule__Color__Alternatives_14750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Thistle_in_rule__Color__Alternatives_14770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Tomato_in_rule__Color__Alternatives_14790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Turquoise_in_rule__Color__Alternatives_14810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Violet_in_rule__Color__Alternatives_14830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Wheat_in_rule__Color__Alternatives_14850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_White_in_rule__Color__Alternatives_14870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WhiteSmoke_in_rule__Color__Alternatives_14890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Yellow_in_rule__Color__Alternatives_14910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_YellowGreen_in_rule__Color__Alternatives_14930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Right_in_rule__Legend__Alternatives_14965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Left_in_rule__Legend__Alternatives_14985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Center_in_rule__Legend__Alternatives_15005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Opt_in_rule__GroupingMessages__Alternatives_15040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Loop_in_rule__GroupingMessages__Alternatives_15060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Par_in_rule__GroupingMessages__Alternatives_15080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Break_in_rule__GroupingMessages__Alternatives_15100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Critical_in_rule__GroupingMessages__Alternatives_15120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Group_in_rule__GroupingMessages__Alternatives_15140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_0__0_in_rule__Note__Alternatives_25174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_1__0_in_rule__Note__Alternatives_25192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_2__0_in_rule__Note__Alternatives_25210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_4_0__0_in_rule__Note__Alternatives_45243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_4_1__0_in_rule__Note__Alternatives_45261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__0_in_rule__Reference__Alternatives_45294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__0_in_rule__Reference__Alternatives_45312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLineVerticalLine_in_rule__Space__Alternatives5346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__0_in_rule__Space__Alternatives5365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Deactivate_in_rule__Deactivate__Alternatives_05399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Destroy_in_rule__Deactivate__Alternatives_05419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__05451 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__05454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__15512 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__15515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_START_in_rule__Diagram__Group__1__Impl5542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__25571 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12F65A0005C00380L,0x0000000000000068L});
    public static final BitSet FOLLOW_rule__Diagram__Group__3_in_rule__Diagram__Group__25574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__2__Impl5601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__3__Impl_in_rule__Diagram__Group__35630 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12F65A0005C00380L,0x0000000000000068L});
    public static final BitSet FOLLOW_rule__Diagram__Group__4_in_rule__Diagram__Group__35633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__InstructionsAssignment_3_in_rule__Diagram__Group__3__Impl5660 = new BitSet(new long[]{0x6000200000000002L,0x05801E0000000000L,0x12F65A0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__Diagram__Group__4__Impl_in_rule__Diagram__Group__45691 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Diagram__Group__5_in_rule__Diagram__Group__45694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_END_in_rule__Diagram__Group__4__Impl5721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__5__Impl_in_rule__Diagram__Group__55750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__5__Impl5778 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Instruction__Group__0__Impl_in_rule__Instruction__Group__05821 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12F65A0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__Instruction__Group__1_in_rule__Instruction__Group__05824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_0_in_rule__Instruction__Group__0__Impl5851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__1__Impl_in_rule__Instruction__Group__15882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Instruction__Group__1__Impl5909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__0__Impl_in_rule__Instruction__Group_0_1__05942 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__1_in_rule__Instruction__Group_0_1__05945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Instruction__Group_0_1__0__Impl5972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__1__Impl_in_rule__Instruction__Group_0_1__16001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Instruction__Group_0_1__1__Impl6029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__0__Impl_in_rule__Arrow__Group__06064 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_rule__Arrow__Group__1_in_rule__Arrow__Group__06067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__NameAssignment_0_in_rule__Arrow__Group__0__Impl6094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__1__Impl_in_rule__Arrow__Group__16124 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Arrow__Group__2_in_rule__Arrow__Group__16127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SEQUENCE_in_rule__Arrow__Group__1__Impl6154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__2__Impl_in_rule__Arrow__Group__26183 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_rule__Arrow__Group__3_in_rule__Arrow__Group__26186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__NameAssignment_2_in_rule__Arrow__Group__2__Impl6213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__3__Impl_in_rule__Arrow__Group__36243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__0_in_rule__Arrow__Group__3__Impl6270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__0__Impl_in_rule__Arrow__Group_3__06309 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__1_in_rule__Arrow__Group_3__06312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Arrow__Group_3__0__Impl6340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__1__Impl_in_rule__Arrow__Group_3__16371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Arrow__Group_3__1__Impl6399 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__06434 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__06437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Actor_in_rule__Definition__Group_0__0__Impl6465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__16496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl6523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__06557 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__06560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boundary_in_rule__Definition__Group_1__0__Impl6588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__16619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl6646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__06680 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__06683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Control_in_rule__Definition__Group_2__0__Impl6711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__16742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl6769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__06803 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__06806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Entity_in_rule__Definition__Group_3__0__Impl6834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__16865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl6892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__06926 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__06929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Database_in_rule__Definition__Group_4__0__Impl6957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__16988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl7015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__0__Impl_in_rule__Definition__Group_5__07049 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__1_in_rule__Definition__Group_5__07052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Participant_in_rule__Definition__Group_5__0__Impl7080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__1__Impl_in_rule__Definition__Group_5__17111 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__2_in_rule__Definition__Group_5__17114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_5_1_in_rule__Definition__Group_5__1__Impl7141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__2__Impl_in_rule__Definition__Group_5__27171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__0_in_rule__Definition__Group_5__2__Impl7198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__0__Impl_in_rule__Definition__Group_5_2__07235 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__1_in_rule__Definition__Group_5_2__07238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LessThanSignLessThanSign_in_rule__Definition__Group_5_2__0__Impl7266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__1__Impl_in_rule__Definition__Group_5_2__17297 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__2_in_rule__Definition__Group_5_2__17300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Alternatives_5_2_1_in_rule__Definition__Group_5_2__1__Impl7327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__2__Impl_in_rule__Definition__Group_5_2__27357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GreaterThanSignGreaterThanSign_in_rule__Definition__Group_5_2__2__Impl7385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__0__Impl_in_rule__Definition__Group_5_2_1_0__07422 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__1_in_rule__Definition__Group_5_2_1_0__07425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_rule__Definition__Group_5_2_1_0__0__Impl7453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__1__Impl_in_rule__Definition__Group_5_2_1_0__17484 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__2_in_rule__Definition__Group_5_2_1_0__17487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__Group_5_2_1_0__1__Impl7514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__2__Impl_in_rule__Definition__Group_5_2_1_0__27543 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__3_in_rule__Definition__Group_5_2_1_0__27546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Definition__Group_5_2_1_0__2__Impl7574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__3__Impl_in_rule__Definition__Group_5_2_1_0__37605 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__4_in_rule__Definition__Group_5_2_1_0__37608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Definition__Group_5_2_1_0__3__Impl7635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__4__Impl_in_rule__Definition__Group_5_2_1_0__47664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightParenthesis_in_rule__Definition__Group_5_2_1_0__4__Impl7692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__0__Impl_in_rule__Definition__Group_5_2_1_1__07733 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__1_in_rule__Definition__Group_5_2_1_1__07736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_rule__Definition__Group_5_2_1_1__0__Impl7764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__1__Impl_in_rule__Definition__Group_5_2_1_1__17795 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__2_in_rule__Definition__Group_5_2_1_1__17798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__Group_5_2_1_1__1__Impl7825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__2__Impl_in_rule__Definition__Group_5_2_1_1__27854 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__3_in_rule__Definition__Group_5_2_1_1__27857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Definition__Group_5_2_1_1__2__Impl7885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__3__Impl_in_rule__Definition__Group_5_2_1_1__37916 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__4_in_rule__Definition__Group_5_2_1_1__37919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Definition__Group_5_2_1_1__3__Impl7946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__4__Impl_in_rule__Definition__Group_5_2_1_1__47975 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__5_in_rule__Definition__Group_5_2_1_1__47978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightParenthesis_in_rule__Definition__Group_5_2_1_1__4__Impl8006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__5__Impl_in_rule__Definition__Group_5_2_1_1__58037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__Group_5_2_1_1__5__Impl8064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__08105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__08108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Autonumber_in_rule__AutoNumber__Group__0__Impl8136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__18167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl8194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__08229 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__08232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl8259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__18288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl8316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Group__0__Impl_in_rule__Color__Group__08351 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000180FFF83FFC3FL});
    public static final BitSet FOLLOW_rule__Color__Group__1_in_rule__Color__Group__08354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NumberSign_in_rule__Color__Group__0__Impl8382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Group__1__Impl_in_rule__Color__Group__18413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Alternatives_1_in_rule__Color__Group__1__Impl8440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__08474 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Title__Group__1_in_rule__Title__Group__08477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_rule__Title__Group__0__Impl8505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__18536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl8564 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__08599 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000040002000040L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__08602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Legend_in_rule__Legend__Group__0__Impl8630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__18661 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000040002000040L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__18664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl8691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__28722 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000040002000040L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__28725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__0_in_rule__Legend__Group__2__Impl8752 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__38783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Endlegend_in_rule__Legend__Group__3__Impl8811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__0__Impl_in_rule__Legend__Group_2__08850 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__1_in_rule__Legend__Group_2__08853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Legend__Group_2__0__Impl8880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__1__Impl_in_rule__Legend__Group_2__18909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Legend__Group_2__1__Impl8937 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__08972 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__08975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newpage_in_rule__Newpage__Group__0__Impl9003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__19034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl9062 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__AltElse__Group__0__Impl_in_rule__AltElse__Group__09097 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_rule__AltElse__Group__1_in_rule__AltElse__Group__09100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__1__Impl_in_rule__AltElse__Group__19158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__AltElse__Group__2_in_rule__AltElse__Group__19161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Alt_in_rule__AltElse__Group__1__Impl9189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__2__Impl_in_rule__AltElse__Group__29220 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__AltElse__Group__3_in_rule__AltElse__Group__29223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AltElse__Group__2__Impl9251 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__AltElse__Group__3__Impl_in_rule__AltElse__Group__39282 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12FE5B0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__AltElse__Group__4_in_rule__AltElse__Group__39285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__AltElse__Group__3__Impl9312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__4__Impl_in_rule__AltElse__Group__49341 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12FE5B0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__AltElse__Group__5_in_rule__AltElse__Group__49344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__InstructionsAssignment_4_in_rule__AltElse__Group__4__Impl9371 = new BitSet(new long[]{0x6000200000000002L,0x05801E0000000000L,0x12F65A0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__AltElse__Group__5__Impl_in_rule__AltElse__Group__59402 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12FE5B0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__AltElse__Group__6_in_rule__AltElse__Group__59405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__ElsesAssignment_5_in_rule__AltElse__Group__5__Impl9432 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_rule__AltElse__Group__6__Impl_in_rule__AltElse__Group__69463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__AltElse__Group__6__Impl9491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__0__Impl_in_rule__Else__Group__09536 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Else__Group__1_in_rule__Else__Group__09539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__1__Impl_in_rule__Else__Group__19597 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__Else__Group__2_in_rule__Else__Group__19600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_rule__Else__Group__1__Impl9628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__2__Impl_in_rule__Else__Group__29659 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__Else__Group__3_in_rule__Else__Group__29662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Else__Group__2__Impl9690 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Else__Group__3__Impl_in_rule__Else__Group__39721 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12F65A0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__Else__Group__4_in_rule__Else__Group__39724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Else__Group__3__Impl9751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__4__Impl_in_rule__Else__Group__49780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__InstructionsAssignment_4_in_rule__Else__Group__4__Impl9807 = new BitSet(new long[]{0x6000200000000002L,0x05801E0000000000L,0x12F65A0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__0__Impl_in_rule__GroupingMessages__Group__09848 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L,0x0030080001800000L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__1_in_rule__GroupingMessages__Group__09851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__1__Impl_in_rule__GroupingMessages__Group__19909 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__2_in_rule__GroupingMessages__Group__19912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Alternatives_1_in_rule__GroupingMessages__Group__1__Impl9939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__2__Impl_in_rule__GroupingMessages__Group__29969 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__3_in_rule__GroupingMessages__Group__29972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__GroupingMessages__Group__2__Impl10000 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__3__Impl_in_rule__GroupingMessages__Group__310031 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12FE5A0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__4_in_rule__GroupingMessages__Group__310034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__GroupingMessages__Group__3__Impl10061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__4__Impl_in_rule__GroupingMessages__Group__410090 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12FE5A0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__5_in_rule__GroupingMessages__Group__410093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__InstructionsAssignment_4_in_rule__GroupingMessages__Group__4__Impl10120 = new BitSet(new long[]{0x6000200000000002L,0x05801E0000000000L,0x12F65A0005C00380L,0x0000000000000048L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__5__Impl_in_rule__GroupingMessages__Group__510151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__GroupingMessages__Group__5__Impl10179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__0__Impl_in_rule__Note__Group__010222 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_rule__Note__Group__1_in_rule__Note__Group__010225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__1__Impl_in_rule__Note__Group__110283 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000240002000000L});
    public static final BitSet FOLLOW_rule__Note__Group__2_in_rule__Note__Group__110286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_rule__Note__Group__1__Impl10314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__2__Impl_in_rule__Note__Group__210345 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_rule__Note__Group__3_in_rule__Note__Group__210348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Alternatives_2_in_rule__Note__Group__2__Impl10375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__3__Impl_in_rule__Note__Group__310405 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_rule__Note__Group__4_in_rule__Note__Group__310408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Note__Group__3__Impl10436 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group__4__Impl_in_rule__Note__Group__410467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Alternatives_4_in_rule__Note__Group__4__Impl10494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_0__0__Impl_in_rule__Note__Group_2_0__010534 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_2_0__1_in_rule__Note__Group_2_0__010537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Right_in_rule__Note__Group_2_0__0__Impl10565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_0__1__Impl_in_rule__Note__Group_2_0__110596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_0_1__0_in_rule__Note__Group_2_0__1__Impl10623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_0_1__0__Impl_in_rule__Note__Group_2_0_1__010658 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_2_0_1__1_in_rule__Note__Group_2_0_1__010661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Of_in_rule__Note__Group_2_0_1__0__Impl10689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_0_1__1__Impl_in_rule__Note__Group_2_0_1__110720 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_0_1__2_in_rule__Note__Group_2_0_1__110723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__RidAssignment_2_0_1_1_in_rule__Note__Group_2_0_1__1__Impl10750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_0_1__2__Impl_in_rule__Note__Group_2_0_1__210780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_0_1_2__0_in_rule__Note__Group_2_0_1__2__Impl10807 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_0_1_2__0__Impl_in_rule__Note__Group_2_0_1_2__010844 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_2_0_1_2__1_in_rule__Note__Group_2_0_1_2__010847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Note__Group_2_0_1_2__0__Impl10875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_0_1_2__1__Impl_in_rule__Note__Group_2_0_1_2__110906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__RidsAssignment_2_0_1_2_1_in_rule__Note__Group_2_0_1_2__1__Impl10933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_1__0__Impl_in_rule__Note__Group_2_1__010967 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_2_1__1_in_rule__Note__Group_2_1__010970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Left_in_rule__Note__Group_2_1__0__Impl10998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_1__1__Impl_in_rule__Note__Group_2_1__111029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_1_1__0_in_rule__Note__Group_2_1__1__Impl11056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_1_1__0__Impl_in_rule__Note__Group_2_1_1__011091 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_2_1_1__1_in_rule__Note__Group_2_1_1__011094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Of_in_rule__Note__Group_2_1_1__0__Impl11122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_1_1__1__Impl_in_rule__Note__Group_2_1_1__111153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_1_1__2_in_rule__Note__Group_2_1_1__111156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__LidAssignment_2_1_1_1_in_rule__Note__Group_2_1_1__1__Impl11183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_1_1__2__Impl_in_rule__Note__Group_2_1_1__211213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_1_1_2__0_in_rule__Note__Group_2_1_1__2__Impl11240 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_1_1_2__0__Impl_in_rule__Note__Group_2_1_1_2__011277 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_2_1_1_2__1_in_rule__Note__Group_2_1_1_2__011280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Note__Group_2_1_1_2__0__Impl11308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_1_1_2__1__Impl_in_rule__Note__Group_2_1_1_2__111339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__LidsAssignment_2_1_1_2_1_in_rule__Note__Group_2_1_1_2__1__Impl11366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_2__0__Impl_in_rule__Note__Group_2_2__011400 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_2_2__1_in_rule__Note__Group_2_2__011403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Over_in_rule__Note__Group_2_2__0__Impl11431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_2__1__Impl_in_rule__Note__Group_2_2__111462 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_2__2_in_rule__Note__Group_2_2__111465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__OidAssignment_2_2_1_in_rule__Note__Group_2_2__1__Impl11492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_2__2__Impl_in_rule__Note__Group_2_2__211522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_2_2__0_in_rule__Note__Group_2_2__2__Impl11549 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_2_2__0__Impl_in_rule__Note__Group_2_2_2__011586 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_2_2_2__1_in_rule__Note__Group_2_2_2__011589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Note__Group_2_2_2__0__Impl11617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_2_2_2__1__Impl_in_rule__Note__Group_2_2_2__111648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__OidsAssignment_2_2_2_1_in_rule__Note__Group_2_2_2__1__Impl11675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_4_0__0__Impl_in_rule__Note__Group_4_0__011709 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_4_0__1_in_rule__Note__Group_4_0__011712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Note__Group_4_0__0__Impl11740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_4_0__1__Impl_in_rule__Note__Group_4_0__111771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__Group_4_0__1__Impl11798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_4_1__0__Impl_in_rule__Note__Group_4_1__011831 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_rule__Note__Group_4_1__1_in_rule__Note__Group_4_1__011834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_4_1_0__0_in_rule__Note__Group_4_1__0__Impl11861 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Note__Group_4_1__1__Impl_in_rule__Note__Group_4_1__111892 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_4_1__2_in_rule__Note__Group_4_1__111895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Note__Group_4_1__1__Impl11922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_4_1__2__Impl_in_rule__Note__Group_4_1__211951 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_4_1__3_in_rule__Note__Group_4_1__211954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__Note__Group_4_1__2__Impl11982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_4_1__3__Impl_in_rule__Note__Group_4_1__312013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_rule__Note__Group_4_1__3__Impl12041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_4_1_0__0__Impl_in_rule__Note__Group_4_1_0__012080 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Note__Group_4_1_0__1_in_rule__Note__Group_4_1_0__012083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Note__Group_4_1_0__0__Impl12110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_4_1_0__1__Impl_in_rule__Note__Group_4_1_0__112139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__Group_4_1_0__1__Impl12167 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Divider__Group__0__Impl_in_rule__Divider__Group__012202 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Divider__Group__1_in_rule__Divider__Group__012205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__0__Impl12233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__1__Impl_in_rule__Divider__Group__112264 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Divider__Group__2_in_rule__Divider__Group__112267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Divider__Group__1__Impl12295 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Divider__Group__2__Impl_in_rule__Divider__Group__212326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__2__Impl12354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__012391 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__012394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_rule__Reference__Group__0__Impl12422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__112453 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__112456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Over_in_rule__Reference__Group__1__Impl12484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__2__Impl_in_rule__Reference__Group__212515 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__212518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__IdAssignment_2_in_rule__Reference__Group__2__Impl12545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__3__Impl_in_rule__Reference__Group__312575 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__312578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__0_in_rule__Reference__Group__3__Impl12605 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__4__Impl_in_rule__Reference__Group__412636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Alternatives_4_in_rule__Reference__Group__4__Impl12663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__0__Impl_in_rule__Reference__Group_3__012703 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__1_in_rule__Reference__Group_3__012706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Reference__Group_3__0__Impl12734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__1__Impl_in_rule__Reference__Group_3__112765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__IdsAssignment_3_1_in_rule__Reference__Group_3__1__Impl12792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__0__Impl_in_rule__Reference__Group_4_0__012826 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__1_in_rule__Reference__Group_4_0__012829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Reference__Group_4_0__0__Impl12857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__1__Impl_in_rule__Reference__Group_4_0__112888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__Group_4_0__1__Impl12916 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__0__Impl_in_rule__Reference__Group_4_1__012951 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__1_in_rule__Reference__Group_4_1__012954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__0_in_rule__Reference__Group_4_1__0__Impl12981 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__1__Impl_in_rule__Reference__Group_4_1__113012 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__2_in_rule__Reference__Group_4_1__113015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__Reference__Group_4_1__1__Impl13043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__2__Impl_in_rule__Reference__Group_4_1__213074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_rule__Reference__Group_4_1__2__Impl13102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__0__Impl_in_rule__Reference__Group_4_1_0__013139 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__1_in_rule__Reference__Group_4_1_0__013142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Reference__Group_4_1_0__0__Impl13169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__1__Impl_in_rule__Reference__Group_4_1_0__113198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__Group_4_1_0__1__Impl13226 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Delay__Group__0__Impl_in_rule__Delay__Group__013261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000400000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Delay__Group__1_in_rule__Delay__Group__013264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group__0__Impl13292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group__1__Impl_in_rule__Delay__Group__113323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__0_in_rule__Delay__Group__1__Impl13350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__0__Impl_in_rule__Delay__Group_1__013385 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000400000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__1_in_rule__Delay__Group_1__013388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Delay__Group_1__0__Impl13416 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__1__Impl_in_rule__Delay__Group_1__113447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group_1__1__Impl13475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__0__Impl_in_rule__Space__Group_1__013510 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rule__Space__Group_1__1_in_rule__Space__Group_1__013513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__0__Impl13541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__1__Impl_in_rule__Space__Group_1__113572 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_rule__Space__Group_1__2_in_rule__Space__Group_1__113575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Space__Group_1__1__Impl13602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__2__Impl_in_rule__Space__Group_1__213631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__2__Impl13659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__0__Impl_in_rule__Hidefootbox__Group__013696 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__1_in_rule__Hidefootbox__Group__013699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hide_in_rule__Hidefootbox__Group__0__Impl13727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__1__Impl_in_rule__Hidefootbox__Group__113758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Footbox_in_rule__Hidefootbox__Group__1__Impl13786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__0__Impl_in_rule__Activate__Group__013821 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Activate__Group__1_in_rule__Activate__Group__013824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Activate_in_rule__Activate__Group__0__Impl13852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__1__Impl_in_rule__Activate__Group__113883 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Activate__Group__2_in_rule__Activate__Group__113886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Activate__Group__1__Impl13914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__2__Impl_in_rule__Activate__Group__213945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__NameAssignment_2_in_rule__Activate__Group__2__Impl13972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__0__Impl_in_rule__Deactivate__Group__014008 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__1_in_rule__Deactivate__Group__014011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Alternatives_0_in_rule__Deactivate__Group__0__Impl14038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__1__Impl_in_rule__Deactivate__Group__114068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__IdAssignment_1_in_rule__Deactivate__Group__1__Impl14095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__0__Impl_in_rule__ParticipantCreation__Group__014129 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__1_in_rule__ParticipantCreation__Group__014132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_rule__ParticipantCreation__Group__0__Impl14160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__1__Impl_in_rule__ParticipantCreation__Group__114191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParticipantCreation__Group__1__Impl14218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__0__Impl_in_rule__Box__Group__014251 = new BitSet(new long[]{0x6000200000000000L,0x05801E0000000000L,0x12F65A0005C00380L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Box__Group__1_in_rule__Box__Group__014254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__1__Impl_in_rule__Box__Group__114312 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_rule__Box__Group__2_in_rule__Box__Group__114315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_rule__Box__Group__1__Impl14343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__2__Impl_in_rule__Box__Group__214374 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Box__Group__3_in_rule__Box__Group__214377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QuotationMark_in_rule__Box__Group__2__Impl14405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__3__Impl_in_rule__Box__Group__314436 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Box__Group__4_in_rule__Box__Group__314439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Box__Group__3__Impl14467 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Box__Group__4__Impl_in_rule__Box__Group__414498 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Box__Group__5_in_rule__Box__Group__414501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QuotationMark_in_rule__Box__Group__4__Impl14529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__5__Impl_in_rule__Box__Group__514560 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Box__Group__6_in_rule__Box__Group__514563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Box__Group__5__Impl14591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__6__Impl_in_rule__Box__Group__614622 = new BitSet(new long[]{0x0000200000000000L,0x0080140000000000L,0x0008000000400100L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Box__Group__7_in_rule__Box__Group__614625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Box__Group__6__Impl14652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__7__Impl_in_rule__Box__Group__714681 = new BitSet(new long[]{0x0000200000000000L,0x0080140000000000L,0x0008000000400100L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Box__Group__8_in_rule__Box__Group__714684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group_7__0_in_rule__Box__Group__7__Impl14711 = new BitSet(new long[]{0x0000200000000002L,0x0080140000000000L,0x0000000000400100L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Box__Group__8__Impl_in_rule__Box__Group__814742 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_rule__Box__Group__9_in_rule__Box__Group__814745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__Box__Group__8__Impl14773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__9__Impl_in_rule__Box__Group__914804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_rule__Box__Group__9__Impl14832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group_7__0__Impl_in_rule__Box__Group_7__014883 = new BitSet(new long[]{0x0000200000000000L,0x0080140000000000L,0x0000000000400100L,0x0000000000000008L});
    public static final BitSet FOLLOW_rule__Box__Group_7__1_in_rule__Box__Group_7__014886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__DefinitionsAssignment_7_0_in_rule__Box__Group_7__0__Impl14913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group_7__1__Impl_in_rule__Box__Group_7__114944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Box__Group_7__1__Impl14971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_rule__Plantuml__DiagramsAssignment15009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_315040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Arrow__NameAssignment_015071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Arrow__NameAssignment_215102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_115133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_115164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_115195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_115226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_115257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_5_115288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__AltElse__InstructionsAssignment_415319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_rule__AltElse__ElsesAssignment_515350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Else__InstructionsAssignment_415381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__GroupingMessages__InstructionsAssignment_415412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__RidAssignment_2_0_1_115447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__RidsAssignment_2_0_1_2_115486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__LidAssignment_2_1_1_115525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__LidsAssignment_2_1_1_2_115564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__OidAssignment_2_2_115603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__OidsAssignment_2_2_2_115642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__IdAssignment_215681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__IdsAssignment_3_115720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Activate__NameAssignment_215755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Deactivate__IdAssignment_115790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Box__DefinitionsAssignment_7_015825 = new BitSet(new long[]{0x0000000000000002L});

}