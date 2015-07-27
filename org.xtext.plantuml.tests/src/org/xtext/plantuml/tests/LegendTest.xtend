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
class LegendTest extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	

	//1.17 Divider
	
	@Test
	def void standaloneLegend(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		Alice -> Bob : "Hello"
		legend
		"Short kalse"
		endlegend
		@enduml

		'''.parse.assertNoErrors
	}
	
	@Test
	def void leftLegend(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		Alice -> Bob : "Hello"
		legend left
		"Short kalse"
		endlegend
		@enduml

		'''.parse.assertNoErrors
	}
	
	@Test
	def void rightLegend(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		Alice -> Bob : "Hello"
		legend right
		"Short kalse"
		endlegend
		@enduml

		'''.parse.assertNoErrors
	}
	
	@Test
	def void multilineLegend(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		Alice -> Bob : "Hello"
		legend right
		"Short
		legend"
		endlegend
		@enduml

		'''.parse.assertNoErrors
	}
	
	@Test
	def void singlelineLegend(){
		//TODO create better test that not only checks if its parses, but if the parse contains participants
		'''
		@startuml
		Alice -> Bob : "Hello"
		legend right
		"Short"
		endlegend
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