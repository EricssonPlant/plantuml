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
class SkinparamTest extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	
	
	@Test
	def void skinparamSingeline(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		skinparam backgroundColor #EEEBDC
		skinparam Sequence #DeepskyBlue
		Alice -> Alice : "test test test"
		Kalle -> Stangen
		@enduml
		'''.parse.assertNoErrors
	}
	
	def void skinparamSequence(){
		'''
		@startuml
		skinparam sequence {
		ArrowColor DeepSkyBlue
		ActorBorderColor DeepSkyBlue
		LifeLineBorderColor blue
		LifeLineBackgroundColor #A9DCDF
		ParticipantBorderColor DeepSkyBlue
		ParticipantBackgroundColor DodgerBlue
		ParticipantFontName Impact
		ParticipantFontSize 17
		ParticipantFontColor #A9DCDF
		ActorBackgroundColor aqua
		ActorFontColor DeepSkyBlue
		ActorFontSize 17
		ActorFontName Aapex
		}
		
		actor User
		User -> A: "DoWork"
		activate A
		A -> B: "Create Request"
		activate B
		B -> C: "DoWork"
		activate C
		C --> B: "WorkDone"
		destroy C
		B --> A: "Request Created"
		deactivate B
		A --> User: "Done"
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