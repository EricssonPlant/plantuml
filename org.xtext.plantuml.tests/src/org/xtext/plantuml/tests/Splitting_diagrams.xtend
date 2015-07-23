package org.xtext.plantuml.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.junit.Test
import org.junit.runner.RunWith
import org.xtext.PlantumlInjectorProvider
import org.xtext.plantuml.Plantuml


// 1.11 Splitting diagrams

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(PlantumlInjectorProvider))
class Splitting_Diagrams extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	

	
	@Test
	def void SplittingADiagramTwoTimes(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
			Alice -> Bob : "message 1"
			Alice -> Bob : "message 2"
			newpage
			Alice -> Bob : "message 3"
			Alice -> Bob : "message 4"
			newpage "A title for the\nlast page"
			Alice -> Bob : "message 5"
			Alice -> Bob : "message 6"
		@enduml
		'''.parse.assertNoErrors
	}
	
	
	/*
	 * // template
	@Test
	def void some_name(){
		'''
		@startuml

		@enduml
		'''.parse.assertNoErrors
	}
	 */
	

	
	
	
}