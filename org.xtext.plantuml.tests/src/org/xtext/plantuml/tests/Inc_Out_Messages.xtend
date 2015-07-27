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
class Inc_Out_Messages extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	

	//1.23 Incoming and outgoing messages
	
	@Test
	def void Inc_from_left(){
		'''
		@startuml
		[-> A: "DoWork"
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void out_to_right(){
		'''
		@startuml
		A ->] : "lalala"
		@enduml
		'''.parse.assertNoErrors
	}
	
		@Test
	def void Inc_from_right(){
		'''
		@startuml
		A <-] : "DoWork"
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void out_to_left(){
		'''
		@startuml
		[<- A : "lalala"
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