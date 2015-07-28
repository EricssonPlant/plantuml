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
class Stereotype extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	

	//1.24 Strereotypes and Spots
	
	@Test
	def void lable_stereotype(){
		'''
		@startuml
		participant Bob << "Generated" >>
		@enduml
		'''.parse.assertNoErrors
	}
	
		@Test
	def void colored_stereotype(){
		'''
		@startuml
		participant Alice << (C,#ADD1B2) >>
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void both_stereotype(){
		'''
		@startuml
		participant Alice << (C,#ADD1B2) "Testable" >>
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