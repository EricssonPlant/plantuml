package org.xtext.ui;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import static org.eclipse.swt.SWT.*;


public class PlantumlHighlightingConfiguration implements IHighlightingConfiguration{
		// The values of these strings will be displayed on the settings page:
		// Window->Preferenes->Plantuml->Syntax Coloring 
		public static final String STND = "Start- and enduml";
		public static final String SEQ_ARR = "Sequence arrow";
		public static final String COMMENT = "Comment";
		public static final String DEFINITION = "Definition";
		public static final String AUTONUMBER = "Keyword";
		public static final String TITLE = "Title";
		public static final String LEGEND = "Legend";
		public static final String NEWPAGE = "Newpage";
		public static final String GROUPINGMESSAGES = "Grouping message";
		public static final String NOTE = "Note";
		public static final String DIVIDER = "Divider";
		public static final String REFERENCE = "Reference";
		public static final String DELAY = "Delay";
		public static final String SPACE = "Space";
		public static final String HIDEFOOTBOX = "Hidefootbox";
		public static final String DEACTIVATE = "Deactivate";
		public static final String PARTICIPANTCREATION = "Participantcreation";
		public static final String[] ALL_STRINGS = 
		{
			STND, SEQ_ARR, COMMENT, DEFINITION, AUTONUMBER, TITLE, LEGEND, NEWPAGE, 
			GROUPINGMESSAGES, NOTE, REFERENCE, DELAY, SPACE, HIDEFOOTBOX, DEACTIVATE, PARTICIPANTCREATION
		};
	
	// This method must be implemented as it's needed by IHighlightingConfiguration.
	// It will call addType to create the different styles needed.
	public void configure(IHighlightingConfigurationAcceptor acceptor){
		addType( acceptor, STND, 153, 0, 200, BOLD);
		addType( acceptor, SEQ_ARR, 200, 0, 0, BOLD);
		addType( acceptor, COMMENT, 0, 102, 0, BOLD);
		addType( acceptor, DEFINITION, 0, 0, 200, BOLD);
		addType( acceptor, AUTONUMBER, 0, 0, 200, BOLD);
		addType( acceptor, TITLE, 0, 0, 200, BOLD);
		addType( acceptor, LEGEND, 0, 0, 200, BOLD);
		addType( acceptor, NEWPAGE, 0, 0, 200, BOLD);
		addType( acceptor, GROUPINGMESSAGES, 0, 0, 200, BOLD);
		addType( acceptor, NOTE, 0, 0, 200, BOLD);
		addType( acceptor, DIVIDER, 0, 0, 200, BOLD);
		addType( acceptor, REFERENCE, 0, 0, 200, BOLD);
		addType( acceptor, DELAY, 0, 0, 200, BOLD);
		addType( acceptor, SPACE, 0, 0, 200, BOLD);
		addType( acceptor, HIDEFOOTBOX, 0, 0, 200, BOLD);
		addType( acceptor, DEACTIVATE, 0, 0, 200, BOLD);
		addType( acceptor, PARTICIPANTCREATION, 0, 0, 200, BOLD);
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
