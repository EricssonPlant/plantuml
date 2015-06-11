/*
 * generated by Xtext
 */
package org.xtext.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class PlantumlGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class ModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final Assignment cDiagramsAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cDiagramsDiagramParserRuleCall_0 = (RuleCall)cDiagramsAssignment.eContents().get(0);
		
		//// Model is a number of @startuml's and @enduml's
		//Model:
		//	diagrams+=Diagram*;
		@Override public ParserRule getRule() { return rule; }

		//diagrams+=Diagram*
		public Assignment getDiagramsAssignment() { return cDiagramsAssignment; }

		//Diagram
		public RuleCall getDiagramsDiagramParserRuleCall_0() { return cDiagramsDiagramParserRuleCall_0; }
	}

	public class DiagramElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Diagram");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cStartumlKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cInstructionsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cInstructionsInstructionParserRuleCall_1_0 = (RuleCall)cInstructionsAssignment_1.eContents().get(0);
		private final Keyword cEndumlKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//// A diagram starts with @Startuml and ends with @enduml, 
		//// with some number of instructions in between
		//Diagram:
		//	"@startuml" instructions+=Instruction* "@enduml";
		@Override public ParserRule getRule() { return rule; }

		//"@startuml" instructions+=Instruction* "@enduml"
		public Group getGroup() { return cGroup; }

		//"@startuml"
		public Keyword getStartumlKeyword_0() { return cStartumlKeyword_0; }

		//instructions+=Instruction*
		public Assignment getInstructionsAssignment_1() { return cInstructionsAssignment_1; }

		//Instruction
		public RuleCall getInstructionsInstructionParserRuleCall_1_0() { return cInstructionsInstructionParserRuleCall_1_0; }

		//"@enduml"
		public Keyword getEndumlKeyword_2() { return cEndumlKeyword_2; }
	}

	public class InstructionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Instruction");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Assignment cNameAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0_0 = (RuleCall)cNameAssignment_0_0.eContents().get(0);
		private final RuleCall cSequenceParserRuleCall_0_1 = (RuleCall)cGroup_0.eContents().get(1);
		private final Assignment cNameAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_0_2_0 = (RuleCall)cNameAssignment_0_2.eContents().get(0);
		private final Group cGroup_0_3 = (Group)cGroup_0.eContents().get(3);
		private final Keyword cColonKeyword_0_3_0 = (Keyword)cGroup_0_3.eContents().get(0);
		private final RuleCall cSTRINGTerminalRuleCall_0_3_1 = (RuleCall)cGroup_0_3.eContents().get(1);
		private final RuleCall cCommentParserRuleCall_0_4 = (RuleCall)cGroup_0.eContents().get(4);
		private final RuleCall cCommentParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cDefinitionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//// An instruction is either a sequence or a comment
		//Instruction:
		//	name=ID Sequence name=ID (":" STRING)? Comment? | Comment | Definition;
		@Override public ParserRule getRule() { return rule; }

		//name=ID Sequence name=ID (":" STRING)? Comment? | Comment | Definition
		public Alternatives getAlternatives() { return cAlternatives; }

		//name=ID Sequence name=ID (":" STRING)? Comment?
		public Group getGroup_0() { return cGroup_0; }

		//name=ID
		public Assignment getNameAssignment_0_0() { return cNameAssignment_0_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0_0() { return cNameIDTerminalRuleCall_0_0_0; }

		//Sequence
		public RuleCall getSequenceParserRuleCall_0_1() { return cSequenceParserRuleCall_0_1; }

		//name=ID
		public Assignment getNameAssignment_0_2() { return cNameAssignment_0_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_2_0() { return cNameIDTerminalRuleCall_0_2_0; }

		//(":" STRING)?
		public Group getGroup_0_3() { return cGroup_0_3; }

		//":"
		public Keyword getColonKeyword_0_3_0() { return cColonKeyword_0_3_0; }

		//STRING
		public RuleCall getSTRINGTerminalRuleCall_0_3_1() { return cSTRINGTerminalRuleCall_0_3_1; }

		//Comment?
		public RuleCall getCommentParserRuleCall_0_4() { return cCommentParserRuleCall_0_4; }

		//Comment
		public RuleCall getCommentParserRuleCall_1() { return cCommentParserRuleCall_1; }

		//Definition
		public RuleCall getDefinitionParserRuleCall_2() { return cDefinitionParserRuleCall_2; }
	}

	public class SequenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Sequence");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Keyword cGreaterThanSignKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cLessThanSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Keyword cHyphenMinusKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Keyword cXKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Group cGroup_3 = (Group)cAlternatives.eContents().get(3);
		private final Keyword cXKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cLessThanSignKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		private final Group cGroup_4 = (Group)cAlternatives.eContents().get(4);
		private final Keyword cHyphenMinusKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_4_1 = (Keyword)cGroup_4.eContents().get(1);
		private final Keyword cGreaterThanSignKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);
		private final Keyword cGreaterThanSignKeyword_4_3 = (Keyword)cGroup_4.eContents().get(3);
		private final Group cGroup_5 = (Group)cAlternatives.eContents().get(5);
		private final Keyword cLessThanSignKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cLessThanSignKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_5_2 = (Keyword)cGroup_5.eContents().get(2);
		private final Keyword cHyphenMinusKeyword_5_3 = (Keyword)cGroup_5.eContents().get(3);
		private final Group cGroup_6 = (Group)cAlternatives.eContents().get(6);
		private final Keyword cHyphenMinusKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_6_1 = (Keyword)cGroup_6.eContents().get(1);
		private final Keyword cReverseSolidusKeyword_6_2 = (Keyword)cGroup_6.eContents().get(2);
		private final Keyword cReverseSolidusKeyword_6_3 = (Keyword)cGroup_6.eContents().get(3);
		private final Group cGroup_7 = (Group)cAlternatives.eContents().get(7);
		private final Keyword cSolidusKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_7_1 = (Keyword)cGroup_7.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_7_2 = (Keyword)cGroup_7.eContents().get(2);
		private final Group cGroup_8 = (Group)cAlternatives.eContents().get(8);
		private final Keyword cHyphenMinusKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Keyword cReverseSolidusReverseSolidusKeyword_8_2 = (Keyword)cGroup_8.eContents().get(2);
		private final Group cGroup_9 = (Group)cAlternatives.eContents().get(9);
		private final Keyword cSolidusKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Keyword cSolidusKeyword_9_1 = (Keyword)cGroup_9.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_9_2 = (Keyword)cGroup_9.eContents().get(2);
		private final Keyword cHyphenMinusKeyword_9_3 = (Keyword)cGroup_9.eContents().get(3);
		private final Group cGroup_10 = (Group)cAlternatives.eContents().get(10);
		private final Keyword cHyphenMinusKeyword_10_0 = (Keyword)cGroup_10.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_10_1 = (Keyword)cGroup_10.eContents().get(1);
		private final Keyword cGreaterThanSignKeyword_10_2 = (Keyword)cGroup_10.eContents().get(2);
		private final Keyword cOKeyword_10_3 = (Keyword)cGroup_10.eContents().get(3);
		private final Group cGroup_11 = (Group)cAlternatives.eContents().get(11);
		private final Keyword cOKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Keyword cLessThanSignKeyword_11_1 = (Keyword)cGroup_11.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_11_2 = (Keyword)cGroup_11.eContents().get(2);
		private final Keyword cHyphenMinusKeyword_11_3 = (Keyword)cGroup_11.eContents().get(3);
		private final Group cGroup_12 = (Group)cAlternatives.eContents().get(12);
		private final Keyword cHyphenMinusKeyword_12_0 = (Keyword)cGroup_12.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_12_1 = (Keyword)cGroup_12.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_12_2 = (Keyword)cGroup_12.eContents().get(2);
		private final Keyword cSolidusKeyword_12_3 = (Keyword)cGroup_12.eContents().get(3);
		private final Keyword cSolidusKeyword_12_4 = (Keyword)cGroup_12.eContents().get(4);
		private final Keyword cOKeyword_12_5 = (Keyword)cGroup_12.eContents().get(5);
		private final Group cGroup_13 = (Group)cAlternatives.eContents().get(13);
		private final Keyword cOKeyword_13_0 = (Keyword)cGroup_13.eContents().get(0);
		private final Keyword cReverseSolidusReverseSolidusKeyword_13_1 = (Keyword)cGroup_13.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_13_2 = (Keyword)cGroup_13.eContents().get(2);
		private final Keyword cHyphenMinusKeyword_13_3 = (Keyword)cGroup_13.eContents().get(3);
		private final Keyword cHyphenMinusKeyword_13_4 = (Keyword)cGroup_13.eContents().get(4);
		private final Group cGroup_14 = (Group)cAlternatives.eContents().get(14);
		private final Keyword cLessThanSignKeyword_14_0 = (Keyword)cGroup_14.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_14_1 = (Keyword)cGroup_14.eContents().get(1);
		private final Keyword cGreaterThanSignKeyword_14_2 = (Keyword)cGroup_14.eContents().get(2);
		private final Group cGroup_15 = (Group)cAlternatives.eContents().get(15);
		private final Keyword cLessThanSignKeyword_15_0 = (Keyword)cGroup_15.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_15_1 = (Keyword)cGroup_15.eContents().get(1);
		private final Keyword cGreaterThanSignKeyword_15_2 = (Keyword)cGroup_15.eContents().get(2);
		private final Keyword cOKeyword_15_3 = (Keyword)cGroup_15.eContents().get(3);
		private final Group cGroup_16 = (Group)cAlternatives.eContents().get(16);
		private final Keyword cOKeyword_16_0 = (Keyword)cGroup_16.eContents().get(0);
		private final Keyword cLessThanSignKeyword_16_1 = (Keyword)cGroup_16.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_16_2 = (Keyword)cGroup_16.eContents().get(2);
		private final Keyword cGreaterThanSignKeyword_16_3 = (Keyword)cGroup_16.eContents().get(3);
		private final Group cGroup_17 = (Group)cAlternatives.eContents().get(17);
		private final Keyword cLessThanSignKeyword_17_0 = (Keyword)cGroup_17.eContents().get(0);
		private final Keyword cVerticalLineKeyword_17_1 = (Keyword)cGroup_17.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_17_2 = (Keyword)cGroup_17.eContents().get(2);
		private final Keyword cHyphenMinusKeyword_17_3 = (Keyword)cGroup_17.eContents().get(3);
		private final Group cGroup_18 = (Group)cAlternatives.eContents().get(18);
		private final Keyword cHyphenMinusKeyword_18_0 = (Keyword)cGroup_18.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_18_1 = (Keyword)cGroup_18.eContents().get(1);
		private final Keyword cVerticalLineKeyword_18_2 = (Keyword)cGroup_18.eContents().get(2);
		private final Keyword cGreaterThanSignKeyword_18_3 = (Keyword)cGroup_18.eContents().get(3);
		private final Group cGroup_19 = (Group)cAlternatives.eContents().get(19);
		private final Keyword cFullStopKeyword_19_0 = (Keyword)cGroup_19.eContents().get(0);
		private final Keyword cFullStopKeyword_19_1 = (Keyword)cGroup_19.eContents().get(1);
		private final Keyword cFullStopKeyword_20 = (Keyword)cAlternatives.eContents().get(20);
		
		//Sequence:
		//	"-"* "-" // - = u002D  | > = u003E
		//	">" | "<" "-" "-"* // < = u003C  | - = u002D
		//	| "-" ">" // - = u002D  | > = u003E
		//	"x" | "x" "<" // < = u003C | - = u002D
		//	"-" | "-"* "-" ">" // - = u002D | > = u003E
		//	">" | "<" "<" "-" "-"* // < = u003C | - = u002D
		//	| "-"* "-" "\\" // - = u002D
		//	"\\" | "/" "-" "-"* // / = u002F | - = u002D
		//	| "-"* "-" // - = u002D
		//	"\\\\" | "/" "/" "-" "-"* // / = u002F | - = u002D
		//	| "-"* "-" ">" // - = u002D | > = u003E
		//	"o" | "o" "<" "-" "-"* // < = u003C | - = u002D
		//	| "-"* "-" "-" "/" "/" // - = u002D | / = u002F
		//	"o" | "o" "\\\\" "-" "-" "-"* // - = u002D
		//	| "<" "-" // < = u003C | - = u002D | > = u003E
		//	">" | "<" "-" ">" // < = u003C | - = u002D | > = u003E
		//	"o" | "o" "<" "-" // < = u003C | - = u002D | > = u003E
		//	">" | "<" "|" "-" // < = u003C | | = u007C | - = u002D
		//	"-" | "-" "-" "|" // - = u002D | | = u007C | > = u003E
		//	">" | "." // . = u002E
		//	"." | // . = u002E
		//	".";
		@Override public ParserRule getRule() { return rule; }

		//"-"* "-" // - = u002D  | > = u003E
		//">" | "<" "-" "-"* // < = u003C  | - = u002D
		//| "-" ">" // - = u002D  | > = u003E
		//"x" | "x" "<" // < = u003C | - = u002D
		//"-" | "-"* "-" ">" // - = u002D | > = u003E
		//">" | "<" "<" "-" "-"* // < = u003C | - = u002D
		//| "-"* "-" "\\" // - = u002D
		//"\\" | "/" "-" "-"* // / = u002F | - = u002D
		//| "-"* "-" // - = u002D
		//"\\\\" | "/" "/" "-" "-"* // / = u002F | - = u002D
		//| "-"* "-" ">" // - = u002D | > = u003E
		//"o" | "o" "<" "-" "-"* // < = u003C | - = u002D
		//| "-"* "-" "-" "/" "/" // - = u002D | / = u002F
		//"o" | "o" "\\\\" "-" "-" "-"* // - = u002D
		//| "<" "-" // < = u003C | - = u002D | > = u003E
		//">" | "<" "-" ">" // < = u003C | - = u002D | > = u003E
		//"o" | "o" "<" "-" // < = u003C | - = u002D | > = u003E
		//">" | "<" "|" "-" // < = u003C | | = u007C | - = u002D
		//"-" | "-" "-" "|" // - = u002D | | = u007C | > = u003E
		//">" | "." // . = u002E
		//"." | // . = u002E
		//"."
		public Alternatives getAlternatives() { return cAlternatives; }

		//"-"* "-" // - = u002D  | > = u003E
		//">"
		public Group getGroup_0() { return cGroup_0; }

		//"-"*
		public Keyword getHyphenMinusKeyword_0_0() { return cHyphenMinusKeyword_0_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_0_1() { return cHyphenMinusKeyword_0_1; }

		//// - = u002D  | > = u003E
		//">"
		public Keyword getGreaterThanSignKeyword_0_2() { return cGreaterThanSignKeyword_0_2; }

		//"<" "-" "-"* // < = u003C  | - = u002D
		public Group getGroup_1() { return cGroup_1; }

		//"<"
		public Keyword getLessThanSignKeyword_1_0() { return cLessThanSignKeyword_1_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_1_1() { return cHyphenMinusKeyword_1_1; }

		//"-"*
		public Keyword getHyphenMinusKeyword_1_2() { return cHyphenMinusKeyword_1_2; }

		//"-" ">" // - = u002D  | > = u003E
		//"x"
		public Group getGroup_2() { return cGroup_2; }

		//"-"
		public Keyword getHyphenMinusKeyword_2_0() { return cHyphenMinusKeyword_2_0; }

		//">"
		public Keyword getGreaterThanSignKeyword_2_1() { return cGreaterThanSignKeyword_2_1; }

		//// - = u002D  | > = u003E
		//"x"
		public Keyword getXKeyword_2_2() { return cXKeyword_2_2; }

		//"x" "<" // < = u003C | - = u002D
		//"-"
		public Group getGroup_3() { return cGroup_3; }

		//"x"
		public Keyword getXKeyword_3_0() { return cXKeyword_3_0; }

		//"<"
		public Keyword getLessThanSignKeyword_3_1() { return cLessThanSignKeyword_3_1; }

		//// < = u003C | - = u002D
		//"-"
		public Keyword getHyphenMinusKeyword_3_2() { return cHyphenMinusKeyword_3_2; }

		//"-"* "-" ">" // - = u002D | > = u003E
		//">"
		public Group getGroup_4() { return cGroup_4; }

		//"-"*
		public Keyword getHyphenMinusKeyword_4_0() { return cHyphenMinusKeyword_4_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_4_1() { return cHyphenMinusKeyword_4_1; }

		//">"
		public Keyword getGreaterThanSignKeyword_4_2() { return cGreaterThanSignKeyword_4_2; }

		//// - = u002D | > = u003E
		//">"
		public Keyword getGreaterThanSignKeyword_4_3() { return cGreaterThanSignKeyword_4_3; }

		//"<" "<" "-" "-"* // < = u003C | - = u002D
		public Group getGroup_5() { return cGroup_5; }

		//"<"
		public Keyword getLessThanSignKeyword_5_0() { return cLessThanSignKeyword_5_0; }

		//"<"
		public Keyword getLessThanSignKeyword_5_1() { return cLessThanSignKeyword_5_1; }

		//"-"
		public Keyword getHyphenMinusKeyword_5_2() { return cHyphenMinusKeyword_5_2; }

		//"-"*
		public Keyword getHyphenMinusKeyword_5_3() { return cHyphenMinusKeyword_5_3; }

		//"-"* "-" "\\" // - = u002D
		//"\\"
		public Group getGroup_6() { return cGroup_6; }

		//"-"*
		public Keyword getHyphenMinusKeyword_6_0() { return cHyphenMinusKeyword_6_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_6_1() { return cHyphenMinusKeyword_6_1; }

		//"\\"
		public Keyword getReverseSolidusKeyword_6_2() { return cReverseSolidusKeyword_6_2; }

		//// - = u002D
		//"\\"
		public Keyword getReverseSolidusKeyword_6_3() { return cReverseSolidusKeyword_6_3; }

		//"/" "-" "-"* // / = u002F | - = u002D
		public Group getGroup_7() { return cGroup_7; }

		//"/"
		public Keyword getSolidusKeyword_7_0() { return cSolidusKeyword_7_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_7_1() { return cHyphenMinusKeyword_7_1; }

		//"-"*
		public Keyword getHyphenMinusKeyword_7_2() { return cHyphenMinusKeyword_7_2; }

		//"-"* "-" // - = u002D
		//"\\\\"
		public Group getGroup_8() { return cGroup_8; }

		//"-"*
		public Keyword getHyphenMinusKeyword_8_0() { return cHyphenMinusKeyword_8_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_8_1() { return cHyphenMinusKeyword_8_1; }

		//// - = u002D
		//"\\\\"
		public Keyword getReverseSolidusReverseSolidusKeyword_8_2() { return cReverseSolidusReverseSolidusKeyword_8_2; }

		//"/" "/" "-" "-"* // / = u002F | - = u002D
		public Group getGroup_9() { return cGroup_9; }

		//"/"
		public Keyword getSolidusKeyword_9_0() { return cSolidusKeyword_9_0; }

		//"/"
		public Keyword getSolidusKeyword_9_1() { return cSolidusKeyword_9_1; }

		//"-"
		public Keyword getHyphenMinusKeyword_9_2() { return cHyphenMinusKeyword_9_2; }

		//"-"*
		public Keyword getHyphenMinusKeyword_9_3() { return cHyphenMinusKeyword_9_3; }

		//"-"* "-" ">" // - = u002D | > = u003E
		//"o"
		public Group getGroup_10() { return cGroup_10; }

		//"-"*
		public Keyword getHyphenMinusKeyword_10_0() { return cHyphenMinusKeyword_10_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_10_1() { return cHyphenMinusKeyword_10_1; }

		//">"
		public Keyword getGreaterThanSignKeyword_10_2() { return cGreaterThanSignKeyword_10_2; }

		//// - = u002D | > = u003E
		//"o"
		public Keyword getOKeyword_10_3() { return cOKeyword_10_3; }

		//"o" "<" "-" "-"* // < = u003C | - = u002D
		public Group getGroup_11() { return cGroup_11; }

		//"o"
		public Keyword getOKeyword_11_0() { return cOKeyword_11_0; }

		//"<"
		public Keyword getLessThanSignKeyword_11_1() { return cLessThanSignKeyword_11_1; }

		//"-"
		public Keyword getHyphenMinusKeyword_11_2() { return cHyphenMinusKeyword_11_2; }

		//"-"*
		public Keyword getHyphenMinusKeyword_11_3() { return cHyphenMinusKeyword_11_3; }

		//"-"* "-" "-" "/" "/" // - = u002D | / = u002F
		//"o"
		public Group getGroup_12() { return cGroup_12; }

		//"-"*
		public Keyword getHyphenMinusKeyword_12_0() { return cHyphenMinusKeyword_12_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_12_1() { return cHyphenMinusKeyword_12_1; }

		//"-"
		public Keyword getHyphenMinusKeyword_12_2() { return cHyphenMinusKeyword_12_2; }

		//"/"
		public Keyword getSolidusKeyword_12_3() { return cSolidusKeyword_12_3; }

		//"/"
		public Keyword getSolidusKeyword_12_4() { return cSolidusKeyword_12_4; }

		//// - = u002D | / = u002F
		//"o"
		public Keyword getOKeyword_12_5() { return cOKeyword_12_5; }

		//"o" "\\\\" "-" "-" "-"* // - = u002D
		public Group getGroup_13() { return cGroup_13; }

		//"o"
		public Keyword getOKeyword_13_0() { return cOKeyword_13_0; }

		//"\\\\"
		public Keyword getReverseSolidusReverseSolidusKeyword_13_1() { return cReverseSolidusReverseSolidusKeyword_13_1; }

		//"-"
		public Keyword getHyphenMinusKeyword_13_2() { return cHyphenMinusKeyword_13_2; }

		//"-"
		public Keyword getHyphenMinusKeyword_13_3() { return cHyphenMinusKeyword_13_3; }

		//"-"*
		public Keyword getHyphenMinusKeyword_13_4() { return cHyphenMinusKeyword_13_4; }

		//"<" "-" // < = u003C | - = u002D | > = u003E
		//">"
		public Group getGroup_14() { return cGroup_14; }

		//"<"
		public Keyword getLessThanSignKeyword_14_0() { return cLessThanSignKeyword_14_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_14_1() { return cHyphenMinusKeyword_14_1; }

		//// < = u003C | - = u002D | > = u003E
		//">"
		public Keyword getGreaterThanSignKeyword_14_2() { return cGreaterThanSignKeyword_14_2; }

		//"<" "-" ">" // < = u003C | - = u002D | > = u003E
		//"o"
		public Group getGroup_15() { return cGroup_15; }

		//"<"
		public Keyword getLessThanSignKeyword_15_0() { return cLessThanSignKeyword_15_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_15_1() { return cHyphenMinusKeyword_15_1; }

		//">"
		public Keyword getGreaterThanSignKeyword_15_2() { return cGreaterThanSignKeyword_15_2; }

		//// < = u003C | - = u002D | > = u003E
		//"o"
		public Keyword getOKeyword_15_3() { return cOKeyword_15_3; }

		//"o" "<" "-" // < = u003C | - = u002D | > = u003E
		//">"
		public Group getGroup_16() { return cGroup_16; }

		//"o"
		public Keyword getOKeyword_16_0() { return cOKeyword_16_0; }

		//"<"
		public Keyword getLessThanSignKeyword_16_1() { return cLessThanSignKeyword_16_1; }

		//"-"
		public Keyword getHyphenMinusKeyword_16_2() { return cHyphenMinusKeyword_16_2; }

		//// < = u003C | - = u002D | > = u003E
		//">"
		public Keyword getGreaterThanSignKeyword_16_3() { return cGreaterThanSignKeyword_16_3; }

		//"<" "|" "-" // < = u003C | | = u007C | - = u002D
		//"-"
		public Group getGroup_17() { return cGroup_17; }

		//"<"
		public Keyword getLessThanSignKeyword_17_0() { return cLessThanSignKeyword_17_0; }

		//"|"
		public Keyword getVerticalLineKeyword_17_1() { return cVerticalLineKeyword_17_1; }

		//"-"
		public Keyword getHyphenMinusKeyword_17_2() { return cHyphenMinusKeyword_17_2; }

		//// < = u003C | | = u007C | - = u002D
		//"-"
		public Keyword getHyphenMinusKeyword_17_3() { return cHyphenMinusKeyword_17_3; }

		//"-" "-" "|" // - = u002D | | = u007C | > = u003E
		//">"
		public Group getGroup_18() { return cGroup_18; }

		//"-"
		public Keyword getHyphenMinusKeyword_18_0() { return cHyphenMinusKeyword_18_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_18_1() { return cHyphenMinusKeyword_18_1; }

		//"|"
		public Keyword getVerticalLineKeyword_18_2() { return cVerticalLineKeyword_18_2; }

		//// - = u002D | | = u007C | > = u003E
		//">"
		public Keyword getGreaterThanSignKeyword_18_3() { return cGreaterThanSignKeyword_18_3; }

		//"." // . = u002E
		//"."
		public Group getGroup_19() { return cGroup_19; }

		//"."
		public Keyword getFullStopKeyword_19_0() { return cFullStopKeyword_19_0; }

		//// . = u002E
		//"."
		public Keyword getFullStopKeyword_19_1() { return cFullStopKeyword_19_1; }

		//// . = u002E
		//"."
		public Keyword getFullStopKeyword_20() { return cFullStopKeyword_20; }
	}

	public class CommentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Comment");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cApostropheKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final RuleCall cSTRINGTerminalRuleCall_0_1 = (RuleCall)cGroup_0.eContents().get(1);
		private final Keyword cApostropheKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cSolidusApostropheKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cSTRINGTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final RuleCall cWSTerminalRuleCall_1_2_0 = (RuleCall)cGroup_1_2.eContents().get(0);
		private final Assignment cStringsAssignment_1_2_1 = (Assignment)cGroup_1_2.eContents().get(1);
		private final RuleCall cStringsSTRINGTerminalRuleCall_1_2_1_0 = (RuleCall)cStringsAssignment_1_2_1.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_1_3 = (RuleCall)cGroup_1.eContents().get(3);
		private final Keyword cApostropheSolidusKeyword_1_4 = (Keyword)cGroup_1.eContents().get(4);
		
		//// A comment can be single- or multiline
		//Comment:
		//	"\'" STRING "\'" | "/\'" STRING (WS strings+=STRING)* WS* "\'/";
		@Override public ParserRule getRule() { return rule; }

		//"\'" STRING "\'" | "/\'" STRING (WS strings+=STRING)* WS* "\'/"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"\'" STRING "\'"
		public Group getGroup_0() { return cGroup_0; }

		//"\'"
		public Keyword getApostropheKeyword_0_0() { return cApostropheKeyword_0_0; }

		//STRING
		public RuleCall getSTRINGTerminalRuleCall_0_1() { return cSTRINGTerminalRuleCall_0_1; }

		//"\'"
		public Keyword getApostropheKeyword_0_2() { return cApostropheKeyword_0_2; }

		//"/\'" STRING (WS strings+=STRING)* WS* "\'/"
		public Group getGroup_1() { return cGroup_1; }

		//"/\'"
		public Keyword getSolidusApostropheKeyword_1_0() { return cSolidusApostropheKeyword_1_0; }

		//STRING
		public RuleCall getSTRINGTerminalRuleCall_1_1() { return cSTRINGTerminalRuleCall_1_1; }

		//(WS strings+=STRING)*
		public Group getGroup_1_2() { return cGroup_1_2; }

		//WS
		public RuleCall getWSTerminalRuleCall_1_2_0() { return cWSTerminalRuleCall_1_2_0; }

		//strings+=STRING
		public Assignment getStringsAssignment_1_2_1() { return cStringsAssignment_1_2_1; }

		//STRING
		public RuleCall getStringsSTRINGTerminalRuleCall_1_2_1_0() { return cStringsSTRINGTerminalRuleCall_1_2_1_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_1_3() { return cWSTerminalRuleCall_1_3; }

		//"\'/"
		public Keyword getApostropheSolidusKeyword_1_4() { return cApostropheSolidusKeyword_1_4; }
	}

	public class DefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Definition");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cActorKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cNameAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_0_1_0 = (RuleCall)cNameAssignment_0_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cBoundaryKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cNameAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_1_0 = (RuleCall)cNameAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Keyword cControlKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cNameAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_2_1_0 = (RuleCall)cNameAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cAlternatives.eContents().get(3);
		private final Keyword cEntityKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cNameAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_3_1_0 = (RuleCall)cNameAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cAlternatives.eContents().get(4);
		private final Keyword cDatabaseKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cNameAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_4_1_0 = (RuleCall)cNameAssignment_4_1.eContents().get(0);
		
		//// Rule for defining objects in PlantUML, such as
		//// actors, boundaries, controls, entities and databases
		//Definition:
		//	"actor" name=ID | "boundary" name=ID | "control" name=ID | "entity" name=ID | "database" name=ID;
		@Override public ParserRule getRule() { return rule; }

		//"actor" name=ID | "boundary" name=ID | "control" name=ID | "entity" name=ID | "database" name=ID
		public Alternatives getAlternatives() { return cAlternatives; }

		//"actor" name=ID
		public Group getGroup_0() { return cGroup_0; }

		//"actor"
		public Keyword getActorKeyword_0_0() { return cActorKeyword_0_0; }

		//name=ID
		public Assignment getNameAssignment_0_1() { return cNameAssignment_0_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_1_0() { return cNameIDTerminalRuleCall_0_1_0; }

		//"boundary" name=ID
		public Group getGroup_1() { return cGroup_1; }

		//"boundary"
		public Keyword getBoundaryKeyword_1_0() { return cBoundaryKeyword_1_0; }

		//name=ID
		public Assignment getNameAssignment_1_1() { return cNameAssignment_1_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_1_0() { return cNameIDTerminalRuleCall_1_1_0; }

		//"control" name=ID
		public Group getGroup_2() { return cGroup_2; }

		//"control"
		public Keyword getControlKeyword_2_0() { return cControlKeyword_2_0; }

		//name=ID
		public Assignment getNameAssignment_2_1() { return cNameAssignment_2_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_1_0() { return cNameIDTerminalRuleCall_2_1_0; }

		//"entity" name=ID
		public Group getGroup_3() { return cGroup_3; }

		//"entity"
		public Keyword getEntityKeyword_3_0() { return cEntityKeyword_3_0; }

		//name=ID
		public Assignment getNameAssignment_3_1() { return cNameAssignment_3_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_3_1_0() { return cNameIDTerminalRuleCall_3_1_0; }

		//"database" name=ID
		public Group getGroup_4() { return cGroup_4; }

		//"database"
		public Keyword getDatabaseKeyword_4_0() { return cDatabaseKeyword_4_0; }

		//name=ID
		public Assignment getNameAssignment_4_1() { return cNameAssignment_4_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_4_1_0() { return cNameIDTerminalRuleCall_4_1_0; }
	}
	
	
	private final ModelElements pModel;
	private final DiagramElements pDiagram;
	private final InstructionElements pInstruction;
	private final SequenceElements pSequence;
	private final CommentElements pComment;
	private final DefinitionElements pDefinition;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public PlantumlGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pModel = new ModelElements();
		this.pDiagram = new DiagramElements();
		this.pInstruction = new InstructionElements();
		this.pSequence = new SequenceElements();
		this.pComment = new CommentElements();
		this.pDefinition = new DefinitionElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.xtext.Plantuml".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//// Model is a number of @startuml's and @enduml's
	//Model:
	//	diagrams+=Diagram*;
	public ModelElements getModelAccess() {
		return pModel;
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}

	//// A diagram starts with @Startuml and ends with @enduml, 
	//// with some number of instructions in between
	//Diagram:
	//	"@startuml" instructions+=Instruction* "@enduml";
	public DiagramElements getDiagramAccess() {
		return pDiagram;
	}
	
	public ParserRule getDiagramRule() {
		return getDiagramAccess().getRule();
	}

	//// An instruction is either a sequence or a comment
	//Instruction:
	//	name=ID Sequence name=ID (":" STRING)? Comment? | Comment | Definition;
	public InstructionElements getInstructionAccess() {
		return pInstruction;
	}
	
	public ParserRule getInstructionRule() {
		return getInstructionAccess().getRule();
	}

	//Sequence:
	//	"-"* "-" // - = u002D  | > = u003E
	//	">" | "<" "-" "-"* // < = u003C  | - = u002D
	//	| "-" ">" // - = u002D  | > = u003E
	//	"x" | "x" "<" // < = u003C | - = u002D
	//	"-" | "-"* "-" ">" // - = u002D | > = u003E
	//	">" | "<" "<" "-" "-"* // < = u003C | - = u002D
	//	| "-"* "-" "\\" // - = u002D
	//	"\\" | "/" "-" "-"* // / = u002F | - = u002D
	//	| "-"* "-" // - = u002D
	//	"\\\\" | "/" "/" "-" "-"* // / = u002F | - = u002D
	//	| "-"* "-" ">" // - = u002D | > = u003E
	//	"o" | "o" "<" "-" "-"* // < = u003C | - = u002D
	//	| "-"* "-" "-" "/" "/" // - = u002D | / = u002F
	//	"o" | "o" "\\\\" "-" "-" "-"* // - = u002D
	//	| "<" "-" // < = u003C | - = u002D | > = u003E
	//	">" | "<" "-" ">" // < = u003C | - = u002D | > = u003E
	//	"o" | "o" "<" "-" // < = u003C | - = u002D | > = u003E
	//	">" | "<" "|" "-" // < = u003C | | = u007C | - = u002D
	//	"-" | "-" "-" "|" // - = u002D | | = u007C | > = u003E
	//	">" | "." // . = u002E
	//	"." | // . = u002E
	//	".";
	public SequenceElements getSequenceAccess() {
		return pSequence;
	}
	
	public ParserRule getSequenceRule() {
		return getSequenceAccess().getRule();
	}

	//// A comment can be single- or multiline
	//Comment:
	//	"\'" STRING "\'" | "/\'" STRING (WS strings+=STRING)* WS* "\'/";
	public CommentElements getCommentAccess() {
		return pComment;
	}
	
	public ParserRule getCommentRule() {
		return getCommentAccess().getRule();
	}

	//// Rule for defining objects in PlantUML, such as
	//// actors, boundaries, controls, entities and databases
	//Definition:
	//	"actor" name=ID | "boundary" name=ID | "control" name=ID | "entity" name=ID | "database" name=ID;
	public DefinitionElements getDefinitionAccess() {
		return pDefinition;
	}
	
	public ParserRule getDefinitionRule() {
		return getDefinitionAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" . / * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\""))* "\"" | "\'" ("\\" .
	//	/ * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
