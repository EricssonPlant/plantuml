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
class Notes_on_Messages extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	

	
	@Test
	def void Notes_on_Messages(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		Alice->Bob : "hello"
		note left: "this is a first note"
		Bob->Alice : "ok"
		note right: "this is another note"
		Bob->Bob : "I am thinking"
		note left
		"a note
		can also be defined
		on several lines"
		end note
		@enduml
		'''.parse.assertNoErrors
	}
	
	
	@Test
	def void Notes_on_Messages_colored(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		participant Alice
		participant Bob
		note left of Alice #aqua
		"This is displayed
		left of Alice."
		end note
		note right of Alice: "This is displayed right of Alice."
		note over Alice: "This is displayed over Alice."
		note over Alice, Bob #FFAAAA: "This is displayed\n over Bob and Alice."
		note over Bob, Alice
		"This is yet another
		example of
		a long note."
		end note
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