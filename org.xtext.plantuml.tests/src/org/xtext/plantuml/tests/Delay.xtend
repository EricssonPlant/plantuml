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


@RunWith(typeof(XtextRunner))
@InjectWith(typeof(PlantumlInjectorProvider))
class Delay extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	

	//1.19 Delay
	
	@Test
	def void Simple_Delay(){
		'''
		@startuml
		Alice -> Bob: "Authentication Request"
		...
		Bob --> Alice: "Authentication Response"
		...
		Bob --> Alice: "Bye !"
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void Titled_Delay(){
		'''
		@startuml
		Alice -> Bob: "Authentication Request"
		... "1 min later" ...
		Bob --> Alice: "Authentication Response"
		... "5 minutes latter" ...
		Bob --> Alice: "Bye !"
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