
/*
 * generated by Xtext
 */
lexer grammar InternalPlantumlLexer;


@header {
package org.xtext.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}




LightGoldenRodYellow : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('G'|'g')('O'|'o')('L'|'l')('D'|'d')('E'|'e')('N'|'n')('R'|'r')('O'|'o')('D'|'d')('Y'|'y')('E'|'e')('L'|'l')('L'|'l')('O'|'o')('W'|'w');

MediumSpringGreen : ('M'|'m')('E'|'e')('D'|'d')('I'|'i')('U'|'u')('M'|'m')('S'|'s')('P'|'p')('R'|'r')('I'|'i')('N'|'n')('G'|'g')('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

MediumAquaMarine : ('M'|'m')('E'|'e')('D'|'d')('I'|'i')('U'|'u')('M'|'m')('A'|'a')('Q'|'q')('U'|'u')('A'|'a')('M'|'m')('A'|'a')('R'|'r')('I'|'i')('N'|'n')('E'|'e');

MediumSlateBlue : ('M'|'m')('E'|'e')('D'|'d')('I'|'i')('U'|'u')('M'|'m')('S'|'s')('L'|'l')('A'|'a')('T'|'t')('E'|'e')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

MediumTurquoise : ('M'|'m')('E'|'e')('D'|'d')('I'|'i')('U'|'u')('M'|'m')('T'|'t')('U'|'u')('R'|'r')('Q'|'q')('U'|'u')('O'|'o')('I'|'i')('S'|'s')('E'|'e');

MediumVioletRed : ('M'|'m')('E'|'e')('D'|'d')('I'|'i')('U'|'u')('M'|'m')('V'|'v')('I'|'i')('O'|'o')('L'|'l')('E'|'e')('T'|'t')('R'|'r')('E'|'e')('D'|'d');

BlanchedAlmond : ('B'|'b')('L'|'l')('A'|'a')('N'|'n')('C'|'c')('H'|'h')('E'|'e')('D'|'d')('A'|'a')('L'|'l')('M'|'m')('O'|'o')('N'|'n')('D'|'d');

CornflowerBlue : ('C'|'c')('O'|'o')('R'|'r')('N'|'n')('F'|'f')('L'|'l')('O'|'o')('W'|'w')('E'|'e')('R'|'r')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

DarkOliveGreen : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('O'|'o')('L'|'l')('I'|'i')('V'|'v')('E'|'e')('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

LightSlateGray : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('S'|'s')('L'|'l')('A'|'a')('T'|'t')('E'|'e')('G'|'g')('R'|'r')('A'|'a')('Y'|'y');

LightSlateGrey : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('S'|'s')('L'|'l')('A'|'a')('T'|'t')('E'|'e')('G'|'g')('R'|'r')('E'|'e')('Y'|'y');

LightSteelBlue : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('S'|'s')('T'|'t')('E'|'e')('E'|'e')('L'|'l')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

MediumSeaGreen : ('M'|'m')('E'|'e')('D'|'d')('I'|'i')('U'|'u')('M'|'m')('S'|'s')('E'|'e')('A'|'a')('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

DarkGoldenRod : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('G'|'g')('O'|'o')('L'|'l')('D'|'d')('E'|'e')('N'|'n')('R'|'r')('O'|'o')('D'|'d');

DarkSlateBlue : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('S'|'s')('L'|'l')('A'|'a')('T'|'t')('E'|'e')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

DarkSlateGray : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('S'|'s')('L'|'l')('A'|'a')('T'|'t')('E'|'e')('G'|'g')('R'|'r')('A'|'a')('Y'|'y');

DarkSlateGrey : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('S'|'s')('L'|'l')('A'|'a')('T'|'t')('E'|'e')('G'|'g')('R'|'r')('E'|'e')('Y'|'y');

DarkTurquoise : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('T'|'t')('U'|'u')('R'|'r')('Q'|'q')('U'|'u')('O'|'o')('I'|'i')('S'|'s')('E'|'e');

LavenderBlush : ('L'|'l')('A'|'a')('V'|'v')('E'|'e')('N'|'n')('D'|'d')('E'|'e')('R'|'r')('B'|'b')('L'|'l')('U'|'u')('S'|'s')('H'|'h');

LightSeaGreen : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('S'|'s')('E'|'e')('A'|'a')('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

PaleGoldenRod : ('P'|'p')('A'|'a')('L'|'l')('E'|'e')('G'|'g')('O'|'o')('L'|'l')('D'|'d')('E'|'e')('N'|'n')('R'|'r')('O'|'o')('D'|'d');

PaleTurquoise : ('P'|'p')('A'|'a')('L'|'l')('E'|'e')('T'|'t')('U'|'u')('R'|'r')('Q'|'q')('U'|'u')('O'|'o')('I'|'i')('S'|'s')('E'|'e');

PaleVioletRed : ('P'|'p')('A'|'a')('L'|'l')('E'|'e')('V'|'v')('I'|'i')('O'|'o')('L'|'l')('E'|'e')('T'|'t')('R'|'r')('E'|'e')('D'|'d');

AntiqueWhite : ('A'|'a')('N'|'n')('T'|'t')('I'|'i')('Q'|'q')('U'|'u')('E'|'e')('W'|'w')('H'|'h')('I'|'i')('T'|'t')('E'|'e');

DarkSeaGreen : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('S'|'s')('E'|'e')('A'|'a')('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

LemonChiffon : ('L'|'l')('E'|'e')('M'|'m')('O'|'o')('N'|'n')('C'|'c')('H'|'h')('I'|'i')('F'|'f')('F'|'f')('O'|'o')('N'|'n');

LightSkyBlue : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('S'|'s')('K'|'k')('Y'|'y')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

MediumOrchid : ('M'|'m')('E'|'e')('D'|'d')('I'|'i')('U'|'u')('M'|'m')('O'|'o')('R'|'r')('C'|'c')('H'|'h')('I'|'i')('D'|'d');

MediumPurple : ('M'|'m')('E'|'e')('D'|'d')('I'|'i')('U'|'u')('M'|'m')('P'|'p')('U'|'u')('R'|'r')('P'|'p')('L'|'l')('E'|'e');

MidnightBlue : ('M'|'m')('I'|'i')('D'|'d')('N'|'n')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

DarkMagenta : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('M'|'m')('A'|'a')('G'|'g')('E'|'e')('N'|'n')('T'|'t')('A'|'a');

DeepSkyBlue : ('D'|'d')('E'|'e')('E'|'e')('P'|'p')('S'|'s')('K'|'k')('Y'|'y')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

FloralWhite : ('F'|'f')('L'|'l')('O'|'o')('R'|'r')('A'|'a')('L'|'l')('W'|'w')('H'|'h')('I'|'i')('T'|'t')('E'|'e');

ForestGreen : ('F'|'f')('O'|'o')('R'|'r')('E'|'e')('S'|'s')('T'|'t')('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

GreenYellow : ('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n')('Y'|'y')('E'|'e')('L'|'l')('L'|'l')('O'|'o')('W'|'w');

LightSalmon : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('S'|'s')('A'|'a')('L'|'l')('M'|'m')('O'|'o')('N'|'n');

LightYellow : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('Y'|'y')('E'|'e')('L'|'l')('L'|'l')('O'|'o')('W'|'w');

NavajoWhite : ('N'|'n')('A'|'a')('V'|'v')('A'|'a')('J'|'j')('O'|'o')('W'|'w')('H'|'h')('I'|'i')('T'|'t')('E'|'e');

SaddleBrown : ('S'|'s')('A'|'a')('D'|'d')('D'|'d')('L'|'l')('E'|'e')('B'|'b')('R'|'r')('O'|'o')('W'|'w')('N'|'n');

SpringGreen : ('S'|'s')('P'|'p')('R'|'r')('I'|'i')('N'|'n')('G'|'g')('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

YellowGreen : ('Y'|'y')('E'|'e')('L'|'l')('L'|'l')('O'|'o')('W'|'w')('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

Participant : ('P'|'p')('A'|'a')('R'|'r')('T'|'t')('I'|'i')('C'|'c')('I'|'i')('P'|'p')('A'|'a')('N'|'n')('T'|'t');

Aquamarine : ('A'|'a')('Q'|'q')('U'|'u')('A'|'a')('M'|'m')('A'|'a')('R'|'r')('I'|'i')('N'|'n')('E'|'e');

BlueViolet : ('B'|'b')('L'|'l')('U'|'u')('E'|'e')('V'|'v')('I'|'i')('O'|'o')('L'|'l')('E'|'e')('T'|'t');

Chartreuse : ('C'|'c')('H'|'h')('A'|'a')('R'|'r')('T'|'t')('R'|'r')('E'|'e')('U'|'u')('S'|'s')('E'|'e');

DarkOrchid : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('O'|'o')('R'|'r')('C'|'c')('H'|'h')('I'|'i')('D'|'d');

DarkViolet : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('V'|'v')('I'|'i')('O'|'o')('L'|'l')('E'|'e')('T'|'t');

Darkorange : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('O'|'o')('R'|'r')('A'|'a')('N'|'n')('G'|'g')('E'|'e');

DodgerBlue : ('D'|'d')('O'|'o')('D'|'d')('G'|'g')('E'|'e')('R'|'r')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

GhostWhite : ('G'|'g')('H'|'h')('O'|'o')('S'|'s')('T'|'t')('W'|'w')('H'|'h')('I'|'i')('T'|'t')('E'|'e');

LightCoral : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('C'|'c')('O'|'o')('R'|'r')('A'|'a')('L'|'l');

LightGreen : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

MediumBlue : ('M'|'m')('E'|'e')('D'|'d')('I'|'i')('U'|'u')('M'|'m')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

PapayaWhip : ('P'|'p')('A'|'a')('P'|'p')('A'|'a')('Y'|'y')('A'|'a')('W'|'w')('H'|'h')('I'|'i')('P'|'p');

PowderBlue : ('P'|'p')('O'|'o')('W'|'w')('D'|'d')('E'|'e')('R'|'r')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

SandyBrown : ('S'|'s')('A'|'a')('N'|'n')('D'|'d')('Y'|'y')('B'|'b')('R'|'r')('O'|'o')('W'|'w')('N'|'n');

WhiteSmoke : ('W'|'w')('H'|'h')('I'|'i')('T'|'t')('E'|'e')('S'|'s')('M'|'m')('O'|'o')('K'|'k')('E'|'e');

Autonumber : ('A'|'a')('U'|'u')('T'|'t')('O'|'o')('N'|'n')('U'|'u')('M'|'m')('B'|'b')('E'|'e')('R'|'r');

Deactivate : ('D'|'d')('E'|'e')('A'|'a')('C'|'c')('T'|'t')('I'|'i')('V'|'v')('A'|'a')('T'|'t')('E'|'e');

AliceBlue : ('A'|'a')('L'|'l')('I'|'i')('C'|'c')('E'|'e')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

BurlyWood : ('B'|'b')('U'|'u')('R'|'r')('L'|'l')('Y'|'y')('W'|'w')('O'|'o')('O'|'o')('D'|'d');

CadetBlue : ('C'|'c')('A'|'a')('D'|'d')('E'|'e')('T'|'t')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

Chocolate : ('C'|'c')('H'|'h')('O'|'o')('C'|'c')('O'|'o')('L'|'l')('A'|'a')('T'|'t')('E'|'e');

DarkGreen : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

DarkKhaki : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('K'|'k')('H'|'h')('A'|'a')('K'|'k')('I'|'i');

DarkSalmo : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('S'|'s')('A'|'a')('L'|'l')('M'|'m')('O'|'o');

FireBrick : ('F'|'f')('I'|'i')('R'|'r')('E'|'e')('B'|'b')('R'|'r')('I'|'i')('C'|'c')('K'|'k');

Gainsboro : ('G'|'g')('A'|'a')('I'|'i')('N'|'n')('S'|'s')('B'|'b')('O'|'o')('R'|'r')('O'|'o');

GoldenRod : ('G'|'g')('O'|'o')('L'|'l')('D'|'d')('E'|'e')('N'|'n')('R'|'r')('O'|'o')('D'|'d');

IndianRed : ('I'|'i')('N'|'n')('D'|'d')('I'|'i')('A'|'a')('N'|'n')('R'|'r')('E'|'e')('D'|'d');

LawnGreen : ('L'|'l')('A'|'a')('W'|'w')('N'|'n')('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

LightBlue : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

LightCyan : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('C'|'c')('Y'|'y')('A'|'a')('N'|'n');

LightGray : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('G'|'g')('R'|'r')('A'|'a')('Y'|'y');

LightGrey : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('G'|'g')('R'|'r')('E'|'e')('Y'|'y');

LightPink : ('L'|'l')('I'|'i')('G'|'g')('H'|'h')('T'|'t')('P'|'p')('I'|'i')('N'|'n')('K'|'k');

LimeGreen : ('L'|'l')('I'|'i')('M'|'m')('E'|'e')('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

MintCream : ('M'|'m')('I'|'i')('N'|'n')('T'|'t')('C'|'c')('R'|'r')('E'|'e')('A'|'a')('M'|'m');

MistyRose : ('M'|'m')('I'|'i')('S'|'s')('T'|'t')('Y'|'y')('R'|'r')('O'|'o')('S'|'s')('E'|'e');

OliveDrab : ('O'|'o')('L'|'l')('I'|'i')('V'|'v')('E'|'e')('D'|'d')('R'|'r')('A'|'a')('B'|'b');

OrangeRed : ('O'|'o')('R'|'r')('A'|'a')('N'|'n')('G'|'g')('E'|'e')('R'|'r')('E'|'e')('D'|'d');

PaleGreen : ('P'|'p')('A'|'a')('L'|'l')('E'|'e')('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

PeachPuff : ('P'|'p')('E'|'e')('A'|'a')('C'|'c')('H'|'h')('P'|'p')('U'|'u')('F'|'f')('F'|'f');

RosyBrown : ('R'|'r')('O'|'o')('S'|'s')('Y'|'y')('B'|'b')('R'|'r')('O'|'o')('W'|'w')('N'|'n');

RoyalBlue : ('R'|'r')('O'|'o')('Y'|'y')('A'|'a')('L'|'l')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

SlateBlue : ('S'|'s')('L'|'l')('A'|'a')('T'|'t')('E'|'e')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

SlateGray : ('S'|'s')('L'|'l')('A'|'a')('T'|'t')('E'|'e')('G'|'g')('R'|'r')('A'|'a')('Y'|'y');

SlateGrey : ('S'|'s')('L'|'l')('A'|'a')('T'|'t')('E'|'e')('G'|'g')('R'|'r')('E'|'e')('Y'|'y');

SteelBlue : ('S'|'s')('T'|'t')('E'|'e')('E'|'e')('L'|'l')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

Turquoise : ('T'|'t')('U'|'u')('R'|'r')('Q'|'q')('U'|'u')('O'|'o')('I'|'i')('S'|'s')('E'|'e');

Endlegend : ('E'|'e')('N'|'n')('D'|'d')('L'|'l')('E'|'e')('G'|'g')('E'|'e')('N'|'n')('D'|'d');

Cornsilk : ('C'|'c')('O'|'o')('R'|'r')('N'|'n')('S'|'s')('I'|'i')('L'|'l')('K'|'k');

DarkBlue : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

DarkCyan : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('C'|'c')('Y'|'y')('A'|'a')('N'|'n');

DarkGray : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('G'|'g')('R'|'r')('A'|'a')('Y'|'y');

DarkGrey : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('G'|'g')('R'|'r')('E'|'e')('Y'|'y');

DeepPink : ('D'|'d')('E'|'e')('E'|'e')('P'|'p')('P'|'p')('I'|'i')('N'|'n')('K'|'k');

HoneyDew : ('H'|'h')('O'|'o')('N'|'n')('E'|'e')('Y'|'y')('D'|'d')('E'|'e')('W'|'w');

Lavender : ('L'|'l')('A'|'a')('V'|'v')('E'|'e')('N'|'n')('D'|'d')('E'|'e')('R'|'r');

Moccasin : ('M'|'m')('O'|'o')('C'|'c')('C'|'c')('A'|'a')('S'|'s')('I'|'i')('N'|'n');

SeaGreen : ('S'|'s')('E'|'e')('A'|'a')('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

Activate : ('A'|'a')('C'|'c')('T'|'t')('I'|'i')('V'|'v')('A'|'a')('T'|'t')('E'|'e');

Boundary : ('B'|'b')('O'|'o')('U'|'u')('N'|'n')('D'|'d')('A'|'a')('R'|'r')('Y'|'y');

Critical : ('C'|'c')('R'|'r')('I'|'i')('T'|'t')('I'|'i')('C'|'c')('A'|'a')('L'|'l');

Database : ('D'|'d')('A'|'a')('T'|'t')('A'|'a')('B'|'b')('A'|'a')('S'|'s')('E'|'e');

Crimson : ('C'|'c')('R'|'r')('I'|'i')('M'|'m')('S'|'s')('O'|'o')('N'|'n');

DarkRed : ('D'|'d')('A'|'a')('R'|'r')('K'|'k')('R'|'r')('E'|'e')('D'|'d');

DimGray : ('D'|'d')('I'|'i')('M'|'m')('G'|'g')('R'|'r')('A'|'a')('Y'|'y');

DimGrey : ('D'|'d')('I'|'i')('M'|'m')('G'|'g')('R'|'r')('E'|'e')('Y'|'y');

Fuchsia : ('F'|'f')('U'|'u')('C'|'c')('H'|'h')('S'|'s')('I'|'i')('A'|'a');

HotPink : ('H'|'h')('O'|'o')('T'|'t')('P'|'p')('I'|'i')('N'|'n')('K'|'k');

Magenta : ('M'|'m')('A'|'a')('G'|'g')('E'|'e')('N'|'n')('T'|'t')('A'|'a');

OldLace : ('O'|'o')('L'|'l')('D'|'d')('L'|'l')('A'|'a')('C'|'c')('E'|'e');

SkyBlue : ('S'|'s')('K'|'k')('Y'|'y')('B'|'b')('L'|'l')('U'|'u')('E'|'e');

Thistle : ('T'|'t')('H'|'h')('I'|'i')('S'|'s')('T'|'t')('L'|'l')('E'|'e');

Control : ('C'|'c')('O'|'o')('N'|'n')('T'|'t')('R'|'r')('O'|'o')('L'|'l');

Destroy : ('D'|'d')('E'|'e')('S'|'s')('T'|'t')('R'|'r')('O'|'o')('Y'|'y');

Footbox : ('F'|'f')('O'|'o')('O'|'o')('T'|'t')('B'|'b')('O'|'o')('X'|'x');

Newpage : ('N'|'n')('E'|'e')('W'|'w')('P'|'p')('A'|'a')('G'|'g')('E'|'e');

Bisque : ('B'|'b')('I'|'i')('S'|'s')('Q'|'q')('U'|'u')('E'|'e');

Indigo : ('I'|'i')('N'|'n')('D'|'d')('I'|'i')('G'|'g')('O'|'o');

Maroon : ('M'|'m')('A'|'a')('R'|'r')('O'|'o')('O'|'o')('N'|'n');

Orchid : ('O'|'o')('R'|'r')('C'|'c')('H'|'h')('I'|'i')('D'|'d');

Purple : ('P'|'p')('U'|'u')('R'|'r')('P'|'p')('L'|'l')('E'|'e');

Salmon : ('S'|'s')('A'|'a')('L'|'l')('M'|'m')('O'|'o')('N'|'n');

Sienna : ('S'|'s')('I'|'i')('E'|'e')('N'|'n')('N'|'n')('A'|'a');

Silver : ('S'|'s')('I'|'i')('L'|'l')('V'|'v')('E'|'e')('R'|'r');

Tomato : ('T'|'t')('O'|'o')('M'|'m')('A'|'a')('T'|'t')('O'|'o');

Violet : ('V'|'v')('I'|'i')('O'|'o')('L'|'l')('E'|'e')('T'|'t');

Yellow : ('Y'|'y')('E'|'e')('L'|'l')('L'|'l')('O'|'o')('W'|'w');

Center : ('C'|'c')('E'|'e')('N'|'n')('T'|'t')('E'|'e')('R'|'r');

Create : ('C'|'c')('R'|'r')('E'|'e')('A'|'a')('T'|'t')('E'|'e');

Entity : ('E'|'e')('N'|'n')('T'|'t')('I'|'i')('T'|'t')('Y'|'y');

Legend : ('L'|'l')('E'|'e')('G'|'g')('E'|'e')('N'|'n')('D'|'d');

Azure : ('A'|'a')('Z'|'z')('U'|'u')('R'|'r')('E'|'e');

Beige : ('B'|'b')('E'|'e')('I'|'i')('G'|'g')('E'|'e');

Black : ('B'|'b')('L'|'l')('A'|'a')('C'|'c')('K'|'k');

Brown : ('B'|'b')('R'|'r')('O'|'o')('W'|'w')('N'|'n');

Coral : ('C'|'c')('O'|'o')('R'|'r')('A'|'a')('L'|'l');

Green : ('G'|'g')('R'|'r')('E'|'e')('E'|'e')('N'|'n');

Ivory : ('I'|'i')('V'|'v')('O'|'o')('R'|'r')('Y'|'y');

Khaki : ('K'|'k')('H'|'h')('A'|'a')('K'|'k')('I'|'i');

Linen : ('L'|'l')('I'|'i')('N'|'n')('E'|'e')('N'|'n');

Olive : ('O'|'o')('L'|'l')('I'|'i')('V'|'v')('E'|'e');

Wheat : ('W'|'w')('H'|'h')('E'|'e')('A'|'a')('T'|'t');

White : ('W'|'w')('H'|'h')('I'|'i')('T'|'t')('E'|'e');

Actor : ('A'|'a')('C'|'c')('T'|'t')('O'|'o')('R'|'r');

Break : ('B'|'b')('R'|'r')('E'|'e')('A'|'a')('K'|'k');

Group : ('G'|'g')('R'|'r')('O'|'o')('U'|'u')('P'|'p');

Right : ('R'|'r')('I'|'i')('G'|'g')('H'|'h')('T'|'t');

Title : ('T'|'t')('I'|'i')('T'|'t')('L'|'l')('E'|'e');

Aqua : ('A'|'a')('Q'|'q')('U'|'u')('A'|'a');

Blue : ('B'|'b')('L'|'l')('U'|'u')('E'|'e');

Cyan : ('C'|'c')('Y'|'y')('A'|'a')('N'|'n');

Gold : ('G'|'g')('O'|'o')('L'|'l')('D'|'d');

Gray : ('G'|'g')('R'|'r')('A'|'a')('Y'|'y');

Grey : ('G'|'g')('R'|'r')('E'|'e')('Y'|'y');

Lime : ('L'|'l')('I'|'i')('M'|'m')('E'|'e');

Navy : ('N'|'n')('A'|'a')('V'|'v')('Y'|'y');

Peru : ('P'|'p')('E'|'e')('R'|'r')('U'|'u');

Pink : ('P'|'p')('I'|'i')('N'|'n')('K'|'k');

Plum : ('P'|'p')('L'|'l')('U'|'u')('M'|'m');

Snow : ('S'|'s')('N'|'n')('O'|'o')('W'|'w');

Teal : ('T'|'t')('E'|'e')('A'|'a')('L'|'l');

Else : ('E'|'e')('L'|'l')('S'|'s')('E'|'e');

Hide : ('H'|'h')('I'|'i')('D'|'d')('E'|'e');

Left : ('L'|'l')('E'|'e')('F'|'f')('T'|'t');

Loop : ('L'|'l')('O'|'o')('O'|'o')('P'|'p');

Note : ('N'|'n')('O'|'o')('T'|'t')('E'|'e');

Over : ('O'|'o')('V'|'v')('E'|'e')('R'|'r');

FullStopFullStopFullStop : '.''.''.';

Red : ('R'|'r')('E'|'e')('D'|'d');

Tan : ('T'|'t')('A'|'a')('N'|'n');

Alt : ('A'|'a')('L'|'l')('T'|'t');

Box : ('B'|'b')('O'|'o')('X'|'x');

End : ('E'|'e')('N'|'n')('D'|'d');

Opt : ('O'|'o')('P'|'p')('T'|'t');

Par : ('P'|'p')('A'|'a')('R'|'r');

Ref : ('R'|'r')('E'|'e')('F'|'f');

VerticalLineVerticalLineVerticalLine : '|''|''|';

LessThanSignLessThanSign : '<''<';

EqualsSignEqualsSign : '=''=';

GreaterThanSignGreaterThanSign : '>''>';

As : ('A'|'a')('S'|'s');

Of : ('O'|'o')('F'|'f');

VerticalLineVerticalLine : '|''|';

QuotationMark : '"';

NumberSign : '#';

LeftParenthesis : '(';

RightParenthesis : ')';

Comma : ',';

HyphenMinus : '-';

FullStop : '.';

Colon : ':';

LessThanSign : '<';

EqualsSign : '=';

GreaterThanSign : '>';



RULE_NEWLINE : '\r'? '\n';

RULE_START : '@' 'startuml';

RULE_END : '@' 'enduml';

RULE_ML_COMMENT : '/\'' ( options {greedy=false;} : . )*'\'/';

RULE_SL_COMMENT : '\'' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_SEQUENCE : ('-'* '-' '>'|'<' '-' '-'*|'-' '>' 'x'|'x' '<' '-'|'-'* '-' '>' '>'|'<' '<' '-' '-'*|'-'* '-' '\\' '\\'|'/' '-' '-'*|'/' '/' '-' '-'*|'-'* '-' '>' 'o'|'o' '<' '-' '-'*|'-'* '-' '-' '/' '/' 'o'|'o' '\\\\' '-' '-' '-'*|'<' '-' '>'|'<' '-' '>' 'o'|'o' '<' '-' '>'|'<' '|' '-' '-'|'-' '-' '|' '>'|'.' '.'|'.');

RULE_HEXCODE : ('A'..'F'|'0'..'9'|'a'..'f') ('A'..'F'|'0'..'9'|'a'..'f')+;

RULE_INT : ('0'..'9')+;

RULE_ID : ('a'..'z'|'A'..'Z'|'0'..'9'|'\u00E5'|'\u00E4'|'\u00F6')*;

RULE_WS : (' '|'\t')+;

RULE_ANY_OTHER : .;



