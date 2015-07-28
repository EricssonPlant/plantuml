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
class BoxTest extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	
	
	@Test
	def void boxOnly(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		box
		participant Bob
		participant Alice
		end box
		participant Other
		Bob -> Alice : "hello"
		Alice -> Other : "hello"
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void boxWithTitle(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		box "Internal Service"
		participant Bob
		participant Alice
		end box
		participant Other
		Bob -> Alice : "hello"
		Alice -> Other : "hello"
		@enduml
		'''.parse.assertNoErrors
	}
	
	def void boxWithColour(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		box #LightBlue
		participant Bob
		participant Alice
		end box
		participant Other
		Bob -> Alice : "hello"
		Alice -> Other : "hello"
		@enduml
		'''.parse.assertNoErrors
	}
	
	def void boxWithTitleAndColour(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		box "Internal Service" #LightBlue
		participant Bob
		participant Alice
		end box
		participant Other
		Bob -> Alice : "hello"
		Alice -> Other : "hello"
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