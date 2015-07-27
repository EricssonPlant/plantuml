package org.xtext.ui;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import static org.eclipse.swt.SWT.*;


public class PlantumlHighlightingConfiguration implements IHighlightingConfiguration{
		// The values of these strings will be displayed on the settings page:
		// Window->Preferenes->Plantuml->Syntax Coloring 
		public static final String STARTUML = "@startuml";
		public static final String ENDUML = "@enduml";
		public static final String SEQ_ARR = "sequence arrow";
		public static final String COMMENT = "comment";
		public static final String ACTOR = "actor";
		public static final String BOUNDARY = "boundary";
		public static final String CONTROL = "control";
		public static final String ENTITY = "entity";
		public static final String DATABASE = "database";
		public static final String PARTICIPANT = "participant";
		public static final String USECASE = "usecase";
		public static final String AUTONUMBER = "autonumber";
		public static final String TITLE = "title";
		public static final String LEGEND = "legend";
		public static final String ENDLEGEND = "endlegend";
		public static final String END_LEGEND = "end legend";
		public static final String NEWPAGE = "newpage";
		public static final String ALT = "alt";
		public static final String ELSE = "else";
		public static final String OPT = "opt";
		public static final String LOOP = "loop";
		public static final String PAR = "par";
		public static final String BREAK = "break";
		public static final String CRITICAL = "critical";
		public static final String GROUP = "group";
		public static final String END = "end";
		public static final String NOTE = "note";
		public static final String ENDNOTE ="endnote";
		public static final String END_NOTE = "end note";
		public static final String DIVIDER = "==";
		public static final String REFERENCE = "ref over";
		public static final String ENDREF ="endref";
		public static final String END_REF = "end ref";
		public static final String DELAY = "...";
		public static final String SPACESINGLE = "|||";
		public static final String SPACESTARTEND = "||";
		public static final String HIDEFOOTBOX = "hidefootbox";
		public static final String HIDE_FOOTBOX = "hide footbox";
		public static final String DEACTIVATE = "deactivate";
		public static final String DESTROY = "destroy";
		public static final String PARTICIPANTCREATION = "create";
		public static final String ACTIVATE = "activate";
		public static final String BOX = "box";
		public static final String ENDBOX = "end box";
		public static final String INCOUT = "Incoming and outgoing arrows";
		public static final String SKINPARAM = "skinparam";
		public static final String SKINPARAMCOMMAND = "Skinparam command";
		public static final String STEREOTYPELEFT = "<<";
		public static final String STEREOTYPERIGHT = ">>";
		public static final String[] ALL_STRINGS = 
		{
			STARTUML, ENDUML, SEQ_ARR, COMMENT, ACTOR, BOUNDARY, CONTROL, ENTITY, DATABASE, PARTICIPANT, USECASE, AUTONUMBER, TITLE, LEGEND, ENDLEGEND, END_LEGEND, NEWPAGE, 
			ALT, ELSE, OPT, LOOP, PAR, BREAK, CRITICAL, GROUP, END, NOTE, ENDNOTE, END_NOTE, REFERENCE, ENDREF, END_REF, DELAY, SPACESINGLE, SPACESTARTEND, HIDEFOOTBOX, HIDE_FOOTBOX,
			DEACTIVATE, PARTICIPANTCREATION, ACTIVATE, BOX, ENDBOX, INCOUT, SKINPARAM, STEREOTYPELEFT, STEREOTYPERIGHT
		};
	
	// This method must be implemented as it's needed by IHighlightingConfiguration.
	// It will call addType to create the different styles needed.
	public void configure(IHighlightingConfigurationAcceptor acceptor){
		addType( acceptor, STARTUML, 153, 0, 200, BOLD);
		addType( acceptor, ENDUML, 153, 0, 200, BOLD);
		addType( acceptor, SEQ_ARR, 200, 0, 0, BOLD);
		addType( acceptor, COMMENT, 0, 102, 0, BOLD);
		addType( acceptor, ACTOR, 0, 0, 200, BOLD);
		addType( acceptor, BOUNDARY, 0, 0, 200, BOLD);
		addType( acceptor, CONTROL, 0, 0, 200, BOLD);
		addType( acceptor, ENTITY, 0, 0, 200, BOLD);
		addType( acceptor, DATABASE, 0, 0, 200, BOLD);
		addType( acceptor, PARTICIPANT, 0, 0, 200, BOLD);
		addType( acceptor, USECASE, 0, 0, 200, BOLD);
		addType( acceptor, AUTONUMBER, 0, 0, 200, BOLD);
		addType( acceptor, TITLE, 0, 0, 200, BOLD);
		addType( acceptor, LEGEND, 0, 0, 200, BOLD);
		addType( acceptor, ENDLEGEND, 0, 0, 200, BOLD);
		addType( acceptor, END_LEGEND, 0, 0, 200, BOLD);
		addType( acceptor, NEWPAGE, 0, 0, 200, BOLD);
		addType( acceptor, ALT, 0, 0, 200, BOLD);
		addType( acceptor, ELSE, 0, 0, 200, BOLD);
		addType( acceptor, OPT, 0, 0, 200, BOLD);
		addType( acceptor, LOOP, 0, 0, 200, BOLD);
		addType( acceptor, PAR, 0, 0, 200, BOLD);
		addType( acceptor, BREAK, 0, 0, 200, BOLD);
		addType( acceptor, CRITICAL, 0, 0, 200, BOLD);
		addType( acceptor, GROUP, 0, 0, 200, BOLD);
		addType( acceptor, END, 0, 0, 200, BOLD);
		addType( acceptor, NOTE, 0, 0, 200, BOLD);
		addType( acceptor, ENDNOTE, 0, 0, 200, BOLD);
		addType( acceptor, END_NOTE, 0, 0, 200, BOLD);
		addType( acceptor, DIVIDER, 0, 0, 200, BOLD);
		addType( acceptor, REFERENCE, 0, 0, 200, BOLD);
		addType( acceptor, ENDREF, 0, 0, 200, BOLD);
		addType( acceptor, END_REF, 0, 0, 200, BOLD);
		addType( acceptor, DELAY, 0, 0, 200, BOLD);
		addType( acceptor, SPACESINGLE, 0, 0, 200, BOLD);
		addType( acceptor, SPACESTARTEND, 0, 0, 200, BOLD);
		addType( acceptor, HIDEFOOTBOX, 0, 0, 200, BOLD);
		addType( acceptor, HIDE_FOOTBOX, 0, 0, 200, BOLD);
		addType( acceptor, DEACTIVATE, 0, 0, 200, BOLD);
		addType( acceptor, DESTROY, 0, 0, 200, BOLD);
		addType( acceptor, PARTICIPANTCREATION, 0, 0, 200, BOLD);
		addType( acceptor, ACTIVATE, 0, 0, 200, BOLD);
		addType( acceptor, BOX, 0, 0, 200, BOLD);
		addType( acceptor, ENDBOX, 0, 0, 200, BOLD);
		addType( acceptor, INCOUT, 0, 0, 200, BOLD);
		addType( acceptor, SKINPARAMCOMMAND, 0, 0, 200, BOLD);
		addType( acceptor, SKINPARAM, 255, 0, 200, BOLD);
		addType( acceptor, STEREOTYPELEFT, 0, 0, 200, BOLD);
		addType( acceptor, STEREOTYPERIGHT, 0, 0, 200, BOLD);
	}
	
	
	private void addType(IHighlightingConfigurationAcceptor acceptor,
			Object addType) {
		// TODO Auto-generated method stub
		
	}
	
	// This method sets the colour, backgroundcolour and the name for the style specified in the parameter.  
	public void addType(IHighlightingConfigurationAcceptor acceptor,
	String s, int r, int g, int b, int style){
		TextStyle textStyle = new TextStyle();
		textStyle.setBackgroundColor(new RGB(255,255,255));
		textStyle.setColor(new RGB(r, g, b));
		textStyle.setStyle(style);
		acceptor.acceptDefaultHighlighting(s, s, textStyle);
	}

}
