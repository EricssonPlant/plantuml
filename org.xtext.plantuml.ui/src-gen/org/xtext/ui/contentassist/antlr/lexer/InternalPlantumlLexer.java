package org.xtext.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPlantumlLexer extends Lexer {
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

    public InternalPlantumlLexer() {;} 
    public InternalPlantumlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalPlantumlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g"; }

    // $ANTLR start "LightGoldenRodYellow"
    public final void mLightGoldenRodYellow() throws RecognitionException {
        try {
            int _type = LightGoldenRodYellow;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:19:22: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'Y' | 'y' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:19:24: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'Y' | 'y' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightGoldenRodYellow"

    // $ANTLR start "MediumSpringGreen"
    public final void mMediumSpringGreen() throws RecognitionException {
        try {
            int _type = MediumSpringGreen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:21:19: ( ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'S' | 's' ) ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'G' | 'g' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:21:21: ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'S' | 's' ) ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'G' | 'g' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MediumSpringGreen"

    // $ANTLR start "MediumAquaMarine"
    public final void mMediumAquaMarine() throws RecognitionException {
        try {
            int _type = MediumAquaMarine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:23:18: ( ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:23:20: ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MediumAquaMarine"

    // $ANTLR start "MediumSlateBlue"
    public final void mMediumSlateBlue() throws RecognitionException {
        try {
            int _type = MediumSlateBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:25:17: ( ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:25:19: ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MediumSlateBlue"

    // $ANTLR start "MediumTurquoise"
    public final void mMediumTurquoise() throws RecognitionException {
        try {
            int _type = MediumTurquoise;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:27:17: ( ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'O' | 'o' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:27:19: ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'O' | 'o' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MediumTurquoise"

    // $ANTLR start "MediumVioletRed"
    public final void mMediumVioletRed() throws RecognitionException {
        try {
            int _type = MediumVioletRed;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:29:17: ( ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:29:19: ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MediumVioletRed"

    // $ANTLR start "BlanchedAlmond"
    public final void mBlanchedAlmond() throws RecognitionException {
        try {
            int _type = BlanchedAlmond;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:31:16: ( ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:31:18: ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BlanchedAlmond"

    // $ANTLR start "CornflowerBlue"
    public final void mCornflowerBlue() throws RecognitionException {
        try {
            int _type = CornflowerBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:33:16: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'N' | 'n' ) ( 'F' | 'f' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:33:18: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'N' | 'n' ) ( 'F' | 'f' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CornflowerBlue"

    // $ANTLR start "DarkOliveGreen"
    public final void mDarkOliveGreen() throws RecognitionException {
        try {
            int _type = DarkOliveGreen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:35:16: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:35:18: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkOliveGreen"

    // $ANTLR start "LightSlateGray"
    public final void mLightSlateGray() throws RecognitionException {
        try {
            int _type = LightSlateGray;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:37:16: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:37:18: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightSlateGray"

    // $ANTLR start "LightSlateGrey"
    public final void mLightSlateGrey() throws RecognitionException {
        try {
            int _type = LightSlateGrey;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:39:16: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:39:18: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightSlateGrey"

    // $ANTLR start "LightSteelBlue"
    public final void mLightSteelBlue() throws RecognitionException {
        try {
            int _type = LightSteelBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:41:16: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:41:18: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightSteelBlue"

    // $ANTLR start "MediumSeaGreen"
    public final void mMediumSeaGreen() throws RecognitionException {
        try {
            int _type = MediumSeaGreen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:43:16: ( ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:43:18: ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MediumSeaGreen"

    // $ANTLR start "DarkGoldenRod"
    public final void mDarkGoldenRod() throws RecognitionException {
        try {
            int _type = DarkGoldenRod;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:45:15: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:45:17: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkGoldenRod"

    // $ANTLR start "DarkSlateBlue"
    public final void mDarkSlateBlue() throws RecognitionException {
        try {
            int _type = DarkSlateBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:47:15: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:47:17: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkSlateBlue"

    // $ANTLR start "DarkSlateGray"
    public final void mDarkSlateGray() throws RecognitionException {
        try {
            int _type = DarkSlateGray;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:49:15: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:49:17: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkSlateGray"

    // $ANTLR start "DarkSlateGrey"
    public final void mDarkSlateGrey() throws RecognitionException {
        try {
            int _type = DarkSlateGrey;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:51:15: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:51:17: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkSlateGrey"

    // $ANTLR start "DarkTurquoise"
    public final void mDarkTurquoise() throws RecognitionException {
        try {
            int _type = DarkTurquoise;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:53:15: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'O' | 'o' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:53:17: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'O' | 'o' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkTurquoise"

    // $ANTLR start "LavenderBlush"
    public final void mLavenderBlush() throws RecognitionException {
        try {
            int _type = LavenderBlush;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:55:15: ( ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'S' | 's' ) ( 'H' | 'h' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:55:17: ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'S' | 's' ) ( 'H' | 'h' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LavenderBlush"

    // $ANTLR start "LightSeaGreen"
    public final void mLightSeaGreen() throws RecognitionException {
        try {
            int _type = LightSeaGreen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:57:15: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:57:17: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightSeaGreen"

    // $ANTLR start "PaleGoldenRod"
    public final void mPaleGoldenRod() throws RecognitionException {
        try {
            int _type = PaleGoldenRod;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:59:15: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:59:17: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PaleGoldenRod"

    // $ANTLR start "PaleTurquoise"
    public final void mPaleTurquoise() throws RecognitionException {
        try {
            int _type = PaleTurquoise;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:61:15: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'O' | 'o' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:61:17: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'O' | 'o' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PaleTurquoise"

    // $ANTLR start "PaleVioletRed"
    public final void mPaleVioletRed() throws RecognitionException {
        try {
            int _type = PaleVioletRed;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:63:15: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:63:17: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PaleVioletRed"

    // $ANTLR start "AntiqueWhite"
    public final void mAntiqueWhite() throws RecognitionException {
        try {
            int _type = AntiqueWhite;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:65:14: ( ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:65:16: ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AntiqueWhite"

    // $ANTLR start "DarkSeaGreen"
    public final void mDarkSeaGreen() throws RecognitionException {
        try {
            int _type = DarkSeaGreen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:67:14: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:67:16: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkSeaGreen"

    // $ANTLR start "LemonChiffon"
    public final void mLemonChiffon() throws RecognitionException {
        try {
            int _type = LemonChiffon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:69:14: ( ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:69:16: ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LemonChiffon"

    // $ANTLR start "LightSkyBlue"
    public final void mLightSkyBlue() throws RecognitionException {
        try {
            int _type = LightSkyBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:71:14: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'S' | 's' ) ( 'K' | 'k' ) ( 'Y' | 'y' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:71:16: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'S' | 's' ) ( 'K' | 'k' ) ( 'Y' | 'y' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightSkyBlue"

    // $ANTLR start "MediumOrchid"
    public final void mMediumOrchid() throws RecognitionException {
        try {
            int _type = MediumOrchid;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:73:14: ( ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:73:16: ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MediumOrchid"

    // $ANTLR start "MediumPurple"
    public final void mMediumPurple() throws RecognitionException {
        try {
            int _type = MediumPurple;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:75:14: ( ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'P' | 'p' ) ( 'L' | 'l' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:75:16: ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'P' | 'p' ) ( 'L' | 'l' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MediumPurple"

    // $ANTLR start "MidnightBlue"
    public final void mMidnightBlue() throws RecognitionException {
        try {
            int _type = MidnightBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:77:14: ( ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'D' | 'd' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:77:16: ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'D' | 'd' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MidnightBlue"

    // $ANTLR start "DarkMagenta"
    public final void mDarkMagenta() throws RecognitionException {
        try {
            int _type = DarkMagenta;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:79:13: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'A' | 'a' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:79:15: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'A' | 'a' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkMagenta"

    // $ANTLR start "DeepSkyBlue"
    public final void mDeepSkyBlue() throws RecognitionException {
        try {
            int _type = DeepSkyBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:81:13: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'P' | 'p' ) ( 'S' | 's' ) ( 'K' | 'k' ) ( 'Y' | 'y' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:81:15: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'P' | 'p' ) ( 'S' | 's' ) ( 'K' | 'k' ) ( 'Y' | 'y' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DeepSkyBlue"

    // $ANTLR start "FloralWhite"
    public final void mFloralWhite() throws RecognitionException {
        try {
            int _type = FloralWhite;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:83:13: ( ( 'F' | 'f' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:83:15: ( 'F' | 'f' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FloralWhite"

    // $ANTLR start "ForestGreen"
    public final void mForestGreen() throws RecognitionException {
        try {
            int _type = ForestGreen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:85:13: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:85:15: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ForestGreen"

    // $ANTLR start "GreenYellow"
    public final void mGreenYellow() throws RecognitionException {
        try {
            int _type = GreenYellow;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:87:13: ( ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'Y' | 'y' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:87:15: ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'Y' | 'y' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreenYellow"

    // $ANTLR start "LightSalmon"
    public final void mLightSalmon() throws RecognitionException {
        try {
            int _type = LightSalmon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:89:13: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'S' | 's' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:89:15: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'S' | 's' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightSalmon"

    // $ANTLR start "LightYellow"
    public final void mLightYellow() throws RecognitionException {
        try {
            int _type = LightYellow;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:91:13: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'Y' | 'y' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:91:15: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'Y' | 'y' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightYellow"

    // $ANTLR start "NavajoWhite"
    public final void mNavajoWhite() throws RecognitionException {
        try {
            int _type = NavajoWhite;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:93:13: ( ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'J' | 'j' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:93:15: ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'J' | 'j' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NavajoWhite"

    // $ANTLR start "SaddleBrown"
    public final void mSaddleBrown() throws RecognitionException {
        try {
            int _type = SaddleBrown;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:95:13: ( ( 'S' | 's' ) ( 'A' | 'a' ) ( 'D' | 'd' ) ( 'D' | 'd' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:95:15: ( 'S' | 's' ) ( 'A' | 'a' ) ( 'D' | 'd' ) ( 'D' | 'd' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SaddleBrown"

    // $ANTLR start "SpringGreen"
    public final void mSpringGreen() throws RecognitionException {
        try {
            int _type = SpringGreen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:97:13: ( ( 'S' | 's' ) ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'G' | 'g' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:97:15: ( 'S' | 's' ) ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'G' | 'g' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SpringGreen"

    // $ANTLR start "YellowGreen"
    public final void mYellowGreen() throws RecognitionException {
        try {
            int _type = YellowGreen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:99:13: ( ( 'Y' | 'y' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:99:15: ( 'Y' | 'y' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "YellowGreen"

    // $ANTLR start "Participant"
    public final void mParticipant() throws RecognitionException {
        try {
            int _type = Participant;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:101:13: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'I' | 'i' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:101:15: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'I' | 'i' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Participant"

    // $ANTLR start "Aquamarine"
    public final void mAquamarine() throws RecognitionException {
        try {
            int _type = Aquamarine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:103:12: ( ( 'A' | 'a' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:103:14: ( 'A' | 'a' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Aquamarine"

    // $ANTLR start "BlueViolet"
    public final void mBlueViolet() throws RecognitionException {
        try {
            int _type = BlueViolet;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:105:12: ( ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'T' | 't' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:105:14: ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BlueViolet"

    // $ANTLR start "Chartreuse"
    public final void mChartreuse() throws RecognitionException {
        try {
            int _type = Chartreuse;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:107:12: ( ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'U' | 'u' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:107:14: ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'U' | 'u' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Chartreuse"

    // $ANTLR start "DarkOrchid"
    public final void mDarkOrchid() throws RecognitionException {
        try {
            int _type = DarkOrchid;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:109:12: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:109:14: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkOrchid"

    // $ANTLR start "DarkViolet"
    public final void mDarkViolet() throws RecognitionException {
        try {
            int _type = DarkViolet;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:111:12: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'T' | 't' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:111:14: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkViolet"

    // $ANTLR start "Darkorange"
    public final void mDarkorange() throws RecognitionException {
        try {
            int _type = Darkorange;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:113:12: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G' | 'g' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:113:14: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G' | 'g' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Darkorange"

    // $ANTLR start "DodgerBlue"
    public final void mDodgerBlue() throws RecognitionException {
        try {
            int _type = DodgerBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:115:12: ( ( 'D' | 'd' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:115:14: ( 'D' | 'd' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DodgerBlue"

    // $ANTLR start "GhostWhite"
    public final void mGhostWhite() throws RecognitionException {
        try {
            int _type = GhostWhite;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:117:12: ( ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:117:14: ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GhostWhite"

    // $ANTLR start "LightCoral"
    public final void mLightCoral() throws RecognitionException {
        try {
            int _type = LightCoral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:119:12: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:119:14: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightCoral"

    // $ANTLR start "LightGreen"
    public final void mLightGreen() throws RecognitionException {
        try {
            int _type = LightGreen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:121:12: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:121:14: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightGreen"

    // $ANTLR start "MediumBlue"
    public final void mMediumBlue() throws RecognitionException {
        try {
            int _type = MediumBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:123:12: ( ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:123:14: ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MediumBlue"

    // $ANTLR start "PapayaWhip"
    public final void mPapayaWhip() throws RecognitionException {
        try {
            int _type = PapayaWhip;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:125:12: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'Y' | 'y' ) ( 'A' | 'a' ) ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'P' | 'p' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:125:14: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'Y' | 'y' ) ( 'A' | 'a' ) ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'P' | 'p' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PapayaWhip"

    // $ANTLR start "PowderBlue"
    public final void mPowderBlue() throws RecognitionException {
        try {
            int _type = PowderBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:127:12: ( ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:127:14: ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PowderBlue"

    // $ANTLR start "SandyBrown"
    public final void mSandyBrown() throws RecognitionException {
        try {
            int _type = SandyBrown;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:129:12: ( ( 'S' | 's' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'Y' | 'y' ) ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:129:14: ( 'S' | 's' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'Y' | 'y' ) ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SandyBrown"

    // $ANTLR start "WhiteSmoke"
    public final void mWhiteSmoke() throws RecognitionException {
        try {
            int _type = WhiteSmoke;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:131:12: ( ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'K' | 'k' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:131:14: ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'K' | 'k' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WhiteSmoke"

    // $ANTLR start "Autonumber"
    public final void mAutonumber() throws RecognitionException {
        try {
            int _type = Autonumber;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:133:12: ( ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:133:14: ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Autonumber"

    // $ANTLR start "Deactivate"
    public final void mDeactivate() throws RecognitionException {
        try {
            int _type = Deactivate;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:135:12: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:135:14: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Deactivate"

    // $ANTLR start "AliceBlue"
    public final void mAliceBlue() throws RecognitionException {
        try {
            int _type = AliceBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:137:11: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:137:13: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AliceBlue"

    // $ANTLR start "BurlyWood"
    public final void mBurlyWood() throws RecognitionException {
        try {
            int _type = BurlyWood;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:139:11: ( ( 'B' | 'b' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'L' | 'l' ) ( 'Y' | 'y' ) ( 'W' | 'w' ) ( 'O' | 'o' ) ( 'O' | 'o' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:139:13: ( 'B' | 'b' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'L' | 'l' ) ( 'Y' | 'y' ) ( 'W' | 'w' ) ( 'O' | 'o' ) ( 'O' | 'o' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BurlyWood"

    // $ANTLR start "CadetBlue"
    public final void mCadetBlue() throws RecognitionException {
        try {
            int _type = CadetBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:141:11: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:141:13: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CadetBlue"

    // $ANTLR start "Chocolate"
    public final void mChocolate() throws RecognitionException {
        try {
            int _type = Chocolate;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:143:11: ( ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:143:13: ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Chocolate"

    // $ANTLR start "DarkGreen"
    public final void mDarkGreen() throws RecognitionException {
        try {
            int _type = DarkGreen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:145:11: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:145:13: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkGreen"

    // $ANTLR start "DarkKhaki"
    public final void mDarkKhaki() throws RecognitionException {
        try {
            int _type = DarkKhaki;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:147:11: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'K' | 'k' ) ( 'H' | 'h' ) ( 'A' | 'a' ) ( 'K' | 'k' ) ( 'I' | 'i' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:147:13: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'K' | 'k' ) ( 'H' | 'h' ) ( 'A' | 'a' ) ( 'K' | 'k' ) ( 'I' | 'i' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkKhaki"

    // $ANTLR start "DarkSalmo"
    public final void mDarkSalmo() throws RecognitionException {
        try {
            int _type = DarkSalmo;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:149:11: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'S' | 's' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'M' | 'm' ) ( 'O' | 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:149:13: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'S' | 's' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'M' | 'm' ) ( 'O' | 'o' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkSalmo"

    // $ANTLR start "FireBrick"
    public final void mFireBrick() throws RecognitionException {
        try {
            int _type = FireBrick;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:151:11: ( ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'K' | 'k' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:151:13: ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'K' | 'k' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FireBrick"

    // $ANTLR start "Gainsboro"
    public final void mGainsboro() throws RecognitionException {
        try {
            int _type = Gainsboro;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:153:11: ( ( 'G' | 'g' ) ( 'A' | 'a' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'O' | 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:153:13: ( 'G' | 'g' ) ( 'A' | 'a' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'O' | 'o' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Gainsboro"

    // $ANTLR start "GoldenRod"
    public final void mGoldenRod() throws RecognitionException {
        try {
            int _type = GoldenRod;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:155:11: ( ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:155:13: ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GoldenRod"

    // $ANTLR start "IndianRed"
    public final void mIndianRed() throws RecognitionException {
        try {
            int _type = IndianRed;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:157:11: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:157:13: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IndianRed"

    // $ANTLR start "LawnGreen"
    public final void mLawnGreen() throws RecognitionException {
        try {
            int _type = LawnGreen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:159:11: ( ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'W' | 'w' ) ( 'N' | 'n' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:159:13: ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'W' | 'w' ) ( 'N' | 'n' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LawnGreen"

    // $ANTLR start "LightBlue"
    public final void mLightBlue() throws RecognitionException {
        try {
            int _type = LightBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:161:11: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:161:13: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightBlue"

    // $ANTLR start "LightCyan"
    public final void mLightCyan() throws RecognitionException {
        try {
            int _type = LightCyan;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:163:11: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'Y' | 'y' ) ( 'A' | 'a' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:163:13: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'Y' | 'y' ) ( 'A' | 'a' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightCyan"

    // $ANTLR start "LightGray"
    public final void mLightGray() throws RecognitionException {
        try {
            int _type = LightGray;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:165:11: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:165:13: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightGray"

    // $ANTLR start "LightGrey"
    public final void mLightGrey() throws RecognitionException {
        try {
            int _type = LightGrey;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:167:11: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:167:13: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightGrey"

    // $ANTLR start "LightPink"
    public final void mLightPink() throws RecognitionException {
        try {
            int _type = LightPink;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:169:11: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'P' | 'p' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'K' | 'k' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:169:13: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) ( 'P' | 'p' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'K' | 'k' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LightPink"

    // $ANTLR start "LimeGreen"
    public final void mLimeGreen() throws RecognitionException {
        try {
            int _type = LimeGreen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:171:11: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:171:13: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LimeGreen"

    // $ANTLR start "MintCream"
    public final void mMintCream() throws RecognitionException {
        try {
            int _type = MintCream;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:173:11: ( ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'M' | 'm' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:173:13: ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'M' | 'm' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MintCream"

    // $ANTLR start "MistyRose"
    public final void mMistyRose() throws RecognitionException {
        try {
            int _type = MistyRose;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:175:11: ( ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'Y' | 'y' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:175:13: ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'Y' | 'y' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MistyRose"

    // $ANTLR start "OliveDrab"
    public final void mOliveDrab() throws RecognitionException {
        try {
            int _type = OliveDrab;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:177:11: ( ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'B' | 'b' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:177:13: ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'B' | 'b' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OliveDrab"

    // $ANTLR start "OrangeRed"
    public final void mOrangeRed() throws RecognitionException {
        try {
            int _type = OrangeRed;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:179:11: ( ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:179:13: ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OrangeRed"

    // $ANTLR start "PaleGreen"
    public final void mPaleGreen() throws RecognitionException {
        try {
            int _type = PaleGreen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:181:11: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:181:13: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PaleGreen"

    // $ANTLR start "PeachPuff"
    public final void mPeachPuff() throws RecognitionException {
        try {
            int _type = PeachPuff;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:183:11: ( ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'F' | 'f' ) ( 'F' | 'f' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:183:13: ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'F' | 'f' ) ( 'F' | 'f' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PeachPuff"

    // $ANTLR start "RosyBrown"
    public final void mRosyBrown() throws RecognitionException {
        try {
            int _type = RosyBrown;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:185:11: ( ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'S' | 's' ) ( 'Y' | 'y' ) ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:185:13: ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'S' | 's' ) ( 'Y' | 'y' ) ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RosyBrown"

    // $ANTLR start "RoyalBlue"
    public final void mRoyalBlue() throws RecognitionException {
        try {
            int _type = RoyalBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:187:11: ( ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'Y' | 'y' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:187:13: ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'Y' | 'y' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RoyalBlue"

    // $ANTLR start "SlateBlue"
    public final void mSlateBlue() throws RecognitionException {
        try {
            int _type = SlateBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:189:11: ( ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:189:13: ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SlateBlue"

    // $ANTLR start "SlateGray"
    public final void mSlateGray() throws RecognitionException {
        try {
            int _type = SlateGray;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:191:11: ( ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:191:13: ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SlateGray"

    // $ANTLR start "SlateGrey"
    public final void mSlateGrey() throws RecognitionException {
        try {
            int _type = SlateGrey;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:193:11: ( ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:193:13: ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SlateGrey"

    // $ANTLR start "SteelBlue"
    public final void mSteelBlue() throws RecognitionException {
        try {
            int _type = SteelBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:195:11: ( ( 'S' | 's' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:195:13: ( 'S' | 's' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SteelBlue"

    // $ANTLR start "Turquoise"
    public final void mTurquoise() throws RecognitionException {
        try {
            int _type = Turquoise;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:197:11: ( ( 'T' | 't' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'O' | 'o' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:197:13: ( 'T' | 't' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'O' | 'o' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Turquoise"

    // $ANTLR start "Endlegend"
    public final void mEndlegend() throws RecognitionException {
        try {
            int _type = Endlegend;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:199:11: ( ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:199:13: ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Endlegend"

    // $ANTLR start "Cornsilk"
    public final void mCornsilk() throws RecognitionException {
        try {
            int _type = Cornsilk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:201:10: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'K' | 'k' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:201:12: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'K' | 'k' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Cornsilk"

    // $ANTLR start "DarkBlue"
    public final void mDarkBlue() throws RecognitionException {
        try {
            int _type = DarkBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:203:10: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:203:12: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkBlue"

    // $ANTLR start "DarkCyan"
    public final void mDarkCyan() throws RecognitionException {
        try {
            int _type = DarkCyan;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:205:10: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'C' | 'c' ) ( 'Y' | 'y' ) ( 'A' | 'a' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:205:12: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'C' | 'c' ) ( 'Y' | 'y' ) ( 'A' | 'a' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkCyan"

    // $ANTLR start "DarkGray"
    public final void mDarkGray() throws RecognitionException {
        try {
            int _type = DarkGray;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:207:10: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:207:12: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkGray"

    // $ANTLR start "DarkGrey"
    public final void mDarkGrey() throws RecognitionException {
        try {
            int _type = DarkGrey;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:209:10: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:209:12: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkGrey"

    // $ANTLR start "DeepPink"
    public final void mDeepPink() throws RecognitionException {
        try {
            int _type = DeepPink;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:211:10: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'P' | 'p' ) ( 'P' | 'p' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'K' | 'k' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:211:12: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'P' | 'p' ) ( 'P' | 'p' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'K' | 'k' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DeepPink"

    // $ANTLR start "HoneyDew"
    public final void mHoneyDew() throws RecognitionException {
        try {
            int _type = HoneyDew;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:213:10: ( ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'W' | 'w' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:213:12: ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'W' | 'w' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HoneyDew"

    // $ANTLR start "Lavender"
    public final void mLavender() throws RecognitionException {
        try {
            int _type = Lavender;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:215:10: ( ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:215:12: ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Lavender"

    // $ANTLR start "Moccasin"
    public final void mMoccasin() throws RecognitionException {
        try {
            int _type = Moccasin;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:217:10: ( ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:217:12: ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Moccasin"

    // $ANTLR start "SeaGreen"
    public final void mSeaGreen() throws RecognitionException {
        try {
            int _type = SeaGreen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:219:10: ( ( 'S' | 's' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:219:12: ( 'S' | 's' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SeaGreen"

    // $ANTLR start "Activate"
    public final void mActivate() throws RecognitionException {
        try {
            int _type = Activate;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:221:10: ( ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:221:12: ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Activate"

    // $ANTLR start "Boundary"
    public final void mBoundary() throws RecognitionException {
        try {
            int _type = Boundary;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:223:10: ( ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:223:12: ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Boundary"

    // $ANTLR start "Critical"
    public final void mCritical() throws RecognitionException {
        try {
            int _type = Critical;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:225:10: ( ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:225:12: ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Critical"

    // $ANTLR start "Database"
    public final void mDatabase() throws RecognitionException {
        try {
            int _type = Database;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:227:10: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'B' | 'b' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:227:12: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'B' | 'b' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Database"

    // $ANTLR start "Crimson"
    public final void mCrimson() throws RecognitionException {
        try {
            int _type = Crimson;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:229:9: ( ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'S' | 's' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:229:11: ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'S' | 's' ) ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Crimson"

    // $ANTLR start "DarkRed"
    public final void mDarkRed() throws RecognitionException {
        try {
            int _type = DarkRed;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:231:9: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:231:11: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'K' | 'k' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DarkRed"

    // $ANTLR start "DimGray"
    public final void mDimGray() throws RecognitionException {
        try {
            int _type = DimGray;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:233:9: ( ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:233:11: ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DimGray"

    // $ANTLR start "DimGrey"
    public final void mDimGrey() throws RecognitionException {
        try {
            int _type = DimGrey;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:235:9: ( ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:235:11: ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DimGrey"

    // $ANTLR start "Fuchsia"
    public final void mFuchsia() throws RecognitionException {
        try {
            int _type = Fuchsia;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:237:9: ( ( 'F' | 'f' ) ( 'U' | 'u' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'A' | 'a' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:237:11: ( 'F' | 'f' ) ( 'U' | 'u' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'A' | 'a' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Fuchsia"

    // $ANTLR start "HotPink"
    public final void mHotPink() throws RecognitionException {
        try {
            int _type = HotPink;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:239:9: ( ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'T' | 't' ) ( 'P' | 'p' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'K' | 'k' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:239:11: ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'T' | 't' ) ( 'P' | 'p' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'K' | 'k' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HotPink"

    // $ANTLR start "Magenta"
    public final void mMagenta() throws RecognitionException {
        try {
            int _type = Magenta;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:241:9: ( ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'A' | 'a' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:241:11: ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'A' | 'a' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Magenta"

    // $ANTLR start "OldLace"
    public final void mOldLace() throws RecognitionException {
        try {
            int _type = OldLace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:243:9: ( ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:243:11: ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OldLace"

    // $ANTLR start "SkyBlue"
    public final void mSkyBlue() throws RecognitionException {
        try {
            int _type = SkyBlue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:245:9: ( ( 'S' | 's' ) ( 'K' | 'k' ) ( 'Y' | 'y' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:245:11: ( 'S' | 's' ) ( 'K' | 'k' ) ( 'Y' | 'y' ) ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SkyBlue"

    // $ANTLR start "Thistle"
    public final void mThistle() throws RecognitionException {
        try {
            int _type = Thistle;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:247:9: ( ( 'T' | 't' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'L' | 'l' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:247:11: ( 'T' | 't' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'L' | 'l' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Thistle"

    // $ANTLR start "Control"
    public final void mControl() throws RecognitionException {
        try {
            int _type = Control;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:249:9: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'L' | 'l' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:249:11: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Control"

    // $ANTLR start "Destroy"
    public final void mDestroy() throws RecognitionException {
        try {
            int _type = Destroy;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:251:9: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:251:11: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Destroy"

    // $ANTLR start "Footbox"
    public final void mFootbox() throws RecognitionException {
        try {
            int _type = Footbox;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:253:9: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'O' | 'o' ) ( 'T' | 't' ) ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'X' | 'x' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:253:11: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'O' | 'o' ) ( 'T' | 't' ) ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'X' | 'x' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Footbox"

    // $ANTLR start "Newpage"
    public final void mNewpage() throws RecognitionException {
        try {
            int _type = Newpage;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:255:9: ( ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:255:11: ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Newpage"

    // $ANTLR start "Bisque"
    public final void mBisque() throws RecognitionException {
        try {
            int _type = Bisque;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:257:8: ( ( 'B' | 'b' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:257:10: ( 'B' | 'b' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Bisque"

    // $ANTLR start "Indigo"
    public final void mIndigo() throws RecognitionException {
        try {
            int _type = Indigo;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:259:8: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'O' | 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:259:10: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'O' | 'o' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Indigo"

    // $ANTLR start "Maroon"
    public final void mMaroon() throws RecognitionException {
        try {
            int _type = Maroon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:261:8: ( ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:261:10: ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Maroon"

    // $ANTLR start "Orchid"
    public final void mOrchid() throws RecognitionException {
        try {
            int _type = Orchid;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:263:8: ( ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:263:10: ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Orchid"

    // $ANTLR start "Purple"
    public final void mPurple() throws RecognitionException {
        try {
            int _type = Purple;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:265:8: ( ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'P' | 'p' ) ( 'L' | 'l' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:265:10: ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'P' | 'p' ) ( 'L' | 'l' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Purple"

    // $ANTLR start "Salmon"
    public final void mSalmon() throws RecognitionException {
        try {
            int _type = Salmon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:267:8: ( ( 'S' | 's' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:267:10: ( 'S' | 's' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Salmon"

    // $ANTLR start "Sienna"
    public final void mSienna() throws RecognitionException {
        try {
            int _type = Sienna;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:269:8: ( ( 'S' | 's' ) ( 'I' | 'i' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'N' | 'n' ) ( 'A' | 'a' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:269:10: ( 'S' | 's' ) ( 'I' | 'i' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'N' | 'n' ) ( 'A' | 'a' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Sienna"

    // $ANTLR start "Silver"
    public final void mSilver() throws RecognitionException {
        try {
            int _type = Silver;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:271:8: ( ( 'S' | 's' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:271:10: ( 'S' | 's' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Silver"

    // $ANTLR start "Tomato"
    public final void mTomato() throws RecognitionException {
        try {
            int _type = Tomato;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:273:8: ( ( 'T' | 't' ) ( 'O' | 'o' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:273:10: ( 'T' | 't' ) ( 'O' | 'o' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Tomato"

    // $ANTLR start "Violet"
    public final void mViolet() throws RecognitionException {
        try {
            int _type = Violet;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:275:8: ( ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'T' | 't' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:275:10: ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Violet"

    // $ANTLR start "Yellow"
    public final void mYellow() throws RecognitionException {
        try {
            int _type = Yellow;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:277:8: ( ( 'Y' | 'y' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:277:10: ( 'Y' | 'y' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' )
            {
            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Yellow"

    // $ANTLR start "Center"
    public final void mCenter() throws RecognitionException {
        try {
            int _type = Center;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:279:8: ( ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:279:10: ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Center"

    // $ANTLR start "Create"
    public final void mCreate() throws RecognitionException {
        try {
            int _type = Create;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:281:8: ( ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:281:10: ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Create"

    // $ANTLR start "Entity"
    public final void mEntity() throws RecognitionException {
        try {
            int _type = Entity;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:283:8: ( ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:283:10: ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Entity"

    // $ANTLR start "Legend"
    public final void mLegend() throws RecognitionException {
        try {
            int _type = Legend;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:285:8: ( ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:285:10: ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Legend"

    // $ANTLR start "Azure"
    public final void mAzure() throws RecognitionException {
        try {
            int _type = Azure;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:287:7: ( ( 'A' | 'a' ) ( 'Z' | 'z' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:287:9: ( 'A' | 'a' ) ( 'Z' | 'z' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Azure"

    // $ANTLR start "Beige"
    public final void mBeige() throws RecognitionException {
        try {
            int _type = Beige;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:289:7: ( ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:289:9: ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Beige"

    // $ANTLR start "Black"
    public final void mBlack() throws RecognitionException {
        try {
            int _type = Black;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:291:7: ( ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'K' | 'k' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:291:9: ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'K' | 'k' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Black"

    // $ANTLR start "Brown"
    public final void mBrown() throws RecognitionException {
        try {
            int _type = Brown;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:293:7: ( ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:293:9: ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Brown"

    // $ANTLR start "Coral"
    public final void mCoral() throws RecognitionException {
        try {
            int _type = Coral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:295:7: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:295:9: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Coral"

    // $ANTLR start "Green"
    public final void mGreen() throws RecognitionException {
        try {
            int _type = Green;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:297:7: ( ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:297:9: ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Green"

    // $ANTLR start "Ivory"
    public final void mIvory() throws RecognitionException {
        try {
            int _type = Ivory;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:299:7: ( ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:299:9: ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Ivory"

    // $ANTLR start "Khaki"
    public final void mKhaki() throws RecognitionException {
        try {
            int _type = Khaki;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:301:7: ( ( 'K' | 'k' ) ( 'H' | 'h' ) ( 'A' | 'a' ) ( 'K' | 'k' ) ( 'I' | 'i' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:301:9: ( 'K' | 'k' ) ( 'H' | 'h' ) ( 'A' | 'a' ) ( 'K' | 'k' ) ( 'I' | 'i' )
            {
            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Khaki"

    // $ANTLR start "Linen"
    public final void mLinen() throws RecognitionException {
        try {
            int _type = Linen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:303:7: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:303:9: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Linen"

    // $ANTLR start "Olive"
    public final void mOlive() throws RecognitionException {
        try {
            int _type = Olive;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:305:7: ( ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:305:9: ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Olive"

    // $ANTLR start "Wheat"
    public final void mWheat() throws RecognitionException {
        try {
            int _type = Wheat;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:307:7: ( ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'T' | 't' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:307:9: ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Wheat"

    // $ANTLR start "White"
    public final void mWhite() throws RecognitionException {
        try {
            int _type = White;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:309:7: ( ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:309:9: ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "White"

    // $ANTLR start "Actor"
    public final void mActor() throws RecognitionException {
        try {
            int _type = Actor;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:311:7: ( ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:311:9: ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Actor"

    // $ANTLR start "Break"
    public final void mBreak() throws RecognitionException {
        try {
            int _type = Break;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:313:7: ( ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'K' | 'k' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:313:9: ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'K' | 'k' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Break"

    // $ANTLR start "Group"
    public final void mGroup() throws RecognitionException {
        try {
            int _type = Group;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:315:7: ( ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'P' | 'p' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:315:9: ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'P' | 'p' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Group"

    // $ANTLR start "Right"
    public final void mRight() throws RecognitionException {
        try {
            int _type = Right;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:317:7: ( ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:317:9: ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Right"

    // $ANTLR start "Title"
    public final void mTitle() throws RecognitionException {
        try {
            int _type = Title;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:319:7: ( ( 'T' | 't' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'L' | 'l' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:319:9: ( 'T' | 't' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'L' | 'l' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Title"

    // $ANTLR start "Aqua"
    public final void mAqua() throws RecognitionException {
        try {
            int _type = Aqua;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:321:6: ( ( 'A' | 'a' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'A' | 'a' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:321:8: ( 'A' | 'a' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'A' | 'a' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Aqua"

    // $ANTLR start "Blue"
    public final void mBlue() throws RecognitionException {
        try {
            int _type = Blue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:323:6: ( ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:323:8: ( 'B' | 'b' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Blue"

    // $ANTLR start "Cyan"
    public final void mCyan() throws RecognitionException {
        try {
            int _type = Cyan;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:325:6: ( ( 'C' | 'c' ) ( 'Y' | 'y' ) ( 'A' | 'a' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:325:8: ( 'C' | 'c' ) ( 'Y' | 'y' ) ( 'A' | 'a' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Cyan"

    // $ANTLR start "Gold"
    public final void mGold() throws RecognitionException {
        try {
            int _type = Gold;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:327:6: ( ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:327:8: ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Gold"

    // $ANTLR start "Gray"
    public final void mGray() throws RecognitionException {
        try {
            int _type = Gray;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:329:6: ( ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:329:8: ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Gray"

    // $ANTLR start "Grey"
    public final void mGrey() throws RecognitionException {
        try {
            int _type = Grey;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:331:6: ( ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:331:8: ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Grey"

    // $ANTLR start "Lime"
    public final void mLime() throws RecognitionException {
        try {
            int _type = Lime;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:333:6: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:333:8: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Lime"

    // $ANTLR start "Navy"
    public final void mNavy() throws RecognitionException {
        try {
            int _type = Navy;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:335:6: ( ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'V' | 'v' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:335:8: ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'V' | 'v' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Navy"

    // $ANTLR start "Peru"
    public final void mPeru() throws RecognitionException {
        try {
            int _type = Peru;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:337:6: ( ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'U' | 'u' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:337:8: ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'U' | 'u' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Peru"

    // $ANTLR start "Pink"
    public final void mPink() throws RecognitionException {
        try {
            int _type = Pink;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:339:6: ( ( 'P' | 'p' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'K' | 'k' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:339:8: ( 'P' | 'p' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'K' | 'k' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Pink"

    // $ANTLR start "Plum"
    public final void mPlum() throws RecognitionException {
        try {
            int _type = Plum;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:341:6: ( ( 'P' | 'p' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'M' | 'm' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:341:8: ( 'P' | 'p' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'M' | 'm' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Plum"

    // $ANTLR start "Snow"
    public final void mSnow() throws RecognitionException {
        try {
            int _type = Snow;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:343:6: ( ( 'S' | 's' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'W' | 'w' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:343:8: ( 'S' | 's' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'W' | 'w' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Snow"

    // $ANTLR start "Teal"
    public final void mTeal() throws RecognitionException {
        try {
            int _type = Teal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:345:6: ( ( 'T' | 't' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:345:8: ( 'T' | 't' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Teal"

    // $ANTLR start "Else"
    public final void mElse() throws RecognitionException {
        try {
            int _type = Else;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:347:6: ( ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:347:8: ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Else"

    // $ANTLR start "Hide"
    public final void mHide() throws RecognitionException {
        try {
            int _type = Hide;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:349:6: ( ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:349:8: ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'D' | 'd' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Hide"

    // $ANTLR start "Left"
    public final void mLeft() throws RecognitionException {
        try {
            int _type = Left;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:351:6: ( ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'T' | 't' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:351:8: ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Left"

    // $ANTLR start "Loop"
    public final void mLoop() throws RecognitionException {
        try {
            int _type = Loop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:353:6: ( ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'O' | 'o' ) ( 'P' | 'p' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:353:8: ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'O' | 'o' ) ( 'P' | 'p' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Loop"

    // $ANTLR start "Note"
    public final void mNote() throws RecognitionException {
        try {
            int _type = Note;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:355:6: ( ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:355:8: ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Note"

    // $ANTLR start "Over"
    public final void mOver() throws RecognitionException {
        try {
            int _type = Over;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:357:6: ( ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:357:8: ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Over"

    // $ANTLR start "FullStopFullStopFullStop"
    public final void mFullStopFullStopFullStop() throws RecognitionException {
        try {
            int _type = FullStopFullStopFullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:359:26: ( '.' '.' '.' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:359:28: '.' '.' '.'
            {
            match('.'); 
            match('.'); 
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStopFullStopFullStop"

    // $ANTLR start "Red"
    public final void mRed() throws RecognitionException {
        try {
            int _type = Red;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:361:5: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:361:7: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Red"

    // $ANTLR start "Tan"
    public final void mTan() throws RecognitionException {
        try {
            int _type = Tan;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:363:5: ( ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:363:7: ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Tan"

    // $ANTLR start "Alt"
    public final void mAlt() throws RecognitionException {
        try {
            int _type = Alt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:365:5: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'T' | 't' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:365:7: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Alt"

    // $ANTLR start "Box"
    public final void mBox() throws RecognitionException {
        try {
            int _type = Box;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:367:5: ( ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'X' | 'x' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:367:7: ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'X' | 'x' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Box"

    // $ANTLR start "End"
    public final void mEnd() throws RecognitionException {
        try {
            int _type = End;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:369:5: ( ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:369:7: ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "End"

    // $ANTLR start "Opt"
    public final void mOpt() throws RecognitionException {
        try {
            int _type = Opt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:371:5: ( ( 'O' | 'o' ) ( 'P' | 'p' ) ( 'T' | 't' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:371:7: ( 'O' | 'o' ) ( 'P' | 'p' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Opt"

    // $ANTLR start "Par"
    public final void mPar() throws RecognitionException {
        try {
            int _type = Par;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:373:5: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'R' | 'r' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:373:7: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Par"

    // $ANTLR start "Ref"
    public final void mRef() throws RecognitionException {
        try {
            int _type = Ref;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:375:5: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'F' | 'f' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:375:7: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'F' | 'f' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Ref"

    // $ANTLR start "VerticalLineVerticalLineVerticalLine"
    public final void mVerticalLineVerticalLineVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLineVerticalLineVerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:377:38: ( '|' '|' '|' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:377:40: '|' '|' '|'
            {
            match('|'); 
            match('|'); 
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLineVerticalLineVerticalLine"

    // $ANTLR start "LessThanSignLessThanSign"
    public final void mLessThanSignLessThanSign() throws RecognitionException {
        try {
            int _type = LessThanSignLessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:379:26: ( '<' '<' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:379:28: '<' '<'
            {
            match('<'); 
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignLessThanSign"

    // $ANTLR start "EqualsSignEqualsSign"
    public final void mEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:381:22: ( '=' '=' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:381:24: '=' '='
            {
            match('='); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSignEqualsSign"

    // $ANTLR start "GreaterThanSignGreaterThanSign"
    public final void mGreaterThanSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:383:32: ( '>' '>' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:383:34: '>' '>'
            {
            match('>'); 
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignGreaterThanSign"

    // $ANTLR start "Of"
    public final void mOf() throws RecognitionException {
        try {
            int _type = Of;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:385:4: ( ( 'O' | 'o' ) ( 'F' | 'f' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:385:6: ( 'O' | 'o' ) ( 'F' | 'f' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Of"

    // $ANTLR start "VerticalLineVerticalLine"
    public final void mVerticalLineVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLineVerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:387:26: ( '|' '|' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:387:28: '|' '|'
            {
            match('|'); 
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLineVerticalLine"

    // $ANTLR start "QuotationMark"
    public final void mQuotationMark() throws RecognitionException {
        try {
            int _type = QuotationMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:389:15: ( '\"' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:389:17: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QuotationMark"

    // $ANTLR start "NumberSign"
    public final void mNumberSign() throws RecognitionException {
        try {
            int _type = NumberSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:391:12: ( '#' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:391:14: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSign"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:393:17: ( '(' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:393:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:395:18: ( ')' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:395:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:397:7: ( ',' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:397:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:399:7: ( ':' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:399:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "RULE_NEWLINE"
    public final void mRULE_NEWLINE() throws RecognitionException {
        try {
            int _type = RULE_NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:403:14: ( ( '\\r' )? '\\n' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:403:16: ( '\\r' )? '\\n'
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:403:16: ( '\\r' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='\r') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:403:16: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NEWLINE"

    // $ANTLR start "RULE_START"
    public final void mRULE_START() throws RecognitionException {
        try {
            int _type = RULE_START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:405:12: ( '@' 'startuml' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:405:14: '@' 'startuml'
            {
            match('@'); 
            match("startuml"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_START"

    // $ANTLR start "RULE_END"
    public final void mRULE_END() throws RecognitionException {
        try {
            int _type = RULE_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:407:10: ( '@' 'enduml' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:407:12: '@' 'enduml'
            {
            match('@'); 
            match("enduml"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_END"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:409:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00E5' | '\\u00E4' | '\\u00F6' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '\\u00E5' | '\\u00E4' | '\\u00F6' )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:409:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00E5' | '\\u00E4' | '\\u00F6' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '\\u00E5' | '\\u00E4' | '\\u00F6' )*
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:409:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:409:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00E4' && input.LA(1)<='\u00E5')||input.LA(1)=='\u00F6' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:409:67: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '\\u00E5' | '\\u00E4' | '\\u00F6' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')||(LA3_0>='\u00E4' && LA3_0<='\u00E5')||LA3_0=='\u00F6') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00E4' && input.LA(1)<='\u00E5')||input.LA(1)=='\u00F6' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:411:17: ( '/\\'' ( options {greedy=false; } : . )* '\\'/' )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:411:19: '/\\'' ( options {greedy=false; } : . )* '\\'/'
            {
            match("/'"); 

            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:411:25: ( options {greedy=false; } : . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\'') ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1=='/') ) {
                        alt4=2;
                    }
                    else if ( ((LA4_1>='\u0000' && LA4_1<='.')||(LA4_1>='0' && LA4_1<='\uFFFF')) ) {
                        alt4=1;
                    }


                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:411:53: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match("'/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:413:17: ( '\\'' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:413:19: '\\'' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match('\''); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:413:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:413:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:413:40: ( ( '\\r' )? '\\n' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\n'||LA7_0=='\r') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:413:41: ( '\\r' )? '\\n'
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:413:41: ( '\\r' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='\r') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:413:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:415:10: ( ( '0' .. '9' )+ )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:415:12: ( '0' .. '9' )+
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:415:12: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:415:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_SEQUENCE"
    public final void mRULE_SEQUENCE() throws RecognitionException {
        try {
            int _type = RULE_SEQUENCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:15: ( ( ( '-' )* '-' '>' | '<' '-' ( '-' )* | '-' '>' 'x' | 'x' '<' '-' | ( '-' )* '-' '>' '>' | '<' '<' '-' ( '-' )* | ( '-' )* '-' '\\\\' '\\\\' | '/' '-' ( '-' )* | '/' '/' '-' ( '-' )* | ( '-' )* '-' '>' 'o' | 'o' '<' '-' ( '-' )* | ( '-' )* '-' '-' '/' '/' 'o' | 'o' '\\\\\\\\' '-' '-' ( '-' )* | '<' '-' '>' | '<' '-' '>' 'o' | 'o' '<' '-' '>' | '<' '|' '-' '-' | '-' '-' '|' '>' | '.' '.' | '.' ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:17: ( ( '-' )* '-' '>' | '<' '-' ( '-' )* | '-' '>' 'x' | 'x' '<' '-' | ( '-' )* '-' '>' '>' | '<' '<' '-' ( '-' )* | ( '-' )* '-' '\\\\' '\\\\' | '/' '-' ( '-' )* | '/' '/' '-' ( '-' )* | ( '-' )* '-' '>' 'o' | 'o' '<' '-' ( '-' )* | ( '-' )* '-' '-' '/' '/' 'o' | 'o' '\\\\\\\\' '-' '-' ( '-' )* | '<' '-' '>' | '<' '-' '>' 'o' | 'o' '<' '-' '>' | '<' '|' '-' '-' | '-' '-' '|' '>' | '.' '.' | '.' )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:17: ( ( '-' )* '-' '>' | '<' '-' ( '-' )* | '-' '>' 'x' | 'x' '<' '-' | ( '-' )* '-' '>' '>' | '<' '<' '-' ( '-' )* | ( '-' )* '-' '\\\\' '\\\\' | '/' '-' ( '-' )* | '/' '/' '-' ( '-' )* | ( '-' )* '-' '>' 'o' | 'o' '<' '-' ( '-' )* | ( '-' )* '-' '-' '/' '/' 'o' | 'o' '\\\\\\\\' '-' '-' ( '-' )* | '<' '-' '>' | '<' '-' '>' 'o' | 'o' '<' '-' '>' | '<' '|' '-' '-' | '-' '-' '|' '>' | '.' '.' | '.' )
            int alt20=20;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:18: ( '-' )* '-' '>'
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:18: ( '-' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='-') ) {
                            int LA9_1 = input.LA(2);

                            if ( (LA9_1=='-') ) {
                                alt9=1;
                            }


                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:18: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match('-'); 
                    match('>'); 

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:31: '<' '-' ( '-' )*
                    {
                    match('<'); 
                    match('-'); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:39: ( '-' )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0=='-') ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:39: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:44: '-' '>' 'x'
                    {
                    match('-'); 
                    match('>'); 
                    match('x'); 

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:56: 'x' '<' '-'
                    {
                    match('x'); 
                    match('<'); 
                    match('-'); 

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:68: ( '-' )* '-' '>' '>'
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:68: ( '-' )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0=='-') ) {
                            int LA11_1 = input.LA(2);

                            if ( (LA11_1=='-') ) {
                                alt11=1;
                            }


                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:68: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    match('-'); 
                    match('>'); 
                    match('>'); 

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:85: '<' '<' '-' ( '-' )*
                    {
                    match('<'); 
                    match('<'); 
                    match('-'); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:97: ( '-' )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='-') ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:97: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:102: ( '-' )* '-' '\\\\' '\\\\'
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:102: ( '-' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='-') ) {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1=='-') ) {
                                alt13=1;
                            }


                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:102: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    match('-'); 
                    match('\\'); 
                    match('\\'); 

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:121: '/' '-' ( '-' )*
                    {
                    match('/'); 
                    match('-'); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:129: ( '-' )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0=='-') ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:129: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:134: '/' '/' '-' ( '-' )*
                    {
                    match('/'); 
                    match('/'); 
                    match('-'); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:146: ( '-' )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0=='-') ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:146: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:151: ( '-' )* '-' '>' 'o'
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:151: ( '-' )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0=='-') ) {
                            int LA16_1 = input.LA(2);

                            if ( (LA16_1=='-') ) {
                                alt16=1;
                            }


                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:151: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    match('-'); 
                    match('>'); 
                    match('o'); 

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:168: 'o' '<' '-' ( '-' )*
                    {
                    match('o'); 
                    match('<'); 
                    match('-'); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:180: ( '-' )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0=='-') ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:180: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:185: ( '-' )* '-' '-' '/' '/' 'o'
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:185: ( '-' )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0=='-') ) {
                            int LA18_1 = input.LA(2);

                            if ( (LA18_1=='-') ) {
                                int LA18_2 = input.LA(3);

                                if ( (LA18_2=='-') ) {
                                    alt18=1;
                                }


                            }


                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:185: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    match('-'); 
                    match('-'); 
                    match('/'); 
                    match('/'); 
                    match('o'); 

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:210: 'o' '\\\\\\\\' '-' '-' ( '-' )*
                    {
                    match('o'); 
                    match("\\\\"); 

                    match('-'); 
                    match('-'); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:229: ( '-' )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0=='-') ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:229: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:234: '<' '-' '>'
                    {
                    match('<'); 
                    match('-'); 
                    match('>'); 

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:246: '<' '-' '>' 'o'
                    {
                    match('<'); 
                    match('-'); 
                    match('>'); 
                    match('o'); 

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:262: 'o' '<' '-' '>'
                    {
                    match('o'); 
                    match('<'); 
                    match('-'); 
                    match('>'); 

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:278: '<' '|' '-' '-'
                    {
                    match('<'); 
                    match('|'); 
                    match('-'); 
                    match('-'); 

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:294: '-' '-' '|' '>'
                    {
                    match('-'); 
                    match('-'); 
                    match('|'); 
                    match('>'); 

                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:310: '.' '.'
                    {
                    match('.'); 
                    match('.'); 

                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:417:318: '.'
                    {
                    match('.'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SEQUENCE"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:419:9: ( ( ' ' | '\\t' )+ )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:419:11: ( ' ' | '\\t' )+
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:419:11: ( ' ' | '\\t' )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='\t'||LA21_0==' ') ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:421:16: ( . )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:421:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:8: ( LightGoldenRodYellow | MediumSpringGreen | MediumAquaMarine | MediumSlateBlue | MediumTurquoise | MediumVioletRed | BlanchedAlmond | CornflowerBlue | DarkOliveGreen | LightSlateGray | LightSlateGrey | LightSteelBlue | MediumSeaGreen | DarkGoldenRod | DarkSlateBlue | DarkSlateGray | DarkSlateGrey | DarkTurquoise | LavenderBlush | LightSeaGreen | PaleGoldenRod | PaleTurquoise | PaleVioletRed | AntiqueWhite | DarkSeaGreen | LemonChiffon | LightSkyBlue | MediumOrchid | MediumPurple | MidnightBlue | DarkMagenta | DeepSkyBlue | FloralWhite | ForestGreen | GreenYellow | LightSalmon | LightYellow | NavajoWhite | SaddleBrown | SpringGreen | YellowGreen | Participant | Aquamarine | BlueViolet | Chartreuse | DarkOrchid | DarkViolet | Darkorange | DodgerBlue | GhostWhite | LightCoral | LightGreen | MediumBlue | PapayaWhip | PowderBlue | SandyBrown | WhiteSmoke | Autonumber | Deactivate | AliceBlue | BurlyWood | CadetBlue | Chocolate | DarkGreen | DarkKhaki | DarkSalmo | FireBrick | Gainsboro | GoldenRod | IndianRed | LawnGreen | LightBlue | LightCyan | LightGray | LightGrey | LightPink | LimeGreen | MintCream | MistyRose | OliveDrab | OrangeRed | PaleGreen | PeachPuff | RosyBrown | RoyalBlue | SlateBlue | SlateGray | SlateGrey | SteelBlue | Turquoise | Endlegend | Cornsilk | DarkBlue | DarkCyan | DarkGray | DarkGrey | DeepPink | HoneyDew | Lavender | Moccasin | SeaGreen | Activate | Boundary | Critical | Database | Crimson | DarkRed | DimGray | DimGrey | Fuchsia | HotPink | Magenta | OldLace | SkyBlue | Thistle | Control | Destroy | Footbox | Newpage | Bisque | Indigo | Maroon | Orchid | Purple | Salmon | Sienna | Silver | Tomato | Violet | Yellow | Center | Create | Entity | Legend | Azure | Beige | Black | Brown | Coral | Green | Ivory | Khaki | Linen | Olive | Wheat | White | Actor | Break | Group | Right | Title | Aqua | Blue | Cyan | Gold | Gray | Grey | Lime | Navy | Peru | Pink | Plum | Snow | Teal | Else | Hide | Left | Loop | Note | Over | FullStopFullStopFullStop | Red | Tan | Alt | Box | End | Opt | Par | Ref | VerticalLineVerticalLineVerticalLine | LessThanSignLessThanSign | EqualsSignEqualsSign | GreaterThanSignGreaterThanSign | Of | VerticalLineVerticalLine | QuotationMark | NumberSign | LeftParenthesis | RightParenthesis | Comma | Colon | RULE_NEWLINE | RULE_START | RULE_END | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_INT | RULE_SEQUENCE | RULE_WS | RULE_ANY_OTHER )
        int alt22=201;
        alt22 = dfa22.predict(input);
        switch (alt22) {
            case 1 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:10: LightGoldenRodYellow
                {
                mLightGoldenRodYellow(); 

                }
                break;
            case 2 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:31: MediumSpringGreen
                {
                mMediumSpringGreen(); 

                }
                break;
            case 3 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:49: MediumAquaMarine
                {
                mMediumAquaMarine(); 

                }
                break;
            case 4 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:66: MediumSlateBlue
                {
                mMediumSlateBlue(); 

                }
                break;
            case 5 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:82: MediumTurquoise
                {
                mMediumTurquoise(); 

                }
                break;
            case 6 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:98: MediumVioletRed
                {
                mMediumVioletRed(); 

                }
                break;
            case 7 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:114: BlanchedAlmond
                {
                mBlanchedAlmond(); 

                }
                break;
            case 8 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:129: CornflowerBlue
                {
                mCornflowerBlue(); 

                }
                break;
            case 9 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:144: DarkOliveGreen
                {
                mDarkOliveGreen(); 

                }
                break;
            case 10 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:159: LightSlateGray
                {
                mLightSlateGray(); 

                }
                break;
            case 11 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:174: LightSlateGrey
                {
                mLightSlateGrey(); 

                }
                break;
            case 12 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:189: LightSteelBlue
                {
                mLightSteelBlue(); 

                }
                break;
            case 13 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:204: MediumSeaGreen
                {
                mMediumSeaGreen(); 

                }
                break;
            case 14 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:219: DarkGoldenRod
                {
                mDarkGoldenRod(); 

                }
                break;
            case 15 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:233: DarkSlateBlue
                {
                mDarkSlateBlue(); 

                }
                break;
            case 16 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:247: DarkSlateGray
                {
                mDarkSlateGray(); 

                }
                break;
            case 17 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:261: DarkSlateGrey
                {
                mDarkSlateGrey(); 

                }
                break;
            case 18 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:275: DarkTurquoise
                {
                mDarkTurquoise(); 

                }
                break;
            case 19 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:289: LavenderBlush
                {
                mLavenderBlush(); 

                }
                break;
            case 20 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:303: LightSeaGreen
                {
                mLightSeaGreen(); 

                }
                break;
            case 21 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:317: PaleGoldenRod
                {
                mPaleGoldenRod(); 

                }
                break;
            case 22 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:331: PaleTurquoise
                {
                mPaleTurquoise(); 

                }
                break;
            case 23 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:345: PaleVioletRed
                {
                mPaleVioletRed(); 

                }
                break;
            case 24 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:359: AntiqueWhite
                {
                mAntiqueWhite(); 

                }
                break;
            case 25 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:372: DarkSeaGreen
                {
                mDarkSeaGreen(); 

                }
                break;
            case 26 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:385: LemonChiffon
                {
                mLemonChiffon(); 

                }
                break;
            case 27 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:398: LightSkyBlue
                {
                mLightSkyBlue(); 

                }
                break;
            case 28 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:411: MediumOrchid
                {
                mMediumOrchid(); 

                }
                break;
            case 29 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:424: MediumPurple
                {
                mMediumPurple(); 

                }
                break;
            case 30 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:437: MidnightBlue
                {
                mMidnightBlue(); 

                }
                break;
            case 31 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:450: DarkMagenta
                {
                mDarkMagenta(); 

                }
                break;
            case 32 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:462: DeepSkyBlue
                {
                mDeepSkyBlue(); 

                }
                break;
            case 33 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:474: FloralWhite
                {
                mFloralWhite(); 

                }
                break;
            case 34 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:486: ForestGreen
                {
                mForestGreen(); 

                }
                break;
            case 35 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:498: GreenYellow
                {
                mGreenYellow(); 

                }
                break;
            case 36 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:510: LightSalmon
                {
                mLightSalmon(); 

                }
                break;
            case 37 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:522: LightYellow
                {
                mLightYellow(); 

                }
                break;
            case 38 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:534: NavajoWhite
                {
                mNavajoWhite(); 

                }
                break;
            case 39 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:546: SaddleBrown
                {
                mSaddleBrown(); 

                }
                break;
            case 40 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:558: SpringGreen
                {
                mSpringGreen(); 

                }
                break;
            case 41 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:570: YellowGreen
                {
                mYellowGreen(); 

                }
                break;
            case 42 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:582: Participant
                {
                mParticipant(); 

                }
                break;
            case 43 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:594: Aquamarine
                {
                mAquamarine(); 

                }
                break;
            case 44 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:605: BlueViolet
                {
                mBlueViolet(); 

                }
                break;
            case 45 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:616: Chartreuse
                {
                mChartreuse(); 

                }
                break;
            case 46 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:627: DarkOrchid
                {
                mDarkOrchid(); 

                }
                break;
            case 47 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:638: DarkViolet
                {
                mDarkViolet(); 

                }
                break;
            case 48 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:649: Darkorange
                {
                mDarkorange(); 

                }
                break;
            case 49 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:660: DodgerBlue
                {
                mDodgerBlue(); 

                }
                break;
            case 50 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:671: GhostWhite
                {
                mGhostWhite(); 

                }
                break;
            case 51 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:682: LightCoral
                {
                mLightCoral(); 

                }
                break;
            case 52 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:693: LightGreen
                {
                mLightGreen(); 

                }
                break;
            case 53 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:704: MediumBlue
                {
                mMediumBlue(); 

                }
                break;
            case 54 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:715: PapayaWhip
                {
                mPapayaWhip(); 

                }
                break;
            case 55 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:726: PowderBlue
                {
                mPowderBlue(); 

                }
                break;
            case 56 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:737: SandyBrown
                {
                mSandyBrown(); 

                }
                break;
            case 57 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:748: WhiteSmoke
                {
                mWhiteSmoke(); 

                }
                break;
            case 58 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:759: Autonumber
                {
                mAutonumber(); 

                }
                break;
            case 59 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:770: Deactivate
                {
                mDeactivate(); 

                }
                break;
            case 60 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:781: AliceBlue
                {
                mAliceBlue(); 

                }
                break;
            case 61 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:791: BurlyWood
                {
                mBurlyWood(); 

                }
                break;
            case 62 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:801: CadetBlue
                {
                mCadetBlue(); 

                }
                break;
            case 63 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:811: Chocolate
                {
                mChocolate(); 

                }
                break;
            case 64 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:821: DarkGreen
                {
                mDarkGreen(); 

                }
                break;
            case 65 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:831: DarkKhaki
                {
                mDarkKhaki(); 

                }
                break;
            case 66 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:841: DarkSalmo
                {
                mDarkSalmo(); 

                }
                break;
            case 67 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:851: FireBrick
                {
                mFireBrick(); 

                }
                break;
            case 68 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:861: Gainsboro
                {
                mGainsboro(); 

                }
                break;
            case 69 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:871: GoldenRod
                {
                mGoldenRod(); 

                }
                break;
            case 70 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:881: IndianRed
                {
                mIndianRed(); 

                }
                break;
            case 71 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:891: LawnGreen
                {
                mLawnGreen(); 

                }
                break;
            case 72 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:901: LightBlue
                {
                mLightBlue(); 

                }
                break;
            case 73 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:911: LightCyan
                {
                mLightCyan(); 

                }
                break;
            case 74 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:921: LightGray
                {
                mLightGray(); 

                }
                break;
            case 75 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:931: LightGrey
                {
                mLightGrey(); 

                }
                break;
            case 76 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:941: LightPink
                {
                mLightPink(); 

                }
                break;
            case 77 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:951: LimeGreen
                {
                mLimeGreen(); 

                }
                break;
            case 78 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:961: MintCream
                {
                mMintCream(); 

                }
                break;
            case 79 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:971: MistyRose
                {
                mMistyRose(); 

                }
                break;
            case 80 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:981: OliveDrab
                {
                mOliveDrab(); 

                }
                break;
            case 81 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:991: OrangeRed
                {
                mOrangeRed(); 

                }
                break;
            case 82 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1001: PaleGreen
                {
                mPaleGreen(); 

                }
                break;
            case 83 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1011: PeachPuff
                {
                mPeachPuff(); 

                }
                break;
            case 84 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1021: RosyBrown
                {
                mRosyBrown(); 

                }
                break;
            case 85 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1031: RoyalBlue
                {
                mRoyalBlue(); 

                }
                break;
            case 86 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1041: SlateBlue
                {
                mSlateBlue(); 

                }
                break;
            case 87 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1051: SlateGray
                {
                mSlateGray(); 

                }
                break;
            case 88 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1061: SlateGrey
                {
                mSlateGrey(); 

                }
                break;
            case 89 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1071: SteelBlue
                {
                mSteelBlue(); 

                }
                break;
            case 90 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1081: Turquoise
                {
                mTurquoise(); 

                }
                break;
            case 91 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1091: Endlegend
                {
                mEndlegend(); 

                }
                break;
            case 92 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1101: Cornsilk
                {
                mCornsilk(); 

                }
                break;
            case 93 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1110: DarkBlue
                {
                mDarkBlue(); 

                }
                break;
            case 94 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1119: DarkCyan
                {
                mDarkCyan(); 

                }
                break;
            case 95 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1128: DarkGray
                {
                mDarkGray(); 

                }
                break;
            case 96 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1137: DarkGrey
                {
                mDarkGrey(); 

                }
                break;
            case 97 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1146: DeepPink
                {
                mDeepPink(); 

                }
                break;
            case 98 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1155: HoneyDew
                {
                mHoneyDew(); 

                }
                break;
            case 99 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1164: Lavender
                {
                mLavender(); 

                }
                break;
            case 100 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1173: Moccasin
                {
                mMoccasin(); 

                }
                break;
            case 101 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1182: SeaGreen
                {
                mSeaGreen(); 

                }
                break;
            case 102 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1191: Activate
                {
                mActivate(); 

                }
                break;
            case 103 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1200: Boundary
                {
                mBoundary(); 

                }
                break;
            case 104 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1209: Critical
                {
                mCritical(); 

                }
                break;
            case 105 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1218: Database
                {
                mDatabase(); 

                }
                break;
            case 106 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1227: Crimson
                {
                mCrimson(); 

                }
                break;
            case 107 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1235: DarkRed
                {
                mDarkRed(); 

                }
                break;
            case 108 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1243: DimGray
                {
                mDimGray(); 

                }
                break;
            case 109 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1251: DimGrey
                {
                mDimGrey(); 

                }
                break;
            case 110 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1259: Fuchsia
                {
                mFuchsia(); 

                }
                break;
            case 111 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1267: HotPink
                {
                mHotPink(); 

                }
                break;
            case 112 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1275: Magenta
                {
                mMagenta(); 

                }
                break;
            case 113 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1283: OldLace
                {
                mOldLace(); 

                }
                break;
            case 114 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1291: SkyBlue
                {
                mSkyBlue(); 

                }
                break;
            case 115 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1299: Thistle
                {
                mThistle(); 

                }
                break;
            case 116 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1307: Control
                {
                mControl(); 

                }
                break;
            case 117 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1315: Destroy
                {
                mDestroy(); 

                }
                break;
            case 118 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1323: Footbox
                {
                mFootbox(); 

                }
                break;
            case 119 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1331: Newpage
                {
                mNewpage(); 

                }
                break;
            case 120 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1339: Bisque
                {
                mBisque(); 

                }
                break;
            case 121 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1346: Indigo
                {
                mIndigo(); 

                }
                break;
            case 122 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1353: Maroon
                {
                mMaroon(); 

                }
                break;
            case 123 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1360: Orchid
                {
                mOrchid(); 

                }
                break;
            case 124 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1367: Purple
                {
                mPurple(); 

                }
                break;
            case 125 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1374: Salmon
                {
                mSalmon(); 

                }
                break;
            case 126 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1381: Sienna
                {
                mSienna(); 

                }
                break;
            case 127 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1388: Silver
                {
                mSilver(); 

                }
                break;
            case 128 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1395: Tomato
                {
                mTomato(); 

                }
                break;
            case 129 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1402: Violet
                {
                mViolet(); 

                }
                break;
            case 130 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1409: Yellow
                {
                mYellow(); 

                }
                break;
            case 131 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1416: Center
                {
                mCenter(); 

                }
                break;
            case 132 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1423: Create
                {
                mCreate(); 

                }
                break;
            case 133 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1430: Entity
                {
                mEntity(); 

                }
                break;
            case 134 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1437: Legend
                {
                mLegend(); 

                }
                break;
            case 135 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1444: Azure
                {
                mAzure(); 

                }
                break;
            case 136 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1450: Beige
                {
                mBeige(); 

                }
                break;
            case 137 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1456: Black
                {
                mBlack(); 

                }
                break;
            case 138 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1462: Brown
                {
                mBrown(); 

                }
                break;
            case 139 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1468: Coral
                {
                mCoral(); 

                }
                break;
            case 140 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1474: Green
                {
                mGreen(); 

                }
                break;
            case 141 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1480: Ivory
                {
                mIvory(); 

                }
                break;
            case 142 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1486: Khaki
                {
                mKhaki(); 

                }
                break;
            case 143 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1492: Linen
                {
                mLinen(); 

                }
                break;
            case 144 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1498: Olive
                {
                mOlive(); 

                }
                break;
            case 145 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1504: Wheat
                {
                mWheat(); 

                }
                break;
            case 146 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1510: White
                {
                mWhite(); 

                }
                break;
            case 147 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1516: Actor
                {
                mActor(); 

                }
                break;
            case 148 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1522: Break
                {
                mBreak(); 

                }
                break;
            case 149 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1528: Group
                {
                mGroup(); 

                }
                break;
            case 150 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1534: Right
                {
                mRight(); 

                }
                break;
            case 151 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1540: Title
                {
                mTitle(); 

                }
                break;
            case 152 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1546: Aqua
                {
                mAqua(); 

                }
                break;
            case 153 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1551: Blue
                {
                mBlue(); 

                }
                break;
            case 154 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1556: Cyan
                {
                mCyan(); 

                }
                break;
            case 155 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1561: Gold
                {
                mGold(); 

                }
                break;
            case 156 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1566: Gray
                {
                mGray(); 

                }
                break;
            case 157 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1571: Grey
                {
                mGrey(); 

                }
                break;
            case 158 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1576: Lime
                {
                mLime(); 

                }
                break;
            case 159 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1581: Navy
                {
                mNavy(); 

                }
                break;
            case 160 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1586: Peru
                {
                mPeru(); 

                }
                break;
            case 161 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1591: Pink
                {
                mPink(); 

                }
                break;
            case 162 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1596: Plum
                {
                mPlum(); 

                }
                break;
            case 163 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1601: Snow
                {
                mSnow(); 

                }
                break;
            case 164 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1606: Teal
                {
                mTeal(); 

                }
                break;
            case 165 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1611: Else
                {
                mElse(); 

                }
                break;
            case 166 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1616: Hide
                {
                mHide(); 

                }
                break;
            case 167 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1621: Left
                {
                mLeft(); 

                }
                break;
            case 168 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1626: Loop
                {
                mLoop(); 

                }
                break;
            case 169 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1631: Note
                {
                mNote(); 

                }
                break;
            case 170 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1636: Over
                {
                mOver(); 

                }
                break;
            case 171 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1641: FullStopFullStopFullStop
                {
                mFullStopFullStopFullStop(); 

                }
                break;
            case 172 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1666: Red
                {
                mRed(); 

                }
                break;
            case 173 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1670: Tan
                {
                mTan(); 

                }
                break;
            case 174 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1674: Alt
                {
                mAlt(); 

                }
                break;
            case 175 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1678: Box
                {
                mBox(); 

                }
                break;
            case 176 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1682: End
                {
                mEnd(); 

                }
                break;
            case 177 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1686: Opt
                {
                mOpt(); 

                }
                break;
            case 178 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1690: Par
                {
                mPar(); 

                }
                break;
            case 179 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1694: Ref
                {
                mRef(); 

                }
                break;
            case 180 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1698: VerticalLineVerticalLineVerticalLine
                {
                mVerticalLineVerticalLineVerticalLine(); 

                }
                break;
            case 181 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1735: LessThanSignLessThanSign
                {
                mLessThanSignLessThanSign(); 

                }
                break;
            case 182 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1760: EqualsSignEqualsSign
                {
                mEqualsSignEqualsSign(); 

                }
                break;
            case 183 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1781: GreaterThanSignGreaterThanSign
                {
                mGreaterThanSignGreaterThanSign(); 

                }
                break;
            case 184 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1812: Of
                {
                mOf(); 

                }
                break;
            case 185 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1815: VerticalLineVerticalLine
                {
                mVerticalLineVerticalLine(); 

                }
                break;
            case 186 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1840: QuotationMark
                {
                mQuotationMark(); 

                }
                break;
            case 187 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1854: NumberSign
                {
                mNumberSign(); 

                }
                break;
            case 188 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1865: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 189 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1881: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 190 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1898: Comma
                {
                mComma(); 

                }
                break;
            case 191 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1904: Colon
                {
                mColon(); 

                }
                break;
            case 192 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1910: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 193 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1923: RULE_START
                {
                mRULE_START(); 

                }
                break;
            case 194 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1934: RULE_END
                {
                mRULE_END(); 

                }
                break;
            case 195 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1943: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 196 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1951: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 197 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1967: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 198 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1983: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 199 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:1992: RULE_SEQUENCE
                {
                mRULE_SEQUENCE(); 

                }
                break;
            case 200 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:2006: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 201 :
                // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/lexer/InternalPlantumlLexer.g:1:2014: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA20_eotS =
        "\6\uffff\1\22\1\26\2\uffff\1\34\16\uffff\1\26\1\uffff\1\37\1\uffff"+
        "\1\41\4\uffff";
    static final String DFA20_eofS =
        "\42\uffff";
    static final String DFA20_minS =
        "\3\55\1\uffff\1\55\1\74\1\56\1\76\1\uffff\1\55\1\76\4\uffff\1\55"+
        "\11\uffff\1\76\1\55\1\157\1\uffff\1\76\4\uffff";
    static final String DFA20_maxS =
        "\1\170\1\134\1\174\1\uffff\1\57\1\134\1\56\1\170\1\uffff\1\174"+
        "\1\76\4\uffff\1\55\11\uffff\1\157\1\134\1\157\1\uffff\1\76\4\uffff";
    static final String DFA20_acceptS =
        "\3\uffff\1\4\4\uffff\1\7\2\uffff\1\6\1\21\1\10\1\11\1\uffff\1\15"+
        "\1\23\1\24\1\3\1\5\1\12\1\1\1\14\1\22\3\uffff\1\2\1\uffff\1\17\1"+
        "\16\1\20\1\13";
    static final String DFA20_specialS =
        "\42\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1\1\6\1\4\14\uffff\1\2\62\uffff\1\5\10\uffff\1\3",
            "\1\11\20\uffff\1\7\35\uffff\1\10",
            "\1\12\16\uffff\1\13\77\uffff\1\14",
            "",
            "\1\15\1\uffff\1\16",
            "\1\17\37\uffff\1\20",
            "\1\21",
            "\1\24\60\uffff\1\25\10\uffff\1\23",
            "",
            "\1\32\1\uffff\1\27\16\uffff\1\31\35\uffff\1\10\37\uffff\1"+
            "\30",
            "\1\33",
            "",
            "",
            "",
            "",
            "\1\35",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\24\60\uffff\1\25",
            "\1\32\1\uffff\1\27\16\uffff\1\31\35\uffff\1\10",
            "\1\36",
            "",
            "\1\40",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "417:17: ( ( '-' )* '-' '>' | '<' '-' ( '-' )* | '-' '>' 'x' | 'x' '<' '-' | ( '-' )* '-' '>' '>' | '<' '<' '-' ( '-' )* | ( '-' )* '-' '\\\\' '\\\\' | '/' '-' ( '-' )* | '/' '/' '-' ( '-' )* | ( '-' )* '-' '>' 'o' | 'o' '<' '-' ( '-' )* | ( '-' )* '-' '-' '/' '/' 'o' | 'o' '\\\\\\\\' '-' '-' ( '-' )* | '<' '-' '>' | '<' '-' '>' 'o' | 'o' '<' '-' '>' | '<' '|' '-' '-' | '-' '-' '|' '>' | '.' '.' | '.' )";
        }
    }
    static final String DFA22_eotS =
        "\1\uffff\25\62\1\157\4\55\6\uffff\1\55\1\uffff\2\55\1\62\1\55\2"+
        "\uffff\1\55\1\uffff\1\62\2\uffff\4\62\1\uffff\73\62\1\u00ee\1\uffff"+
        "\17\62\1\157\1\u0104\1\u0105\17\uffff\24\62\1\u011b\25\62\1\u0134"+
        "\13\62\1\u0140\45\62\1\u0169\1\uffff\3\62\1\u016d\1\u016e\5\62\1"+
        "\u0174\1\u0176\7\62\4\uffff\1\62\1\u0180\5\62\1\u0186\1\u0187\11"+
        "\62\1\u0192\2\62\1\uffff\16\62\1\u01a4\11\62\1\uffff\3\62\1\u01bd"+
        "\1\62\1\u01bf\1\u01c0\1\62\1\u01c3\2\62\1\uffff\11\62\1\u01cf\1"+
        "\62\1\u01d1\2\62\1\u01d5\1\62\1\u01d7\1\62\1\u01d9\12\62\1\u01e4"+
        "\11\62\1\u01ef\1\uffff\3\62\2\uffff\4\62\1\u01f7\1\uffff\1\62\1"+
        "\uffff\1\62\1\u01fa\2\62\1\u01fd\4\62\1\uffff\1\u0207\4\62\2\uffff"+
        "\10\62\1\u0214\1\62\1\uffff\3\62\1\u0219\1\u021a\1\u021b\2\62\1"+
        "\u021e\10\62\1\uffff\30\62\1\uffff\1\62\2\uffff\2\62\1\uffff\3\62"+
        "\1\u024b\1\u024c\5\62\1\u0253\1\uffff\1\u0254\1\uffff\3\62\1\uffff"+
        "\1\62\1\uffff\1\62\1\uffff\12\62\1\uffff\1\62\1\u0267\1\u0268\2"+
        "\62\1\u026b\1\u026d\3\62\1\uffff\2\62\1\u0273\3\62\1\u0277\1\uffff"+
        "\2\62\1\uffff\2\62\1\uffff\1\62\1\u027d\7\62\1\uffff\3\62\1\u028e"+
        "\6\62\1\u029b\1\62\1\uffff\3\62\1\u02a0\3\uffff\2\62\1\uffff\6\62"+
        "\1\u02a9\1\u02aa\36\62\1\u02cb\5\62\2\uffff\6\62\2\uffff\7\62\1"+
        "\u02de\6\62\1\u02e5\1\u02e6\1\u02e8\1\62\2\uffff\1\62\1\u02eb\1"+
        "\uffff\1\62\1\uffff\2\62\1\u02ef\2\62\1\uffff\2\62\1\u02f4\1\uffff"+
        "\1\62\1\u02f6\2\62\1\u02f9\1\uffff\20\62\1\uffff\13\62\1\u0318\1"+
        "\uffff\4\62\1\uffff\2\62\1\u031f\4\62\1\u0324\2\uffff\17\62\1\u0335"+
        "\4\62\1\u033a\1\62\1\u033c\1\u033d\10\62\1\uffff\7\62\1\u034d\1"+
        "\62\1\u034f\5\62\1\u0355\2\62\1\uffff\5\62\1\u035e\2\uffff\1\62"+
        "\1\uffff\2\62\1\uffff\1\62\1\u0363\1\62\1\uffff\3\62\1\u0368\1\uffff"+
        "\1\62\1\uffff\1\62\1\u036b\1\uffff\16\62\1\u037c\16\62\1\u038b\1"+
        "\uffff\3\62\1\u038f\1\62\1\u0391\1\uffff\3\62\1\u0395\1\uffff\5"+
        "\62\1\u039b\1\u039c\7\62\1\u03a4\1\u03a5\1\uffff\1\u03a6\1\62\1"+
        "\u03a8\1\62\1\uffff\1\62\2\uffff\14\62\1\u03b7\2\62\1\uffff\1\62"+
        "\1\uffff\5\62\1\uffff\7\62\1\u03c7\1\uffff\4\62\1\uffff\4\62\1\uffff"+
        "\1\62\1\u03d1\1\uffff\2\62\1\u03d4\1\u03d5\7\62\1\u03dd\1\u03de"+
        "\1\u03df\1\u03e0\1\62\1\uffff\1\u03e2\13\62\1\u03ee\1\u03ef\1\uffff"+
        "\2\62\1\u03f2\1\uffff\1\62\1\uffff\1\62\1\u03f5\1\u03f6\1\uffff"+
        "\4\62\1\u03fb\2\uffff\2\62\1\u03ff\3\62\1\u0403\3\uffff\1\62\1\uffff"+
        "\3\62\1\u0408\5\62\1\u040e\3\62\1\u0412\1\uffff\2\62\1\u0415\2\62"+
        "\1\u0418\1\u0419\4\62\1\u041e\1\u041f\1\u0420\1\u0421\1\uffff\2"+
        "\62\1\u0424\1\u0425\1\u0426\1\u0427\1\u0428\1\u0429\1\u042a\1\uffff"+
        "\1\62\1\u042c\2\uffff\6\62\1\u0433\4\uffff\1\62\1\uffff\11\62\1"+
        "\u043e\1\62\2\uffff\1\62\1\u0441\1\uffff\1\62\1\u0443\2\uffff\1"+
        "\62\1\u0445\1\u0446\1\62\1\uffff\3\62\1\uffff\2\62\1\u044d\1\uffff"+
        "\1\62\1\u044f\1\u0450\1\62\1\uffff\3\62\1\u0455\1\u0456\1\uffff"+
        "\1\62\1\u0458\1\u0459\1\uffff\2\62\1\uffff\1\62\1\u045d\2\uffff"+
        "\2\62\1\u0460\1\62\4\uffff\1\62\1\u0463\7\uffff\1\62\1\uffff\4\62"+
        "\1\u0469\1\u046a\1\uffff\12\62\1\uffff\2\62\1\uffff\1\62\1\uffff"+
        "\1\62\2\uffff\5\62\1\u047f\1\uffff\1\u0480\2\uffff\3\62\1\u0484"+
        "\2\uffff\1\62\2\uffff\1\u0486\1\u0487\1\u0488\1\uffff\1\u0489\1"+
        "\u048a\1\uffff\1\u048b\1\u048c\1\uffff\4\62\1\u0492\2\uffff\1\62"+
        "\1\u0494\6\62\1\u049b\1\u049c\1\u049d\7\62\1\u04a5\1\62\2\uffff"+
        "\3\62\1\uffff\1\u04aa\7\uffff\4\62\1\u04af\1\uffff\1\u04b0\1\uffff"+
        "\6\62\3\uffff\3\62\1\u04ba\1\u04bb\1\u04bc\1\u04bd\1\uffff\1\u04be"+
        "\1\u04bf\1\u04c0\1\u04c1\1\uffff\1\62\1\u04c3\1\u04c4\1\u04c5\2"+
        "\uffff\2\62\1\u04c8\3\62\1\u04cc\1\u04cd\1\u04ce\10\uffff\1\62\3"+
        "\uffff\1\62\1\u04d1\1\uffff\1\62\1\u04d3\1\u04d4\3\uffff\2\62\1"+
        "\uffff\1\u04d7\2\uffff\1\62\1\u04d9\1\uffff\1\62\1\uffff\1\62\1"+
        "\u04dc\1\uffff";
    static final String DFA22_eofS =
        "\u04dd\uffff";
    static final String DFA22_minS =
        "\1\0\2\101\1\105\3\101\1\103\1\111\3\101\1\105\1\110\1\116\1\74"+
        "\1\105\1\101\1\114\2\111\1\110\1\56\1\174\1\55\1\75\1\76\6\uffff"+
        "\1\12\1\uffff\1\145\1\101\1\74\1\47\2\uffff\1\55\1\uffff\1\106\2"+
        "\uffff\1\107\1\126\1\106\1\117\1\uffff\2\104\1\103\1\107\1\101\1"+
        "\122\1\125\1\123\1\111\1\105\1\116\1\101\1\104\1\105\1\116\1\101"+
        "\1\122\1\101\1\104\1\115\1\114\1\127\1\101\1\122\1\116\1\125\1\124"+
        "\1\125\1\124\1\111\1\124\1\125\2\117\1\122\1\103\1\101\1\117\1\111"+
        "\1\114\1\126\1\127\1\124\1\104\1\122\1\101\1\105\1\101\1\131\1\105"+
        "\1\117\1\114\1\105\1\104\1\117\1\104\1\101\1\105\1\124\1\60\1\uffff"+
        "\1\123\1\107\1\104\1\122\1\111\1\115\1\124\1\101\1\116\1\104\1\123"+
        "\1\116\1\104\1\117\1\101\1\56\1\174\1\55\17\uffff\1\110\3\105\1"+
        "\116\1\117\1\105\1\124\1\120\1\111\1\116\2\124\1\103\1\105\1\117"+
        "\1\103\1\105\1\114\1\116\1\60\1\121\1\107\1\127\2\101\1\124\1\122"+
        "\1\103\1\105\1\115\1\101\1\124\1\116\1\113\1\101\1\120\1\103\1\124"+
        "\2\107\1\105\1\60\1\101\1\104\1\103\1\125\1\120\1\113\1\115\1\111"+
        "\1\101\1\117\1\103\1\60\1\111\2\122\1\105\1\124\1\105\1\110\1\105"+
        "\1\125\1\131\1\123\1\116\1\104\1\101\1\120\1\105\2\104\1\115\1\111"+
        "\1\124\1\105\1\107\1\102\1\116\1\126\1\127\1\114\1\124\1\101\1\111"+
        "\1\122\1\126\1\114\1\116\1\110\1\122\1\60\1\uffff\1\131\1\101\1"+
        "\110\2\60\1\121\1\123\1\101\2\114\2\60\1\111\2\105\1\120\1\105\1"+
        "\114\1\113\4\uffff\1\124\1\60\2\116\1\107\2\116\2\60\1\125\1\111"+
        "\1\103\1\131\1\101\1\116\1\117\1\103\1\113\1\60\1\131\1\104\1\uffff"+
        "\1\125\1\105\1\116\1\113\1\106\1\114\1\122\1\124\1\117\1\124\1\111"+
        "\1\123\1\124\1\105\1\60\2\102\1\120\1\124\1\122\1\105\1\122\1\107"+
        "\1\111\1\uffff\1\131\1\105\1\110\1\60\1\114\2\60\1\121\1\60\1\116"+
        "\1\105\1\uffff\1\126\1\122\1\105\1\101\1\123\2\102\1\123\1\116\1"+
        "\60\1\120\1\60\1\124\1\123\1\60\1\112\1\60\1\101\1\60\1\114\1\131"+
        "\1\117\1\116\1\105\1\114\1\122\1\114\1\116\1\105\1\60\1\117\1\105"+
        "\1\124\1\101\1\131\1\105\1\101\1\107\1\111\1\60\1\uffff\1\102\1"+
        "\114\1\124\2\uffff\1\125\2\124\1\105\1\60\1\uffff\1\105\1\uffff"+
        "\1\124\1\60\1\131\1\111\1\60\1\105\1\111\1\102\1\122\1\uffff\1\60"+
        "\1\104\1\122\1\103\1\104\2\uffff\1\115\1\107\2\122\1\123\1\124\1"+
        "\116\1\110\1\60\1\111\1\uffff\1\127\1\101\1\105\3\60\1\114\1\111"+
        "\1\60\1\117\1\122\1\114\1\102\1\103\1\117\1\105\1\122\1\uffff\1"+
        "\114\1\117\1\101\1\125\1\101\1\111\1\110\1\114\1\131\1\105\1\101"+
        "\1\113\2\111\1\117\1\122\1\101\1\117\1\125\1\111\1\103\1\101\1\122"+
        "\1\120\1\uffff\1\105\2\uffff\1\125\1\101\1\uffff\1\125\1\102\1\101"+
        "\2\60\1\114\1\124\1\117\1\122\1\111\1\60\1\uffff\1\60\1\uffff\1"+
        "\127\1\102\1\116\1\uffff\1\117\1\uffff\1\107\1\uffff\1\105\1\102"+
        "\1\116\1\107\2\102\1\105\1\125\1\101\1\122\1\uffff\1\127\2\60\1"+
        "\116\1\117\2\60\1\103\1\105\1\104\1\uffff\1\122\1\102\1\60\1\117"+
        "\1\114\1\117\1\60\1\uffff\1\107\1\131\1\uffff\1\104\1\116\1\uffff"+
        "\1\124\1\60\1\117\1\101\1\105\1\117\1\114\1\111\1\105\1\uffff\2"+
        "\105\1\110\1\60\1\101\1\110\1\105\1\117\1\111\1\101\1\60\1\105\1"+
        "\uffff\2\117\1\122\1\60\3\uffff\1\117\1\114\1\uffff\1\114\1\105"+
        "\1\101\1\114\1\101\1\116\2\60\1\111\1\101\1\114\3\101\1\114\1\122"+
        "\1\107\1\117\1\101\1\125\1\101\1\104\1\123\1\131\1\116\1\126\1\131"+
        "\1\102\2\131\1\114\1\105\1\122\1\117\1\111\1\127\1\102\1\125\1\60"+
        "\1\105\1\122\1\115\1\114\1\124\2\uffff\1\127\1\107\1\130\1\111\1"+
        "\101\1\105\2\uffff\1\110\1\117\1\122\1\127\1\105\1\102\1\122\1\60"+
        "\1\107\1\114\1\122\1\114\2\105\3\60\1\115\2\uffff\1\122\1\60\1\uffff"+
        "\1\122\1\uffff\1\105\1\122\1\60\1\117\1\114\1\uffff\1\111\1\105"+
        "\1\60\1\uffff\1\105\1\60\1\105\1\113\1\60\1\uffff\1\114\2\101\1"+
        "\105\1\101\1\131\2\114\1\122\1\101\1\125\1\116\1\105\1\122\1\105"+
        "\1\111\1\uffff\1\105\1\121\1\125\1\111\1\122\1\125\1\114\1\124\1"+
        "\101\1\123\1\116\1\60\1\uffff\1\104\1\114\1\117\1\131\1\uffff\1"+
        "\127\1\113\1\60\1\125\1\124\1\125\1\114\1\60\2\uffff\1\126\1\110"+
        "\1\116\1\104\1\105\1\131\1\124\1\107\1\115\1\121\1\105\1\114\1\113"+
        "\1\105\1\116\1\60\1\105\1\102\1\113\1\101\1\60\1\114\2\60\1\104"+
        "\1\105\1\121\1\114\1\120\1\110\1\114\1\106\1\uffff\1\127\1\111\1"+
        "\102\1\125\1\105\1\110\1\122\1\60\1\103\1\60\1\114\1\111\1\122\1"+
        "\117\1\110\1\60\1\122\1\117\1\uffff\1\122\1\125\1\101\1\125\1\116"+
        "\1\60\2\uffff\1\122\1\uffff\1\117\1\105\1\uffff\1\101\1\60\1\105"+
        "\1\uffff\1\127\1\125\1\123\1\60\1\uffff\1\116\1\uffff\1\127\1\60"+
        "\1\uffff\1\104\1\105\1\131\1\124\1\105\1\107\1\102\1\115\1\114\1"+
        "\101\1\116\1\105\1\113\1\116\1\60\1\116\1\106\1\122\2\101\1\125"+
        "\1\122\1\117\1\103\1\122\1\125\1\102\1\115\1\105\1\60\1\uffff\1"+
        "\101\1\105\1\104\1\60\1\105\1\60\1\uffff\1\123\2\105\1\60\1\uffff"+
        "\1\105\1\111\1\107\1\105\1\116\2\60\1\105\1\122\1\117\1\125\1\116"+
        "\1\105\1\111\2\60\1\uffff\1\60\1\114\1\60\1\124\1\uffff\1\125\2"+
        "\uffff\1\105\1\116\1\125\1\105\1\101\1\111\1\125\1\106\1\110\1\116"+
        "\2\105\1\60\1\111\1\105\1\uffff\1\113\1\uffff\1\114\1\124\1\117"+
        "\1\104\1\111\1\uffff\1\117\1\127\2\105\2\131\1\105\1\60\1\uffff"+
        "\1\105\1\113\1\104\1\102\1\uffff\1\104\1\116\2\105\1\uffff\1\104"+
        "\1\60\1\uffff\1\105\1\116\2\60\1\105\1\114\1\122\1\114\2\117\1\114"+
        "\4\60\1\114\1\uffff\1\60\1\106\1\111\1\124\1\107\1\101\1\121\1\114"+
        "\1\110\1\120\1\105\1\114\2\60\1\uffff\1\114\1\124\1\60\1\uffff\1"+
        "\122\1\uffff\1\105\2\60\1\uffff\1\107\1\104\1\105\1\116\1\60\2\uffff"+
        "\1\102\1\105\1\60\1\117\2\124\1\60\3\uffff\1\125\1\uffff\2\105\1"+
        "\116\1\60\1\117\1\124\1\116\1\120\1\105\1\60\1\111\1\105\1\122\1"+
        "\60\1\uffff\1\124\1\105\1\60\1\117\1\105\2\60\1\124\1\127\1\116"+
        "\1\105\4\60\1\uffff\2\105\7\60\1\uffff\1\116\1\60\2\uffff\1\107"+
        "\1\102\1\105\1\125\1\116\1\127\1\60\4\uffff\1\125\1\uffff\1\117"+
        "\1\116\1\105\1\122\1\115\1\125\1\105\1\111\1\114\1\60\1\125\2\uffff"+
        "\1\115\1\60\1\uffff\1\102\1\60\2\uffff\1\122\2\60\1\122\1\uffff"+
        "\1\114\1\122\1\105\1\uffff\1\111\1\101\1\60\1\uffff\1\105\2\60\1"+
        "\122\1\uffff\1\111\1\122\1\124\2\60\1\uffff\1\124\2\60\1\uffff\1"+
        "\105\1\116\1\uffff\1\127\1\60\2\uffff\1\105\1\116\1\60\1\116\4\uffff"+
        "\1\116\1\60\7\uffff\1\122\1\uffff\1\122\1\114\2\105\2\60\1\uffff"+
        "\1\123\1\116\1\107\1\102\1\105\1\101\1\117\1\124\1\104\1\105\1\uffff"+
        "\1\105\1\117\1\uffff\1\114\1\uffff\1\105\2\uffff\1\117\1\125\1\101"+
        "\1\116\1\123\1\60\1\uffff\1\60\2\uffff\1\117\1\123\1\105\1\60\2"+
        "\uffff\1\105\2\uffff\3\60\1\uffff\2\60\1\uffff\2\60\1\uffff\1\117"+
        "\1\101\1\125\1\116\1\60\2\uffff\1\110\1\60\1\107\1\114\1\105\1\122"+
        "\1\111\1\122\3\60\1\116\1\125\1\105\1\104\1\105\2\131\1\60\1\105"+
        "\2\uffff\1\104\1\105\1\104\1\uffff\1\60\7\uffff\1\104\2\131\1\105"+
        "\1\60\1\uffff\1\60\1\uffff\1\122\1\125\1\116\1\111\1\123\1\105\3"+
        "\uffff\1\104\1\105\1\116\4\60\1\uffff\4\60\1\uffff\1\131\3\60\2"+
        "\uffff\2\105\1\60\1\116\1\105\1\104\3\60\10\uffff\1\105\3\uffff"+
        "\1\105\1\60\1\uffff\1\105\2\60\3\uffff\1\114\1\116\1\uffff\1\60"+
        "\2\uffff\1\114\1\60\1\uffff\1\117\1\uffff\1\127\1\60\1\uffff";
    static final String DFA22_maxS =
        "\1\uffff\2\157\1\165\1\171\1\157\1\165\1\172\1\165\1\162\1\157"+
        "\1\164\1\145\1\150\2\166\1\157\1\165\1\156\1\157\1\151\1\150\1\56"+
        "\2\174\1\75\1\76\6\uffff\1\12\1\uffff\1\163\1\u00f6\1\74\1\57\2"+
        "\uffff\1\134\1\uffff\1\166\2\uffff\1\156\1\167\1\155\1\157\1\uffff"+
        "\1\144\1\163\1\143\1\162\1\165\1\162\1\170\1\163\1\151\1\157\1\162"+
        "\1\157\1\144\1\151\1\156\1\141\1\164\1\163\1\144\1\155\1\162\1\167"+
        "\2\162\1\156\1\165\1\164\1\165\3\164\1\165\1\157\2\162\1\143\2\157"+
        "\1\151\1\154\1\166\1\167\1\164\1\156\1\162\1\141\1\145\1\141\1\171"+
        "\1\154\1\157\1\154\1\151\1\144\1\157\1\151\1\143\1\145\1\164\1\u00f6"+
        "\1\uffff\1\171\1\147\1\146\1\162\1\151\1\155\1\164\1\141\1\156\1"+
        "\164\1\163\1\164\1\144\1\157\1\141\1\56\1\174\1\55\17\uffff\1\150"+
        "\3\145\1\156\1\157\1\145\1\164\1\160\1\151\1\156\2\164\1\143\1\145"+
        "\1\157\1\156\1\145\1\154\1\156\1\u00f6\1\161\1\147\1\167\1\141\1"+
        "\156\1\164\1\162\1\143\1\145\1\164\1\141\1\164\1\156\1\153\1\141"+
        "\1\160\1\143\1\164\2\147\1\145\1\u00f6\1\141\1\144\1\143\1\165\1"+
        "\160\1\153\1\155\1\151\1\141\1\157\1\143\1\u00f6\1\157\2\162\1\145"+
        "\1\164\1\145\1\150\1\171\1\165\1\171\1\163\1\156\1\144\1\171\1\160"+
        "\1\145\2\144\1\155\1\151\1\164\1\145\1\147\1\142\1\156\1\166\1\167"+
        "\1\154\1\164\1\141\1\151\1\162\1\166\1\154\1\156\1\150\1\162\1\u00f6"+
        "\1\uffff\1\171\1\141\1\150\2\u00f6\1\161\1\163\1\141\2\154\2\u00f6"+
        "\1\151\2\145\1\160\1\145\1\154\1\153\4\uffff\1\164\1\u00f6\2\156"+
        "\1\147\2\156\2\u00f6\1\165\1\151\1\143\1\171\1\141\1\156\1\157\1"+
        "\143\1\153\1\u00f6\1\171\1\144\1\uffff\1\165\1\145\1\156\1\153\1"+
        "\163\1\154\1\162\1\164\1\157\1\164\1\151\1\163\1\164\1\145\1\u00f6"+
        "\1\166\1\142\1\163\1\164\1\162\1\145\1\162\1\166\1\151\1\uffff\1"+
        "\171\1\145\1\150\1\u00f6\1\154\2\u00f6\1\161\1\u00f6\1\156\1\145"+
        "\1\uffff\1\166\1\162\1\145\1\141\1\163\2\142\1\163\1\156\1\u00f6"+
        "\1\160\1\u00f6\1\164\1\163\1\u00f6\1\152\1\u00f6\1\141\1\u00f6\1"+
        "\154\1\171\1\157\1\156\1\145\1\154\1\162\1\154\1\156\1\145\1\u00f6"+
        "\1\157\1\145\1\164\1\147\1\171\1\145\1\141\1\147\1\151\1\u00f6\1"+
        "\uffff\1\142\1\154\1\164\2\uffff\1\165\2\164\1\145\1\u00f6\1\uffff"+
        "\1\145\1\uffff\1\164\1\u00f6\1\171\1\151\1\u00f6\1\145\1\151\1\171"+
        "\1\162\1\uffff\1\u00f6\1\144\1\162\1\143\1\144\2\uffff\1\155\1\147"+
        "\2\162\1\163\1\164\1\156\1\150\1\u00f6\1\151\1\uffff\1\167\1\141"+
        "\1\145\3\u00f6\1\154\1\151\1\u00f6\1\157\1\162\1\154\1\142\1\143"+
        "\1\157\1\145\1\162\1\uffff\2\162\1\154\1\165\1\141\1\151\1\150\1"+
        "\154\1\171\1\145\1\141\1\153\2\151\1\157\1\162\1\145\1\162\1\165"+
        "\1\151\1\143\1\141\1\162\1\160\1\uffff\1\145\2\uffff\1\165\1\141"+
        "\1\uffff\1\165\1\142\1\141\2\u00f6\1\154\1\164\1\157\1\162\1\151"+
        "\1\u00f6\1\uffff\1\u00f6\1\uffff\1\167\1\142\1\156\1\uffff\1\157"+
        "\1\uffff\1\147\1\uffff\1\145\1\142\1\156\2\147\1\142\1\145\1\165"+
        "\1\141\1\162\1\uffff\1\167\2\u00f6\1\156\1\157\2\u00f6\1\143\1\145"+
        "\1\144\1\uffff\1\162\1\142\1\u00f6\1\157\1\154\1\157\1\u00f6\1\uffff"+
        "\1\147\1\171\1\uffff\1\144\1\156\1\uffff\1\164\1\u00f6\1\162\1\164"+
        "\1\145\1\171\1\154\1\151\1\145\1\uffff\2\145\1\150\1\u00f6\1\166"+
        "\1\150\1\145\1\157\1\151\1\141\1\u00f6\1\145\1\uffff\2\157\1\162"+
        "\1\u00f6\3\uffff\1\157\1\154\1\uffff\1\154\1\145\1\141\1\154\1\141"+
        "\1\156\2\u00f6\1\151\1\143\1\154\1\145\2\141\1\154\1\162\1\147\1"+
        "\157\1\141\1\165\1\141\1\144\1\163\1\171\1\156\1\166\1\171\1\142"+
        "\2\171\1\154\1\145\1\162\1\157\1\151\1\167\1\142\1\165\1\u00f6\1"+
        "\145\1\162\1\155\1\154\1\164\2\uffff\1\167\1\147\1\170\1\151\1\141"+
        "\1\145\2\uffff\1\150\1\157\1\162\1\167\1\145\1\142\1\162\1\u00f6"+
        "\1\147\1\154\1\162\1\154\2\145\3\u00f6\1\155\2\uffff\1\162\1\u00f6"+
        "\1\uffff\1\162\1\uffff\1\145\1\162\1\u00f6\1\157\1\154\1\uffff\1"+
        "\151\1\145\1\u00f6\1\uffff\1\145\1\u00f6\1\145\1\153\1\u00f6\1\uffff"+
        "\1\154\1\145\1\141\1\145\1\141\1\171\2\154\1\162\1\141\1\165\1\156"+
        "\1\145\1\162\1\145\1\151\1\uffff\1\160\1\161\1\165\1\151\1\162\1"+
        "\165\1\154\1\164\1\141\1\163\1\156\1\u00f6\1\uffff\1\144\1\154\1"+
        "\157\1\171\1\uffff\1\167\1\153\1\u00f6\1\165\1\164\1\165\1\154\1"+
        "\u00f6\2\uffff\1\166\1\150\1\156\1\144\2\171\1\164\1\147\1\155\1"+
        "\161\1\145\1\154\1\153\1\145\1\156\1\u00f6\1\145\1\142\1\153\1\141"+
        "\1\u00f6\1\154\2\u00f6\1\144\1\145\1\161\1\154\1\160\1\150\1\154"+
        "\1\146\1\uffff\1\167\1\151\1\142\1\165\1\145\1\150\1\162\1\u00f6"+
        "\1\143\1\u00f6\1\154\1\151\1\162\1\157\1\150\1\u00f6\1\162\1\157"+
        "\1\uffff\1\162\1\165\1\145\1\165\1\156\1\u00f6\2\uffff\1\162\1\uffff"+
        "\1\157\1\145\1\uffff\1\141\1\u00f6\1\145\1\uffff\1\167\1\165\1\163"+
        "\1\u00f6\1\uffff\1\156\1\uffff\1\167\1\u00f6\1\uffff\1\144\2\171"+
        "\1\164\1\145\1\147\1\142\1\155\1\154\1\141\1\156\1\145\1\153\1\156"+
        "\1\u00f6\1\156\1\146\1\162\2\141\1\165\1\162\1\157\1\143\1\162\1"+
        "\165\1\142\1\155\1\145\1\u00f6\1\uffff\1\141\1\145\1\144\1\u00f6"+
        "\1\145\1\u00f6\1\uffff\1\163\2\145\1\u00f6\1\uffff\1\145\1\151\1"+
        "\147\1\145\1\156\2\u00f6\1\145\1\162\1\157\1\165\1\156\1\145\1\151"+
        "\2\u00f6\1\uffff\1\u00f6\1\154\1\u00f6\1\164\1\uffff\1\165\2\uffff"+
        "\1\145\1\156\1\165\1\145\1\141\1\151\1\165\1\146\1\150\1\156\2\145"+
        "\1\u00f6\1\151\1\145\1\uffff\1\153\1\uffff\1\154\1\164\1\157\1\144"+
        "\1\151\1\uffff\1\157\1\167\2\145\2\171\1\145\1\u00f6\1\uffff\1\145"+
        "\1\153\1\144\1\142\1\uffff\1\144\1\156\2\145\1\uffff\1\144\1\u00f6"+
        "\1\uffff\1\145\1\156\2\u00f6\1\145\1\154\1\162\1\154\2\157\1\154"+
        "\4\u00f6\1\154\1\uffff\1\u00f6\1\146\1\151\1\164\1\147\1\141\1\161"+
        "\1\154\1\150\1\160\1\145\1\154\2\u00f6\1\uffff\1\154\1\164\1\u00f6"+
        "\1\uffff\1\162\1\uffff\1\145\2\u00f6\1\uffff\1\147\1\144\1\145\1"+
        "\156\1\u00f6\2\uffff\1\147\1\145\1\u00f6\1\157\2\164\1\u00f6\3\uffff"+
        "\1\165\1\uffff\2\145\1\156\1\u00f6\1\157\1\164\1\156\1\160\1\145"+
        "\1\u00f6\1\151\1\145\1\162\1\u00f6\1\uffff\1\164\1\145\1\u00f6\1"+
        "\157\1\145\2\u00f6\1\164\1\167\1\156\1\145\4\u00f6\1\uffff\2\145"+
        "\7\u00f6\1\uffff\1\156\1\u00f6\2\uffff\1\147\1\142\1\145\1\165\1"+
        "\156\1\167\1\u00f6\4\uffff\1\165\1\uffff\1\157\1\156\1\145\1\162"+
        "\1\155\1\165\1\145\1\151\1\154\1\u00f6\1\165\2\uffff\1\155\1\u00f6"+
        "\1\uffff\1\142\1\u00f6\2\uffff\1\162\2\u00f6\1\162\1\uffff\1\154"+
        "\1\162\1\145\1\uffff\1\151\1\141\1\u00f6\1\uffff\1\145\2\u00f6\1"+
        "\162\1\uffff\1\151\1\162\1\164\2\u00f6\1\uffff\1\164\2\u00f6\1\uffff"+
        "\1\145\1\156\1\uffff\1\167\1\u00f6\2\uffff\1\145\1\156\1\u00f6\1"+
        "\156\4\uffff\1\156\1\u00f6\7\uffff\1\162\1\uffff\1\162\1\154\2\145"+
        "\2\u00f6\1\uffff\1\163\1\156\1\147\1\142\1\145\1\141\1\157\1\164"+
        "\1\144\1\145\1\uffff\1\145\1\157\1\uffff\1\154\1\uffff\1\145\2\uffff"+
        "\1\157\1\165\1\145\1\156\1\163\1\u00f6\1\uffff\1\u00f6\2\uffff\1"+
        "\157\1\163\1\145\1\u00f6\2\uffff\1\145\2\uffff\3\u00f6\1\uffff\2"+
        "\u00f6\1\uffff\2\u00f6\1\uffff\1\157\1\145\1\165\1\156\1\u00f6\2"+
        "\uffff\1\150\1\u00f6\1\147\1\154\1\145\1\162\1\151\1\162\3\u00f6"+
        "\1\156\1\165\1\145\1\144\1\145\2\171\1\u00f6\1\145\2\uffff\1\144"+
        "\1\145\1\144\1\uffff\1\u00f6\7\uffff\1\144\2\171\1\145\1\u00f6\1"+
        "\uffff\1\u00f6\1\uffff\1\162\1\165\1\156\1\151\1\163\1\145\3\uffff"+
        "\1\144\1\145\1\156\4\u00f6\1\uffff\4\u00f6\1\uffff\1\171\3\u00f6"+
        "\2\uffff\2\145\1\u00f6\1\156\1\145\1\144\3\u00f6\10\uffff\1\145"+
        "\3\uffff\1\145\1\u00f6\1\uffff\1\145\2\u00f6\3\uffff\1\154\1\156"+
        "\1\uffff\1\u00f6\2\uffff\1\154\1\u00f6\1\uffff\1\157\1\uffff\1\167"+
        "\1\u00f6\1\uffff";
    static final String DFA22_acceptS =
        "\33\uffff\1\u00ba\1\u00bb\1\u00bc\1\u00bd\1\u00be\1\u00bf\1\uffff"+
        "\1\u00c0\4\uffff\1\u00c5\1\u00c6\1\uffff\1\u00c3\1\uffff\1\u00c8"+
        "\1\u00c9\4\uffff\1\u00c3\74\uffff\1\u00c7\22\uffff\1\u00b6\1\u00b7"+
        "\1\u00ba\1\u00bb\1\u00bc\1\u00bd\1\u00be\1\u00bf\1\u00c0\1\u00c1"+
        "\1\u00c2\1\u00c4\1\u00c5\1\u00c6\1\u00c8\135\uffff\1\u00b8\23\uffff"+
        "\1\u00ab\1\u00b4\1\u00b9\1\u00b5\25\uffff\1\u00af\30\uffff\1\u00b2"+
        "\13\uffff\1\u00ae\50\uffff\1\u00b1\3\uffff\1\u00ac\1\u00b3\5\uffff"+
        "\1\u00ad\1\uffff\1\u00b0\11\uffff\1\u009e\5\uffff\1\u00a7\1\u00a8"+
        "\12\uffff\1\u0099\21\uffff\1\u009a\30\uffff\1\u00a0\1\uffff\1\u00a1"+
        "\1\u00a2\2\uffff\1\u0098\13\uffff\1\u009d\1\uffff\1\u009c\3\uffff"+
        "\1\u009b\1\uffff\1\u009f\1\uffff\1\u00a9\12\uffff\1\u00a3\12\uffff"+
        "\1\u00aa\7\uffff\1\u00a4\2\uffff\1\u00a5\2\uffff\1\u00a6\11\uffff"+
        "\1\u008f\14\uffff\1\u0089\4\uffff\1\u0088\1\u008a\1\u0094\2\uffff"+
        "\1\u008b\54\uffff\1\u0093\1\u0087\6\uffff\1\u008c\1\u0095\22\uffff"+
        "\1\u0092\1\u0091\2\uffff\1\u008d\1\uffff\1\u0090\5\uffff\1\u0096"+
        "\3\uffff\1\u0097\5\uffff\1\u008e\20\uffff\1\u0086\14\uffff\1\172"+
        "\4\uffff\1\170\10\uffff\1\u0084\1\u0083\40\uffff\1\174\22\uffff"+
        "\1\175\6\uffff\1\176\1\177\1\uffff\1\u0082\2\uffff\1\171\3\uffff"+
        "\1\173\4\uffff\1\u0080\1\uffff\1\u0085\2\uffff\1\u0081\36\uffff"+
        "\1\160\6\uffff\1\164\4\uffff\1\152\20\uffff\1\153\4\uffff\1\165"+
        "\1\uffff\1\154\1\155\17\uffff\1\166\1\uffff\1\156\5\uffff\1\167"+
        "\10\uffff\1\162\4\uffff\1\161\4\uffff\1\163\2\uffff\1\157\20\uffff"+
        "\1\143\16\uffff\1\144\3\uffff\1\147\1\uffff\1\134\3\uffff\1\150"+
        "\5\uffff\1\140\1\137\7\uffff\1\135\1\136\1\151\1\uffff\1\141\16"+
        "\uffff\1\146\17\uffff\1\145\11\uffff\1\142\2\uffff\1\113\1\112\7"+
        "\uffff\1\111\1\110\1\114\1\115\1\uffff\1\107\13\uffff\1\116\1\117"+
        "\2\uffff\1\75\2\uffff\1\77\1\76\4\uffff\1\100\3\uffff\1\102\3\uffff"+
        "\1\101\4\uffff\1\122\5\uffff\1\123\3\uffff\1\74\2\uffff\1\103\2"+
        "\uffff\1\104\1\105\4\uffff\1\126\1\127\1\130\1\131\2\uffff\1\106"+
        "\1\120\1\121\1\124\1\125\1\132\1\133\1\uffff\1\64\6\uffff\1\63\12"+
        "\uffff\1\65\2\uffff\1\54\1\uffff\1\55\1\uffff\1\56\1\60\6\uffff"+
        "\1\57\1\uffff\1\73\1\61\4\uffff\1\66\1\67\1\uffff\1\53\1\72\3\uffff"+
        "\1\62\2\uffff\1\70\2\uffff\1\71\5\uffff\1\44\1\45\24\uffff\1\37"+
        "\1\40\3\uffff\1\52\1\uffff\1\41\1\42\1\43\1\46\1\47\1\50\1\51\5"+
        "\uffff\1\33\1\uffff\1\32\6\uffff\1\34\1\35\1\36\7\uffff\1\31\4\uffff"+
        "\1\30\4\uffff\1\24\1\23\11\uffff\1\16\1\17\1\20\1\21\1\22\1\25\1"+
        "\26\1\27\1\uffff\1\12\1\13\1\14\2\uffff\1\15\3\uffff\1\7\1\10\1"+
        "\11\2\uffff\1\4\1\uffff\1\5\1\6\2\uffff\1\3\1\uffff\1\2\2\uffff"+
        "\1\1";
    static final String DFA22_specialS =
        "\1\0\u04dc\uffff}>";
    static final String[] DFA22_transitionS = {
            "\11\55\1\54\1\42\2\55\1\41\22\55\1\54\1\55\1\33\1\34\3\55\1"+
            "\47\1\35\1\36\2\55\1\37\1\51\1\26\1\46\12\50\1\40\1\55\1\30"+
            "\1\31\1\32\1\55\1\43\1\7\1\3\1\4\1\5\1\22\1\10\1\11\1\23\1\16"+
            "\1\52\1\25\1\1\1\2\1\12\1\53\1\6\1\52\1\20\1\13\1\21\1\52\1"+
            "\24\1\15\1\52\1\14\1\52\3\55\1\44\1\52\1\55\1\7\1\3\1\4\1\5"+
            "\1\22\1\10\1\11\1\23\1\16\1\52\1\25\1\1\1\2\1\12\1\17\1\6\1"+
            "\52\1\20\1\13\1\21\1\52\1\24\1\15\1\45\1\14\1\52\1\55\1\27\147"+
            "\55\2\52\20\55\1\52\uff09\55",
            "\1\57\3\uffff\1\60\3\uffff\1\56\5\uffff\1\61\21\uffff\1\57"+
            "\3\uffff\1\60\3\uffff\1\56\5\uffff\1\61",
            "\1\66\3\uffff\1\63\3\uffff\1\64\5\uffff\1\65\21\uffff\1\66"+
            "\3\uffff\1\63\3\uffff\1\64\5\uffff\1\65",
            "\1\73\3\uffff\1\72\2\uffff\1\67\2\uffff\1\71\2\uffff\1\74"+
            "\2\uffff\1\70\17\uffff\1\73\3\uffff\1\72\2\uffff\1\67\2\uffff"+
            "\1\71\2\uffff\1\74\2\uffff\1\70",
            "\1\77\3\uffff\1\101\2\uffff\1\76\6\uffff\1\75\2\uffff\1\100"+
            "\6\uffff\1\102\7\uffff\1\77\3\uffff\1\101\2\uffff\1\76\6\uffff"+
            "\1\75\2\uffff\1\100\6\uffff\1\102",
            "\1\103\3\uffff\1\104\3\uffff\1\106\5\uffff\1\105\21\uffff"+
            "\1\103\3\uffff\1\104\3\uffff\1\106\5\uffff\1\105",
            "\1\107\3\uffff\1\111\3\uffff\1\113\2\uffff\1\114\2\uffff\1"+
            "\110\5\uffff\1\112\13\uffff\1\107\3\uffff\1\111\3\uffff\1\113"+
            "\2\uffff\1\114\2\uffff\1\110\5\uffff\1\112",
            "\1\121\10\uffff\1\120\1\uffff\1\115\2\uffff\1\116\3\uffff"+
            "\1\117\4\uffff\1\122\10\uffff\1\121\10\uffff\1\120\1\uffff\1"+
            "\115\2\uffff\1\116\3\uffff\1\117\4\uffff\1\122",
            "\1\125\2\uffff\1\123\2\uffff\1\124\5\uffff\1\126\23\uffff"+
            "\1\125\2\uffff\1\123\2\uffff\1\124\5\uffff\1\126",
            "\1\131\6\uffff\1\130\6\uffff\1\132\2\uffff\1\127\16\uffff"+
            "\1\131\6\uffff\1\130\6\uffff\1\132\2\uffff\1\127",
            "\1\133\3\uffff\1\134\11\uffff\1\135\21\uffff\1\133\3\uffff"+
            "\1\134\11\uffff\1\135",
            "\1\136\3\uffff\1\142\3\uffff\1\144\1\uffff\1\143\1\140\1\uffff"+
            "\1\145\1\uffff\1\137\3\uffff\1\141\14\uffff\1\136\3\uffff\1"+
            "\142\3\uffff\1\144\1\uffff\1\143\1\140\1\uffff\1\145\1\uffff"+
            "\1\137\3\uffff\1\141",
            "\1\146\37\uffff\1\146",
            "\1\147\37\uffff\1\147",
            "\1\150\7\uffff\1\151\27\uffff\1\150\7\uffff\1\151",
            "\1\157\11\uffff\1\156\5\uffff\1\152\3\uffff\1\155\1\uffff"+
            "\1\153\3\uffff\1\154\5\uffff\1\157\11\uffff\1\156\5\uffff\1"+
            "\152\3\uffff\1\155\1\uffff\1\153\3\uffff\1\154",
            "\1\162\3\uffff\1\161\5\uffff\1\160\25\uffff\1\162\3\uffff"+
            "\1\161\5\uffff\1\160",
            "\1\170\3\uffff\1\167\2\uffff\1\164\1\166\5\uffff\1\165\5\uffff"+
            "\1\163\13\uffff\1\170\3\uffff\1\167\2\uffff\1\164\1\166\5\uffff"+
            "\1\165\5\uffff\1\163",
            "\1\172\1\uffff\1\171\35\uffff\1\172\1\uffff\1\171",
            "\1\174\5\uffff\1\173\31\uffff\1\174\5\uffff\1\173",
            "\1\175\37\uffff\1\175",
            "\1\176\37\uffff\1\176",
            "\1\177",
            "\1\u0080",
            "\1\157\16\uffff\1\u0081\77\uffff\1\157",
            "\1\u0082",
            "\1\u0083",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u008a",
            "",
            "\1\u008c\15\uffff\1\u008b",
            "\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff\2\62\20\uffff"+
            "\1\62",
            "\1\157",
            "\1\u008d\5\uffff\1\157\1\uffff\1\157",
            "",
            "",
            "\1\157\20\uffff\1\157\35\uffff\1\157",
            "",
            "\1\156\5\uffff\1\152\3\uffff\1\155\1\uffff\1\153\3\uffff\1"+
            "\154\17\uffff\1\156\5\uffff\1\152\3\uffff\1\155\1\uffff\1\153"+
            "\3\uffff\1\154",
            "",
            "",
            "\1\u0091\5\uffff\1\u0092\1\u0093\30\uffff\1\u0091\5\uffff"+
            "\1\u0092\1\u0093",
            "\1\u0094\1\u0095\36\uffff\1\u0094\1\u0095",
            "\1\u0098\1\u0097\5\uffff\1\u0096\30\uffff\1\u0098\1\u0097"+
            "\5\uffff\1\u0096",
            "\1\u0099\37\uffff\1\u0099",
            "",
            "\1\u009a\37\uffff\1\u009a",
            "\1\u009b\11\uffff\1\u009c\4\uffff\1\u009d\20\uffff\1\u009b"+
            "\11\uffff\1\u009c\4\uffff\1\u009d",
            "\1\u009e\37\uffff\1\u009e",
            "\1\u009f\12\uffff\1\u00a0\24\uffff\1\u009f\12\uffff\1\u00a0",
            "\1\u00a1\23\uffff\1\u00a2\13\uffff\1\u00a1\23\uffff\1\u00a2",
            "\1\u00a3\37\uffff\1\u00a3",
            "\1\u00a4\2\uffff\1\u00a5\34\uffff\1\u00a4\2\uffff\1\u00a5",
            "\1\u00a6\37\uffff\1\u00a6",
            "\1\u00a7\37\uffff\1\u00a7",
            "\1\u00a9\11\uffff\1\u00a8\25\uffff\1\u00a9\11\uffff\1\u00a8",
            "\1\u00ab\3\uffff\1\u00aa\33\uffff\1\u00ab\3\uffff\1\u00aa",
            "\1\u00ac\15\uffff\1\u00ad\21\uffff\1\u00ac\15\uffff\1\u00ad",
            "\1\u00ae\37\uffff\1\u00ae",
            "\1\u00b0\3\uffff\1\u00af\33\uffff\1\u00b0\3\uffff\1\u00af",
            "\1\u00b1\37\uffff\1\u00b1",
            "\1\u00b2\37\uffff\1\u00b2",
            "\1\u00b3\1\uffff\1\u00b4\35\uffff\1\u00b3\1\uffff\1\u00b4",
            "\1\u00b6\3\uffff\1\u00b5\15\uffff\1\u00b7\15\uffff\1\u00b6"+
            "\3\uffff\1\u00b5\15\uffff\1\u00b7",
            "\1\u00b8\37\uffff\1\u00b8",
            "\1\u00b9\37\uffff\1\u00b9",
            "\1\u00ba\3\uffff\1\u00bc\1\uffff\1\u00bb\31\uffff\1\u00ba"+
            "\3\uffff\1\u00bc\1\uffff\1\u00bb",
            "\1\u00bd\37\uffff\1\u00bd",
            "\1\u00be\20\uffff\1\u00bf\16\uffff\1\u00be\20\uffff\1\u00bf",
            "\1\u00c0\37\uffff\1\u00c0",
            "\1\u00c1\37\uffff\1\u00c1",
            "\1\u00c2\37\uffff\1\u00c2",
            "\1\u00c3\37\uffff\1\u00c3",
            "\1\u00c4\37\uffff\1\u00c4",
            "\1\u00c5\37\uffff\1\u00c5",
            "\1\u00c6\12\uffff\1\u00c7\24\uffff\1\u00c6\12\uffff\1\u00c7",
            "\1\u00c8\37\uffff\1\u00c8",
            "\1\u00c9\37\uffff\1\u00c9",
            "\1\u00ca\37\uffff\1\u00ca",
            "\1\u00cc\2\uffff\1\u00cb\34\uffff\1\u00cc\2\uffff\1\u00cb",
            "\1\u00cd\37\uffff\1\u00cd",
            "\1\u00ce\37\uffff\1\u00ce",
            "\1\u00d1\3\uffff\1\u00cf\11\uffff\1\u00d0\21\uffff\1\u00d1"+
            "\3\uffff\1\u00cf\11\uffff\1\u00d0",
            "\1\u00d2\37\uffff\1\u00d2",
            "\1\u00d3\37\uffff\1\u00d3",
            "\1\u00d4\37\uffff\1\u00d4",
            "\1\u00d5\37\uffff\1\u00d5",
            "\1\u00d6\37\uffff\1\u00d6",
            "\1\u00d7\37\uffff\1\u00d7",
            "\1\u00d8\7\uffff\1\u00da\1\uffff\1\u00d9\25\uffff\1\u00d8"+
            "\7\uffff\1\u00da\1\uffff\1\u00d9",
            "\1\u00db\37\uffff\1\u00db",
            "\1\u00dc\37\uffff\1\u00dc",
            "\1\u00dd\37\uffff\1\u00dd",
            "\1\u00de\37\uffff\1\u00de",
            "\1\u00df\37\uffff\1\u00df",
            "\1\u00e0\6\uffff\1\u00e1\30\uffff\1\u00e0\6\uffff\1\u00e1",
            "\1\u00e2\37\uffff\1\u00e2",
            "\1\u00e3\37\uffff\1\u00e3",
            "\1\u00e5\3\uffff\1\u00e4\33\uffff\1\u00e5\3\uffff\1\u00e4",
            "\1\u00e6\37\uffff\1\u00e6",
            "\1\u00e7\37\uffff\1\u00e7",
            "\1\u00e9\4\uffff\1\u00e8\32\uffff\1\u00e9\4\uffff\1\u00e8",
            "\1\u00ea\1\uffff\1\u00eb\35\uffff\1\u00ea\1\uffff\1\u00eb",
            "\1\u00ec\37\uffff\1\u00ec",
            "\1\u00ed\37\uffff\1\u00ed",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u00ef\5\uffff\1\u00f0\31\uffff\1\u00ef\5\uffff\1\u00f0",
            "\1\u00f1\37\uffff\1\u00f1",
            "\1\u00f2\1\uffff\1\u00f3\35\uffff\1\u00f2\1\uffff\1\u00f3",
            "\1\u00f4\37\uffff\1\u00f4",
            "\1\u00f5\37\uffff\1\u00f5",
            "\1\u00f6\37\uffff\1\u00f6",
            "\1\u00f7\37\uffff\1\u00f7",
            "\1\u00f8\37\uffff\1\u00f8",
            "\1\u00f9\37\uffff\1\u00f9",
            "\1\u00fa\17\uffff\1\u00fb\17\uffff\1\u00fa\17\uffff\1\u00fb",
            "\1\u00fc\37\uffff\1\u00fc",
            "\1\u00fd\5\uffff\1\u00fe\31\uffff\1\u00fd\5\uffff\1\u00fe",
            "\1\u00ff\37\uffff\1\u00ff",
            "\1\u0100\37\uffff\1\u0100",
            "\1\u0101\37\uffff\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\157",
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
            "\1\u0106\37\uffff\1\u0106",
            "\1\u0107\37\uffff\1\u0107",
            "\1\u0108\37\uffff\1\u0108",
            "\1\u0109\37\uffff\1\u0109",
            "\1\u010a\37\uffff\1\u010a",
            "\1\u010b\37\uffff\1\u010b",
            "\1\u010c\37\uffff\1\u010c",
            "\1\u010d\37\uffff\1\u010d",
            "\1\u010e\37\uffff\1\u010e",
            "\1\u010f\37\uffff\1\u010f",
            "\1\u0110\37\uffff\1\u0110",
            "\1\u0111\37\uffff\1\u0111",
            "\1\u0112\37\uffff\1\u0112",
            "\1\u0113\37\uffff\1\u0113",
            "\1\u0114\37\uffff\1\u0114",
            "\1\u0115\37\uffff\1\u0115",
            "\1\u0117\12\uffff\1\u0116\24\uffff\1\u0117\12\uffff\1\u0116",
            "\1\u0118\37\uffff\1\u0118",
            "\1\u0119\37\uffff\1\u0119",
            "\1\u011a\37\uffff\1\u011a",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u011c\37\uffff\1\u011c",
            "\1\u011d\37\uffff\1\u011d",
            "\1\u011e\37\uffff\1\u011e",
            "\1\u011f\37\uffff\1\u011f",
            "\1\u0121\14\uffff\1\u0120\22\uffff\1\u0121\14\uffff\1\u0120",
            "\1\u0122\37\uffff\1\u0122",
            "\1\u0123\37\uffff\1\u0123",
            "\1\u0124\37\uffff\1\u0124",
            "\1\u0125\37\uffff\1\u0125",
            "\1\u0127\6\uffff\1\u0126\30\uffff\1\u0127\6\uffff\1\u0126",
            "\1\u0128\37\uffff\1\u0128",
            "\1\u0129\37\uffff\1\u0129",
            "\1\u012a\37\uffff\1\u012a",
            "\1\u012b\37\uffff\1\u012b",
            "\1\u012c\37\uffff\1\u012c",
            "\1\u012d\37\uffff\1\u012d",
            "\1\u012e\37\uffff\1\u012e",
            "\1\u012f\37\uffff\1\u012f",
            "\1\u0130\37\uffff\1\u0130",
            "\1\u0131\37\uffff\1\u0131",
            "\1\u0132\37\uffff\1\u0132",
            "\12\62\7\uffff\23\62\1\u0133\6\62\4\uffff\1\62\1\uffff\23"+
            "\62\1\u0133\6\62\151\uffff\2\62\20\uffff\1\62",
            "\1\u0135\37\uffff\1\u0135",
            "\1\u0136\37\uffff\1\u0136",
            "\1\u0137\37\uffff\1\u0137",
            "\1\u0138\37\uffff\1\u0138",
            "\1\u0139\37\uffff\1\u0139",
            "\1\u013a\37\uffff\1\u013a",
            "\1\u013b\37\uffff\1\u013b",
            "\1\u013c\37\uffff\1\u013c",
            "\1\u013d\37\uffff\1\u013d",
            "\1\u013e\37\uffff\1\u013e",
            "\1\u013f\37\uffff\1\u013f",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0141\5\uffff\1\u0142\31\uffff\1\u0141\5\uffff\1\u0142",
            "\1\u0143\37\uffff\1\u0143",
            "\1\u0144\37\uffff\1\u0144",
            "\1\u0145\37\uffff\1\u0145",
            "\1\u0146\37\uffff\1\u0146",
            "\1\u0147\37\uffff\1\u0147",
            "\1\u0148\37\uffff\1\u0148",
            "\1\u0149\23\uffff\1\u014a\13\uffff\1\u0149\23\uffff\1\u014a",
            "\1\u014b\37\uffff\1\u014b",
            "\1\u014c\37\uffff\1\u014c",
            "\1\u014d\37\uffff\1\u014d",
            "\1\u014e\37\uffff\1\u014e",
            "\1\u014f\37\uffff\1\u014f",
            "\1\u0150\27\uffff\1\u0151\7\uffff\1\u0150\27\uffff\1\u0151",
            "\1\u0152\37\uffff\1\u0152",
            "\1\u0153\37\uffff\1\u0153",
            "\1\u0154\37\uffff\1\u0154",
            "\1\u0155\37\uffff\1\u0155",
            "\1\u0156\37\uffff\1\u0156",
            "\1\u0157\37\uffff\1\u0157",
            "\1\u0158\37\uffff\1\u0158",
            "\1\u0159\37\uffff\1\u0159",
            "\1\u015a\37\uffff\1\u015a",
            "\1\u015b\37\uffff\1\u015b",
            "\1\u015c\37\uffff\1\u015c",
            "\1\u015d\37\uffff\1\u015d",
            "\1\u015e\37\uffff\1\u015e",
            "\1\u015f\37\uffff\1\u015f",
            "\1\u0160\37\uffff\1\u0160",
            "\1\u0161\37\uffff\1\u0161",
            "\1\u0162\37\uffff\1\u0162",
            "\1\u0163\37\uffff\1\u0163",
            "\1\u0164\37\uffff\1\u0164",
            "\1\u0165\37\uffff\1\u0165",
            "\1\u0166\37\uffff\1\u0166",
            "\1\u0167\37\uffff\1\u0167",
            "\1\u0168\37\uffff\1\u0168",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u016a\37\uffff\1\u016a",
            "\1\u016b\37\uffff\1\u016b",
            "\1\u016c\37\uffff\1\u016c",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u016f\37\uffff\1\u016f",
            "\1\u0170\37\uffff\1\u0170",
            "\1\u0171\37\uffff\1\u0171",
            "\1\u0172\37\uffff\1\u0172",
            "\1\u0173\37\uffff\1\u0173",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\13\62\1\u0175\16\62\4\uffff\1\62\1\uffff\13"+
            "\62\1\u0175\16\62\151\uffff\2\62\20\uffff\1\62",
            "\1\u0177\37\uffff\1\u0177",
            "\1\u0178\37\uffff\1\u0178",
            "\1\u0179\37\uffff\1\u0179",
            "\1\u017a\37\uffff\1\u017a",
            "\1\u017b\37\uffff\1\u017b",
            "\1\u017c\37\uffff\1\u017c",
            "\1\u017d\37\uffff\1\u017d",
            "",
            "",
            "",
            "",
            "\1\u017e\37\uffff\1\u017e",
            "\12\62\7\uffff\6\62\1\u017f\23\62\4\uffff\1\62\1\uffff\6\62"+
            "\1\u017f\23\62\151\uffff\2\62\20\uffff\1\62",
            "\1\u0181\37\uffff\1\u0181",
            "\1\u0182\37\uffff\1\u0182",
            "\1\u0183\37\uffff\1\u0183",
            "\1\u0184\37\uffff\1\u0184",
            "\1\u0185\37\uffff\1\u0185",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0188\37\uffff\1\u0188",
            "\1\u0189\37\uffff\1\u0189",
            "\1\u018a\37\uffff\1\u018a",
            "\1\u018b\37\uffff\1\u018b",
            "\1\u018c\37\uffff\1\u018c",
            "\1\u018d\37\uffff\1\u018d",
            "\1\u018e\37\uffff\1\u018e",
            "\1\u018f\37\uffff\1\u018f",
            "\1\u0190\37\uffff\1\u0190",
            "\12\62\7\uffff\25\62\1\u0191\4\62\4\uffff\1\62\1\uffff\25"+
            "\62\1\u0191\4\62\151\uffff\2\62\20\uffff\1\62",
            "\1\u0193\37\uffff\1\u0193",
            "\1\u0194\37\uffff\1\u0194",
            "",
            "\1\u0195\37\uffff\1\u0195",
            "\1\u0196\37\uffff\1\u0196",
            "\1\u0197\37\uffff\1\u0197",
            "\1\u0198\37\uffff\1\u0198",
            "\1\u0199\14\uffff\1\u019a\22\uffff\1\u0199\14\uffff\1\u019a",
            "\1\u019b\37\uffff\1\u019b",
            "\1\u019c\37\uffff\1\u019c",
            "\1\u019d\37\uffff\1\u019d",
            "\1\u019e\37\uffff\1\u019e",
            "\1\u019f\37\uffff\1\u019f",
            "\1\u01a0\37\uffff\1\u01a0",
            "\1\u01a1\37\uffff\1\u01a1",
            "\1\u01a2\37\uffff\1\u01a2",
            "\1\u01a3\37\uffff\1\u01a3",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u01ac\1\u01ad\3\uffff\1\u01a6\3\uffff\1\u01ab\1\uffff\1"+
            "\u01a9\1\uffff\1\u01a5\2\uffff\1\u01ae\1\u01a7\1\u01a8\1\uffff"+
            "\1\u01aa\13\uffff\1\u01ac\1\u01ad\3\uffff\1\u01a6\3\uffff\1"+
            "\u01ab\1\uffff\1\u01a9\1\uffff\1\u01a5\2\uffff\1\u01ae\1\u01a7"+
            "\1\u01a8\1\uffff\1\u01aa",
            "\1\u01af\37\uffff\1\u01af",
            "\1\u01b1\2\uffff\1\u01b0\34\uffff\1\u01b1\2\uffff\1\u01b0",
            "\1\u01b2\37\uffff\1\u01b2",
            "\1\u01b3\37\uffff\1\u01b3",
            "\1\u01b4\37\uffff\1\u01b4",
            "\1\u01b5\37\uffff\1\u01b5",
            "\1\u01b6\14\uffff\1\u01b7\1\uffff\1\u01b8\20\uffff\1\u01b6"+
            "\14\uffff\1\u01b7\1\uffff\1\u01b8",
            "\1\u01b9\37\uffff\1\u01b9",
            "",
            "\1\u01ba\37\uffff\1\u01ba",
            "\1\u01bb\37\uffff\1\u01bb",
            "\1\u01bc\37\uffff\1\u01bc",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u01be\37\uffff\1\u01be",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u01c1\37\uffff\1\u01c1",
            "\12\62\7\uffff\14\62\1\u01c2\15\62\4\uffff\1\62\1\uffff\14"+
            "\62\1\u01c2\15\62\151\uffff\2\62\20\uffff\1\62",
            "\1\u01c4\37\uffff\1\u01c4",
            "\1\u01c5\37\uffff\1\u01c5",
            "",
            "\1\u01c6\37\uffff\1\u01c6",
            "\1\u01c7\37\uffff\1\u01c7",
            "\1\u01c8\37\uffff\1\u01c8",
            "\1\u01c9\37\uffff\1\u01c9",
            "\1\u01ca\37\uffff\1\u01ca",
            "\1\u01cb\37\uffff\1\u01cb",
            "\1\u01cc\37\uffff\1\u01cc",
            "\1\u01cd\37\uffff\1\u01cd",
            "\1\u01ce\37\uffff\1\u01ce",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u01d0\37\uffff\1\u01d0",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u01d2\37\uffff\1\u01d2",
            "\1\u01d3\37\uffff\1\u01d3",
            "\12\62\7\uffff\4\62\1\u01d4\25\62\4\uffff\1\62\1\uffff\4\62"+
            "\1\u01d4\25\62\151\uffff\2\62\20\uffff\1\62",
            "\1\u01d6\37\uffff\1\u01d6",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u01d8\37\uffff\1\u01d8",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u01da\37\uffff\1\u01da",
            "\1\u01db\37\uffff\1\u01db",
            "\1\u01dc\37\uffff\1\u01dc",
            "\1\u01dd\37\uffff\1\u01dd",
            "\1\u01de\37\uffff\1\u01de",
            "\1\u01df\37\uffff\1\u01df",
            "\1\u01e0\37\uffff\1\u01e0",
            "\1\u01e1\37\uffff\1\u01e1",
            "\1\u01e2\37\uffff\1\u01e2",
            "\1\u01e3\37\uffff\1\u01e3",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u01e5\37\uffff\1\u01e5",
            "\1\u01e6\37\uffff\1\u01e6",
            "\1\u01e7\37\uffff\1\u01e7",
            "\1\u01e8\5\uffff\1\u01e9\31\uffff\1\u01e8\5\uffff\1\u01e9",
            "\1\u01ea\37\uffff\1\u01ea",
            "\1\u01eb\37\uffff\1\u01eb",
            "\1\u01ec\37\uffff\1\u01ec",
            "\1\u01ed\37\uffff\1\u01ed",
            "\1\u01ee\37\uffff\1\u01ee",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u01f0\37\uffff\1\u01f0",
            "\1\u01f1\37\uffff\1\u01f1",
            "\1\u01f2\37\uffff\1\u01f2",
            "",
            "",
            "\1\u01f3\37\uffff\1\u01f3",
            "\1\u01f4\37\uffff\1\u01f4",
            "\1\u01f5\37\uffff\1\u01f5",
            "\1\u01f6\37\uffff\1\u01f6",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u01f8\37\uffff\1\u01f8",
            "",
            "\1\u01f9\37\uffff\1\u01f9",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u01fb\37\uffff\1\u01fb",
            "\1\u01fc\37\uffff\1\u01fc",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u01fe\37\uffff\1\u01fe",
            "\1\u01ff\37\uffff\1\u01ff",
            "\1\u0204\1\u0203\3\uffff\1\u0200\10\uffff\1\u0205\2\uffff"+
            "\1\u0201\5\uffff\1\u0202\10\uffff\1\u0204\1\u0203\3\uffff\1"+
            "\u0200\10\uffff\1\u0205\2\uffff\1\u0201\5\uffff\1\u0202",
            "\1\u0206\37\uffff\1\u0206",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0208\37\uffff\1\u0208",
            "\1\u0209\37\uffff\1\u0209",
            "\1\u020a\37\uffff\1\u020a",
            "\1\u020b\37\uffff\1\u020b",
            "",
            "",
            "\1\u020c\37\uffff\1\u020c",
            "\1\u020d\37\uffff\1\u020d",
            "\1\u020e\37\uffff\1\u020e",
            "\1\u020f\37\uffff\1\u020f",
            "\1\u0210\37\uffff\1\u0210",
            "\1\u0211\37\uffff\1\u0211",
            "\1\u0212\37\uffff\1\u0212",
            "\1\u0213\37\uffff\1\u0213",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0215\37\uffff\1\u0215",
            "",
            "\1\u0216\37\uffff\1\u0216",
            "\1\u0217\37\uffff\1\u0217",
            "\1\u0218\37\uffff\1\u0218",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u021c\37\uffff\1\u021c",
            "\1\u021d\37\uffff\1\u021d",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u021f\37\uffff\1\u021f",
            "\1\u0220\37\uffff\1\u0220",
            "\1\u0221\37\uffff\1\u0221",
            "\1\u0222\37\uffff\1\u0222",
            "\1\u0223\37\uffff\1\u0223",
            "\1\u0224\37\uffff\1\u0224",
            "\1\u0225\37\uffff\1\u0225",
            "\1\u0226\37\uffff\1\u0226",
            "",
            "\1\u0227\5\uffff\1\u0228\31\uffff\1\u0227\5\uffff\1\u0228",
            "\1\u0229\2\uffff\1\u022a\34\uffff\1\u0229\2\uffff\1\u022a",
            "\1\u022d\3\uffff\1\u022c\6\uffff\1\u022b\24\uffff\1\u022d"+
            "\3\uffff\1\u022c\6\uffff\1\u022b",
            "\1\u022e\37\uffff\1\u022e",
            "\1\u022f\37\uffff\1\u022f",
            "\1\u0230\37\uffff\1\u0230",
            "\1\u0231\37\uffff\1\u0231",
            "\1\u0232\37\uffff\1\u0232",
            "\1\u0233\37\uffff\1\u0233",
            "\1\u0234\37\uffff\1\u0234",
            "\1\u0235\37\uffff\1\u0235",
            "\1\u0236\37\uffff\1\u0236",
            "\1\u0237\37\uffff\1\u0237",
            "\1\u0238\37\uffff\1\u0238",
            "\1\u0239\37\uffff\1\u0239",
            "\1\u023a\37\uffff\1\u023a",
            "\1\u023b\3\uffff\1\u023c\33\uffff\1\u023b\3\uffff\1\u023c",
            "\1\u023d\2\uffff\1\u023e\34\uffff\1\u023d\2\uffff\1\u023e",
            "\1\u023f\37\uffff\1\u023f",
            "\1\u0240\37\uffff\1\u0240",
            "\1\u0241\37\uffff\1\u0241",
            "\1\u0242\37\uffff\1\u0242",
            "\1\u0243\37\uffff\1\u0243",
            "\1\u0244\37\uffff\1\u0244",
            "",
            "\1\u0245\37\uffff\1\u0245",
            "",
            "",
            "\1\u0246\37\uffff\1\u0246",
            "\1\u0247\37\uffff\1\u0247",
            "",
            "\1\u0248\37\uffff\1\u0248",
            "\1\u0249\37\uffff\1\u0249",
            "\1\u024a\37\uffff\1\u024a",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u024d\37\uffff\1\u024d",
            "\1\u024e\37\uffff\1\u024e",
            "\1\u024f\37\uffff\1\u024f",
            "\1\u0250\37\uffff\1\u0250",
            "\1\u0251\37\uffff\1\u0251",
            "\12\62\7\uffff\30\62\1\u0252\1\62\4\uffff\1\62\1\uffff\30"+
            "\62\1\u0252\1\62\151\uffff\2\62\20\uffff\1\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u0255\37\uffff\1\u0255",
            "\1\u0256\37\uffff\1\u0256",
            "\1\u0257\37\uffff\1\u0257",
            "",
            "\1\u0258\37\uffff\1\u0258",
            "",
            "\1\u0259\37\uffff\1\u0259",
            "",
            "\1\u025a\37\uffff\1\u025a",
            "\1\u025b\37\uffff\1\u025b",
            "\1\u025c\37\uffff\1\u025c",
            "\1\u025d\37\uffff\1\u025d",
            "\1\u025e\4\uffff\1\u025f\32\uffff\1\u025e\4\uffff\1\u025f",
            "\1\u0260\37\uffff\1\u0260",
            "\1\u0261\37\uffff\1\u0261",
            "\1\u0262\37\uffff\1\u0262",
            "\1\u0263\37\uffff\1\u0263",
            "\1\u0264\37\uffff\1\u0264",
            "",
            "\1\u0265\37\uffff\1\u0265",
            "\12\62\7\uffff\22\62\1\u0266\7\62\4\uffff\1\62\1\uffff\22"+
            "\62\1\u0266\7\62\151\uffff\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0269\37\uffff\1\u0269",
            "\1\u026a\37\uffff\1\u026a",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\3\62\1\u026c\26\62\4\uffff\1\62\1\uffff\3\62"+
            "\1\u026c\26\62\151\uffff\2\62\20\uffff\1\62",
            "\1\u026e\37\uffff\1\u026e",
            "\1\u026f\37\uffff\1\u026f",
            "\1\u0270\37\uffff\1\u0270",
            "",
            "\1\u0271\37\uffff\1\u0271",
            "\1\u0272\37\uffff\1\u0272",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0274\37\uffff\1\u0274",
            "\1\u0275\37\uffff\1\u0275",
            "\1\u0276\37\uffff\1\u0276",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u0278\37\uffff\1\u0278",
            "\1\u0279\37\uffff\1\u0279",
            "",
            "\1\u027a\37\uffff\1\u027a",
            "\1\u027b\37\uffff\1\u027b",
            "",
            "\1\u027c\37\uffff\1\u027c",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u027e\2\uffff\1\u027f\34\uffff\1\u027e\2\uffff\1\u027f",
            "\1\u0284\3\uffff\1\u0282\5\uffff\1\u0283\1\u0280\7\uffff\1"+
            "\u0281\14\uffff\1\u0284\3\uffff\1\u0282\5\uffff\1\u0283\1\u0280"+
            "\7\uffff\1\u0281",
            "\1\u0285\37\uffff\1\u0285",
            "\1\u0286\11\uffff\1\u0287\25\uffff\1\u0286\11\uffff\1\u0287",
            "\1\u0288\37\uffff\1\u0288",
            "\1\u0289\37\uffff\1\u0289",
            "\1\u028a\37\uffff\1\u028a",
            "",
            "\1\u028b\37\uffff\1\u028b",
            "\1\u028c\37\uffff\1\u028c",
            "\1\u028d\37\uffff\1\u028d",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0290\1\u0295\14\uffff\1\u0293\1\u0294\2\uffff\1\u028f"+
            "\1\u0291\1\uffff\1\u0292\12\uffff\1\u0290\1\u0295\14\uffff\1"+
            "\u0293\1\u0294\2\uffff\1\u028f\1\u0291\1\uffff\1\u0292",
            "\1\u0296\37\uffff\1\u0296",
            "\1\u0297\37\uffff\1\u0297",
            "\1\u0298\37\uffff\1\u0298",
            "\1\u0299\37\uffff\1\u0299",
            "\1\u029a\37\uffff\1\u029a",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u029c\37\uffff\1\u029c",
            "",
            "\1\u029d\37\uffff\1\u029d",
            "\1\u029e\37\uffff\1\u029e",
            "\1\u029f\37\uffff\1\u029f",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "",
            "\1\u02a1\37\uffff\1\u02a1",
            "\1\u02a2\37\uffff\1\u02a2",
            "",
            "\1\u02a3\37\uffff\1\u02a3",
            "\1\u02a4\37\uffff\1\u02a4",
            "\1\u02a5\37\uffff\1\u02a5",
            "\1\u02a6\37\uffff\1\u02a6",
            "\1\u02a7\37\uffff\1\u02a7",
            "\1\u02a8\37\uffff\1\u02a8",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u02ab\37\uffff\1\u02ab",
            "\1\u02ad\1\uffff\1\u02ac\35\uffff\1\u02ad\1\uffff\1\u02ac",
            "\1\u02ae\37\uffff\1\u02ae",
            "\1\u02b0\3\uffff\1\u02af\33\uffff\1\u02b0\3\uffff\1\u02af",
            "\1\u02b1\37\uffff\1\u02b1",
            "\1\u02b2\37\uffff\1\u02b2",
            "\1\u02b3\37\uffff\1\u02b3",
            "\1\u02b4\37\uffff\1\u02b4",
            "\1\u02b5\37\uffff\1\u02b5",
            "\1\u02b6\37\uffff\1\u02b6",
            "\1\u02b7\37\uffff\1\u02b7",
            "\1\u02b8\37\uffff\1\u02b8",
            "\1\u02b9\37\uffff\1\u02b9",
            "\1\u02ba\37\uffff\1\u02ba",
            "\1\u02bb\37\uffff\1\u02bb",
            "\1\u02bc\37\uffff\1\u02bc",
            "\1\u02bd\37\uffff\1\u02bd",
            "\1\u02be\37\uffff\1\u02be",
            "\1\u02bf\37\uffff\1\u02bf",
            "\1\u02c0\37\uffff\1\u02c0",
            "\1\u02c1\37\uffff\1\u02c1",
            "\1\u02c2\37\uffff\1\u02c2",
            "\1\u02c3\37\uffff\1\u02c3",
            "\1\u02c4\37\uffff\1\u02c4",
            "\1\u02c5\37\uffff\1\u02c5",
            "\1\u02c6\37\uffff\1\u02c6",
            "\1\u02c7\37\uffff\1\u02c7",
            "\1\u02c8\37\uffff\1\u02c8",
            "\1\u02c9\37\uffff\1\u02c9",
            "\1\u02ca\37\uffff\1\u02ca",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u02cc\37\uffff\1\u02cc",
            "\1\u02cd\37\uffff\1\u02cd",
            "\1\u02ce\37\uffff\1\u02ce",
            "\1\u02cf\37\uffff\1\u02cf",
            "\1\u02d0\37\uffff\1\u02d0",
            "",
            "",
            "\1\u02d1\37\uffff\1\u02d1",
            "\1\u02d2\37\uffff\1\u02d2",
            "\1\u02d3\37\uffff\1\u02d3",
            "\1\u02d4\37\uffff\1\u02d4",
            "\1\u02d5\37\uffff\1\u02d5",
            "\1\u02d6\37\uffff\1\u02d6",
            "",
            "",
            "\1\u02d7\37\uffff\1\u02d7",
            "\1\u02d8\37\uffff\1\u02d8",
            "\1\u02d9\37\uffff\1\u02d9",
            "\1\u02da\37\uffff\1\u02da",
            "\1\u02db\37\uffff\1\u02db",
            "\1\u02dc\37\uffff\1\u02dc",
            "\1\u02dd\37\uffff\1\u02dd",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u02df\37\uffff\1\u02df",
            "\1\u02e0\37\uffff\1\u02e0",
            "\1\u02e1\37\uffff\1\u02e1",
            "\1\u02e2\37\uffff\1\u02e2",
            "\1\u02e3\37\uffff\1\u02e3",
            "\1\u02e4\37\uffff\1\u02e4",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\6\62\1\u02e7\23\62\4\uffff\1\62\1\uffff\6\62"+
            "\1\u02e7\23\62\151\uffff\2\62\20\uffff\1\62",
            "\1\u02e9\37\uffff\1\u02e9",
            "",
            "",
            "\1\u02ea\37\uffff\1\u02ea",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u02ec\37\uffff\1\u02ec",
            "",
            "\1\u02ed\37\uffff\1\u02ed",
            "\1\u02ee\37\uffff\1\u02ee",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u02f0\37\uffff\1\u02f0",
            "\1\u02f1\37\uffff\1\u02f1",
            "",
            "\1\u02f2\37\uffff\1\u02f2",
            "\1\u02f3\37\uffff\1\u02f3",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u02f5\37\uffff\1\u02f5",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u02f7\37\uffff\1\u02f7",
            "\1\u02f8\37\uffff\1\u02f8",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u02fa\37\uffff\1\u02fa",
            "\1\u02fc\3\uffff\1\u02fb\33\uffff\1\u02fc\3\uffff\1\u02fb",
            "\1\u02fd\37\uffff\1\u02fd",
            "\1\u02fe\37\uffff\1\u02fe",
            "\1\u02ff\37\uffff\1\u02ff",
            "\1\u0300\37\uffff\1\u0300",
            "\1\u0301\37\uffff\1\u0301",
            "\1\u0302\37\uffff\1\u0302",
            "\1\u0303\37\uffff\1\u0303",
            "\1\u0304\37\uffff\1\u0304",
            "\1\u0305\37\uffff\1\u0305",
            "\1\u0306\37\uffff\1\u0306",
            "\1\u0307\37\uffff\1\u0307",
            "\1\u0308\37\uffff\1\u0308",
            "\1\u0309\37\uffff\1\u0309",
            "\1\u030a\37\uffff\1\u030a",
            "",
            "\1\u030d\6\uffff\1\u030c\3\uffff\1\u030b\24\uffff\1\u030d"+
            "\6\uffff\1\u030c\3\uffff\1\u030b",
            "\1\u030e\37\uffff\1\u030e",
            "\1\u030f\37\uffff\1\u030f",
            "\1\u0310\37\uffff\1\u0310",
            "\1\u0311\37\uffff\1\u0311",
            "\1\u0312\37\uffff\1\u0312",
            "\1\u0313\37\uffff\1\u0313",
            "\1\u0314\37\uffff\1\u0314",
            "\1\u0315\37\uffff\1\u0315",
            "\1\u0316\37\uffff\1\u0316",
            "\1\u0317\37\uffff\1\u0317",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u0319\37\uffff\1\u0319",
            "\1\u031a\37\uffff\1\u031a",
            "\1\u031b\37\uffff\1\u031b",
            "\1\u031c\37\uffff\1\u031c",
            "",
            "\1\u031d\37\uffff\1\u031d",
            "\1\u031e\37\uffff\1\u031e",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0320\37\uffff\1\u0320",
            "\1\u0321\37\uffff\1\u0321",
            "\1\u0322\37\uffff\1\u0322",
            "\1\u0323\37\uffff\1\u0323",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "\1\u0325\37\uffff\1\u0325",
            "\1\u0326\37\uffff\1\u0326",
            "\1\u0327\37\uffff\1\u0327",
            "\1\u0328\37\uffff\1\u0328",
            "\1\u0329\23\uffff\1\u032a\13\uffff\1\u0329\23\uffff\1\u032a",
            "\1\u032b\37\uffff\1\u032b",
            "\1\u032c\37\uffff\1\u032c",
            "\1\u032d\37\uffff\1\u032d",
            "\1\u032e\37\uffff\1\u032e",
            "\1\u032f\37\uffff\1\u032f",
            "\1\u0330\37\uffff\1\u0330",
            "\1\u0331\37\uffff\1\u0331",
            "\1\u0332\37\uffff\1\u0332",
            "\1\u0333\37\uffff\1\u0333",
            "\1\u0334\37\uffff\1\u0334",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0336\37\uffff\1\u0336",
            "\1\u0337\37\uffff\1\u0337",
            "\1\u0338\37\uffff\1\u0338",
            "\1\u0339\37\uffff\1\u0339",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u033b\37\uffff\1\u033b",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u033e\37\uffff\1\u033e",
            "\1\u033f\37\uffff\1\u033f",
            "\1\u0340\37\uffff\1\u0340",
            "\1\u0341\37\uffff\1\u0341",
            "\1\u0342\37\uffff\1\u0342",
            "\1\u0343\37\uffff\1\u0343",
            "\1\u0344\37\uffff\1\u0344",
            "\1\u0345\37\uffff\1\u0345",
            "",
            "\1\u0346\37\uffff\1\u0346",
            "\1\u0347\37\uffff\1\u0347",
            "\1\u0348\37\uffff\1\u0348",
            "\1\u0349\37\uffff\1\u0349",
            "\1\u034a\37\uffff\1\u034a",
            "\1\u034b\37\uffff\1\u034b",
            "\1\u034c\37\uffff\1\u034c",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u034e\37\uffff\1\u034e",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0350\37\uffff\1\u0350",
            "\1\u0351\37\uffff\1\u0351",
            "\1\u0352\37\uffff\1\u0352",
            "\1\u0353\37\uffff\1\u0353",
            "\1\u0354\37\uffff\1\u0354",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0356\37\uffff\1\u0356",
            "\1\u0357\37\uffff\1\u0357",
            "",
            "\1\u0358\37\uffff\1\u0358",
            "\1\u0359\37\uffff\1\u0359",
            "\1\u035a\3\uffff\1\u035b\33\uffff\1\u035a\3\uffff\1\u035b",
            "\1\u035c\37\uffff\1\u035c",
            "\1\u035d\37\uffff\1\u035d",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "\1\u035f\37\uffff\1\u035f",
            "",
            "\1\u0360\37\uffff\1\u0360",
            "\1\u0361\37\uffff\1\u0361",
            "",
            "\1\u0362\37\uffff\1\u0362",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0364\37\uffff\1\u0364",
            "",
            "\1\u0365\37\uffff\1\u0365",
            "\1\u0366\37\uffff\1\u0366",
            "\1\u0367\37\uffff\1\u0367",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u0369\37\uffff\1\u0369",
            "",
            "\1\u036a\37\uffff\1\u036a",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u036c\37\uffff\1\u036c",
            "\1\u036d\23\uffff\1\u036e\13\uffff\1\u036d\23\uffff\1\u036e",
            "\1\u036f\37\uffff\1\u036f",
            "\1\u0370\37\uffff\1\u0370",
            "\1\u0371\37\uffff\1\u0371",
            "\1\u0372\37\uffff\1\u0372",
            "\1\u0373\37\uffff\1\u0373",
            "\1\u0374\37\uffff\1\u0374",
            "\1\u0375\37\uffff\1\u0375",
            "\1\u0376\37\uffff\1\u0376",
            "\1\u0377\37\uffff\1\u0377",
            "\1\u0378\37\uffff\1\u0378",
            "\1\u0379\37\uffff\1\u0379",
            "\1\u037a\37\uffff\1\u037a",
            "\12\62\7\uffff\1\62\1\u037b\30\62\4\uffff\1\62\1\uffff\1\62"+
            "\1\u037b\30\62\151\uffff\2\62\20\uffff\1\62",
            "\1\u037d\37\uffff\1\u037d",
            "\1\u037e\37\uffff\1\u037e",
            "\1\u037f\37\uffff\1\u037f",
            "\1\u0380\37\uffff\1\u0380",
            "\1\u0381\37\uffff\1\u0381",
            "\1\u0382\37\uffff\1\u0382",
            "\1\u0383\37\uffff\1\u0383",
            "\1\u0384\37\uffff\1\u0384",
            "\1\u0385\37\uffff\1\u0385",
            "\1\u0386\37\uffff\1\u0386",
            "\1\u0387\37\uffff\1\u0387",
            "\1\u0388\37\uffff\1\u0388",
            "\1\u0389\37\uffff\1\u0389",
            "\1\u038a\37\uffff\1\u038a",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u038c\37\uffff\1\u038c",
            "\1\u038d\37\uffff\1\u038d",
            "\1\u038e\37\uffff\1\u038e",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0390\37\uffff\1\u0390",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u0392\37\uffff\1\u0392",
            "\1\u0393\37\uffff\1\u0393",
            "\1\u0394\37\uffff\1\u0394",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u0396\37\uffff\1\u0396",
            "\1\u0397\37\uffff\1\u0397",
            "\1\u0398\37\uffff\1\u0398",
            "\1\u0399\37\uffff\1\u0399",
            "\1\u039a\37\uffff\1\u039a",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u039d\37\uffff\1\u039d",
            "\1\u039e\37\uffff\1\u039e",
            "\1\u039f\37\uffff\1\u039f",
            "\1\u03a0\37\uffff\1\u03a0",
            "\1\u03a1\37\uffff\1\u03a1",
            "\1\u03a2\37\uffff\1\u03a2",
            "\1\u03a3\37\uffff\1\u03a3",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u03a7\37\uffff\1\u03a7",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u03a9\37\uffff\1\u03a9",
            "",
            "\1\u03aa\37\uffff\1\u03aa",
            "",
            "",
            "\1\u03ab\37\uffff\1\u03ab",
            "\1\u03ac\37\uffff\1\u03ac",
            "\1\u03ad\37\uffff\1\u03ad",
            "\1\u03ae\37\uffff\1\u03ae",
            "\1\u03af\37\uffff\1\u03af",
            "\1\u03b0\37\uffff\1\u03b0",
            "\1\u03b1\37\uffff\1\u03b1",
            "\1\u03b2\37\uffff\1\u03b2",
            "\1\u03b3\37\uffff\1\u03b3",
            "\1\u03b4\37\uffff\1\u03b4",
            "\1\u03b5\37\uffff\1\u03b5",
            "\1\u03b6\37\uffff\1\u03b6",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u03b8\37\uffff\1\u03b8",
            "\1\u03b9\37\uffff\1\u03b9",
            "",
            "\1\u03ba\37\uffff\1\u03ba",
            "",
            "\1\u03bb\37\uffff\1\u03bb",
            "\1\u03bc\37\uffff\1\u03bc",
            "\1\u03bd\37\uffff\1\u03bd",
            "\1\u03be\37\uffff\1\u03be",
            "\1\u03bf\37\uffff\1\u03bf",
            "",
            "\1\u03c0\37\uffff\1\u03c0",
            "\1\u03c1\37\uffff\1\u03c1",
            "\1\u03c2\37\uffff\1\u03c2",
            "\1\u03c3\37\uffff\1\u03c3",
            "\1\u03c4\37\uffff\1\u03c4",
            "\1\u03c5\37\uffff\1\u03c5",
            "\1\u03c6\37\uffff\1\u03c6",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u03c8\37\uffff\1\u03c8",
            "\1\u03c9\37\uffff\1\u03c9",
            "\1\u03ca\37\uffff\1\u03ca",
            "\1\u03cb\37\uffff\1\u03cb",
            "",
            "\1\u03cc\37\uffff\1\u03cc",
            "\1\u03cd\37\uffff\1\u03cd",
            "\1\u03ce\37\uffff\1\u03ce",
            "\1\u03cf\37\uffff\1\u03cf",
            "",
            "\1\u03d0\37\uffff\1\u03d0",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u03d2\37\uffff\1\u03d2",
            "\1\u03d3\37\uffff\1\u03d3",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u03d6\37\uffff\1\u03d6",
            "\1\u03d7\37\uffff\1\u03d7",
            "\1\u03d8\37\uffff\1\u03d8",
            "\1\u03d9\37\uffff\1\u03d9",
            "\1\u03da\37\uffff\1\u03da",
            "\1\u03db\37\uffff\1\u03db",
            "\1\u03dc\37\uffff\1\u03dc",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u03e1\37\uffff\1\u03e1",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u03e3\37\uffff\1\u03e3",
            "\1\u03e4\37\uffff\1\u03e4",
            "\1\u03e5\37\uffff\1\u03e5",
            "\1\u03e6\37\uffff\1\u03e6",
            "\1\u03e7\37\uffff\1\u03e7",
            "\1\u03e8\37\uffff\1\u03e8",
            "\1\u03e9\37\uffff\1\u03e9",
            "\1\u03ea\37\uffff\1\u03ea",
            "\1\u03eb\37\uffff\1\u03eb",
            "\1\u03ec\37\uffff\1\u03ec",
            "\1\u03ed\37\uffff\1\u03ed",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u03f0\37\uffff\1\u03f0",
            "\1\u03f1\37\uffff\1\u03f1",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u03f3\37\uffff\1\u03f3",
            "",
            "\1\u03f4\37\uffff\1\u03f4",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u03f7\37\uffff\1\u03f7",
            "\1\u03f8\37\uffff\1\u03f8",
            "\1\u03f9\37\uffff\1\u03f9",
            "\1\u03fa\37\uffff\1\u03fa",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "\1\u03fc\4\uffff\1\u03fd\32\uffff\1\u03fc\4\uffff\1\u03fd",
            "\1\u03fe\37\uffff\1\u03fe",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0400\37\uffff\1\u0400",
            "\1\u0401\37\uffff\1\u0401",
            "\1\u0402\37\uffff\1\u0402",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "",
            "\1\u0404\37\uffff\1\u0404",
            "",
            "\1\u0405\37\uffff\1\u0405",
            "\1\u0406\37\uffff\1\u0406",
            "\1\u0407\37\uffff\1\u0407",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0409\37\uffff\1\u0409",
            "\1\u040a\37\uffff\1\u040a",
            "\1\u040b\37\uffff\1\u040b",
            "\1\u040c\37\uffff\1\u040c",
            "\1\u040d\37\uffff\1\u040d",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u040f\37\uffff\1\u040f",
            "\1\u0410\37\uffff\1\u0410",
            "\1\u0411\37\uffff\1\u0411",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u0413\37\uffff\1\u0413",
            "\1\u0414\37\uffff\1\u0414",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0416\37\uffff\1\u0416",
            "\1\u0417\37\uffff\1\u0417",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u041a\37\uffff\1\u041a",
            "\1\u041b\37\uffff\1\u041b",
            "\1\u041c\37\uffff\1\u041c",
            "\1\u041d\37\uffff\1\u041d",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u0422\37\uffff\1\u0422",
            "\1\u0423\37\uffff\1\u0423",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u042b\37\uffff\1\u042b",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "\1\u042d\37\uffff\1\u042d",
            "\1\u042e\37\uffff\1\u042e",
            "\1\u042f\37\uffff\1\u042f",
            "\1\u0430\37\uffff\1\u0430",
            "\1\u0431\37\uffff\1\u0431",
            "\1\u0432\37\uffff\1\u0432",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "",
            "",
            "\1\u0434\37\uffff\1\u0434",
            "",
            "\1\u0435\37\uffff\1\u0435",
            "\1\u0436\37\uffff\1\u0436",
            "\1\u0437\37\uffff\1\u0437",
            "\1\u0438\37\uffff\1\u0438",
            "\1\u0439\37\uffff\1\u0439",
            "\1\u043a\37\uffff\1\u043a",
            "\1\u043b\37\uffff\1\u043b",
            "\1\u043c\37\uffff\1\u043c",
            "\1\u043d\37\uffff\1\u043d",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u043f\37\uffff\1\u043f",
            "",
            "",
            "\1\u0440\37\uffff\1\u0440",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u0442\37\uffff\1\u0442",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "\1\u0444\37\uffff\1\u0444",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0447\37\uffff\1\u0447",
            "",
            "\1\u0448\37\uffff\1\u0448",
            "\1\u0449\37\uffff\1\u0449",
            "\1\u044a\37\uffff\1\u044a",
            "",
            "\1\u044b\37\uffff\1\u044b",
            "\1\u044c\37\uffff\1\u044c",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u044e\37\uffff\1\u044e",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0451\37\uffff\1\u0451",
            "",
            "\1\u0452\37\uffff\1\u0452",
            "\1\u0453\37\uffff\1\u0453",
            "\1\u0454\37\uffff\1\u0454",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u0457\37\uffff\1\u0457",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u045a\37\uffff\1\u045a",
            "\1\u045b\37\uffff\1\u045b",
            "",
            "\1\u045c\37\uffff\1\u045c",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "\1\u045e\37\uffff\1\u045e",
            "\1\u045f\37\uffff\1\u045f",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0461\37\uffff\1\u0461",
            "",
            "",
            "",
            "",
            "\1\u0462\37\uffff\1\u0462",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0464\37\uffff\1\u0464",
            "",
            "\1\u0465\37\uffff\1\u0465",
            "\1\u0466\37\uffff\1\u0466",
            "\1\u0467\37\uffff\1\u0467",
            "\1\u0468\37\uffff\1\u0468",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u046b\37\uffff\1\u046b",
            "\1\u046c\37\uffff\1\u046c",
            "\1\u046d\37\uffff\1\u046d",
            "\1\u046e\37\uffff\1\u046e",
            "\1\u046f\37\uffff\1\u046f",
            "\1\u0470\37\uffff\1\u0470",
            "\1\u0471\37\uffff\1\u0471",
            "\1\u0472\37\uffff\1\u0472",
            "\1\u0473\37\uffff\1\u0473",
            "\1\u0474\37\uffff\1\u0474",
            "",
            "\1\u0475\37\uffff\1\u0475",
            "\1\u0476\37\uffff\1\u0476",
            "",
            "\1\u0477\37\uffff\1\u0477",
            "",
            "\1\u0478\37\uffff\1\u0478",
            "",
            "",
            "\1\u0479\37\uffff\1\u0479",
            "\1\u047a\37\uffff\1\u047a",
            "\1\u047b\3\uffff\1\u047c\33\uffff\1\u047b\3\uffff\1\u047c",
            "\1\u047d\37\uffff\1\u047d",
            "\1\u047e\37\uffff\1\u047e",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "\1\u0481\37\uffff\1\u0481",
            "\1\u0482\37\uffff\1\u0482",
            "\1\u0483\37\uffff\1\u0483",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "\1\u0485\37\uffff\1\u0485",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u048d\37\uffff\1\u048d",
            "\1\u048e\3\uffff\1\u048f\33\uffff\1\u048e\3\uffff\1\u048f",
            "\1\u0490\37\uffff\1\u0490",
            "\1\u0491\37\uffff\1\u0491",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "\1\u0493\37\uffff\1\u0493",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u0495\37\uffff\1\u0495",
            "\1\u0496\37\uffff\1\u0496",
            "\1\u0497\37\uffff\1\u0497",
            "\1\u0498\37\uffff\1\u0498",
            "\1\u0499\37\uffff\1\u0499",
            "\1\u049a\37\uffff\1\u049a",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u049e\37\uffff\1\u049e",
            "\1\u049f\37\uffff\1\u049f",
            "\1\u04a0\37\uffff\1\u04a0",
            "\1\u04a1\37\uffff\1\u04a1",
            "\1\u04a2\37\uffff\1\u04a2",
            "\1\u04a3\37\uffff\1\u04a3",
            "\1\u04a4\37\uffff\1\u04a4",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u04a6\37\uffff\1\u04a6",
            "",
            "",
            "\1\u04a7\37\uffff\1\u04a7",
            "\1\u04a8\37\uffff\1\u04a8",
            "\1\u04a9\37\uffff\1\u04a9",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u04ab\37\uffff\1\u04ab",
            "\1\u04ac\37\uffff\1\u04ac",
            "\1\u04ad\37\uffff\1\u04ad",
            "\1\u04ae\37\uffff\1\u04ae",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u04b1\37\uffff\1\u04b1",
            "\1\u04b2\37\uffff\1\u04b2",
            "\1\u04b3\37\uffff\1\u04b3",
            "\1\u04b4\37\uffff\1\u04b4",
            "\1\u04b5\37\uffff\1\u04b5",
            "\1\u04b6\37\uffff\1\u04b6",
            "",
            "",
            "",
            "\1\u04b7\37\uffff\1\u04b7",
            "\1\u04b8\37\uffff\1\u04b8",
            "\1\u04b9\37\uffff\1\u04b9",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u04c2\37\uffff\1\u04c2",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "\1\u04c6\37\uffff\1\u04c6",
            "\1\u04c7\37\uffff\1\u04c7",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\1\u04c9\37\uffff\1\u04c9",
            "\1\u04ca\37\uffff\1\u04ca",
            "\1\u04cb\37\uffff\1\u04cb",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u04cf\37\uffff\1\u04cf",
            "",
            "",
            "",
            "\1\u04d0\37\uffff\1\u04d0",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u04d2\37\uffff\1\u04d2",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "",
            "\1\u04d5\37\uffff\1\u04d5",
            "\1\u04d6\37\uffff\1\u04d6",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "",
            "\1\u04d8\37\uffff\1\u04d8",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
            "",
            "\1\u04da\37\uffff\1\u04da",
            "",
            "\1\u04db\37\uffff\1\u04db",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62\151\uffff"+
            "\2\62\20\uffff\1\62",
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
            return "1:1: Tokens : ( LightGoldenRodYellow | MediumSpringGreen | MediumAquaMarine | MediumSlateBlue | MediumTurquoise | MediumVioletRed | BlanchedAlmond | CornflowerBlue | DarkOliveGreen | LightSlateGray | LightSlateGrey | LightSteelBlue | MediumSeaGreen | DarkGoldenRod | DarkSlateBlue | DarkSlateGray | DarkSlateGrey | DarkTurquoise | LavenderBlush | LightSeaGreen | PaleGoldenRod | PaleTurquoise | PaleVioletRed | AntiqueWhite | DarkSeaGreen | LemonChiffon | LightSkyBlue | MediumOrchid | MediumPurple | MidnightBlue | DarkMagenta | DeepSkyBlue | FloralWhite | ForestGreen | GreenYellow | LightSalmon | LightYellow | NavajoWhite | SaddleBrown | SpringGreen | YellowGreen | Participant | Aquamarine | BlueViolet | Chartreuse | DarkOrchid | DarkViolet | Darkorange | DodgerBlue | GhostWhite | LightCoral | LightGreen | MediumBlue | PapayaWhip | PowderBlue | SandyBrown | WhiteSmoke | Autonumber | Deactivate | AliceBlue | BurlyWood | CadetBlue | Chocolate | DarkGreen | DarkKhaki | DarkSalmo | FireBrick | Gainsboro | GoldenRod | IndianRed | LawnGreen | LightBlue | LightCyan | LightGray | LightGrey | LightPink | LimeGreen | MintCream | MistyRose | OliveDrab | OrangeRed | PaleGreen | PeachPuff | RosyBrown | RoyalBlue | SlateBlue | SlateGray | SlateGrey | SteelBlue | Turquoise | Endlegend | Cornsilk | DarkBlue | DarkCyan | DarkGray | DarkGrey | DeepPink | HoneyDew | Lavender | Moccasin | SeaGreen | Activate | Boundary | Critical | Database | Crimson | DarkRed | DimGray | DimGrey | Fuchsia | HotPink | Magenta | OldLace | SkyBlue | Thistle | Control | Destroy | Footbox | Newpage | Bisque | Indigo | Maroon | Orchid | Purple | Salmon | Sienna | Silver | Tomato | Violet | Yellow | Center | Create | Entity | Legend | Azure | Beige | Black | Brown | Coral | Green | Ivory | Khaki | Linen | Olive | Wheat | White | Actor | Break | Group | Right | Title | Aqua | Blue | Cyan | Gold | Gray | Grey | Lime | Navy | Peru | Pink | Plum | Snow | Teal | Else | Hide | Left | Loop | Note | Over | FullStopFullStopFullStop | Red | Tan | Alt | Box | End | Opt | Par | Ref | VerticalLineVerticalLineVerticalLine | LessThanSignLessThanSign | EqualsSignEqualsSign | GreaterThanSignGreaterThanSign | Of | VerticalLineVerticalLine | QuotationMark | NumberSign | LeftParenthesis | RightParenthesis | Comma | Colon | RULE_NEWLINE | RULE_START | RULE_END | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_INT | RULE_SEQUENCE | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_0 = input.LA(1);

                        s = -1;
                        if ( (LA22_0=='L'||LA22_0=='l') ) {s = 1;}

                        else if ( (LA22_0=='M'||LA22_0=='m') ) {s = 2;}

                        else if ( (LA22_0=='B'||LA22_0=='b') ) {s = 3;}

                        else if ( (LA22_0=='C'||LA22_0=='c') ) {s = 4;}

                        else if ( (LA22_0=='D'||LA22_0=='d') ) {s = 5;}

                        else if ( (LA22_0=='P'||LA22_0=='p') ) {s = 6;}

                        else if ( (LA22_0=='A'||LA22_0=='a') ) {s = 7;}

                        else if ( (LA22_0=='F'||LA22_0=='f') ) {s = 8;}

                        else if ( (LA22_0=='G'||LA22_0=='g') ) {s = 9;}

                        else if ( (LA22_0=='N'||LA22_0=='n') ) {s = 10;}

                        else if ( (LA22_0=='S'||LA22_0=='s') ) {s = 11;}

                        else if ( (LA22_0=='Y'||LA22_0=='y') ) {s = 12;}

                        else if ( (LA22_0=='W'||LA22_0=='w') ) {s = 13;}

                        else if ( (LA22_0=='I'||LA22_0=='i') ) {s = 14;}

                        else if ( (LA22_0=='o') ) {s = 15;}

                        else if ( (LA22_0=='R'||LA22_0=='r') ) {s = 16;}

                        else if ( (LA22_0=='T'||LA22_0=='t') ) {s = 17;}

                        else if ( (LA22_0=='E'||LA22_0=='e') ) {s = 18;}

                        else if ( (LA22_0=='H'||LA22_0=='h') ) {s = 19;}

                        else if ( (LA22_0=='V'||LA22_0=='v') ) {s = 20;}

                        else if ( (LA22_0=='K'||LA22_0=='k') ) {s = 21;}

                        else if ( (LA22_0=='.') ) {s = 22;}

                        else if ( (LA22_0=='|') ) {s = 23;}

                        else if ( (LA22_0=='<') ) {s = 24;}

                        else if ( (LA22_0=='=') ) {s = 25;}

                        else if ( (LA22_0=='>') ) {s = 26;}

                        else if ( (LA22_0=='\"') ) {s = 27;}

                        else if ( (LA22_0=='#') ) {s = 28;}

                        else if ( (LA22_0=='(') ) {s = 29;}

                        else if ( (LA22_0==')') ) {s = 30;}

                        else if ( (LA22_0==',') ) {s = 31;}

                        else if ( (LA22_0==':') ) {s = 32;}

                        else if ( (LA22_0=='\r') ) {s = 33;}

                        else if ( (LA22_0=='\n') ) {s = 34;}

                        else if ( (LA22_0=='@') ) {s = 35;}

                        else if ( (LA22_0=='^') ) {s = 36;}

                        else if ( (LA22_0=='x') ) {s = 37;}

                        else if ( (LA22_0=='/') ) {s = 38;}

                        else if ( (LA22_0=='\'') ) {s = 39;}

                        else if ( ((LA22_0>='0' && LA22_0<='9')) ) {s = 40;}

                        else if ( (LA22_0=='-') ) {s = 41;}

                        else if ( (LA22_0=='J'||LA22_0=='Q'||LA22_0=='U'||LA22_0=='X'||LA22_0=='Z'||LA22_0=='_'||LA22_0=='j'||LA22_0=='q'||LA22_0=='u'||LA22_0=='z'||(LA22_0>='\u00E4' && LA22_0<='\u00E5')||LA22_0=='\u00F6') ) {s = 42;}

                        else if ( (LA22_0=='O') ) {s = 43;}

                        else if ( (LA22_0=='\t'||LA22_0==' ') ) {s = 44;}

                        else if ( ((LA22_0>='\u0000' && LA22_0<='\b')||(LA22_0>='\u000B' && LA22_0<='\f')||(LA22_0>='\u000E' && LA22_0<='\u001F')||LA22_0=='!'||(LA22_0>='$' && LA22_0<='&')||(LA22_0>='*' && LA22_0<='+')||LA22_0==';'||LA22_0=='?'||(LA22_0>='[' && LA22_0<=']')||LA22_0=='`'||LA22_0=='{'||(LA22_0>='}' && LA22_0<='\u00E3')||(LA22_0>='\u00E6' && LA22_0<='\u00F5')||(LA22_0>='\u00F7' && LA22_0<='\uFFFF')) ) {s = 45;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}