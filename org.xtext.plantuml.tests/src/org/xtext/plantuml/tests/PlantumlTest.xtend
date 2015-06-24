package org.xtext.plantuml.tests

import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import org.xtext.PlantumlInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import javax.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.xtext.PlantumlRuntimeModule
import org.xtext.plantuml.Plantuml
import org.junit.Test
import org.eclipse.xtext.junit4.validation.ValidationTestHelper

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(PlantumlInjectorProvider))
class PlantumlTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	
	@Test
	def void testTitle(){
		'''
		@startuml
		title hello
		@enduml
		'''.parse.assertNoErrors
	}
	
	def void testTitleSL(){
		'''
		@startuml
		title hello my name is anton
		@enduml
		'''.parse.assertNoErrors
	}
	
	def void testTitleML(){
		'''
		@startuml
		title hello my name is
		Anton Anton Anton
		@enduml
		'''.parse.assertNoErrors
	}
}