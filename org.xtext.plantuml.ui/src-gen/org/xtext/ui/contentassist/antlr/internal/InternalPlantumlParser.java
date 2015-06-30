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
    public String getGrammarFileName() { return "../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g"; }


     
     	private PlantumlGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("QuotationMark", "'\"'");
    		tokenNameToValue.put("NumberSign", "'#'");
    		tokenNameToValue.put("LeftParenthesis", "'('");
    		tokenNameToValue.put("RightParenthesis", "')'");
    		tokenNameToValue.put("Comma", "','");
    		tokenNameToValue.put("HyphenMinus", "'-'");
    		tokenNameToValue.put("FullStop", "'.'");
    		tokenNameToValue.put("Colon", "':'");
    		tokenNameToValue.put("LessThanSign", "'<'");
    		tokenNameToValue.put("EqualsSign", "'='");
    		tokenNameToValue.put("GreaterThanSign", "'>'");
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:259:1: entryRulePlantuml : rulePlantuml EOF ;
    public final void entryRulePlantuml() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:260:1: ( rulePlantuml EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:261:1: rulePlantuml EOF
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:268:1: rulePlantuml : ( ( rule__Plantuml__DiagramsAssignment )* ) ;
    public final void rulePlantuml() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:272:5: ( ( ( rule__Plantuml__DiagramsAssignment )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:273:1: ( ( rule__Plantuml__DiagramsAssignment )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:273:1: ( ( rule__Plantuml__DiagramsAssignment )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:274:1: ( rule__Plantuml__DiagramsAssignment )*
            {
             before(grammarAccess.getPlantumlAccess().getDiagramsAssignment()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:275:1: ( rule__Plantuml__DiagramsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_START) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:275:2: rule__Plantuml__DiagramsAssignment
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:287:1: entryRuleDiagram : ruleDiagram EOF ;
    public final void entryRuleDiagram() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:288:1: ( ruleDiagram EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:289:1: ruleDiagram EOF
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:296:1: ruleDiagram : ( ( rule__Diagram__Group__0 ) ) ;
    public final void ruleDiagram() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:300:5: ( ( ( rule__Diagram__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:301:1: ( ( rule__Diagram__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:301:1: ( ( rule__Diagram__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:302:1: ( rule__Diagram__Group__0 )
            {
             before(grammarAccess.getDiagramAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:303:1: ( rule__Diagram__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:303:2: rule__Diagram__Group__0
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:315:1: entryRuleInstruction : ruleInstruction EOF ;
    public final void entryRuleInstruction() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:316:1: ( ruleInstruction EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:317:1: ruleInstruction EOF
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:324:1: ruleInstruction : ( ( rule__Instruction__Group__0 ) ) ;
    public final void ruleInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:328:5: ( ( ( rule__Instruction__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:329:1: ( ( rule__Instruction__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:329:1: ( ( rule__Instruction__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:330:1: ( rule__Instruction__Group__0 )
            {
             before(grammarAccess.getInstructionAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:331:1: ( rule__Instruction__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:331:2: rule__Instruction__Group__0
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:343:1: entryRuleArrow : ruleArrow EOF ;
    public final void entryRuleArrow() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:344:1: ( ruleArrow EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:345:1: ruleArrow EOF
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:352:1: ruleArrow : ( ( rule__Arrow__Group__0 ) ) ;
    public final void ruleArrow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:356:5: ( ( ( rule__Arrow__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:357:1: ( ( rule__Arrow__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:357:1: ( ( rule__Arrow__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:358:1: ( rule__Arrow__Group__0 )
            {
             before(grammarAccess.getArrowAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:359:1: ( rule__Arrow__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:359:2: rule__Arrow__Group__0
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:371:1: entryRuleDefinition : ruleDefinition EOF ;
    public final void entryRuleDefinition() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:372:1: ( ruleDefinition EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:373:1: ruleDefinition EOF
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:380:1: ruleDefinition : ( ( rule__Definition__Alternatives ) ) ;
    public final void ruleDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:384:5: ( ( ( rule__Definition__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:385:1: ( ( rule__Definition__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:385:1: ( ( rule__Definition__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:386:1: ( rule__Definition__Alternatives )
            {
             before(grammarAccess.getDefinitionAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:387:1: ( rule__Definition__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:387:2: rule__Definition__Alternatives
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


    // $ANTLR start "entryRuleEndID"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:401:1: entryRuleEndID : ruleEndID EOF ;
    public final void entryRuleEndID() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:402:1: ( ruleEndID EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:403:1: ruleEndID EOF
            {
             before(grammarAccess.getEndIDRule()); 
            pushFollow(FOLLOW_ruleEndID_in_entryRuleEndID377);
            ruleEndID();

            state._fsp--;

             after(grammarAccess.getEndIDRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndID384); 

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
    // $ANTLR end "entryRuleEndID"


    // $ANTLR start "ruleEndID"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:410:1: ruleEndID : ( ( rule__EndID__Alternatives ) ) ;
    public final void ruleEndID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:414:5: ( ( ( rule__EndID__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:415:1: ( ( rule__EndID__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:415:1: ( ( rule__EndID__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:416:1: ( rule__EndID__Alternatives )
            {
             before(grammarAccess.getEndIDAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:417:1: ( rule__EndID__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:417:2: rule__EndID__Alternatives
            {
            pushFollow(FOLLOW_rule__EndID__Alternatives_in_ruleEndID414);
            rule__EndID__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEndIDAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEndID"


    // $ANTLR start "entryRuleMyID"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:429:1: entryRuleMyID : ruleMyID EOF ;
    public final void entryRuleMyID() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:430:1: ( ruleMyID EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:431:1: ruleMyID EOF
            {
             before(grammarAccess.getMyIDRule()); 
            pushFollow(FOLLOW_ruleMyID_in_entryRuleMyID441);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getMyIDRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMyID448); 

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
    // $ANTLR end "entryRuleMyID"


    // $ANTLR start "ruleMyID"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:438:1: ruleMyID : ( ( rule__MyID__Alternatives ) ) ;
    public final void ruleMyID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:442:5: ( ( ( rule__MyID__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:443:1: ( ( rule__MyID__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:443:1: ( ( rule__MyID__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:444:1: ( rule__MyID__Alternatives )
            {
             before(grammarAccess.getMyIDAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:445:1: ( rule__MyID__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:445:2: rule__MyID__Alternatives
            {
            pushFollow(FOLLOW_rule__MyID__Alternatives_in_ruleMyID478);
            rule__MyID__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMyIDAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyID"


    // $ANTLR start "entryRuleAutoNumber"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:457:1: entryRuleAutoNumber : ruleAutoNumber EOF ;
    public final void entryRuleAutoNumber() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:458:1: ( ruleAutoNumber EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:459:1: ruleAutoNumber EOF
            {
             before(grammarAccess.getAutoNumberRule()); 
            pushFollow(FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber505);
            ruleAutoNumber();

            state._fsp--;

             after(grammarAccess.getAutoNumberRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAutoNumber512); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:466:1: ruleAutoNumber : ( ( rule__AutoNumber__Group__0 ) ) ;
    public final void ruleAutoNumber() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:470:5: ( ( ( rule__AutoNumber__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:471:1: ( ( rule__AutoNumber__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:471:1: ( ( rule__AutoNumber__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:472:1: ( rule__AutoNumber__Group__0 )
            {
             before(grammarAccess.getAutoNumberAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:473:1: ( rule__AutoNumber__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:473:2: rule__AutoNumber__Group__0
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0_in_ruleAutoNumber542);
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


    // $ANTLR start "entryRuleTitle"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:485:1: entryRuleTitle : ruleTitle EOF ;
    public final void entryRuleTitle() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:486:1: ( ruleTitle EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:487:1: ruleTitle EOF
            {
             before(grammarAccess.getTitleRule()); 
            pushFollow(FOLLOW_ruleTitle_in_entryRuleTitle569);
            ruleTitle();

            state._fsp--;

             after(grammarAccess.getTitleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTitle576); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:494:1: ruleTitle : ( ( rule__Title__Group__0 ) ) ;
    public final void ruleTitle() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:498:5: ( ( ( rule__Title__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:499:1: ( ( rule__Title__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:499:1: ( ( rule__Title__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:500:1: ( rule__Title__Group__0 )
            {
             before(grammarAccess.getTitleAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:501:1: ( rule__Title__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:501:2: rule__Title__Group__0
            {
            pushFollow(FOLLOW_rule__Title__Group__0_in_ruleTitle606);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:513:1: entryRuleLegend : ruleLegend EOF ;
    public final void entryRuleLegend() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:514:1: ( ruleLegend EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:515:1: ruleLegend EOF
            {
             before(grammarAccess.getLegendRule()); 
            pushFollow(FOLLOW_ruleLegend_in_entryRuleLegend633);
            ruleLegend();

            state._fsp--;

             after(grammarAccess.getLegendRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLegend640); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:522:1: ruleLegend : ( ( rule__Legend__Group__0 ) ) ;
    public final void ruleLegend() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:526:5: ( ( ( rule__Legend__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:527:1: ( ( rule__Legend__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:527:1: ( ( rule__Legend__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:528:1: ( rule__Legend__Group__0 )
            {
             before(grammarAccess.getLegendAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:529:1: ( rule__Legend__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:529:2: rule__Legend__Group__0
            {
            pushFollow(FOLLOW_rule__Legend__Group__0_in_ruleLegend670);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:541:1: entryRuleNewpage : ruleNewpage EOF ;
    public final void entryRuleNewpage() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:542:1: ( ruleNewpage EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:543:1: ruleNewpage EOF
            {
             before(grammarAccess.getNewpageRule()); 
            pushFollow(FOLLOW_ruleNewpage_in_entryRuleNewpage697);
            ruleNewpage();

            state._fsp--;

             after(grammarAccess.getNewpageRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNewpage704); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:550:1: ruleNewpage : ( ( rule__Newpage__Group__0 ) ) ;
    public final void ruleNewpage() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:554:5: ( ( ( rule__Newpage__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:555:1: ( ( rule__Newpage__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:555:1: ( ( rule__Newpage__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:556:1: ( rule__Newpage__Group__0 )
            {
             before(grammarAccess.getNewpageAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:557:1: ( rule__Newpage__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:557:2: rule__Newpage__Group__0
            {
            pushFollow(FOLLOW_rule__Newpage__Group__0_in_ruleNewpage734);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:569:1: entryRuleAltElse : ruleAltElse EOF ;
    public final void entryRuleAltElse() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:570:1: ( ruleAltElse EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:571:1: ruleAltElse EOF
            {
             before(grammarAccess.getAltElseRule()); 
            pushFollow(FOLLOW_ruleAltElse_in_entryRuleAltElse761);
            ruleAltElse();

            state._fsp--;

             after(grammarAccess.getAltElseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltElse768); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:578:1: ruleAltElse : ( ( rule__AltElse__Group__0 ) ) ;
    public final void ruleAltElse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:582:5: ( ( ( rule__AltElse__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:583:1: ( ( rule__AltElse__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:583:1: ( ( rule__AltElse__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:584:1: ( rule__AltElse__Group__0 )
            {
             before(grammarAccess.getAltElseAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:585:1: ( rule__AltElse__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:585:2: rule__AltElse__Group__0
            {
            pushFollow(FOLLOW_rule__AltElse__Group__0_in_ruleAltElse798);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:597:1: entryRuleElse : ruleElse EOF ;
    public final void entryRuleElse() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:598:1: ( ruleElse EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:599:1: ruleElse EOF
            {
             before(grammarAccess.getElseRule()); 
            pushFollow(FOLLOW_ruleElse_in_entryRuleElse825);
            ruleElse();

            state._fsp--;

             after(grammarAccess.getElseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElse832); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:606:1: ruleElse : ( ( rule__Else__Group__0 ) ) ;
    public final void ruleElse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:610:5: ( ( ( rule__Else__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:611:1: ( ( rule__Else__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:611:1: ( ( rule__Else__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:612:1: ( rule__Else__Group__0 )
            {
             before(grammarAccess.getElseAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:613:1: ( rule__Else__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:613:2: rule__Else__Group__0
            {
            pushFollow(FOLLOW_rule__Else__Group__0_in_ruleElse862);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:625:1: entryRuleGroupingMessages : ruleGroupingMessages EOF ;
    public final void entryRuleGroupingMessages() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:626:1: ( ruleGroupingMessages EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:627:1: ruleGroupingMessages EOF
            {
             before(grammarAccess.getGroupingMessagesRule()); 
            pushFollow(FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages889);
            ruleGroupingMessages();

            state._fsp--;

             after(grammarAccess.getGroupingMessagesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroupingMessages896); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:634:1: ruleGroupingMessages : ( ( rule__GroupingMessages__Group__0 ) ) ;
    public final void ruleGroupingMessages() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:638:5: ( ( ( rule__GroupingMessages__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:639:1: ( ( rule__GroupingMessages__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:639:1: ( ( rule__GroupingMessages__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:640:1: ( rule__GroupingMessages__Group__0 )
            {
             before(grammarAccess.getGroupingMessagesAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:641:1: ( rule__GroupingMessages__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:641:2: rule__GroupingMessages__Group__0
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__0_in_ruleGroupingMessages926);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:653:1: entryRuleNote : ruleNote EOF ;
    public final void entryRuleNote() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:654:1: ( ruleNote EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:655:1: ruleNote EOF
            {
             before(grammarAccess.getNoteRule()); 
            pushFollow(FOLLOW_ruleNote_in_entryRuleNote953);
            ruleNote();

            state._fsp--;

             after(grammarAccess.getNoteRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNote960); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:662:1: ruleNote : ( ( rule__Note__Group__0 ) ) ;
    public final void ruleNote() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:666:5: ( ( ( rule__Note__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:667:1: ( ( rule__Note__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:667:1: ( ( rule__Note__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:668:1: ( rule__Note__Group__0 )
            {
             before(grammarAccess.getNoteAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:669:1: ( rule__Note__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:669:2: rule__Note__Group__0
            {
            pushFollow(FOLLOW_rule__Note__Group__0_in_ruleNote990);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:681:1: entryRuleDivider : ruleDivider EOF ;
    public final void entryRuleDivider() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:682:1: ( ruleDivider EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:683:1: ruleDivider EOF
            {
             before(grammarAccess.getDividerRule()); 
            pushFollow(FOLLOW_ruleDivider_in_entryRuleDivider1017);
            ruleDivider();

            state._fsp--;

             after(grammarAccess.getDividerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDivider1024); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:690:1: ruleDivider : ( ( rule__Divider__Group__0 ) ) ;
    public final void ruleDivider() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:694:5: ( ( ( rule__Divider__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:695:1: ( ( rule__Divider__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:695:1: ( ( rule__Divider__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:696:1: ( rule__Divider__Group__0 )
            {
             before(grammarAccess.getDividerAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:697:1: ( rule__Divider__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:697:2: rule__Divider__Group__0
            {
            pushFollow(FOLLOW_rule__Divider__Group__0_in_ruleDivider1054);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:709:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:710:1: ( ruleReference EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:711:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference1081);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference1088); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:718:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:722:5: ( ( ( rule__Reference__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:723:1: ( ( rule__Reference__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:723:1: ( ( rule__Reference__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:724:1: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:725:1: ( rule__Reference__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:725:2: rule__Reference__Group__0
            {
            pushFollow(FOLLOW_rule__Reference__Group__0_in_ruleReference1118);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:737:1: entryRuleDelay : ruleDelay EOF ;
    public final void entryRuleDelay() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:738:1: ( ruleDelay EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:739:1: ruleDelay EOF
            {
             before(grammarAccess.getDelayRule()); 
            pushFollow(FOLLOW_ruleDelay_in_entryRuleDelay1145);
            ruleDelay();

            state._fsp--;

             after(grammarAccess.getDelayRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDelay1152); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:746:1: ruleDelay : ( ( rule__Delay__Group__0 ) ) ;
    public final void ruleDelay() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:750:5: ( ( ( rule__Delay__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:751:1: ( ( rule__Delay__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:751:1: ( ( rule__Delay__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:752:1: ( rule__Delay__Group__0 )
            {
             before(grammarAccess.getDelayAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:753:1: ( rule__Delay__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:753:2: rule__Delay__Group__0
            {
            pushFollow(FOLLOW_rule__Delay__Group__0_in_ruleDelay1182);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:765:1: entryRuleSpace : ruleSpace EOF ;
    public final void entryRuleSpace() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:766:1: ( ruleSpace EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:767:1: ruleSpace EOF
            {
             before(grammarAccess.getSpaceRule()); 
            pushFollow(FOLLOW_ruleSpace_in_entryRuleSpace1209);
            ruleSpace();

            state._fsp--;

             after(grammarAccess.getSpaceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpace1216); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:774:1: ruleSpace : ( ( rule__Space__Alternatives ) ) ;
    public final void ruleSpace() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:778:5: ( ( ( rule__Space__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:779:1: ( ( rule__Space__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:779:1: ( ( rule__Space__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:780:1: ( rule__Space__Alternatives )
            {
             before(grammarAccess.getSpaceAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:781:1: ( rule__Space__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:781:2: rule__Space__Alternatives
            {
            pushFollow(FOLLOW_rule__Space__Alternatives_in_ruleSpace1246);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:793:1: entryRuleHidefootbox : ruleHidefootbox EOF ;
    public final void entryRuleHidefootbox() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:794:1: ( ruleHidefootbox EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:795:1: ruleHidefootbox EOF
            {
             before(grammarAccess.getHidefootboxRule()); 
            pushFollow(FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox1273);
            ruleHidefootbox();

            state._fsp--;

             after(grammarAccess.getHidefootboxRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHidefootbox1280); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:802:1: ruleHidefootbox : ( ( rule__Hidefootbox__Group__0 ) ) ;
    public final void ruleHidefootbox() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:806:5: ( ( ( rule__Hidefootbox__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:807:1: ( ( rule__Hidefootbox__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:807:1: ( ( rule__Hidefootbox__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:808:1: ( rule__Hidefootbox__Group__0 )
            {
             before(grammarAccess.getHidefootboxAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:809:1: ( rule__Hidefootbox__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:809:2: rule__Hidefootbox__Group__0
            {
            pushFollow(FOLLOW_rule__Hidefootbox__Group__0_in_ruleHidefootbox1310);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:821:1: entryRuleActivate : ruleActivate EOF ;
    public final void entryRuleActivate() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:822:1: ( ruleActivate EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:823:1: ruleActivate EOF
            {
             before(grammarAccess.getActivateRule()); 
            pushFollow(FOLLOW_ruleActivate_in_entryRuleActivate1337);
            ruleActivate();

            state._fsp--;

             after(grammarAccess.getActivateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActivate1344); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:830:1: ruleActivate : ( ( rule__Activate__Group__0 ) ) ;
    public final void ruleActivate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:834:5: ( ( ( rule__Activate__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:835:1: ( ( rule__Activate__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:835:1: ( ( rule__Activate__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:836:1: ( rule__Activate__Group__0 )
            {
             before(grammarAccess.getActivateAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:837:1: ( rule__Activate__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:837:2: rule__Activate__Group__0
            {
            pushFollow(FOLLOW_rule__Activate__Group__0_in_ruleActivate1374);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:849:1: entryRuleDeactivate : ruleDeactivate EOF ;
    public final void entryRuleDeactivate() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:850:1: ( ruleDeactivate EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:851:1: ruleDeactivate EOF
            {
             before(grammarAccess.getDeactivateRule()); 
            pushFollow(FOLLOW_ruleDeactivate_in_entryRuleDeactivate1401);
            ruleDeactivate();

            state._fsp--;

             after(grammarAccess.getDeactivateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeactivate1408); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:858:1: ruleDeactivate : ( ( rule__Deactivate__Group__0 ) ) ;
    public final void ruleDeactivate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:862:5: ( ( ( rule__Deactivate__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:863:1: ( ( rule__Deactivate__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:863:1: ( ( rule__Deactivate__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:864:1: ( rule__Deactivate__Group__0 )
            {
             before(grammarAccess.getDeactivateAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:865:1: ( rule__Deactivate__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:865:2: rule__Deactivate__Group__0
            {
            pushFollow(FOLLOW_rule__Deactivate__Group__0_in_ruleDeactivate1438);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:877:1: entryRuleParticipantCreation : ruleParticipantCreation EOF ;
    public final void entryRuleParticipantCreation() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:878:1: ( ruleParticipantCreation EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:879:1: ruleParticipantCreation EOF
            {
             before(grammarAccess.getParticipantCreationRule()); 
            pushFollow(FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation1465);
            ruleParticipantCreation();

            state._fsp--;

             after(grammarAccess.getParticipantCreationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParticipantCreation1472); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:886:1: ruleParticipantCreation : ( ( rule__ParticipantCreation__Group__0 ) ) ;
    public final void ruleParticipantCreation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:890:5: ( ( ( rule__ParticipantCreation__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:891:1: ( ( rule__ParticipantCreation__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:891:1: ( ( rule__ParticipantCreation__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:892:1: ( rule__ParticipantCreation__Group__0 )
            {
             before(grammarAccess.getParticipantCreationAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:893:1: ( rule__ParticipantCreation__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:893:2: rule__ParticipantCreation__Group__0
            {
            pushFollow(FOLLOW_rule__ParticipantCreation__Group__0_in_ruleParticipantCreation1502);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:905:1: entryRuleBox : ruleBox EOF ;
    public final void entryRuleBox() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:906:1: ( ruleBox EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:907:1: ruleBox EOF
            {
             before(grammarAccess.getBoxRule()); 
            pushFollow(FOLLOW_ruleBox_in_entryRuleBox1529);
            ruleBox();

            state._fsp--;

             after(grammarAccess.getBoxRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBox1536); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:914:1: ruleBox : ( ( rule__Box__Group__0 ) ) ;
    public final void ruleBox() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:918:5: ( ( ( rule__Box__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:919:1: ( ( rule__Box__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:919:1: ( ( rule__Box__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:920:1: ( rule__Box__Group__0 )
            {
             before(grammarAccess.getBoxAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:921:1: ( rule__Box__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:921:2: rule__Box__Group__0
            {
            pushFollow(FOLLOW_rule__Box__Group__0_in_ruleBox1566);
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


    // $ANTLR start "entryRuleColors"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:933:1: entryRuleColors : ruleColors EOF ;
    public final void entryRuleColors() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:934:1: ( ruleColors EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:935:1: ruleColors EOF
            {
             before(grammarAccess.getColorsRule()); 
            pushFollow(FOLLOW_ruleColors_in_entryRuleColors1593);
            ruleColors();

            state._fsp--;

             after(grammarAccess.getColorsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColors1600); 

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
    // $ANTLR end "entryRuleColors"


    // $ANTLR start "ruleColors"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:942:1: ruleColors : ( ( rule__Colors__Group__0 ) ) ;
    public final void ruleColors() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:946:5: ( ( ( rule__Colors__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:947:1: ( ( rule__Colors__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:947:1: ( ( rule__Colors__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:948:1: ( rule__Colors__Group__0 )
            {
             before(grammarAccess.getColorsAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:949:1: ( rule__Colors__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:949:2: rule__Colors__Group__0
            {
            pushFollow(FOLLOW_rule__Colors__Group__0_in_ruleColors1630);
            rule__Colors__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getColorsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColors"


    // $ANTLR start "entryRuleColor"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:961:1: entryRuleColor : ruleColor EOF ;
    public final void entryRuleColor() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:962:1: ( ruleColor EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:963:1: ruleColor EOF
            {
             before(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_ruleColor_in_entryRuleColor1657);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getColorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColor1664); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:970:1: ruleColor : ( ( rule__Color__Alternatives ) ) ;
    public final void ruleColor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:974:5: ( ( ( rule__Color__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:975:1: ( ( rule__Color__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:975:1: ( ( rule__Color__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:976:1: ( rule__Color__Alternatives )
            {
             before(grammarAccess.getColorAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:977:1: ( rule__Color__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:977:2: rule__Color__Alternatives
            {
            pushFollow(FOLLOW_rule__Color__Alternatives_in_ruleColor1694);
            rule__Color__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getColorAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "rule__Instruction__Alternatives_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:989:1: rule__Instruction__Alternatives_0 : ( ( ruleArrow ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) | ( ruleAltElse ) | ( ruleGroupingMessages ) | ( ruleNote ) | ( ruleDivider ) | ( ruleReference ) | ( ruleDelay ) | ( ruleSpace ) | ( ruleHidefootbox ) | ( ruleActivate ) | ( ruleDeactivate ) | ( ruleParticipantCreation ) | ( ruleBox ) );
    public final void rule__Instruction__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:993:1: ( ( ruleArrow ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) | ( ruleAltElse ) | ( ruleGroupingMessages ) | ( ruleNote ) | ( ruleDivider ) | ( ruleReference ) | ( ruleDelay ) | ( ruleSpace ) | ( ruleHidefootbox ) | ( ruleActivate ) | ( ruleDeactivate ) | ( ruleParticipantCreation ) | ( ruleBox ) )
            int alt2=18;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:994:1: ( ruleArrow )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:994:1: ( ruleArrow )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:995:1: ruleArrow
                    {
                     before(grammarAccess.getInstructionAccess().getArrowParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_ruleArrow_in_rule__Instruction__Alternatives_01730);
                    ruleArrow();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getArrowParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1000:6: ( ( rule__Instruction__Group_0_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1000:6: ( ( rule__Instruction__Group_0_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1001:1: ( rule__Instruction__Group_0_1__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_0_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1002:1: ( rule__Instruction__Group_0_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1002:2: rule__Instruction__Group_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_1__0_in_rule__Instruction__Alternatives_01747);
                    rule__Instruction__Group_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1006:6: ( ruleAutoNumber )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1006:6: ( ruleAutoNumber )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1007:1: ruleAutoNumber
                    {
                     before(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 
                    pushFollow(FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives_01765);
                    ruleAutoNumber();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1012:6: ( ruleTitle )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1012:6: ( ruleTitle )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1013:1: ruleTitle
                    {
                     before(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 
                    pushFollow(FOLLOW_ruleTitle_in_rule__Instruction__Alternatives_01782);
                    ruleTitle();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1018:6: ( ruleLegend )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1018:6: ( ruleLegend )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1019:1: ruleLegend
                    {
                     before(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 
                    pushFollow(FOLLOW_ruleLegend_in_rule__Instruction__Alternatives_01799);
                    ruleLegend();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1024:6: ( ruleNewpage )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1024:6: ( ruleNewpage )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1025:1: ruleNewpage
                    {
                     before(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 
                    pushFollow(FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives_01816);
                    ruleNewpage();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1030:6: ( ruleAltElse )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1030:6: ( ruleAltElse )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1031:1: ruleAltElse
                    {
                     before(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 
                    pushFollow(FOLLOW_ruleAltElse_in_rule__Instruction__Alternatives_01833);
                    ruleAltElse();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1036:6: ( ruleGroupingMessages )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1036:6: ( ruleGroupingMessages )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1037:1: ruleGroupingMessages
                    {
                     before(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 
                    pushFollow(FOLLOW_ruleGroupingMessages_in_rule__Instruction__Alternatives_01850);
                    ruleGroupingMessages();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1042:6: ( ruleNote )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1042:6: ( ruleNote )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1043:1: ruleNote
                    {
                     before(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 
                    pushFollow(FOLLOW_ruleNote_in_rule__Instruction__Alternatives_01867);
                    ruleNote();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1048:6: ( ruleDivider )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1048:6: ( ruleDivider )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1049:1: ruleDivider
                    {
                     before(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 
                    pushFollow(FOLLOW_ruleDivider_in_rule__Instruction__Alternatives_01884);
                    ruleDivider();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1054:6: ( ruleReference )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1054:6: ( ruleReference )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1055:1: ruleReference
                    {
                     before(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 
                    pushFollow(FOLLOW_ruleReference_in_rule__Instruction__Alternatives_01901);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1060:6: ( ruleDelay )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1060:6: ( ruleDelay )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1061:1: ruleDelay
                    {
                     before(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 
                    pushFollow(FOLLOW_ruleDelay_in_rule__Instruction__Alternatives_01918);
                    ruleDelay();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1066:6: ( ruleSpace )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1066:6: ( ruleSpace )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1067:1: ruleSpace
                    {
                     before(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 
                    pushFollow(FOLLOW_ruleSpace_in_rule__Instruction__Alternatives_01935);
                    ruleSpace();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1072:6: ( ruleHidefootbox )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1072:6: ( ruleHidefootbox )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1073:1: ruleHidefootbox
                    {
                     before(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 
                    pushFollow(FOLLOW_ruleHidefootbox_in_rule__Instruction__Alternatives_01952);
                    ruleHidefootbox();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1078:6: ( ruleActivate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1078:6: ( ruleActivate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1079:1: ruleActivate
                    {
                     before(grammarAccess.getInstructionAccess().getActivateParserRuleCall_0_14()); 
                    pushFollow(FOLLOW_ruleActivate_in_rule__Instruction__Alternatives_01969);
                    ruleActivate();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getActivateParserRuleCall_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1084:6: ( ruleDeactivate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1084:6: ( ruleDeactivate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1085:1: ruleDeactivate
                    {
                     before(grammarAccess.getInstructionAccess().getDeactivateParserRuleCall_0_15()); 
                    pushFollow(FOLLOW_ruleDeactivate_in_rule__Instruction__Alternatives_01986);
                    ruleDeactivate();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDeactivateParserRuleCall_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1090:6: ( ruleParticipantCreation )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1090:6: ( ruleParticipantCreation )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1091:1: ruleParticipantCreation
                    {
                     before(grammarAccess.getInstructionAccess().getParticipantCreationParserRuleCall_0_16()); 
                    pushFollow(FOLLOW_ruleParticipantCreation_in_rule__Instruction__Alternatives_02003);
                    ruleParticipantCreation();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getParticipantCreationParserRuleCall_0_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1096:6: ( ruleBox )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1096:6: ( ruleBox )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1097:1: ruleBox
                    {
                     before(grammarAccess.getInstructionAccess().getBoxParserRuleCall_0_17()); 
                    pushFollow(FOLLOW_ruleBox_in_rule__Instruction__Alternatives_02020);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1107:1: rule__Definition__Alternatives : ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) | ( ( rule__Definition__Group_5__0 ) ) );
    public final void rule__Definition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1111:1: ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) | ( ( rule__Definition__Group_5__0 ) ) )
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1112:1: ( ( rule__Definition__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1112:1: ( ( rule__Definition__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1113:1: ( rule__Definition__Group_0__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1114:1: ( rule__Definition__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1114:2: rule__Definition__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives2052);
                    rule__Definition__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1118:6: ( ( rule__Definition__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1118:6: ( ( rule__Definition__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1119:1: ( rule__Definition__Group_1__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1120:1: ( rule__Definition__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1120:2: rule__Definition__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives2070);
                    rule__Definition__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1124:6: ( ( rule__Definition__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1124:6: ( ( rule__Definition__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1125:1: ( rule__Definition__Group_2__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1126:1: ( rule__Definition__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1126:2: rule__Definition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives2088);
                    rule__Definition__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1130:6: ( ( rule__Definition__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1130:6: ( ( rule__Definition__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1131:1: ( rule__Definition__Group_3__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1132:1: ( rule__Definition__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1132:2: rule__Definition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives2106);
                    rule__Definition__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1136:6: ( ( rule__Definition__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1136:6: ( ( rule__Definition__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1137:1: ( rule__Definition__Group_4__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1138:1: ( rule__Definition__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1138:2: rule__Definition__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives2124);
                    rule__Definition__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1142:6: ( ( rule__Definition__Group_5__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1142:6: ( ( rule__Definition__Group_5__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1143:1: ( rule__Definition__Group_5__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_5()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1144:1: ( rule__Definition__Group_5__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1144:2: rule__Definition__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5__0_in_rule__Definition__Alternatives2142);
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


    // $ANTLR start "rule__EndID__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1154:1: rule__EndID__Alternatives : ( ( RULE_ID ) | ( Create ) | ( Autonumber ) | ( Title ) | ( Legend ) | ( Right ) | ( Left ) | ( Center ) | ( Endlegend ) | ( Alt ) | ( Else ) | ( Newpage ) | ( Opt ) | ( Loop ) | ( Par ) | ( Break ) | ( Critical ) | ( Group ) | ( Note ) | ( Over ) | ( Of ) | ( Ref ) | ( Hide ) | ( Footbox ) | ( Activate ) | ( Deactivate ) | ( Destroy ) | ( Box ) | ( NumberSign ) | ( Comma ) | ( LeftParenthesis ) | ( RightParenthesis ) | ( EqualsSign ) | ( RULE_INT ) | ( HyphenMinus ) | ( FullStop ) | ( Colon ) | ( GreaterThanSign ) | ( LessThanSign ) );
    public final void rule__EndID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1158:1: ( ( RULE_ID ) | ( Create ) | ( Autonumber ) | ( Title ) | ( Legend ) | ( Right ) | ( Left ) | ( Center ) | ( Endlegend ) | ( Alt ) | ( Else ) | ( Newpage ) | ( Opt ) | ( Loop ) | ( Par ) | ( Break ) | ( Critical ) | ( Group ) | ( Note ) | ( Over ) | ( Of ) | ( Ref ) | ( Hide ) | ( Footbox ) | ( Activate ) | ( Deactivate ) | ( Destroy ) | ( Box ) | ( NumberSign ) | ( Comma ) | ( LeftParenthesis ) | ( RightParenthesis ) | ( EqualsSign ) | ( RULE_INT ) | ( HyphenMinus ) | ( FullStop ) | ( Colon ) | ( GreaterThanSign ) | ( LessThanSign ) )
            int alt4=39;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt4=1;
                }
                break;
            case Create:
                {
                alt4=2;
                }
                break;
            case Autonumber:
                {
                alt4=3;
                }
                break;
            case Title:
                {
                alt4=4;
                }
                break;
            case Legend:
                {
                alt4=5;
                }
                break;
            case Right:
                {
                alt4=6;
                }
                break;
            case Left:
                {
                alt4=7;
                }
                break;
            case Center:
                {
                alt4=8;
                }
                break;
            case Endlegend:
                {
                alt4=9;
                }
                break;
            case Alt:
                {
                alt4=10;
                }
                break;
            case Else:
                {
                alt4=11;
                }
                break;
            case Newpage:
                {
                alt4=12;
                }
                break;
            case Opt:
                {
                alt4=13;
                }
                break;
            case Loop:
                {
                alt4=14;
                }
                break;
            case Par:
                {
                alt4=15;
                }
                break;
            case Break:
                {
                alt4=16;
                }
                break;
            case Critical:
                {
                alt4=17;
                }
                break;
            case Group:
                {
                alt4=18;
                }
                break;
            case Note:
                {
                alt4=19;
                }
                break;
            case Over:
                {
                alt4=20;
                }
                break;
            case Of:
                {
                alt4=21;
                }
                break;
            case Ref:
                {
                alt4=22;
                }
                break;
            case Hide:
                {
                alt4=23;
                }
                break;
            case Footbox:
                {
                alt4=24;
                }
                break;
            case Activate:
                {
                alt4=25;
                }
                break;
            case Deactivate:
                {
                alt4=26;
                }
                break;
            case Destroy:
                {
                alt4=27;
                }
                break;
            case Box:
                {
                alt4=28;
                }
                break;
            case NumberSign:
                {
                alt4=29;
                }
                break;
            case Comma:
                {
                alt4=30;
                }
                break;
            case LeftParenthesis:
                {
                alt4=31;
                }
                break;
            case RightParenthesis:
                {
                alt4=32;
                }
                break;
            case EqualsSign:
                {
                alt4=33;
                }
                break;
            case RULE_INT:
                {
                alt4=34;
                }
                break;
            case HyphenMinus:
                {
                alt4=35;
                }
                break;
            case FullStop:
                {
                alt4=36;
                }
                break;
            case Colon:
                {
                alt4=37;
                }
                break;
            case GreaterThanSign:
                {
                alt4=38;
                }
                break;
            case LessThanSign:
                {
                alt4=39;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1159:1: ( RULE_ID )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1159:1: ( RULE_ID )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1160:1: RULE_ID
                    {
                     before(grammarAccess.getEndIDAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EndID__Alternatives2176); 
                     after(grammarAccess.getEndIDAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1165:6: ( Create )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1165:6: ( Create )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1166:1: Create
                    {
                     before(grammarAccess.getEndIDAccess().getCreateKeyword_1()); 
                    match(input,Create,FOLLOW_Create_in_rule__EndID__Alternatives2194); 
                     after(grammarAccess.getEndIDAccess().getCreateKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1173:6: ( Autonumber )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1173:6: ( Autonumber )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1174:1: Autonumber
                    {
                     before(grammarAccess.getEndIDAccess().getAutonumberKeyword_2()); 
                    match(input,Autonumber,FOLLOW_Autonumber_in_rule__EndID__Alternatives2214); 
                     after(grammarAccess.getEndIDAccess().getAutonumberKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1181:6: ( Title )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1181:6: ( Title )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1182:1: Title
                    {
                     before(grammarAccess.getEndIDAccess().getTitleKeyword_3()); 
                    match(input,Title,FOLLOW_Title_in_rule__EndID__Alternatives2234); 
                     after(grammarAccess.getEndIDAccess().getTitleKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1189:6: ( Legend )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1189:6: ( Legend )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1190:1: Legend
                    {
                     before(grammarAccess.getEndIDAccess().getLegendKeyword_4()); 
                    match(input,Legend,FOLLOW_Legend_in_rule__EndID__Alternatives2254); 
                     after(grammarAccess.getEndIDAccess().getLegendKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1197:6: ( Right )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1197:6: ( Right )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1198:1: Right
                    {
                     before(grammarAccess.getEndIDAccess().getRightKeyword_5()); 
                    match(input,Right,FOLLOW_Right_in_rule__EndID__Alternatives2274); 
                     after(grammarAccess.getEndIDAccess().getRightKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1205:6: ( Left )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1205:6: ( Left )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1206:1: Left
                    {
                     before(grammarAccess.getEndIDAccess().getLeftKeyword_6()); 
                    match(input,Left,FOLLOW_Left_in_rule__EndID__Alternatives2294); 
                     after(grammarAccess.getEndIDAccess().getLeftKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1213:6: ( Center )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1213:6: ( Center )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1214:1: Center
                    {
                     before(grammarAccess.getEndIDAccess().getCenterKeyword_7()); 
                    match(input,Center,FOLLOW_Center_in_rule__EndID__Alternatives2314); 
                     after(grammarAccess.getEndIDAccess().getCenterKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1221:6: ( Endlegend )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1221:6: ( Endlegend )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1222:1: Endlegend
                    {
                     before(grammarAccess.getEndIDAccess().getEndlegendKeyword_8()); 
                    match(input,Endlegend,FOLLOW_Endlegend_in_rule__EndID__Alternatives2334); 
                     after(grammarAccess.getEndIDAccess().getEndlegendKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1229:6: ( Alt )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1229:6: ( Alt )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1230:1: Alt
                    {
                     before(grammarAccess.getEndIDAccess().getAltKeyword_9()); 
                    match(input,Alt,FOLLOW_Alt_in_rule__EndID__Alternatives2354); 
                     after(grammarAccess.getEndIDAccess().getAltKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1237:6: ( Else )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1237:6: ( Else )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1238:1: Else
                    {
                     before(grammarAccess.getEndIDAccess().getElseKeyword_10()); 
                    match(input,Else,FOLLOW_Else_in_rule__EndID__Alternatives2374); 
                     after(grammarAccess.getEndIDAccess().getElseKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1245:6: ( Newpage )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1245:6: ( Newpage )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1246:1: Newpage
                    {
                     before(grammarAccess.getEndIDAccess().getNewpageKeyword_11()); 
                    match(input,Newpage,FOLLOW_Newpage_in_rule__EndID__Alternatives2394); 
                     after(grammarAccess.getEndIDAccess().getNewpageKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1253:6: ( Opt )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1253:6: ( Opt )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1254:1: Opt
                    {
                     before(grammarAccess.getEndIDAccess().getOptKeyword_12()); 
                    match(input,Opt,FOLLOW_Opt_in_rule__EndID__Alternatives2414); 
                     after(grammarAccess.getEndIDAccess().getOptKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1261:6: ( Loop )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1261:6: ( Loop )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1262:1: Loop
                    {
                     before(grammarAccess.getEndIDAccess().getLoopKeyword_13()); 
                    match(input,Loop,FOLLOW_Loop_in_rule__EndID__Alternatives2434); 
                     after(grammarAccess.getEndIDAccess().getLoopKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1269:6: ( Par )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1269:6: ( Par )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1270:1: Par
                    {
                     before(grammarAccess.getEndIDAccess().getParKeyword_14()); 
                    match(input,Par,FOLLOW_Par_in_rule__EndID__Alternatives2454); 
                     after(grammarAccess.getEndIDAccess().getParKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1277:6: ( Break )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1277:6: ( Break )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1278:1: Break
                    {
                     before(grammarAccess.getEndIDAccess().getBreakKeyword_15()); 
                    match(input,Break,FOLLOW_Break_in_rule__EndID__Alternatives2474); 
                     after(grammarAccess.getEndIDAccess().getBreakKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1285:6: ( Critical )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1285:6: ( Critical )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1286:1: Critical
                    {
                     before(grammarAccess.getEndIDAccess().getCriticalKeyword_16()); 
                    match(input,Critical,FOLLOW_Critical_in_rule__EndID__Alternatives2494); 
                     after(grammarAccess.getEndIDAccess().getCriticalKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1293:6: ( Group )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1293:6: ( Group )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1294:1: Group
                    {
                     before(grammarAccess.getEndIDAccess().getGroupKeyword_17()); 
                    match(input,Group,FOLLOW_Group_in_rule__EndID__Alternatives2514); 
                     after(grammarAccess.getEndIDAccess().getGroupKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1301:6: ( Note )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1301:6: ( Note )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1302:1: Note
                    {
                     before(grammarAccess.getEndIDAccess().getNoteKeyword_18()); 
                    match(input,Note,FOLLOW_Note_in_rule__EndID__Alternatives2534); 
                     after(grammarAccess.getEndIDAccess().getNoteKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1309:6: ( Over )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1309:6: ( Over )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1310:1: Over
                    {
                     before(grammarAccess.getEndIDAccess().getOverKeyword_19()); 
                    match(input,Over,FOLLOW_Over_in_rule__EndID__Alternatives2554); 
                     after(grammarAccess.getEndIDAccess().getOverKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1317:6: ( Of )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1317:6: ( Of )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1318:1: Of
                    {
                     before(grammarAccess.getEndIDAccess().getOfKeyword_20()); 
                    match(input,Of,FOLLOW_Of_in_rule__EndID__Alternatives2574); 
                     after(grammarAccess.getEndIDAccess().getOfKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1325:6: ( Ref )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1325:6: ( Ref )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1326:1: Ref
                    {
                     before(grammarAccess.getEndIDAccess().getRefKeyword_21()); 
                    match(input,Ref,FOLLOW_Ref_in_rule__EndID__Alternatives2594); 
                     after(grammarAccess.getEndIDAccess().getRefKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1333:6: ( Hide )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1333:6: ( Hide )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1334:1: Hide
                    {
                     before(grammarAccess.getEndIDAccess().getHideKeyword_22()); 
                    match(input,Hide,FOLLOW_Hide_in_rule__EndID__Alternatives2614); 
                     after(grammarAccess.getEndIDAccess().getHideKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1341:6: ( Footbox )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1341:6: ( Footbox )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1342:1: Footbox
                    {
                     before(grammarAccess.getEndIDAccess().getFootboxKeyword_23()); 
                    match(input,Footbox,FOLLOW_Footbox_in_rule__EndID__Alternatives2634); 
                     after(grammarAccess.getEndIDAccess().getFootboxKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1349:6: ( Activate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1349:6: ( Activate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1350:1: Activate
                    {
                     before(grammarAccess.getEndIDAccess().getActivateKeyword_24()); 
                    match(input,Activate,FOLLOW_Activate_in_rule__EndID__Alternatives2654); 
                     after(grammarAccess.getEndIDAccess().getActivateKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1357:6: ( Deactivate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1357:6: ( Deactivate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1358:1: Deactivate
                    {
                     before(grammarAccess.getEndIDAccess().getDeactivateKeyword_25()); 
                    match(input,Deactivate,FOLLOW_Deactivate_in_rule__EndID__Alternatives2674); 
                     after(grammarAccess.getEndIDAccess().getDeactivateKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1365:6: ( Destroy )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1365:6: ( Destroy )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1366:1: Destroy
                    {
                     before(grammarAccess.getEndIDAccess().getDestroyKeyword_26()); 
                    match(input,Destroy,FOLLOW_Destroy_in_rule__EndID__Alternatives2694); 
                     after(grammarAccess.getEndIDAccess().getDestroyKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1373:6: ( Box )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1373:6: ( Box )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1374:1: Box
                    {
                     before(grammarAccess.getEndIDAccess().getBoxKeyword_27()); 
                    match(input,Box,FOLLOW_Box_in_rule__EndID__Alternatives2714); 
                     after(grammarAccess.getEndIDAccess().getBoxKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1381:6: ( NumberSign )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1381:6: ( NumberSign )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1382:1: NumberSign
                    {
                     before(grammarAccess.getEndIDAccess().getNumberSignKeyword_28()); 
                    match(input,NumberSign,FOLLOW_NumberSign_in_rule__EndID__Alternatives2734); 
                     after(grammarAccess.getEndIDAccess().getNumberSignKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1389:6: ( Comma )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1389:6: ( Comma )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1390:1: Comma
                    {
                     before(grammarAccess.getEndIDAccess().getCommaKeyword_29()); 
                    match(input,Comma,FOLLOW_Comma_in_rule__EndID__Alternatives2754); 
                     after(grammarAccess.getEndIDAccess().getCommaKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1397:6: ( LeftParenthesis )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1397:6: ( LeftParenthesis )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1398:1: LeftParenthesis
                    {
                     before(grammarAccess.getEndIDAccess().getLeftParenthesisKeyword_30()); 
                    match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_rule__EndID__Alternatives2774); 
                     after(grammarAccess.getEndIDAccess().getLeftParenthesisKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1405:6: ( RightParenthesis )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1405:6: ( RightParenthesis )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1406:1: RightParenthesis
                    {
                     before(grammarAccess.getEndIDAccess().getRightParenthesisKeyword_31()); 
                    match(input,RightParenthesis,FOLLOW_RightParenthesis_in_rule__EndID__Alternatives2794); 
                     after(grammarAccess.getEndIDAccess().getRightParenthesisKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1413:6: ( EqualsSign )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1413:6: ( EqualsSign )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1414:1: EqualsSign
                    {
                     before(grammarAccess.getEndIDAccess().getEqualsSignKeyword_32()); 
                    match(input,EqualsSign,FOLLOW_EqualsSign_in_rule__EndID__Alternatives2814); 
                     after(grammarAccess.getEndIDAccess().getEqualsSignKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1421:6: ( RULE_INT )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1421:6: ( RULE_INT )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1422:1: RULE_INT
                    {
                     before(grammarAccess.getEndIDAccess().getINTTerminalRuleCall_33()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__EndID__Alternatives2833); 
                     after(grammarAccess.getEndIDAccess().getINTTerminalRuleCall_33()); 

                    }


                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1427:6: ( HyphenMinus )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1427:6: ( HyphenMinus )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1428:1: HyphenMinus
                    {
                     before(grammarAccess.getEndIDAccess().getHyphenMinusKeyword_34()); 
                    match(input,HyphenMinus,FOLLOW_HyphenMinus_in_rule__EndID__Alternatives2851); 
                     after(grammarAccess.getEndIDAccess().getHyphenMinusKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1435:6: ( FullStop )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1435:6: ( FullStop )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1436:1: FullStop
                    {
                     before(grammarAccess.getEndIDAccess().getFullStopKeyword_35()); 
                    match(input,FullStop,FOLLOW_FullStop_in_rule__EndID__Alternatives2871); 
                     after(grammarAccess.getEndIDAccess().getFullStopKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1443:6: ( Colon )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1443:6: ( Colon )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1444:1: Colon
                    {
                     before(grammarAccess.getEndIDAccess().getColonKeyword_36()); 
                    match(input,Colon,FOLLOW_Colon_in_rule__EndID__Alternatives2891); 
                     after(grammarAccess.getEndIDAccess().getColonKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1451:6: ( GreaterThanSign )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1451:6: ( GreaterThanSign )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1452:1: GreaterThanSign
                    {
                     before(grammarAccess.getEndIDAccess().getGreaterThanSignKeyword_37()); 
                    match(input,GreaterThanSign,FOLLOW_GreaterThanSign_in_rule__EndID__Alternatives2911); 
                     after(grammarAccess.getEndIDAccess().getGreaterThanSignKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1459:6: ( LessThanSign )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1459:6: ( LessThanSign )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1460:1: LessThanSign
                    {
                     before(grammarAccess.getEndIDAccess().getLessThanSignKeyword_38()); 
                    match(input,LessThanSign,FOLLOW_LessThanSign_in_rule__EndID__Alternatives2931); 
                     after(grammarAccess.getEndIDAccess().getLessThanSignKeyword_38()); 

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
    // $ANTLR end "rule__EndID__Alternatives"


    // $ANTLR start "rule__MyID__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1472:1: rule__MyID__Alternatives : ( ( ruleEndID ) | ( End ) );
    public final void rule__MyID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1476:1: ( ( ruleEndID ) | ( End ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=Autonumber && LA5_0<=Deactivate)||LA5_0==Endlegend||LA5_0==Activate||LA5_0==Critical||(LA5_0>=Destroy && LA5_0<=Newpage)||(LA5_0>=Center && LA5_0<=Create)||LA5_0==Legend||(LA5_0>=Break && LA5_0<=Title)||(LA5_0>=Else && LA5_0<=Over)||(LA5_0>=Alt && LA5_0<=Box)||(LA5_0>=Opt && LA5_0<=Ref)||LA5_0==Of||(LA5_0>=NumberSign && LA5_0<=GreaterThanSign)||(LA5_0>=RULE_INT && LA5_0<=RULE_ID)) ) {
                alt5=1;
            }
            else if ( (LA5_0==End) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1477:1: ( ruleEndID )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1477:1: ( ruleEndID )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1478:1: ruleEndID
                    {
                     before(grammarAccess.getMyIDAccess().getEndIDParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleEndID_in_rule__MyID__Alternatives2965);
                    ruleEndID();

                    state._fsp--;

                     after(grammarAccess.getMyIDAccess().getEndIDParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1483:6: ( End )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1483:6: ( End )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1484:1: End
                    {
                     before(grammarAccess.getMyIDAccess().getEndKeyword_1()); 
                    match(input,End,FOLLOW_End_in_rule__MyID__Alternatives2983); 
                     after(grammarAccess.getMyIDAccess().getEndKeyword_1()); 

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
    // $ANTLR end "rule__MyID__Alternatives"


    // $ANTLR start "rule__Legend__Alternatives_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1496:1: rule__Legend__Alternatives_1 : ( ( Right ) | ( Left ) | ( Center ) );
    public final void rule__Legend__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1500:1: ( ( Right ) | ( Left ) | ( Center ) )
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1501:1: ( Right )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1501:1: ( Right )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1502:1: Right
                    {
                     before(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                    match(input,Right,FOLLOW_Right_in_rule__Legend__Alternatives_13018); 
                     after(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1509:6: ( Left )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1509:6: ( Left )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1510:1: Left
                    {
                     before(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                    match(input,Left,FOLLOW_Left_in_rule__Legend__Alternatives_13038); 
                     after(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1517:6: ( Center )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1517:6: ( Center )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1518:1: Center
                    {
                     before(grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                    match(input,Center,FOLLOW_Center_in_rule__Legend__Alternatives_13058); 
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


    // $ANTLR start "rule__GroupingMessages__Alternatives_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1530:1: rule__GroupingMessages__Alternatives_0 : ( ( Opt ) | ( Loop ) | ( Par ) | ( Break ) | ( Critical ) | ( Group ) );
    public final void rule__GroupingMessages__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1534:1: ( ( Opt ) | ( Loop ) | ( Par ) | ( Break ) | ( Critical ) | ( Group ) )
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1535:1: ( Opt )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1535:1: ( Opt )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1536:1: Opt
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getOptKeyword_0_0()); 
                    match(input,Opt,FOLLOW_Opt_in_rule__GroupingMessages__Alternatives_03093); 
                     after(grammarAccess.getGroupingMessagesAccess().getOptKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1543:6: ( Loop )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1543:6: ( Loop )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1544:1: Loop
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getLoopKeyword_0_1()); 
                    match(input,Loop,FOLLOW_Loop_in_rule__GroupingMessages__Alternatives_03113); 
                     after(grammarAccess.getGroupingMessagesAccess().getLoopKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1551:6: ( Par )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1551:6: ( Par )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1552:1: Par
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getParKeyword_0_2()); 
                    match(input,Par,FOLLOW_Par_in_rule__GroupingMessages__Alternatives_03133); 
                     after(grammarAccess.getGroupingMessagesAccess().getParKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1559:6: ( Break )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1559:6: ( Break )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1560:1: Break
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getBreakKeyword_0_3()); 
                    match(input,Break,FOLLOW_Break_in_rule__GroupingMessages__Alternatives_03153); 
                     after(grammarAccess.getGroupingMessagesAccess().getBreakKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1567:6: ( Critical )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1567:6: ( Critical )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1568:1: Critical
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_0_4()); 
                    match(input,Critical,FOLLOW_Critical_in_rule__GroupingMessages__Alternatives_03173); 
                     after(grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1575:6: ( Group )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1575:6: ( Group )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1576:1: Group
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getGroupKeyword_0_5()); 
                    match(input,Group,FOLLOW_Group_in_rule__GroupingMessages__Alternatives_03193); 
                     after(grammarAccess.getGroupingMessagesAccess().getGroupKeyword_0_5()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1588:1: rule__Note__Alternatives_1 : ( ( ( rule__Note__Group_1_0__0 ) ) | ( ( rule__Note__Group_1_1__0 ) ) | ( ( rule__Note__Group_1_2__0 ) ) );
    public final void rule__Note__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1592:1: ( ( ( rule__Note__Group_1_0__0 ) ) | ( ( rule__Note__Group_1_1__0 ) ) | ( ( rule__Note__Group_1_2__0 ) ) )
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1593:1: ( ( rule__Note__Group_1_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1593:1: ( ( rule__Note__Group_1_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1594:1: ( rule__Note__Group_1_0__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_1_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1595:1: ( rule__Note__Group_1_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1595:2: rule__Note__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_0__0_in_rule__Note__Alternatives_13227);
                    rule__Note__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1599:6: ( ( rule__Note__Group_1_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1599:6: ( ( rule__Note__Group_1_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1600:1: ( rule__Note__Group_1_1__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_1_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1601:1: ( rule__Note__Group_1_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1601:2: rule__Note__Group_1_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_1__0_in_rule__Note__Alternatives_13245);
                    rule__Note__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1605:6: ( ( rule__Note__Group_1_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1605:6: ( ( rule__Note__Group_1_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1606:1: ( rule__Note__Group_1_2__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_1_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1607:1: ( rule__Note__Group_1_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1607:2: rule__Note__Group_1_2__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_2__0_in_rule__Note__Alternatives_13263);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1616:1: rule__Note__Alternatives_3 : ( ( ( rule__Note__Group_3_0__0 ) ) | ( ( rule__Note__Group_3_1__0 ) ) );
    public final void rule__Note__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1620:1: ( ( ( rule__Note__Group_3_0__0 ) ) | ( ( rule__Note__Group_3_1__0 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Colon) ) {
                alt9=1;
            }
            else if ( (LA9_0==End||LA9_0==RULE_NEWLINE) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1621:1: ( ( rule__Note__Group_3_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1621:1: ( ( rule__Note__Group_3_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1622:1: ( rule__Note__Group_3_0__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_3_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1623:1: ( rule__Note__Group_3_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1623:2: rule__Note__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_3_0__0_in_rule__Note__Alternatives_33296);
                    rule__Note__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1627:6: ( ( rule__Note__Group_3_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1627:6: ( ( rule__Note__Group_3_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1628:1: ( rule__Note__Group_3_1__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_3_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1629:1: ( rule__Note__Group_3_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1629:2: rule__Note__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_3_1__0_in_rule__Note__Alternatives_33314);
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


    // $ANTLR start "rule__Reference__Alternatives_4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1638:1: rule__Reference__Alternatives_4 : ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ( rule__Reference__Group_4_1__0 ) ) );
    public final void rule__Reference__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1642:1: ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ( rule__Reference__Group_4_1__0 ) ) )
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1643:1: ( ( rule__Reference__Group_4_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1643:1: ( ( rule__Reference__Group_4_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1644:1: ( rule__Reference__Group_4_0__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_4_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1645:1: ( rule__Reference__Group_4_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1645:2: rule__Reference__Group_4_0__0
                    {
                    pushFollow(FOLLOW_rule__Reference__Group_4_0__0_in_rule__Reference__Alternatives_43347);
                    rule__Reference__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceAccess().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1649:6: ( ( rule__Reference__Group_4_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1649:6: ( ( rule__Reference__Group_4_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1650:1: ( rule__Reference__Group_4_1__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_4_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1651:1: ( rule__Reference__Group_4_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1651:2: rule__Reference__Group_4_1__0
                    {
                    pushFollow(FOLLOW_rule__Reference__Group_4_1__0_in_rule__Reference__Alternatives_43365);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1660:1: rule__Space__Alternatives : ( ( VerticalLineVerticalLineVerticalLine ) | ( ( rule__Space__Group_1__0 ) ) );
    public final void rule__Space__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1664:1: ( ( VerticalLineVerticalLineVerticalLine ) | ( ( rule__Space__Group_1__0 ) ) )
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1665:1: ( VerticalLineVerticalLineVerticalLine )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1665:1: ( VerticalLineVerticalLineVerticalLine )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1666:1: VerticalLineVerticalLineVerticalLine
                    {
                     before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 
                    match(input,VerticalLineVerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLineVerticalLine_in_rule__Space__Alternatives3399); 
                     after(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1673:6: ( ( rule__Space__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1673:6: ( ( rule__Space__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1674:1: ( rule__Space__Group_1__0 )
                    {
                     before(grammarAccess.getSpaceAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1675:1: ( rule__Space__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1675:2: rule__Space__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Space__Group_1__0_in_rule__Space__Alternatives3418);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1684:1: rule__Deactivate__Alternatives_0 : ( ( Deactivate ) | ( Destroy ) );
    public final void rule__Deactivate__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1688:1: ( ( Deactivate ) | ( Destroy ) )
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1689:1: ( Deactivate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1689:1: ( Deactivate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1690:1: Deactivate
                    {
                     before(grammarAccess.getDeactivateAccess().getDeactivateKeyword_0_0()); 
                    match(input,Deactivate,FOLLOW_Deactivate_in_rule__Deactivate__Alternatives_03452); 
                     after(grammarAccess.getDeactivateAccess().getDeactivateKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1697:6: ( Destroy )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1697:6: ( Destroy )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1698:1: Destroy
                    {
                     before(grammarAccess.getDeactivateAccess().getDestroyKeyword_0_1()); 
                    match(input,Destroy,FOLLOW_Destroy_in_rule__Deactivate__Alternatives_03472); 
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


    // $ANTLR start "rule__Colors__Alternatives_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1710:1: rule__Colors__Alternatives_1 : ( ( ruleColor ) | ( RULE_HEXCODE ) );
    public final void rule__Colors__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1714:1: ( ( ruleColor ) | ( RULE_HEXCODE ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=LightGoldenRodYellow && LA13_0<=YellowGreen)||(LA13_0>=Aquamarine && LA13_0<=WhiteSmoke)||(LA13_0>=AliceBlue && LA13_0<=Turquoise)||(LA13_0>=Cornsilk && LA13_0<=SeaGreen)||(LA13_0>=Crimson && LA13_0<=Thistle)||(LA13_0>=Bisque && LA13_0<=Yellow)||(LA13_0>=Azure && LA13_0<=White)||(LA13_0>=Aqua && LA13_0<=Teal)||(LA13_0>=Red && LA13_0<=Tan)) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_HEXCODE) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1715:1: ( ruleColor )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1715:1: ( ruleColor )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1716:1: ruleColor
                    {
                     before(grammarAccess.getColorsAccess().getColorParserRuleCall_1_0()); 
                    pushFollow(FOLLOW_ruleColor_in_rule__Colors__Alternatives_13506);
                    ruleColor();

                    state._fsp--;

                     after(grammarAccess.getColorsAccess().getColorParserRuleCall_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1721:6: ( RULE_HEXCODE )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1721:6: ( RULE_HEXCODE )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1722:1: RULE_HEXCODE
                    {
                     before(grammarAccess.getColorsAccess().getHEXCODETerminalRuleCall_1_1()); 
                    match(input,RULE_HEXCODE,FOLLOW_RULE_HEXCODE_in_rule__Colors__Alternatives_13523); 
                     after(grammarAccess.getColorsAccess().getHEXCODETerminalRuleCall_1_1()); 

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
    // $ANTLR end "rule__Colors__Alternatives_1"


    // $ANTLR start "rule__Color__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1732:1: rule__Color__Alternatives : ( ( AliceBlue ) | ( AntiqueWhite ) | ( Aqua ) | ( Aquamarine ) | ( Azure ) | ( Beige ) | ( Bisque ) | ( Black ) | ( BlanchedAlmond ) | ( Blue ) | ( BlueViolet ) | ( Brown ) | ( BurlyWood ) | ( CadetBlue ) | ( Chartreuse ) | ( Chocolate ) | ( Coral ) | ( CornflowerBlue ) | ( Cornsilk ) | ( Crimson ) | ( Cyan ) | ( DarkBlue ) | ( DarkCyan ) | ( DarkGoldenRod ) | ( DarkGray ) | ( DarkGreen ) | ( DarkGrey ) | ( DarkKhaki ) | ( DarkMagenta ) | ( DarkOliveGreen ) | ( DarkOrchid ) | ( DarkRed ) | ( DarkSalmo ) | ( DarkSeaGreen ) | ( DarkSlateBlue ) | ( DarkSlateGray ) | ( DarkSlateGrey ) | ( DarkTurquoise ) | ( DarkViolet ) | ( Darkorange ) | ( DeepPink ) | ( DeepSkyBlue ) | ( DimGray ) | ( DimGrey ) | ( DodgerBlue ) | ( FireBrick ) | ( FloralWhite ) | ( ForestGreen ) | ( Fuchsia ) | ( Gainsboro ) | ( GhostWhite ) | ( Gold ) | ( GoldenRod ) | ( Gray ) | ( Green ) | ( GreenYellow ) | ( Grey ) | ( HoneyDew ) | ( HotPink ) | ( IndianRed ) | ( Indigo ) | ( Ivory ) | ( Khaki ) | ( Lavender ) | ( LavenderBlush ) | ( LawnGreen ) | ( LemonChiffon ) | ( LightBlue ) | ( LightCoral ) | ( LightCyan ) | ( LightGoldenRodYellow ) | ( LightGray ) | ( LightGreen ) | ( LightGrey ) | ( LightPink ) | ( LightSalmon ) | ( LightSeaGreen ) | ( LightSkyBlue ) | ( LightSlateGray ) | ( LightSlateGrey ) | ( LightSteelBlue ) | ( LightYellow ) | ( Lime ) | ( LimeGreen ) | ( Linen ) | ( Magenta ) | ( Maroon ) | ( MediumAquaMarine ) | ( MediumBlue ) | ( MediumOrchid ) | ( MediumPurple ) | ( MediumSeaGreen ) | ( MediumSlateBlue ) | ( MediumSpringGreen ) | ( MediumTurquoise ) | ( MediumVioletRed ) | ( MidnightBlue ) | ( MintCream ) | ( MistyRose ) | ( Moccasin ) | ( NavajoWhite ) | ( Navy ) | ( OldLace ) | ( Olive ) | ( OliveDrab ) | ( OrangeRed ) | ( Orchid ) | ( PaleGoldenRod ) | ( PaleGreen ) | ( PaleTurquoise ) | ( PaleVioletRed ) | ( PapayaWhip ) | ( PeachPuff ) | ( Peru ) | ( Pink ) | ( Plum ) | ( PowderBlue ) | ( Purple ) | ( Red ) | ( RosyBrown ) | ( RoyalBlue ) | ( SaddleBrown ) | ( Salmon ) | ( SandyBrown ) | ( SeaGreen ) | ( Sienna ) | ( Silver ) | ( SkyBlue ) | ( SlateBlue ) | ( SlateGray ) | ( SlateGrey ) | ( Snow ) | ( SpringGreen ) | ( SteelBlue ) | ( Tan ) | ( Teal ) | ( Thistle ) | ( Tomato ) | ( Turquoise ) | ( Violet ) | ( Wheat ) | ( White ) | ( WhiteSmoke ) | ( Yellow ) | ( YellowGreen ) );
    public final void rule__Color__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1736:1: ( ( AliceBlue ) | ( AntiqueWhite ) | ( Aqua ) | ( Aquamarine ) | ( Azure ) | ( Beige ) | ( Bisque ) | ( Black ) | ( BlanchedAlmond ) | ( Blue ) | ( BlueViolet ) | ( Brown ) | ( BurlyWood ) | ( CadetBlue ) | ( Chartreuse ) | ( Chocolate ) | ( Coral ) | ( CornflowerBlue ) | ( Cornsilk ) | ( Crimson ) | ( Cyan ) | ( DarkBlue ) | ( DarkCyan ) | ( DarkGoldenRod ) | ( DarkGray ) | ( DarkGreen ) | ( DarkGrey ) | ( DarkKhaki ) | ( DarkMagenta ) | ( DarkOliveGreen ) | ( DarkOrchid ) | ( DarkRed ) | ( DarkSalmo ) | ( DarkSeaGreen ) | ( DarkSlateBlue ) | ( DarkSlateGray ) | ( DarkSlateGrey ) | ( DarkTurquoise ) | ( DarkViolet ) | ( Darkorange ) | ( DeepPink ) | ( DeepSkyBlue ) | ( DimGray ) | ( DimGrey ) | ( DodgerBlue ) | ( FireBrick ) | ( FloralWhite ) | ( ForestGreen ) | ( Fuchsia ) | ( Gainsboro ) | ( GhostWhite ) | ( Gold ) | ( GoldenRod ) | ( Gray ) | ( Green ) | ( GreenYellow ) | ( Grey ) | ( HoneyDew ) | ( HotPink ) | ( IndianRed ) | ( Indigo ) | ( Ivory ) | ( Khaki ) | ( Lavender ) | ( LavenderBlush ) | ( LawnGreen ) | ( LemonChiffon ) | ( LightBlue ) | ( LightCoral ) | ( LightCyan ) | ( LightGoldenRodYellow ) | ( LightGray ) | ( LightGreen ) | ( LightGrey ) | ( LightPink ) | ( LightSalmon ) | ( LightSeaGreen ) | ( LightSkyBlue ) | ( LightSlateGray ) | ( LightSlateGrey ) | ( LightSteelBlue ) | ( LightYellow ) | ( Lime ) | ( LimeGreen ) | ( Linen ) | ( Magenta ) | ( Maroon ) | ( MediumAquaMarine ) | ( MediumBlue ) | ( MediumOrchid ) | ( MediumPurple ) | ( MediumSeaGreen ) | ( MediumSlateBlue ) | ( MediumSpringGreen ) | ( MediumTurquoise ) | ( MediumVioletRed ) | ( MidnightBlue ) | ( MintCream ) | ( MistyRose ) | ( Moccasin ) | ( NavajoWhite ) | ( Navy ) | ( OldLace ) | ( Olive ) | ( OliveDrab ) | ( OrangeRed ) | ( Orchid ) | ( PaleGoldenRod ) | ( PaleGreen ) | ( PaleTurquoise ) | ( PaleVioletRed ) | ( PapayaWhip ) | ( PeachPuff ) | ( Peru ) | ( Pink ) | ( Plum ) | ( PowderBlue ) | ( Purple ) | ( Red ) | ( RosyBrown ) | ( RoyalBlue ) | ( SaddleBrown ) | ( Salmon ) | ( SandyBrown ) | ( SeaGreen ) | ( Sienna ) | ( Silver ) | ( SkyBlue ) | ( SlateBlue ) | ( SlateGray ) | ( SlateGrey ) | ( Snow ) | ( SpringGreen ) | ( SteelBlue ) | ( Tan ) | ( Teal ) | ( Thistle ) | ( Tomato ) | ( Turquoise ) | ( Violet ) | ( Wheat ) | ( White ) | ( WhiteSmoke ) | ( Yellow ) | ( YellowGreen ) )
            int alt14=145;
            switch ( input.LA(1) ) {
            case AliceBlue:
                {
                alt14=1;
                }
                break;
            case AntiqueWhite:
                {
                alt14=2;
                }
                break;
            case Aqua:
                {
                alt14=3;
                }
                break;
            case Aquamarine:
                {
                alt14=4;
                }
                break;
            case Azure:
                {
                alt14=5;
                }
                break;
            case Beige:
                {
                alt14=6;
                }
                break;
            case Bisque:
                {
                alt14=7;
                }
                break;
            case Black:
                {
                alt14=8;
                }
                break;
            case BlanchedAlmond:
                {
                alt14=9;
                }
                break;
            case Blue:
                {
                alt14=10;
                }
                break;
            case BlueViolet:
                {
                alt14=11;
                }
                break;
            case Brown:
                {
                alt14=12;
                }
                break;
            case BurlyWood:
                {
                alt14=13;
                }
                break;
            case CadetBlue:
                {
                alt14=14;
                }
                break;
            case Chartreuse:
                {
                alt14=15;
                }
                break;
            case Chocolate:
                {
                alt14=16;
                }
                break;
            case Coral:
                {
                alt14=17;
                }
                break;
            case CornflowerBlue:
                {
                alt14=18;
                }
                break;
            case Cornsilk:
                {
                alt14=19;
                }
                break;
            case Crimson:
                {
                alt14=20;
                }
                break;
            case Cyan:
                {
                alt14=21;
                }
                break;
            case DarkBlue:
                {
                alt14=22;
                }
                break;
            case DarkCyan:
                {
                alt14=23;
                }
                break;
            case DarkGoldenRod:
                {
                alt14=24;
                }
                break;
            case DarkGray:
                {
                alt14=25;
                }
                break;
            case DarkGreen:
                {
                alt14=26;
                }
                break;
            case DarkGrey:
                {
                alt14=27;
                }
                break;
            case DarkKhaki:
                {
                alt14=28;
                }
                break;
            case DarkMagenta:
                {
                alt14=29;
                }
                break;
            case DarkOliveGreen:
                {
                alt14=30;
                }
                break;
            case DarkOrchid:
                {
                alt14=31;
                }
                break;
            case DarkRed:
                {
                alt14=32;
                }
                break;
            case DarkSalmo:
                {
                alt14=33;
                }
                break;
            case DarkSeaGreen:
                {
                alt14=34;
                }
                break;
            case DarkSlateBlue:
                {
                alt14=35;
                }
                break;
            case DarkSlateGray:
                {
                alt14=36;
                }
                break;
            case DarkSlateGrey:
                {
                alt14=37;
                }
                break;
            case DarkTurquoise:
                {
                alt14=38;
                }
                break;
            case DarkViolet:
                {
                alt14=39;
                }
                break;
            case Darkorange:
                {
                alt14=40;
                }
                break;
            case DeepPink:
                {
                alt14=41;
                }
                break;
            case DeepSkyBlue:
                {
                alt14=42;
                }
                break;
            case DimGray:
                {
                alt14=43;
                }
                break;
            case DimGrey:
                {
                alt14=44;
                }
                break;
            case DodgerBlue:
                {
                alt14=45;
                }
                break;
            case FireBrick:
                {
                alt14=46;
                }
                break;
            case FloralWhite:
                {
                alt14=47;
                }
                break;
            case ForestGreen:
                {
                alt14=48;
                }
                break;
            case Fuchsia:
                {
                alt14=49;
                }
                break;
            case Gainsboro:
                {
                alt14=50;
                }
                break;
            case GhostWhite:
                {
                alt14=51;
                }
                break;
            case Gold:
                {
                alt14=52;
                }
                break;
            case GoldenRod:
                {
                alt14=53;
                }
                break;
            case Gray:
                {
                alt14=54;
                }
                break;
            case Green:
                {
                alt14=55;
                }
                break;
            case GreenYellow:
                {
                alt14=56;
                }
                break;
            case Grey:
                {
                alt14=57;
                }
                break;
            case HoneyDew:
                {
                alt14=58;
                }
                break;
            case HotPink:
                {
                alt14=59;
                }
                break;
            case IndianRed:
                {
                alt14=60;
                }
                break;
            case Indigo:
                {
                alt14=61;
                }
                break;
            case Ivory:
                {
                alt14=62;
                }
                break;
            case Khaki:
                {
                alt14=63;
                }
                break;
            case Lavender:
                {
                alt14=64;
                }
                break;
            case LavenderBlush:
                {
                alt14=65;
                }
                break;
            case LawnGreen:
                {
                alt14=66;
                }
                break;
            case LemonChiffon:
                {
                alt14=67;
                }
                break;
            case LightBlue:
                {
                alt14=68;
                }
                break;
            case LightCoral:
                {
                alt14=69;
                }
                break;
            case LightCyan:
                {
                alt14=70;
                }
                break;
            case LightGoldenRodYellow:
                {
                alt14=71;
                }
                break;
            case LightGray:
                {
                alt14=72;
                }
                break;
            case LightGreen:
                {
                alt14=73;
                }
                break;
            case LightGrey:
                {
                alt14=74;
                }
                break;
            case LightPink:
                {
                alt14=75;
                }
                break;
            case LightSalmon:
                {
                alt14=76;
                }
                break;
            case LightSeaGreen:
                {
                alt14=77;
                }
                break;
            case LightSkyBlue:
                {
                alt14=78;
                }
                break;
            case LightSlateGray:
                {
                alt14=79;
                }
                break;
            case LightSlateGrey:
                {
                alt14=80;
                }
                break;
            case LightSteelBlue:
                {
                alt14=81;
                }
                break;
            case LightYellow:
                {
                alt14=82;
                }
                break;
            case Lime:
                {
                alt14=83;
                }
                break;
            case LimeGreen:
                {
                alt14=84;
                }
                break;
            case Linen:
                {
                alt14=85;
                }
                break;
            case Magenta:
                {
                alt14=86;
                }
                break;
            case Maroon:
                {
                alt14=87;
                }
                break;
            case MediumAquaMarine:
                {
                alt14=88;
                }
                break;
            case MediumBlue:
                {
                alt14=89;
                }
                break;
            case MediumOrchid:
                {
                alt14=90;
                }
                break;
            case MediumPurple:
                {
                alt14=91;
                }
                break;
            case MediumSeaGreen:
                {
                alt14=92;
                }
                break;
            case MediumSlateBlue:
                {
                alt14=93;
                }
                break;
            case MediumSpringGreen:
                {
                alt14=94;
                }
                break;
            case MediumTurquoise:
                {
                alt14=95;
                }
                break;
            case MediumVioletRed:
                {
                alt14=96;
                }
                break;
            case MidnightBlue:
                {
                alt14=97;
                }
                break;
            case MintCream:
                {
                alt14=98;
                }
                break;
            case MistyRose:
                {
                alt14=99;
                }
                break;
            case Moccasin:
                {
                alt14=100;
                }
                break;
            case NavajoWhite:
                {
                alt14=101;
                }
                break;
            case Navy:
                {
                alt14=102;
                }
                break;
            case OldLace:
                {
                alt14=103;
                }
                break;
            case Olive:
                {
                alt14=104;
                }
                break;
            case OliveDrab:
                {
                alt14=105;
                }
                break;
            case OrangeRed:
                {
                alt14=106;
                }
                break;
            case Orchid:
                {
                alt14=107;
                }
                break;
            case PaleGoldenRod:
                {
                alt14=108;
                }
                break;
            case PaleGreen:
                {
                alt14=109;
                }
                break;
            case PaleTurquoise:
                {
                alt14=110;
                }
                break;
            case PaleVioletRed:
                {
                alt14=111;
                }
                break;
            case PapayaWhip:
                {
                alt14=112;
                }
                break;
            case PeachPuff:
                {
                alt14=113;
                }
                break;
            case Peru:
                {
                alt14=114;
                }
                break;
            case Pink:
                {
                alt14=115;
                }
                break;
            case Plum:
                {
                alt14=116;
                }
                break;
            case PowderBlue:
                {
                alt14=117;
                }
                break;
            case Purple:
                {
                alt14=118;
                }
                break;
            case Red:
                {
                alt14=119;
                }
                break;
            case RosyBrown:
                {
                alt14=120;
                }
                break;
            case RoyalBlue:
                {
                alt14=121;
                }
                break;
            case SaddleBrown:
                {
                alt14=122;
                }
                break;
            case Salmon:
                {
                alt14=123;
                }
                break;
            case SandyBrown:
                {
                alt14=124;
                }
                break;
            case SeaGreen:
                {
                alt14=125;
                }
                break;
            case Sienna:
                {
                alt14=126;
                }
                break;
            case Silver:
                {
                alt14=127;
                }
                break;
            case SkyBlue:
                {
                alt14=128;
                }
                break;
            case SlateBlue:
                {
                alt14=129;
                }
                break;
            case SlateGray:
                {
                alt14=130;
                }
                break;
            case SlateGrey:
                {
                alt14=131;
                }
                break;
            case Snow:
                {
                alt14=132;
                }
                break;
            case SpringGreen:
                {
                alt14=133;
                }
                break;
            case SteelBlue:
                {
                alt14=134;
                }
                break;
            case Tan:
                {
                alt14=135;
                }
                break;
            case Teal:
                {
                alt14=136;
                }
                break;
            case Thistle:
                {
                alt14=137;
                }
                break;
            case Tomato:
                {
                alt14=138;
                }
                break;
            case Turquoise:
                {
                alt14=139;
                }
                break;
            case Violet:
                {
                alt14=140;
                }
                break;
            case Wheat:
                {
                alt14=141;
                }
                break;
            case White:
                {
                alt14=142;
                }
                break;
            case WhiteSmoke:
                {
                alt14=143;
                }
                break;
            case Yellow:
                {
                alt14=144;
                }
                break;
            case YellowGreen:
                {
                alt14=145;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1737:1: ( AliceBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1737:1: ( AliceBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1738:1: AliceBlue
                    {
                     before(grammarAccess.getColorAccess().getAliceBlueKeyword_0()); 
                    match(input,AliceBlue,FOLLOW_AliceBlue_in_rule__Color__Alternatives3556); 
                     after(grammarAccess.getColorAccess().getAliceBlueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1745:6: ( AntiqueWhite )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1745:6: ( AntiqueWhite )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1746:1: AntiqueWhite
                    {
                     before(grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1()); 
                    match(input,AntiqueWhite,FOLLOW_AntiqueWhite_in_rule__Color__Alternatives3576); 
                     after(grammarAccess.getColorAccess().getAntiqueWhiteKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1753:6: ( Aqua )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1753:6: ( Aqua )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1754:1: Aqua
                    {
                     before(grammarAccess.getColorAccess().getAquaKeyword_2()); 
                    match(input,Aqua,FOLLOW_Aqua_in_rule__Color__Alternatives3596); 
                     after(grammarAccess.getColorAccess().getAquaKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1761:6: ( Aquamarine )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1761:6: ( Aquamarine )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1762:1: Aquamarine
                    {
                     before(grammarAccess.getColorAccess().getAquamarineKeyword_3()); 
                    match(input,Aquamarine,FOLLOW_Aquamarine_in_rule__Color__Alternatives3616); 
                     after(grammarAccess.getColorAccess().getAquamarineKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1769:6: ( Azure )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1769:6: ( Azure )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1770:1: Azure
                    {
                     before(grammarAccess.getColorAccess().getAzureKeyword_4()); 
                    match(input,Azure,FOLLOW_Azure_in_rule__Color__Alternatives3636); 
                     after(grammarAccess.getColorAccess().getAzureKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1777:6: ( Beige )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1777:6: ( Beige )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1778:1: Beige
                    {
                     before(grammarAccess.getColorAccess().getBeigeKeyword_5()); 
                    match(input,Beige,FOLLOW_Beige_in_rule__Color__Alternatives3656); 
                     after(grammarAccess.getColorAccess().getBeigeKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1785:6: ( Bisque )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1785:6: ( Bisque )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1786:1: Bisque
                    {
                     before(grammarAccess.getColorAccess().getBisqueKeyword_6()); 
                    match(input,Bisque,FOLLOW_Bisque_in_rule__Color__Alternatives3676); 
                     after(grammarAccess.getColorAccess().getBisqueKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1793:6: ( Black )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1793:6: ( Black )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1794:1: Black
                    {
                     before(grammarAccess.getColorAccess().getBlackKeyword_7()); 
                    match(input,Black,FOLLOW_Black_in_rule__Color__Alternatives3696); 
                     after(grammarAccess.getColorAccess().getBlackKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1801:6: ( BlanchedAlmond )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1801:6: ( BlanchedAlmond )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1802:1: BlanchedAlmond
                    {
                     before(grammarAccess.getColorAccess().getBlanchedAlmondKeyword_8()); 
                    match(input,BlanchedAlmond,FOLLOW_BlanchedAlmond_in_rule__Color__Alternatives3716); 
                     after(grammarAccess.getColorAccess().getBlanchedAlmondKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1809:6: ( Blue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1809:6: ( Blue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1810:1: Blue
                    {
                     before(grammarAccess.getColorAccess().getBlueKeyword_9()); 
                    match(input,Blue,FOLLOW_Blue_in_rule__Color__Alternatives3736); 
                     after(grammarAccess.getColorAccess().getBlueKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1817:6: ( BlueViolet )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1817:6: ( BlueViolet )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1818:1: BlueViolet
                    {
                     before(grammarAccess.getColorAccess().getBlueVioletKeyword_10()); 
                    match(input,BlueViolet,FOLLOW_BlueViolet_in_rule__Color__Alternatives3756); 
                     after(grammarAccess.getColorAccess().getBlueVioletKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1825:6: ( Brown )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1825:6: ( Brown )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1826:1: Brown
                    {
                     before(grammarAccess.getColorAccess().getBrownKeyword_11()); 
                    match(input,Brown,FOLLOW_Brown_in_rule__Color__Alternatives3776); 
                     after(grammarAccess.getColorAccess().getBrownKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1833:6: ( BurlyWood )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1833:6: ( BurlyWood )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1834:1: BurlyWood
                    {
                     before(grammarAccess.getColorAccess().getBurlyWoodKeyword_12()); 
                    match(input,BurlyWood,FOLLOW_BurlyWood_in_rule__Color__Alternatives3796); 
                     after(grammarAccess.getColorAccess().getBurlyWoodKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1841:6: ( CadetBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1841:6: ( CadetBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1842:1: CadetBlue
                    {
                     before(grammarAccess.getColorAccess().getCadetBlueKeyword_13()); 
                    match(input,CadetBlue,FOLLOW_CadetBlue_in_rule__Color__Alternatives3816); 
                     after(grammarAccess.getColorAccess().getCadetBlueKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1849:6: ( Chartreuse )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1849:6: ( Chartreuse )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1850:1: Chartreuse
                    {
                     before(grammarAccess.getColorAccess().getChartreuseKeyword_14()); 
                    match(input,Chartreuse,FOLLOW_Chartreuse_in_rule__Color__Alternatives3836); 
                     after(grammarAccess.getColorAccess().getChartreuseKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1857:6: ( Chocolate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1857:6: ( Chocolate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1858:1: Chocolate
                    {
                     before(grammarAccess.getColorAccess().getChocolateKeyword_15()); 
                    match(input,Chocolate,FOLLOW_Chocolate_in_rule__Color__Alternatives3856); 
                     after(grammarAccess.getColorAccess().getChocolateKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1865:6: ( Coral )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1865:6: ( Coral )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1866:1: Coral
                    {
                     before(grammarAccess.getColorAccess().getCoralKeyword_16()); 
                    match(input,Coral,FOLLOW_Coral_in_rule__Color__Alternatives3876); 
                     after(grammarAccess.getColorAccess().getCoralKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1873:6: ( CornflowerBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1873:6: ( CornflowerBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1874:1: CornflowerBlue
                    {
                     before(grammarAccess.getColorAccess().getCornflowerBlueKeyword_17()); 
                    match(input,CornflowerBlue,FOLLOW_CornflowerBlue_in_rule__Color__Alternatives3896); 
                     after(grammarAccess.getColorAccess().getCornflowerBlueKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1881:6: ( Cornsilk )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1881:6: ( Cornsilk )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1882:1: Cornsilk
                    {
                     before(grammarAccess.getColorAccess().getCornsilkKeyword_18()); 
                    match(input,Cornsilk,FOLLOW_Cornsilk_in_rule__Color__Alternatives3916); 
                     after(grammarAccess.getColorAccess().getCornsilkKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1889:6: ( Crimson )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1889:6: ( Crimson )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1890:1: Crimson
                    {
                     before(grammarAccess.getColorAccess().getCrimsonKeyword_19()); 
                    match(input,Crimson,FOLLOW_Crimson_in_rule__Color__Alternatives3936); 
                     after(grammarAccess.getColorAccess().getCrimsonKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1897:6: ( Cyan )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1897:6: ( Cyan )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1898:1: Cyan
                    {
                     before(grammarAccess.getColorAccess().getCyanKeyword_20()); 
                    match(input,Cyan,FOLLOW_Cyan_in_rule__Color__Alternatives3956); 
                     after(grammarAccess.getColorAccess().getCyanKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1905:6: ( DarkBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1905:6: ( DarkBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1906:1: DarkBlue
                    {
                     before(grammarAccess.getColorAccess().getDarkBlueKeyword_21()); 
                    match(input,DarkBlue,FOLLOW_DarkBlue_in_rule__Color__Alternatives3976); 
                     after(grammarAccess.getColorAccess().getDarkBlueKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1913:6: ( DarkCyan )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1913:6: ( DarkCyan )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1914:1: DarkCyan
                    {
                     before(grammarAccess.getColorAccess().getDarkCyanKeyword_22()); 
                    match(input,DarkCyan,FOLLOW_DarkCyan_in_rule__Color__Alternatives3996); 
                     after(grammarAccess.getColorAccess().getDarkCyanKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1921:6: ( DarkGoldenRod )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1921:6: ( DarkGoldenRod )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1922:1: DarkGoldenRod
                    {
                     before(grammarAccess.getColorAccess().getDarkGoldenRodKeyword_23()); 
                    match(input,DarkGoldenRod,FOLLOW_DarkGoldenRod_in_rule__Color__Alternatives4016); 
                     after(grammarAccess.getColorAccess().getDarkGoldenRodKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1929:6: ( DarkGray )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1929:6: ( DarkGray )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1930:1: DarkGray
                    {
                     before(grammarAccess.getColorAccess().getDarkGrayKeyword_24()); 
                    match(input,DarkGray,FOLLOW_DarkGray_in_rule__Color__Alternatives4036); 
                     after(grammarAccess.getColorAccess().getDarkGrayKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1937:6: ( DarkGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1937:6: ( DarkGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1938:1: DarkGreen
                    {
                     before(grammarAccess.getColorAccess().getDarkGreenKeyword_25()); 
                    match(input,DarkGreen,FOLLOW_DarkGreen_in_rule__Color__Alternatives4056); 
                     after(grammarAccess.getColorAccess().getDarkGreenKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1945:6: ( DarkGrey )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1945:6: ( DarkGrey )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1946:1: DarkGrey
                    {
                     before(grammarAccess.getColorAccess().getDarkGreyKeyword_26()); 
                    match(input,DarkGrey,FOLLOW_DarkGrey_in_rule__Color__Alternatives4076); 
                     after(grammarAccess.getColorAccess().getDarkGreyKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1953:6: ( DarkKhaki )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1953:6: ( DarkKhaki )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1954:1: DarkKhaki
                    {
                     before(grammarAccess.getColorAccess().getDarkKhakiKeyword_27()); 
                    match(input,DarkKhaki,FOLLOW_DarkKhaki_in_rule__Color__Alternatives4096); 
                     after(grammarAccess.getColorAccess().getDarkKhakiKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1961:6: ( DarkMagenta )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1961:6: ( DarkMagenta )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1962:1: DarkMagenta
                    {
                     before(grammarAccess.getColorAccess().getDarkMagentaKeyword_28()); 
                    match(input,DarkMagenta,FOLLOW_DarkMagenta_in_rule__Color__Alternatives4116); 
                     after(grammarAccess.getColorAccess().getDarkMagentaKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1969:6: ( DarkOliveGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1969:6: ( DarkOliveGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1970:1: DarkOliveGreen
                    {
                     before(grammarAccess.getColorAccess().getDarkOliveGreenKeyword_29()); 
                    match(input,DarkOliveGreen,FOLLOW_DarkOliveGreen_in_rule__Color__Alternatives4136); 
                     after(grammarAccess.getColorAccess().getDarkOliveGreenKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1977:6: ( DarkOrchid )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1977:6: ( DarkOrchid )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1978:1: DarkOrchid
                    {
                     before(grammarAccess.getColorAccess().getDarkOrchidKeyword_30()); 
                    match(input,DarkOrchid,FOLLOW_DarkOrchid_in_rule__Color__Alternatives4156); 
                     after(grammarAccess.getColorAccess().getDarkOrchidKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1985:6: ( DarkRed )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1985:6: ( DarkRed )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1986:1: DarkRed
                    {
                     before(grammarAccess.getColorAccess().getDarkRedKeyword_31()); 
                    match(input,DarkRed,FOLLOW_DarkRed_in_rule__Color__Alternatives4176); 
                     after(grammarAccess.getColorAccess().getDarkRedKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1993:6: ( DarkSalmo )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1993:6: ( DarkSalmo )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1994:1: DarkSalmo
                    {
                     before(grammarAccess.getColorAccess().getDarkSalmoKeyword_32()); 
                    match(input,DarkSalmo,FOLLOW_DarkSalmo_in_rule__Color__Alternatives4196); 
                     after(grammarAccess.getColorAccess().getDarkSalmoKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2001:6: ( DarkSeaGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2001:6: ( DarkSeaGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2002:1: DarkSeaGreen
                    {
                     before(grammarAccess.getColorAccess().getDarkSeaGreenKeyword_33()); 
                    match(input,DarkSeaGreen,FOLLOW_DarkSeaGreen_in_rule__Color__Alternatives4216); 
                     after(grammarAccess.getColorAccess().getDarkSeaGreenKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2009:6: ( DarkSlateBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2009:6: ( DarkSlateBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2010:1: DarkSlateBlue
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateBlueKeyword_34()); 
                    match(input,DarkSlateBlue,FOLLOW_DarkSlateBlue_in_rule__Color__Alternatives4236); 
                     after(grammarAccess.getColorAccess().getDarkSlateBlueKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2017:6: ( DarkSlateGray )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2017:6: ( DarkSlateGray )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2018:1: DarkSlateGray
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateGrayKeyword_35()); 
                    match(input,DarkSlateGray,FOLLOW_DarkSlateGray_in_rule__Color__Alternatives4256); 
                     after(grammarAccess.getColorAccess().getDarkSlateGrayKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2025:6: ( DarkSlateGrey )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2025:6: ( DarkSlateGrey )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2026:1: DarkSlateGrey
                    {
                     before(grammarAccess.getColorAccess().getDarkSlateGreyKeyword_36()); 
                    match(input,DarkSlateGrey,FOLLOW_DarkSlateGrey_in_rule__Color__Alternatives4276); 
                     after(grammarAccess.getColorAccess().getDarkSlateGreyKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2033:6: ( DarkTurquoise )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2033:6: ( DarkTurquoise )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2034:1: DarkTurquoise
                    {
                     before(grammarAccess.getColorAccess().getDarkTurquoiseKeyword_37()); 
                    match(input,DarkTurquoise,FOLLOW_DarkTurquoise_in_rule__Color__Alternatives4296); 
                     after(grammarAccess.getColorAccess().getDarkTurquoiseKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2041:6: ( DarkViolet )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2041:6: ( DarkViolet )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2042:1: DarkViolet
                    {
                     before(grammarAccess.getColorAccess().getDarkVioletKeyword_38()); 
                    match(input,DarkViolet,FOLLOW_DarkViolet_in_rule__Color__Alternatives4316); 
                     after(grammarAccess.getColorAccess().getDarkVioletKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2049:6: ( Darkorange )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2049:6: ( Darkorange )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2050:1: Darkorange
                    {
                     before(grammarAccess.getColorAccess().getDarkorangeKeyword_39()); 
                    match(input,Darkorange,FOLLOW_Darkorange_in_rule__Color__Alternatives4336); 
                     after(grammarAccess.getColorAccess().getDarkorangeKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2057:6: ( DeepPink )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2057:6: ( DeepPink )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2058:1: DeepPink
                    {
                     before(grammarAccess.getColorAccess().getDeepPinkKeyword_40()); 
                    match(input,DeepPink,FOLLOW_DeepPink_in_rule__Color__Alternatives4356); 
                     after(grammarAccess.getColorAccess().getDeepPinkKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2065:6: ( DeepSkyBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2065:6: ( DeepSkyBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2066:1: DeepSkyBlue
                    {
                     before(grammarAccess.getColorAccess().getDeepSkyBlueKeyword_41()); 
                    match(input,DeepSkyBlue,FOLLOW_DeepSkyBlue_in_rule__Color__Alternatives4376); 
                     after(grammarAccess.getColorAccess().getDeepSkyBlueKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2073:6: ( DimGray )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2073:6: ( DimGray )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2074:1: DimGray
                    {
                     before(grammarAccess.getColorAccess().getDimGrayKeyword_42()); 
                    match(input,DimGray,FOLLOW_DimGray_in_rule__Color__Alternatives4396); 
                     after(grammarAccess.getColorAccess().getDimGrayKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2081:6: ( DimGrey )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2081:6: ( DimGrey )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2082:1: DimGrey
                    {
                     before(grammarAccess.getColorAccess().getDimGreyKeyword_43()); 
                    match(input,DimGrey,FOLLOW_DimGrey_in_rule__Color__Alternatives4416); 
                     after(grammarAccess.getColorAccess().getDimGreyKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2089:6: ( DodgerBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2089:6: ( DodgerBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2090:1: DodgerBlue
                    {
                     before(grammarAccess.getColorAccess().getDodgerBlueKeyword_44()); 
                    match(input,DodgerBlue,FOLLOW_DodgerBlue_in_rule__Color__Alternatives4436); 
                     after(grammarAccess.getColorAccess().getDodgerBlueKeyword_44()); 

                    }


                    }
                    break;
                case 46 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2097:6: ( FireBrick )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2097:6: ( FireBrick )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2098:1: FireBrick
                    {
                     before(grammarAccess.getColorAccess().getFireBrickKeyword_45()); 
                    match(input,FireBrick,FOLLOW_FireBrick_in_rule__Color__Alternatives4456); 
                     after(grammarAccess.getColorAccess().getFireBrickKeyword_45()); 

                    }


                    }
                    break;
                case 47 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2105:6: ( FloralWhite )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2105:6: ( FloralWhite )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2106:1: FloralWhite
                    {
                     before(grammarAccess.getColorAccess().getFloralWhiteKeyword_46()); 
                    match(input,FloralWhite,FOLLOW_FloralWhite_in_rule__Color__Alternatives4476); 
                     after(grammarAccess.getColorAccess().getFloralWhiteKeyword_46()); 

                    }


                    }
                    break;
                case 48 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2113:6: ( ForestGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2113:6: ( ForestGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2114:1: ForestGreen
                    {
                     before(grammarAccess.getColorAccess().getForestGreenKeyword_47()); 
                    match(input,ForestGreen,FOLLOW_ForestGreen_in_rule__Color__Alternatives4496); 
                     after(grammarAccess.getColorAccess().getForestGreenKeyword_47()); 

                    }


                    }
                    break;
                case 49 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2121:6: ( Fuchsia )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2121:6: ( Fuchsia )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2122:1: Fuchsia
                    {
                     before(grammarAccess.getColorAccess().getFuchsiaKeyword_48()); 
                    match(input,Fuchsia,FOLLOW_Fuchsia_in_rule__Color__Alternatives4516); 
                     after(grammarAccess.getColorAccess().getFuchsiaKeyword_48()); 

                    }


                    }
                    break;
                case 50 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2129:6: ( Gainsboro )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2129:6: ( Gainsboro )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2130:1: Gainsboro
                    {
                     before(grammarAccess.getColorAccess().getGainsboroKeyword_49()); 
                    match(input,Gainsboro,FOLLOW_Gainsboro_in_rule__Color__Alternatives4536); 
                     after(grammarAccess.getColorAccess().getGainsboroKeyword_49()); 

                    }


                    }
                    break;
                case 51 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2137:6: ( GhostWhite )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2137:6: ( GhostWhite )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2138:1: GhostWhite
                    {
                     before(grammarAccess.getColorAccess().getGhostWhiteKeyword_50()); 
                    match(input,GhostWhite,FOLLOW_GhostWhite_in_rule__Color__Alternatives4556); 
                     after(grammarAccess.getColorAccess().getGhostWhiteKeyword_50()); 

                    }


                    }
                    break;
                case 52 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2145:6: ( Gold )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2145:6: ( Gold )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2146:1: Gold
                    {
                     before(grammarAccess.getColorAccess().getGoldKeyword_51()); 
                    match(input,Gold,FOLLOW_Gold_in_rule__Color__Alternatives4576); 
                     after(grammarAccess.getColorAccess().getGoldKeyword_51()); 

                    }


                    }
                    break;
                case 53 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2153:6: ( GoldenRod )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2153:6: ( GoldenRod )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2154:1: GoldenRod
                    {
                     before(grammarAccess.getColorAccess().getGoldenRodKeyword_52()); 
                    match(input,GoldenRod,FOLLOW_GoldenRod_in_rule__Color__Alternatives4596); 
                     after(grammarAccess.getColorAccess().getGoldenRodKeyword_52()); 

                    }


                    }
                    break;
                case 54 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2161:6: ( Gray )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2161:6: ( Gray )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2162:1: Gray
                    {
                     before(grammarAccess.getColorAccess().getGrayKeyword_53()); 
                    match(input,Gray,FOLLOW_Gray_in_rule__Color__Alternatives4616); 
                     after(grammarAccess.getColorAccess().getGrayKeyword_53()); 

                    }


                    }
                    break;
                case 55 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2169:6: ( Green )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2169:6: ( Green )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2170:1: Green
                    {
                     before(grammarAccess.getColorAccess().getGreenKeyword_54()); 
                    match(input,Green,FOLLOW_Green_in_rule__Color__Alternatives4636); 
                     after(grammarAccess.getColorAccess().getGreenKeyword_54()); 

                    }


                    }
                    break;
                case 56 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2177:6: ( GreenYellow )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2177:6: ( GreenYellow )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2178:1: GreenYellow
                    {
                     before(grammarAccess.getColorAccess().getGreenYellowKeyword_55()); 
                    match(input,GreenYellow,FOLLOW_GreenYellow_in_rule__Color__Alternatives4656); 
                     after(grammarAccess.getColorAccess().getGreenYellowKeyword_55()); 

                    }


                    }
                    break;
                case 57 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2185:6: ( Grey )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2185:6: ( Grey )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2186:1: Grey
                    {
                     before(grammarAccess.getColorAccess().getGreyKeyword_56()); 
                    match(input,Grey,FOLLOW_Grey_in_rule__Color__Alternatives4676); 
                     after(grammarAccess.getColorAccess().getGreyKeyword_56()); 

                    }


                    }
                    break;
                case 58 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2193:6: ( HoneyDew )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2193:6: ( HoneyDew )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2194:1: HoneyDew
                    {
                     before(grammarAccess.getColorAccess().getHoneyDewKeyword_57()); 
                    match(input,HoneyDew,FOLLOW_HoneyDew_in_rule__Color__Alternatives4696); 
                     after(grammarAccess.getColorAccess().getHoneyDewKeyword_57()); 

                    }


                    }
                    break;
                case 59 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2201:6: ( HotPink )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2201:6: ( HotPink )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2202:1: HotPink
                    {
                     before(grammarAccess.getColorAccess().getHotPinkKeyword_58()); 
                    match(input,HotPink,FOLLOW_HotPink_in_rule__Color__Alternatives4716); 
                     after(grammarAccess.getColorAccess().getHotPinkKeyword_58()); 

                    }


                    }
                    break;
                case 60 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2209:6: ( IndianRed )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2209:6: ( IndianRed )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2210:1: IndianRed
                    {
                     before(grammarAccess.getColorAccess().getIndianRedKeyword_59()); 
                    match(input,IndianRed,FOLLOW_IndianRed_in_rule__Color__Alternatives4736); 
                     after(grammarAccess.getColorAccess().getIndianRedKeyword_59()); 

                    }


                    }
                    break;
                case 61 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2217:6: ( Indigo )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2217:6: ( Indigo )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2218:1: Indigo
                    {
                     before(grammarAccess.getColorAccess().getIndigoKeyword_60()); 
                    match(input,Indigo,FOLLOW_Indigo_in_rule__Color__Alternatives4756); 
                     after(grammarAccess.getColorAccess().getIndigoKeyword_60()); 

                    }


                    }
                    break;
                case 62 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2225:6: ( Ivory )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2225:6: ( Ivory )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2226:1: Ivory
                    {
                     before(grammarAccess.getColorAccess().getIvoryKeyword_61()); 
                    match(input,Ivory,FOLLOW_Ivory_in_rule__Color__Alternatives4776); 
                     after(grammarAccess.getColorAccess().getIvoryKeyword_61()); 

                    }


                    }
                    break;
                case 63 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2233:6: ( Khaki )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2233:6: ( Khaki )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2234:1: Khaki
                    {
                     before(grammarAccess.getColorAccess().getKhakiKeyword_62()); 
                    match(input,Khaki,FOLLOW_Khaki_in_rule__Color__Alternatives4796); 
                     after(grammarAccess.getColorAccess().getKhakiKeyword_62()); 

                    }


                    }
                    break;
                case 64 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2241:6: ( Lavender )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2241:6: ( Lavender )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2242:1: Lavender
                    {
                     before(grammarAccess.getColorAccess().getLavenderKeyword_63()); 
                    match(input,Lavender,FOLLOW_Lavender_in_rule__Color__Alternatives4816); 
                     after(grammarAccess.getColorAccess().getLavenderKeyword_63()); 

                    }


                    }
                    break;
                case 65 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2249:6: ( LavenderBlush )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2249:6: ( LavenderBlush )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2250:1: LavenderBlush
                    {
                     before(grammarAccess.getColorAccess().getLavenderBlushKeyword_64()); 
                    match(input,LavenderBlush,FOLLOW_LavenderBlush_in_rule__Color__Alternatives4836); 
                     after(grammarAccess.getColorAccess().getLavenderBlushKeyword_64()); 

                    }


                    }
                    break;
                case 66 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2257:6: ( LawnGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2257:6: ( LawnGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2258:1: LawnGreen
                    {
                     before(grammarAccess.getColorAccess().getLawnGreenKeyword_65()); 
                    match(input,LawnGreen,FOLLOW_LawnGreen_in_rule__Color__Alternatives4856); 
                     after(grammarAccess.getColorAccess().getLawnGreenKeyword_65()); 

                    }


                    }
                    break;
                case 67 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2265:6: ( LemonChiffon )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2265:6: ( LemonChiffon )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2266:1: LemonChiffon
                    {
                     before(grammarAccess.getColorAccess().getLemonChiffonKeyword_66()); 
                    match(input,LemonChiffon,FOLLOW_LemonChiffon_in_rule__Color__Alternatives4876); 
                     after(grammarAccess.getColorAccess().getLemonChiffonKeyword_66()); 

                    }


                    }
                    break;
                case 68 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2273:6: ( LightBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2273:6: ( LightBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2274:1: LightBlue
                    {
                     before(grammarAccess.getColorAccess().getLightBlueKeyword_67()); 
                    match(input,LightBlue,FOLLOW_LightBlue_in_rule__Color__Alternatives4896); 
                     after(grammarAccess.getColorAccess().getLightBlueKeyword_67()); 

                    }


                    }
                    break;
                case 69 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2281:6: ( LightCoral )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2281:6: ( LightCoral )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2282:1: LightCoral
                    {
                     before(grammarAccess.getColorAccess().getLightCoralKeyword_68()); 
                    match(input,LightCoral,FOLLOW_LightCoral_in_rule__Color__Alternatives4916); 
                     after(grammarAccess.getColorAccess().getLightCoralKeyword_68()); 

                    }


                    }
                    break;
                case 70 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2289:6: ( LightCyan )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2289:6: ( LightCyan )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2290:1: LightCyan
                    {
                     before(grammarAccess.getColorAccess().getLightCyanKeyword_69()); 
                    match(input,LightCyan,FOLLOW_LightCyan_in_rule__Color__Alternatives4936); 
                     after(grammarAccess.getColorAccess().getLightCyanKeyword_69()); 

                    }


                    }
                    break;
                case 71 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2297:6: ( LightGoldenRodYellow )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2297:6: ( LightGoldenRodYellow )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2298:1: LightGoldenRodYellow
                    {
                     before(grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_70()); 
                    match(input,LightGoldenRodYellow,FOLLOW_LightGoldenRodYellow_in_rule__Color__Alternatives4956); 
                     after(grammarAccess.getColorAccess().getLightGoldenRodYellowKeyword_70()); 

                    }


                    }
                    break;
                case 72 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2305:6: ( LightGray )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2305:6: ( LightGray )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2306:1: LightGray
                    {
                     before(grammarAccess.getColorAccess().getLightGrayKeyword_71()); 
                    match(input,LightGray,FOLLOW_LightGray_in_rule__Color__Alternatives4976); 
                     after(grammarAccess.getColorAccess().getLightGrayKeyword_71()); 

                    }


                    }
                    break;
                case 73 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2313:6: ( LightGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2313:6: ( LightGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2314:1: LightGreen
                    {
                     before(grammarAccess.getColorAccess().getLightGreenKeyword_72()); 
                    match(input,LightGreen,FOLLOW_LightGreen_in_rule__Color__Alternatives4996); 
                     after(grammarAccess.getColorAccess().getLightGreenKeyword_72()); 

                    }


                    }
                    break;
                case 74 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2321:6: ( LightGrey )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2321:6: ( LightGrey )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2322:1: LightGrey
                    {
                     before(grammarAccess.getColorAccess().getLightGreyKeyword_73()); 
                    match(input,LightGrey,FOLLOW_LightGrey_in_rule__Color__Alternatives5016); 
                     after(grammarAccess.getColorAccess().getLightGreyKeyword_73()); 

                    }


                    }
                    break;
                case 75 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2329:6: ( LightPink )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2329:6: ( LightPink )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2330:1: LightPink
                    {
                     before(grammarAccess.getColorAccess().getLightPinkKeyword_74()); 
                    match(input,LightPink,FOLLOW_LightPink_in_rule__Color__Alternatives5036); 
                     after(grammarAccess.getColorAccess().getLightPinkKeyword_74()); 

                    }


                    }
                    break;
                case 76 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2337:6: ( LightSalmon )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2337:6: ( LightSalmon )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2338:1: LightSalmon
                    {
                     before(grammarAccess.getColorAccess().getLightSalmonKeyword_75()); 
                    match(input,LightSalmon,FOLLOW_LightSalmon_in_rule__Color__Alternatives5056); 
                     after(grammarAccess.getColorAccess().getLightSalmonKeyword_75()); 

                    }


                    }
                    break;
                case 77 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2345:6: ( LightSeaGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2345:6: ( LightSeaGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2346:1: LightSeaGreen
                    {
                     before(grammarAccess.getColorAccess().getLightSeaGreenKeyword_76()); 
                    match(input,LightSeaGreen,FOLLOW_LightSeaGreen_in_rule__Color__Alternatives5076); 
                     after(grammarAccess.getColorAccess().getLightSeaGreenKeyword_76()); 

                    }


                    }
                    break;
                case 78 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2353:6: ( LightSkyBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2353:6: ( LightSkyBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2354:1: LightSkyBlue
                    {
                     before(grammarAccess.getColorAccess().getLightSkyBlueKeyword_77()); 
                    match(input,LightSkyBlue,FOLLOW_LightSkyBlue_in_rule__Color__Alternatives5096); 
                     after(grammarAccess.getColorAccess().getLightSkyBlueKeyword_77()); 

                    }


                    }
                    break;
                case 79 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2361:6: ( LightSlateGray )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2361:6: ( LightSlateGray )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2362:1: LightSlateGray
                    {
                     before(grammarAccess.getColorAccess().getLightSlateGrayKeyword_78()); 
                    match(input,LightSlateGray,FOLLOW_LightSlateGray_in_rule__Color__Alternatives5116); 
                     after(grammarAccess.getColorAccess().getLightSlateGrayKeyword_78()); 

                    }


                    }
                    break;
                case 80 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2369:6: ( LightSlateGrey )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2369:6: ( LightSlateGrey )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2370:1: LightSlateGrey
                    {
                     before(grammarAccess.getColorAccess().getLightSlateGreyKeyword_79()); 
                    match(input,LightSlateGrey,FOLLOW_LightSlateGrey_in_rule__Color__Alternatives5136); 
                     after(grammarAccess.getColorAccess().getLightSlateGreyKeyword_79()); 

                    }


                    }
                    break;
                case 81 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2377:6: ( LightSteelBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2377:6: ( LightSteelBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2378:1: LightSteelBlue
                    {
                     before(grammarAccess.getColorAccess().getLightSteelBlueKeyword_80()); 
                    match(input,LightSteelBlue,FOLLOW_LightSteelBlue_in_rule__Color__Alternatives5156); 
                     after(grammarAccess.getColorAccess().getLightSteelBlueKeyword_80()); 

                    }


                    }
                    break;
                case 82 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2385:6: ( LightYellow )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2385:6: ( LightYellow )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2386:1: LightYellow
                    {
                     before(grammarAccess.getColorAccess().getLightYellowKeyword_81()); 
                    match(input,LightYellow,FOLLOW_LightYellow_in_rule__Color__Alternatives5176); 
                     after(grammarAccess.getColorAccess().getLightYellowKeyword_81()); 

                    }


                    }
                    break;
                case 83 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2393:6: ( Lime )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2393:6: ( Lime )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2394:1: Lime
                    {
                     before(grammarAccess.getColorAccess().getLimeKeyword_82()); 
                    match(input,Lime,FOLLOW_Lime_in_rule__Color__Alternatives5196); 
                     after(grammarAccess.getColorAccess().getLimeKeyword_82()); 

                    }


                    }
                    break;
                case 84 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2401:6: ( LimeGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2401:6: ( LimeGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2402:1: LimeGreen
                    {
                     before(grammarAccess.getColorAccess().getLimeGreenKeyword_83()); 
                    match(input,LimeGreen,FOLLOW_LimeGreen_in_rule__Color__Alternatives5216); 
                     after(grammarAccess.getColorAccess().getLimeGreenKeyword_83()); 

                    }


                    }
                    break;
                case 85 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2409:6: ( Linen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2409:6: ( Linen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2410:1: Linen
                    {
                     before(grammarAccess.getColorAccess().getLinenKeyword_84()); 
                    match(input,Linen,FOLLOW_Linen_in_rule__Color__Alternatives5236); 
                     after(grammarAccess.getColorAccess().getLinenKeyword_84()); 

                    }


                    }
                    break;
                case 86 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2417:6: ( Magenta )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2417:6: ( Magenta )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2418:1: Magenta
                    {
                     before(grammarAccess.getColorAccess().getMagentaKeyword_85()); 
                    match(input,Magenta,FOLLOW_Magenta_in_rule__Color__Alternatives5256); 
                     after(grammarAccess.getColorAccess().getMagentaKeyword_85()); 

                    }


                    }
                    break;
                case 87 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2425:6: ( Maroon )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2425:6: ( Maroon )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2426:1: Maroon
                    {
                     before(grammarAccess.getColorAccess().getMaroonKeyword_86()); 
                    match(input,Maroon,FOLLOW_Maroon_in_rule__Color__Alternatives5276); 
                     after(grammarAccess.getColorAccess().getMaroonKeyword_86()); 

                    }


                    }
                    break;
                case 88 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2433:6: ( MediumAquaMarine )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2433:6: ( MediumAquaMarine )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2434:1: MediumAquaMarine
                    {
                     before(grammarAccess.getColorAccess().getMediumAquaMarineKeyword_87()); 
                    match(input,MediumAquaMarine,FOLLOW_MediumAquaMarine_in_rule__Color__Alternatives5296); 
                     after(grammarAccess.getColorAccess().getMediumAquaMarineKeyword_87()); 

                    }


                    }
                    break;
                case 89 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2441:6: ( MediumBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2441:6: ( MediumBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2442:1: MediumBlue
                    {
                     before(grammarAccess.getColorAccess().getMediumBlueKeyword_88()); 
                    match(input,MediumBlue,FOLLOW_MediumBlue_in_rule__Color__Alternatives5316); 
                     after(grammarAccess.getColorAccess().getMediumBlueKeyword_88()); 

                    }


                    }
                    break;
                case 90 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2449:6: ( MediumOrchid )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2449:6: ( MediumOrchid )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2450:1: MediumOrchid
                    {
                     before(grammarAccess.getColorAccess().getMediumOrchidKeyword_89()); 
                    match(input,MediumOrchid,FOLLOW_MediumOrchid_in_rule__Color__Alternatives5336); 
                     after(grammarAccess.getColorAccess().getMediumOrchidKeyword_89()); 

                    }


                    }
                    break;
                case 91 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2457:6: ( MediumPurple )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2457:6: ( MediumPurple )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2458:1: MediumPurple
                    {
                     before(grammarAccess.getColorAccess().getMediumPurpleKeyword_90()); 
                    match(input,MediumPurple,FOLLOW_MediumPurple_in_rule__Color__Alternatives5356); 
                     after(grammarAccess.getColorAccess().getMediumPurpleKeyword_90()); 

                    }


                    }
                    break;
                case 92 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2465:6: ( MediumSeaGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2465:6: ( MediumSeaGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2466:1: MediumSeaGreen
                    {
                     before(grammarAccess.getColorAccess().getMediumSeaGreenKeyword_91()); 
                    match(input,MediumSeaGreen,FOLLOW_MediumSeaGreen_in_rule__Color__Alternatives5376); 
                     after(grammarAccess.getColorAccess().getMediumSeaGreenKeyword_91()); 

                    }


                    }
                    break;
                case 93 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2473:6: ( MediumSlateBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2473:6: ( MediumSlateBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2474:1: MediumSlateBlue
                    {
                     before(grammarAccess.getColorAccess().getMediumSlateBlueKeyword_92()); 
                    match(input,MediumSlateBlue,FOLLOW_MediumSlateBlue_in_rule__Color__Alternatives5396); 
                     after(grammarAccess.getColorAccess().getMediumSlateBlueKeyword_92()); 

                    }


                    }
                    break;
                case 94 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2481:6: ( MediumSpringGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2481:6: ( MediumSpringGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2482:1: MediumSpringGreen
                    {
                     before(grammarAccess.getColorAccess().getMediumSpringGreenKeyword_93()); 
                    match(input,MediumSpringGreen,FOLLOW_MediumSpringGreen_in_rule__Color__Alternatives5416); 
                     after(grammarAccess.getColorAccess().getMediumSpringGreenKeyword_93()); 

                    }


                    }
                    break;
                case 95 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2489:6: ( MediumTurquoise )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2489:6: ( MediumTurquoise )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2490:1: MediumTurquoise
                    {
                     before(grammarAccess.getColorAccess().getMediumTurquoiseKeyword_94()); 
                    match(input,MediumTurquoise,FOLLOW_MediumTurquoise_in_rule__Color__Alternatives5436); 
                     after(grammarAccess.getColorAccess().getMediumTurquoiseKeyword_94()); 

                    }


                    }
                    break;
                case 96 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2497:6: ( MediumVioletRed )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2497:6: ( MediumVioletRed )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2498:1: MediumVioletRed
                    {
                     before(grammarAccess.getColorAccess().getMediumVioletRedKeyword_95()); 
                    match(input,MediumVioletRed,FOLLOW_MediumVioletRed_in_rule__Color__Alternatives5456); 
                     after(grammarAccess.getColorAccess().getMediumVioletRedKeyword_95()); 

                    }


                    }
                    break;
                case 97 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2505:6: ( MidnightBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2505:6: ( MidnightBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2506:1: MidnightBlue
                    {
                     before(grammarAccess.getColorAccess().getMidnightBlueKeyword_96()); 
                    match(input,MidnightBlue,FOLLOW_MidnightBlue_in_rule__Color__Alternatives5476); 
                     after(grammarAccess.getColorAccess().getMidnightBlueKeyword_96()); 

                    }


                    }
                    break;
                case 98 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2513:6: ( MintCream )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2513:6: ( MintCream )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2514:1: MintCream
                    {
                     before(grammarAccess.getColorAccess().getMintCreamKeyword_97()); 
                    match(input,MintCream,FOLLOW_MintCream_in_rule__Color__Alternatives5496); 
                     after(grammarAccess.getColorAccess().getMintCreamKeyword_97()); 

                    }


                    }
                    break;
                case 99 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2521:6: ( MistyRose )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2521:6: ( MistyRose )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2522:1: MistyRose
                    {
                     before(grammarAccess.getColorAccess().getMistyRoseKeyword_98()); 
                    match(input,MistyRose,FOLLOW_MistyRose_in_rule__Color__Alternatives5516); 
                     after(grammarAccess.getColorAccess().getMistyRoseKeyword_98()); 

                    }


                    }
                    break;
                case 100 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2529:6: ( Moccasin )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2529:6: ( Moccasin )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2530:1: Moccasin
                    {
                     before(grammarAccess.getColorAccess().getMoccasinKeyword_99()); 
                    match(input,Moccasin,FOLLOW_Moccasin_in_rule__Color__Alternatives5536); 
                     after(grammarAccess.getColorAccess().getMoccasinKeyword_99()); 

                    }


                    }
                    break;
                case 101 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2537:6: ( NavajoWhite )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2537:6: ( NavajoWhite )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2538:1: NavajoWhite
                    {
                     before(grammarAccess.getColorAccess().getNavajoWhiteKeyword_100()); 
                    match(input,NavajoWhite,FOLLOW_NavajoWhite_in_rule__Color__Alternatives5556); 
                     after(grammarAccess.getColorAccess().getNavajoWhiteKeyword_100()); 

                    }


                    }
                    break;
                case 102 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2545:6: ( Navy )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2545:6: ( Navy )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2546:1: Navy
                    {
                     before(grammarAccess.getColorAccess().getNavyKeyword_101()); 
                    match(input,Navy,FOLLOW_Navy_in_rule__Color__Alternatives5576); 
                     after(grammarAccess.getColorAccess().getNavyKeyword_101()); 

                    }


                    }
                    break;
                case 103 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2553:6: ( OldLace )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2553:6: ( OldLace )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2554:1: OldLace
                    {
                     before(grammarAccess.getColorAccess().getOldLaceKeyword_102()); 
                    match(input,OldLace,FOLLOW_OldLace_in_rule__Color__Alternatives5596); 
                     after(grammarAccess.getColorAccess().getOldLaceKeyword_102()); 

                    }


                    }
                    break;
                case 104 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2561:6: ( Olive )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2561:6: ( Olive )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2562:1: Olive
                    {
                     before(grammarAccess.getColorAccess().getOliveKeyword_103()); 
                    match(input,Olive,FOLLOW_Olive_in_rule__Color__Alternatives5616); 
                     after(grammarAccess.getColorAccess().getOliveKeyword_103()); 

                    }


                    }
                    break;
                case 105 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2569:6: ( OliveDrab )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2569:6: ( OliveDrab )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2570:1: OliveDrab
                    {
                     before(grammarAccess.getColorAccess().getOliveDrabKeyword_104()); 
                    match(input,OliveDrab,FOLLOW_OliveDrab_in_rule__Color__Alternatives5636); 
                     after(grammarAccess.getColorAccess().getOliveDrabKeyword_104()); 

                    }


                    }
                    break;
                case 106 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2577:6: ( OrangeRed )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2577:6: ( OrangeRed )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2578:1: OrangeRed
                    {
                     before(grammarAccess.getColorAccess().getOrangeRedKeyword_105()); 
                    match(input,OrangeRed,FOLLOW_OrangeRed_in_rule__Color__Alternatives5656); 
                     after(grammarAccess.getColorAccess().getOrangeRedKeyword_105()); 

                    }


                    }
                    break;
                case 107 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2585:6: ( Orchid )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2585:6: ( Orchid )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2586:1: Orchid
                    {
                     before(grammarAccess.getColorAccess().getOrchidKeyword_106()); 
                    match(input,Orchid,FOLLOW_Orchid_in_rule__Color__Alternatives5676); 
                     after(grammarAccess.getColorAccess().getOrchidKeyword_106()); 

                    }


                    }
                    break;
                case 108 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2593:6: ( PaleGoldenRod )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2593:6: ( PaleGoldenRod )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2594:1: PaleGoldenRod
                    {
                     before(grammarAccess.getColorAccess().getPaleGoldenRodKeyword_107()); 
                    match(input,PaleGoldenRod,FOLLOW_PaleGoldenRod_in_rule__Color__Alternatives5696); 
                     after(grammarAccess.getColorAccess().getPaleGoldenRodKeyword_107()); 

                    }


                    }
                    break;
                case 109 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2601:6: ( PaleGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2601:6: ( PaleGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2602:1: PaleGreen
                    {
                     before(grammarAccess.getColorAccess().getPaleGreenKeyword_108()); 
                    match(input,PaleGreen,FOLLOW_PaleGreen_in_rule__Color__Alternatives5716); 
                     after(grammarAccess.getColorAccess().getPaleGreenKeyword_108()); 

                    }


                    }
                    break;
                case 110 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2609:6: ( PaleTurquoise )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2609:6: ( PaleTurquoise )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2610:1: PaleTurquoise
                    {
                     before(grammarAccess.getColorAccess().getPaleTurquoiseKeyword_109()); 
                    match(input,PaleTurquoise,FOLLOW_PaleTurquoise_in_rule__Color__Alternatives5736); 
                     after(grammarAccess.getColorAccess().getPaleTurquoiseKeyword_109()); 

                    }


                    }
                    break;
                case 111 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2617:6: ( PaleVioletRed )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2617:6: ( PaleVioletRed )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2618:1: PaleVioletRed
                    {
                     before(grammarAccess.getColorAccess().getPaleVioletRedKeyword_110()); 
                    match(input,PaleVioletRed,FOLLOW_PaleVioletRed_in_rule__Color__Alternatives5756); 
                     after(grammarAccess.getColorAccess().getPaleVioletRedKeyword_110()); 

                    }


                    }
                    break;
                case 112 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2625:6: ( PapayaWhip )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2625:6: ( PapayaWhip )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2626:1: PapayaWhip
                    {
                     before(grammarAccess.getColorAccess().getPapayaWhipKeyword_111()); 
                    match(input,PapayaWhip,FOLLOW_PapayaWhip_in_rule__Color__Alternatives5776); 
                     after(grammarAccess.getColorAccess().getPapayaWhipKeyword_111()); 

                    }


                    }
                    break;
                case 113 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2633:6: ( PeachPuff )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2633:6: ( PeachPuff )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2634:1: PeachPuff
                    {
                     before(grammarAccess.getColorAccess().getPeachPuffKeyword_112()); 
                    match(input,PeachPuff,FOLLOW_PeachPuff_in_rule__Color__Alternatives5796); 
                     after(grammarAccess.getColorAccess().getPeachPuffKeyword_112()); 

                    }


                    }
                    break;
                case 114 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2641:6: ( Peru )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2641:6: ( Peru )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2642:1: Peru
                    {
                     before(grammarAccess.getColorAccess().getPeruKeyword_113()); 
                    match(input,Peru,FOLLOW_Peru_in_rule__Color__Alternatives5816); 
                     after(grammarAccess.getColorAccess().getPeruKeyword_113()); 

                    }


                    }
                    break;
                case 115 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2649:6: ( Pink )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2649:6: ( Pink )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2650:1: Pink
                    {
                     before(grammarAccess.getColorAccess().getPinkKeyword_114()); 
                    match(input,Pink,FOLLOW_Pink_in_rule__Color__Alternatives5836); 
                     after(grammarAccess.getColorAccess().getPinkKeyword_114()); 

                    }


                    }
                    break;
                case 116 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2657:6: ( Plum )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2657:6: ( Plum )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2658:1: Plum
                    {
                     before(grammarAccess.getColorAccess().getPlumKeyword_115()); 
                    match(input,Plum,FOLLOW_Plum_in_rule__Color__Alternatives5856); 
                     after(grammarAccess.getColorAccess().getPlumKeyword_115()); 

                    }


                    }
                    break;
                case 117 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2665:6: ( PowderBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2665:6: ( PowderBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2666:1: PowderBlue
                    {
                     before(grammarAccess.getColorAccess().getPowderBlueKeyword_116()); 
                    match(input,PowderBlue,FOLLOW_PowderBlue_in_rule__Color__Alternatives5876); 
                     after(grammarAccess.getColorAccess().getPowderBlueKeyword_116()); 

                    }


                    }
                    break;
                case 118 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2673:6: ( Purple )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2673:6: ( Purple )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2674:1: Purple
                    {
                     before(grammarAccess.getColorAccess().getPurpleKeyword_117()); 
                    match(input,Purple,FOLLOW_Purple_in_rule__Color__Alternatives5896); 
                     after(grammarAccess.getColorAccess().getPurpleKeyword_117()); 

                    }


                    }
                    break;
                case 119 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2681:6: ( Red )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2681:6: ( Red )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2682:1: Red
                    {
                     before(grammarAccess.getColorAccess().getRedKeyword_118()); 
                    match(input,Red,FOLLOW_Red_in_rule__Color__Alternatives5916); 
                     after(grammarAccess.getColorAccess().getRedKeyword_118()); 

                    }


                    }
                    break;
                case 120 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2689:6: ( RosyBrown )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2689:6: ( RosyBrown )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2690:1: RosyBrown
                    {
                     before(grammarAccess.getColorAccess().getRosyBrownKeyword_119()); 
                    match(input,RosyBrown,FOLLOW_RosyBrown_in_rule__Color__Alternatives5936); 
                     after(grammarAccess.getColorAccess().getRosyBrownKeyword_119()); 

                    }


                    }
                    break;
                case 121 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2697:6: ( RoyalBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2697:6: ( RoyalBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2698:1: RoyalBlue
                    {
                     before(grammarAccess.getColorAccess().getRoyalBlueKeyword_120()); 
                    match(input,RoyalBlue,FOLLOW_RoyalBlue_in_rule__Color__Alternatives5956); 
                     after(grammarAccess.getColorAccess().getRoyalBlueKeyword_120()); 

                    }


                    }
                    break;
                case 122 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2705:6: ( SaddleBrown )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2705:6: ( SaddleBrown )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2706:1: SaddleBrown
                    {
                     before(grammarAccess.getColorAccess().getSaddleBrownKeyword_121()); 
                    match(input,SaddleBrown,FOLLOW_SaddleBrown_in_rule__Color__Alternatives5976); 
                     after(grammarAccess.getColorAccess().getSaddleBrownKeyword_121()); 

                    }


                    }
                    break;
                case 123 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2713:6: ( Salmon )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2713:6: ( Salmon )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2714:1: Salmon
                    {
                     before(grammarAccess.getColorAccess().getSalmonKeyword_122()); 
                    match(input,Salmon,FOLLOW_Salmon_in_rule__Color__Alternatives5996); 
                     after(grammarAccess.getColorAccess().getSalmonKeyword_122()); 

                    }


                    }
                    break;
                case 124 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2721:6: ( SandyBrown )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2721:6: ( SandyBrown )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2722:1: SandyBrown
                    {
                     before(grammarAccess.getColorAccess().getSandyBrownKeyword_123()); 
                    match(input,SandyBrown,FOLLOW_SandyBrown_in_rule__Color__Alternatives6016); 
                     after(grammarAccess.getColorAccess().getSandyBrownKeyword_123()); 

                    }


                    }
                    break;
                case 125 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2729:6: ( SeaGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2729:6: ( SeaGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2730:1: SeaGreen
                    {
                     before(grammarAccess.getColorAccess().getSeaGreenKeyword_124()); 
                    match(input,SeaGreen,FOLLOW_SeaGreen_in_rule__Color__Alternatives6036); 
                     after(grammarAccess.getColorAccess().getSeaGreenKeyword_124()); 

                    }


                    }
                    break;
                case 126 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2737:6: ( Sienna )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2737:6: ( Sienna )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2738:1: Sienna
                    {
                     before(grammarAccess.getColorAccess().getSiennaKeyword_125()); 
                    match(input,Sienna,FOLLOW_Sienna_in_rule__Color__Alternatives6056); 
                     after(grammarAccess.getColorAccess().getSiennaKeyword_125()); 

                    }


                    }
                    break;
                case 127 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2745:6: ( Silver )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2745:6: ( Silver )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2746:1: Silver
                    {
                     before(grammarAccess.getColorAccess().getSilverKeyword_126()); 
                    match(input,Silver,FOLLOW_Silver_in_rule__Color__Alternatives6076); 
                     after(grammarAccess.getColorAccess().getSilverKeyword_126()); 

                    }


                    }
                    break;
                case 128 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2753:6: ( SkyBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2753:6: ( SkyBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2754:1: SkyBlue
                    {
                     before(grammarAccess.getColorAccess().getSkyBlueKeyword_127()); 
                    match(input,SkyBlue,FOLLOW_SkyBlue_in_rule__Color__Alternatives6096); 
                     after(grammarAccess.getColorAccess().getSkyBlueKeyword_127()); 

                    }


                    }
                    break;
                case 129 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2761:6: ( SlateBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2761:6: ( SlateBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2762:1: SlateBlue
                    {
                     before(grammarAccess.getColorAccess().getSlateBlueKeyword_128()); 
                    match(input,SlateBlue,FOLLOW_SlateBlue_in_rule__Color__Alternatives6116); 
                     after(grammarAccess.getColorAccess().getSlateBlueKeyword_128()); 

                    }


                    }
                    break;
                case 130 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2769:6: ( SlateGray )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2769:6: ( SlateGray )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2770:1: SlateGray
                    {
                     before(grammarAccess.getColorAccess().getSlateGrayKeyword_129()); 
                    match(input,SlateGray,FOLLOW_SlateGray_in_rule__Color__Alternatives6136); 
                     after(grammarAccess.getColorAccess().getSlateGrayKeyword_129()); 

                    }


                    }
                    break;
                case 131 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2777:6: ( SlateGrey )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2777:6: ( SlateGrey )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2778:1: SlateGrey
                    {
                     before(grammarAccess.getColorAccess().getSlateGreyKeyword_130()); 
                    match(input,SlateGrey,FOLLOW_SlateGrey_in_rule__Color__Alternatives6156); 
                     after(grammarAccess.getColorAccess().getSlateGreyKeyword_130()); 

                    }


                    }
                    break;
                case 132 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2785:6: ( Snow )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2785:6: ( Snow )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2786:1: Snow
                    {
                     before(grammarAccess.getColorAccess().getSnowKeyword_131()); 
                    match(input,Snow,FOLLOW_Snow_in_rule__Color__Alternatives6176); 
                     after(grammarAccess.getColorAccess().getSnowKeyword_131()); 

                    }


                    }
                    break;
                case 133 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2793:6: ( SpringGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2793:6: ( SpringGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2794:1: SpringGreen
                    {
                     before(grammarAccess.getColorAccess().getSpringGreenKeyword_132()); 
                    match(input,SpringGreen,FOLLOW_SpringGreen_in_rule__Color__Alternatives6196); 
                     after(grammarAccess.getColorAccess().getSpringGreenKeyword_132()); 

                    }


                    }
                    break;
                case 134 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2801:6: ( SteelBlue )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2801:6: ( SteelBlue )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2802:1: SteelBlue
                    {
                     before(grammarAccess.getColorAccess().getSteelBlueKeyword_133()); 
                    match(input,SteelBlue,FOLLOW_SteelBlue_in_rule__Color__Alternatives6216); 
                     after(grammarAccess.getColorAccess().getSteelBlueKeyword_133()); 

                    }


                    }
                    break;
                case 135 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2809:6: ( Tan )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2809:6: ( Tan )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2810:1: Tan
                    {
                     before(grammarAccess.getColorAccess().getTanKeyword_134()); 
                    match(input,Tan,FOLLOW_Tan_in_rule__Color__Alternatives6236); 
                     after(grammarAccess.getColorAccess().getTanKeyword_134()); 

                    }


                    }
                    break;
                case 136 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2817:6: ( Teal )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2817:6: ( Teal )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2818:1: Teal
                    {
                     before(grammarAccess.getColorAccess().getTealKeyword_135()); 
                    match(input,Teal,FOLLOW_Teal_in_rule__Color__Alternatives6256); 
                     after(grammarAccess.getColorAccess().getTealKeyword_135()); 

                    }


                    }
                    break;
                case 137 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2825:6: ( Thistle )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2825:6: ( Thistle )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2826:1: Thistle
                    {
                     before(grammarAccess.getColorAccess().getThistleKeyword_136()); 
                    match(input,Thistle,FOLLOW_Thistle_in_rule__Color__Alternatives6276); 
                     after(grammarAccess.getColorAccess().getThistleKeyword_136()); 

                    }


                    }
                    break;
                case 138 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2833:6: ( Tomato )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2833:6: ( Tomato )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2834:1: Tomato
                    {
                     before(grammarAccess.getColorAccess().getTomatoKeyword_137()); 
                    match(input,Tomato,FOLLOW_Tomato_in_rule__Color__Alternatives6296); 
                     after(grammarAccess.getColorAccess().getTomatoKeyword_137()); 

                    }


                    }
                    break;
                case 139 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2841:6: ( Turquoise )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2841:6: ( Turquoise )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2842:1: Turquoise
                    {
                     before(grammarAccess.getColorAccess().getTurquoiseKeyword_138()); 
                    match(input,Turquoise,FOLLOW_Turquoise_in_rule__Color__Alternatives6316); 
                     after(grammarAccess.getColorAccess().getTurquoiseKeyword_138()); 

                    }


                    }
                    break;
                case 140 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2849:6: ( Violet )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2849:6: ( Violet )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2850:1: Violet
                    {
                     before(grammarAccess.getColorAccess().getVioletKeyword_139()); 
                    match(input,Violet,FOLLOW_Violet_in_rule__Color__Alternatives6336); 
                     after(grammarAccess.getColorAccess().getVioletKeyword_139()); 

                    }


                    }
                    break;
                case 141 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2857:6: ( Wheat )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2857:6: ( Wheat )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2858:1: Wheat
                    {
                     before(grammarAccess.getColorAccess().getWheatKeyword_140()); 
                    match(input,Wheat,FOLLOW_Wheat_in_rule__Color__Alternatives6356); 
                     after(grammarAccess.getColorAccess().getWheatKeyword_140()); 

                    }


                    }
                    break;
                case 142 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2865:6: ( White )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2865:6: ( White )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2866:1: White
                    {
                     before(grammarAccess.getColorAccess().getWhiteKeyword_141()); 
                    match(input,White,FOLLOW_White_in_rule__Color__Alternatives6376); 
                     after(grammarAccess.getColorAccess().getWhiteKeyword_141()); 

                    }


                    }
                    break;
                case 143 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2873:6: ( WhiteSmoke )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2873:6: ( WhiteSmoke )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2874:1: WhiteSmoke
                    {
                     before(grammarAccess.getColorAccess().getWhiteSmokeKeyword_142()); 
                    match(input,WhiteSmoke,FOLLOW_WhiteSmoke_in_rule__Color__Alternatives6396); 
                     after(grammarAccess.getColorAccess().getWhiteSmokeKeyword_142()); 

                    }


                    }
                    break;
                case 144 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2881:6: ( Yellow )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2881:6: ( Yellow )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2882:1: Yellow
                    {
                     before(grammarAccess.getColorAccess().getYellowKeyword_143()); 
                    match(input,Yellow,FOLLOW_Yellow_in_rule__Color__Alternatives6416); 
                     after(grammarAccess.getColorAccess().getYellowKeyword_143()); 

                    }


                    }
                    break;
                case 145 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2889:6: ( YellowGreen )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2889:6: ( YellowGreen )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2890:1: YellowGreen
                    {
                     before(grammarAccess.getColorAccess().getYellowGreenKeyword_144()); 
                    match(input,YellowGreen,FOLLOW_YellowGreen_in_rule__Color__Alternatives6436); 
                     after(grammarAccess.getColorAccess().getYellowGreenKeyword_144()); 

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
    // $ANTLR end "rule__Color__Alternatives"


    // $ANTLR start "rule__Diagram__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2904:1: rule__Diagram__Group__0 : rule__Diagram__Group__0__Impl rule__Diagram__Group__1 ;
    public final void rule__Diagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2908:1: ( rule__Diagram__Group__0__Impl rule__Diagram__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2909:2: rule__Diagram__Group__0__Impl rule__Diagram__Group__1
            {
            pushFollow(FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__06468);
            rule__Diagram__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__06471);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2916:1: rule__Diagram__Group__0__Impl : ( RULE_START ) ;
    public final void rule__Diagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2920:1: ( ( RULE_START ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2921:1: ( RULE_START )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2921:1: ( RULE_START )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2922:1: RULE_START
            {
             before(grammarAccess.getDiagramAccess().getSTARTTerminalRuleCall_0()); 
            match(input,RULE_START,FOLLOW_RULE_START_in_rule__Diagram__Group__0__Impl6498); 
             after(grammarAccess.getDiagramAccess().getSTARTTerminalRuleCall_0()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2933:1: rule__Diagram__Group__1 : rule__Diagram__Group__1__Impl rule__Diagram__Group__2 ;
    public final void rule__Diagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2937:1: ( rule__Diagram__Group__1__Impl rule__Diagram__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2938:2: rule__Diagram__Group__1__Impl rule__Diagram__Group__2
            {
            pushFollow(FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__16527);
            rule__Diagram__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__16530);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2945:1: rule__Diagram__Group__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Diagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2949:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2950:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2950:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2951:1: RULE_NEWLINE
            {
             before(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__1__Impl6557); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2962:1: rule__Diagram__Group__2 : rule__Diagram__Group__2__Impl rule__Diagram__Group__3 ;
    public final void rule__Diagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2966:1: ( rule__Diagram__Group__2__Impl rule__Diagram__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2967:2: rule__Diagram__Group__2__Impl rule__Diagram__Group__3
            {
            pushFollow(FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__26586);
            rule__Diagram__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__3_in_rule__Diagram__Group__26589);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2974:1: rule__Diagram__Group__2__Impl : ( ( rule__Diagram__InstructionsAssignment_2 )* ) ;
    public final void rule__Diagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2978:1: ( ( ( rule__Diagram__InstructionsAssignment_2 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2979:1: ( ( rule__Diagram__InstructionsAssignment_2 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2979:1: ( ( rule__Diagram__InstructionsAssignment_2 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2980:1: ( rule__Diagram__InstructionsAssignment_2 )*
            {
             before(grammarAccess.getDiagramAccess().getInstructionsAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2981:1: ( rule__Diagram__InstructionsAssignment_2 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==Participant||(LA15_0>=Autonumber && LA15_0<=Deactivate)||LA15_0==Endlegend||(LA15_0>=Activate && LA15_0<=Database)||(LA15_0>=Control && LA15_0<=Newpage)||(LA15_0>=Center && LA15_0<=Legend)||(LA15_0>=Actor && LA15_0<=Title)||(LA15_0>=Else && LA15_0<=FullStopFullStopFullStop)||(LA15_0>=Alt && LA15_0<=VerticalLineVerticalLineVerticalLine)||LA15_0==EqualsSignEqualsSign||(LA15_0>=Of && LA15_0<=VerticalLineVerticalLine)||(LA15_0>=NumberSign && LA15_0<=RULE_NEWLINE)||(LA15_0>=RULE_INT && LA15_0<=RULE_ID)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2981:2: rule__Diagram__InstructionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Diagram__InstructionsAssignment_2_in_rule__Diagram__Group__2__Impl6616);
            	    rule__Diagram__InstructionsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2991:1: rule__Diagram__Group__3 : rule__Diagram__Group__3__Impl rule__Diagram__Group__4 ;
    public final void rule__Diagram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2995:1: ( rule__Diagram__Group__3__Impl rule__Diagram__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2996:2: rule__Diagram__Group__3__Impl rule__Diagram__Group__4
            {
            pushFollow(FOLLOW_rule__Diagram__Group__3__Impl_in_rule__Diagram__Group__36647);
            rule__Diagram__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__4_in_rule__Diagram__Group__36650);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3003:1: rule__Diagram__Group__3__Impl : ( RULE_END ) ;
    public final void rule__Diagram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3007:1: ( ( RULE_END ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3008:1: ( RULE_END )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3008:1: ( RULE_END )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3009:1: RULE_END
            {
             before(grammarAccess.getDiagramAccess().getENDTerminalRuleCall_3()); 
            match(input,RULE_END,FOLLOW_RULE_END_in_rule__Diagram__Group__3__Impl6677); 
             after(grammarAccess.getDiagramAccess().getENDTerminalRuleCall_3()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3020:1: rule__Diagram__Group__4 : rule__Diagram__Group__4__Impl ;
    public final void rule__Diagram__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3024:1: ( rule__Diagram__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3025:2: rule__Diagram__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Diagram__Group__4__Impl_in_rule__Diagram__Group__46706);
            rule__Diagram__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3031:1: rule__Diagram__Group__4__Impl : ( ( RULE_NEWLINE )* ) ;
    public final void rule__Diagram__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3035:1: ( ( ( RULE_NEWLINE )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3036:1: ( ( RULE_NEWLINE )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3036:1: ( ( RULE_NEWLINE )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3037:1: ( RULE_NEWLINE )*
            {
             before(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3038:1: ( RULE_NEWLINE )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_NEWLINE) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3038:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__4__Impl6734); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__Instruction__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3058:1: rule__Instruction__Group__0 : rule__Instruction__Group__0__Impl rule__Instruction__Group__1 ;
    public final void rule__Instruction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3062:1: ( rule__Instruction__Group__0__Impl rule__Instruction__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3063:2: rule__Instruction__Group__0__Impl rule__Instruction__Group__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group__0__Impl_in_rule__Instruction__Group__06775);
            rule__Instruction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group__1_in_rule__Instruction__Group__06778);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3070:1: rule__Instruction__Group__0__Impl : ( ( rule__Instruction__Alternatives_0 )? ) ;
    public final void rule__Instruction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3074:1: ( ( ( rule__Instruction__Alternatives_0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3075:1: ( ( rule__Instruction__Alternatives_0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3075:1: ( ( rule__Instruction__Alternatives_0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3076:1: ( rule__Instruction__Alternatives_0 )?
            {
             before(grammarAccess.getInstructionAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3077:1: ( rule__Instruction__Alternatives_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==Participant||(LA17_0>=Autonumber && LA17_0<=Deactivate)||LA17_0==Endlegend||(LA17_0>=Activate && LA17_0<=Database)||(LA17_0>=Control && LA17_0<=Newpage)||(LA17_0>=Center && LA17_0<=Legend)||(LA17_0>=Actor && LA17_0<=Title)||(LA17_0>=Else && LA17_0<=Over)||LA17_0==FullStopFullStopFullStop||(LA17_0>=Alt && LA17_0<=VerticalLineVerticalLineVerticalLine)||LA17_0==EqualsSignEqualsSign||(LA17_0>=Of && LA17_0<=VerticalLineVerticalLine)||(LA17_0>=NumberSign && LA17_0<=GreaterThanSign)||(LA17_0>=RULE_INT && LA17_0<=RULE_ID)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3077:2: rule__Instruction__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Alternatives_0_in_rule__Instruction__Group__0__Impl6805);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3087:1: rule__Instruction__Group__1 : rule__Instruction__Group__1__Impl ;
    public final void rule__Instruction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3091:1: ( rule__Instruction__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3092:2: rule__Instruction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group__1__Impl_in_rule__Instruction__Group__16836);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3098:1: rule__Instruction__Group__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Instruction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3102:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3103:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3103:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3104:1: RULE_NEWLINE
            {
             before(grammarAccess.getInstructionAccess().getNEWLINETerminalRuleCall_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Instruction__Group__1__Impl6863); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3119:1: rule__Instruction__Group_0_1__0 : rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1 ;
    public final void rule__Instruction__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3123:1: ( rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3124:2: rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_1__0__Impl_in_rule__Instruction__Group_0_1__06896);
            rule__Instruction__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_1__1_in_rule__Instruction__Group_0_1__06899);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3131:1: rule__Instruction__Group_0_1__0__Impl : ( ruleDefinition ) ;
    public final void rule__Instruction__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3135:1: ( ( ruleDefinition ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3136:1: ( ruleDefinition )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3136:1: ( ruleDefinition )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3137:1: ruleDefinition
            {
             before(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Instruction__Group_0_1__0__Impl6926);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3148:1: rule__Instruction__Group_0_1__1 : rule__Instruction__Group_0_1__1__Impl ;
    public final void rule__Instruction__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3152:1: ( rule__Instruction__Group_0_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3153:2: rule__Instruction__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_1__1__Impl_in_rule__Instruction__Group_0_1__16955);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3159:1: rule__Instruction__Group_0_1__1__Impl : ( ( ruleColors )? ) ;
    public final void rule__Instruction__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3163:1: ( ( ( ruleColors )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3164:1: ( ( ruleColors )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3164:1: ( ( ruleColors )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3165:1: ( ruleColors )?
            {
             before(grammarAccess.getInstructionAccess().getColorsParserRuleCall_0_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3166:1: ( ruleColors )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==NumberSign) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3166:3: ruleColors
                    {
                    pushFollow(FOLLOW_ruleColors_in_rule__Instruction__Group_0_1__1__Impl6983);
                    ruleColors();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInstructionAccess().getColorsParserRuleCall_0_1_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3180:1: rule__Arrow__Group__0 : rule__Arrow__Group__0__Impl rule__Arrow__Group__1 ;
    public final void rule__Arrow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3184:1: ( rule__Arrow__Group__0__Impl rule__Arrow__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3185:2: rule__Arrow__Group__0__Impl rule__Arrow__Group__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group__0__Impl_in_rule__Arrow__Group__07018);
            rule__Arrow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group__1_in_rule__Arrow__Group__07021);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3192:1: rule__Arrow__Group__0__Impl : ( ( rule__Arrow__NameAssignment_0 ) ) ;
    public final void rule__Arrow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3196:1: ( ( ( rule__Arrow__NameAssignment_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3197:1: ( ( rule__Arrow__NameAssignment_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3197:1: ( ( rule__Arrow__NameAssignment_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3198:1: ( rule__Arrow__NameAssignment_0 )
            {
             before(grammarAccess.getArrowAccess().getNameAssignment_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3199:1: ( rule__Arrow__NameAssignment_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3199:2: rule__Arrow__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Arrow__NameAssignment_0_in_rule__Arrow__Group__0__Impl7048);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3209:1: rule__Arrow__Group__1 : rule__Arrow__Group__1__Impl rule__Arrow__Group__2 ;
    public final void rule__Arrow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3213:1: ( rule__Arrow__Group__1__Impl rule__Arrow__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3214:2: rule__Arrow__Group__1__Impl rule__Arrow__Group__2
            {
            pushFollow(FOLLOW_rule__Arrow__Group__1__Impl_in_rule__Arrow__Group__17078);
            rule__Arrow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group__2_in_rule__Arrow__Group__17081);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3221:1: rule__Arrow__Group__1__Impl : ( RULE_SEQUENCE ) ;
    public final void rule__Arrow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3225:1: ( ( RULE_SEQUENCE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3226:1: ( RULE_SEQUENCE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3226:1: ( RULE_SEQUENCE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3227:1: RULE_SEQUENCE
            {
             before(grammarAccess.getArrowAccess().getSEQUENCETerminalRuleCall_1()); 
            match(input,RULE_SEQUENCE,FOLLOW_RULE_SEQUENCE_in_rule__Arrow__Group__1__Impl7108); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3238:1: rule__Arrow__Group__2 : rule__Arrow__Group__2__Impl rule__Arrow__Group__3 ;
    public final void rule__Arrow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3242:1: ( rule__Arrow__Group__2__Impl rule__Arrow__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3243:2: rule__Arrow__Group__2__Impl rule__Arrow__Group__3
            {
            pushFollow(FOLLOW_rule__Arrow__Group__2__Impl_in_rule__Arrow__Group__27137);
            rule__Arrow__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group__3_in_rule__Arrow__Group__27140);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3250:1: rule__Arrow__Group__2__Impl : ( ( rule__Arrow__NamesAssignment_2 ) ) ;
    public final void rule__Arrow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3254:1: ( ( ( rule__Arrow__NamesAssignment_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3255:1: ( ( rule__Arrow__NamesAssignment_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3255:1: ( ( rule__Arrow__NamesAssignment_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3256:1: ( rule__Arrow__NamesAssignment_2 )
            {
             before(grammarAccess.getArrowAccess().getNamesAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3257:1: ( rule__Arrow__NamesAssignment_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3257:2: rule__Arrow__NamesAssignment_2
            {
            pushFollow(FOLLOW_rule__Arrow__NamesAssignment_2_in_rule__Arrow__Group__2__Impl7167);
            rule__Arrow__NamesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getNamesAssignment_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3267:1: rule__Arrow__Group__3 : rule__Arrow__Group__3__Impl ;
    public final void rule__Arrow__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3271:1: ( rule__Arrow__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3272:2: rule__Arrow__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group__3__Impl_in_rule__Arrow__Group__37197);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3278:1: rule__Arrow__Group__3__Impl : ( ( rule__Arrow__Group_3__0 )? ) ;
    public final void rule__Arrow__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3282:1: ( ( ( rule__Arrow__Group_3__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3283:1: ( ( rule__Arrow__Group_3__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3283:1: ( ( rule__Arrow__Group_3__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3284:1: ( rule__Arrow__Group_3__0 )?
            {
             before(grammarAccess.getArrowAccess().getGroup_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3285:1: ( rule__Arrow__Group_3__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==Colon) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3285:2: rule__Arrow__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Arrow__Group_3__0_in_rule__Arrow__Group__3__Impl7224);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3303:1: rule__Arrow__Group_3__0 : rule__Arrow__Group_3__0__Impl rule__Arrow__Group_3__1 ;
    public final void rule__Arrow__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3307:1: ( rule__Arrow__Group_3__0__Impl rule__Arrow__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3308:2: rule__Arrow__Group_3__0__Impl rule__Arrow__Group_3__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group_3__0__Impl_in_rule__Arrow__Group_3__07263);
            rule__Arrow__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_3__1_in_rule__Arrow__Group_3__07266);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3315:1: rule__Arrow__Group_3__0__Impl : ( Colon ) ;
    public final void rule__Arrow__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3319:1: ( ( Colon ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3320:1: ( Colon )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3320:1: ( Colon )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3321:1: Colon
            {
             before(grammarAccess.getArrowAccess().getColonKeyword_3_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Arrow__Group_3__0__Impl7294); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3334:1: rule__Arrow__Group_3__1 : rule__Arrow__Group_3__1__Impl ;
    public final void rule__Arrow__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3338:1: ( rule__Arrow__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3339:2: rule__Arrow__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group_3__1__Impl_in_rule__Arrow__Group_3__17325);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3345:1: rule__Arrow__Group_3__1__Impl : ( ( ruleMyID )* ) ;
    public final void rule__Arrow__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3349:1: ( ( ( ruleMyID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3350:1: ( ( ruleMyID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3350:1: ( ( ruleMyID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3351:1: ( ruleMyID )*
            {
             before(grammarAccess.getArrowAccess().getMyIDParserRuleCall_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3352:1: ( ruleMyID )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=Autonumber && LA20_0<=Deactivate)||LA20_0==Endlegend||LA20_0==Activate||LA20_0==Critical||(LA20_0>=Destroy && LA20_0<=Newpage)||(LA20_0>=Center && LA20_0<=Create)||LA20_0==Legend||(LA20_0>=Break && LA20_0<=Title)||(LA20_0>=Else && LA20_0<=Over)||(LA20_0>=Alt && LA20_0<=Ref)||LA20_0==Of||(LA20_0>=NumberSign && LA20_0<=GreaterThanSign)||(LA20_0>=RULE_INT && LA20_0<=RULE_ID)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3352:3: ruleMyID
            	    {
            	    pushFollow(FOLLOW_ruleMyID_in_rule__Arrow__Group_3__1__Impl7353);
            	    ruleMyID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getArrowAccess().getMyIDParserRuleCall_3_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3366:1: rule__Definition__Group_0__0 : rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 ;
    public final void rule__Definition__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3370:1: ( rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3371:2: rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__07388);
            rule__Definition__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__07391);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3378:1: rule__Definition__Group_0__0__Impl : ( Actor ) ;
    public final void rule__Definition__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3382:1: ( ( Actor ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3383:1: ( Actor )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3383:1: ( Actor )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3384:1: Actor
            {
             before(grammarAccess.getDefinitionAccess().getActorKeyword_0_0()); 
            match(input,Actor,FOLLOW_Actor_in_rule__Definition__Group_0__0__Impl7419); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3397:1: rule__Definition__Group_0__1 : rule__Definition__Group_0__1__Impl ;
    public final void rule__Definition__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3401:1: ( rule__Definition__Group_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3402:2: rule__Definition__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__17450);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3408:1: rule__Definition__Group_0__1__Impl : ( ( rule__Definition__NameAssignment_0_1 ) ) ;
    public final void rule__Definition__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3412:1: ( ( ( rule__Definition__NameAssignment_0_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3413:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3413:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3414:1: ( rule__Definition__NameAssignment_0_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3415:1: ( rule__Definition__NameAssignment_0_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3415:2: rule__Definition__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl7477);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3429:1: rule__Definition__Group_1__0 : rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 ;
    public final void rule__Definition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3433:1: ( rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3434:2: rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__07511);
            rule__Definition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__07514);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3441:1: rule__Definition__Group_1__0__Impl : ( Boundary ) ;
    public final void rule__Definition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3445:1: ( ( Boundary ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3446:1: ( Boundary )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3446:1: ( Boundary )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3447:1: Boundary
            {
             before(grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0()); 
            match(input,Boundary,FOLLOW_Boundary_in_rule__Definition__Group_1__0__Impl7542); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3460:1: rule__Definition__Group_1__1 : rule__Definition__Group_1__1__Impl ;
    public final void rule__Definition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3464:1: ( rule__Definition__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3465:2: rule__Definition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__17573);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3471:1: rule__Definition__Group_1__1__Impl : ( ( rule__Definition__NameAssignment_1_1 ) ) ;
    public final void rule__Definition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3475:1: ( ( ( rule__Definition__NameAssignment_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3476:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3476:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3477:1: ( rule__Definition__NameAssignment_1_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3478:1: ( rule__Definition__NameAssignment_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3478:2: rule__Definition__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl7600);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3492:1: rule__Definition__Group_2__0 : rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 ;
    public final void rule__Definition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3496:1: ( rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3497:2: rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__07634);
            rule__Definition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__07637);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3504:1: rule__Definition__Group_2__0__Impl : ( Control ) ;
    public final void rule__Definition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3508:1: ( ( Control ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3509:1: ( Control )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3509:1: ( Control )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3510:1: Control
            {
             before(grammarAccess.getDefinitionAccess().getControlKeyword_2_0()); 
            match(input,Control,FOLLOW_Control_in_rule__Definition__Group_2__0__Impl7665); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3523:1: rule__Definition__Group_2__1 : rule__Definition__Group_2__1__Impl ;
    public final void rule__Definition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3527:1: ( rule__Definition__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3528:2: rule__Definition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__17696);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3534:1: rule__Definition__Group_2__1__Impl : ( ( rule__Definition__NameAssignment_2_1 ) ) ;
    public final void rule__Definition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3538:1: ( ( ( rule__Definition__NameAssignment_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3539:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3539:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3540:1: ( rule__Definition__NameAssignment_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3541:1: ( rule__Definition__NameAssignment_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3541:2: rule__Definition__NameAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl7723);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3555:1: rule__Definition__Group_3__0 : rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 ;
    public final void rule__Definition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3559:1: ( rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3560:2: rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__07757);
            rule__Definition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__07760);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3567:1: rule__Definition__Group_3__0__Impl : ( Entity ) ;
    public final void rule__Definition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3571:1: ( ( Entity ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3572:1: ( Entity )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3572:1: ( Entity )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3573:1: Entity
            {
             before(grammarAccess.getDefinitionAccess().getEntityKeyword_3_0()); 
            match(input,Entity,FOLLOW_Entity_in_rule__Definition__Group_3__0__Impl7788); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3586:1: rule__Definition__Group_3__1 : rule__Definition__Group_3__1__Impl ;
    public final void rule__Definition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3590:1: ( rule__Definition__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3591:2: rule__Definition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__17819);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3597:1: rule__Definition__Group_3__1__Impl : ( ( rule__Definition__NameAssignment_3_1 ) ) ;
    public final void rule__Definition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3601:1: ( ( ( rule__Definition__NameAssignment_3_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3602:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3602:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3603:1: ( rule__Definition__NameAssignment_3_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3604:1: ( rule__Definition__NameAssignment_3_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3604:2: rule__Definition__NameAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl7846);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3618:1: rule__Definition__Group_4__0 : rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 ;
    public final void rule__Definition__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3622:1: ( rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3623:2: rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__07880);
            rule__Definition__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__07883);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3630:1: rule__Definition__Group_4__0__Impl : ( Database ) ;
    public final void rule__Definition__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3634:1: ( ( Database ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3635:1: ( Database )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3635:1: ( Database )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3636:1: Database
            {
             before(grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0()); 
            match(input,Database,FOLLOW_Database_in_rule__Definition__Group_4__0__Impl7911); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3649:1: rule__Definition__Group_4__1 : rule__Definition__Group_4__1__Impl ;
    public final void rule__Definition__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3653:1: ( rule__Definition__Group_4__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3654:2: rule__Definition__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__17942);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3660:1: rule__Definition__Group_4__1__Impl : ( ( rule__Definition__NameAssignment_4_1 ) ) ;
    public final void rule__Definition__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3664:1: ( ( ( rule__Definition__NameAssignment_4_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3665:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3665:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3666:1: ( rule__Definition__NameAssignment_4_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_4_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3667:1: ( rule__Definition__NameAssignment_4_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3667:2: rule__Definition__NameAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl7969);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3681:1: rule__Definition__Group_5__0 : rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1 ;
    public final void rule__Definition__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3685:1: ( rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3686:2: rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5__0__Impl_in_rule__Definition__Group_5__08003);
            rule__Definition__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5__1_in_rule__Definition__Group_5__08006);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3693:1: rule__Definition__Group_5__0__Impl : ( Participant ) ;
    public final void rule__Definition__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3697:1: ( ( Participant ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3698:1: ( Participant )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3698:1: ( Participant )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3699:1: Participant
            {
             before(grammarAccess.getDefinitionAccess().getParticipantKeyword_5_0()); 
            match(input,Participant,FOLLOW_Participant_in_rule__Definition__Group_5__0__Impl8034); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3712:1: rule__Definition__Group_5__1 : rule__Definition__Group_5__1__Impl rule__Definition__Group_5__2 ;
    public final void rule__Definition__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3716:1: ( rule__Definition__Group_5__1__Impl rule__Definition__Group_5__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3717:2: rule__Definition__Group_5__1__Impl rule__Definition__Group_5__2
            {
            pushFollow(FOLLOW_rule__Definition__Group_5__1__Impl_in_rule__Definition__Group_5__18065);
            rule__Definition__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5__2_in_rule__Definition__Group_5__18068);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3724:1: rule__Definition__Group_5__1__Impl : ( ( rule__Definition__NameAssignment_5_1 ) ) ;
    public final void rule__Definition__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3728:1: ( ( ( rule__Definition__NameAssignment_5_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3729:1: ( ( rule__Definition__NameAssignment_5_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3729:1: ( ( rule__Definition__NameAssignment_5_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3730:1: ( rule__Definition__NameAssignment_5_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_5_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3731:1: ( rule__Definition__NameAssignment_5_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3731:2: rule__Definition__NameAssignment_5_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_5_1_in_rule__Definition__Group_5__1__Impl8095);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3741:1: rule__Definition__Group_5__2 : rule__Definition__Group_5__2__Impl ;
    public final void rule__Definition__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3745:1: ( rule__Definition__Group_5__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3746:2: rule__Definition__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5__2__Impl_in_rule__Definition__Group_5__28125);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3752:1: rule__Definition__Group_5__2__Impl : ( ( rule__Definition__Group_5_2__0 )? ) ;
    public final void rule__Definition__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3756:1: ( ( ( rule__Definition__Group_5_2__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3757:1: ( ( rule__Definition__Group_5_2__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3757:1: ( ( rule__Definition__Group_5_2__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3758:1: ( rule__Definition__Group_5_2__0 )?
            {
             before(grammarAccess.getDefinitionAccess().getGroup_5_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3759:1: ( rule__Definition__Group_5_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==LessThanSignLessThanSign) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3759:2: rule__Definition__Group_5_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5_2__0_in_rule__Definition__Group_5__2__Impl8152);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3775:1: rule__Definition__Group_5_2__0 : rule__Definition__Group_5_2__0__Impl rule__Definition__Group_5_2__1 ;
    public final void rule__Definition__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3779:1: ( rule__Definition__Group_5_2__0__Impl rule__Definition__Group_5_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3780:2: rule__Definition__Group_5_2__0__Impl rule__Definition__Group_5_2__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2__0__Impl_in_rule__Definition__Group_5_2__08189);
            rule__Definition__Group_5_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2__1_in_rule__Definition__Group_5_2__08192);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3787:1: rule__Definition__Group_5_2__0__Impl : ( LessThanSignLessThanSign ) ;
    public final void rule__Definition__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3791:1: ( ( LessThanSignLessThanSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3792:1: ( LessThanSignLessThanSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3792:1: ( LessThanSignLessThanSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3793:1: LessThanSignLessThanSign
            {
             before(grammarAccess.getDefinitionAccess().getLessThanSignLessThanSignKeyword_5_2_0()); 
            match(input,LessThanSignLessThanSign,FOLLOW_LessThanSignLessThanSign_in_rule__Definition__Group_5_2__0__Impl8220); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3806:1: rule__Definition__Group_5_2__1 : rule__Definition__Group_5_2__1__Impl rule__Definition__Group_5_2__2 ;
    public final void rule__Definition__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3810:1: ( rule__Definition__Group_5_2__1__Impl rule__Definition__Group_5_2__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3811:2: rule__Definition__Group_5_2__1__Impl rule__Definition__Group_5_2__2
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2__1__Impl_in_rule__Definition__Group_5_2__18251);
            rule__Definition__Group_5_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2__2_in_rule__Definition__Group_5_2__18254);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3818:1: rule__Definition__Group_5_2__1__Impl : ( ( rule__Definition__Group_5_2_1__0 )? ) ;
    public final void rule__Definition__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3822:1: ( ( ( rule__Definition__Group_5_2_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3823:1: ( ( rule__Definition__Group_5_2_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3823:1: ( ( rule__Definition__Group_5_2_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3824:1: ( rule__Definition__Group_5_2_1__0 )?
            {
             before(grammarAccess.getDefinitionAccess().getGroup_5_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3825:1: ( rule__Definition__Group_5_2_1__0 )?
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3825:2: rule__Definition__Group_5_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5_2_1__0_in_rule__Definition__Group_5_2__1__Impl8281);
                    rule__Definition__Group_5_2_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDefinitionAccess().getGroup_5_2_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3835:1: rule__Definition__Group_5_2__2 : rule__Definition__Group_5_2__2__Impl rule__Definition__Group_5_2__3 ;
    public final void rule__Definition__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3839:1: ( rule__Definition__Group_5_2__2__Impl rule__Definition__Group_5_2__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3840:2: rule__Definition__Group_5_2__2__Impl rule__Definition__Group_5_2__3
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2__2__Impl_in_rule__Definition__Group_5_2__28312);
            rule__Definition__Group_5_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2__3_in_rule__Definition__Group_5_2__28315);
            rule__Definition__Group_5_2__3();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3847:1: rule__Definition__Group_5_2__2__Impl : ( ( ruleEndID )* ) ;
    public final void rule__Definition__Group_5_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3851:1: ( ( ( ruleEndID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3852:1: ( ( ruleEndID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3852:1: ( ( ruleEndID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3853:1: ( ruleEndID )*
            {
             before(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3854:1: ( ruleEndID )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=Autonumber && LA23_0<=Deactivate)||LA23_0==Endlegend||LA23_0==Activate||LA23_0==Critical||(LA23_0>=Destroy && LA23_0<=Newpage)||(LA23_0>=Center && LA23_0<=Create)||LA23_0==Legend||(LA23_0>=Break && LA23_0<=Title)||(LA23_0>=Else && LA23_0<=Over)||(LA23_0>=Alt && LA23_0<=Box)||(LA23_0>=Opt && LA23_0<=Ref)||LA23_0==Of||(LA23_0>=NumberSign && LA23_0<=GreaterThanSign)||(LA23_0>=RULE_INT && LA23_0<=RULE_ID)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3854:3: ruleEndID
            	    {
            	    pushFollow(FOLLOW_ruleEndID_in_rule__Definition__Group_5_2__2__Impl8343);
            	    ruleEndID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__Definition__Group_5_2__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3864:1: rule__Definition__Group_5_2__3 : rule__Definition__Group_5_2__3__Impl ;
    public final void rule__Definition__Group_5_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3868:1: ( rule__Definition__Group_5_2__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3869:2: rule__Definition__Group_5_2__3__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2__3__Impl_in_rule__Definition__Group_5_2__38374);
            rule__Definition__Group_5_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__3"


    // $ANTLR start "rule__Definition__Group_5_2__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3875:1: rule__Definition__Group_5_2__3__Impl : ( GreaterThanSignGreaterThanSign ) ;
    public final void rule__Definition__Group_5_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3879:1: ( ( GreaterThanSignGreaterThanSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3880:1: ( GreaterThanSignGreaterThanSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3880:1: ( GreaterThanSignGreaterThanSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3881:1: GreaterThanSignGreaterThanSign
            {
             before(grammarAccess.getDefinitionAccess().getGreaterThanSignGreaterThanSignKeyword_5_2_3()); 
            match(input,GreaterThanSignGreaterThanSign,FOLLOW_GreaterThanSignGreaterThanSign_in_rule__Definition__Group_5_2__3__Impl8402); 
             after(grammarAccess.getDefinitionAccess().getGreaterThanSignGreaterThanSignKeyword_5_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__3__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3902:1: rule__Definition__Group_5_2_1__0 : rule__Definition__Group_5_2_1__0__Impl rule__Definition__Group_5_2_1__1 ;
    public final void rule__Definition__Group_5_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3906:1: ( rule__Definition__Group_5_2_1__0__Impl rule__Definition__Group_5_2_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3907:2: rule__Definition__Group_5_2_1__0__Impl rule__Definition__Group_5_2_1__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__0__Impl_in_rule__Definition__Group_5_2_1__08441);
            rule__Definition__Group_5_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__1_in_rule__Definition__Group_5_2_1__08444);
            rule__Definition__Group_5_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__0"


    // $ANTLR start "rule__Definition__Group_5_2_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3914:1: rule__Definition__Group_5_2_1__0__Impl : ( LeftParenthesis ) ;
    public final void rule__Definition__Group_5_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3918:1: ( ( LeftParenthesis ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3919:1: ( LeftParenthesis )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3919:1: ( LeftParenthesis )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3920:1: LeftParenthesis
            {
             before(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_0()); 
            match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_rule__Definition__Group_5_2_1__0__Impl8472); 
             after(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__0__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3933:1: rule__Definition__Group_5_2_1__1 : rule__Definition__Group_5_2_1__1__Impl rule__Definition__Group_5_2_1__2 ;
    public final void rule__Definition__Group_5_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3937:1: ( rule__Definition__Group_5_2_1__1__Impl rule__Definition__Group_5_2_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3938:2: rule__Definition__Group_5_2_1__1__Impl rule__Definition__Group_5_2_1__2
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__1__Impl_in_rule__Definition__Group_5_2_1__18503);
            rule__Definition__Group_5_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__2_in_rule__Definition__Group_5_2_1__18506);
            rule__Definition__Group_5_2_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__1"


    // $ANTLR start "rule__Definition__Group_5_2_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3945:1: rule__Definition__Group_5_2_1__1__Impl : ( ruleEndID ) ;
    public final void rule__Definition__Group_5_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3949:1: ( ( ruleEndID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3950:1: ( ruleEndID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3950:1: ( ruleEndID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3951:1: ruleEndID
            {
             before(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_1_1()); 
            pushFollow(FOLLOW_ruleEndID_in_rule__Definition__Group_5_2_1__1__Impl8533);
            ruleEndID();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__1__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3962:1: rule__Definition__Group_5_2_1__2 : rule__Definition__Group_5_2_1__2__Impl rule__Definition__Group_5_2_1__3 ;
    public final void rule__Definition__Group_5_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3966:1: ( rule__Definition__Group_5_2_1__2__Impl rule__Definition__Group_5_2_1__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3967:2: rule__Definition__Group_5_2_1__2__Impl rule__Definition__Group_5_2_1__3
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__2__Impl_in_rule__Definition__Group_5_2_1__28562);
            rule__Definition__Group_5_2_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__3_in_rule__Definition__Group_5_2_1__28565);
            rule__Definition__Group_5_2_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__2"


    // $ANTLR start "rule__Definition__Group_5_2_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3974:1: rule__Definition__Group_5_2_1__2__Impl : ( Comma ) ;
    public final void rule__Definition__Group_5_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3978:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3979:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3979:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3980:1: Comma
            {
             before(grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_2()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Definition__Group_5_2_1__2__Impl8593); 
             after(grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__2__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3993:1: rule__Definition__Group_5_2_1__3 : rule__Definition__Group_5_2_1__3__Impl rule__Definition__Group_5_2_1__4 ;
    public final void rule__Definition__Group_5_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3997:1: ( rule__Definition__Group_5_2_1__3__Impl rule__Definition__Group_5_2_1__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3998:2: rule__Definition__Group_5_2_1__3__Impl rule__Definition__Group_5_2_1__4
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__3__Impl_in_rule__Definition__Group_5_2_1__38624);
            rule__Definition__Group_5_2_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__4_in_rule__Definition__Group_5_2_1__38627);
            rule__Definition__Group_5_2_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__3"


    // $ANTLR start "rule__Definition__Group_5_2_1__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4005:1: rule__Definition__Group_5_2_1__3__Impl : ( NumberSign ) ;
    public final void rule__Definition__Group_5_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4009:1: ( ( NumberSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4010:1: ( NumberSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4010:1: ( NumberSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4011:1: NumberSign
            {
             before(grammarAccess.getDefinitionAccess().getNumberSignKeyword_5_2_1_3()); 
            match(input,NumberSign,FOLLOW_NumberSign_in_rule__Definition__Group_5_2_1__3__Impl8655); 
             after(grammarAccess.getDefinitionAccess().getNumberSignKeyword_5_2_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__3__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4024:1: rule__Definition__Group_5_2_1__4 : rule__Definition__Group_5_2_1__4__Impl rule__Definition__Group_5_2_1__5 ;
    public final void rule__Definition__Group_5_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4028:1: ( rule__Definition__Group_5_2_1__4__Impl rule__Definition__Group_5_2_1__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4029:2: rule__Definition__Group_5_2_1__4__Impl rule__Definition__Group_5_2_1__5
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__4__Impl_in_rule__Definition__Group_5_2_1__48686);
            rule__Definition__Group_5_2_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__5_in_rule__Definition__Group_5_2_1__48689);
            rule__Definition__Group_5_2_1__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__4"


    // $ANTLR start "rule__Definition__Group_5_2_1__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4036:1: rule__Definition__Group_5_2_1__4__Impl : ( RULE_HEXCODE ) ;
    public final void rule__Definition__Group_5_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4040:1: ( ( RULE_HEXCODE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4041:1: ( RULE_HEXCODE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4041:1: ( RULE_HEXCODE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4042:1: RULE_HEXCODE
            {
             before(grammarAccess.getDefinitionAccess().getHEXCODETerminalRuleCall_5_2_1_4()); 
            match(input,RULE_HEXCODE,FOLLOW_RULE_HEXCODE_in_rule__Definition__Group_5_2_1__4__Impl8716); 
             after(grammarAccess.getDefinitionAccess().getHEXCODETerminalRuleCall_5_2_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__4__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1__5"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4053:1: rule__Definition__Group_5_2_1__5 : rule__Definition__Group_5_2_1__5__Impl ;
    public final void rule__Definition__Group_5_2_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4057:1: ( rule__Definition__Group_5_2_1__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4058:2: rule__Definition__Group_5_2_1__5__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__5__Impl_in_rule__Definition__Group_5_2_1__58745);
            rule__Definition__Group_5_2_1__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__5"


    // $ANTLR start "rule__Definition__Group_5_2_1__5__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4064:1: rule__Definition__Group_5_2_1__5__Impl : ( RightParenthesis ) ;
    public final void rule__Definition__Group_5_2_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4068:1: ( ( RightParenthesis ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4069:1: ( RightParenthesis )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4069:1: ( RightParenthesis )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4070:1: RightParenthesis
            {
             before(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_5()); 
            match(input,RightParenthesis,FOLLOW_RightParenthesis_in_rule__Definition__Group_5_2_1__5__Impl8773); 
             after(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__5__Impl"


    // $ANTLR start "rule__AutoNumber__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4095:1: rule__AutoNumber__Group__0 : rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 ;
    public final void rule__AutoNumber__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4099:1: ( rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4100:2: rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__08816);
            rule__AutoNumber__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__08819);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4107:1: rule__AutoNumber__Group__0__Impl : ( Autonumber ) ;
    public final void rule__AutoNumber__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4111:1: ( ( Autonumber ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4112:1: ( Autonumber )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4112:1: ( Autonumber )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4113:1: Autonumber
            {
             before(grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
            match(input,Autonumber,FOLLOW_Autonumber_in_rule__AutoNumber__Group__0__Impl8847); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4126:1: rule__AutoNumber__Group__1 : rule__AutoNumber__Group__1__Impl ;
    public final void rule__AutoNumber__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4130:1: ( rule__AutoNumber__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4131:2: rule__AutoNumber__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__18878);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4137:1: rule__AutoNumber__Group__1__Impl : ( ( rule__AutoNumber__Group_1__0 )? ) ;
    public final void rule__AutoNumber__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4141:1: ( ( ( rule__AutoNumber__Group_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4142:1: ( ( rule__AutoNumber__Group_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4142:1: ( ( rule__AutoNumber__Group_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4143:1: ( rule__AutoNumber__Group_1__0 )?
            {
             before(grammarAccess.getAutoNumberAccess().getGroup_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4144:1: ( rule__AutoNumber__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_INT) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4144:2: rule__AutoNumber__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl8905);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4158:1: rule__AutoNumber__Group_1__0 : rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 ;
    public final void rule__AutoNumber__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4162:1: ( rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4163:2: rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__08940);
            rule__AutoNumber__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__08943);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4170:1: rule__AutoNumber__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__AutoNumber__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4174:1: ( ( RULE_INT ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4175:1: ( RULE_INT )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4175:1: ( RULE_INT )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4176:1: RULE_INT
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl8970); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4187:1: rule__AutoNumber__Group_1__1 : rule__AutoNumber__Group_1__1__Impl ;
    public final void rule__AutoNumber__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4191:1: ( rule__AutoNumber__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4192:2: rule__AutoNumber__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__18999);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4198:1: rule__AutoNumber__Group_1__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__AutoNumber__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4202:1: ( ( ( RULE_INT )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4203:1: ( ( RULE_INT )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4203:1: ( ( RULE_INT )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4204:1: ( RULE_INT )?
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4205:1: ( RULE_INT )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_INT) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4205:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl9027); 

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


    // $ANTLR start "rule__Title__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4219:1: rule__Title__Group__0 : rule__Title__Group__0__Impl rule__Title__Group__1 ;
    public final void rule__Title__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4223:1: ( rule__Title__Group__0__Impl rule__Title__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4224:2: rule__Title__Group__0__Impl rule__Title__Group__1
            {
            pushFollow(FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__09062);
            rule__Title__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Title__Group__1_in_rule__Title__Group__09065);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4231:1: rule__Title__Group__0__Impl : ( Title ) ;
    public final void rule__Title__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4235:1: ( ( Title ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4236:1: ( Title )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4236:1: ( Title )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4237:1: Title
            {
             before(grammarAccess.getTitleAccess().getTitleKeyword_0()); 
            match(input,Title,FOLLOW_Title_in_rule__Title__Group__0__Impl9093); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4250:1: rule__Title__Group__1 : rule__Title__Group__1__Impl ;
    public final void rule__Title__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4254:1: ( rule__Title__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4255:2: rule__Title__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__19124);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4261:1: rule__Title__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Title__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4265:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4266:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4266:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4267:1: ( RULE_ID )*
            {
             before(grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4268:1: ( RULE_ID )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4268:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl9152); 

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4282:1: rule__Legend__Group__0 : rule__Legend__Group__0__Impl rule__Legend__Group__1 ;
    public final void rule__Legend__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4286:1: ( rule__Legend__Group__0__Impl rule__Legend__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4287:2: rule__Legend__Group__0__Impl rule__Legend__Group__1
            {
            pushFollow(FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__09187);
            rule__Legend__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__09190);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4294:1: rule__Legend__Group__0__Impl : ( Legend ) ;
    public final void rule__Legend__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4298:1: ( ( Legend ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4299:1: ( Legend )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4299:1: ( Legend )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4300:1: Legend
            {
             before(grammarAccess.getLegendAccess().getLegendKeyword_0()); 
            match(input,Legend,FOLLOW_Legend_in_rule__Legend__Group__0__Impl9218); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4313:1: rule__Legend__Group__1 : rule__Legend__Group__1__Impl rule__Legend__Group__2 ;
    public final void rule__Legend__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4317:1: ( rule__Legend__Group__1__Impl rule__Legend__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4318:2: rule__Legend__Group__1__Impl rule__Legend__Group__2
            {
            pushFollow(FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__19249);
            rule__Legend__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__19252);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4325:1: rule__Legend__Group__1__Impl : ( ( rule__Legend__Alternatives_1 )? ) ;
    public final void rule__Legend__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4329:1: ( ( ( rule__Legend__Alternatives_1 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4330:1: ( ( rule__Legend__Alternatives_1 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4330:1: ( ( rule__Legend__Alternatives_1 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4331:1: ( rule__Legend__Alternatives_1 )?
            {
             before(grammarAccess.getLegendAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4332:1: ( rule__Legend__Alternatives_1 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==Center||LA27_0==Right||LA27_0==Left) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4332:2: rule__Legend__Alternatives_1
                    {
                    pushFollow(FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl9279);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4342:1: rule__Legend__Group__2 : rule__Legend__Group__2__Impl rule__Legend__Group__3 ;
    public final void rule__Legend__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4346:1: ( rule__Legend__Group__2__Impl rule__Legend__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4347:2: rule__Legend__Group__2__Impl rule__Legend__Group__3
            {
            pushFollow(FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__29310);
            rule__Legend__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__29313);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4354:1: rule__Legend__Group__2__Impl : ( ( rule__Legend__Group_2__0 )* ) ;
    public final void rule__Legend__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4358:1: ( ( ( rule__Legend__Group_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4359:1: ( ( rule__Legend__Group_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4359:1: ( ( rule__Legend__Group_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4360:1: ( rule__Legend__Group_2__0 )*
            {
             before(grammarAccess.getLegendAccess().getGroup_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4361:1: ( rule__Legend__Group_2__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_NEWLINE) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4361:2: rule__Legend__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Legend__Group_2__0_in_rule__Legend__Group__2__Impl9340);
            	    rule__Legend__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4371:1: rule__Legend__Group__3 : rule__Legend__Group__3__Impl ;
    public final void rule__Legend__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4375:1: ( rule__Legend__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4376:2: rule__Legend__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__39371);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4382:1: rule__Legend__Group__3__Impl : ( Endlegend ) ;
    public final void rule__Legend__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4386:1: ( ( Endlegend ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4387:1: ( Endlegend )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4387:1: ( Endlegend )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4388:1: Endlegend
            {
             before(grammarAccess.getLegendAccess().getEndlegendKeyword_3()); 
            match(input,Endlegend,FOLLOW_Endlegend_in_rule__Legend__Group__3__Impl9399); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4409:1: rule__Legend__Group_2__0 : rule__Legend__Group_2__0__Impl rule__Legend__Group_2__1 ;
    public final void rule__Legend__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4413:1: ( rule__Legend__Group_2__0__Impl rule__Legend__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4414:2: rule__Legend__Group_2__0__Impl rule__Legend__Group_2__1
            {
            pushFollow(FOLLOW_rule__Legend__Group_2__0__Impl_in_rule__Legend__Group_2__09438);
            rule__Legend__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group_2__1_in_rule__Legend__Group_2__09441);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4421:1: rule__Legend__Group_2__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Legend__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4425:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4426:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4426:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4427:1: RULE_NEWLINE
            {
             before(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Legend__Group_2__0__Impl9468); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4438:1: rule__Legend__Group_2__1 : rule__Legend__Group_2__1__Impl ;
    public final void rule__Legend__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4442:1: ( rule__Legend__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4443:2: rule__Legend__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group_2__1__Impl_in_rule__Legend__Group_2__19497);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4449:1: rule__Legend__Group_2__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Legend__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4453:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4454:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4454:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4455:1: ( RULE_ID )*
            {
             before(grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4456:1: ( RULE_ID )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4456:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Legend__Group_2__1__Impl9525); 

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4470:1: rule__Newpage__Group__0 : rule__Newpage__Group__0__Impl rule__Newpage__Group__1 ;
    public final void rule__Newpage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4474:1: ( rule__Newpage__Group__0__Impl rule__Newpage__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4475:2: rule__Newpage__Group__0__Impl rule__Newpage__Group__1
            {
            pushFollow(FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__09560);
            rule__Newpage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__09563);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4482:1: rule__Newpage__Group__0__Impl : ( Newpage ) ;
    public final void rule__Newpage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4486:1: ( ( Newpage ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4487:1: ( Newpage )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4487:1: ( Newpage )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4488:1: Newpage
            {
             before(grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
            match(input,Newpage,FOLLOW_Newpage_in_rule__Newpage__Group__0__Impl9591); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4501:1: rule__Newpage__Group__1 : rule__Newpage__Group__1__Impl ;
    public final void rule__Newpage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4505:1: ( rule__Newpage__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4506:2: rule__Newpage__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__19622);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4512:1: rule__Newpage__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Newpage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4516:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4517:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4517:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4518:1: ( RULE_ID )*
            {
             before(grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4519:1: ( RULE_ID )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4519:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl9650); 

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4533:1: rule__AltElse__Group__0 : rule__AltElse__Group__0__Impl rule__AltElse__Group__1 ;
    public final void rule__AltElse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4537:1: ( rule__AltElse__Group__0__Impl rule__AltElse__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4538:2: rule__AltElse__Group__0__Impl rule__AltElse__Group__1
            {
            pushFollow(FOLLOW_rule__AltElse__Group__0__Impl_in_rule__AltElse__Group__09685);
            rule__AltElse__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__1_in_rule__AltElse__Group__09688);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4545:1: rule__AltElse__Group__0__Impl : ( Alt ) ;
    public final void rule__AltElse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4549:1: ( ( Alt ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4550:1: ( Alt )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4550:1: ( Alt )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4551:1: Alt
            {
             before(grammarAccess.getAltElseAccess().getAltKeyword_0()); 
            match(input,Alt,FOLLOW_Alt_in_rule__AltElse__Group__0__Impl9716); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4564:1: rule__AltElse__Group__1 : rule__AltElse__Group__1__Impl rule__AltElse__Group__2 ;
    public final void rule__AltElse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4568:1: ( rule__AltElse__Group__1__Impl rule__AltElse__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4569:2: rule__AltElse__Group__1__Impl rule__AltElse__Group__2
            {
            pushFollow(FOLLOW_rule__AltElse__Group__1__Impl_in_rule__AltElse__Group__19747);
            rule__AltElse__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__2_in_rule__AltElse__Group__19750);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4576:1: rule__AltElse__Group__1__Impl : ( ( ruleMyID )* ) ;
    public final void rule__AltElse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4580:1: ( ( ( ruleMyID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4581:1: ( ( ruleMyID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4581:1: ( ( ruleMyID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4582:1: ( ruleMyID )*
            {
             before(grammarAccess.getAltElseAccess().getMyIDParserRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4583:1: ( ruleMyID )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=Autonumber && LA31_0<=Deactivate)||LA31_0==Endlegend||LA31_0==Activate||LA31_0==Critical||(LA31_0>=Destroy && LA31_0<=Newpage)||(LA31_0>=Center && LA31_0<=Create)||LA31_0==Legend||(LA31_0>=Break && LA31_0<=Title)||(LA31_0>=Else && LA31_0<=Over)||(LA31_0>=Alt && LA31_0<=Ref)||LA31_0==Of||(LA31_0>=NumberSign && LA31_0<=GreaterThanSign)||(LA31_0>=RULE_INT && LA31_0<=RULE_ID)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4583:3: ruleMyID
            	    {
            	    pushFollow(FOLLOW_ruleMyID_in_rule__AltElse__Group__1__Impl9778);
            	    ruleMyID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getAltElseAccess().getMyIDParserRuleCall_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4593:1: rule__AltElse__Group__2 : rule__AltElse__Group__2__Impl rule__AltElse__Group__3 ;
    public final void rule__AltElse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4597:1: ( rule__AltElse__Group__2__Impl rule__AltElse__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4598:2: rule__AltElse__Group__2__Impl rule__AltElse__Group__3
            {
            pushFollow(FOLLOW_rule__AltElse__Group__2__Impl_in_rule__AltElse__Group__29809);
            rule__AltElse__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__3_in_rule__AltElse__Group__29812);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4605:1: rule__AltElse__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__AltElse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4609:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4610:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4610:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4611:1: RULE_NEWLINE
            {
             before(grammarAccess.getAltElseAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__AltElse__Group__2__Impl9839); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4622:1: rule__AltElse__Group__3 : rule__AltElse__Group__3__Impl rule__AltElse__Group__4 ;
    public final void rule__AltElse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4626:1: ( rule__AltElse__Group__3__Impl rule__AltElse__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4627:2: rule__AltElse__Group__3__Impl rule__AltElse__Group__4
            {
            pushFollow(FOLLOW_rule__AltElse__Group__3__Impl_in_rule__AltElse__Group__39868);
            rule__AltElse__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__4_in_rule__AltElse__Group__39871);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4634:1: rule__AltElse__Group__3__Impl : ( ( rule__AltElse__InstructionsAssignment_3 )* ) ;
    public final void rule__AltElse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4638:1: ( ( ( rule__AltElse__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4639:1: ( ( rule__AltElse__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4639:1: ( ( rule__AltElse__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4640:1: ( rule__AltElse__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getAltElseAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4641:1: ( rule__AltElse__InstructionsAssignment_3 )*
            loop32:
            do {
                int alt32=2;
                switch ( input.LA(1) ) {
                case Else:
                    {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==RULE_SEQUENCE) ) {
                        alt32=1;
                    }


                    }
                    break;
                case End:
                    {
                    int LA32_2 = input.LA(2);

                    if ( (LA32_2==RULE_SEQUENCE) ) {
                        alt32=1;
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
                    alt32=1;
                    }
                    break;

                }

                switch (alt32) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4641:2: rule__AltElse__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__AltElse__InstructionsAssignment_3_in_rule__AltElse__Group__3__Impl9898);
            	    rule__AltElse__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4651:1: rule__AltElse__Group__4 : rule__AltElse__Group__4__Impl rule__AltElse__Group__5 ;
    public final void rule__AltElse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4655:1: ( rule__AltElse__Group__4__Impl rule__AltElse__Group__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4656:2: rule__AltElse__Group__4__Impl rule__AltElse__Group__5
            {
            pushFollow(FOLLOW_rule__AltElse__Group__4__Impl_in_rule__AltElse__Group__49929);
            rule__AltElse__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__5_in_rule__AltElse__Group__49932);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4663:1: rule__AltElse__Group__4__Impl : ( ( rule__AltElse__ElsesAssignment_4 )* ) ;
    public final void rule__AltElse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4667:1: ( ( ( rule__AltElse__ElsesAssignment_4 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4668:1: ( ( rule__AltElse__ElsesAssignment_4 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4668:1: ( ( rule__AltElse__ElsesAssignment_4 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4669:1: ( rule__AltElse__ElsesAssignment_4 )*
            {
             before(grammarAccess.getAltElseAccess().getElsesAssignment_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4670:1: ( rule__AltElse__ElsesAssignment_4 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==Else) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4670:2: rule__AltElse__ElsesAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__AltElse__ElsesAssignment_4_in_rule__AltElse__Group__4__Impl9959);
            	    rule__AltElse__ElsesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4680:1: rule__AltElse__Group__5 : rule__AltElse__Group__5__Impl ;
    public final void rule__AltElse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4684:1: ( rule__AltElse__Group__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4685:2: rule__AltElse__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__AltElse__Group__5__Impl_in_rule__AltElse__Group__59990);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4691:1: rule__AltElse__Group__5__Impl : ( End ) ;
    public final void rule__AltElse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4695:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4696:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4696:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4697:1: End
            {
             before(grammarAccess.getAltElseAccess().getEndKeyword_5()); 
            match(input,End,FOLLOW_End_in_rule__AltElse__Group__5__Impl10018); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4722:1: rule__Else__Group__0 : rule__Else__Group__0__Impl rule__Else__Group__1 ;
    public final void rule__Else__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4726:1: ( rule__Else__Group__0__Impl rule__Else__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4727:2: rule__Else__Group__0__Impl rule__Else__Group__1
            {
            pushFollow(FOLLOW_rule__Else__Group__0__Impl_in_rule__Else__Group__010061);
            rule__Else__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__1_in_rule__Else__Group__010064);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4734:1: rule__Else__Group__0__Impl : ( Else ) ;
    public final void rule__Else__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4738:1: ( ( Else ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4739:1: ( Else )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4739:1: ( Else )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4740:1: Else
            {
             before(grammarAccess.getElseAccess().getElseKeyword_0()); 
            match(input,Else,FOLLOW_Else_in_rule__Else__Group__0__Impl10092); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4753:1: rule__Else__Group__1 : rule__Else__Group__1__Impl rule__Else__Group__2 ;
    public final void rule__Else__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4757:1: ( rule__Else__Group__1__Impl rule__Else__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4758:2: rule__Else__Group__1__Impl rule__Else__Group__2
            {
            pushFollow(FOLLOW_rule__Else__Group__1__Impl_in_rule__Else__Group__110123);
            rule__Else__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__2_in_rule__Else__Group__110126);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4765:1: rule__Else__Group__1__Impl : ( ( ruleMyID )* ) ;
    public final void rule__Else__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4769:1: ( ( ( ruleMyID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4770:1: ( ( ruleMyID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4770:1: ( ( ruleMyID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4771:1: ( ruleMyID )*
            {
             before(grammarAccess.getElseAccess().getMyIDParserRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4772:1: ( ruleMyID )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=Autonumber && LA34_0<=Deactivate)||LA34_0==Endlegend||LA34_0==Activate||LA34_0==Critical||(LA34_0>=Destroy && LA34_0<=Newpage)||(LA34_0>=Center && LA34_0<=Create)||LA34_0==Legend||(LA34_0>=Break && LA34_0<=Title)||(LA34_0>=Else && LA34_0<=Over)||(LA34_0>=Alt && LA34_0<=Ref)||LA34_0==Of||(LA34_0>=NumberSign && LA34_0<=GreaterThanSign)||(LA34_0>=RULE_INT && LA34_0<=RULE_ID)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4772:3: ruleMyID
            	    {
            	    pushFollow(FOLLOW_ruleMyID_in_rule__Else__Group__1__Impl10154);
            	    ruleMyID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getElseAccess().getMyIDParserRuleCall_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4782:1: rule__Else__Group__2 : rule__Else__Group__2__Impl rule__Else__Group__3 ;
    public final void rule__Else__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4786:1: ( rule__Else__Group__2__Impl rule__Else__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4787:2: rule__Else__Group__2__Impl rule__Else__Group__3
            {
            pushFollow(FOLLOW_rule__Else__Group__2__Impl_in_rule__Else__Group__210185);
            rule__Else__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__3_in_rule__Else__Group__210188);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4794:1: rule__Else__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Else__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4798:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4799:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4799:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4800:1: RULE_NEWLINE
            {
             before(grammarAccess.getElseAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Else__Group__2__Impl10215); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4811:1: rule__Else__Group__3 : rule__Else__Group__3__Impl ;
    public final void rule__Else__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4815:1: ( rule__Else__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4816:2: rule__Else__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Else__Group__3__Impl_in_rule__Else__Group__310244);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4822:1: rule__Else__Group__3__Impl : ( ( rule__Else__InstructionsAssignment_3 )* ) ;
    public final void rule__Else__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4826:1: ( ( ( rule__Else__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4827:1: ( ( rule__Else__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4827:1: ( ( rule__Else__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4828:1: ( rule__Else__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getElseAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4829:1: ( rule__Else__InstructionsAssignment_3 )*
            loop35:
            do {
                int alt35=2;
                switch ( input.LA(1) ) {
                case End:
                    {
                    int LA35_2 = input.LA(2);

                    if ( (LA35_2==RULE_SEQUENCE) ) {
                        alt35=1;
                    }


                    }
                    break;
                case Else:
                    {
                    int LA35_3 = input.LA(2);

                    if ( (LA35_3==RULE_SEQUENCE) ) {
                        alt35=1;
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
                    alt35=1;
                    }
                    break;

                }

                switch (alt35) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4829:2: rule__Else__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Else__InstructionsAssignment_3_in_rule__Else__Group__3__Impl10271);
            	    rule__Else__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4847:1: rule__GroupingMessages__Group__0 : rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1 ;
    public final void rule__GroupingMessages__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4851:1: ( rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4852:2: rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__0__Impl_in_rule__GroupingMessages__Group__010310);
            rule__GroupingMessages__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__1_in_rule__GroupingMessages__Group__010313);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4859:1: rule__GroupingMessages__Group__0__Impl : ( ( rule__GroupingMessages__Alternatives_0 ) ) ;
    public final void rule__GroupingMessages__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4863:1: ( ( ( rule__GroupingMessages__Alternatives_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4864:1: ( ( rule__GroupingMessages__Alternatives_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4864:1: ( ( rule__GroupingMessages__Alternatives_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4865:1: ( rule__GroupingMessages__Alternatives_0 )
            {
             before(grammarAccess.getGroupingMessagesAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4866:1: ( rule__GroupingMessages__Alternatives_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4866:2: rule__GroupingMessages__Alternatives_0
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Alternatives_0_in_rule__GroupingMessages__Group__0__Impl10340);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4876:1: rule__GroupingMessages__Group__1 : rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2 ;
    public final void rule__GroupingMessages__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4880:1: ( rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4881:2: rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__1__Impl_in_rule__GroupingMessages__Group__110370);
            rule__GroupingMessages__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__2_in_rule__GroupingMessages__Group__110373);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4888:1: rule__GroupingMessages__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__GroupingMessages__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4892:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4893:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4893:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4894:1: ( RULE_ID )*
            {
             before(grammarAccess.getGroupingMessagesAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4895:1: ( RULE_ID )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4895:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__GroupingMessages__Group__1__Impl10401); 

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4905:1: rule__GroupingMessages__Group__2 : rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3 ;
    public final void rule__GroupingMessages__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4909:1: ( rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4910:2: rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__2__Impl_in_rule__GroupingMessages__Group__210432);
            rule__GroupingMessages__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__3_in_rule__GroupingMessages__Group__210435);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4917:1: rule__GroupingMessages__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__GroupingMessages__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4921:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4922:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4922:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4923:1: RULE_NEWLINE
            {
             before(grammarAccess.getGroupingMessagesAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__GroupingMessages__Group__2__Impl10462); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4934:1: rule__GroupingMessages__Group__3 : rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4 ;
    public final void rule__GroupingMessages__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4938:1: ( rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4939:2: rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__3__Impl_in_rule__GroupingMessages__Group__310491);
            rule__GroupingMessages__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__4_in_rule__GroupingMessages__Group__310494);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4946:1: rule__GroupingMessages__Group__3__Impl : ( ( rule__GroupingMessages__InstructionsAssignment_3 )* ) ;
    public final void rule__GroupingMessages__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4950:1: ( ( ( rule__GroupingMessages__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4951:1: ( ( rule__GroupingMessages__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4951:1: ( ( rule__GroupingMessages__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4952:1: ( rule__GroupingMessages__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getGroupingMessagesAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4953:1: ( rule__GroupingMessages__InstructionsAssignment_3 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==End) ) {
                    int LA37_1 = input.LA(2);

                    if ( (LA37_1==RULE_SEQUENCE) ) {
                        alt37=1;
                    }


                }
                else if ( (LA37_0==Participant||(LA37_0>=Autonumber && LA37_0<=Deactivate)||LA37_0==Endlegend||(LA37_0>=Activate && LA37_0<=Database)||(LA37_0>=Control && LA37_0<=Newpage)||(LA37_0>=Center && LA37_0<=Legend)||(LA37_0>=Actor && LA37_0<=Title)||(LA37_0>=Else && LA37_0<=FullStopFullStopFullStop)||(LA37_0>=Alt && LA37_0<=Box)||(LA37_0>=Opt && LA37_0<=VerticalLineVerticalLineVerticalLine)||LA37_0==EqualsSignEqualsSign||(LA37_0>=Of && LA37_0<=VerticalLineVerticalLine)||(LA37_0>=NumberSign && LA37_0<=RULE_NEWLINE)||(LA37_0>=RULE_INT && LA37_0<=RULE_ID)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4953:2: rule__GroupingMessages__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__GroupingMessages__InstructionsAssignment_3_in_rule__GroupingMessages__Group__3__Impl10521);
            	    rule__GroupingMessages__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4963:1: rule__GroupingMessages__Group__4 : rule__GroupingMessages__Group__4__Impl ;
    public final void rule__GroupingMessages__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4967:1: ( rule__GroupingMessages__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4968:2: rule__GroupingMessages__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__4__Impl_in_rule__GroupingMessages__Group__410552);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4974:1: rule__GroupingMessages__Group__4__Impl : ( End ) ;
    public final void rule__GroupingMessages__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4978:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4979:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4979:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4980:1: End
            {
             before(grammarAccess.getGroupingMessagesAccess().getEndKeyword_4()); 
            match(input,End,FOLLOW_End_in_rule__GroupingMessages__Group__4__Impl10580); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5003:1: rule__Note__Group__0 : rule__Note__Group__0__Impl rule__Note__Group__1 ;
    public final void rule__Note__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5007:1: ( rule__Note__Group__0__Impl rule__Note__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5008:2: rule__Note__Group__0__Impl rule__Note__Group__1
            {
            pushFollow(FOLLOW_rule__Note__Group__0__Impl_in_rule__Note__Group__010621);
            rule__Note__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__1_in_rule__Note__Group__010624);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5015:1: rule__Note__Group__0__Impl : ( Note ) ;
    public final void rule__Note__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5019:1: ( ( Note ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5020:1: ( Note )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5020:1: ( Note )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5021:1: Note
            {
             before(grammarAccess.getNoteAccess().getNoteKeyword_0()); 
            match(input,Note,FOLLOW_Note_in_rule__Note__Group__0__Impl10652); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5034:1: rule__Note__Group__1 : rule__Note__Group__1__Impl rule__Note__Group__2 ;
    public final void rule__Note__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5038:1: ( rule__Note__Group__1__Impl rule__Note__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5039:2: rule__Note__Group__1__Impl rule__Note__Group__2
            {
            pushFollow(FOLLOW_rule__Note__Group__1__Impl_in_rule__Note__Group__110683);
            rule__Note__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__2_in_rule__Note__Group__110686);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5046:1: rule__Note__Group__1__Impl : ( ( rule__Note__Alternatives_1 ) ) ;
    public final void rule__Note__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5050:1: ( ( ( rule__Note__Alternatives_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5051:1: ( ( rule__Note__Alternatives_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5051:1: ( ( rule__Note__Alternatives_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5052:1: ( rule__Note__Alternatives_1 )
            {
             before(grammarAccess.getNoteAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5053:1: ( rule__Note__Alternatives_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5053:2: rule__Note__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Note__Alternatives_1_in_rule__Note__Group__1__Impl10713);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5063:1: rule__Note__Group__2 : rule__Note__Group__2__Impl rule__Note__Group__3 ;
    public final void rule__Note__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5067:1: ( rule__Note__Group__2__Impl rule__Note__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5068:2: rule__Note__Group__2__Impl rule__Note__Group__3
            {
            pushFollow(FOLLOW_rule__Note__Group__2__Impl_in_rule__Note__Group__210743);
            rule__Note__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__3_in_rule__Note__Group__210746);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5075:1: rule__Note__Group__2__Impl : ( ( ruleColor )* ) ;
    public final void rule__Note__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5079:1: ( ( ( ruleColor )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5080:1: ( ( ruleColor )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5080:1: ( ( ruleColor )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5081:1: ( ruleColor )*
            {
             before(grammarAccess.getNoteAccess().getColorParserRuleCall_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5082:1: ( ruleColor )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=LightGoldenRodYellow && LA38_0<=YellowGreen)||(LA38_0>=Aquamarine && LA38_0<=WhiteSmoke)||(LA38_0>=AliceBlue && LA38_0<=Turquoise)||(LA38_0>=Cornsilk && LA38_0<=SeaGreen)||(LA38_0>=Crimson && LA38_0<=Thistle)||(LA38_0>=Bisque && LA38_0<=Yellow)||(LA38_0>=Azure && LA38_0<=White)||(LA38_0>=Aqua && LA38_0<=Teal)||(LA38_0>=Red && LA38_0<=Tan)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5082:3: ruleColor
            	    {
            	    pushFollow(FOLLOW_ruleColor_in_rule__Note__Group__2__Impl10774);
            	    ruleColor();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5092:1: rule__Note__Group__3 : rule__Note__Group__3__Impl ;
    public final void rule__Note__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5096:1: ( rule__Note__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5097:2: rule__Note__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group__3__Impl_in_rule__Note__Group__310805);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5103:1: rule__Note__Group__3__Impl : ( ( rule__Note__Alternatives_3 ) ) ;
    public final void rule__Note__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5107:1: ( ( ( rule__Note__Alternatives_3 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5108:1: ( ( rule__Note__Alternatives_3 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5108:1: ( ( rule__Note__Alternatives_3 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5109:1: ( rule__Note__Alternatives_3 )
            {
             before(grammarAccess.getNoteAccess().getAlternatives_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5110:1: ( rule__Note__Alternatives_3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5110:2: rule__Note__Alternatives_3
            {
            pushFollow(FOLLOW_rule__Note__Alternatives_3_in_rule__Note__Group__3__Impl10832);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5128:1: rule__Note__Group_1_0__0 : rule__Note__Group_1_0__0__Impl rule__Note__Group_1_0__1 ;
    public final void rule__Note__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5132:1: ( rule__Note__Group_1_0__0__Impl rule__Note__Group_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5133:2: rule__Note__Group_1_0__0__Impl rule__Note__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0__0__Impl_in_rule__Note__Group_1_0__010870);
            rule__Note__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0__1_in_rule__Note__Group_1_0__010873);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5140:1: rule__Note__Group_1_0__0__Impl : ( Right ) ;
    public final void rule__Note__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5144:1: ( ( Right ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5145:1: ( Right )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5145:1: ( Right )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5146:1: Right
            {
             before(grammarAccess.getNoteAccess().getRightKeyword_1_0_0()); 
            match(input,Right,FOLLOW_Right_in_rule__Note__Group_1_0__0__Impl10901); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5159:1: rule__Note__Group_1_0__1 : rule__Note__Group_1_0__1__Impl ;
    public final void rule__Note__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5163:1: ( rule__Note__Group_1_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5164:2: rule__Note__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0__1__Impl_in_rule__Note__Group_1_0__110932);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5170:1: rule__Note__Group_1_0__1__Impl : ( ( rule__Note__Group_1_0_1__0 )? ) ;
    public final void rule__Note__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5174:1: ( ( ( rule__Note__Group_1_0_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5175:1: ( ( rule__Note__Group_1_0_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5175:1: ( ( rule__Note__Group_1_0_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5176:1: ( rule__Note__Group_1_0_1__0 )?
            {
             before(grammarAccess.getNoteAccess().getGroup_1_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5177:1: ( rule__Note__Group_1_0_1__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==Of) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5177:2: rule__Note__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_0_1__0_in_rule__Note__Group_1_0__1__Impl10959);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5191:1: rule__Note__Group_1_0_1__0 : rule__Note__Group_1_0_1__0__Impl rule__Note__Group_1_0_1__1 ;
    public final void rule__Note__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5195:1: ( rule__Note__Group_1_0_1__0__Impl rule__Note__Group_1_0_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5196:2: rule__Note__Group_1_0_1__0__Impl rule__Note__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1__0__Impl_in_rule__Note__Group_1_0_1__010994);
            rule__Note__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0_1__1_in_rule__Note__Group_1_0_1__010997);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5203:1: rule__Note__Group_1_0_1__0__Impl : ( Of ) ;
    public final void rule__Note__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5207:1: ( ( Of ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5208:1: ( Of )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5208:1: ( Of )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5209:1: Of
            {
             before(grammarAccess.getNoteAccess().getOfKeyword_1_0_1_0()); 
            match(input,Of,FOLLOW_Of_in_rule__Note__Group_1_0_1__0__Impl11025); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5222:1: rule__Note__Group_1_0_1__1 : rule__Note__Group_1_0_1__1__Impl rule__Note__Group_1_0_1__2 ;
    public final void rule__Note__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5226:1: ( rule__Note__Group_1_0_1__1__Impl rule__Note__Group_1_0_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5227:2: rule__Note__Group_1_0_1__1__Impl rule__Note__Group_1_0_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1__1__Impl_in_rule__Note__Group_1_0_1__111056);
            rule__Note__Group_1_0_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0_1__2_in_rule__Note__Group_1_0_1__111059);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5234:1: rule__Note__Group_1_0_1__1__Impl : ( ( rule__Note__RidAssignment_1_0_1_1 ) ) ;
    public final void rule__Note__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5238:1: ( ( ( rule__Note__RidAssignment_1_0_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5239:1: ( ( rule__Note__RidAssignment_1_0_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5239:1: ( ( rule__Note__RidAssignment_1_0_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5240:1: ( rule__Note__RidAssignment_1_0_1_1 )
            {
             before(grammarAccess.getNoteAccess().getRidAssignment_1_0_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5241:1: ( rule__Note__RidAssignment_1_0_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5241:2: rule__Note__RidAssignment_1_0_1_1
            {
            pushFollow(FOLLOW_rule__Note__RidAssignment_1_0_1_1_in_rule__Note__Group_1_0_1__1__Impl11086);
            rule__Note__RidAssignment_1_0_1_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getRidAssignment_1_0_1_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5251:1: rule__Note__Group_1_0_1__2 : rule__Note__Group_1_0_1__2__Impl ;
    public final void rule__Note__Group_1_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5255:1: ( rule__Note__Group_1_0_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5256:2: rule__Note__Group_1_0_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1__2__Impl_in_rule__Note__Group_1_0_1__211116);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5262:1: rule__Note__Group_1_0_1__2__Impl : ( ( rule__Note__Group_1_0_1_2__0 )* ) ;
    public final void rule__Note__Group_1_0_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5266:1: ( ( ( rule__Note__Group_1_0_1_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5267:1: ( ( rule__Note__Group_1_0_1_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5267:1: ( ( rule__Note__Group_1_0_1_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5268:1: ( rule__Note__Group_1_0_1_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_1_0_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5269:1: ( rule__Note__Group_1_0_1_2__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==Comma) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5269:2: rule__Note__Group_1_0_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__0_in_rule__Note__Group_1_0_1__2__Impl11143);
            	    rule__Note__Group_1_0_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5285:1: rule__Note__Group_1_0_1_2__0 : rule__Note__Group_1_0_1_2__0__Impl rule__Note__Group_1_0_1_2__1 ;
    public final void rule__Note__Group_1_0_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5289:1: ( rule__Note__Group_1_0_1_2__0__Impl rule__Note__Group_1_0_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5290:2: rule__Note__Group_1_0_1_2__0__Impl rule__Note__Group_1_0_1_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__0__Impl_in_rule__Note__Group_1_0_1_2__011180);
            rule__Note__Group_1_0_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__1_in_rule__Note__Group_1_0_1_2__011183);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5297:1: rule__Note__Group_1_0_1_2__0__Impl : ( Comma ) ;
    public final void rule__Note__Group_1_0_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5301:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5302:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5302:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5303:1: Comma
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_1_0_1_2_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Note__Group_1_0_1_2__0__Impl11211); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5316:1: rule__Note__Group_1_0_1_2__1 : rule__Note__Group_1_0_1_2__1__Impl ;
    public final void rule__Note__Group_1_0_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5320:1: ( rule__Note__Group_1_0_1_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5321:2: rule__Note__Group_1_0_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__1__Impl_in_rule__Note__Group_1_0_1_2__111242);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5327:1: rule__Note__Group_1_0_1_2__1__Impl : ( ( rule__Note__RidsAssignment_1_0_1_2_1 ) ) ;
    public final void rule__Note__Group_1_0_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5331:1: ( ( ( rule__Note__RidsAssignment_1_0_1_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5332:1: ( ( rule__Note__RidsAssignment_1_0_1_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5332:1: ( ( rule__Note__RidsAssignment_1_0_1_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5333:1: ( rule__Note__RidsAssignment_1_0_1_2_1 )
            {
             before(grammarAccess.getNoteAccess().getRidsAssignment_1_0_1_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5334:1: ( rule__Note__RidsAssignment_1_0_1_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5334:2: rule__Note__RidsAssignment_1_0_1_2_1
            {
            pushFollow(FOLLOW_rule__Note__RidsAssignment_1_0_1_2_1_in_rule__Note__Group_1_0_1_2__1__Impl11269);
            rule__Note__RidsAssignment_1_0_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getRidsAssignment_1_0_1_2_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5348:1: rule__Note__Group_1_1__0 : rule__Note__Group_1_1__0__Impl rule__Note__Group_1_1__1 ;
    public final void rule__Note__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5352:1: ( rule__Note__Group_1_1__0__Impl rule__Note__Group_1_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5353:2: rule__Note__Group_1_1__0__Impl rule__Note__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1__0__Impl_in_rule__Note__Group_1_1__011303);
            rule__Note__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1__1_in_rule__Note__Group_1_1__011306);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5360:1: rule__Note__Group_1_1__0__Impl : ( Left ) ;
    public final void rule__Note__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5364:1: ( ( Left ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5365:1: ( Left )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5365:1: ( Left )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5366:1: Left
            {
             before(grammarAccess.getNoteAccess().getLeftKeyword_1_1_0()); 
            match(input,Left,FOLLOW_Left_in_rule__Note__Group_1_1__0__Impl11334); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5379:1: rule__Note__Group_1_1__1 : rule__Note__Group_1_1__1__Impl ;
    public final void rule__Note__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5383:1: ( rule__Note__Group_1_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5384:2: rule__Note__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1__1__Impl_in_rule__Note__Group_1_1__111365);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5390:1: rule__Note__Group_1_1__1__Impl : ( ( rule__Note__Group_1_1_1__0 )? ) ;
    public final void rule__Note__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5394:1: ( ( ( rule__Note__Group_1_1_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5395:1: ( ( rule__Note__Group_1_1_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5395:1: ( ( rule__Note__Group_1_1_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5396:1: ( rule__Note__Group_1_1_1__0 )?
            {
             before(grammarAccess.getNoteAccess().getGroup_1_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5397:1: ( rule__Note__Group_1_1_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==Of) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5397:2: rule__Note__Group_1_1_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_1_1__0_in_rule__Note__Group_1_1__1__Impl11392);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5411:1: rule__Note__Group_1_1_1__0 : rule__Note__Group_1_1_1__0__Impl rule__Note__Group_1_1_1__1 ;
    public final void rule__Note__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5415:1: ( rule__Note__Group_1_1_1__0__Impl rule__Note__Group_1_1_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5416:2: rule__Note__Group_1_1_1__0__Impl rule__Note__Group_1_1_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1__0__Impl_in_rule__Note__Group_1_1_1__011427);
            rule__Note__Group_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1_1__1_in_rule__Note__Group_1_1_1__011430);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5423:1: rule__Note__Group_1_1_1__0__Impl : ( Of ) ;
    public final void rule__Note__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5427:1: ( ( Of ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5428:1: ( Of )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5428:1: ( Of )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5429:1: Of
            {
             before(grammarAccess.getNoteAccess().getOfKeyword_1_1_1_0()); 
            match(input,Of,FOLLOW_Of_in_rule__Note__Group_1_1_1__0__Impl11458); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5442:1: rule__Note__Group_1_1_1__1 : rule__Note__Group_1_1_1__1__Impl rule__Note__Group_1_1_1__2 ;
    public final void rule__Note__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5446:1: ( rule__Note__Group_1_1_1__1__Impl rule__Note__Group_1_1_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5447:2: rule__Note__Group_1_1_1__1__Impl rule__Note__Group_1_1_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1__1__Impl_in_rule__Note__Group_1_1_1__111489);
            rule__Note__Group_1_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1_1__2_in_rule__Note__Group_1_1_1__111492);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5454:1: rule__Note__Group_1_1_1__1__Impl : ( ( rule__Note__LidAssignment_1_1_1_1 ) ) ;
    public final void rule__Note__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5458:1: ( ( ( rule__Note__LidAssignment_1_1_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5459:1: ( ( rule__Note__LidAssignment_1_1_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5459:1: ( ( rule__Note__LidAssignment_1_1_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5460:1: ( rule__Note__LidAssignment_1_1_1_1 )
            {
             before(grammarAccess.getNoteAccess().getLidAssignment_1_1_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5461:1: ( rule__Note__LidAssignment_1_1_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5461:2: rule__Note__LidAssignment_1_1_1_1
            {
            pushFollow(FOLLOW_rule__Note__LidAssignment_1_1_1_1_in_rule__Note__Group_1_1_1__1__Impl11519);
            rule__Note__LidAssignment_1_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getLidAssignment_1_1_1_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5471:1: rule__Note__Group_1_1_1__2 : rule__Note__Group_1_1_1__2__Impl ;
    public final void rule__Note__Group_1_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5475:1: ( rule__Note__Group_1_1_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5476:2: rule__Note__Group_1_1_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1__2__Impl_in_rule__Note__Group_1_1_1__211549);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5482:1: rule__Note__Group_1_1_1__2__Impl : ( ( rule__Note__Group_1_1_1_2__0 )* ) ;
    public final void rule__Note__Group_1_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5486:1: ( ( ( rule__Note__Group_1_1_1_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5487:1: ( ( rule__Note__Group_1_1_1_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5487:1: ( ( rule__Note__Group_1_1_1_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5488:1: ( rule__Note__Group_1_1_1_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_1_1_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5489:1: ( rule__Note__Group_1_1_1_2__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==Comma) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5489:2: rule__Note__Group_1_1_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__0_in_rule__Note__Group_1_1_1__2__Impl11576);
            	    rule__Note__Group_1_1_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5505:1: rule__Note__Group_1_1_1_2__0 : rule__Note__Group_1_1_1_2__0__Impl rule__Note__Group_1_1_1_2__1 ;
    public final void rule__Note__Group_1_1_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5509:1: ( rule__Note__Group_1_1_1_2__0__Impl rule__Note__Group_1_1_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5510:2: rule__Note__Group_1_1_1_2__0__Impl rule__Note__Group_1_1_1_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__0__Impl_in_rule__Note__Group_1_1_1_2__011613);
            rule__Note__Group_1_1_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__1_in_rule__Note__Group_1_1_1_2__011616);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5517:1: rule__Note__Group_1_1_1_2__0__Impl : ( Comma ) ;
    public final void rule__Note__Group_1_1_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5521:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5522:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5522:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5523:1: Comma
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_1_1_1_2_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Note__Group_1_1_1_2__0__Impl11644); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5536:1: rule__Note__Group_1_1_1_2__1 : rule__Note__Group_1_1_1_2__1__Impl ;
    public final void rule__Note__Group_1_1_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5540:1: ( rule__Note__Group_1_1_1_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5541:2: rule__Note__Group_1_1_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__1__Impl_in_rule__Note__Group_1_1_1_2__111675);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5547:1: rule__Note__Group_1_1_1_2__1__Impl : ( ( rule__Note__LidsAssignment_1_1_1_2_1 ) ) ;
    public final void rule__Note__Group_1_1_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5551:1: ( ( ( rule__Note__LidsAssignment_1_1_1_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5552:1: ( ( rule__Note__LidsAssignment_1_1_1_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5552:1: ( ( rule__Note__LidsAssignment_1_1_1_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5553:1: ( rule__Note__LidsAssignment_1_1_1_2_1 )
            {
             before(grammarAccess.getNoteAccess().getLidsAssignment_1_1_1_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5554:1: ( rule__Note__LidsAssignment_1_1_1_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5554:2: rule__Note__LidsAssignment_1_1_1_2_1
            {
            pushFollow(FOLLOW_rule__Note__LidsAssignment_1_1_1_2_1_in_rule__Note__Group_1_1_1_2__1__Impl11702);
            rule__Note__LidsAssignment_1_1_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getLidsAssignment_1_1_1_2_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5568:1: rule__Note__Group_1_2__0 : rule__Note__Group_1_2__0__Impl rule__Note__Group_1_2__1 ;
    public final void rule__Note__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5572:1: ( rule__Note__Group_1_2__0__Impl rule__Note__Group_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5573:2: rule__Note__Group_1_2__0__Impl rule__Note__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2__0__Impl_in_rule__Note__Group_1_2__011736);
            rule__Note__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_2__1_in_rule__Note__Group_1_2__011739);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5580:1: rule__Note__Group_1_2__0__Impl : ( Over ) ;
    public final void rule__Note__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5584:1: ( ( Over ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5585:1: ( Over )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5585:1: ( Over )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5586:1: Over
            {
             before(grammarAccess.getNoteAccess().getOverKeyword_1_2_0()); 
            match(input,Over,FOLLOW_Over_in_rule__Note__Group_1_2__0__Impl11767); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5599:1: rule__Note__Group_1_2__1 : rule__Note__Group_1_2__1__Impl rule__Note__Group_1_2__2 ;
    public final void rule__Note__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5603:1: ( rule__Note__Group_1_2__1__Impl rule__Note__Group_1_2__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5604:2: rule__Note__Group_1_2__1__Impl rule__Note__Group_1_2__2
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2__1__Impl_in_rule__Note__Group_1_2__111798);
            rule__Note__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_2__2_in_rule__Note__Group_1_2__111801);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5611:1: rule__Note__Group_1_2__1__Impl : ( ( rule__Note__OidAssignment_1_2_1 ) ) ;
    public final void rule__Note__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5615:1: ( ( ( rule__Note__OidAssignment_1_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5616:1: ( ( rule__Note__OidAssignment_1_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5616:1: ( ( rule__Note__OidAssignment_1_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5617:1: ( rule__Note__OidAssignment_1_2_1 )
            {
             before(grammarAccess.getNoteAccess().getOidAssignment_1_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5618:1: ( rule__Note__OidAssignment_1_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5618:2: rule__Note__OidAssignment_1_2_1
            {
            pushFollow(FOLLOW_rule__Note__OidAssignment_1_2_1_in_rule__Note__Group_1_2__1__Impl11828);
            rule__Note__OidAssignment_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getOidAssignment_1_2_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5628:1: rule__Note__Group_1_2__2 : rule__Note__Group_1_2__2__Impl ;
    public final void rule__Note__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5632:1: ( rule__Note__Group_1_2__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5633:2: rule__Note__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2__2__Impl_in_rule__Note__Group_1_2__211858);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5639:1: rule__Note__Group_1_2__2__Impl : ( ( rule__Note__Group_1_2_2__0 )* ) ;
    public final void rule__Note__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5643:1: ( ( ( rule__Note__Group_1_2_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5644:1: ( ( rule__Note__Group_1_2_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5644:1: ( ( rule__Note__Group_1_2_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5645:1: ( rule__Note__Group_1_2_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_1_2_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5646:1: ( rule__Note__Group_1_2_2__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==Comma) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5646:2: rule__Note__Group_1_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_1_2_2__0_in_rule__Note__Group_1_2__2__Impl11885);
            	    rule__Note__Group_1_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5662:1: rule__Note__Group_1_2_2__0 : rule__Note__Group_1_2_2__0__Impl rule__Note__Group_1_2_2__1 ;
    public final void rule__Note__Group_1_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5666:1: ( rule__Note__Group_1_2_2__0__Impl rule__Note__Group_1_2_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5667:2: rule__Note__Group_1_2_2__0__Impl rule__Note__Group_1_2_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2_2__0__Impl_in_rule__Note__Group_1_2_2__011922);
            rule__Note__Group_1_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_2_2__1_in_rule__Note__Group_1_2_2__011925);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5674:1: rule__Note__Group_1_2_2__0__Impl : ( Comma ) ;
    public final void rule__Note__Group_1_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5678:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5679:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5679:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5680:1: Comma
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_1_2_2_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Note__Group_1_2_2__0__Impl11953); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5693:1: rule__Note__Group_1_2_2__1 : rule__Note__Group_1_2_2__1__Impl ;
    public final void rule__Note__Group_1_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5697:1: ( rule__Note__Group_1_2_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5698:2: rule__Note__Group_1_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2_2__1__Impl_in_rule__Note__Group_1_2_2__111984);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5704:1: rule__Note__Group_1_2_2__1__Impl : ( ( rule__Note__OidsAssignment_1_2_2_1 ) ) ;
    public final void rule__Note__Group_1_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5708:1: ( ( ( rule__Note__OidsAssignment_1_2_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5709:1: ( ( rule__Note__OidsAssignment_1_2_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5709:1: ( ( rule__Note__OidsAssignment_1_2_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5710:1: ( rule__Note__OidsAssignment_1_2_2_1 )
            {
             before(grammarAccess.getNoteAccess().getOidsAssignment_1_2_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5711:1: ( rule__Note__OidsAssignment_1_2_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5711:2: rule__Note__OidsAssignment_1_2_2_1
            {
            pushFollow(FOLLOW_rule__Note__OidsAssignment_1_2_2_1_in_rule__Note__Group_1_2_2__1__Impl12011);
            rule__Note__OidsAssignment_1_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getOidsAssignment_1_2_2_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5725:1: rule__Note__Group_3_0__0 : rule__Note__Group_3_0__0__Impl rule__Note__Group_3_0__1 ;
    public final void rule__Note__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5729:1: ( rule__Note__Group_3_0__0__Impl rule__Note__Group_3_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5730:2: rule__Note__Group_3_0__0__Impl rule__Note__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_3_0__0__Impl_in_rule__Note__Group_3_0__012045);
            rule__Note__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_0__1_in_rule__Note__Group_3_0__012048);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5737:1: rule__Note__Group_3_0__0__Impl : ( Colon ) ;
    public final void rule__Note__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5741:1: ( ( Colon ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5742:1: ( Colon )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5742:1: ( Colon )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5743:1: Colon
            {
             before(grammarAccess.getNoteAccess().getColonKeyword_3_0_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Note__Group_3_0__0__Impl12076); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5756:1: rule__Note__Group_3_0__1 : rule__Note__Group_3_0__1__Impl ;
    public final void rule__Note__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5760:1: ( rule__Note__Group_3_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5761:2: rule__Note__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_3_0__1__Impl_in_rule__Note__Group_3_0__112107);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5767:1: rule__Note__Group_3_0__1__Impl : ( ( ruleMyID )* ) ;
    public final void rule__Note__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5771:1: ( ( ( ruleMyID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5772:1: ( ( ruleMyID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5772:1: ( ( ruleMyID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5773:1: ( ruleMyID )*
            {
             before(grammarAccess.getNoteAccess().getMyIDParserRuleCall_3_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5774:1: ( ruleMyID )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=Autonumber && LA44_0<=Deactivate)||LA44_0==Endlegend||LA44_0==Activate||LA44_0==Critical||(LA44_0>=Destroy && LA44_0<=Newpage)||(LA44_0>=Center && LA44_0<=Create)||LA44_0==Legend||(LA44_0>=Break && LA44_0<=Title)||(LA44_0>=Else && LA44_0<=Over)||(LA44_0>=Alt && LA44_0<=Ref)||LA44_0==Of||(LA44_0>=NumberSign && LA44_0<=GreaterThanSign)||(LA44_0>=RULE_INT && LA44_0<=RULE_ID)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5774:3: ruleMyID
            	    {
            	    pushFollow(FOLLOW_ruleMyID_in_rule__Note__Group_3_0__1__Impl12135);
            	    ruleMyID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getMyIDParserRuleCall_3_0_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5788:1: rule__Note__Group_3_1__0 : rule__Note__Group_3_1__0__Impl rule__Note__Group_3_1__1 ;
    public final void rule__Note__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5792:1: ( rule__Note__Group_3_1__0__Impl rule__Note__Group_3_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5793:2: rule__Note__Group_3_1__0__Impl rule__Note__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1__0__Impl_in_rule__Note__Group_3_1__012170);
            rule__Note__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_1__1_in_rule__Note__Group_3_1__012173);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5800:1: rule__Note__Group_3_1__0__Impl : ( ( rule__Note__Group_3_1_0__0 )* ) ;
    public final void rule__Note__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5804:1: ( ( ( rule__Note__Group_3_1_0__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5805:1: ( ( rule__Note__Group_3_1_0__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5805:1: ( ( rule__Note__Group_3_1_0__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5806:1: ( rule__Note__Group_3_1_0__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_3_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5807:1: ( rule__Note__Group_3_1_0__0 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_NEWLINE) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5807:2: rule__Note__Group_3_1_0__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_3_1_0__0_in_rule__Note__Group_3_1__0__Impl12200);
            	    rule__Note__Group_3_1_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5817:1: rule__Note__Group_3_1__1 : rule__Note__Group_3_1__1__Impl rule__Note__Group_3_1__2 ;
    public final void rule__Note__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5821:1: ( rule__Note__Group_3_1__1__Impl rule__Note__Group_3_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5822:2: rule__Note__Group_3_1__1__Impl rule__Note__Group_3_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1__1__Impl_in_rule__Note__Group_3_1__112231);
            rule__Note__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_1__2_in_rule__Note__Group_3_1__112234);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5829:1: rule__Note__Group_3_1__1__Impl : ( End ) ;
    public final void rule__Note__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5833:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5834:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5834:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5835:1: End
            {
             before(grammarAccess.getNoteAccess().getEndKeyword_3_1_1()); 
            match(input,End,FOLLOW_End_in_rule__Note__Group_3_1__1__Impl12262); 
             after(grammarAccess.getNoteAccess().getEndKeyword_3_1_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5848:1: rule__Note__Group_3_1__2 : rule__Note__Group_3_1__2__Impl ;
    public final void rule__Note__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5852:1: ( rule__Note__Group_3_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5853:2: rule__Note__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1__2__Impl_in_rule__Note__Group_3_1__212293);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5859:1: rule__Note__Group_3_1__2__Impl : ( Note ) ;
    public final void rule__Note__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5863:1: ( ( Note ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5864:1: ( Note )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5864:1: ( Note )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5865:1: Note
            {
             before(grammarAccess.getNoteAccess().getNoteKeyword_3_1_2()); 
            match(input,Note,FOLLOW_Note_in_rule__Note__Group_3_1__2__Impl12321); 
             after(grammarAccess.getNoteAccess().getNoteKeyword_3_1_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5884:1: rule__Note__Group_3_1_0__0 : rule__Note__Group_3_1_0__0__Impl rule__Note__Group_3_1_0__1 ;
    public final void rule__Note__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5888:1: ( rule__Note__Group_3_1_0__0__Impl rule__Note__Group_3_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5889:2: rule__Note__Group_3_1_0__0__Impl rule__Note__Group_3_1_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1_0__0__Impl_in_rule__Note__Group_3_1_0__012358);
            rule__Note__Group_3_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_1_0__1_in_rule__Note__Group_3_1_0__012361);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5896:1: rule__Note__Group_3_1_0__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Note__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5900:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5901:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5901:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5902:1: RULE_NEWLINE
            {
             before(grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_0_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Note__Group_3_1_0__0__Impl12388); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5913:1: rule__Note__Group_3_1_0__1 : rule__Note__Group_3_1_0__1__Impl ;
    public final void rule__Note__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5917:1: ( rule__Note__Group_3_1_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5918:2: rule__Note__Group_3_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1_0__1__Impl_in_rule__Note__Group_3_1_0__112417);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5924:1: rule__Note__Group_3_1_0__1__Impl : ( ( ruleEndID )* ) ;
    public final void rule__Note__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5928:1: ( ( ( ruleEndID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5929:1: ( ( ruleEndID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5929:1: ( ( ruleEndID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5930:1: ( ruleEndID )*
            {
             before(grammarAccess.getNoteAccess().getEndIDParserRuleCall_3_1_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5931:1: ( ruleEndID )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=Autonumber && LA46_0<=Deactivate)||LA46_0==Endlegend||LA46_0==Activate||LA46_0==Critical||(LA46_0>=Destroy && LA46_0<=Newpage)||(LA46_0>=Center && LA46_0<=Create)||LA46_0==Legend||(LA46_0>=Break && LA46_0<=Title)||(LA46_0>=Else && LA46_0<=Over)||(LA46_0>=Alt && LA46_0<=Box)||(LA46_0>=Opt && LA46_0<=Ref)||LA46_0==Of||(LA46_0>=NumberSign && LA46_0<=GreaterThanSign)||(LA46_0>=RULE_INT && LA46_0<=RULE_ID)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5931:3: ruleEndID
            	    {
            	    pushFollow(FOLLOW_ruleEndID_in_rule__Note__Group_3_1_0__1__Impl12445);
            	    ruleEndID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getEndIDParserRuleCall_3_1_0_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5945:1: rule__Divider__Group__0 : rule__Divider__Group__0__Impl rule__Divider__Group__1 ;
    public final void rule__Divider__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5949:1: ( rule__Divider__Group__0__Impl rule__Divider__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5950:2: rule__Divider__Group__0__Impl rule__Divider__Group__1
            {
            pushFollow(FOLLOW_rule__Divider__Group__0__Impl_in_rule__Divider__Group__012480);
            rule__Divider__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Divider__Group__1_in_rule__Divider__Group__012483);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5957:1: rule__Divider__Group__0__Impl : ( EqualsSignEqualsSign ) ;
    public final void rule__Divider__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5961:1: ( ( EqualsSignEqualsSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5962:1: ( EqualsSignEqualsSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5962:1: ( EqualsSignEqualsSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5963:1: EqualsSignEqualsSign
            {
             before(grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_0()); 
            match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__0__Impl12511); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5976:1: rule__Divider__Group__1 : rule__Divider__Group__1__Impl rule__Divider__Group__2 ;
    public final void rule__Divider__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5980:1: ( rule__Divider__Group__1__Impl rule__Divider__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5981:2: rule__Divider__Group__1__Impl rule__Divider__Group__2
            {
            pushFollow(FOLLOW_rule__Divider__Group__1__Impl_in_rule__Divider__Group__112542);
            rule__Divider__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Divider__Group__2_in_rule__Divider__Group__112545);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5988:1: rule__Divider__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Divider__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5992:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5993:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5993:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5994:1: ( RULE_ID )*
            {
             before(grammarAccess.getDividerAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5995:1: ( RULE_ID )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_ID) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5995:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Divider__Group__1__Impl12573); 

            	    }
            	    break;

            	default :
            	    break loop47;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6005:1: rule__Divider__Group__2 : rule__Divider__Group__2__Impl ;
    public final void rule__Divider__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6009:1: ( rule__Divider__Group__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6010:2: rule__Divider__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Divider__Group__2__Impl_in_rule__Divider__Group__212604);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6016:1: rule__Divider__Group__2__Impl : ( EqualsSignEqualsSign ) ;
    public final void rule__Divider__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6020:1: ( ( EqualsSignEqualsSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6021:1: ( EqualsSignEqualsSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6021:1: ( EqualsSignEqualsSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6022:1: EqualsSignEqualsSign
            {
             before(grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_2()); 
            match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__2__Impl12632); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6041:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6045:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6046:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__012669);
            rule__Reference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__012672);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6053:1: rule__Reference__Group__0__Impl : ( Ref ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6057:1: ( ( Ref ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6058:1: ( Ref )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6058:1: ( Ref )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6059:1: Ref
            {
             before(grammarAccess.getReferenceAccess().getRefKeyword_0()); 
            match(input,Ref,FOLLOW_Ref_in_rule__Reference__Group__0__Impl12700); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6072:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6076:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6077:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
            {
            pushFollow(FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__112731);
            rule__Reference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__112734);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6084:1: rule__Reference__Group__1__Impl : ( Over ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6088:1: ( ( Over ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6089:1: ( Over )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6089:1: ( Over )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6090:1: Over
            {
             before(grammarAccess.getReferenceAccess().getOverKeyword_1()); 
            match(input,Over,FOLLOW_Over_in_rule__Reference__Group__1__Impl12762); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6103:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6107:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6108:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
            {
            pushFollow(FOLLOW_rule__Reference__Group__2__Impl_in_rule__Reference__Group__212793);
            rule__Reference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__212796);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6115:1: rule__Reference__Group__2__Impl : ( ( rule__Reference__IdAssignment_2 ) ) ;
    public final void rule__Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6119:1: ( ( ( rule__Reference__IdAssignment_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6120:1: ( ( rule__Reference__IdAssignment_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6120:1: ( ( rule__Reference__IdAssignment_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6121:1: ( rule__Reference__IdAssignment_2 )
            {
             before(grammarAccess.getReferenceAccess().getIdAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6122:1: ( rule__Reference__IdAssignment_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6122:2: rule__Reference__IdAssignment_2
            {
            pushFollow(FOLLOW_rule__Reference__IdAssignment_2_in_rule__Reference__Group__2__Impl12823);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6132:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6136:1: ( rule__Reference__Group__3__Impl rule__Reference__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6137:2: rule__Reference__Group__3__Impl rule__Reference__Group__4
            {
            pushFollow(FOLLOW_rule__Reference__Group__3__Impl_in_rule__Reference__Group__312853);
            rule__Reference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__312856);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6144:1: rule__Reference__Group__3__Impl : ( ( rule__Reference__Group_3__0 )* ) ;
    public final void rule__Reference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6148:1: ( ( ( rule__Reference__Group_3__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6149:1: ( ( rule__Reference__Group_3__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6149:1: ( ( rule__Reference__Group_3__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6150:1: ( rule__Reference__Group_3__0 )*
            {
             before(grammarAccess.getReferenceAccess().getGroup_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6151:1: ( rule__Reference__Group_3__0 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==Comma) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6151:2: rule__Reference__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Reference__Group_3__0_in_rule__Reference__Group__3__Impl12883);
            	    rule__Reference__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6161:1: rule__Reference__Group__4 : rule__Reference__Group__4__Impl ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6165:1: ( rule__Reference__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6166:2: rule__Reference__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group__4__Impl_in_rule__Reference__Group__412914);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6172:1: rule__Reference__Group__4__Impl : ( ( rule__Reference__Alternatives_4 ) ) ;
    public final void rule__Reference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6176:1: ( ( ( rule__Reference__Alternatives_4 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6177:1: ( ( rule__Reference__Alternatives_4 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6177:1: ( ( rule__Reference__Alternatives_4 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6178:1: ( rule__Reference__Alternatives_4 )
            {
             before(grammarAccess.getReferenceAccess().getAlternatives_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6179:1: ( rule__Reference__Alternatives_4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6179:2: rule__Reference__Alternatives_4
            {
            pushFollow(FOLLOW_rule__Reference__Alternatives_4_in_rule__Reference__Group__4__Impl12941);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6199:1: rule__Reference__Group_3__0 : rule__Reference__Group_3__0__Impl rule__Reference__Group_3__1 ;
    public final void rule__Reference__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6203:1: ( rule__Reference__Group_3__0__Impl rule__Reference__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6204:2: rule__Reference__Group_3__0__Impl rule__Reference__Group_3__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_3__0__Impl_in_rule__Reference__Group_3__012981);
            rule__Reference__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_3__1_in_rule__Reference__Group_3__012984);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6211:1: rule__Reference__Group_3__0__Impl : ( Comma ) ;
    public final void rule__Reference__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6215:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6216:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6216:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6217:1: Comma
            {
             before(grammarAccess.getReferenceAccess().getCommaKeyword_3_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Reference__Group_3__0__Impl13012); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6230:1: rule__Reference__Group_3__1 : rule__Reference__Group_3__1__Impl ;
    public final void rule__Reference__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6234:1: ( rule__Reference__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6235:2: rule__Reference__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_3__1__Impl_in_rule__Reference__Group_3__113043);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6241:1: rule__Reference__Group_3__1__Impl : ( ( rule__Reference__IdsAssignment_3_1 ) ) ;
    public final void rule__Reference__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6245:1: ( ( ( rule__Reference__IdsAssignment_3_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6246:1: ( ( rule__Reference__IdsAssignment_3_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6246:1: ( ( rule__Reference__IdsAssignment_3_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6247:1: ( rule__Reference__IdsAssignment_3_1 )
            {
             before(grammarAccess.getReferenceAccess().getIdsAssignment_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6248:1: ( rule__Reference__IdsAssignment_3_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6248:2: rule__Reference__IdsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Reference__IdsAssignment_3_1_in_rule__Reference__Group_3__1__Impl13070);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6262:1: rule__Reference__Group_4_0__0 : rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1 ;
    public final void rule__Reference__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6266:1: ( rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6267:2: rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_0__0__Impl_in_rule__Reference__Group_4_0__013104);
            rule__Reference__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_0__1_in_rule__Reference__Group_4_0__013107);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6274:1: rule__Reference__Group_4_0__0__Impl : ( Colon ) ;
    public final void rule__Reference__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6278:1: ( ( Colon ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6279:1: ( Colon )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6279:1: ( Colon )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6280:1: Colon
            {
             before(grammarAccess.getReferenceAccess().getColonKeyword_4_0_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Reference__Group_4_0__0__Impl13135); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6293:1: rule__Reference__Group_4_0__1 : rule__Reference__Group_4_0__1__Impl ;
    public final void rule__Reference__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6297:1: ( rule__Reference__Group_4_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6298:2: rule__Reference__Group_4_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_0__1__Impl_in_rule__Reference__Group_4_0__113166);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6304:1: rule__Reference__Group_4_0__1__Impl : ( ( ruleMyID )* ) ;
    public final void rule__Reference__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6308:1: ( ( ( ruleMyID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6309:1: ( ( ruleMyID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6309:1: ( ( ruleMyID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6310:1: ( ruleMyID )*
            {
             before(grammarAccess.getReferenceAccess().getMyIDParserRuleCall_4_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6311:1: ( ruleMyID )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=Autonumber && LA49_0<=Deactivate)||LA49_0==Endlegend||LA49_0==Activate||LA49_0==Critical||(LA49_0>=Destroy && LA49_0<=Newpage)||(LA49_0>=Center && LA49_0<=Create)||LA49_0==Legend||(LA49_0>=Break && LA49_0<=Title)||(LA49_0>=Else && LA49_0<=Over)||(LA49_0>=Alt && LA49_0<=Ref)||LA49_0==Of||(LA49_0>=NumberSign && LA49_0<=GreaterThanSign)||(LA49_0>=RULE_INT && LA49_0<=RULE_ID)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6311:3: ruleMyID
            	    {
            	    pushFollow(FOLLOW_ruleMyID_in_rule__Reference__Group_4_0__1__Impl13194);
            	    ruleMyID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getMyIDParserRuleCall_4_0_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6325:1: rule__Reference__Group_4_1__0 : rule__Reference__Group_4_1__0__Impl rule__Reference__Group_4_1__1 ;
    public final void rule__Reference__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6329:1: ( rule__Reference__Group_4_1__0__Impl rule__Reference__Group_4_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6330:2: rule__Reference__Group_4_1__0__Impl rule__Reference__Group_4_1__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1__0__Impl_in_rule__Reference__Group_4_1__013229);
            rule__Reference__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_1__1_in_rule__Reference__Group_4_1__013232);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6337:1: rule__Reference__Group_4_1__0__Impl : ( ( rule__Reference__Group_4_1_0__0 )* ) ;
    public final void rule__Reference__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6341:1: ( ( ( rule__Reference__Group_4_1_0__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6342:1: ( ( rule__Reference__Group_4_1_0__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6342:1: ( ( rule__Reference__Group_4_1_0__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6343:1: ( rule__Reference__Group_4_1_0__0 )*
            {
             before(grammarAccess.getReferenceAccess().getGroup_4_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6344:1: ( rule__Reference__Group_4_1_0__0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_NEWLINE) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6344:2: rule__Reference__Group_4_1_0__0
            	    {
            	    pushFollow(FOLLOW_rule__Reference__Group_4_1_0__0_in_rule__Reference__Group_4_1__0__Impl13259);
            	    rule__Reference__Group_4_1_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6354:1: rule__Reference__Group_4_1__1 : rule__Reference__Group_4_1__1__Impl rule__Reference__Group_4_1__2 ;
    public final void rule__Reference__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6358:1: ( rule__Reference__Group_4_1__1__Impl rule__Reference__Group_4_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6359:2: rule__Reference__Group_4_1__1__Impl rule__Reference__Group_4_1__2
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1__1__Impl_in_rule__Reference__Group_4_1__113290);
            rule__Reference__Group_4_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_1__2_in_rule__Reference__Group_4_1__113293);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6366:1: rule__Reference__Group_4_1__1__Impl : ( End ) ;
    public final void rule__Reference__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6370:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6371:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6371:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6372:1: End
            {
             before(grammarAccess.getReferenceAccess().getEndKeyword_4_1_1()); 
            match(input,End,FOLLOW_End_in_rule__Reference__Group_4_1__1__Impl13321); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6385:1: rule__Reference__Group_4_1__2 : rule__Reference__Group_4_1__2__Impl ;
    public final void rule__Reference__Group_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6389:1: ( rule__Reference__Group_4_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6390:2: rule__Reference__Group_4_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1__2__Impl_in_rule__Reference__Group_4_1__213352);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6396:1: rule__Reference__Group_4_1__2__Impl : ( Ref ) ;
    public final void rule__Reference__Group_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6400:1: ( ( Ref ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6401:1: ( Ref )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6401:1: ( Ref )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6402:1: Ref
            {
             before(grammarAccess.getReferenceAccess().getRefKeyword_4_1_2()); 
            match(input,Ref,FOLLOW_Ref_in_rule__Reference__Group_4_1__2__Impl13380); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6421:1: rule__Reference__Group_4_1_0__0 : rule__Reference__Group_4_1_0__0__Impl rule__Reference__Group_4_1_0__1 ;
    public final void rule__Reference__Group_4_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6425:1: ( rule__Reference__Group_4_1_0__0__Impl rule__Reference__Group_4_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6426:2: rule__Reference__Group_4_1_0__0__Impl rule__Reference__Group_4_1_0__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1_0__0__Impl_in_rule__Reference__Group_4_1_0__013417);
            rule__Reference__Group_4_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_1_0__1_in_rule__Reference__Group_4_1_0__013420);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6433:1: rule__Reference__Group_4_1_0__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Reference__Group_4_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6437:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6438:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6438:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6439:1: RULE_NEWLINE
            {
             before(grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_4_1_0_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Reference__Group_4_1_0__0__Impl13447); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6450:1: rule__Reference__Group_4_1_0__1 : rule__Reference__Group_4_1_0__1__Impl ;
    public final void rule__Reference__Group_4_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6454:1: ( rule__Reference__Group_4_1_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6455:2: rule__Reference__Group_4_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1_0__1__Impl_in_rule__Reference__Group_4_1_0__113476);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6461:1: rule__Reference__Group_4_1_0__1__Impl : ( ( ruleEndID )* ) ;
    public final void rule__Reference__Group_4_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6465:1: ( ( ( ruleEndID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6466:1: ( ( ruleEndID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6466:1: ( ( ruleEndID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6467:1: ( ruleEndID )*
            {
             before(grammarAccess.getReferenceAccess().getEndIDParserRuleCall_4_1_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6468:1: ( ruleEndID )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( ((LA51_0>=Autonumber && LA51_0<=Deactivate)||LA51_0==Endlegend||LA51_0==Activate||LA51_0==Critical||(LA51_0>=Destroy && LA51_0<=Newpage)||(LA51_0>=Center && LA51_0<=Create)||LA51_0==Legend||(LA51_0>=Break && LA51_0<=Title)||(LA51_0>=Else && LA51_0<=Over)||(LA51_0>=Alt && LA51_0<=Box)||(LA51_0>=Opt && LA51_0<=Ref)||LA51_0==Of||(LA51_0>=NumberSign && LA51_0<=GreaterThanSign)||(LA51_0>=RULE_INT && LA51_0<=RULE_ID)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6468:3: ruleEndID
            	    {
            	    pushFollow(FOLLOW_ruleEndID_in_rule__Reference__Group_4_1_0__1__Impl13504);
            	    ruleEndID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getEndIDParserRuleCall_4_1_0_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6482:1: rule__Delay__Group__0 : rule__Delay__Group__0__Impl rule__Delay__Group__1 ;
    public final void rule__Delay__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6486:1: ( rule__Delay__Group__0__Impl rule__Delay__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6487:2: rule__Delay__Group__0__Impl rule__Delay__Group__1
            {
            pushFollow(FOLLOW_rule__Delay__Group__0__Impl_in_rule__Delay__Group__013539);
            rule__Delay__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Delay__Group__1_in_rule__Delay__Group__013542);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6494:1: rule__Delay__Group__0__Impl : ( FullStopFullStopFullStop ) ;
    public final void rule__Delay__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6498:1: ( ( FullStopFullStopFullStop ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6499:1: ( FullStopFullStopFullStop )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6499:1: ( FullStopFullStopFullStop )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6500:1: FullStopFullStopFullStop
            {
             before(grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_0()); 
            match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group__0__Impl13570); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6513:1: rule__Delay__Group__1 : rule__Delay__Group__1__Impl ;
    public final void rule__Delay__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6517:1: ( rule__Delay__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6518:2: rule__Delay__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Delay__Group__1__Impl_in_rule__Delay__Group__113601);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6524:1: rule__Delay__Group__1__Impl : ( ( rule__Delay__Group_1__0 )? ) ;
    public final void rule__Delay__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6528:1: ( ( ( rule__Delay__Group_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6529:1: ( ( rule__Delay__Group_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6529:1: ( ( rule__Delay__Group_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6530:1: ( rule__Delay__Group_1__0 )?
            {
             before(grammarAccess.getDelayAccess().getGroup_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6531:1: ( rule__Delay__Group_1__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==FullStopFullStopFullStop||LA52_0==RULE_ID) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6531:2: rule__Delay__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Delay__Group_1__0_in_rule__Delay__Group__1__Impl13628);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6545:1: rule__Delay__Group_1__0 : rule__Delay__Group_1__0__Impl rule__Delay__Group_1__1 ;
    public final void rule__Delay__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6549:1: ( rule__Delay__Group_1__0__Impl rule__Delay__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6550:2: rule__Delay__Group_1__0__Impl rule__Delay__Group_1__1
            {
            pushFollow(FOLLOW_rule__Delay__Group_1__0__Impl_in_rule__Delay__Group_1__013663);
            rule__Delay__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Delay__Group_1__1_in_rule__Delay__Group_1__013666);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6557:1: rule__Delay__Group_1__0__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Delay__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6561:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6562:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6562:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6563:1: ( RULE_ID )*
            {
             before(grammarAccess.getDelayAccess().getIDTerminalRuleCall_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6564:1: ( RULE_ID )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_ID) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6564:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Delay__Group_1__0__Impl13694); 

            	    }
            	    break;

            	default :
            	    break loop53;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6574:1: rule__Delay__Group_1__1 : rule__Delay__Group_1__1__Impl ;
    public final void rule__Delay__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6578:1: ( rule__Delay__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6579:2: rule__Delay__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Delay__Group_1__1__Impl_in_rule__Delay__Group_1__113725);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6585:1: rule__Delay__Group_1__1__Impl : ( FullStopFullStopFullStop ) ;
    public final void rule__Delay__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6589:1: ( ( FullStopFullStopFullStop ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6590:1: ( FullStopFullStopFullStop )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6590:1: ( FullStopFullStopFullStop )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6591:1: FullStopFullStopFullStop
            {
             before(grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_1_1()); 
            match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group_1__1__Impl13753); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6608:1: rule__Space__Group_1__0 : rule__Space__Group_1__0__Impl rule__Space__Group_1__1 ;
    public final void rule__Space__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6612:1: ( rule__Space__Group_1__0__Impl rule__Space__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6613:2: rule__Space__Group_1__0__Impl rule__Space__Group_1__1
            {
            pushFollow(FOLLOW_rule__Space__Group_1__0__Impl_in_rule__Space__Group_1__013788);
            rule__Space__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Space__Group_1__1_in_rule__Space__Group_1__013791);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6620:1: rule__Space__Group_1__0__Impl : ( VerticalLineVerticalLine ) ;
    public final void rule__Space__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6624:1: ( ( VerticalLineVerticalLine ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6625:1: ( VerticalLineVerticalLine )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6625:1: ( VerticalLineVerticalLine )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6626:1: VerticalLineVerticalLine
            {
             before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_0()); 
            match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__0__Impl13819); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6639:1: rule__Space__Group_1__1 : rule__Space__Group_1__1__Impl rule__Space__Group_1__2 ;
    public final void rule__Space__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6643:1: ( rule__Space__Group_1__1__Impl rule__Space__Group_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6644:2: rule__Space__Group_1__1__Impl rule__Space__Group_1__2
            {
            pushFollow(FOLLOW_rule__Space__Group_1__1__Impl_in_rule__Space__Group_1__113850);
            rule__Space__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Space__Group_1__2_in_rule__Space__Group_1__113853);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6651:1: rule__Space__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__Space__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6655:1: ( ( RULE_INT ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6656:1: ( RULE_INT )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6656:1: ( RULE_INT )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6657:1: RULE_INT
            {
             before(grammarAccess.getSpaceAccess().getINTTerminalRuleCall_1_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Space__Group_1__1__Impl13880); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6668:1: rule__Space__Group_1__2 : rule__Space__Group_1__2__Impl ;
    public final void rule__Space__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6672:1: ( rule__Space__Group_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6673:2: rule__Space__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Space__Group_1__2__Impl_in_rule__Space__Group_1__213909);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6679:1: rule__Space__Group_1__2__Impl : ( VerticalLineVerticalLine ) ;
    public final void rule__Space__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6683:1: ( ( VerticalLineVerticalLine ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6684:1: ( VerticalLineVerticalLine )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6684:1: ( VerticalLineVerticalLine )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6685:1: VerticalLineVerticalLine
            {
             before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_2()); 
            match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__2__Impl13937); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6704:1: rule__Hidefootbox__Group__0 : rule__Hidefootbox__Group__0__Impl rule__Hidefootbox__Group__1 ;
    public final void rule__Hidefootbox__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6708:1: ( rule__Hidefootbox__Group__0__Impl rule__Hidefootbox__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6709:2: rule__Hidefootbox__Group__0__Impl rule__Hidefootbox__Group__1
            {
            pushFollow(FOLLOW_rule__Hidefootbox__Group__0__Impl_in_rule__Hidefootbox__Group__013974);
            rule__Hidefootbox__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Hidefootbox__Group__1_in_rule__Hidefootbox__Group__013977);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6716:1: rule__Hidefootbox__Group__0__Impl : ( Hide ) ;
    public final void rule__Hidefootbox__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6720:1: ( ( Hide ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6721:1: ( Hide )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6721:1: ( Hide )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6722:1: Hide
            {
             before(grammarAccess.getHidefootboxAccess().getHideKeyword_0()); 
            match(input,Hide,FOLLOW_Hide_in_rule__Hidefootbox__Group__0__Impl14005); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6735:1: rule__Hidefootbox__Group__1 : rule__Hidefootbox__Group__1__Impl ;
    public final void rule__Hidefootbox__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6739:1: ( rule__Hidefootbox__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6740:2: rule__Hidefootbox__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Hidefootbox__Group__1__Impl_in_rule__Hidefootbox__Group__114036);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6746:1: rule__Hidefootbox__Group__1__Impl : ( Footbox ) ;
    public final void rule__Hidefootbox__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6750:1: ( ( Footbox ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6751:1: ( Footbox )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6751:1: ( Footbox )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6752:1: Footbox
            {
             before(grammarAccess.getHidefootboxAccess().getFootboxKeyword_1()); 
            match(input,Footbox,FOLLOW_Footbox_in_rule__Hidefootbox__Group__1__Impl14064); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6769:1: rule__Activate__Group__0 : rule__Activate__Group__0__Impl rule__Activate__Group__1 ;
    public final void rule__Activate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6773:1: ( rule__Activate__Group__0__Impl rule__Activate__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6774:2: rule__Activate__Group__0__Impl rule__Activate__Group__1
            {
            pushFollow(FOLLOW_rule__Activate__Group__0__Impl_in_rule__Activate__Group__014099);
            rule__Activate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Activate__Group__1_in_rule__Activate__Group__014102);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6781:1: rule__Activate__Group__0__Impl : ( Activate ) ;
    public final void rule__Activate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6785:1: ( ( Activate ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6786:1: ( Activate )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6786:1: ( Activate )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6787:1: Activate
            {
             before(grammarAccess.getActivateAccess().getActivateKeyword_0()); 
            match(input,Activate,FOLLOW_Activate_in_rule__Activate__Group__0__Impl14130); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6800:1: rule__Activate__Group__1 : rule__Activate__Group__1__Impl rule__Activate__Group__2 ;
    public final void rule__Activate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6804:1: ( rule__Activate__Group__1__Impl rule__Activate__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6805:2: rule__Activate__Group__1__Impl rule__Activate__Group__2
            {
            pushFollow(FOLLOW_rule__Activate__Group__1__Impl_in_rule__Activate__Group__114161);
            rule__Activate__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Activate__Group__2_in_rule__Activate__Group__114164);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6812:1: rule__Activate__Group__1__Impl : ( ( ruleColor )? ) ;
    public final void rule__Activate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6816:1: ( ( ( ruleColor )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6817:1: ( ( ruleColor )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6817:1: ( ( ruleColor )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6818:1: ( ruleColor )?
            {
             before(grammarAccess.getActivateAccess().getColorParserRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6819:1: ( ruleColor )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=LightGoldenRodYellow && LA54_0<=YellowGreen)||(LA54_0>=Aquamarine && LA54_0<=WhiteSmoke)||(LA54_0>=AliceBlue && LA54_0<=Turquoise)||(LA54_0>=Cornsilk && LA54_0<=SeaGreen)||(LA54_0>=Crimson && LA54_0<=Thistle)||(LA54_0>=Bisque && LA54_0<=Yellow)||(LA54_0>=Azure && LA54_0<=White)||(LA54_0>=Aqua && LA54_0<=Teal)||(LA54_0>=Red && LA54_0<=Tan)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6819:3: ruleColor
                    {
                    pushFollow(FOLLOW_ruleColor_in_rule__Activate__Group__1__Impl14192);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6829:1: rule__Activate__Group__2 : rule__Activate__Group__2__Impl ;
    public final void rule__Activate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6833:1: ( rule__Activate__Group__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6834:2: rule__Activate__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Activate__Group__2__Impl_in_rule__Activate__Group__214223);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6840:1: rule__Activate__Group__2__Impl : ( ( rule__Activate__NameAssignment_2 ) ) ;
    public final void rule__Activate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6844:1: ( ( ( rule__Activate__NameAssignment_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6845:1: ( ( rule__Activate__NameAssignment_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6845:1: ( ( rule__Activate__NameAssignment_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6846:1: ( rule__Activate__NameAssignment_2 )
            {
             before(grammarAccess.getActivateAccess().getNameAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6847:1: ( rule__Activate__NameAssignment_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6847:2: rule__Activate__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__Activate__NameAssignment_2_in_rule__Activate__Group__2__Impl14250);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6863:1: rule__Deactivate__Group__0 : rule__Deactivate__Group__0__Impl rule__Deactivate__Group__1 ;
    public final void rule__Deactivate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6867:1: ( rule__Deactivate__Group__0__Impl rule__Deactivate__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6868:2: rule__Deactivate__Group__0__Impl rule__Deactivate__Group__1
            {
            pushFollow(FOLLOW_rule__Deactivate__Group__0__Impl_in_rule__Deactivate__Group__014286);
            rule__Deactivate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Deactivate__Group__1_in_rule__Deactivate__Group__014289);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6875:1: rule__Deactivate__Group__0__Impl : ( ( rule__Deactivate__Alternatives_0 ) ) ;
    public final void rule__Deactivate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6879:1: ( ( ( rule__Deactivate__Alternatives_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6880:1: ( ( rule__Deactivate__Alternatives_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6880:1: ( ( rule__Deactivate__Alternatives_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6881:1: ( rule__Deactivate__Alternatives_0 )
            {
             before(grammarAccess.getDeactivateAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6882:1: ( rule__Deactivate__Alternatives_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6882:2: rule__Deactivate__Alternatives_0
            {
            pushFollow(FOLLOW_rule__Deactivate__Alternatives_0_in_rule__Deactivate__Group__0__Impl14316);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6892:1: rule__Deactivate__Group__1 : rule__Deactivate__Group__1__Impl ;
    public final void rule__Deactivate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6896:1: ( rule__Deactivate__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6897:2: rule__Deactivate__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Deactivate__Group__1__Impl_in_rule__Deactivate__Group__114346);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6903:1: rule__Deactivate__Group__1__Impl : ( ( rule__Deactivate__IdAssignment_1 ) ) ;
    public final void rule__Deactivate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6907:1: ( ( ( rule__Deactivate__IdAssignment_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6908:1: ( ( rule__Deactivate__IdAssignment_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6908:1: ( ( rule__Deactivate__IdAssignment_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6909:1: ( rule__Deactivate__IdAssignment_1 )
            {
             before(grammarAccess.getDeactivateAccess().getIdAssignment_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6910:1: ( rule__Deactivate__IdAssignment_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6910:2: rule__Deactivate__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__Deactivate__IdAssignment_1_in_rule__Deactivate__Group__1__Impl14373);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6924:1: rule__ParticipantCreation__Group__0 : rule__ParticipantCreation__Group__0__Impl rule__ParticipantCreation__Group__1 ;
    public final void rule__ParticipantCreation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6928:1: ( rule__ParticipantCreation__Group__0__Impl rule__ParticipantCreation__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6929:2: rule__ParticipantCreation__Group__0__Impl rule__ParticipantCreation__Group__1
            {
            pushFollow(FOLLOW_rule__ParticipantCreation__Group__0__Impl_in_rule__ParticipantCreation__Group__014407);
            rule__ParticipantCreation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParticipantCreation__Group__1_in_rule__ParticipantCreation__Group__014410);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6936:1: rule__ParticipantCreation__Group__0__Impl : ( Create ) ;
    public final void rule__ParticipantCreation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6940:1: ( ( Create ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6941:1: ( Create )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6941:1: ( Create )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6942:1: Create
            {
             before(grammarAccess.getParticipantCreationAccess().getCreateKeyword_0()); 
            match(input,Create,FOLLOW_Create_in_rule__ParticipantCreation__Group__0__Impl14438); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6955:1: rule__ParticipantCreation__Group__1 : rule__ParticipantCreation__Group__1__Impl ;
    public final void rule__ParticipantCreation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6959:1: ( rule__ParticipantCreation__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6960:2: rule__ParticipantCreation__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParticipantCreation__Group__1__Impl_in_rule__ParticipantCreation__Group__114469);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6966:1: rule__ParticipantCreation__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__ParticipantCreation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6970:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6971:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6971:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6972:1: RULE_ID
            {
             before(grammarAccess.getParticipantCreationAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParticipantCreation__Group__1__Impl14496); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6987:1: rule__Box__Group__0 : rule__Box__Group__0__Impl rule__Box__Group__1 ;
    public final void rule__Box__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6991:1: ( rule__Box__Group__0__Impl rule__Box__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6992:2: rule__Box__Group__0__Impl rule__Box__Group__1
            {
            pushFollow(FOLLOW_rule__Box__Group__0__Impl_in_rule__Box__Group__014529);
            rule__Box__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__1_in_rule__Box__Group__014532);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6999:1: rule__Box__Group__0__Impl : ( Box ) ;
    public final void rule__Box__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7003:1: ( ( Box ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7004:1: ( Box )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7004:1: ( Box )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7005:1: Box
            {
             before(grammarAccess.getBoxAccess().getBoxKeyword_0()); 
            match(input,Box,FOLLOW_Box_in_rule__Box__Group__0__Impl14560); 
             after(grammarAccess.getBoxAccess().getBoxKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__0__Impl"


    // $ANTLR start "rule__Box__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7018:1: rule__Box__Group__1 : rule__Box__Group__1__Impl rule__Box__Group__2 ;
    public final void rule__Box__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7022:1: ( rule__Box__Group__1__Impl rule__Box__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7023:2: rule__Box__Group__1__Impl rule__Box__Group__2
            {
            pushFollow(FOLLOW_rule__Box__Group__1__Impl_in_rule__Box__Group__114591);
            rule__Box__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__2_in_rule__Box__Group__114594);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7030:1: rule__Box__Group__1__Impl : ( QuotationMark ) ;
    public final void rule__Box__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7034:1: ( ( QuotationMark ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7035:1: ( QuotationMark )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7035:1: ( QuotationMark )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7036:1: QuotationMark
            {
             before(grammarAccess.getBoxAccess().getQuotationMarkKeyword_1()); 
            match(input,QuotationMark,FOLLOW_QuotationMark_in_rule__Box__Group__1__Impl14622); 
             after(grammarAccess.getBoxAccess().getQuotationMarkKeyword_1()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7049:1: rule__Box__Group__2 : rule__Box__Group__2__Impl rule__Box__Group__3 ;
    public final void rule__Box__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7053:1: ( rule__Box__Group__2__Impl rule__Box__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7054:2: rule__Box__Group__2__Impl rule__Box__Group__3
            {
            pushFollow(FOLLOW_rule__Box__Group__2__Impl_in_rule__Box__Group__214653);
            rule__Box__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__3_in_rule__Box__Group__214656);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7061:1: rule__Box__Group__2__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Box__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7065:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7066:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7066:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7067:1: ( RULE_ID )*
            {
             before(grammarAccess.getBoxAccess().getIDTerminalRuleCall_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7068:1: ( RULE_ID )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_ID) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7068:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Box__Group__2__Impl14684); 

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

             after(grammarAccess.getBoxAccess().getIDTerminalRuleCall_2()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7078:1: rule__Box__Group__3 : rule__Box__Group__3__Impl rule__Box__Group__4 ;
    public final void rule__Box__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7082:1: ( rule__Box__Group__3__Impl rule__Box__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7083:2: rule__Box__Group__3__Impl rule__Box__Group__4
            {
            pushFollow(FOLLOW_rule__Box__Group__3__Impl_in_rule__Box__Group__314715);
            rule__Box__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__4_in_rule__Box__Group__314718);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7090:1: rule__Box__Group__3__Impl : ( QuotationMark ) ;
    public final void rule__Box__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7094:1: ( ( QuotationMark ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7095:1: ( QuotationMark )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7095:1: ( QuotationMark )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7096:1: QuotationMark
            {
             before(grammarAccess.getBoxAccess().getQuotationMarkKeyword_3()); 
            match(input,QuotationMark,FOLLOW_QuotationMark_in_rule__Box__Group__3__Impl14746); 
             after(grammarAccess.getBoxAccess().getQuotationMarkKeyword_3()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7109:1: rule__Box__Group__4 : rule__Box__Group__4__Impl rule__Box__Group__5 ;
    public final void rule__Box__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7113:1: ( rule__Box__Group__4__Impl rule__Box__Group__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7114:2: rule__Box__Group__4__Impl rule__Box__Group__5
            {
            pushFollow(FOLLOW_rule__Box__Group__4__Impl_in_rule__Box__Group__414777);
            rule__Box__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__5_in_rule__Box__Group__414780);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7121:1: rule__Box__Group__4__Impl : ( ( ruleColor )? ) ;
    public final void rule__Box__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7125:1: ( ( ( ruleColor )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7126:1: ( ( ruleColor )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7126:1: ( ( ruleColor )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7127:1: ( ruleColor )?
            {
             before(grammarAccess.getBoxAccess().getColorParserRuleCall_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7128:1: ( ruleColor )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=LightGoldenRodYellow && LA56_0<=YellowGreen)||(LA56_0>=Aquamarine && LA56_0<=WhiteSmoke)||(LA56_0>=AliceBlue && LA56_0<=Turquoise)||(LA56_0>=Cornsilk && LA56_0<=SeaGreen)||(LA56_0>=Crimson && LA56_0<=Thistle)||(LA56_0>=Bisque && LA56_0<=Yellow)||(LA56_0>=Azure && LA56_0<=White)||(LA56_0>=Aqua && LA56_0<=Teal)||(LA56_0>=Red && LA56_0<=Tan)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7128:3: ruleColor
                    {
                    pushFollow(FOLLOW_ruleColor_in_rule__Box__Group__4__Impl14808);
                    ruleColor();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBoxAccess().getColorParserRuleCall_4()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7138:1: rule__Box__Group__5 : rule__Box__Group__5__Impl rule__Box__Group__6 ;
    public final void rule__Box__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7142:1: ( rule__Box__Group__5__Impl rule__Box__Group__6 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7143:2: rule__Box__Group__5__Impl rule__Box__Group__6
            {
            pushFollow(FOLLOW_rule__Box__Group__5__Impl_in_rule__Box__Group__514839);
            rule__Box__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__6_in_rule__Box__Group__514842);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7150:1: rule__Box__Group__5__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Box__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7154:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7155:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7155:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7156:1: RULE_NEWLINE
            {
             before(grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_5()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Box__Group__5__Impl14869); 
             after(grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_5()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7167:1: rule__Box__Group__6 : rule__Box__Group__6__Impl rule__Box__Group__7 ;
    public final void rule__Box__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7171:1: ( rule__Box__Group__6__Impl rule__Box__Group__7 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7172:2: rule__Box__Group__6__Impl rule__Box__Group__7
            {
            pushFollow(FOLLOW_rule__Box__Group__6__Impl_in_rule__Box__Group__614898);
            rule__Box__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__7_in_rule__Box__Group__614901);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7179:1: rule__Box__Group__6__Impl : ( ( rule__Box__Group_6__0 )* ) ;
    public final void rule__Box__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7183:1: ( ( ( rule__Box__Group_6__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7184:1: ( ( rule__Box__Group_6__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7184:1: ( ( rule__Box__Group_6__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7185:1: ( rule__Box__Group_6__0 )*
            {
             before(grammarAccess.getBoxAccess().getGroup_6()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7186:1: ( rule__Box__Group_6__0 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==Participant||LA57_0==Boundary||LA57_0==Database||LA57_0==Control||LA57_0==Entity||LA57_0==Actor||LA57_0==RULE_NEWLINE) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7186:2: rule__Box__Group_6__0
            	    {
            	    pushFollow(FOLLOW_rule__Box__Group_6__0_in_rule__Box__Group__6__Impl14928);
            	    rule__Box__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

             after(grammarAccess.getBoxAccess().getGroup_6()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7196:1: rule__Box__Group__7 : rule__Box__Group__7__Impl rule__Box__Group__8 ;
    public final void rule__Box__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7200:1: ( rule__Box__Group__7__Impl rule__Box__Group__8 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7201:2: rule__Box__Group__7__Impl rule__Box__Group__8
            {
            pushFollow(FOLLOW_rule__Box__Group__7__Impl_in_rule__Box__Group__714959);
            rule__Box__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__8_in_rule__Box__Group__714962);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7208:1: rule__Box__Group__7__Impl : ( End ) ;
    public final void rule__Box__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7212:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7213:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7213:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7214:1: End
            {
             before(grammarAccess.getBoxAccess().getEndKeyword_7()); 
            match(input,End,FOLLOW_End_in_rule__Box__Group__7__Impl14990); 
             after(grammarAccess.getBoxAccess().getEndKeyword_7()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7227:1: rule__Box__Group__8 : rule__Box__Group__8__Impl ;
    public final void rule__Box__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7231:1: ( rule__Box__Group__8__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7232:2: rule__Box__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__Box__Group__8__Impl_in_rule__Box__Group__815021);
            rule__Box__Group__8__Impl();

            state._fsp--;


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7238:1: rule__Box__Group__8__Impl : ( Box ) ;
    public final void rule__Box__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7242:1: ( ( Box ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7243:1: ( Box )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7243:1: ( Box )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7244:1: Box
            {
             before(grammarAccess.getBoxAccess().getBoxKeyword_8()); 
            match(input,Box,FOLLOW_Box_in_rule__Box__Group__8__Impl15049); 
             after(grammarAccess.getBoxAccess().getBoxKeyword_8()); 

            }


            }

        }
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


    // $ANTLR start "rule__Box__Group_6__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7275:1: rule__Box__Group_6__0 : rule__Box__Group_6__0__Impl rule__Box__Group_6__1 ;
    public final void rule__Box__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7279:1: ( rule__Box__Group_6__0__Impl rule__Box__Group_6__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7280:2: rule__Box__Group_6__0__Impl rule__Box__Group_6__1
            {
            pushFollow(FOLLOW_rule__Box__Group_6__0__Impl_in_rule__Box__Group_6__015098);
            rule__Box__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group_6__1_in_rule__Box__Group_6__015101);
            rule__Box__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group_6__0"


    // $ANTLR start "rule__Box__Group_6__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7287:1: rule__Box__Group_6__0__Impl : ( ( rule__Box__DefinitionsAssignment_6_0 )? ) ;
    public final void rule__Box__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7291:1: ( ( ( rule__Box__DefinitionsAssignment_6_0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7292:1: ( ( rule__Box__DefinitionsAssignment_6_0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7292:1: ( ( rule__Box__DefinitionsAssignment_6_0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7293:1: ( rule__Box__DefinitionsAssignment_6_0 )?
            {
             before(grammarAccess.getBoxAccess().getDefinitionsAssignment_6_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7294:1: ( rule__Box__DefinitionsAssignment_6_0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==Participant||LA58_0==Boundary||LA58_0==Database||LA58_0==Control||LA58_0==Entity||LA58_0==Actor) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7294:2: rule__Box__DefinitionsAssignment_6_0
                    {
                    pushFollow(FOLLOW_rule__Box__DefinitionsAssignment_6_0_in_rule__Box__Group_6__0__Impl15128);
                    rule__Box__DefinitionsAssignment_6_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBoxAccess().getDefinitionsAssignment_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group_6__0__Impl"


    // $ANTLR start "rule__Box__Group_6__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7304:1: rule__Box__Group_6__1 : rule__Box__Group_6__1__Impl ;
    public final void rule__Box__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7308:1: ( rule__Box__Group_6__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7309:2: rule__Box__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__Box__Group_6__1__Impl_in_rule__Box__Group_6__115159);
            rule__Box__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group_6__1"


    // $ANTLR start "rule__Box__Group_6__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7315:1: rule__Box__Group_6__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Box__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7319:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7320:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7320:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7321:1: RULE_NEWLINE
            {
             before(grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_6_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Box__Group_6__1__Impl15186); 
             after(grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group_6__1__Impl"


    // $ANTLR start "rule__Colors__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7336:1: rule__Colors__Group__0 : rule__Colors__Group__0__Impl rule__Colors__Group__1 ;
    public final void rule__Colors__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7340:1: ( rule__Colors__Group__0__Impl rule__Colors__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7341:2: rule__Colors__Group__0__Impl rule__Colors__Group__1
            {
            pushFollow(FOLLOW_rule__Colors__Group__0__Impl_in_rule__Colors__Group__015219);
            rule__Colors__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Colors__Group__1_in_rule__Colors__Group__015222);
            rule__Colors__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Colors__Group__0"


    // $ANTLR start "rule__Colors__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7348:1: rule__Colors__Group__0__Impl : ( NumberSign ) ;
    public final void rule__Colors__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7352:1: ( ( NumberSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7353:1: ( NumberSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7353:1: ( NumberSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7354:1: NumberSign
            {
             before(grammarAccess.getColorsAccess().getNumberSignKeyword_0()); 
            match(input,NumberSign,FOLLOW_NumberSign_in_rule__Colors__Group__0__Impl15250); 
             after(grammarAccess.getColorsAccess().getNumberSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Colors__Group__0__Impl"


    // $ANTLR start "rule__Colors__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7367:1: rule__Colors__Group__1 : rule__Colors__Group__1__Impl ;
    public final void rule__Colors__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7371:1: ( rule__Colors__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7372:2: rule__Colors__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Colors__Group__1__Impl_in_rule__Colors__Group__115281);
            rule__Colors__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Colors__Group__1"


    // $ANTLR start "rule__Colors__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7378:1: rule__Colors__Group__1__Impl : ( ( rule__Colors__Alternatives_1 ) ) ;
    public final void rule__Colors__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7382:1: ( ( ( rule__Colors__Alternatives_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7383:1: ( ( rule__Colors__Alternatives_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7383:1: ( ( rule__Colors__Alternatives_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7384:1: ( rule__Colors__Alternatives_1 )
            {
             before(grammarAccess.getColorsAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7385:1: ( rule__Colors__Alternatives_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7385:2: rule__Colors__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Colors__Alternatives_1_in_rule__Colors__Group__1__Impl15308);
            rule__Colors__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getColorsAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Colors__Group__1__Impl"


    // $ANTLR start "rule__Plantuml__DiagramsAssignment"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7400:1: rule__Plantuml__DiagramsAssignment : ( ruleDiagram ) ;
    public final void rule__Plantuml__DiagramsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7404:1: ( ( ruleDiagram ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7405:1: ( ruleDiagram )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7405:1: ( ruleDiagram )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7406:1: ruleDiagram
            {
             before(grammarAccess.getPlantumlAccess().getDiagramsDiagramParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDiagram_in_rule__Plantuml__DiagramsAssignment15347);
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


    // $ANTLR start "rule__Diagram__InstructionsAssignment_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7415:1: rule__Diagram__InstructionsAssignment_2 : ( ruleInstruction ) ;
    public final void rule__Diagram__InstructionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7419:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7420:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7420:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7421:1: ruleInstruction
            {
             before(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_215378);
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


    // $ANTLR start "rule__Arrow__NameAssignment_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7430:1: rule__Arrow__NameAssignment_0 : ( ruleMyID ) ;
    public final void rule__Arrow__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7434:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7435:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7435:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7436:1: ruleMyID
            {
             before(grammarAccess.getArrowAccess().getNameMyIDParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Arrow__NameAssignment_015409);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getNameMyIDParserRuleCall_0_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__Arrow__NamesAssignment_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7445:1: rule__Arrow__NamesAssignment_2 : ( ruleMyID ) ;
    public final void rule__Arrow__NamesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7449:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7450:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7450:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7451:1: ruleMyID
            {
             before(grammarAccess.getArrowAccess().getNamesMyIDParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Arrow__NamesAssignment_215440);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getNamesMyIDParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__NamesAssignment_2"


    // $ANTLR start "rule__Definition__NameAssignment_0_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7460:1: rule__Definition__NameAssignment_0_1 : ( ruleMyID ) ;
    public final void rule__Definition__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7464:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7465:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7465:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7466:1: ruleMyID
            {
             before(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_0_115471);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_0_1_0()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7475:1: rule__Definition__NameAssignment_1_1 : ( ruleMyID ) ;
    public final void rule__Definition__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7479:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7480:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7480:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7481:1: ruleMyID
            {
             before(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_1_115502);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_1_1_0()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7490:1: rule__Definition__NameAssignment_2_1 : ( ruleMyID ) ;
    public final void rule__Definition__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7494:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7495:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7495:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7496:1: ruleMyID
            {
             before(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_2_115533);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_2_1_0()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7505:1: rule__Definition__NameAssignment_3_1 : ( ruleMyID ) ;
    public final void rule__Definition__NameAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7509:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7510:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7510:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7511:1: ruleMyID
            {
             before(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_3_115564);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_3_1_0()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7520:1: rule__Definition__NameAssignment_4_1 : ( ruleMyID ) ;
    public final void rule__Definition__NameAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7524:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7525:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7525:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7526:1: ruleMyID
            {
             before(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_4_115595);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_4_1_0()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7535:1: rule__Definition__NameAssignment_5_1 : ( ruleMyID ) ;
    public final void rule__Definition__NameAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7539:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7540:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7540:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7541:1: ruleMyID
            {
             before(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_5_115626);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_5_1_0()); 

            }


            }

        }
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7550:1: rule__AltElse__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__AltElse__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7554:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7555:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7555:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7556:1: ruleInstruction
            {
             before(grammarAccess.getAltElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__AltElse__InstructionsAssignment_315657);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7565:1: rule__AltElse__ElsesAssignment_4 : ( ruleElse ) ;
    public final void rule__AltElse__ElsesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7569:1: ( ( ruleElse ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7570:1: ( ruleElse )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7570:1: ( ruleElse )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7571:1: ruleElse
            {
             before(grammarAccess.getAltElseAccess().getElsesElseParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleElse_in_rule__AltElse__ElsesAssignment_415688);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7580:1: rule__Else__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__Else__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7584:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7585:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7585:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7586:1: ruleInstruction
            {
             before(grammarAccess.getElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Else__InstructionsAssignment_315719);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7595:1: rule__GroupingMessages__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__GroupingMessages__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7599:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7600:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7600:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7601:1: ruleInstruction
            {
             before(grammarAccess.getGroupingMessagesAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__GroupingMessages__InstructionsAssignment_315750);
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


    // $ANTLR start "rule__Note__RidAssignment_1_0_1_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7610:1: rule__Note__RidAssignment_1_0_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__RidAssignment_1_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7614:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7615:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7615:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7616:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getRidDefinitionCrossReference_1_0_1_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7617:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7618:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getRidDefinitionIDTerminalRuleCall_1_0_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__RidAssignment_1_0_1_115785); 
             after(grammarAccess.getNoteAccess().getRidDefinitionIDTerminalRuleCall_1_0_1_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getRidDefinitionCrossReference_1_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__RidAssignment_1_0_1_1"


    // $ANTLR start "rule__Note__RidsAssignment_1_0_1_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7629:1: rule__Note__RidsAssignment_1_0_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__RidsAssignment_1_0_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7633:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7634:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7634:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7635:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getRidsDefinitionCrossReference_1_0_1_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7636:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7637:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getRidsDefinitionIDTerminalRuleCall_1_0_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__RidsAssignment_1_0_1_2_115824); 
             after(grammarAccess.getNoteAccess().getRidsDefinitionIDTerminalRuleCall_1_0_1_2_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getRidsDefinitionCrossReference_1_0_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__RidsAssignment_1_0_1_2_1"


    // $ANTLR start "rule__Note__LidAssignment_1_1_1_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7648:1: rule__Note__LidAssignment_1_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__LidAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7652:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7653:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7653:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7654:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getLidDefinitionCrossReference_1_1_1_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7655:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7656:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getLidDefinitionIDTerminalRuleCall_1_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__LidAssignment_1_1_1_115863); 
             after(grammarAccess.getNoteAccess().getLidDefinitionIDTerminalRuleCall_1_1_1_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getLidDefinitionCrossReference_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__LidAssignment_1_1_1_1"


    // $ANTLR start "rule__Note__LidsAssignment_1_1_1_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7667:1: rule__Note__LidsAssignment_1_1_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__LidsAssignment_1_1_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7671:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7672:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7672:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7673:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getLidsDefinitionCrossReference_1_1_1_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7674:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7675:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getLidsDefinitionIDTerminalRuleCall_1_1_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__LidsAssignment_1_1_1_2_115902); 
             after(grammarAccess.getNoteAccess().getLidsDefinitionIDTerminalRuleCall_1_1_1_2_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getLidsDefinitionCrossReference_1_1_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__LidsAssignment_1_1_1_2_1"


    // $ANTLR start "rule__Note__OidAssignment_1_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7686:1: rule__Note__OidAssignment_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__OidAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7690:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7691:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7691:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7692:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getOidDefinitionCrossReference_1_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7693:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7694:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getOidDefinitionIDTerminalRuleCall_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__OidAssignment_1_2_115941); 
             after(grammarAccess.getNoteAccess().getOidDefinitionIDTerminalRuleCall_1_2_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getOidDefinitionCrossReference_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__OidAssignment_1_2_1"


    // $ANTLR start "rule__Note__OidsAssignment_1_2_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7705:1: rule__Note__OidsAssignment_1_2_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__OidsAssignment_1_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7709:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7710:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7710:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7711:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getOidsDefinitionCrossReference_1_2_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7712:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7713:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getOidsDefinitionIDTerminalRuleCall_1_2_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__OidsAssignment_1_2_2_115980); 
             after(grammarAccess.getNoteAccess().getOidsDefinitionIDTerminalRuleCall_1_2_2_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getOidsDefinitionCrossReference_1_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__OidsAssignment_1_2_2_1"


    // $ANTLR start "rule__Reference__IdAssignment_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7724:1: rule__Reference__IdAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__IdAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7728:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7729:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7729:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7730:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAccess().getIdDefinitionCrossReference_2_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7731:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7732:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getIdDefinitionIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__IdAssignment_216019); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7743:1: rule__Reference__IdsAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__IdsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7747:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7748:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7748:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7749:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAccess().getIdsDefinitionCrossReference_3_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7750:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7751:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getIdsDefinitionIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__IdsAssignment_3_116058); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7762:1: rule__Activate__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Activate__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7766:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7767:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7767:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7768:1: RULE_ID
            {
             before(grammarAccess.getActivateAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Activate__NameAssignment_216093); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7777:1: rule__Deactivate__IdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Deactivate__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7781:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7782:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7782:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7783:1: ( RULE_ID )
            {
             before(grammarAccess.getDeactivateAccess().getIdActivateCrossReference_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7784:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7785:1: RULE_ID
            {
             before(grammarAccess.getDeactivateAccess().getIdActivateIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Deactivate__IdAssignment_116128); 
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


    // $ANTLR start "rule__Box__DefinitionsAssignment_6_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7796:1: rule__Box__DefinitionsAssignment_6_0 : ( ruleDefinition ) ;
    public final void rule__Box__DefinitionsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7800:1: ( ( ruleDefinition ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7801:1: ( ruleDefinition )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7801:1: ( ruleDefinition )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:7802:1: ruleDefinition
            {
             before(grammarAccess.getBoxAccess().getDefinitionsDefinitionParserRuleCall_6_0_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Box__DefinitionsAssignment_6_016163);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getBoxAccess().getDefinitionsDefinitionParserRuleCall_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__DefinitionsAssignment_6_0"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA2_eotS =
        "\46\uffff";
    static final String DFA2_eofS =
        "\46\uffff";
    static final String DFA2_minS =
        "\1\55\1\uffff\1\u00cd\2\u00c8\1\136\1\75\7\u00c8\1\u0099\1\u00ad"+
        "\1\171\1\4\2\u00cd\1\u00bd\21\uffff";
    static final String DFA2_maxS =
        "\1\u00d0\1\uffff\1\u00d0\1\u00cf\1\u00d0\1\u00cd\10\u00d0\3\u00cd"+
        "\3\u00d0\1\u00cd\21\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\23\uffff\1\2\1\12\1\14\1\15\1\21\1\3\1\4\1\5\1\7\1"+
        "\6\1\10\1\11\1\13\1\16\1\17\1\20\1\22";
    static final String DFA2_specialS =
        "\46\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\25\17\uffff\1\3\1\22\37\uffff\1\1\12\uffff\1\21\1\25\1\14"+
            "\1\25\12\uffff\1\25\1\23\1\1\1\7\13\uffff\1\1\1\2\1\25\1\5\14"+
            "\uffff\1\25\1\13\1\15\1\1\1\4\15\uffff\1\1\1\20\1\1\1\11\1\16"+
            "\1\1\1\27\2\uffff\1\6\1\24\1\1\1\10\1\12\1\17\1\30\1\uffff\1"+
            "\26\1\uffff\1\1\1\30\1\uffff\12\1\7\uffff\2\1",
            "",
            "\1\1\2\uffff\1\31",
            "\1\32\4\uffff\1\1\1\uffff\1\32",
            "\1\33\4\uffff\1\1\2\uffff\1\33",
            "\1\34\47\uffff\1\34\22\uffff\1\34\20\uffff\1\34\35\uffff\1"+
            "\34\4\uffff\1\1",
            "\2\35\37\uffff\1\35\12\uffff\1\35\1\uffff\1\35\14\uffff\3"+
            "\35\13\uffff\2\35\1\uffff\1\35\15\uffff\4\35\15\uffff\6\35\3"+
            "\uffff\6\35\4\uffff\1\35\2\uffff\13\35\4\uffff\1\1\1\uffff\2"+
            "\35",
            "\1\36\4\uffff\1\1\2\uffff\1\36",
            "\1\37\4\uffff\1\1\2\uffff\1\37",
            "\1\37\4\uffff\1\1\2\uffff\1\37",
            "\1\37\4\uffff\1\1\2\uffff\1\37",
            "\1\37\4\uffff\1\1\2\uffff\1\37",
            "\1\37\4\uffff\1\1\2\uffff\1\37",
            "\1\37\4\uffff\1\1\2\uffff\1\37",
            "\1\40\20\uffff\1\40\2\uffff\1\40\37\uffff\1\1",
            "\1\41\37\uffff\1\1",
            "\1\42\123\uffff\1\1",
            "\51\43\1\uffff\17\43\2\uffff\37\43\1\uffff\12\43\4\uffff\12"+
            "\43\4\uffff\13\43\4\uffff\14\43\5\uffff\15\43\7\uffff\2\43\34"+
            "\uffff\1\1\2\uffff\1\43",
            "\1\1\2\uffff\1\44",
            "\1\1\2\uffff\1\44",
            "\1\45\17\uffff\1\1",
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

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "989:1: rule__Instruction__Alternatives_0 : ( ( ruleArrow ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) | ( ruleAltElse ) | ( ruleGroupingMessages ) | ( ruleNote ) | ( ruleDivider ) | ( ruleReference ) | ( ruleDelay ) | ( ruleSpace ) | ( ruleHidefootbox ) | ( ruleActivate ) | ( ruleDeactivate ) | ( ruleParticipantCreation ) | ( ruleBox ) );";
        }
    }
    static final String DFA22_eotS =
        "\55\uffff";
    static final String DFA22_eofS =
        "\55\uffff";
    static final String DFA22_minS =
        "\2\75\1\uffff\51\75\1\uffff";
    static final String DFA22_maxS =
        "\2\u00d0\1\uffff\51\u00d0\1\uffff";
    static final String DFA22_acceptS =
        "\2\uffff\1\2\51\uffff\1\1";
    static final String DFA22_specialS =
        "\55\uffff}>";
    static final String[] DFA22_transitionS = {
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

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "3825:1: ( rule__Definition__Group_5_2_1__0 )?";
        }
    }
 

    public static final BitSet FOLLOW_rulePlantuml_in_entryRulePlantuml54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlantuml61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Plantuml__DiagramsAssignment_in_rulePlantuml91 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
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
    public static final BitSet FOLLOW_ruleEndID_in_entryRuleEndID377 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndID384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndID__Alternatives_in_ruleEndID414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_entryRuleMyID441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMyID448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MyID__Alternatives_in_ruleMyID478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber505 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAutoNumber512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0_in_ruleAutoNumber542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_entryRuleTitle569 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTitle576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__0_in_ruleTitle606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_entryRuleLegend633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLegend640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__0_in_ruleLegend670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_entryRuleNewpage697 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNewpage704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__0_in_ruleNewpage734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltElse_in_entryRuleAltElse761 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltElse768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__0_in_ruleAltElse798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_entryRuleElse825 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElse832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__0_in_ruleElse862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages889 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroupingMessages896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__0_in_ruleGroupingMessages926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_entryRuleNote953 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNote960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__0_in_ruleNote990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_entryRuleDivider1017 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDivider1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__0_in_ruleDivider1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0_in_ruleReference1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_entryRuleDelay1145 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDelay1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group__0_in_ruleDelay1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_entryRuleSpace1209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpace1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Alternatives_in_ruleSpace1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox1273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHidefootbox1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__0_in_ruleHidefootbox1310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivate_in_entryRuleActivate1337 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActivate1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__0_in_ruleActivate1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeactivate_in_entryRuleDeactivate1401 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeactivate1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__0_in_ruleDeactivate1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation1465 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParticipantCreation1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__0_in_ruleParticipantCreation1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBox_in_entryRuleBox1529 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBox1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__0_in_ruleBox1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColors_in_entryRuleColors1593 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColors1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Colors__Group__0_in_ruleColors1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_entryRuleColor1657 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColor1664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Color__Alternatives_in_ruleColor1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_rule__Instruction__Alternatives_01730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__0_in_rule__Instruction__Alternatives_01747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives_01765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_rule__Instruction__Alternatives_01782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_rule__Instruction__Alternatives_01799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives_01816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltElse_in_rule__Instruction__Alternatives_01833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_rule__Instruction__Alternatives_01850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_rule__Instruction__Alternatives_01867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_rule__Instruction__Alternatives_01884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rule__Instruction__Alternatives_01901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_rule__Instruction__Alternatives_01918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_rule__Instruction__Alternatives_01935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_rule__Instruction__Alternatives_01952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivate_in_rule__Instruction__Alternatives_01969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeactivate_in_rule__Instruction__Alternatives_01986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_rule__Instruction__Alternatives_02003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBox_in_rule__Instruction__Alternatives_02020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives2052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives2070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives2106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives2124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__0_in_rule__Definition__Alternatives2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EndID__Alternatives2176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_rule__EndID__Alternatives2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Autonumber_in_rule__EndID__Alternatives2214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_rule__EndID__Alternatives2234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Legend_in_rule__EndID__Alternatives2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Right_in_rule__EndID__Alternatives2274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Left_in_rule__EndID__Alternatives2294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Center_in_rule__EndID__Alternatives2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Endlegend_in_rule__EndID__Alternatives2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Alt_in_rule__EndID__Alternatives2354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_rule__EndID__Alternatives2374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newpage_in_rule__EndID__Alternatives2394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Opt_in_rule__EndID__Alternatives2414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Loop_in_rule__EndID__Alternatives2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Par_in_rule__EndID__Alternatives2454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Break_in_rule__EndID__Alternatives2474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Critical_in_rule__EndID__Alternatives2494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Group_in_rule__EndID__Alternatives2514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_rule__EndID__Alternatives2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Over_in_rule__EndID__Alternatives2554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Of_in_rule__EndID__Alternatives2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_rule__EndID__Alternatives2594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hide_in_rule__EndID__Alternatives2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Footbox_in_rule__EndID__Alternatives2634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Activate_in_rule__EndID__Alternatives2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Deactivate_in_rule__EndID__Alternatives2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Destroy_in_rule__EndID__Alternatives2694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_rule__EndID__Alternatives2714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NumberSign_in_rule__EndID__Alternatives2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__EndID__Alternatives2754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_rule__EndID__Alternatives2774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightParenthesis_in_rule__EndID__Alternatives2794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSign_in_rule__EndID__Alternatives2814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__EndID__Alternatives2833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HyphenMinus_in_rule__EndID__Alternatives2851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStop_in_rule__EndID__Alternatives2871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__EndID__Alternatives2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GreaterThanSign_in_rule__EndID__Alternatives2911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LessThanSign_in_rule__EndID__Alternatives2931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_rule__MyID__Alternatives2965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__MyID__Alternatives2983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Right_in_rule__Legend__Alternatives_13018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Left_in_rule__Legend__Alternatives_13038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Center_in_rule__Legend__Alternatives_13058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Opt_in_rule__GroupingMessages__Alternatives_03093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Loop_in_rule__GroupingMessages__Alternatives_03113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Par_in_rule__GroupingMessages__Alternatives_03133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Break_in_rule__GroupingMessages__Alternatives_03153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Critical_in_rule__GroupingMessages__Alternatives_03173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Group_in_rule__GroupingMessages__Alternatives_03193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__0_in_rule__Note__Alternatives_13227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__0_in_rule__Note__Alternatives_13245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__0_in_rule__Note__Alternatives_13263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__0_in_rule__Note__Alternatives_33296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__0_in_rule__Note__Alternatives_33314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__0_in_rule__Reference__Alternatives_43347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__0_in_rule__Reference__Alternatives_43365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLineVerticalLine_in_rule__Space__Alternatives3399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__0_in_rule__Space__Alternatives3418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Deactivate_in_rule__Deactivate__Alternatives_03452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Destroy_in_rule__Deactivate__Alternatives_03472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Colors__Alternatives_13506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXCODE_in_rule__Colors__Alternatives_13523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AliceBlue_in_rule__Color__Alternatives3556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AntiqueWhite_in_rule__Color__Alternatives3576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Aqua_in_rule__Color__Alternatives3596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Aquamarine_in_rule__Color__Alternatives3616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Azure_in_rule__Color__Alternatives3636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Beige_in_rule__Color__Alternatives3656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bisque_in_rule__Color__Alternatives3676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Black_in_rule__Color__Alternatives3696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlanchedAlmond_in_rule__Color__Alternatives3716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Blue_in_rule__Color__Alternatives3736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlueViolet_in_rule__Color__Alternatives3756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Brown_in_rule__Color__Alternatives3776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BurlyWood_in_rule__Color__Alternatives3796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CadetBlue_in_rule__Color__Alternatives3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Chartreuse_in_rule__Color__Alternatives3836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Chocolate_in_rule__Color__Alternatives3856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Coral_in_rule__Color__Alternatives3876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CornflowerBlue_in_rule__Color__Alternatives3896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Cornsilk_in_rule__Color__Alternatives3916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Crimson_in_rule__Color__Alternatives3936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Cyan_in_rule__Color__Alternatives3956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkBlue_in_rule__Color__Alternatives3976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkCyan_in_rule__Color__Alternatives3996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGoldenRod_in_rule__Color__Alternatives4016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGray_in_rule__Color__Alternatives4036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGreen_in_rule__Color__Alternatives4056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkGrey_in_rule__Color__Alternatives4076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkKhaki_in_rule__Color__Alternatives4096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkMagenta_in_rule__Color__Alternatives4116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkOliveGreen_in_rule__Color__Alternatives4136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkOrchid_in_rule__Color__Alternatives4156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkRed_in_rule__Color__Alternatives4176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSalmo_in_rule__Color__Alternatives4196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSeaGreen_in_rule__Color__Alternatives4216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateBlue_in_rule__Color__Alternatives4236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateGray_in_rule__Color__Alternatives4256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkSlateGrey_in_rule__Color__Alternatives4276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkTurquoise_in_rule__Color__Alternatives4296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DarkViolet_in_rule__Color__Alternatives4316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Darkorange_in_rule__Color__Alternatives4336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DeepPink_in_rule__Color__Alternatives4356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DeepSkyBlue_in_rule__Color__Alternatives4376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DimGray_in_rule__Color__Alternatives4396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DimGrey_in_rule__Color__Alternatives4416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DodgerBlue_in_rule__Color__Alternatives4436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FireBrick_in_rule__Color__Alternatives4456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FloralWhite_in_rule__Color__Alternatives4476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ForestGreen_in_rule__Color__Alternatives4496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Fuchsia_in_rule__Color__Alternatives4516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gainsboro_in_rule__Color__Alternatives4536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GhostWhite_in_rule__Color__Alternatives4556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gold_in_rule__Color__Alternatives4576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GoldenRod_in_rule__Color__Alternatives4596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Gray_in_rule__Color__Alternatives4616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Green_in_rule__Color__Alternatives4636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GreenYellow_in_rule__Color__Alternatives4656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Grey_in_rule__Color__Alternatives4676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HoneyDew_in_rule__Color__Alternatives4696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HotPink_in_rule__Color__Alternatives4716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IndianRed_in_rule__Color__Alternatives4736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Indigo_in_rule__Color__Alternatives4756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ivory_in_rule__Color__Alternatives4776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Khaki_in_rule__Color__Alternatives4796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lavender_in_rule__Color__Alternatives4816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LavenderBlush_in_rule__Color__Alternatives4836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LawnGreen_in_rule__Color__Alternatives4856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LemonChiffon_in_rule__Color__Alternatives4876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightBlue_in_rule__Color__Alternatives4896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightCoral_in_rule__Color__Alternatives4916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightCyan_in_rule__Color__Alternatives4936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGoldenRodYellow_in_rule__Color__Alternatives4956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGray_in_rule__Color__Alternatives4976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGreen_in_rule__Color__Alternatives4996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightGrey_in_rule__Color__Alternatives5016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightPink_in_rule__Color__Alternatives5036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSalmon_in_rule__Color__Alternatives5056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSeaGreen_in_rule__Color__Alternatives5076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSkyBlue_in_rule__Color__Alternatives5096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSlateGray_in_rule__Color__Alternatives5116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSlateGrey_in_rule__Color__Alternatives5136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightSteelBlue_in_rule__Color__Alternatives5156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LightYellow_in_rule__Color__Alternatives5176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lime_in_rule__Color__Alternatives5196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LimeGreen_in_rule__Color__Alternatives5216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Linen_in_rule__Color__Alternatives5236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Magenta_in_rule__Color__Alternatives5256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Maroon_in_rule__Color__Alternatives5276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumAquaMarine_in_rule__Color__Alternatives5296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumBlue_in_rule__Color__Alternatives5316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumOrchid_in_rule__Color__Alternatives5336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumPurple_in_rule__Color__Alternatives5356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSeaGreen_in_rule__Color__Alternatives5376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSlateBlue_in_rule__Color__Alternatives5396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumSpringGreen_in_rule__Color__Alternatives5416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumTurquoise_in_rule__Color__Alternatives5436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MediumVioletRed_in_rule__Color__Alternatives5456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MidnightBlue_in_rule__Color__Alternatives5476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MintCream_in_rule__Color__Alternatives5496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MistyRose_in_rule__Color__Alternatives5516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Moccasin_in_rule__Color__Alternatives5536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NavajoWhite_in_rule__Color__Alternatives5556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Navy_in_rule__Color__Alternatives5576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OldLace_in_rule__Color__Alternatives5596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Olive_in_rule__Color__Alternatives5616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OliveDrab_in_rule__Color__Alternatives5636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OrangeRed_in_rule__Color__Alternatives5656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Orchid_in_rule__Color__Alternatives5676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleGoldenRod_in_rule__Color__Alternatives5696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleGreen_in_rule__Color__Alternatives5716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleTurquoise_in_rule__Color__Alternatives5736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PaleVioletRed_in_rule__Color__Alternatives5756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PapayaWhip_in_rule__Color__Alternatives5776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PeachPuff_in_rule__Color__Alternatives5796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Peru_in_rule__Color__Alternatives5816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Pink_in_rule__Color__Alternatives5836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plum_in_rule__Color__Alternatives5856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PowderBlue_in_rule__Color__Alternatives5876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Purple_in_rule__Color__Alternatives5896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Red_in_rule__Color__Alternatives5916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RosyBrown_in_rule__Color__Alternatives5936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RoyalBlue_in_rule__Color__Alternatives5956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SaddleBrown_in_rule__Color__Alternatives5976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Salmon_in_rule__Color__Alternatives5996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SandyBrown_in_rule__Color__Alternatives6016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SeaGreen_in_rule__Color__Alternatives6036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Sienna_in_rule__Color__Alternatives6056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Silver_in_rule__Color__Alternatives6076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SkyBlue_in_rule__Color__Alternatives6096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateBlue_in_rule__Color__Alternatives6116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateGray_in_rule__Color__Alternatives6136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SlateGrey_in_rule__Color__Alternatives6156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Snow_in_rule__Color__Alternatives6176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SpringGreen_in_rule__Color__Alternatives6196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SteelBlue_in_rule__Color__Alternatives6216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Tan_in_rule__Color__Alternatives6236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Teal_in_rule__Color__Alternatives6256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Thistle_in_rule__Color__Alternatives6276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Tomato_in_rule__Color__Alternatives6296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Turquoise_in_rule__Color__Alternatives6316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Violet_in_rule__Color__Alternatives6336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Wheat_in_rule__Color__Alternatives6356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_White_in_rule__Color__Alternatives6376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WhiteSmoke_in_rule__Color__Alternatives6396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Yellow_in_rule__Color__Alternatives6416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_YellowGreen_in_rule__Color__Alternatives6436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__06468 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__06471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_START_in_rule__Diagram__Group__0__Impl6498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__16527 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000185FFL});
    public static final BitSet FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__16530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__1__Impl6557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__26586 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000185FFL});
    public static final BitSet FOLLOW_rule__Diagram__Group__3_in_rule__Diagram__Group__26589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__InstructionsAssignment_2_in_rule__Diagram__Group__2__Impl6616 = new BitSet(new long[]{0x6000200000000002L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__Diagram__Group__3__Impl_in_rule__Diagram__Group__36647 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Diagram__Group__4_in_rule__Diagram__Group__36650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_END_in_rule__Diagram__Group__3__Impl6677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__4__Impl_in_rule__Diagram__Group__46706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__4__Impl6734 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Instruction__Group__0__Impl_in_rule__Instruction__Group__06775 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__Instruction__Group__1_in_rule__Instruction__Group__06778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_0_in_rule__Instruction__Group__0__Impl6805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__1__Impl_in_rule__Instruction__Group__16836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Instruction__Group__1__Impl6863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__0__Impl_in_rule__Instruction__Group_0_1__06896 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__1_in_rule__Instruction__Group_0_1__06899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Instruction__Group_0_1__0__Impl6926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__1__Impl_in_rule__Instruction__Group_0_1__16955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColors_in_rule__Instruction__Group_0_1__1__Impl6983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__0__Impl_in_rule__Arrow__Group__07018 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Arrow__Group__1_in_rule__Arrow__Group__07021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__NameAssignment_0_in_rule__Arrow__Group__0__Impl7048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__1__Impl_in_rule__Arrow__Group__17078 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Arrow__Group__2_in_rule__Arrow__Group__17081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SEQUENCE_in_rule__Arrow__Group__1__Impl7108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__2__Impl_in_rule__Arrow__Group__27137 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Arrow__Group__3_in_rule__Arrow__Group__27140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__NamesAssignment_2_in_rule__Arrow__Group__2__Impl7167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__3__Impl_in_rule__Arrow__Group__37197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__0_in_rule__Arrow__Group__3__Impl7224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__0__Impl_in_rule__Arrow__Group_3__07263 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__1_in_rule__Arrow__Group_3__07266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Arrow__Group_3__0__Impl7294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__1__Impl_in_rule__Arrow__Group_3__17325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Arrow__Group_3__1__Impl7353 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__07388 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__07391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Actor_in_rule__Definition__Group_0__0__Impl7419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__17450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl7477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__07511 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__07514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boundary_in_rule__Definition__Group_1__0__Impl7542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__17573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl7600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__07634 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__07637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Control_in_rule__Definition__Group_2__0__Impl7665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__17696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl7723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__07757 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__07760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Entity_in_rule__Definition__Group_3__0__Impl7788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__17819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl7846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__07880 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__07883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Database_in_rule__Definition__Group_4__0__Impl7911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__17942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl7969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__0__Impl_in_rule__Definition__Group_5__08003 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Definition__Group_5__1_in_rule__Definition__Group_5__08006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Participant_in_rule__Definition__Group_5__0__Impl8034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__1__Impl_in_rule__Definition__Group_5__18065 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__2_in_rule__Definition__Group_5__18068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_5_1_in_rule__Definition__Group_5__1__Impl8095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__2__Impl_in_rule__Definition__Group_5__28125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__0_in_rule__Definition__Group_5__2__Impl8152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__0__Impl_in_rule__Definition__Group_5_2__08189 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xCC763F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__1_in_rule__Definition__Group_5_2__08192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LessThanSignLessThanSign_in_rule__Definition__Group_5_2__0__Impl8220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__1__Impl_in_rule__Definition__Group_5_2__18251 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xCC763F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__2_in_rule__Definition__Group_5_2__18254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__0_in_rule__Definition__Group_5_2__1__Impl8281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__2__Impl_in_rule__Definition__Group_5_2__28312 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xCC763F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__3_in_rule__Definition__Group_5_2__28315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_rule__Definition__Group_5_2__2__Impl8343 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0xC8763F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__3__Impl_in_rule__Definition__Group_5_2__38374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GreaterThanSignGreaterThanSign_in_rule__Definition__Group_5_2__3__Impl8402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__0__Impl_in_rule__Definition__Group_5_2_1__08441 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC8763F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__1_in_rule__Definition__Group_5_2_1__08444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_rule__Definition__Group_5_2_1__0__Impl8472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__1__Impl_in_rule__Definition__Group_5_2_1__18503 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__2_in_rule__Definition__Group_5_2_1__18506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_rule__Definition__Group_5_2_1__1__Impl8533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__2__Impl_in_rule__Definition__Group_5_2_1__28562 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__3_in_rule__Definition__Group_5_2_1__28565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Definition__Group_5_2_1__2__Impl8593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__3__Impl_in_rule__Definition__Group_5_2_1__38624 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__4_in_rule__Definition__Group_5_2_1__38627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NumberSign_in_rule__Definition__Group_5_2_1__3__Impl8655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__4__Impl_in_rule__Definition__Group_5_2_1__48686 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__5_in_rule__Definition__Group_5_2_1__48689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXCODE_in_rule__Definition__Group_5_2_1__4__Impl8716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__5__Impl_in_rule__Definition__Group_5_2_1__58745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightParenthesis_in_rule__Definition__Group_5_2_1__5__Impl8773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__08816 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__08819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Autonumber_in_rule__AutoNumber__Group__0__Impl8847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__18878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl8905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__08940 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__08943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl8970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__18999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl9027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__09062 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Title__Group__1_in_rule__Title__Group__09065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_rule__Title__Group__0__Impl9093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__19124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl9152 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__09187 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000040002000040L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__09190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Legend_in_rule__Legend__Group__0__Impl9218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__19249 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000040002000040L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__19252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl9279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__29310 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000040002000040L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__29313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__0_in_rule__Legend__Group__2__Impl9340 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__39371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Endlegend_in_rule__Legend__Group__3__Impl9399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__0__Impl_in_rule__Legend__Group_2__09438 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__1_in_rule__Legend__Group_2__09441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Legend__Group_2__0__Impl9468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__1__Impl_in_rule__Legend__Group_2__19497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Legend__Group_2__1__Impl9525 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__09560 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__09563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newpage_in_rule__Newpage__Group__0__Impl9591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__19622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl9650 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__AltElse__Group__0__Impl_in_rule__AltElse__Group__09685 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__AltElse__Group__1_in_rule__AltElse__Group__09688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Alt_in_rule__AltElse__Group__0__Impl9716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__1__Impl_in_rule__AltElse__Group__19747 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__AltElse__Group__2_in_rule__AltElse__Group__19750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__AltElse__Group__1__Impl9778 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__AltElse__Group__2__Impl_in_rule__AltElse__Group__29809 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__AltElse__Group__3_in_rule__AltElse__Group__29812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__AltElse__Group__2__Impl9839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__3__Impl_in_rule__AltElse__Group__39868 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__AltElse__Group__4_in_rule__AltElse__Group__39871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__InstructionsAssignment_3_in_rule__AltElse__Group__3__Impl9898 = new BitSet(new long[]{0x6000200000000002L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__AltElse__Group__4__Impl_in_rule__AltElse__Group__49929 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__AltElse__Group__5_in_rule__AltElse__Group__49932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__ElsesAssignment_4_in_rule__AltElse__Group__4__Impl9959 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_rule__AltElse__Group__5__Impl_in_rule__AltElse__Group__59990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__AltElse__Group__5__Impl10018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__0__Impl_in_rule__Else__Group__010061 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__Else__Group__1_in_rule__Else__Group__010064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_rule__Else__Group__0__Impl10092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__1__Impl_in_rule__Else__Group__110123 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__Else__Group__2_in_rule__Else__Group__110126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Else__Group__1__Impl10154 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Else__Group__2__Impl_in_rule__Else__Group__210185 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__Else__Group__3_in_rule__Else__Group__210188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Else__Group__2__Impl10215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__3__Impl_in_rule__Else__Group__310244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__InstructionsAssignment_3_in_rule__Else__Group__3__Impl10271 = new BitSet(new long[]{0x6000200000000002L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__0__Impl_in_rule__GroupingMessages__Group__010310 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010100L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__1_in_rule__GroupingMessages__Group__010313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Alternatives_0_in_rule__GroupingMessages__Group__0__Impl10340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__1__Impl_in_rule__GroupingMessages__Group__110370 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010100L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__2_in_rule__GroupingMessages__Group__110373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__GroupingMessages__Group__1__Impl10401 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__2__Impl_in_rule__GroupingMessages__Group__210432 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__3_in_rule__GroupingMessages__Group__210435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__GroupingMessages__Group__2__Impl10462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__3__Impl_in_rule__GroupingMessages__Group__310491 = new BitSet(new long[]{0x6000200000000000L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__4_in_rule__GroupingMessages__Group__310494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__InstructionsAssignment_3_in_rule__GroupingMessages__Group__3__Impl10521 = new BitSet(new long[]{0x6000200000000002L,0x07801E0040000000L,0xDAFE7F0007C003C0L,0x00000000000181FFL});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__4__Impl_in_rule__GroupingMessages__Group__410552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__GroupingMessages__Group__4__Impl10580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__0__Impl_in_rule__Note__Group__010621 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000240002000000L});
    public static final BitSet FOLLOW_rule__Note__Group__1_in_rule__Note__Group__010624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_rule__Note__Group__0__Impl10652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__1__Impl_in_rule__Note__Group__110683 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000110L});
    public static final BitSet FOLLOW_rule__Note__Group__2_in_rule__Note__Group__110686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Alternatives_1_in_rule__Note__Group__1__Impl10713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__2__Impl_in_rule__Note__Group__210743 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000110L});
    public static final BitSet FOLLOW_rule__Note__Group__3_in_rule__Note__Group__210746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Note__Group__2__Impl10774 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF2L,0xF87FE1FFBFFFFFFFL,0x000180FFF83FFC3FL});
    public static final BitSet FOLLOW_rule__Note__Group__3__Impl_in_rule__Note__Group__310805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Alternatives_3_in_rule__Note__Group__3__Impl10832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__0__Impl_in_rule__Note__Group_1_0__010870 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__1_in_rule__Note__Group_1_0__010873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Right_in_rule__Note__Group_1_0__0__Impl10901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__1__Impl_in_rule__Note__Group_1_0__110932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__0_in_rule__Note__Group_1_0__1__Impl10959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__0__Impl_in_rule__Note__Group_1_0_1__010994 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__1_in_rule__Note__Group_1_0_1__010997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Of_in_rule__Note__Group_1_0_1__0__Impl11025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__1__Impl_in_rule__Note__Group_1_0_1__111056 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__2_in_rule__Note__Group_1_0_1__111059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__RidAssignment_1_0_1_1_in_rule__Note__Group_1_0_1__1__Impl11086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__2__Impl_in_rule__Note__Group_1_0_1__211116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__0_in_rule__Note__Group_1_0_1__2__Impl11143 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__0__Impl_in_rule__Note__Group_1_0_1_2__011180 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__1_in_rule__Note__Group_1_0_1_2__011183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Note__Group_1_0_1_2__0__Impl11211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__1__Impl_in_rule__Note__Group_1_0_1_2__111242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__RidsAssignment_1_0_1_2_1_in_rule__Note__Group_1_0_1_2__1__Impl11269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__0__Impl_in_rule__Note__Group_1_1__011303 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__1_in_rule__Note__Group_1_1__011306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Left_in_rule__Note__Group_1_1__0__Impl11334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__1__Impl_in_rule__Note__Group_1_1__111365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__0_in_rule__Note__Group_1_1__1__Impl11392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__0__Impl_in_rule__Note__Group_1_1_1__011427 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__1_in_rule__Note__Group_1_1_1__011430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Of_in_rule__Note__Group_1_1_1__0__Impl11458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__1__Impl_in_rule__Note__Group_1_1_1__111489 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__2_in_rule__Note__Group_1_1_1__111492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__LidAssignment_1_1_1_1_in_rule__Note__Group_1_1_1__1__Impl11519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__2__Impl_in_rule__Note__Group_1_1_1__211549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__0_in_rule__Note__Group_1_1_1__2__Impl11576 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__0__Impl_in_rule__Note__Group_1_1_1_2__011613 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__1_in_rule__Note__Group_1_1_1_2__011616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Note__Group_1_1_1_2__0__Impl11644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__1__Impl_in_rule__Note__Group_1_1_1_2__111675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__LidsAssignment_1_1_1_2_1_in_rule__Note__Group_1_1_1_2__1__Impl11702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__0__Impl_in_rule__Note__Group_1_2__011736 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__1_in_rule__Note__Group_1_2__011739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Over_in_rule__Note__Group_1_2__0__Impl11767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__1__Impl_in_rule__Note__Group_1_2__111798 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__2_in_rule__Note__Group_1_2__111801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__OidAssignment_1_2_1_in_rule__Note__Group_1_2__1__Impl11828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__2__Impl_in_rule__Note__Group_1_2__211858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__0_in_rule__Note__Group_1_2__2__Impl11885 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__0__Impl_in_rule__Note__Group_1_2_2__011922 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__1_in_rule__Note__Group_1_2_2__011925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Note__Group_1_2_2__0__Impl11953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__1__Impl_in_rule__Note__Group_1_2_2__111984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__OidsAssignment_1_2_2_1_in_rule__Note__Group_1_2_2__1__Impl12011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__0__Impl_in_rule__Note__Group_3_0__012045 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__1_in_rule__Note__Group_3_0__012048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Note__Group_3_0__0__Impl12076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__1__Impl_in_rule__Note__Group_3_0__112107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Note__Group_3_0__1__Impl12135 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__0__Impl_in_rule__Note__Group_3_1__012170 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000980FFF83FFC3FL,0x0000000000000110L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__1_in_rule__Note__Group_3_1__012173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__0_in_rule__Note__Group_3_1__0__Impl12200 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__1__Impl_in_rule__Note__Group_3_1__112231 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__2_in_rule__Note__Group_3_1__112234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__Note__Group_3_1__1__Impl12262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__2__Impl_in_rule__Note__Group_3_1__212293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_rule__Note__Group_3_1__2__Impl12321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__0__Impl_in_rule__Note__Group_3_1_0__012358 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC8763F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__1_in_rule__Note__Group_3_1_0__012361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Note__Group_3_1_0__0__Impl12388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__1__Impl_in_rule__Note__Group_3_1_0__112417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_rule__Note__Group_3_1_0__1__Impl12445 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0xC8763F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Divider__Group__0__Impl_in_rule__Divider__Group__012480 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Divider__Group__1_in_rule__Divider__Group__012483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__0__Impl12511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__1__Impl_in_rule__Divider__Group__112542 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Divider__Group__2_in_rule__Divider__Group__112545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Divider__Group__1__Impl12573 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Divider__Group__2__Impl_in_rule__Divider__Group__212604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__2__Impl12632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__012669 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__012672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_rule__Reference__Group__0__Impl12700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__112731 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__112734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Over_in_rule__Reference__Group__1__Impl12762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__2__Impl_in_rule__Reference__Group__212793 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L,0x0000000000000112L});
    public static final BitSet FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__212796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__IdAssignment_2_in_rule__Reference__Group__2__Impl12823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__3__Impl_in_rule__Reference__Group__312853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L,0x0000000000000112L});
    public static final BitSet FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__312856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__0_in_rule__Reference__Group__3__Impl12883 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__4__Impl_in_rule__Reference__Group__412914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Alternatives_4_in_rule__Reference__Group__4__Impl12941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__0__Impl_in_rule__Reference__Group_3__012981 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__1_in_rule__Reference__Group_3__012984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Reference__Group_3__0__Impl13012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__1__Impl_in_rule__Reference__Group_3__113043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__IdsAssignment_3_1_in_rule__Reference__Group_3__1__Impl13070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__0__Impl_in_rule__Reference__Group_4_0__013104 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__1_in_rule__Reference__Group_4_0__013107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Reference__Group_4_0__0__Impl13135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__1__Impl_in_rule__Reference__Group_4_0__113166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Reference__Group_4_0__1__Impl13194 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0xC87E3F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__0__Impl_in_rule__Reference__Group_4_1__013229 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L,0x0000000000000112L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__1_in_rule__Reference__Group_4_1__013232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__0_in_rule__Reference__Group_4_1__0__Impl13259 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__1__Impl_in_rule__Reference__Group_4_1__113290 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__2_in_rule__Reference__Group_4_1__113293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__Reference__Group_4_1__1__Impl13321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__2__Impl_in_rule__Reference__Group_4_1__213352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_rule__Reference__Group_4_1__2__Impl13380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__0__Impl_in_rule__Reference__Group_4_1_0__013417 = new BitSet(new long[]{0x6000000000000000L,0x07000A0040000000L,0xC8763F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__1_in_rule__Reference__Group_4_1_0__013420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Reference__Group_4_1_0__0__Impl13447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__1__Impl_in_rule__Reference__Group_4_1_0__113476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_rule__Reference__Group_4_1_0__1__Impl13504 = new BitSet(new long[]{0x6000000000000002L,0x07000A0040000000L,0xC8763F00078002C0L,0x00000000000180FFL});
    public static final BitSet FOLLOW_rule__Delay__Group__0__Impl_in_rule__Delay__Group__013539 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000400000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Delay__Group__1_in_rule__Delay__Group__013542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group__0__Impl13570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group__1__Impl_in_rule__Delay__Group__113601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__0_in_rule__Delay__Group__1__Impl13628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__0__Impl_in_rule__Delay__Group_1__013663 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000400000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__1_in_rule__Delay__Group_1__013666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Delay__Group_1__0__Impl13694 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__1__Impl_in_rule__Delay__Group_1__113725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group_1__1__Impl13753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__0__Impl_in_rule__Space__Group_1__013788 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Space__Group_1__1_in_rule__Space__Group_1__013791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__0__Impl13819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__1__Impl_in_rule__Space__Group_1__113850 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_rule__Space__Group_1__2_in_rule__Space__Group_1__113853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Space__Group_1__1__Impl13880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__2__Impl_in_rule__Space__Group_1__213909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__2__Impl13937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__0__Impl_in_rule__Hidefootbox__Group__013974 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__1_in_rule__Hidefootbox__Group__013977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hide_in_rule__Hidefootbox__Group__0__Impl14005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__1__Impl_in_rule__Hidefootbox__Group__114036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Footbox_in_rule__Hidefootbox__Group__1__Impl14064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__0__Impl_in_rule__Activate__Group__014099 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000180FFF83FFC3FL,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Activate__Group__1_in_rule__Activate__Group__014102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Activate_in_rule__Activate__Group__0__Impl14130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__1__Impl_in_rule__Activate__Group__114161 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000180FFF83FFC3FL,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Activate__Group__2_in_rule__Activate__Group__114164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Activate__Group__1__Impl14192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__2__Impl_in_rule__Activate__Group__214223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__NameAssignment_2_in_rule__Activate__Group__2__Impl14250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__0__Impl_in_rule__Deactivate__Group__014286 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__1_in_rule__Deactivate__Group__014289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Alternatives_0_in_rule__Deactivate__Group__0__Impl14316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__1__Impl_in_rule__Deactivate__Group__114346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__IdAssignment_1_in_rule__Deactivate__Group__1__Impl14373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__0__Impl_in_rule__ParticipantCreation__Group__014407 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__1_in_rule__ParticipantCreation__Group__014410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_rule__ParticipantCreation__Group__0__Impl14438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__1__Impl_in_rule__ParticipantCreation__Group__114469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParticipantCreation__Group__1__Impl14496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__0__Impl_in_rule__Box__Group__014529 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_rule__Box__Group__1_in_rule__Box__Group__014532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_rule__Box__Group__0__Impl14560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__1__Impl_in_rule__Box__Group__114591 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Box__Group__2_in_rule__Box__Group__114594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QuotationMark_in_rule__Box__Group__1__Impl14622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__2__Impl_in_rule__Box__Group__214653 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Box__Group__3_in_rule__Box__Group__214656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Box__Group__2__Impl14684 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Box__Group__3__Impl_in_rule__Box__Group__314715 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000180FFF83FFC3FL,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Box__Group__4_in_rule__Box__Group__314718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QuotationMark_in_rule__Box__Group__3__Impl14746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__4__Impl_in_rule__Box__Group__414777 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000180FFF83FFC3FL,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Box__Group__5_in_rule__Box__Group__414780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColor_in_rule__Box__Group__4__Impl14808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__5__Impl_in_rule__Box__Group__514839 = new BitSet(new long[]{0x0000200000000000L,0x0080140000000000L,0x0008000000400100L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Box__Group__6_in_rule__Box__Group__514842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Box__Group__5__Impl14869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__6__Impl_in_rule__Box__Group__614898 = new BitSet(new long[]{0x0000200000000000L,0x0080140000000000L,0x0008000000400100L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Box__Group__7_in_rule__Box__Group__614901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group_6__0_in_rule__Box__Group__6__Impl14928 = new BitSet(new long[]{0x0000200000000002L,0x0080140000000000L,0x0000000000400100L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Box__Group__7__Impl_in_rule__Box__Group__714959 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_rule__Box__Group__8_in_rule__Box__Group__714962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__Box__Group__7__Impl14990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__8__Impl_in_rule__Box__Group__815021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_rule__Box__Group__8__Impl15049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group_6__0__Impl_in_rule__Box__Group_6__015098 = new BitSet(new long[]{0x0000200000000000L,0x0080140000000000L,0x0000000000400100L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Box__Group_6__1_in_rule__Box__Group_6__015101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__DefinitionsAssignment_6_0_in_rule__Box__Group_6__0__Impl15128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group_6__1__Impl_in_rule__Box__Group_6__115159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Box__Group_6__1__Impl15186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Colors__Group__0__Impl_in_rule__Colors__Group__015219 = new BitSet(new long[]{0x9FFFDFFFFFFFFFF0L,0xF87FE1FFBFFFFFFFL,0x000180FFF83FFC3FL,0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Colors__Group__1_in_rule__Colors__Group__015222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NumberSign_in_rule__Colors__Group__0__Impl15250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Colors__Group__1__Impl_in_rule__Colors__Group__115281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Colors__Alternatives_1_in_rule__Colors__Group__1__Impl15308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_rule__Plantuml__DiagramsAssignment15347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_215378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Arrow__NameAssignment_015409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Arrow__NamesAssignment_215440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_0_115471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_1_115502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_2_115533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_3_115564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_4_115595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_5_115626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__AltElse__InstructionsAssignment_315657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_rule__AltElse__ElsesAssignment_415688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Else__InstructionsAssignment_315719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__GroupingMessages__InstructionsAssignment_315750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__RidAssignment_1_0_1_115785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__RidsAssignment_1_0_1_2_115824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__LidAssignment_1_1_1_115863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__LidsAssignment_1_1_1_2_115902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__OidAssignment_1_2_115941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__OidsAssignment_1_2_2_115980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__IdAssignment_216019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__IdsAssignment_3_116058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Activate__NameAssignment_216093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Deactivate__IdAssignment_116128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Box__DefinitionsAssignment_6_016163 = new BitSet(new long[]{0x0000000000000002L});

}