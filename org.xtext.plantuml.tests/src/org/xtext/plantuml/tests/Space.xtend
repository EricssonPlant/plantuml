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
class Space extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	

	//1.20 Space
	
	@Test
	def void Simple_Space(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		Bob --> Alice: "ok"
		|||
		Alice -> Bob: "message 2"
		Bob --> Alice: ok
		|||
		Alice -> Bob: "message 3"
		Bob --> Alice: "ok"
		@enduml
		'''.parse.assertNoErrors
	}
	
		@Test
	def void Long_Space(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		Bob --> Alice: "ok"
		||25||
		Alice -> Bob: "message 2"
		Bob --> Alice: ok
		||45||
		Alice -> Bob: "message 3"
		||4||
		Bob --> Alice: "ok"
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