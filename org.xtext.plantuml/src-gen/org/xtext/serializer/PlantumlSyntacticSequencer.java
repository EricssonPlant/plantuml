/*
 * generated by Xtext
 */
package org.xtext.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.xtext.services.PlantumlGrammarAccess;

@SuppressWarnings("all")
public class PlantumlSyntacticSequencer extends AbstractSyntacticSequencer {

	protected PlantumlGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Activate_ColorParserRuleCall_1_q;
	protected AbstractElementAlias match_AltElse_MyIDParserRuleCall_1_a;
	protected AbstractElementAlias match_Arrow___ColonKeyword_3_0_MyIDParserRuleCall_3_1_a__q;
	protected AbstractElementAlias match_Box_ColorParserRuleCall_4_q;
	protected AbstractElementAlias match_Box_IDTerminalRuleCall_2_a;
	protected AbstractElementAlias match_Box_NEWLINETerminalRuleCall_6_1_a;
	protected AbstractElementAlias match_Box_NEWLINETerminalRuleCall_6_1_p;
	protected AbstractElementAlias match_Deactivate_DeactivateKeyword_0_0_or_DestroyKeyword_0_1;
	protected AbstractElementAlias match_Definition_EndIDParserRuleCall_5_1_1_1_a;
	protected AbstractElementAlias match_Definition___LessThanSignLessThanSignKeyword_5_2_0___LeftParenthesisKeyword_5_2_1_0_EndIDParserRuleCall_5_2_1_1_CommaKeyword_5_2_1_2_NumberSignKeyword_5_2_1_3_HEXCODETerminalRuleCall_5_2_1_4_RightParenthesisKeyword_5_2_1_5__q_EndIDParserRuleCall_5_2_2_a_GreaterThanSignGreaterThanSignKeyword_5_2_3__q;
	protected AbstractElementAlias match_Diagram_NEWLINETerminalRuleCall_4_a;
	protected AbstractElementAlias match_Else_MyIDParserRuleCall_1_a;
	protected AbstractElementAlias match_GroupingMessages_BreakKeyword_0_3_or_CriticalKeyword_0_4_or_GroupKeyword_0_5_or_LoopKeyword_0_1_or_OptKeyword_0_0_or_ParKeyword_0_2;
	protected AbstractElementAlias match_GroupingMessages_IDTerminalRuleCall_1_a;
	protected AbstractElementAlias match_Instruction_ColorsParserRuleCall_0_1_1_q;
	protected AbstractElementAlias match_Instruction___AutoNumberParserRuleCall_0_2_or_DelayParserRuleCall_0_11_or_DividerParserRuleCall_0_9_or_HidefootboxParserRuleCall_0_13_or_LegendParserRuleCall_0_4_or_NewpageParserRuleCall_0_5_or_ParticipantCreationParserRuleCall_0_16_or_SpaceParserRuleCall_0_12_or_TitleParserRuleCall_0_3__q;
	protected AbstractElementAlias match_Note_ColorParserRuleCall_2_a;
	protected AbstractElementAlias match_Note_LeftKeyword_1_1_0_or_RightKeyword_1_0_0;
	protected AbstractElementAlias match_Note___ColonKeyword_3_0_0_MyIDParserRuleCall_3_0_1_a___or_____NEWLINETerminalRuleCall_3_1_0_0_EndIDParserRuleCall_3_1_0_1_a__a_EndKeyword_3_1_1_NoteKeyword_3_1_2__;
	protected AbstractElementAlias match_Reference___ColonKeyword_4_0_0_MyIDParserRuleCall_4_0_1_a___or_____NEWLINETerminalRuleCall_4_1_0_0_EndIDParserRuleCall_4_1_0_1_a__a_EndKeyword_4_1_1_RefKeyword_4_1_2__;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (PlantumlGrammarAccess) access;
		match_Activate_ColorParserRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getActivateAccess().getColorParserRuleCall_1());
		match_AltElse_MyIDParserRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getAltElseAccess().getMyIDParserRuleCall_1());
		match_Arrow___ColonKeyword_3_0_MyIDParserRuleCall_3_1_a__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getArrowAccess().getColonKeyword_3_0()), new TokenAlias(true, true, grammarAccess.getArrowAccess().getMyIDParserRuleCall_3_1()));
		match_Box_ColorParserRuleCall_4_q = new TokenAlias(false, true, grammarAccess.getBoxAccess().getColorParserRuleCall_4());
		match_Box_IDTerminalRuleCall_2_a = new TokenAlias(true, true, grammarAccess.getBoxAccess().getIDTerminalRuleCall_2());
		match_Box_NEWLINETerminalRuleCall_6_1_a = new TokenAlias(true, true, grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_6_1());
		match_Box_NEWLINETerminalRuleCall_6_1_p = new TokenAlias(true, false, grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_6_1());
		match_Deactivate_DeactivateKeyword_0_0_or_DestroyKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDeactivateAccess().getDeactivateKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getDeactivateAccess().getDestroyKeyword_0_1()));
		match_Definition_EndIDParserRuleCall_5_1_1_1_a = new TokenAlias(true, true, grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_1_1_1());
		match_Definition___LessThanSignLessThanSignKeyword_5_2_0___LeftParenthesisKeyword_5_2_1_0_EndIDParserRuleCall_5_2_1_1_CommaKeyword_5_2_1_2_NumberSignKeyword_5_2_1_3_HEXCODETerminalRuleCall_5_2_1_4_RightParenthesisKeyword_5_2_1_5__q_EndIDParserRuleCall_5_2_2_a_GreaterThanSignGreaterThanSignKeyword_5_2_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDefinitionAccess().getLessThanSignLessThanSignKeyword_5_2_0()), new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_0()), new TokenAlias(false, false, grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_1_1()), new TokenAlias(false, false, grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_2()), new TokenAlias(false, false, grammarAccess.getDefinitionAccess().getNumberSignKeyword_5_2_1_3()), new TokenAlias(false, false, grammarAccess.getDefinitionAccess().getHEXCODETerminalRuleCall_5_2_1_4()), new TokenAlias(false, false, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_5())), new TokenAlias(true, true, grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_2()), new TokenAlias(false, false, grammarAccess.getDefinitionAccess().getGreaterThanSignGreaterThanSignKeyword_5_2_3()));
		match_Diagram_NEWLINETerminalRuleCall_4_a = new TokenAlias(true, true, grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_4());
		match_Else_MyIDParserRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getElseAccess().getMyIDParserRuleCall_1());
		match_GroupingMessages_BreakKeyword_0_3_or_CriticalKeyword_0_4_or_GroupKeyword_0_5_or_LoopKeyword_0_1_or_OptKeyword_0_0_or_ParKeyword_0_2 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGroupingMessagesAccess().getBreakKeyword_0_3()), new TokenAlias(false, false, grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_0_4()), new TokenAlias(false, false, grammarAccess.getGroupingMessagesAccess().getGroupKeyword_0_5()), new TokenAlias(false, false, grammarAccess.getGroupingMessagesAccess().getLoopKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getGroupingMessagesAccess().getOptKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getGroupingMessagesAccess().getParKeyword_0_2()));
		match_GroupingMessages_IDTerminalRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getGroupingMessagesAccess().getIDTerminalRuleCall_1());
		match_Instruction_ColorsParserRuleCall_0_1_1_q = new TokenAlias(false, true, grammarAccess.getInstructionAccess().getColorsParserRuleCall_0_1_1());
		match_Instruction___AutoNumberParserRuleCall_0_2_or_DelayParserRuleCall_0_11_or_DividerParserRuleCall_0_9_or_HidefootboxParserRuleCall_0_13_or_LegendParserRuleCall_0_4_or_NewpageParserRuleCall_0_5_or_ParticipantCreationParserRuleCall_0_16_or_SpaceParserRuleCall_0_12_or_TitleParserRuleCall_0_3__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()), new TokenAlias(false, false, grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()), new TokenAlias(false, false, grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()), new TokenAlias(false, false, grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()), new TokenAlias(false, false, grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()), new TokenAlias(false, false, grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()), new TokenAlias(false, false, grammarAccess.getInstructionAccess().getParticipantCreationParserRuleCall_0_16()), new TokenAlias(false, false, grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()), new TokenAlias(false, false, grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()));
		match_Note_ColorParserRuleCall_2_a = new TokenAlias(true, true, grammarAccess.getNoteAccess().getColorParserRuleCall_2());
		match_Note_LeftKeyword_1_1_0_or_RightKeyword_1_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNoteAccess().getLeftKeyword_1_1_0()), new TokenAlias(false, false, grammarAccess.getNoteAccess().getRightKeyword_1_0_0()));
		match_Note___ColonKeyword_3_0_0_MyIDParserRuleCall_3_0_1_a___or_____NEWLINETerminalRuleCall_3_1_0_0_EndIDParserRuleCall_3_1_0_1_a__a_EndKeyword_3_1_1_NoteKeyword_3_1_2__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_0_0()), new TokenAlias(true, true, grammarAccess.getNoteAccess().getEndIDParserRuleCall_3_1_0_1())), new TokenAlias(false, false, grammarAccess.getNoteAccess().getEndKeyword_3_1_1()), new TokenAlias(false, false, grammarAccess.getNoteAccess().getNoteKeyword_3_1_2())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getNoteAccess().getColonKeyword_3_0_0()), new TokenAlias(true, true, grammarAccess.getNoteAccess().getMyIDParserRuleCall_3_0_1())));
		match_Reference___ColonKeyword_4_0_0_MyIDParserRuleCall_4_0_1_a___or_____NEWLINETerminalRuleCall_4_1_0_0_EndIDParserRuleCall_4_1_0_1_a__a_EndKeyword_4_1_1_RefKeyword_4_1_2__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_4_1_0_0()), new TokenAlias(true, true, grammarAccess.getReferenceAccess().getEndIDParserRuleCall_4_1_0_1())), new TokenAlias(false, false, grammarAccess.getReferenceAccess().getEndKeyword_4_1_1()), new TokenAlias(false, false, grammarAccess.getReferenceAccess().getRefKeyword_4_1_2())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getReferenceAccess().getColonKeyword_4_0_0()), new TokenAlias(true, true, grammarAccess.getReferenceAccess().getMyIDParserRuleCall_4_0_1())));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getAutoNumberRule())
			return getAutoNumberToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getColorRule())
			return getColorToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getColorsRule())
			return getColorsToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getDelayRule())
			return getDelayToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getDividerRule())
			return getDividerToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getENDRule())
			return getENDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getEndIDRule())
			return getEndIDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getHEXCODERule())
			return getHEXCODEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getHidefootboxRule())
			return getHidefootboxToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getLegendRule())
			return getLegendToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getMyIDRule())
			return getMyIDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getNEWLINERule())
			return getNEWLINEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getNewpageRule())
			return getNewpageToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getParticipantCreationRule())
			return getParticipantCreationToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSEQUENCERule())
			return getSEQUENCEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSTARTRule())
			return getSTARTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSpaceRule())
			return getSpaceToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getTitleRule())
			return getTitleToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * AutoNumber:
	 * 	'autonumber' (INT (INT)?)?
	 * ;
	 */
	protected String getAutoNumberToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "autonumber";
	}
	
	/**
	 * Color:
	 * 	('AliceBlue'|'AntiqueWhite'|'Aqua'|'Aquamarine'|'Azure'|'Beige'|'Bisque'|'Black'|'BlanchedAlmond'
	 * 	|'Blue'|'BlueViolet'|'Brown'|'BurlyWood'|'CadetBlue'|'Chartreuse'|'Chocolate'|'Coral'
	 * 	|'CornflowerBlue'|'Cornsilk'|'Crimson'|'Cyan'|'DarkBlue'|'DarkCyan'|'DarkGoldenRod'|'DarkGray'
	 * 	|'DarkGreen'|'DarkGrey'|'DarkKhaki'|'DarkMagenta'|'DarkOliveGreen'|'DarkOrchid'|'DarkRed'
	 * 	|'DarkSalmo'|'DarkSeaGreen'|'DarkSlateBlue'|'DarkSlateGray'|'DarkSlateGrey'|'DarkTurquoise'
	 * 	|'DarkViolet'|'Darkorange'|'DeepPink'|'DeepSkyBlue'|'DimGray'|'DimGrey'|'DodgerBlue'
	 * 	|'FireBrick'|'FloralWhite'|'ForestGreen'|'Fuchsia'|'Gainsboro'|'GhostWhite'|'Gold'
	 * 	|'GoldenRod'|'Gray'|'Green'|'GreenYellow'|'Grey'|'HoneyDew'|'HotPink'|'IndianRed'
	 * 	|'Indigo'|'Ivory'|'Khaki'|'Lavender'|'LavenderBlush'|'LawnGreen'|'LemonChiffon'
	 * 	|'LightBlue'|'LightCoral'|'LightCyan'|'LightGoldenRodYellow'|'LightGray'|'LightGreen'
	 * 	|'LightGrey'|'LightPink'|'LightSalmon'|'LightSeaGreen'|'LightSkyBlue'|'LightSlateGray'
	 * 	|'LightSlateGrey'|'LightSteelBlue'|'LightYellow'|'Lime'|'LimeGreen'|'Linen'|'Magenta'
	 * 	|'Maroon'|'MediumAquaMarine'|'MediumBlue'|'MediumOrchid'|'MediumPurple'|'MediumSeaGreen'
	 * 	|'MediumSlateBlue'|'MediumSpringGreen'|'MediumTurquoise'|'MediumVioletRed'
	 * 	|'MidnightBlue'|'MintCream'|'MistyRose'|'Moccasin'|'NavajoWhite'|'Navy'|'OldLace'
	 * 	|'Olive'|'OliveDrab'|'OrangeRed'|'Orchid'|'PaleGoldenRod'|'PaleGreen'
	 * 	|'PaleTurquoise'|'PaleVioletRed'|'PapayaWhip'|'PeachPuff'|'Peru'|'Pink'|'Plum'
	 * 	|'PowderBlue'|'Purple'|'Red'|'RosyBrown'|'RoyalBlue'|'SaddleBrown'
	 * 	|'Salmon'|'SandyBrown'|'SeaGreen'|'Sienna'|'Silver'|'SkyBlue'|'SlateBlue'
	 * 	|'SlateGray'|'SlateGrey'|'Snow'|'SpringGreen'|'SteelBlue'|'Tan'|'Teal'|'Thistle'
	 * 	|'Tomato'|'Turquoise'|'Violet'|'Wheat'|'White'|'WhiteSmoke'|'Yellow'|'YellowGreen')
	 * ;
	 */
	protected String getColorToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "AliceBlue";
	}
	
	/**
	 * Colors: '#' (Color|HEXCODE);
	 */
	protected String getColorsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "#AliceBlue";
	}
	
	/**
	 * Delay:
	 * 	'...' (ID* '...')?
	 * ;
	 */
	protected String getDelayToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "...";
	}
	
	/**
	 * Divider:
	 * 	'==' ID* '=='
	 * ;
	 */
	protected String getDividerToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "====";
	}
	
	/**
	 * terminal END		: '\u0040' 'enduml';
	 */
	protected String getENDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "@enduml";
	}
	
	/**
	 * EndID:
	 * 	ID | 'create'|'autonumber'|'title'|'legend'|'right'|'left'|'center'
	 * 	   |'endlegend'|'alt'|'else'|'newpage'|'opt'|'loop'|'par'|'break'
	 * 	   |'critical'|'group'|'note'|'over'|'of'|'ref'|'hide'|'footbox'|'activate'
	 * 	   |'deactivate'|'destroy'|'box'|'#'|','|'('|')'|'='|INT|'-'|'.'|':'|'>'|'<'
	 * ;
	 */
	protected String getEndIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * terminal HEXCODE:
	 *         ('A' .. 'F'|'0' .. '9'|'a' .. 'f')('A' .. 'F'|'0' .. '9'|'a' .. 'f')+
	 * ;
	 */
	protected String getHEXCODEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * Hidefootbox:
	 * 	'hide' 'footbox'
	 * ;
	 */
	protected String getHidefootboxToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "hidefootbox";
	}
	
	/**
	 * terminal ID  		: ('a'..'z'|'A'..'Z'|'0'..'9' | 'å' | 'ä' | 'ö')*;
	 */
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * Legend:
	 * 	'legend' ('right' | 'left' | 'center')? (NEWLINE ID*)* 'endlegend'
	 * ;
	 */
	protected String getLegendToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "legendendlegend";
	}
	
	/**
	 * MyID:
	 * 	EndID|'end'
	 * ;
	 */
	protected String getMyIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * terminal NEWLINE 	: ('\r'? '\n');
	 */
	protected String getNEWLINEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\n";
	}
	
	/**
	 * Newpage:
	 * 	'newpage' (ID)*
	 * ;
	 */
	protected String getNewpageToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "newpage";
	}
	
	/**
	 * ParticipantCreation:
	 * 	'create' ID
	 * ;
	 */
	protected String getParticipantCreationToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "create";
	}
	
	/**
	 * terminal SEQUENCE:
	 * 	('\u002D')* '\u002D' '\u003E'								| '\u003C' '\u002D' ('\u002D')* 							| '\u002D' '\u003E' 'x'										| 'x' '\u003C' '\u002D' 									| ('\u002D')* '\u002D' '\u003E' '\u003E'					| '\u003C' '\u003C' '\u002D' ('\u002D')*					| ('\u002D')* '\u002D' '\u005C' '\u005C'					| '\u002F' '\u002D' ('\u002D')*								| '\u002F' '\u002F' '\u002D' ('\u002D')*					| ('\u002D')* '\u002D' '\u003E' 'o'							| 'o' '\u003C' '\u002D' ('\u002D')*							| ('\u002D')* '\u002D' '\u002D' '\u002F' '\u002F' 'o'		| 'o' '\\\\' '\u002D' '\u002D' ('\u002D')* 					| '\u003C' '\u002D' '\u003E' 								| '\u003C' '\u002D' '\u003E' 'o' 							| 'o' '\u003C' '\u002D' '\u003E' 							| '\u003C' '\u007C' '\u002D' '\u002D' 						| '\u002D' '\u002D' '\u007C' '\u003E' 						| '\u002E' '\u002E' 										| '\u002E'												;
	 */
	protected String getSEQUENCEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "->";
	}
	
	/**
	 * terminal START		: '\u0040' 'startuml';
	 */
	protected String getSTARTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "@startuml";
	}
	
	/**
	 * Space:
	 * 	('|||'|('||' INT+ '||'))
	 * ;
	 */
	protected String getSpaceToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "|||";
	}
	
	/**
	 * Title:
	 * 	'title' ID*
	 * ;
	 */
	protected String getTitleToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "title";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Activate_ColorParserRuleCall_1_q.equals(syntax))
				emit_Activate_ColorParserRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AltElse_MyIDParserRuleCall_1_a.equals(syntax))
				emit_AltElse_MyIDParserRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Arrow___ColonKeyword_3_0_MyIDParserRuleCall_3_1_a__q.equals(syntax))
				emit_Arrow___ColonKeyword_3_0_MyIDParserRuleCall_3_1_a__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Box_ColorParserRuleCall_4_q.equals(syntax))
				emit_Box_ColorParserRuleCall_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Box_IDTerminalRuleCall_2_a.equals(syntax))
				emit_Box_IDTerminalRuleCall_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Box_NEWLINETerminalRuleCall_6_1_a.equals(syntax))
				emit_Box_NEWLINETerminalRuleCall_6_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Box_NEWLINETerminalRuleCall_6_1_p.equals(syntax))
				emit_Box_NEWLINETerminalRuleCall_6_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Deactivate_DeactivateKeyword_0_0_or_DestroyKeyword_0_1.equals(syntax))
				emit_Deactivate_DeactivateKeyword_0_0_or_DestroyKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Definition_EndIDParserRuleCall_5_1_1_1_a.equals(syntax))
				emit_Definition_EndIDParserRuleCall_5_1_1_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Definition___LessThanSignLessThanSignKeyword_5_2_0___LeftParenthesisKeyword_5_2_1_0_EndIDParserRuleCall_5_2_1_1_CommaKeyword_5_2_1_2_NumberSignKeyword_5_2_1_3_HEXCODETerminalRuleCall_5_2_1_4_RightParenthesisKeyword_5_2_1_5__q_EndIDParserRuleCall_5_2_2_a_GreaterThanSignGreaterThanSignKeyword_5_2_3__q.equals(syntax))
				emit_Definition___LessThanSignLessThanSignKeyword_5_2_0___LeftParenthesisKeyword_5_2_1_0_EndIDParserRuleCall_5_2_1_1_CommaKeyword_5_2_1_2_NumberSignKeyword_5_2_1_3_HEXCODETerminalRuleCall_5_2_1_4_RightParenthesisKeyword_5_2_1_5__q_EndIDParserRuleCall_5_2_2_a_GreaterThanSignGreaterThanSignKeyword_5_2_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Diagram_NEWLINETerminalRuleCall_4_a.equals(syntax))
				emit_Diagram_NEWLINETerminalRuleCall_4_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Else_MyIDParserRuleCall_1_a.equals(syntax))
				emit_Else_MyIDParserRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GroupingMessages_BreakKeyword_0_3_or_CriticalKeyword_0_4_or_GroupKeyword_0_5_or_LoopKeyword_0_1_or_OptKeyword_0_0_or_ParKeyword_0_2.equals(syntax))
				emit_GroupingMessages_BreakKeyword_0_3_or_CriticalKeyword_0_4_or_GroupKeyword_0_5_or_LoopKeyword_0_1_or_OptKeyword_0_0_or_ParKeyword_0_2(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GroupingMessages_IDTerminalRuleCall_1_a.equals(syntax))
				emit_GroupingMessages_IDTerminalRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Instruction_ColorsParserRuleCall_0_1_1_q.equals(syntax))
				emit_Instruction_ColorsParserRuleCall_0_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Instruction___AutoNumberParserRuleCall_0_2_or_DelayParserRuleCall_0_11_or_DividerParserRuleCall_0_9_or_HidefootboxParserRuleCall_0_13_or_LegendParserRuleCall_0_4_or_NewpageParserRuleCall_0_5_or_ParticipantCreationParserRuleCall_0_16_or_SpaceParserRuleCall_0_12_or_TitleParserRuleCall_0_3__q.equals(syntax))
				emit_Instruction___AutoNumberParserRuleCall_0_2_or_DelayParserRuleCall_0_11_or_DividerParserRuleCall_0_9_or_HidefootboxParserRuleCall_0_13_or_LegendParserRuleCall_0_4_or_NewpageParserRuleCall_0_5_or_ParticipantCreationParserRuleCall_0_16_or_SpaceParserRuleCall_0_12_or_TitleParserRuleCall_0_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Note_ColorParserRuleCall_2_a.equals(syntax))
				emit_Note_ColorParserRuleCall_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Note_LeftKeyword_1_1_0_or_RightKeyword_1_0_0.equals(syntax))
				emit_Note_LeftKeyword_1_1_0_or_RightKeyword_1_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Note___ColonKeyword_3_0_0_MyIDParserRuleCall_3_0_1_a___or_____NEWLINETerminalRuleCall_3_1_0_0_EndIDParserRuleCall_3_1_0_1_a__a_EndKeyword_3_1_1_NoteKeyword_3_1_2__.equals(syntax))
				emit_Note___ColonKeyword_3_0_0_MyIDParserRuleCall_3_0_1_a___or_____NEWLINETerminalRuleCall_3_1_0_0_EndIDParserRuleCall_3_1_0_1_a__a_EndKeyword_3_1_1_NoteKeyword_3_1_2__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Reference___ColonKeyword_4_0_0_MyIDParserRuleCall_4_0_1_a___or_____NEWLINETerminalRuleCall_4_1_0_0_EndIDParserRuleCall_4_1_0_1_a__a_EndKeyword_4_1_1_RefKeyword_4_1_2__.equals(syntax))
				emit_Reference___ColonKeyword_4_0_0_MyIDParserRuleCall_4_0_1_a___or_____NEWLINETerminalRuleCall_4_1_0_0_EndIDParserRuleCall_4_1_0_1_a__a_EndKeyword_4_1_1_RefKeyword_4_1_2__(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     Color?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'activate' (ambiguity) name=ID
	 */
	protected void emit_Activate_ColorParserRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     MyID*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'alt' (ambiguity) NEWLINE 'end' (rule start)
	 *     (rule start) 'alt' (ambiguity) NEWLINE elses+=Else
	 *     (rule start) 'alt' (ambiguity) NEWLINE instructions+=Instruction
	 */
	protected void emit_AltElse_MyIDParserRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (':' MyID*)?
	 *
	 * This ambiguous syntax occurs at:
	 *     names+=MyID (ambiguity) (rule end)
	 *     names+=MyID (ambiguity) NEWLINE (rule end)
	 */
	protected void emit_Arrow___ColonKeyword_3_0_MyIDParserRuleCall_3_1_a__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     Color?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'box' '"' ID* '"' (ambiguity) NEWLINE NEWLINE* 'end' 'box' (rule start)
	 *     (rule start) 'box' '"' ID* '"' (ambiguity) NEWLINE NEWLINE* definitions+=Definition
	 *     (rule start) 'box' '"' ID* '"' (ambiguity) NEWLINE NEWLINE+ 'end' 'box' (rule start)
	 *     (rule start) 'box' '"' ID* '"' (ambiguity) NEWLINE NEWLINE+ 'end' 'box' NEWLINE (rule start)
	 */
	protected void emit_Box_ColorParserRuleCall_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ID*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'box' '"' (ambiguity) '"' Color? NEWLINE NEWLINE* 'end' 'box' (rule start)
	 *     (rule start) 'box' '"' (ambiguity) '"' Color? NEWLINE NEWLINE* definitions+=Definition
	 *     (rule start) 'box' '"' (ambiguity) '"' Color? NEWLINE NEWLINE+ 'end' 'box' (rule start)
	 *     (rule start) 'box' '"' (ambiguity) '"' Color? NEWLINE NEWLINE+ 'end' 'box' NEWLINE (rule start)
	 */
	protected void emit_Box_IDTerminalRuleCall_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     NEWLINE*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'box' '"' ID* '"' Color? NEWLINE (ambiguity) 'end' 'box' (rule start)
	 *     (rule start) 'box' '"' ID* '"' Color? NEWLINE (ambiguity) definitions+=Definition
	 */
	protected void emit_Box_NEWLINETerminalRuleCall_6_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     NEWLINE+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'box' '"' ID* '"' Color? NEWLINE (ambiguity) 'end' 'box' (rule start)
	 *     (rule start) 'box' '"' ID* '"' Color? NEWLINE (ambiguity) 'end' 'box' NEWLINE (rule start)
	 *     definitions+=Definition (ambiguity) 'end' 'box' (rule end)
	 *     definitions+=Definition (ambiguity) 'end' 'box' NEWLINE (rule end)
	 *     definitions+=Definition (ambiguity) definitions+=Definition
	 */
	protected void emit_Box_NEWLINETerminalRuleCall_6_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'deactivate' | 'destroy'
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) id=[Activate|ID]
	 */
	protected void emit_Deactivate_DeactivateKeyword_0_0_or_DestroyKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     EndID*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'participant' '"' (ambiguity) '"' 'as' ID ('<<' ('(' EndID ',' '#' HEXCODE ')')? EndID* '>>')? (rule start)
	 */
	protected void emit_Definition_EndIDParserRuleCall_5_1_1_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (
	  *         '<<' 
	  *         (
	  *             '(' 
	  *             EndID 
	  *             ',' 
	  *             '#' 
	  *             HEXCODE 
	  *             ')'
	  *         )? 
	  *         EndID* 
	  *         '>>'
	  *     )?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'participant' '"' EndID* '"' 'as' ID (ambiguity) (rule start)
	 *     name=MyID (ambiguity) (rule end)
	 *     name=MyID (ambiguity) Colors? NEWLINE (rule end)
	 */
	protected void emit_Definition___LessThanSignLessThanSignKeyword_5_2_0___LeftParenthesisKeyword_5_2_1_0_EndIDParserRuleCall_5_2_1_1_CommaKeyword_5_2_1_2_NumberSignKeyword_5_2_1_3_HEXCODETerminalRuleCall_5_2_1_4_RightParenthesisKeyword_5_2_1_5__q_EndIDParserRuleCall_5_2_2_a_GreaterThanSignGreaterThanSignKeyword_5_2_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     NEWLINE*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) START NEWLINE END (ambiguity) (rule start)
	 *     instructions+=Instruction END (ambiguity) (rule end)
	 */
	protected void emit_Diagram_NEWLINETerminalRuleCall_4_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     MyID*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'else' (ambiguity) NEWLINE (rule start)
	 *     (rule start) 'else' (ambiguity) NEWLINE instructions+=Instruction
	 */
	protected void emit_Else_MyIDParserRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (
	  *         'opt' | 
	  *         'loop' | 
	  *         'par' | 
	  *         'break' | 
	  *         'critical' | 
	  *         'group'
	  *     )
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) ID* NEWLINE 'end' (rule start)
	 *     (rule start) (ambiguity) ID* NEWLINE instructions+=Instruction
	 */
	protected void emit_GroupingMessages_BreakKeyword_0_3_or_CriticalKeyword_0_4_or_GroupKeyword_0_5_or_LoopKeyword_0_1_or_OptKeyword_0_0_or_ParKeyword_0_2(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ID*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) ('opt' | 'loop' | 'par' | 'break' | 'critical' | 'group') (ambiguity) NEWLINE 'end' (rule start)
	 *     (rule start) ('opt' | 'loop' | 'par' | 'break' | 'critical' | 'group') (ambiguity) NEWLINE instructions+=Instruction
	 */
	protected void emit_GroupingMessages_IDTerminalRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     Colors?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=MyID ('<<' ('(' EndID ',' '#' HEXCODE ')')? EndID* '>>')? (ambiguity) NEWLINE (rule end)
	 *     name=MyID (ambiguity) NEWLINE (rule end)
	 */
	protected void emit_Instruction_ColorsParserRuleCall_0_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (
	  *         AutoNumber | 
	  *         Title | 
	  *         Legend | 
	  *         Newpage | 
	  *         Divider | 
	  *         Delay | 
	  *         Space | 
	  *         Hidefootbox | 
	  *         ParticipantCreation
	  *     )?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) NEWLINE (rule start)
	 */
	protected void emit_Instruction___AutoNumberParserRuleCall_0_2_or_DelayParserRuleCall_0_11_or_DividerParserRuleCall_0_9_or_HidefootboxParserRuleCall_0_13_or_LegendParserRuleCall_0_4_or_NewpageParserRuleCall_0_5_or_ParticipantCreationParserRuleCall_0_16_or_SpaceParserRuleCall_0_12_or_TitleParserRuleCall_0_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     Color*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'note' ('right' | 'left') (ambiguity) ((':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')) (rule start)
	 *     lid=[Definition|ID] (ambiguity) ((':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')) (rule end)
	 *     lid=[Definition|ID] (ambiguity) ((':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')) NEWLINE (rule end)
	 *     lids+=[Definition|ID] (ambiguity) ((':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')) (rule end)
	 *     lids+=[Definition|ID] (ambiguity) ((':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')) NEWLINE (rule end)
	 *     oid=[Definition|ID] (ambiguity) ((':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')) (rule end)
	 *     oid=[Definition|ID] (ambiguity) ((':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')) NEWLINE (rule end)
	 *     oids+=[Definition|ID] (ambiguity) ((':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')) (rule end)
	 *     oids+=[Definition|ID] (ambiguity) ((':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')) NEWLINE (rule end)
	 *     rid=[Definition|ID] (ambiguity) ((':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')) (rule end)
	 *     rid=[Definition|ID] (ambiguity) ((':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')) NEWLINE (rule end)
	 *     rids+=[Definition|ID] (ambiguity) ((':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')) (rule end)
	 *     rids+=[Definition|ID] (ambiguity) ((':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')) NEWLINE (rule end)
	 */
	protected void emit_Note_ColorParserRuleCall_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'right' | 'left'
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'note' (ambiguity) Color* ((':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')) (rule start)
	 */
	protected void emit_Note_LeftKeyword_1_1_0_or_RightKeyword_1_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (':' MyID*) | ((NEWLINE EndID*)* 'end' 'note')
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'note' ('right' | 'left') Color* (ambiguity) (rule start)
	 *     lid=[Definition|ID] Color* (ambiguity) (rule end)
	 *     lid=[Definition|ID] Color* (ambiguity) NEWLINE (rule end)
	 *     lids+=[Definition|ID] Color* (ambiguity) (rule end)
	 *     lids+=[Definition|ID] Color* (ambiguity) NEWLINE (rule end)
	 *     oid=[Definition|ID] Color* (ambiguity) (rule end)
	 *     oid=[Definition|ID] Color* (ambiguity) NEWLINE (rule end)
	 *     oids+=[Definition|ID] Color* (ambiguity) (rule end)
	 *     oids+=[Definition|ID] Color* (ambiguity) NEWLINE (rule end)
	 *     rid=[Definition|ID] Color* (ambiguity) (rule end)
	 *     rid=[Definition|ID] Color* (ambiguity) NEWLINE (rule end)
	 *     rids+=[Definition|ID] Color* (ambiguity) (rule end)
	 *     rids+=[Definition|ID] Color* (ambiguity) NEWLINE (rule end)
	 */
	protected void emit_Note___ColonKeyword_3_0_0_MyIDParserRuleCall_3_0_1_a___or_____NEWLINETerminalRuleCall_3_1_0_0_EndIDParserRuleCall_3_1_0_1_a__a_EndKeyword_3_1_1_NoteKeyword_3_1_2__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (':' MyID*) | ((NEWLINE EndID*)* 'end' 'ref')
	 *
	 * This ambiguous syntax occurs at:
	 *     id=[Definition|ID] (ambiguity) (rule end)
	 *     id=[Definition|ID] (ambiguity) NEWLINE (rule end)
	 *     ids+=[Definition|ID] (ambiguity) (rule end)
	 *     ids+=[Definition|ID] (ambiguity) NEWLINE (rule end)
	 */
	protected void emit_Reference___ColonKeyword_4_0_0_MyIDParserRuleCall_4_0_1_a___or_____NEWLINETerminalRuleCall_4_1_0_0_EndIDParserRuleCall_4_1_0_1_a__a_EndKeyword_4_1_1_RefKeyword_4_1_2__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}