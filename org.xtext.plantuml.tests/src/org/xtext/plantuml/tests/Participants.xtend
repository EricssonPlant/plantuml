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


// 1.3 tests for declaring participants

// see book chapter 6 for TODOs  
// "Implementing Domain-specific languages with Xtext and Xtend - Bettini Lorenzo"

//TODO add color to participants, see http://plantuml.sourceforge.net/PlantUML_Language_Reference_Guide.pdf 1.3

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(PlantumlInjectorProvider))
class Participants extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	

	
	@Test
	def void declaringParticipantsActor(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
			actor Foo1
		@enduml
		'''.parse.assertNoErrors
	}
	
	def void declaringParticipantsBoundary(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
			boundary Foo2
		@enduml
		'''.parse.assertNoErrors
	}
	
	def void declaringParticipantsControl(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
			control Foo3
		@enduml
		'''.parse.assertNoErrors
	}
	
	def void declaringParticipantsEntity(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
			entity Foo4
		@enduml
		'''.parse.assertNoErrors
	}
	
	def void declaringParticipantsDatabase(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
			database Foo5
		@enduml
		'''.parse.assertNoErrors
	}
	
	def void declaringParticipantsAll(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
			actor Foo1
			boundary Foo2
			control Foo3
			entity Foo4
			database Foo5
		@enduml
		'''.parse.assertNoErrors
	}
	
	
	/*def void declaringParticipantsAllsameName(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
			actor Foo1
			boundary Foo1
			control Foo1
			entity Foo1
			database Foo1
		@enduml
		'''.parse.assertNoErrors
	}*/

	
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