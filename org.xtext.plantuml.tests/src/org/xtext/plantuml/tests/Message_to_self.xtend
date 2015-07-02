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


// 1.5 tests Message to self


@RunWith(typeof(XtextRunner))
@InjectWith(typeof(PlantumlInjectorProvider))
class Message_to_self extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	

	
	@Test
	def void simpleMessageToSelf(){
		'''
		@startuml
			Alice->Alice: This is a signal to self
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