package org.xtext.plantuml.tests

import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import org.xtext.PlantumlInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import javax.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.xtext.PlantumlRuntimeModule
import org.xtext.plantuml.Plantuml
import org.junit.Test
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(PlantumlInjectorProvider))
class PlantumlTest extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	
	 new(){
	 	super("platform:/org.xtext.plantuml.tests/resources");
	 }
	
	/* @Test
	def void testTitle(){
		'''
		@startuml
		title hello
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void testTitleSL(){
		'''
		@startuml
		title hello my name is anton
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void testTitleML(){
		'''
		@startuml
		title hello my name is \n
		Anton Anton Anton
		@enduml
		'''.parse.assertNoErrors
	}*/
	
	// 1.1 Basic examples
	@Test 
	def void basicExample(){
		testFile("test1.plantuml");
	}
	
	
	
}