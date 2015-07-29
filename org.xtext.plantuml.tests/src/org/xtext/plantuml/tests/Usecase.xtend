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
class UC_Actor extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	

	//2 Usecase
	
		@Test
	def void Usecase(){
		'''
		@startuml
		(simple)
		usecase Men3
		@enduml
		'''.parse.assertNoErrors
	}
	
	
	
	@Test
	def void Actor(){
		'''
		@startuml
		:simple:
		actor Men3
		@enduml
		'''.parse.assertNoErrors
	}
	
	// not tested because not implemented yet
	//@Test
	def void Extensions(){
		'''
		@startuml
		:User: <|-- :Admin:
		(Start) <|-- (Use)
		@enduml
		'''.parse.assertNoErrors
	}
	
	

	@Test
	def void Direction_ltr(){
		'''
		@startuml
		left to right direction
		user1 --> (Usecase1)
		user2 --> (Usecase2)
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void Direction_ttb(){
		'''
		@startuml
		top to bottom direction
		user1 --> (Usecase1)
		user2 --> (Usecase2)
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