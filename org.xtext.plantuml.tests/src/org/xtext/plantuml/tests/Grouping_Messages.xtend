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


// 1.12 Grouping message

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(PlantumlInjectorProvider))
class Grouping_Messages extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	

	
	@Test
	def void Grouping_Messages(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		Alice -> Bob: "Authentication Request"
		alt "successful case"
		Bob -> Alice: "Authentication Accepted"
		else "some kind of failure"
		Bob -> Alice: "Authentication Failure"
		group "My own label"
		Alice -> Log : "Log attack start"
		loop "1000 times"
		Alice -> Bob: "DNS Attack"
		end
		Alice -> Log :"Log attack end"
		end
		else "Another type of failure"
		Bob -> Alice: "Please repeat"
		end
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