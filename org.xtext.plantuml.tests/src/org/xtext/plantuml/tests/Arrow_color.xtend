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
class Arrow_color extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	
	@Test
	def void simpleRedRightArrow(){
		'''
		@startuml
			Bob -[#red]> Alice : "simple red right arrow"
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void simpleHexRightArrow(){
		'''
		@startuml
			Alice -[#0000FF]-> Bob : "simple left arrow"
		@enduml
		'''.parse.assertNoErrors
	}
	
	
	//TODO do alot of right arrows???

	
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