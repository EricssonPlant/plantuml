package org.xtext.ui;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import static org.eclipse.swt.SWT.*;


public class PlantumlHighlightingConfiguration implements IHighlightingConfiguration{
		public static final String DIAGRAM = "Start- and enduml";
		public static final String SEQ_ARR = "Sequence arrow";
		public static final String COMMENT = "Comment";
		public static final String DEFINITION = "Definition";
		public static final String[] ALL_STRINGS = 
		{
			DIAGRAM, SEQ_ARR, COMMENT, DEFINITION
		};
	
	public void configure(IHighlightingConfigurationAcceptor acceptor){
		addType( acceptor, DIAGRAM, 50, 0, 0, NORMAL);
		addType( acceptor, SEQ_ARR, 50, 0, 0, NORMAL);
		addType( acceptor, COMMENT, 150, 200, 0, NORMAL);
		addType( acceptor, DEFINITION, 50, 200, 0, NORMAL);
	}
	
	private void addType(IHighlightingConfigurationAcceptor acceptor,
			Object addType) {
		// TODO Auto-generated method stub
		
	}

	public void addType(IHighlightingConfigurationAcceptor acceptor,
	String s, int r, int g, int b, int style){
		TextStyle textStyle = new TextStyle();
		textStyle.setBackgroundColor(new RGB(255,255,255));
		textStyle.setColor(new RGB(r, g, b));
		textStyle.setStyle(style);
		acceptor.acceptDefaultHighlighting(s, s, textStyle);
	}

}
