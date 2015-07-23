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
class Divider extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	

	//1.17 Divider
	
	@Test
	def void Divider(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		== "Initialization" ==
		Alice -> Bob: "Authentication Request"
		Bob --> Alice: "Authentication Response"
		== "Repetition" ==
		Alice -> Bob: "Another authentication Request"
		Alice <-- Bob: "another authentication Response"
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