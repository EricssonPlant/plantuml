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
class Arrow_style extends XtextTest {
	@Inject extension ParseHelper<Plantuml>
	@Inject extension ValidationTestHelper
	
	@Test
	def void simpleRightArrow(){
		'''
		@startuml
			Alice -> Bob: "simple right arrow"
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void simpleLeftArrow(){
		'''
		@startuml
			Alice <- Bob: "simple left arrow"
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void dottedRightArrow(){
		'''
		@startuml
			Alice --> Bob: "dotted right arrow"
			Alice ---> Bob: "dotted right arrow"
			Alice ----> Bob: "dotted right arrow"
			Alice -----> Bob: "dotted right arrow"
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void dottedLeftArrow(){
		'''
		@startuml
			Alice <-- Bob : "dotted left arrow"
			Alice <--- Bob : "dotted left arrow"
			Alice <---- Bob : "dotted left arrow"
			Alice <----- Bob : "dotted left arrow"
			Alice <------ Bob : "dotted left arrow"
		@enduml
		'''.parse.assertNoErrors
	}
	
	// not sure if last one should work??
	@Test
	def void multipleDoubleArrows(){
		'''
		@startuml
			Alice <--> Bob: "arrow"
			Alice x<-->x Bob: "arrow"
			Alice o<-->o Bob: "arrow"
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void multipleComplexLeftArrows(){
		'''
		@startuml
			Alice <- Bob: "dotted left arrow"
			Alice <-- Bob: "dotted left arrow"
			
			Alice x<- Bob: "dotted left arrow"
			Alice x<-- Bob: "dotted left arrow"
			
			Alice x<- Bob: "dotted left arrow"
			Alice o<-- Bob: "dotted left arrow"
		@enduml
		'''.parse.assertNoErrors
	}
	
	@Test
	def void diffrentArrowBodys(){
		'''
		@startuml
			Alice <- Bob: "simple left arrow"
			Alice <= Bob: "simple left arrow"
			Alice <. Bob: "simple left arrow"
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