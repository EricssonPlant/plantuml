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
class HideFootboxTest extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	
	
	@Test
	def void HidefootboxContainingSpace(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		Alice -> Alice : "test test test"
		hide footbox
		Kalle -> Stangen
		@enduml
		'''.parse.assertNoErrors
	}
	
	def void HidefootboxWithoutSpace(){
		'''
		@startuml
		Alice -> Alice : "test test test"
		hidefootbox 
		Kalle -> Stangen
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