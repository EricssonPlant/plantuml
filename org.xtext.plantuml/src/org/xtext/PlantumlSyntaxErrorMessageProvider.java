package org.xtext;

import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider;

public class PlantumlSyntaxErrorMessageProvider extends SyntaxErrorMessageProvider {
	/* TODO: Implement custom error message syntax" */
	/* TODO: Try to import error messages from Plantuml.jar*/
	
	public static String NO_INSTRUCTIONS = "NO_INSTRUCTIONS";
	public static String NOT_IN_GRAMMAR = "NOT_IN_GRAMMAR";
	
	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context){
		/*System.out.println("Default message: " + context.getDefaultMessage());
		System.out.println("Recognition Exception: " + context.getRecognitionException());
		System.out.println("Tokens: " + context.getTokenNames());*/
		if(context.getRecognitionException() instanceof EarlyExitException)
			return new SyntaxErrorMessage("Must have an instruction between @startuml and @enduml", NO_INSTRUCTIONS);
		else if (context.getRecognitionException() instanceof NoViableAltException){
			System.out.println(context.getRecognitionException().toString());
			return new SyntaxErrorMessage("Token not found/Not viable alternative", NOT_IN_GRAMMAR);
		}
		else{
			return super.getSyntaxErrorMessage(context);
		}
	}
}
