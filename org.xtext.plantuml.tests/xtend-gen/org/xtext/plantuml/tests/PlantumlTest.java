package org.xtext.plantuml.tests;

import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xtext.PlantumlInjectorProvider;
import org.xtext.plantuml.Plantuml;

@RunWith(XtextRunner.class)
@InjectWith(PlantumlInjectorProvider.class)
@SuppressWarnings("all")
public class PlantumlTest {
  @Inject
  @Extension
  private ParseHelper<Plantuml> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testTitle() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@startuml");
      _builder.newLine();
      _builder.append("title hello");
      _builder.newLine();
      _builder.append("@enduml");
      _builder.newLine();
      Plantuml _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testTitleSL() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@startuml");
      _builder.newLine();
      _builder.append("title hello my name is anton");
      _builder.newLine();
      _builder.append("@enduml");
      _builder.newLine();
      Plantuml _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testTitleML() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@startuml");
      _builder.newLine();
      _builder.append("title hello my name is");
      _builder.newLine();
      _builder.append("Anton Anton Anton");
      _builder.newLine();
      _builder.append("@enduml");
      _builder.newLine();
      Plantuml _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
