package org.xtext.plantuml.tests

import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import org.xtext.PlantumlInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import javax.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(PlantumlInjectorProvider))
class PlantumlTest {
	//@Inject extension ParseHelper<Plantuml>
	
}