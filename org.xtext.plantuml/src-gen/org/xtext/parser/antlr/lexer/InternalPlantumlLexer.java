package org.xtext.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPlantumlLexer extends Lexer {
    public static final int Par=36;
    public static final int Entity=18;
    public static final int Left=27;
    public static final int RULE_SEQUENCE=56;
    public static final int Break=21;
    public static final int Alt=32;
    public static final int Critical=10;
    public static final int FullStopFullStopFullStop=31;
    public static final int Boundary=9;
    public static final int Opt=35;
    public static final int LeftParenthesis=45;
    public static final int Actor=20;
    public static final int VerticalLineVerticalLineVerticalLine=38;
    public static final int Database=11;
    public static final int RULE_ID=53;
    public static final int Endlegend=7;
    public static final int RightParenthesis=46;
    public static final int Box=33;
    public static final int EqualsSignEqualsSign=40;
    public static final int Participant=4;
    public static final int Activate=8;
    public static final int RULE_INT=52;
    public static final int Note=29;
    public static final int RULE_ML_COMMENT=54;
    public static final int RULE_HEXCODE=58;
    public static final int End=34;
    public static final int LessThanSignLessThanSign=39;
    public static final int Hide=26;
    public static final int Group=22;
    public static final int Legend=19;
    public static final int RULE_END=51;
    public static final int RULE_START=50;
    public static final int VerticalLineVerticalLine=43;
    public static final int RULE_NEWLINE=49;
    public static final int Right=23;
    public static final int Footbox=14;
    public static final int QuotationMark=44;
    public static final int Newpage=15;
    public static final int RULE_SL_COMMENT=55;
    public static final int Over=30;
    public static final int Comma=47;
    public static final int Control=12;
    public static final int Destroy=13;
    public static final int Create=17;
    public static final int RULE_COLOR=57;
    public static final int Deactivate=6;
    public static final int Colon=48;
    public static final int EOF=-1;
    public static final int Loop=28;
    public static final int Center=16;
    public static final int RULE_WS=59;
    public static final int Title=24;
    public static final int RULE_ANY_OTHER=60;
    public static final int GreaterThanSignGreaterThanSign=41;
    public static final int Ref=37;
    public static final int Of=42;
    public static final int Else=25;
    public static final int Autonumber=5;

    // delegates
    // delegators

    public InternalPlantumlLexer() {;} 
    public InternalPlantumlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalPlantumlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g"; }

    // $ANTLR start "Participant"
    public final void mParticipant() throws RecognitionException {
        try {
            int _type = Participant;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:19:13: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'I' | 'i' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:19:15: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'I' | 'i' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' )
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

    // $ANTLR start "Autonumber"
    public final void mAutonumber() throws RecognitionException {
        try {
            int _type = Autonumber;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:21:12: ( ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:21:14: ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:23:12: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:23:14: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
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

    // $ANTLR start "Endlegend"
    public final void mEndlegend() throws RecognitionException {
        try {
            int _type = Endlegend;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:25:11: ( ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:25:13: ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' )
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

    // $ANTLR start "Activate"
    public final void mActivate() throws RecognitionException {
        try {
            int _type = Activate;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:27:10: ( ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:27:12: ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:29:10: ( ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:29:12: ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'Y' | 'y' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:31:10: ( ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:31:12: ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'L' | 'l' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:33:10: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'B' | 'b' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:33:12: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'B' | 'b' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' )
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

    // $ANTLR start "Control"
    public final void mControl() throws RecognitionException {
        try {
            int _type = Control;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:35:9: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'L' | 'l' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:35:11: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'L' | 'l' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:37:9: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:37:11: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'Y' | 'y' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:39:9: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'O' | 'o' ) ( 'T' | 't' ) ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'X' | 'x' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:39:11: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'O' | 'o' ) ( 'T' | 't' ) ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'X' | 'x' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:41:9: ( ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:41:11: ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'E' | 'e' )
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

    // $ANTLR start "Center"
    public final void mCenter() throws RecognitionException {
        try {
            int _type = Center;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:43:8: ( ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:43:10: ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:45:8: ( ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:45:10: ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:47:8: ( ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'Y' | 'y' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:47:10: ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'Y' | 'y' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:49:8: ( ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:49:10: ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' )
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

    // $ANTLR start "Actor"
    public final void mActor() throws RecognitionException {
        try {
            int _type = Actor;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:51:7: ( ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:51:9: ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:53:7: ( ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'K' | 'k' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:53:9: ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'K' | 'k' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:55:7: ( ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'P' | 'p' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:55:9: ( 'G' | 'g' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'P' | 'p' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:57:7: ( ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:57:9: ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:59:7: ( ( 'T' | 't' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'L' | 'l' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:59:9: ( 'T' | 't' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'L' | 'l' ) ( 'E' | 'e' )
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

    // $ANTLR start "Else"
    public final void mElse() throws RecognitionException {
        try {
            int _type = Else;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:61:6: ( ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:61:8: ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:63:6: ( ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:63:8: ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'D' | 'd' ) ( 'E' | 'e' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:65:6: ( ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'T' | 't' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:65:8: ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'T' | 't' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:67:6: ( ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'O' | 'o' ) ( 'P' | 'p' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:67:8: ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'O' | 'o' ) ( 'P' | 'p' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:69:6: ( ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:69:8: ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:71:6: ( ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:71:8: ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:73:26: ( '.' '.' '.' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:73:28: '.' '.' '.'
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

    // $ANTLR start "Alt"
    public final void mAlt() throws RecognitionException {
        try {
            int _type = Alt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:75:5: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'T' | 't' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:75:7: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'T' | 't' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:77:5: ( ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'X' | 'x' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:77:7: ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'X' | 'x' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:79:5: ( ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:79:7: ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:81:5: ( ( 'O' | 'o' ) ( 'P' | 'p' ) ( 'T' | 't' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:81:7: ( 'O' | 'o' ) ( 'P' | 'p' ) ( 'T' | 't' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:83:5: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'R' | 'r' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:83:7: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'R' | 'r' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:85:5: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'F' | 'f' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:85:7: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'F' | 'f' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:87:38: ( '|' '|' '|' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:87:40: '|' '|' '|'
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:89:26: ( '<' '<' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:89:28: '<' '<'
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:91:22: ( '=' '=' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:91:24: '=' '='
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:93:32: ( '>' '>' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:93:34: '>' '>'
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:95:4: ( ( 'O' | 'o' ) ( 'F' | 'f' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:95:6: ( 'O' | 'o' ) ( 'F' | 'f' )
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:97:26: ( '|' '|' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:97:28: '|' '|'
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:99:15: ( '\"' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:99:17: '\"'
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

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:101:17: ( '(' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:101:19: '('
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:103:18: ( ')' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:103:20: ')'
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:105:7: ( ',' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:105:9: ','
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:107:7: ( ':' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:107:9: ':'
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:111:14: ( ( '\\r' )? '\\n' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:111:16: ( '\\r' )? '\\n'
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:111:16: ( '\\r' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='\r') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:111:16: '\\r'
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:113:12: ( '@' 'startuml' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:113:14: '@' 'startuml'
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:115:10: ( '@' 'enduml' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:115:12: '@' 'enduml'
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

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:117:10: ( ( '0' .. '9' )+ )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:117:12: ( '0' .. '9' )+
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:117:12: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:117:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:119:9: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '\\u00E5' | '\\u00E4' | '\\u00F6' )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:119:11: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '\\u00E5' | '\\u00E4' | '\\u00F6' )*
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:119:11: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '\\u00E5' | '\\u00E4' | '\\u00F6' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||(LA3_0>='a' && LA3_0<='z')||(LA3_0>='\u00E4' && LA3_0<='\u00E5')||LA3_0=='\u00F6') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00E4' && input.LA(1)<='\u00E5')||input.LA(1)=='\u00F6' ) {
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:121:17: ( '/\\'' ( options {greedy=false; } : . )* '\\'/' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:121:19: '/\\'' ( options {greedy=false; } : . )* '\\'/'
            {
            match("/'"); 

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:121:25: ( options {greedy=false; } : . )*
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
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:121:53: .
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:123:17: ( '\\'' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:123:19: '\\'' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match('\''); 
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:123:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:123:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:123:40: ( ( '\\r' )? '\\n' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\n'||LA7_0=='\r') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:123:41: ( '\\r' )? '\\n'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:123:41: ( '\\r' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='\r') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:123:41: '\\r'
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

    // $ANTLR start "RULE_SEQUENCE"
    public final void mRULE_SEQUENCE() throws RecognitionException {
        try {
            int _type = RULE_SEQUENCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:15: ( ( ( '-' )* '-' '>' | '<' '-' ( '-' )* | '-' '>' 'x' | 'x' '<' '-' | ( '-' )* '-' '>' '>' | '<' '<' '-' ( '-' )* | ( '-' )* '-' '\\\\' '\\\\' | '/' '-' ( '-' )* | '/' '/' '-' ( '-' )* | ( '-' )* '-' '>' 'o' | 'o' '<' '-' ( '-' )* | ( '-' )* '-' '-' '/' '/' 'o' | 'o' '\\\\\\\\' '-' '-' ( '-' )* | '<' '-' '>' | '<' '-' '>' 'o' | 'o' '<' '-' '>' | '<' '|' '-' '-' | '-' '-' '|' '>' | '.' '.' | '.' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:17: ( ( '-' )* '-' '>' | '<' '-' ( '-' )* | '-' '>' 'x' | 'x' '<' '-' | ( '-' )* '-' '>' '>' | '<' '<' '-' ( '-' )* | ( '-' )* '-' '\\\\' '\\\\' | '/' '-' ( '-' )* | '/' '/' '-' ( '-' )* | ( '-' )* '-' '>' 'o' | 'o' '<' '-' ( '-' )* | ( '-' )* '-' '-' '/' '/' 'o' | 'o' '\\\\\\\\' '-' '-' ( '-' )* | '<' '-' '>' | '<' '-' '>' 'o' | 'o' '<' '-' '>' | '<' '|' '-' '-' | '-' '-' '|' '>' | '.' '.' | '.' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:17: ( ( '-' )* '-' '>' | '<' '-' ( '-' )* | '-' '>' 'x' | 'x' '<' '-' | ( '-' )* '-' '>' '>' | '<' '<' '-' ( '-' )* | ( '-' )* '-' '\\\\' '\\\\' | '/' '-' ( '-' )* | '/' '/' '-' ( '-' )* | ( '-' )* '-' '>' 'o' | 'o' '<' '-' ( '-' )* | ( '-' )* '-' '-' '/' '/' 'o' | 'o' '\\\\\\\\' '-' '-' ( '-' )* | '<' '-' '>' | '<' '-' '>' 'o' | 'o' '<' '-' '>' | '<' '|' '-' '-' | '-' '-' '|' '>' | '.' '.' | '.' )
            int alt19=20;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:18: ( '-' )* '-' '>'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:18: ( '-' )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='-') ) {
                            int LA8_1 = input.LA(2);

                            if ( (LA8_1=='-') ) {
                                alt8=1;
                            }


                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:18: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match('-'); 
                    match('>'); 

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:31: '<' '-' ( '-' )*
                    {
                    match('<'); 
                    match('-'); 
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:39: ( '-' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='-') ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:39: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:44: '-' '>' 'x'
                    {
                    match('-'); 
                    match('>'); 
                    match('x'); 

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:56: 'x' '<' '-'
                    {
                    match('x'); 
                    match('<'); 
                    match('-'); 

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:68: ( '-' )* '-' '>' '>'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:68: ( '-' )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0=='-') ) {
                            int LA10_1 = input.LA(2);

                            if ( (LA10_1=='-') ) {
                                alt10=1;
                            }


                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:68: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match('-'); 
                    match('>'); 
                    match('>'); 

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:85: '<' '<' '-' ( '-' )*
                    {
                    match('<'); 
                    match('<'); 
                    match('-'); 
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:97: ( '-' )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0=='-') ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:97: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:102: ( '-' )* '-' '\\\\' '\\\\'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:102: ( '-' )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='-') ) {
                            int LA12_1 = input.LA(2);

                            if ( (LA12_1=='-') ) {
                                alt12=1;
                            }


                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:102: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    match('-'); 
                    match('\\'); 
                    match('\\'); 

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:121: '/' '-' ( '-' )*
                    {
                    match('/'); 
                    match('-'); 
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:129: ( '-' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='-') ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:129: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:134: '/' '/' '-' ( '-' )*
                    {
                    match('/'); 
                    match('/'); 
                    match('-'); 
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:146: ( '-' )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0=='-') ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:146: '-'
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
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:151: ( '-' )* '-' '>' 'o'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:151: ( '-' )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0=='-') ) {
                            int LA15_1 = input.LA(2);

                            if ( (LA15_1=='-') ) {
                                alt15=1;
                            }


                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:151: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    match('-'); 
                    match('>'); 
                    match('o'); 

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:168: 'o' '<' '-' ( '-' )*
                    {
                    match('o'); 
                    match('<'); 
                    match('-'); 
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:180: ( '-' )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0=='-') ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:180: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:185: ( '-' )* '-' '-' '/' '/' 'o'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:185: ( '-' )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0=='-') ) {
                            int LA17_1 = input.LA(2);

                            if ( (LA17_1=='-') ) {
                                int LA17_2 = input.LA(3);

                                if ( (LA17_2=='-') ) {
                                    alt17=1;
                                }


                            }


                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:185: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:210: 'o' '\\\\\\\\' '-' '-' ( '-' )*
                    {
                    match('o'); 
                    match("\\\\"); 

                    match('-'); 
                    match('-'); 
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:229: ( '-' )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0=='-') ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:229: '-'
                    	    {
                    	    match('-'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:234: '<' '-' '>'
                    {
                    match('<'); 
                    match('-'); 
                    match('>'); 

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:246: '<' '-' '>' 'o'
                    {
                    match('<'); 
                    match('-'); 
                    match('>'); 
                    match('o'); 

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:262: 'o' '<' '-' '>'
                    {
                    match('o'); 
                    match('<'); 
                    match('-'); 
                    match('>'); 

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:278: '<' '|' '-' '-'
                    {
                    match('<'); 
                    match('|'); 
                    match('-'); 
                    match('-'); 

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:294: '-' '-' '|' '>'
                    {
                    match('-'); 
                    match('-'); 
                    match('|'); 
                    match('>'); 

                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:310: '.' '.'
                    {
                    match('.'); 
                    match('.'); 

                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:125:318: '.'
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

    // $ANTLR start "RULE_COLOR"
    public final void mRULE_COLOR() throws RecognitionException {
        try {
            int _type = RULE_COLOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:12: ( '#' ( 'AliceBlue' | 'AntiqueWhite' | 'Aqua' | 'Aquamarine' | 'Azure' | 'Beige' | 'Bisque' | 'Black' | 'BlanchedAlmond' | 'Blue' | 'BlueViolet' | 'Brown' | 'BurlyWood' | 'CadetBlue' | 'Chartreuse' | 'Chocolate' | 'Coral' | 'CornflowerBlue' | 'Cornsilk' | 'Crimson' | 'Cyan' | 'DarkBlue' | 'DarkCyan' | 'DarkGoldenRod' | 'DarkGray' | 'DarkGreen' | 'DarkGrey' | 'DarkKhaki' | 'DarkMagenta' | 'DarkOliveGreen' | 'DarkOrchid' | 'DarkRed' | 'DarkSalmo' | 'DarkSeaGreen' | 'DarkSlateBlue' | 'DarkSlateGray' | 'DarkSlateGrey' | 'DarkTurquoise' | 'DarkViolet' | 'Darkorange' | 'DeepPink' | 'DeepSkyBlue' | 'DimGray' | 'DimGrey' | 'DodgerBlue' | 'FireBrick' | 'FloralWhite' | 'ForestGreen' | 'Fuchsia' | 'Gainsboro' | 'GhostWhite' | 'Gold' | 'GoldenRod' | 'Gray' | 'Green' | 'GreenYellow' | 'Grey' | 'HoneyDew' | 'HotPink' | 'IndianRed' | 'Indigo' | 'Ivory' | 'Khaki' | 'Lavender' | 'LavenderBlush' | 'LawnGreen' | 'LemonChiffon' | 'LightBlue' | 'LightCoral' | 'LightCyan' | 'LightGoldenRodYellow' | 'LightGray' | 'LightGreen' | 'LightGrey' | 'LightPink' | 'LightSalmon' | 'LightSeaGreen' | 'LightSkyBlue' | 'LightSlateGray' | 'LightSlateGrey' | 'LightSteelBlue' | 'LightYellow' | 'Lime' | 'LimeGreen' | 'Linen' | 'Magenta' | 'Maroon' | 'MediumAquaMarine' | 'MediumBlue' | 'MediumOrchid' | 'MediumPurple' | 'MediumSeaGreen' | 'MediumSlateBlue' | 'MediumSpringGreen' | 'MediumTurquoise' | 'MediumVioletRed' | 'MidnightBlue' | 'MintCream' | 'MistyRose' | 'Moccasin' | 'NavajoWhite' | 'Navy' | 'OldLace' | 'Olive' | 'OliveDrab' | 'OrangeRed' | 'Orchid' | 'PaleGoldenRod' | 'PaleGreen' | 'PaleTurquoise' | 'PaleVioletRed' | 'PapayaWhip' | 'PeachPuff' | 'Peru' | 'Pink' | 'Plum' | 'PowderBlue' | 'Purple' | 'Red' | 'RosyBrown' | 'RoyalBlue' | 'SaddleBrown' | 'Salmon' | 'SandyBrown' | 'SeaGreen' | 'Sienna' | 'Silver' | 'SkyBlue' | 'SlateBlue' | 'SlateGray' | 'SlateGrey' | 'Snow' | 'SpringGreen' | 'SteelBlue' | 'Tan' | 'Teal' | 'Thistle' | 'Tomato' | 'Turquoise' | 'Violet' | 'Wheat' | 'White' | 'WhiteSmoke' | 'Yellow' | 'YellowGreen' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:14: '#' ( 'AliceBlue' | 'AntiqueWhite' | 'Aqua' | 'Aquamarine' | 'Azure' | 'Beige' | 'Bisque' | 'Black' | 'BlanchedAlmond' | 'Blue' | 'BlueViolet' | 'Brown' | 'BurlyWood' | 'CadetBlue' | 'Chartreuse' | 'Chocolate' | 'Coral' | 'CornflowerBlue' | 'Cornsilk' | 'Crimson' | 'Cyan' | 'DarkBlue' | 'DarkCyan' | 'DarkGoldenRod' | 'DarkGray' | 'DarkGreen' | 'DarkGrey' | 'DarkKhaki' | 'DarkMagenta' | 'DarkOliveGreen' | 'DarkOrchid' | 'DarkRed' | 'DarkSalmo' | 'DarkSeaGreen' | 'DarkSlateBlue' | 'DarkSlateGray' | 'DarkSlateGrey' | 'DarkTurquoise' | 'DarkViolet' | 'Darkorange' | 'DeepPink' | 'DeepSkyBlue' | 'DimGray' | 'DimGrey' | 'DodgerBlue' | 'FireBrick' | 'FloralWhite' | 'ForestGreen' | 'Fuchsia' | 'Gainsboro' | 'GhostWhite' | 'Gold' | 'GoldenRod' | 'Gray' | 'Green' | 'GreenYellow' | 'Grey' | 'HoneyDew' | 'HotPink' | 'IndianRed' | 'Indigo' | 'Ivory' | 'Khaki' | 'Lavender' | 'LavenderBlush' | 'LawnGreen' | 'LemonChiffon' | 'LightBlue' | 'LightCoral' | 'LightCyan' | 'LightGoldenRodYellow' | 'LightGray' | 'LightGreen' | 'LightGrey' | 'LightPink' | 'LightSalmon' | 'LightSeaGreen' | 'LightSkyBlue' | 'LightSlateGray' | 'LightSlateGrey' | 'LightSteelBlue' | 'LightYellow' | 'Lime' | 'LimeGreen' | 'Linen' | 'Magenta' | 'Maroon' | 'MediumAquaMarine' | 'MediumBlue' | 'MediumOrchid' | 'MediumPurple' | 'MediumSeaGreen' | 'MediumSlateBlue' | 'MediumSpringGreen' | 'MediumTurquoise' | 'MediumVioletRed' | 'MidnightBlue' | 'MintCream' | 'MistyRose' | 'Moccasin' | 'NavajoWhite' | 'Navy' | 'OldLace' | 'Olive' | 'OliveDrab' | 'OrangeRed' | 'Orchid' | 'PaleGoldenRod' | 'PaleGreen' | 'PaleTurquoise' | 'PaleVioletRed' | 'PapayaWhip' | 'PeachPuff' | 'Peru' | 'Pink' | 'Plum' | 'PowderBlue' | 'Purple' | 'Red' | 'RosyBrown' | 'RoyalBlue' | 'SaddleBrown' | 'Salmon' | 'SandyBrown' | 'SeaGreen' | 'Sienna' | 'Silver' | 'SkyBlue' | 'SlateBlue' | 'SlateGray' | 'SlateGrey' | 'Snow' | 'SpringGreen' | 'SteelBlue' | 'Tan' | 'Teal' | 'Thistle' | 'Tomato' | 'Turquoise' | 'Violet' | 'Wheat' | 'White' | 'WhiteSmoke' | 'Yellow' | 'YellowGreen' )
            {
            match('#'); 
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:18: ( 'AliceBlue' | 'AntiqueWhite' | 'Aqua' | 'Aquamarine' | 'Azure' | 'Beige' | 'Bisque' | 'Black' | 'BlanchedAlmond' | 'Blue' | 'BlueViolet' | 'Brown' | 'BurlyWood' | 'CadetBlue' | 'Chartreuse' | 'Chocolate' | 'Coral' | 'CornflowerBlue' | 'Cornsilk' | 'Crimson' | 'Cyan' | 'DarkBlue' | 'DarkCyan' | 'DarkGoldenRod' | 'DarkGray' | 'DarkGreen' | 'DarkGrey' | 'DarkKhaki' | 'DarkMagenta' | 'DarkOliveGreen' | 'DarkOrchid' | 'DarkRed' | 'DarkSalmo' | 'DarkSeaGreen' | 'DarkSlateBlue' | 'DarkSlateGray' | 'DarkSlateGrey' | 'DarkTurquoise' | 'DarkViolet' | 'Darkorange' | 'DeepPink' | 'DeepSkyBlue' | 'DimGray' | 'DimGrey' | 'DodgerBlue' | 'FireBrick' | 'FloralWhite' | 'ForestGreen' | 'Fuchsia' | 'Gainsboro' | 'GhostWhite' | 'Gold' | 'GoldenRod' | 'Gray' | 'Green' | 'GreenYellow' | 'Grey' | 'HoneyDew' | 'HotPink' | 'IndianRed' | 'Indigo' | 'Ivory' | 'Khaki' | 'Lavender' | 'LavenderBlush' | 'LawnGreen' | 'LemonChiffon' | 'LightBlue' | 'LightCoral' | 'LightCyan' | 'LightGoldenRodYellow' | 'LightGray' | 'LightGreen' | 'LightGrey' | 'LightPink' | 'LightSalmon' | 'LightSeaGreen' | 'LightSkyBlue' | 'LightSlateGray' | 'LightSlateGrey' | 'LightSteelBlue' | 'LightYellow' | 'Lime' | 'LimeGreen' | 'Linen' | 'Magenta' | 'Maroon' | 'MediumAquaMarine' | 'MediumBlue' | 'MediumOrchid' | 'MediumPurple' | 'MediumSeaGreen' | 'MediumSlateBlue' | 'MediumSpringGreen' | 'MediumTurquoise' | 'MediumVioletRed' | 'MidnightBlue' | 'MintCream' | 'MistyRose' | 'Moccasin' | 'NavajoWhite' | 'Navy' | 'OldLace' | 'Olive' | 'OliveDrab' | 'OrangeRed' | 'Orchid' | 'PaleGoldenRod' | 'PaleGreen' | 'PaleTurquoise' | 'PaleVioletRed' | 'PapayaWhip' | 'PeachPuff' | 'Peru' | 'Pink' | 'Plum' | 'PowderBlue' | 'Purple' | 'Red' | 'RosyBrown' | 'RoyalBlue' | 'SaddleBrown' | 'Salmon' | 'SandyBrown' | 'SeaGreen' | 'Sienna' | 'Silver' | 'SkyBlue' | 'SlateBlue' | 'SlateGray' | 'SlateGrey' | 'Snow' | 'SpringGreen' | 'SteelBlue' | 'Tan' | 'Teal' | 'Thistle' | 'Tomato' | 'Turquoise' | 'Violet' | 'Wheat' | 'White' | 'WhiteSmoke' | 'Yellow' | 'YellowGreen' )
            int alt20=145;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:19: 'AliceBlue'
                    {
                    match("AliceBlue"); 


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:31: 'AntiqueWhite'
                    {
                    match("AntiqueWhite"); 


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:46: 'Aqua'
                    {
                    match("Aqua"); 


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:53: 'Aquamarine'
                    {
                    match("Aquamarine"); 


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:66: 'Azure'
                    {
                    match("Azure"); 


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:74: 'Beige'
                    {
                    match("Beige"); 


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:82: 'Bisque'
                    {
                    match("Bisque"); 


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:91: 'Black'
                    {
                    match("Black"); 


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:99: 'BlanchedAlmond'
                    {
                    match("BlanchedAlmond"); 


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:116: 'Blue'
                    {
                    match("Blue"); 


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:123: 'BlueViolet'
                    {
                    match("BlueViolet"); 


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:136: 'Brown'
                    {
                    match("Brown"); 


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:144: 'BurlyWood'
                    {
                    match("BurlyWood"); 


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:156: 'CadetBlue'
                    {
                    match("CadetBlue"); 


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:168: 'Chartreuse'
                    {
                    match("Chartreuse"); 


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:181: 'Chocolate'
                    {
                    match("Chocolate"); 


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:193: 'Coral'
                    {
                    match("Coral"); 


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:201: 'CornflowerBlue'
                    {
                    match("CornflowerBlue"); 


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:218: 'Cornsilk'
                    {
                    match("Cornsilk"); 


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:229: 'Crimson'
                    {
                    match("Crimson"); 


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:239: 'Cyan'
                    {
                    match("Cyan"); 


                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:246: 'DarkBlue'
                    {
                    match("DarkBlue"); 


                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:257: 'DarkCyan'
                    {
                    match("DarkCyan"); 


                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:268: 'DarkGoldenRod'
                    {
                    match("DarkGoldenRod"); 


                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:284: 'DarkGray'
                    {
                    match("DarkGray"); 


                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:295: 'DarkGreen'
                    {
                    match("DarkGreen"); 


                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:307: 'DarkGrey'
                    {
                    match("DarkGrey"); 


                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:318: 'DarkKhaki'
                    {
                    match("DarkKhaki"); 


                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:330: 'DarkMagenta'
                    {
                    match("DarkMagenta"); 


                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:344: 'DarkOliveGreen'
                    {
                    match("DarkOliveGreen"); 


                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:361: 'DarkOrchid'
                    {
                    match("DarkOrchid"); 


                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:374: 'DarkRed'
                    {
                    match("DarkRed"); 


                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:384: 'DarkSalmo'
                    {
                    match("DarkSalmo"); 


                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:396: 'DarkSeaGreen'
                    {
                    match("DarkSeaGreen"); 


                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:411: 'DarkSlateBlue'
                    {
                    match("DarkSlateBlue"); 


                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:427: 'DarkSlateGray'
                    {
                    match("DarkSlateGray"); 


                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:443: 'DarkSlateGrey'
                    {
                    match("DarkSlateGrey"); 


                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:459: 'DarkTurquoise'
                    {
                    match("DarkTurquoise"); 


                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:475: 'DarkViolet'
                    {
                    match("DarkViolet"); 


                    }
                    break;
                case 40 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:488: 'Darkorange'
                    {
                    match("Darkorange"); 


                    }
                    break;
                case 41 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:501: 'DeepPink'
                    {
                    match("DeepPink"); 


                    }
                    break;
                case 42 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:512: 'DeepSkyBlue'
                    {
                    match("DeepSkyBlue"); 


                    }
                    break;
                case 43 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:526: 'DimGray'
                    {
                    match("DimGray"); 


                    }
                    break;
                case 44 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:536: 'DimGrey'
                    {
                    match("DimGrey"); 


                    }
                    break;
                case 45 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:546: 'DodgerBlue'
                    {
                    match("DodgerBlue"); 


                    }
                    break;
                case 46 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:559: 'FireBrick'
                    {
                    match("FireBrick"); 


                    }
                    break;
                case 47 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:571: 'FloralWhite'
                    {
                    match("FloralWhite"); 


                    }
                    break;
                case 48 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:585: 'ForestGreen'
                    {
                    match("ForestGreen"); 


                    }
                    break;
                case 49 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:599: 'Fuchsia'
                    {
                    match("Fuchsia"); 


                    }
                    break;
                case 50 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:609: 'Gainsboro'
                    {
                    match("Gainsboro"); 


                    }
                    break;
                case 51 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:621: 'GhostWhite'
                    {
                    match("GhostWhite"); 


                    }
                    break;
                case 52 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:634: 'Gold'
                    {
                    match("Gold"); 


                    }
                    break;
                case 53 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:641: 'GoldenRod'
                    {
                    match("GoldenRod"); 


                    }
                    break;
                case 54 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:653: 'Gray'
                    {
                    match("Gray"); 


                    }
                    break;
                case 55 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:660: 'Green'
                    {
                    match("Green"); 


                    }
                    break;
                case 56 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:668: 'GreenYellow'
                    {
                    match("GreenYellow"); 


                    }
                    break;
                case 57 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:682: 'Grey'
                    {
                    match("Grey"); 


                    }
                    break;
                case 58 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:689: 'HoneyDew'
                    {
                    match("HoneyDew"); 


                    }
                    break;
                case 59 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:700: 'HotPink'
                    {
                    match("HotPink"); 


                    }
                    break;
                case 60 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:710: 'IndianRed'
                    {
                    match("IndianRed"); 


                    }
                    break;
                case 61 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:722: 'Indigo'
                    {
                    match("Indigo"); 


                    }
                    break;
                case 62 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:731: 'Ivory'
                    {
                    match("Ivory"); 


                    }
                    break;
                case 63 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:739: 'Khaki'
                    {
                    match("Khaki"); 


                    }
                    break;
                case 64 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:747: 'Lavender'
                    {
                    match("Lavender"); 


                    }
                    break;
                case 65 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:758: 'LavenderBlush'
                    {
                    match("LavenderBlush"); 


                    }
                    break;
                case 66 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:774: 'LawnGreen'
                    {
                    match("LawnGreen"); 


                    }
                    break;
                case 67 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:786: 'LemonChiffon'
                    {
                    match("LemonChiffon"); 


                    }
                    break;
                case 68 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:801: 'LightBlue'
                    {
                    match("LightBlue"); 


                    }
                    break;
                case 69 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:813: 'LightCoral'
                    {
                    match("LightCoral"); 


                    }
                    break;
                case 70 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:826: 'LightCyan'
                    {
                    match("LightCyan"); 


                    }
                    break;
                case 71 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:838: 'LightGoldenRodYellow'
                    {
                    match("LightGoldenRodYellow"); 


                    }
                    break;
                case 72 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:861: 'LightGray'
                    {
                    match("LightGray"); 


                    }
                    break;
                case 73 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:873: 'LightGreen'
                    {
                    match("LightGreen"); 


                    }
                    break;
                case 74 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:886: 'LightGrey'
                    {
                    match("LightGrey"); 


                    }
                    break;
                case 75 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:898: 'LightPink'
                    {
                    match("LightPink"); 


                    }
                    break;
                case 76 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:910: 'LightSalmon'
                    {
                    match("LightSalmon"); 


                    }
                    break;
                case 77 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:924: 'LightSeaGreen'
                    {
                    match("LightSeaGreen"); 


                    }
                    break;
                case 78 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:940: 'LightSkyBlue'
                    {
                    match("LightSkyBlue"); 


                    }
                    break;
                case 79 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:955: 'LightSlateGray'
                    {
                    match("LightSlateGray"); 


                    }
                    break;
                case 80 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:972: 'LightSlateGrey'
                    {
                    match("LightSlateGrey"); 


                    }
                    break;
                case 81 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:989: 'LightSteelBlue'
                    {
                    match("LightSteelBlue"); 


                    }
                    break;
                case 82 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1006: 'LightYellow'
                    {
                    match("LightYellow"); 


                    }
                    break;
                case 83 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1020: 'Lime'
                    {
                    match("Lime"); 


                    }
                    break;
                case 84 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1027: 'LimeGreen'
                    {
                    match("LimeGreen"); 


                    }
                    break;
                case 85 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1039: 'Linen'
                    {
                    match("Linen"); 


                    }
                    break;
                case 86 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1047: 'Magenta'
                    {
                    match("Magenta"); 


                    }
                    break;
                case 87 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1057: 'Maroon'
                    {
                    match("Maroon"); 


                    }
                    break;
                case 88 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1066: 'MediumAquaMarine'
                    {
                    match("MediumAquaMarine"); 


                    }
                    break;
                case 89 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1085: 'MediumBlue'
                    {
                    match("MediumBlue"); 


                    }
                    break;
                case 90 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1098: 'MediumOrchid'
                    {
                    match("MediumOrchid"); 


                    }
                    break;
                case 91 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1113: 'MediumPurple'
                    {
                    match("MediumPurple"); 


                    }
                    break;
                case 92 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1128: 'MediumSeaGreen'
                    {
                    match("MediumSeaGreen"); 


                    }
                    break;
                case 93 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1145: 'MediumSlateBlue'
                    {
                    match("MediumSlateBlue"); 


                    }
                    break;
                case 94 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1163: 'MediumSpringGreen'
                    {
                    match("MediumSpringGreen"); 


                    }
                    break;
                case 95 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1183: 'MediumTurquoise'
                    {
                    match("MediumTurquoise"); 


                    }
                    break;
                case 96 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1201: 'MediumVioletRed'
                    {
                    match("MediumVioletRed"); 


                    }
                    break;
                case 97 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1219: 'MidnightBlue'
                    {
                    match("MidnightBlue"); 


                    }
                    break;
                case 98 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1234: 'MintCream'
                    {
                    match("MintCream"); 


                    }
                    break;
                case 99 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1246: 'MistyRose'
                    {
                    match("MistyRose"); 


                    }
                    break;
                case 100 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1258: 'Moccasin'
                    {
                    match("Moccasin"); 


                    }
                    break;
                case 101 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1269: 'NavajoWhite'
                    {
                    match("NavajoWhite"); 


                    }
                    break;
                case 102 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1283: 'Navy'
                    {
                    match("Navy"); 


                    }
                    break;
                case 103 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1290: 'OldLace'
                    {
                    match("OldLace"); 


                    }
                    break;
                case 104 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1300: 'Olive'
                    {
                    match("Olive"); 


                    }
                    break;
                case 105 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1308: 'OliveDrab'
                    {
                    match("OliveDrab"); 


                    }
                    break;
                case 106 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1320: 'OrangeRed'
                    {
                    match("OrangeRed"); 


                    }
                    break;
                case 107 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1332: 'Orchid'
                    {
                    match("Orchid"); 


                    }
                    break;
                case 108 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1341: 'PaleGoldenRod'
                    {
                    match("PaleGoldenRod"); 


                    }
                    break;
                case 109 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1357: 'PaleGreen'
                    {
                    match("PaleGreen"); 


                    }
                    break;
                case 110 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1369: 'PaleTurquoise'
                    {
                    match("PaleTurquoise"); 


                    }
                    break;
                case 111 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1385: 'PaleVioletRed'
                    {
                    match("PaleVioletRed"); 


                    }
                    break;
                case 112 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1401: 'PapayaWhip'
                    {
                    match("PapayaWhip"); 


                    }
                    break;
                case 113 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1414: 'PeachPuff'
                    {
                    match("PeachPuff"); 


                    }
                    break;
                case 114 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1426: 'Peru'
                    {
                    match("Peru"); 


                    }
                    break;
                case 115 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1433: 'Pink'
                    {
                    match("Pink"); 


                    }
                    break;
                case 116 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1440: 'Plum'
                    {
                    match("Plum"); 


                    }
                    break;
                case 117 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1447: 'PowderBlue'
                    {
                    match("PowderBlue"); 


                    }
                    break;
                case 118 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1460: 'Purple'
                    {
                    match("Purple"); 


                    }
                    break;
                case 119 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1469: 'Red'
                    {
                    match("Red"); 


                    }
                    break;
                case 120 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1475: 'RosyBrown'
                    {
                    match("RosyBrown"); 


                    }
                    break;
                case 121 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1487: 'RoyalBlue'
                    {
                    match("RoyalBlue"); 


                    }
                    break;
                case 122 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1499: 'SaddleBrown'
                    {
                    match("SaddleBrown"); 


                    }
                    break;
                case 123 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1513: 'Salmon'
                    {
                    match("Salmon"); 


                    }
                    break;
                case 124 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1522: 'SandyBrown'
                    {
                    match("SandyBrown"); 


                    }
                    break;
                case 125 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1535: 'SeaGreen'
                    {
                    match("SeaGreen"); 


                    }
                    break;
                case 126 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1546: 'Sienna'
                    {
                    match("Sienna"); 


                    }
                    break;
                case 127 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1555: 'Silver'
                    {
                    match("Silver"); 


                    }
                    break;
                case 128 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1564: 'SkyBlue'
                    {
                    match("SkyBlue"); 


                    }
                    break;
                case 129 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1574: 'SlateBlue'
                    {
                    match("SlateBlue"); 


                    }
                    break;
                case 130 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1586: 'SlateGray'
                    {
                    match("SlateGray"); 


                    }
                    break;
                case 131 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1598: 'SlateGrey'
                    {
                    match("SlateGrey"); 


                    }
                    break;
                case 132 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1610: 'Snow'
                    {
                    match("Snow"); 


                    }
                    break;
                case 133 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1617: 'SpringGreen'
                    {
                    match("SpringGreen"); 


                    }
                    break;
                case 134 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1631: 'SteelBlue'
                    {
                    match("SteelBlue"); 


                    }
                    break;
                case 135 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1643: 'Tan'
                    {
                    match("Tan"); 


                    }
                    break;
                case 136 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1649: 'Teal'
                    {
                    match("Teal"); 


                    }
                    break;
                case 137 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1656: 'Thistle'
                    {
                    match("Thistle"); 


                    }
                    break;
                case 138 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1666: 'Tomato'
                    {
                    match("Tomato"); 


                    }
                    break;
                case 139 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1675: 'Turquoise'
                    {
                    match("Turquoise"); 


                    }
                    break;
                case 140 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1687: 'Violet'
                    {
                    match("Violet"); 


                    }
                    break;
                case 141 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1696: 'Wheat'
                    {
                    match("Wheat"); 


                    }
                    break;
                case 142 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1704: 'White'
                    {
                    match("White"); 


                    }
                    break;
                case 143 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1712: 'WhiteSmoke'
                    {
                    match("WhiteSmoke"); 


                    }
                    break;
                case 144 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1725: 'Yellow'
                    {
                    match("Yellow"); 


                    }
                    break;
                case 145 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:127:1734: 'YellowGreen'
                    {
                    match("YellowGreen"); 


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
    // $ANTLR end "RULE_COLOR"

    // $ANTLR start "RULE_HEXCODE"
    public final void mRULE_HEXCODE() throws RecognitionException {
        try {
            int _type = RULE_HEXCODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:129:14: ( '#' ( 'A' .. 'F' | '0' .. '9' ) ( 'A' .. 'F' | '0' .. '9' ) ( 'A' .. 'F' | '0' .. '9' ) ( 'A' .. 'F' | '0' .. '9' ) ( 'A' .. 'F' | '0' .. '9' ) ( 'A' .. 'F' | '0' .. '9' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:129:16: '#' ( 'A' .. 'F' | '0' .. '9' ) ( 'A' .. 'F' | '0' .. '9' ) ( 'A' .. 'F' | '0' .. '9' ) ( 'A' .. 'F' | '0' .. '9' ) ( 'A' .. 'F' | '0' .. '9' ) ( 'A' .. 'F' | '0' .. '9' )
            {
            match('#'); 
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F') ) {
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
    // $ANTLR end "RULE_HEXCODE"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:131:9: ( ( ' ' | '\\t' )+ )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:131:11: ( ' ' | '\\t' )+
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:131:11: ( ' ' | '\\t' )+
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
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:133:16: ( . )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:133:18: .
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
        // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:8: ( Participant | Autonumber | Deactivate | Endlegend | Activate | Boundary | Critical | Database | Control | Destroy | Footbox | Newpage | Center | Create | Entity | Legend | Actor | Break | Group | Right | Title | Else | Hide | Left | Loop | Note | Over | FullStopFullStopFullStop | Alt | Box | End | Opt | Par | Ref | VerticalLineVerticalLineVerticalLine | LessThanSignLessThanSign | EqualsSignEqualsSign | GreaterThanSignGreaterThanSign | Of | VerticalLineVerticalLine | QuotationMark | LeftParenthesis | RightParenthesis | Comma | Colon | RULE_NEWLINE | RULE_START | RULE_END | RULE_INT | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_SEQUENCE | RULE_COLOR | RULE_HEXCODE | RULE_WS | RULE_ANY_OTHER )
        int alt22=57;
        alt22 = dfa22.predict(input);
        switch (alt22) {
            case 1 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:10: Participant
                {
                mParticipant(); 

                }
                break;
            case 2 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:22: Autonumber
                {
                mAutonumber(); 

                }
                break;
            case 3 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:33: Deactivate
                {
                mDeactivate(); 

                }
                break;
            case 4 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:44: Endlegend
                {
                mEndlegend(); 

                }
                break;
            case 5 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:54: Activate
                {
                mActivate(); 

                }
                break;
            case 6 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:63: Boundary
                {
                mBoundary(); 

                }
                break;
            case 7 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:72: Critical
                {
                mCritical(); 

                }
                break;
            case 8 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:81: Database
                {
                mDatabase(); 

                }
                break;
            case 9 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:90: Control
                {
                mControl(); 

                }
                break;
            case 10 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:98: Destroy
                {
                mDestroy(); 

                }
                break;
            case 11 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:106: Footbox
                {
                mFootbox(); 

                }
                break;
            case 12 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:114: Newpage
                {
                mNewpage(); 

                }
                break;
            case 13 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:122: Center
                {
                mCenter(); 

                }
                break;
            case 14 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:129: Create
                {
                mCreate(); 

                }
                break;
            case 15 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:136: Entity
                {
                mEntity(); 

                }
                break;
            case 16 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:143: Legend
                {
                mLegend(); 

                }
                break;
            case 17 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:150: Actor
                {
                mActor(); 

                }
                break;
            case 18 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:156: Break
                {
                mBreak(); 

                }
                break;
            case 19 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:162: Group
                {
                mGroup(); 

                }
                break;
            case 20 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:168: Right
                {
                mRight(); 

                }
                break;
            case 21 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:174: Title
                {
                mTitle(); 

                }
                break;
            case 22 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:180: Else
                {
                mElse(); 

                }
                break;
            case 23 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:185: Hide
                {
                mHide(); 

                }
                break;
            case 24 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:190: Left
                {
                mLeft(); 

                }
                break;
            case 25 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:195: Loop
                {
                mLoop(); 

                }
                break;
            case 26 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:200: Note
                {
                mNote(); 

                }
                break;
            case 27 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:205: Over
                {
                mOver(); 

                }
                break;
            case 28 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:210: FullStopFullStopFullStop
                {
                mFullStopFullStopFullStop(); 

                }
                break;
            case 29 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:235: Alt
                {
                mAlt(); 

                }
                break;
            case 30 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:239: Box
                {
                mBox(); 

                }
                break;
            case 31 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:243: End
                {
                mEnd(); 

                }
                break;
            case 32 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:247: Opt
                {
                mOpt(); 

                }
                break;
            case 33 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:251: Par
                {
                mPar(); 

                }
                break;
            case 34 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:255: Ref
                {
                mRef(); 

                }
                break;
            case 35 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:259: VerticalLineVerticalLineVerticalLine
                {
                mVerticalLineVerticalLineVerticalLine(); 

                }
                break;
            case 36 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:296: LessThanSignLessThanSign
                {
                mLessThanSignLessThanSign(); 

                }
                break;
            case 37 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:321: EqualsSignEqualsSign
                {
                mEqualsSignEqualsSign(); 

                }
                break;
            case 38 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:342: GreaterThanSignGreaterThanSign
                {
                mGreaterThanSignGreaterThanSign(); 

                }
                break;
            case 39 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:373: Of
                {
                mOf(); 

                }
                break;
            case 40 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:376: VerticalLineVerticalLine
                {
                mVerticalLineVerticalLine(); 

                }
                break;
            case 41 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:401: QuotationMark
                {
                mQuotationMark(); 

                }
                break;
            case 42 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:415: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 43 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:431: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 44 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:448: Comma
                {
                mComma(); 

                }
                break;
            case 45 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:454: Colon
                {
                mColon(); 

                }
                break;
            case 46 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:460: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 47 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:473: RULE_START
                {
                mRULE_START(); 

                }
                break;
            case 48 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:484: RULE_END
                {
                mRULE_END(); 

                }
                break;
            case 49 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:493: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 50 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:502: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 51 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:510: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 52 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:526: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 53 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:542: RULE_SEQUENCE
                {
                mRULE_SEQUENCE(); 

                }
                break;
            case 54 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:556: RULE_COLOR
                {
                mRULE_COLOR(); 

                }
                break;
            case 55 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:567: RULE_HEXCODE
                {
                mRULE_HEXCODE(); 

                }
                break;
            case 56 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:580: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 57 :
                // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/lexer/InternalPlantumlLexer.g:1:588: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA19_eotS =
        "\6\uffff\1\22\1\26\2\uffff\1\34\17\uffff\1\26\1\37\1\uffff\1\41"+
        "\4\uffff";
    static final String DFA19_eofS =
        "\42\uffff";
    static final String DFA19_minS =
        "\3\55\1\uffff\1\55\1\74\1\56\1\76\1\uffff\1\55\1\76\4\uffff\1\55"+
        "\11\uffff\1\55\1\76\1\157\1\uffff\1\76\4\uffff";
    static final String DFA19_maxS =
        "\1\170\1\134\1\174\1\uffff\1\57\1\134\1\56\1\170\1\uffff\1\174"+
        "\1\76\4\uffff\1\55\11\uffff\1\134\2\157\1\uffff\1\76\4\uffff";
    static final String DFA19_acceptS =
        "\3\uffff\1\4\4\uffff\1\7\2\uffff\1\6\1\21\1\10\1\11\1\uffff\1\15"+
        "\1\23\1\24\1\3\1\5\1\12\1\1\1\14\1\22\3\uffff\1\2\1\uffff\1\17\1"+
        "\16\1\20\1\13";
    static final String DFA19_specialS =
        "\42\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1\1\6\1\4\14\uffff\1\2\62\uffff\1\5\10\uffff\1\3",
            "\1\11\20\uffff\1\7\35\uffff\1\10",
            "\1\12\16\uffff\1\13\77\uffff\1\14",
            "",
            "\1\15\1\uffff\1\16",
            "\1\17\37\uffff\1\20",
            "\1\21",
            "\1\24\60\uffff\1\25\10\uffff\1\23",
            "",
            "\1\31\1\uffff\1\27\16\uffff\1\32\35\uffff\1\10\37\uffff\1"+
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
            "\1\31\1\uffff\1\27\16\uffff\1\32\35\uffff\1\10",
            "\1\24\60\uffff\1\25",
            "\1\36",
            "",
            "\1\40",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "125:17: ( ( '-' )* '-' '>' | '<' '-' ( '-' )* | '-' '>' 'x' | 'x' '<' '-' | ( '-' )* '-' '>' '>' | '<' '<' '-' ( '-' )* | ( '-' )* '-' '\\\\' '\\\\' | '/' '-' ( '-' )* | '/' '/' '-' ( '-' )* | ( '-' )* '-' '>' 'o' | 'o' '<' '-' ( '-' )* | ( '-' )* '-' '-' '/' '/' 'o' | 'o' '\\\\\\\\' '-' '-' ( '-' )* | '<' '-' '>' | '<' '-' '>' 'o' | 'o' '<' '-' '>' | '<' '|' '-' '-' | '-' '-' '|' '>' | '.' '.' | '.' )";
        }
    }
    static final String DFA20_eotS =
        "\u0081\uffff\1\u009a\2\uffff\1\u009c\5\uffff\1\u00ae\5\uffff\1"+
        "\u00b5\36\uffff\1\u00c8\7\uffff\1\u00d2\4\uffff\1\u00d8\34\uffff"+
        "\1\u00f0\32\uffff\1\u00ff\30\uffff";
    static final String DFA20_eofS =
        "\u010d\uffff";
    static final String DFA20_minS =
        "\1\101\1\154\1\145\2\141\1\151\1\141\1\157\1\156\1\uffff\3\141"+
        "\1\154\1\141\1\145\2\141\1\uffff\1\150\1\145\2\uffff\1\165\3\uffff"+
        "\1\141\3\uffff\1\141\1\162\2\uffff\1\162\1\145\1\155\7\uffff\1\154"+
        "\1\141\1\156\1\144\1\uffff\1\166\1\uffff\2\147\2\144\1\uffff\1\166"+
        "\1\144\1\141\1\154\1\141\5\uffff\1\163\1\144\1\uffff\1\145\1\uffff"+
        "\1\141\10\uffff\1\145\1\154\1\141\1\143\1\145\2\uffff\1\141\1\153"+
        "\1\160\1\107\1\144\1\uffff\1\145\2\uffff\1\151\1\145\1\uffff\1\150"+
        "\1\145\3\uffff\1\151\3\uffff\1\141\1\uffff\1\166\2\uffff\1\145\12"+
        "\uffff\1\164\1\uffff\1\164\1\154\1\155\2\uffff\1\126\1\uffff\1\146"+
        "\1\102\1\120\1\162\1\145\1\156\1\uffff\1\141\1\156\1\164\1\107\1"+
        "\165\2\uffff\1\145\1\107\2\145\1\157\10\uffff\1\157\2\uffff\1\154"+
        "\1\uffff\1\141\5\uffff\1\141\2\uffff\1\131\2\uffff\1\144\1\102\2"+
        "\uffff\1\155\1\104\1\157\2\uffff\1\102\1\123\1\167\1\uffff\1\141"+
        "\4\uffff\1\141\4\uffff\1\145\1\uffff\2\157\1\uffff\1\141\1\uffff"+
        "\1\101\5\uffff\1\162\2\uffff\1\107\1\uffff\1\145\1\164\1\162\3\uffff"+
        "\1\141\3\uffff\1\141\5\uffff\1\145\2\uffff\1\141\4\uffff\1\145\1"+
        "\102\1\uffff\1\145\1\164\5\uffff\1\102\4\uffff\1\145\1\uffff\1\162"+
        "\1\107\1\141\1\162\2\uffff\1\141\2\uffff";
    static final String DFA20_maxS =
        "\1\131\1\172\1\165\1\171\1\157\1\165\1\162\1\157\1\166\1\uffff"+
        "\1\151\1\157\1\141\1\162\1\165\1\157\1\164\1\165\1\uffff\1\150\1"+
        "\145\2\uffff\1\165\3\uffff\1\165\3\uffff\1\157\1\162\2\uffff\1\162"+
        "\1\145\1\155\7\uffff\1\154\1\145\1\164\1\144\1\uffff\1\167\1\uffff"+
        "\1\156\1\162\1\144\1\163\1\uffff\1\166\1\151\1\143\1\160\1\162\5"+
        "\uffff\1\171\1\156\1\uffff\1\154\1\uffff\1\141\10\uffff\1\151\1"+
        "\154\1\141\1\156\1\145\2\uffff\1\156\1\153\1\160\1\107\1\144\1\uffff"+
        "\1\171\2\uffff\1\151\1\145\1\uffff\1\150\1\145\3\uffff\1\151\3\uffff"+
        "\1\171\1\uffff\1\166\2\uffff\1\145\12\uffff\1\164\1\uffff\1\164"+
        "\1\154\1\155\2\uffff\1\126\1\uffff\1\163\1\157\1\123\1\162\1\145"+
        "\1\156\1\uffff\1\147\1\156\1\164\1\107\1\165\2\uffff\1\145\1\126"+
        "\2\145\1\157\10\uffff\1\162\2\uffff\1\162\1\uffff\1\154\5\uffff"+
        "\1\145\2\uffff\1\131\2\uffff\1\144\1\131\2\uffff\1\155\1\104\1\162"+
        "\2\uffff\1\107\1\123\1\167\1\uffff\1\145\4\uffff\1\141\4\uffff\1"+
        "\145\1\uffff\1\171\1\162\1\uffff\1\164\1\uffff\1\126\5\uffff\1\162"+
        "\2\uffff\1\107\1\uffff\1\171\1\164\1\162\3\uffff\1\145\3\uffff\1"+
        "\141\5\uffff\1\160\2\uffff\1\145\4\uffff\1\145\1\102\1\uffff\1\171"+
        "\1\164\5\uffff\1\107\4\uffff\1\145\1\uffff\1\162\1\107\1\145\1\162"+
        "\2\uffff\1\145\2\uffff";
    static final String DFA20_acceptS =
        "\11\uffff\1\77\10\uffff\1\u008c\2\uffff\1\1\1\2\1\uffff\1\5\1\6"+
        "\1\7\1\uffff\1\14\1\15\1\16\2\uffff\1\24\1\25\3\uffff\1\55\1\56"+
        "\1\57\1\60\1\61\1\62\1\63\4\uffff\1\76\1\uffff\1\103\4\uffff\1\144"+
        "\5\uffff\1\163\1\164\1\165\1\166\1\167\2\uffff\1\175\1\uffff\1\u0080"+
        "\1\uffff\1\u0084\1\u0085\1\u0086\1\u0087\1\u0088\1\u0089\1\u008a"+
        "\1\u008b\5\uffff\1\17\1\20\5\uffff\1\66\1\uffff\1\72\1\73\2\uffff"+
        "\1\102\2\uffff\1\125\1\126\1\127\1\uffff\1\141\1\142\1\143\1\uffff"+
        "\1\147\1\uffff\1\152\1\153\1\uffff\1\160\1\161\1\162\1\170\1\171"+
        "\1\172\1\173\1\174\1\176\1\177\1\uffff\1\u008d\3\uffff\1\10\1\11"+
        "\1\uffff\1\21\6\uffff\1\71\5\uffff\1\145\1\146\5\uffff\1\4\1\3\1"+
        "\13\1\12\1\22\1\23\1\26\1\27\1\uffff\1\34\1\35\1\uffff\1\40\1\uffff"+
        "\1\46\1\47\1\50\1\51\1\52\1\uffff\1\65\1\64\1\uffff\1\74\1\75\2"+
        "\uffff\1\124\1\123\3\uffff\1\156\1\157\3\uffff\1\30\1\uffff\1\36"+
        "\1\37\1\41\1\42\1\uffff\1\53\1\54\1\70\1\67\1\uffff\1\104\2\uffff"+
        "\1\113\1\uffff\1\122\1\uffff\1\151\1\150\1\154\1\155\1\u0081\1\uffff"+
        "\1\u008f\1\u008e\1\uffff\1\31\3\uffff\1\105\1\106\1\107\1\uffff"+
        "\1\114\1\115\1\116\1\uffff\1\121\1\130\1\131\1\132\1\133\1\uffff"+
        "\1\137\1\140\1\uffff\1\u0091\1\u0090\1\32\1\33\2\uffff\1\110\2\uffff"+
        "\1\134\1\135\1\136\1\u0082\1\u0083\1\uffff\1\101\1\100\1\111\1\112"+
        "\1\uffff\1\43\4\uffff\1\44\1\45\1\uffff\1\117\1\120";
    static final String DFA20_specialS =
        "\u010d\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1\1\2\1\3\1\4\1\uffff\1\5\1\6\1\7\1\10\1\uffff\1\11\1\12"+
            "\1\13\1\14\1\15\1\16\1\uffff\1\17\1\20\1\21\1\uffff\1\22\1\23"+
            "\1\uffff\1\24",
            "\1\25\1\uffff\1\26\2\uffff\1\27\10\uffff\1\30",
            "\1\31\3\uffff\1\32\2\uffff\1\33\5\uffff\1\34\2\uffff\1\35",
            "\1\36\6\uffff\1\37\6\uffff\1\40\2\uffff\1\41\6\uffff\1\42",
            "\1\43\3\uffff\1\44\3\uffff\1\45\5\uffff\1\46",
            "\1\47\2\uffff\1\50\2\uffff\1\51\5\uffff\1\52",
            "\1\53\6\uffff\1\54\6\uffff\1\55\2\uffff\1\56",
            "\1\57",
            "\1\60\7\uffff\1\61",
            "",
            "\1\62\3\uffff\1\63\3\uffff\1\64",
            "\1\65\3\uffff\1\66\3\uffff\1\67\5\uffff\1\70",
            "\1\71",
            "\1\72\5\uffff\1\73",
            "\1\74\3\uffff\1\75\3\uffff\1\76\2\uffff\1\77\2\uffff\1\100"+
            "\5\uffff\1\101",
            "\1\102\11\uffff\1\103",
            "\1\104\3\uffff\1\105\3\uffff\1\106\1\uffff\1\107\1\110\1\uffff"+
            "\1\111\1\uffff\1\112\3\uffff\1\113",
            "\1\114\3\uffff\1\115\2\uffff\1\116\6\uffff\1\117\5\uffff\1"+
            "\120",
            "",
            "\1\121",
            "\1\122",
            "",
            "",
            "\1\123",
            "",
            "",
            "",
            "\1\124\23\uffff\1\125",
            "",
            "",
            "",
            "\1\126\15\uffff\1\127",
            "\1\130",
            "",
            "",
            "\1\131",
            "\1\132",
            "\1\133",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\134",
            "\1\135\3\uffff\1\136",
            "\1\137\5\uffff\1\140",
            "\1\141",
            "",
            "\1\142\1\143",
            "",
            "\1\144\5\uffff\1\145\1\146",
            "\1\147\12\uffff\1\150",
            "\1\151",
            "\1\152\11\uffff\1\153\4\uffff\1\154",
            "",
            "\1\155",
            "\1\156\4\uffff\1\157",
            "\1\160\1\uffff\1\161",
            "\1\162\3\uffff\1\163",
            "\1\164\20\uffff\1\165",
            "",
            "",
            "",
            "",
            "",
            "\1\166\5\uffff\1\167",
            "\1\170\7\uffff\1\171\1\uffff\1\172",
            "",
            "\1\173\6\uffff\1\174",
            "",
            "\1\175",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\176\3\uffff\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082\12\uffff\1\u0083",
            "\1\u0084",
            "",
            "",
            "\1\u0085\14\uffff\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "",
            "\1\u008b\23\uffff\1\u008c",
            "",
            "",
            "\1\u008d",
            "\1\u008e",
            "",
            "\1\u008f",
            "\1\u0090",
            "",
            "",
            "",
            "\1\u0091",
            "",
            "",
            "",
            "\1\u0092\27\uffff\1\u0093",
            "",
            "\1\u0094",
            "",
            "",
            "\1\u0095",
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
            "\1\u0096",
            "",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "",
            "",
            "\1\u009b",
            "",
            "\1\u009d\14\uffff\1\u009e",
            "\1\u009f\1\u00a0\3\uffff\1\u00a1\3\uffff\1\u00a2\1\uffff\1"+
            "\u00a3\1\uffff\1\u00a4\2\uffff\1\u00a5\1\u00a6\1\u00a7\1\uffff"+
            "\1\u00a8\30\uffff\1\u00a9",
            "\1\u00aa\2\uffff\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00af",
            "",
            "\1\u00b0\5\uffff\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b6",
            "",
            "",
            "\1\u00b7",
            "\1\u00b8\14\uffff\1\u00b9\1\uffff\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00be\2\uffff\1\u00bf",
            "",
            "",
            "\1\u00c0\5\uffff\1\u00c1",
            "",
            "\1\u00c2\3\uffff\1\u00c3\6\uffff\1\u00c4",
            "",
            "",
            "",
            "",
            "",
            "\1\u00c5\3\uffff\1\u00c6",
            "",
            "",
            "\1\u00c7",
            "",
            "",
            "\1\u00c9",
            "\1\u00ca\1\u00cb\3\uffff\1\u00cc\10\uffff\1\u00cd\2\uffff"+
            "\1\u00ce\5\uffff\1\u00cf",
            "",
            "",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d3\2\uffff\1\u00d4",
            "",
            "",
            "\1\u00d5\4\uffff\1\u00d6",
            "\1\u00d7",
            "\1\u00d9",
            "",
            "\1\u00da\3\uffff\1\u00db",
            "",
            "",
            "",
            "",
            "\1\u00dc",
            "",
            "",
            "",
            "",
            "\1\u00dd",
            "",
            "\1\u00de\11\uffff\1\u00df",
            "\1\u00e0\2\uffff\1\u00e1",
            "",
            "\1\u00e2\3\uffff\1\u00e3\5\uffff\1\u00e4\1\u00e5\7\uffff\1"+
            "\u00e6",
            "",
            "\1\u00e7\1\u00e8\14\uffff\1\u00e9\1\u00ea\2\uffff\1\u00eb"+
            "\1\u00ec\1\uffff\1\u00ed",
            "",
            "",
            "",
            "",
            "",
            "\1\u00ee",
            "",
            "",
            "\1\u00ef",
            "",
            "\1\u00f1\23\uffff\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "",
            "",
            "",
            "\1\u00f5\3\uffff\1\u00f6",
            "",
            "",
            "",
            "\1\u00f7",
            "",
            "",
            "",
            "",
            "",
            "\1\u00f8\6\uffff\1\u00f9\3\uffff\1\u00fa",
            "",
            "",
            "\1\u00fb\3\uffff\1\u00fc",
            "",
            "",
            "",
            "",
            "\1\u00fd",
            "\1\u00fe",
            "",
            "\1\u0100\23\uffff\1\u0101",
            "\1\u0102",
            "",
            "",
            "",
            "",
            "",
            "\1\u0103\4\uffff\1\u0104",
            "",
            "",
            "",
            "",
            "\1\u0105",
            "",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108\3\uffff\1\u0109",
            "\1\u010a",
            "",
            "",
            "\1\u010b\3\uffff\1\u010c",
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
            return "127:18: ( 'AliceBlue' | 'AntiqueWhite' | 'Aqua' | 'Aquamarine' | 'Azure' | 'Beige' | 'Bisque' | 'Black' | 'BlanchedAlmond' | 'Blue' | 'BlueViolet' | 'Brown' | 'BurlyWood' | 'CadetBlue' | 'Chartreuse' | 'Chocolate' | 'Coral' | 'CornflowerBlue' | 'Cornsilk' | 'Crimson' | 'Cyan' | 'DarkBlue' | 'DarkCyan' | 'DarkGoldenRod' | 'DarkGray' | 'DarkGreen' | 'DarkGrey' | 'DarkKhaki' | 'DarkMagenta' | 'DarkOliveGreen' | 'DarkOrchid' | 'DarkRed' | 'DarkSalmo' | 'DarkSeaGreen' | 'DarkSlateBlue' | 'DarkSlateGray' | 'DarkSlateGrey' | 'DarkTurquoise' | 'DarkViolet' | 'Darkorange' | 'DeepPink' | 'DeepSkyBlue' | 'DimGray' | 'DimGrey' | 'DodgerBlue' | 'FireBrick' | 'FloralWhite' | 'ForestGreen' | 'Fuchsia' | 'Gainsboro' | 'GhostWhite' | 'Gold' | 'GoldenRod' | 'Gray' | 'Green' | 'GreenYellow' | 'Grey' | 'HoneyDew' | 'HotPink' | 'IndianRed' | 'Indigo' | 'Ivory' | 'Khaki' | 'Lavender' | 'LavenderBlush' | 'LawnGreen' | 'LemonChiffon' | 'LightBlue' | 'LightCoral' | 'LightCyan' | 'LightGoldenRodYellow' | 'LightGray' | 'LightGreen' | 'LightGrey' | 'LightPink' | 'LightSalmon' | 'LightSeaGreen' | 'LightSkyBlue' | 'LightSlateGray' | 'LightSlateGrey' | 'LightSteelBlue' | 'LightYellow' | 'Lime' | 'LimeGreen' | 'Linen' | 'Magenta' | 'Maroon' | 'MediumAquaMarine' | 'MediumBlue' | 'MediumOrchid' | 'MediumPurple' | 'MediumSeaGreen' | 'MediumSlateBlue' | 'MediumSpringGreen' | 'MediumTurquoise' | 'MediumVioletRed' | 'MidnightBlue' | 'MintCream' | 'MistyRose' | 'Moccasin' | 'NavajoWhite' | 'Navy' | 'OldLace' | 'Olive' | 'OliveDrab' | 'OrangeRed' | 'Orchid' | 'PaleGoldenRod' | 'PaleGreen' | 'PaleTurquoise' | 'PaleVioletRed' | 'PapayaWhip' | 'PeachPuff' | 'Peru' | 'Pink' | 'Plum' | 'PowderBlue' | 'Purple' | 'Red' | 'RosyBrown' | 'RoyalBlue' | 'SaddleBrown' | 'Salmon' | 'SandyBrown' | 'SeaGreen' | 'Sienna' | 'Silver' | 'SkyBlue' | 'SlateBlue' | 'SlateGray' | 'SlateGrey' | 'Snow' | 'SpringGreen' | 'SteelBlue' | 'Tan' | 'Teal' | 'Thistle' | 'Tomato' | 'Turquoise' | 'Violet' | 'Wheat' | 'White' | 'WhiteSmoke' | 'Yellow' | 'YellowGreen' )";
        }
    }
    static final String DFA22_eotS =
        "\17\36\1\101\4\46\5\uffff\1\46\1\uffff\1\46\1\117\1\36\1\uffff"+
        "\1\46\1\uffff\1\46\1\uffff\1\36\1\46\2\uffff\31\36\1\171\1\uffff"+
        "\1\101\1\174\1\175\13\uffff\1\117\12\uffff\1\177\2\36\1\u0083\3"+
        "\36\1\u0088\3\36\1\u008c\15\36\1\u009a\3\36\1\u009e\5\uffff\1\36"+
        "\1\uffff\3\36\1\uffff\4\36\1\uffff\1\36\1\u00a8\1\36\1\uffff\7\36"+
        "\1\u00b1\1\36\1\u00b3\1\u00b4\2\36\1\uffff\1\36\1\u00b8\1\u00b9"+
        "\1\uffff\3\36\1\u00bd\5\36\1\uffff\1\36\1\u00c4\6\36\1\uffff\1\36"+
        "\2\uffff\1\u00cc\1\u00cd\1\u00ce\2\uffff\3\36\1\uffff\4\36\1\u00d6"+
        "\1\36\1\uffff\1\36\1\u00d9\1\36\1\u00db\2\36\1\u00de\3\uffff\4\36"+
        "\1\u00e3\2\36\1\uffff\2\36\1\uffff\1\u00e8\1\uffff\1\u00e9\1\u00ea"+
        "\1\uffff\2\36\1\u00ed\1\36\1\uffff\1\u00ef\1\36\1\u00f1\1\u00f2"+
        "\3\uffff\2\36\1\uffff\1\36\1\uffff\1\u00f6\2\uffff\1\36\1\u00f8"+
        "\1\u00f9\1\uffff\1\u00fa\3\uffff";
    static final String DFA22_eofS =
        "\u00fb\uffff";
    static final String DFA22_minS =
        "\1\0\1\101\1\103\1\101\1\114\1\117\1\105\1\117\2\105\1\122\1\105"+
        "\2\111\1\74\1\56\1\174\1\55\1\75\1\76\5\uffff\1\12\1\uffff\1\145"+
        "\1\60\1\74\1\uffff\1\47\1\uffff\1\55\1\uffff\1\106\1\60\2\uffff"+
        "\1\122\3\124\1\101\1\124\1\104\1\123\1\125\2\105\2\116\1\117\1\127"+
        "\1\124\1\106\2\117\1\107\1\106\1\124\1\104\1\105\1\124\1\60\1\uffff"+
        "\1\56\1\174\1\55\13\uffff\1\60\2\uffff\5\60\3\uffff\1\60\1\117\1"+
        "\111\1\60\1\103\1\124\1\101\1\60\1\111\1\105\1\116\1\60\1\101\1"+
        "\124\1\101\3\124\1\120\2\105\1\124\1\120\1\125\1\110\1\60\1\114"+
        "\1\105\1\122\1\60\5\uffff\1\111\1\uffff\1\116\1\126\1\122\1\uffff"+
        "\1\124\1\122\1\102\1\105\1\uffff\1\124\1\60\1\104\1\uffff\1\113"+
        "\1\111\1\124\1\122\1\105\1\102\1\101\1\60\1\116\2\60\1\120\1\124"+
        "\1\uffff\1\105\2\60\1\uffff\1\103\1\125\1\101\1\60\1\111\1\117\1"+
        "\101\1\107\1\131\1\uffff\1\101\1\60\1\103\1\105\1\117\1\122\1\117"+
        "\1\107\1\uffff\1\104\2\uffff\3\60\2\uffff\1\111\1\115\1\124\1\uffff"+
        "\1\126\1\131\1\123\1\105\1\60\1\122\1\uffff\1\101\1\60\1\114\1\60"+
        "\1\130\1\105\1\60\3\uffff\1\120\1\102\1\105\1\101\1\60\1\105\1\116"+
        "\1\uffff\1\131\1\114\1\uffff\1\60\1\uffff\2\60\1\uffff\1\101\1\105"+
        "\1\60\1\124\1\uffff\1\60\1\104\2\60\3\uffff\1\116\1\122\1\uffff"+
        "\1\105\1\uffff\1\60\2\uffff\1\124\2\60\1\uffff\1\60\3\uffff";
    static final String DFA22_maxS =
        "\1\uffff\1\141\1\165\1\145\1\156\2\162\3\157\1\162\3\151\1\166"+
        "\1\56\2\174\1\75\1\76\5\uffff\1\12\1\uffff\1\163\1\u00f6\1\74\1"+
        "\uffff\1\57\1\uffff\1\134\1\uffff\1\166\1\131\2\uffff\1\162\3\164"+
        "\1\163\2\164\1\163\1\170\1\145\1\151\2\156\1\157\1\167\1\164\1\147"+
        "\2\157\1\147\1\146\1\164\1\144\1\145\1\164\1\u00f6\1\uffff\1\56"+
        "\1\174\1\55\13\uffff\1\u00f6\2\uffff\1\172\1\165\1\171\1\157\1\165"+
        "\3\uffff\1\u00f6\2\157\1\u00f6\1\143\1\164\1\141\1\u00f6\1\151\1"+
        "\145\1\156\1\u00f6\1\141\1\164\1\141\3\164\1\160\2\145\1\164\1\160"+
        "\1\165\1\150\1\u00f6\1\154\1\145\1\162\1\u00f6\5\uffff\1\151\1\uffff"+
        "\1\156\1\166\1\162\1\uffff\1\164\1\162\1\142\1\145\1\uffff\1\164"+
        "\1\u00f6\1\144\1\uffff\1\153\1\151\1\164\1\162\1\145\1\142\1\141"+
        "\1\u00f6\1\156\2\u00f6\1\160\1\164\1\uffff\1\145\2\u00f6\1\uffff"+
        "\1\143\1\165\1\141\1\u00f6\1\151\1\157\1\141\1\147\1\171\1\uffff"+
        "\1\141\1\u00f6\1\143\1\145\1\157\1\162\1\157\1\147\1\uffff\1\144"+
        "\2\uffff\3\u00f6\2\uffff\1\151\1\155\1\164\1\uffff\1\166\1\171\1"+
        "\163\1\145\1\u00f6\1\162\1\uffff\1\141\1\u00f6\1\154\1\u00f6\1\170"+
        "\1\145\1\u00f6\3\uffff\1\160\1\142\1\145\1\141\1\u00f6\1\145\1\156"+
        "\1\uffff\1\171\1\154\1\uffff\1\u00f6\1\uffff\2\u00f6\1\uffff\1\141"+
        "\1\145\1\u00f6\1\164\1\uffff\1\u00f6\1\144\2\u00f6\3\uffff\1\156"+
        "\1\162\1\uffff\1\145\1\uffff\1\u00f6\2\uffff\1\164\2\u00f6\1\uffff"+
        "\1\u00f6\3\uffff";
    static final String DFA22_acceptS =
        "\24\uffff\1\51\1\52\1\53\1\54\1\55\1\uffff\1\56\3\uffff\1\62\1"+
        "\uffff\1\64\1\uffff\1\62\2\uffff\1\70\1\71\32\uffff\1\65\3\uffff"+
        "\1\45\1\46\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\uffff"+
        "\1\63\1\64\5\uffff\1\67\1\66\1\70\36\uffff\1\47\1\34\1\43\1\50\1"+
        "\44\1\uffff\1\41\3\uffff\1\35\4\uffff\1\37\3\uffff\1\36\15\uffff"+
        "\1\42\3\uffff\1\40\11\uffff\1\26\10\uffff\1\32\1\uffff\1\30\1\31"+
        "\3\uffff\1\27\1\33\3\uffff\1\21\6\uffff\1\22\7\uffff\1\23\1\24\1"+
        "\25\7\uffff\1\17\2\uffff\1\16\1\uffff\1\15\2\uffff\1\20\4\uffff"+
        "\1\12\4\uffff\1\11\1\13\1\14\2\uffff\1\5\1\uffff\1\10\1\uffff\1"+
        "\6\1\7\3\uffff\1\4\1\uffff\1\2\1\3\1\1";
    static final String DFA22_specialS =
        "\1\0\u00fa\uffff}>";
    static final String[] DFA22_transitionS = {
            "\11\46\1\45\1\32\2\46\1\31\22\46\1\45\1\46\1\24\1\44\3\46\1"+
            "\40\1\25\1\26\2\46\1\27\1\41\1\17\1\37\12\34\1\30\1\46\1\21"+
            "\1\22\1\23\1\46\1\33\1\2\1\5\1\6\1\3\1\4\1\7\1\12\1\15\3\42"+
            "\1\11\1\42\1\10\1\43\1\1\1\42\1\13\1\42\1\14\6\42\6\46\1\2\1"+
            "\5\1\6\1\3\1\4\1\7\1\12\1\15\3\42\1\11\1\42\1\10\1\16\1\1\1"+
            "\42\1\13\1\42\1\14\3\42\1\35\2\42\1\46\1\20\147\46\2\42\20\46"+
            "\1\42\uff09\46",
            "\1\47\37\uffff\1\47",
            "\1\51\10\uffff\1\52\10\uffff\1\50\15\uffff\1\51\10\uffff\1"+
            "\52\10\uffff\1\50",
            "\1\54\3\uffff\1\53\33\uffff\1\54\3\uffff\1\53",
            "\1\56\1\uffff\1\55\35\uffff\1\56\1\uffff\1\55",
            "\1\57\2\uffff\1\60\34\uffff\1\57\2\uffff\1\60",
            "\1\63\11\uffff\1\62\2\uffff\1\61\22\uffff\1\63\11\uffff\1"+
            "\62\2\uffff\1\61",
            "\1\64\37\uffff\1\64",
            "\1\65\11\uffff\1\66\25\uffff\1\65\11\uffff\1\66",
            "\1\67\11\uffff\1\70\25\uffff\1\67\11\uffff\1\70",
            "\1\71\37\uffff\1\71",
            "\1\73\3\uffff\1\72\33\uffff\1\73\3\uffff\1\72",
            "\1\74\37\uffff\1\74",
            "\1\75\37\uffff\1\75",
            "\1\101\11\uffff\1\100\11\uffff\1\77\5\uffff\1\76\5\uffff\1"+
            "\101\11\uffff\1\100\11\uffff\1\77\5\uffff\1\76",
            "\1\102",
            "\1\103",
            "\1\101\16\uffff\1\104\77\uffff\1\101",
            "\1\105",
            "\1\106",
            "",
            "",
            "",
            "",
            "",
            "\1\114",
            "",
            "\1\116\15\uffff\1\115",
            "\12\120\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\101",
            "",
            "\1\121\5\uffff\1\101\1\uffff\1\101",
            "",
            "\1\101\20\uffff\1\101\35\uffff\1\101",
            "",
            "\1\100\11\uffff\1\77\5\uffff\1\76\17\uffff\1\100\11\uffff"+
            "\1\77\5\uffff\1\76",
            "\12\130\7\uffff\1\123\1\124\1\125\1\126\1\130\1\127\3\131"+
            "\1\uffff\6\131\1\uffff\3\131\1\uffff\2\131\1\uffff\1\131",
            "",
            "",
            "\1\133\37\uffff\1\133",
            "\1\134\37\uffff\1\134",
            "\1\135\37\uffff\1\135",
            "\1\136\37\uffff\1\136",
            "\1\137\21\uffff\1\140\15\uffff\1\137\21\uffff\1\140",
            "\1\141\37\uffff\1\141",
            "\1\142\17\uffff\1\143\17\uffff\1\142\17\uffff\1\143",
            "\1\144\37\uffff\1\144",
            "\1\145\2\uffff\1\146\34\uffff\1\145\2\uffff\1\146",
            "\1\147\37\uffff\1\147",
            "\1\151\3\uffff\1\150\33\uffff\1\151\3\uffff\1\150",
            "\1\152\37\uffff\1\152",
            "\1\153\37\uffff\1\153",
            "\1\154\37\uffff\1\154",
            "\1\155\37\uffff\1\155",
            "\1\156\37\uffff\1\156",
            "\1\160\1\157\36\uffff\1\160\1\157",
            "\1\161\37\uffff\1\161",
            "\1\162\37\uffff\1\162",
            "\1\163\37\uffff\1\163",
            "\1\164\37\uffff\1\164",
            "\1\165\37\uffff\1\165",
            "\1\166\37\uffff\1\166",
            "\1\167\37\uffff\1\167",
            "\1\170\37\uffff\1\170",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "",
            "\1\172",
            "\1\173",
            "\1\101",
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
            "\12\120\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "",
            "",
            "\12\130\7\uffff\6\130\45\uffff\1\131\1\uffff\1\131\2\uffff"+
            "\1\131\10\uffff\1\131",
            "\12\130\7\uffff\6\130\36\uffff\1\131\3\uffff\1\131\2\uffff"+
            "\1\131\5\uffff\1\131\2\uffff\1\131",
            "\12\130\7\uffff\6\130\32\uffff\1\131\6\uffff\1\131\6\uffff"+
            "\1\131\2\uffff\1\131\6\uffff\1\131",
            "\12\130\7\uffff\6\130\32\uffff\1\131\3\uffff\1\131\3\uffff"+
            "\1\131\5\uffff\1\131",
            "\12\130\7\uffff\6\130\42\uffff\1\131\2\uffff\1\131\2\uffff"+
            "\1\131\5\uffff\1\131",
            "",
            "",
            "",
            "\12\36\7\uffff\23\36\1\176\6\36\6\uffff\23\36\1\176\6\36\151"+
            "\uffff\2\36\20\uffff\1\36",
            "\1\u0080\37\uffff\1\u0080",
            "\1\u0081\5\uffff\1\u0082\31\uffff\1\u0081\5\uffff\1\u0082",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\u0084\37\uffff\1\u0084",
            "\1\u0085\37\uffff\1\u0085",
            "\1\u0086\37\uffff\1\u0086",
            "\12\36\7\uffff\13\36\1\u0087\16\36\6\uffff\13\36\1\u0087\16"+
            "\36\151\uffff\2\36\20\uffff\1\36",
            "\1\u0089\37\uffff\1\u0089",
            "\1\u008a\37\uffff\1\u008a",
            "\1\u008b\37\uffff\1\u008b",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\u008d\37\uffff\1\u008d",
            "\1\u008e\37\uffff\1\u008e",
            "\1\u008f\37\uffff\1\u008f",
            "\1\u0090\37\uffff\1\u0090",
            "\1\u0091\37\uffff\1\u0091",
            "\1\u0092\37\uffff\1\u0092",
            "\1\u0093\37\uffff\1\u0093",
            "\1\u0094\37\uffff\1\u0094",
            "\1\u0095\37\uffff\1\u0095",
            "\1\u0096\37\uffff\1\u0096",
            "\1\u0097\37\uffff\1\u0097",
            "\1\u0098\37\uffff\1\u0098",
            "\1\u0099\37\uffff\1\u0099",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\u009b\37\uffff\1\u009b",
            "\1\u009c\37\uffff\1\u009c",
            "\1\u009d\37\uffff\1\u009d",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "",
            "",
            "",
            "",
            "",
            "\1\u009f\37\uffff\1\u009f",
            "",
            "\1\u00a0\37\uffff\1\u00a0",
            "\1\u00a1\37\uffff\1\u00a1",
            "\1\u00a2\37\uffff\1\u00a2",
            "",
            "\1\u00a3\37\uffff\1\u00a3",
            "\1\u00a4\37\uffff\1\u00a4",
            "\1\u00a5\37\uffff\1\u00a5",
            "\1\u00a6\37\uffff\1\u00a6",
            "",
            "\1\u00a7\37\uffff\1\u00a7",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\u00a9\37\uffff\1\u00a9",
            "",
            "\1\u00aa\37\uffff\1\u00aa",
            "\1\u00ab\37\uffff\1\u00ab",
            "\1\u00ac\37\uffff\1\u00ac",
            "\1\u00ad\37\uffff\1\u00ad",
            "\1\u00ae\37\uffff\1\u00ae",
            "\1\u00af\37\uffff\1\u00af",
            "\1\u00b0\37\uffff\1\u00b0",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\u00b2\37\uffff\1\u00b2",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\u00b5\37\uffff\1\u00b5",
            "\1\u00b6\37\uffff\1\u00b6",
            "",
            "\1\u00b7\37\uffff\1\u00b7",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "",
            "\1\u00ba\37\uffff\1\u00ba",
            "\1\u00bb\37\uffff\1\u00bb",
            "\1\u00bc\37\uffff\1\u00bc",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\u00be\37\uffff\1\u00be",
            "\1\u00bf\37\uffff\1\u00bf",
            "\1\u00c0\37\uffff\1\u00c0",
            "\1\u00c1\37\uffff\1\u00c1",
            "\1\u00c2\37\uffff\1\u00c2",
            "",
            "\1\u00c3\37\uffff\1\u00c3",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\u00c5\37\uffff\1\u00c5",
            "\1\u00c6\37\uffff\1\u00c6",
            "\1\u00c7\37\uffff\1\u00c7",
            "\1\u00c8\37\uffff\1\u00c8",
            "\1\u00c9\37\uffff\1\u00c9",
            "\1\u00ca\37\uffff\1\u00ca",
            "",
            "\1\u00cb\37\uffff\1\u00cb",
            "",
            "",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "",
            "",
            "\1\u00cf\37\uffff\1\u00cf",
            "\1\u00d0\37\uffff\1\u00d0",
            "\1\u00d1\37\uffff\1\u00d1",
            "",
            "\1\u00d2\37\uffff\1\u00d2",
            "\1\u00d3\37\uffff\1\u00d3",
            "\1\u00d4\37\uffff\1\u00d4",
            "\1\u00d5\37\uffff\1\u00d5",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\u00d7\37\uffff\1\u00d7",
            "",
            "\1\u00d8\37\uffff\1\u00d8",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\u00da\37\uffff\1\u00da",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\u00dc\37\uffff\1\u00dc",
            "\1\u00dd\37\uffff\1\u00dd",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "",
            "",
            "",
            "\1\u00df\37\uffff\1\u00df",
            "\1\u00e0\37\uffff\1\u00e0",
            "\1\u00e1\37\uffff\1\u00e1",
            "\1\u00e2\37\uffff\1\u00e2",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\u00e4\37\uffff\1\u00e4",
            "\1\u00e5\37\uffff\1\u00e5",
            "",
            "\1\u00e6\37\uffff\1\u00e6",
            "\1\u00e7\37\uffff\1\u00e7",
            "",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "",
            "\1\u00eb\37\uffff\1\u00eb",
            "\1\u00ec\37\uffff\1\u00ec",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\u00ee\37\uffff\1\u00ee",
            "",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\1\u00f0\37\uffff\1\u00f0",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "",
            "",
            "",
            "\1\u00f3\37\uffff\1\u00f3",
            "\1\u00f4\37\uffff\1\u00f4",
            "",
            "\1\u00f5\37\uffff\1\u00f5",
            "",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "",
            "",
            "\1\u00f7\37\uffff\1\u00f7",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "",
            "\12\36\7\uffff\32\36\6\uffff\32\36\151\uffff\2\36\20\uffff"+
            "\1\36",
            "",
            "",
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
            return "1:1: Tokens : ( Participant | Autonumber | Deactivate | Endlegend | Activate | Boundary | Critical | Database | Control | Destroy | Footbox | Newpage | Center | Create | Entity | Legend | Actor | Break | Group | Right | Title | Else | Hide | Left | Loop | Note | Over | FullStopFullStopFullStop | Alt | Box | End | Opt | Par | Ref | VerticalLineVerticalLineVerticalLine | LessThanSignLessThanSign | EqualsSignEqualsSign | GreaterThanSignGreaterThanSign | Of | VerticalLineVerticalLine | QuotationMark | LeftParenthesis | RightParenthesis | Comma | Colon | RULE_NEWLINE | RULE_START | RULE_END | RULE_INT | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_SEQUENCE | RULE_COLOR | RULE_HEXCODE | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_0 = input.LA(1);

                        s = -1;
                        if ( (LA22_0=='P'||LA22_0=='p') ) {s = 1;}

                        else if ( (LA22_0=='A'||LA22_0=='a') ) {s = 2;}

                        else if ( (LA22_0=='D'||LA22_0=='d') ) {s = 3;}

                        else if ( (LA22_0=='E'||LA22_0=='e') ) {s = 4;}

                        else if ( (LA22_0=='B'||LA22_0=='b') ) {s = 5;}

                        else if ( (LA22_0=='C'||LA22_0=='c') ) {s = 6;}

                        else if ( (LA22_0=='F'||LA22_0=='f') ) {s = 7;}

                        else if ( (LA22_0=='N'||LA22_0=='n') ) {s = 8;}

                        else if ( (LA22_0=='L'||LA22_0=='l') ) {s = 9;}

                        else if ( (LA22_0=='G'||LA22_0=='g') ) {s = 10;}

                        else if ( (LA22_0=='R'||LA22_0=='r') ) {s = 11;}

                        else if ( (LA22_0=='T'||LA22_0=='t') ) {s = 12;}

                        else if ( (LA22_0=='H'||LA22_0=='h') ) {s = 13;}

                        else if ( (LA22_0=='o') ) {s = 14;}

                        else if ( (LA22_0=='.') ) {s = 15;}

                        else if ( (LA22_0=='|') ) {s = 16;}

                        else if ( (LA22_0=='<') ) {s = 17;}

                        else if ( (LA22_0=='=') ) {s = 18;}

                        else if ( (LA22_0=='>') ) {s = 19;}

                        else if ( (LA22_0=='\"') ) {s = 20;}

                        else if ( (LA22_0=='(') ) {s = 21;}

                        else if ( (LA22_0==')') ) {s = 22;}

                        else if ( (LA22_0==',') ) {s = 23;}

                        else if ( (LA22_0==':') ) {s = 24;}

                        else if ( (LA22_0=='\r') ) {s = 25;}

                        else if ( (LA22_0=='\n') ) {s = 26;}

                        else if ( (LA22_0=='@') ) {s = 27;}

                        else if ( ((LA22_0>='0' && LA22_0<='9')) ) {s = 28;}

                        else if ( (LA22_0=='x') ) {s = 29;}

                        else if ( (LA22_0=='/') ) {s = 31;}

                        else if ( (LA22_0=='\'') ) {s = 32;}

                        else if ( (LA22_0=='-') ) {s = 33;}

                        else if ( ((LA22_0>='I' && LA22_0<='K')||LA22_0=='M'||LA22_0=='Q'||LA22_0=='S'||(LA22_0>='U' && LA22_0<='Z')||(LA22_0>='i' && LA22_0<='k')||LA22_0=='m'||LA22_0=='q'||LA22_0=='s'||(LA22_0>='u' && LA22_0<='w')||(LA22_0>='y' && LA22_0<='z')||(LA22_0>='\u00E4' && LA22_0<='\u00E5')||LA22_0=='\u00F6') ) {s = 34;}

                        else if ( (LA22_0=='O') ) {s = 35;}

                        else if ( (LA22_0=='#') ) {s = 36;}

                        else if ( (LA22_0=='\t'||LA22_0==' ') ) {s = 37;}

                        else if ( ((LA22_0>='\u0000' && LA22_0<='\b')||(LA22_0>='\u000B' && LA22_0<='\f')||(LA22_0>='\u000E' && LA22_0<='\u001F')||LA22_0=='!'||(LA22_0>='$' && LA22_0<='&')||(LA22_0>='*' && LA22_0<='+')||LA22_0==';'||LA22_0=='?'||(LA22_0>='[' && LA22_0<='`')||LA22_0=='{'||(LA22_0>='}' && LA22_0<='\u00E3')||(LA22_0>='\u00E6' && LA22_0<='\u00F5')||(LA22_0>='\u00F7' && LA22_0<='\uFFFF')) ) {s = 38;}

                        else s = 30;

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