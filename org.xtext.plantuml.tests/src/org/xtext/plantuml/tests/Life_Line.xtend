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
class Life_Line extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	

	//1.21 Lifeline Activation and destruction
	
	@Test
	def void activate(){
		'''
		@startuml
		User -> A: "DoWork"
		activate A
		A -> B: "test"
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void activate_and_destroy(){
		'''
		@startuml
		User -> A: "DoWork"
		activate A
		A -> B: "test"
		destroy A
		A -> B: "after destroy"
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void multiple_activate_and_destruction(){
		'''
		@startuml
		participant User
		User -> A: "DoWork"
		activate A
		A -> B: "hej hej hej"
		activate B
		B -> C: "DoWork"
		activate C
		C --> B: "WorkDone"
		destroy C
		B --> A: "RequestCreated"
		deactivate B
		A -> User: "Done"
		deactivate A
		@enduml
		'''.parse.assertNoErrors
	}
	
		@Test
	def void multiple_colored_activate_and_destruction(){
		'''
		@startuml
		participant User
		User -> A: "DoWork"
		activate A #FFBBBB
		A -> A: "Internal call"
		activate A #DarkSalmon
		A -> B: "<< createRequest >>"
		activate B #00dd00
		B --> A: "RequestCreated"
		deactivate B
		deactivate A
		A -> User: "Done"
		deactivate A
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