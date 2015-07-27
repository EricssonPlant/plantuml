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
class Refrence extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	

	//1.18 refrence 
	
	@Test
	def void SL_refrence(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		participant Alice
		actor Bob
		ref over Alice : "ref over alice"
		Alice -> Bob : "hello"
		ref over Bob : "ref left of bob"
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void ML_refrence(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		participant Alice
		actor Bob
		Alice -> Bob : "hello"
		ref over Bob
		"This can be on
		several lines"
		end ref
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