package org.xtext.plantuml.tests

//import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import org.xtext.PlantumlInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
//import javax.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.xtext.PlantumlRuntimeModule
import org.xtext.plantuml.Plantuml
import org.junit.Test
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.eclipse.xtext.junit4.XtextRunner
import com.google.inject.Inject


// 1.2 comments 

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(PlantumlInjectorProvider))
class Comments extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	
	
	@Test
	def void commentSL(){
		'''
		@startuml
			' this is a single line comment
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void commentML(){
		'''
		@startuml
			/' this 
			is a 
			multiline 
			comment
			'/
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