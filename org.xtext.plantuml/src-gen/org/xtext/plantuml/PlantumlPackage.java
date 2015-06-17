/**
 */
package org.xtext.plantuml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.xtext.plantuml.PlantumlFactory
 * @model kind="package"
 * @generated
 */
public interface PlantumlPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "plantuml";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.xtext.org/Plantuml";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "plantuml";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PlantumlPackage eINSTANCE = org.xtext.plantuml.impl.PlantumlPackageImpl.init();

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.ModelImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__DIAGRAMS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.DiagramImpl <em>Diagram</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.DiagramImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getDiagram()
   * @generated
   */
  int DIAGRAM = 1;

  /**
   * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIAGRAM__INSTRUCTIONS = 0;

  /**
   * The number of structural features of the '<em>Diagram</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIAGRAM_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.InstructionImpl <em>Instruction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.InstructionImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getInstruction()
   * @generated
   */
  int INSTRUCTION = 2;

  /**
   * The feature id for the '<em><b>Name1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTRUCTION__NAME1 = 0;

  /**
   * The feature id for the '<em><b>Name2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTRUCTION__NAME2 = 1;

  /**
   * The number of structural features of the '<em>Instruction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTRUCTION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.DefinitionImpl <em>Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.DefinitionImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getDefinition()
   * @generated
   */
  int DEFINITION = 3;

  /**
   * The feature id for the '<em><b>Name1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__NAME1 = INSTRUCTION__NAME1;

  /**
   * The feature id for the '<em><b>Name2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__NAME2 = INSTRUCTION__NAME2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__NAME = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.AltElseImpl <em>Alt Else</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.AltElseImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getAltElse()
   * @generated
   */
  int ALT_ELSE = 4;

  /**
   * The feature id for the '<em><b>Name1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALT_ELSE__NAME1 = INSTRUCTION__NAME1;

  /**
   * The feature id for the '<em><b>Name2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALT_ELSE__NAME2 = INSTRUCTION__NAME2;

  /**
   * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALT_ELSE__INSTRUCTIONS = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Elses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALT_ELSE__ELSES = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Alt Else</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALT_ELSE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.ElseImpl <em>Else</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.ElseImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getElse()
   * @generated
   */
  int ELSE = 5;

  /**
   * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE__INSTRUCTIONS = 0;

  /**
   * The number of structural features of the '<em>Else</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.GroupingMessagesImpl <em>Grouping Messages</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.GroupingMessagesImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getGroupingMessages()
   * @generated
   */
  int GROUPING_MESSAGES = 6;

  /**
   * The feature id for the '<em><b>Name1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUPING_MESSAGES__NAME1 = INSTRUCTION__NAME1;

  /**
   * The feature id for the '<em><b>Name2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUPING_MESSAGES__NAME2 = INSTRUCTION__NAME2;

  /**
   * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUPING_MESSAGES__INSTRUCTIONS = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Grouping Messages</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUPING_MESSAGES_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.xtext.plantuml.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.xtext.plantuml.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.plantuml.Model#getDiagrams <em>Diagrams</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Diagrams</em>'.
   * @see org.xtext.plantuml.Model#getDiagrams()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Diagrams();

  /**
   * Returns the meta object for class '{@link org.xtext.plantuml.Diagram <em>Diagram</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Diagram</em>'.
   * @see org.xtext.plantuml.Diagram
   * @generated
   */
  EClass getDiagram();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.plantuml.Diagram#getInstructions <em>Instructions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Instructions</em>'.
   * @see org.xtext.plantuml.Diagram#getInstructions()
   * @see #getDiagram()
   * @generated
   */
  EReference getDiagram_Instructions();

  /**
   * Returns the meta object for class '{@link org.xtext.plantuml.Instruction <em>Instruction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instruction</em>'.
   * @see org.xtext.plantuml.Instruction
   * @generated
   */
  EClass getInstruction();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.plantuml.Instruction#getName1 <em>Name1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name1</em>'.
   * @see org.xtext.plantuml.Instruction#getName1()
   * @see #getInstruction()
   * @generated
   */
  EAttribute getInstruction_Name1();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.plantuml.Instruction#getName2 <em>Name2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name2</em>'.
   * @see org.xtext.plantuml.Instruction#getName2()
   * @see #getInstruction()
   * @generated
   */
  EAttribute getInstruction_Name2();

  /**
   * Returns the meta object for class '{@link org.xtext.plantuml.Definition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definition</em>'.
   * @see org.xtext.plantuml.Definition
   * @generated
   */
  EClass getDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.plantuml.Definition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.plantuml.Definition#getName()
   * @see #getDefinition()
   * @generated
   */
  EAttribute getDefinition_Name();

  /**
   * Returns the meta object for class '{@link org.xtext.plantuml.AltElse <em>Alt Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alt Else</em>'.
   * @see org.xtext.plantuml.AltElse
   * @generated
   */
  EClass getAltElse();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.plantuml.AltElse#getInstructions <em>Instructions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Instructions</em>'.
   * @see org.xtext.plantuml.AltElse#getInstructions()
   * @see #getAltElse()
   * @generated
   */
  EReference getAltElse_Instructions();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.plantuml.AltElse#getElses <em>Elses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elses</em>'.
   * @see org.xtext.plantuml.AltElse#getElses()
   * @see #getAltElse()
   * @generated
   */
  EReference getAltElse_Elses();

  /**
   * Returns the meta object for class '{@link org.xtext.plantuml.Else <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Else</em>'.
   * @see org.xtext.plantuml.Else
   * @generated
   */
  EClass getElse();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.plantuml.Else#getInstructions <em>Instructions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Instructions</em>'.
   * @see org.xtext.plantuml.Else#getInstructions()
   * @see #getElse()
   * @generated
   */
  EReference getElse_Instructions();

  /**
   * Returns the meta object for class '{@link org.xtext.plantuml.GroupingMessages <em>Grouping Messages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Grouping Messages</em>'.
   * @see org.xtext.plantuml.GroupingMessages
   * @generated
   */
  EClass getGroupingMessages();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.plantuml.GroupingMessages#getInstructions <em>Instructions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Instructions</em>'.
   * @see org.xtext.plantuml.GroupingMessages#getInstructions()
   * @see #getGroupingMessages()
   * @generated
   */
  EReference getGroupingMessages_Instructions();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PlantumlFactory getPlantumlFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.xtext.plantuml.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.ModelImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Diagrams</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__DIAGRAMS = eINSTANCE.getModel_Diagrams();

    /**
     * The meta object literal for the '{@link org.xtext.plantuml.impl.DiagramImpl <em>Diagram</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.DiagramImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getDiagram()
     * @generated
     */
    EClass DIAGRAM = eINSTANCE.getDiagram();

    /**
     * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DIAGRAM__INSTRUCTIONS = eINSTANCE.getDiagram_Instructions();

    /**
     * The meta object literal for the '{@link org.xtext.plantuml.impl.InstructionImpl <em>Instruction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.InstructionImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getInstruction()
     * @generated
     */
    EClass INSTRUCTION = eINSTANCE.getInstruction();

    /**
     * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTRUCTION__NAME1 = eINSTANCE.getInstruction_Name1();

    /**
     * The meta object literal for the '<em><b>Name2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTRUCTION__NAME2 = eINSTANCE.getInstruction_Name2();

    /**
     * The meta object literal for the '{@link org.xtext.plantuml.impl.DefinitionImpl <em>Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.DefinitionImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getDefinition()
     * @generated
     */
    EClass DEFINITION = eINSTANCE.getDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFINITION__NAME = eINSTANCE.getDefinition_Name();

    /**
     * The meta object literal for the '{@link org.xtext.plantuml.impl.AltElseImpl <em>Alt Else</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.AltElseImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getAltElse()
     * @generated
     */
    EClass ALT_ELSE = eINSTANCE.getAltElse();

    /**
     * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALT_ELSE__INSTRUCTIONS = eINSTANCE.getAltElse_Instructions();

    /**
     * The meta object literal for the '<em><b>Elses</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALT_ELSE__ELSES = eINSTANCE.getAltElse_Elses();

    /**
     * The meta object literal for the '{@link org.xtext.plantuml.impl.ElseImpl <em>Else</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.ElseImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getElse()
     * @generated
     */
    EClass ELSE = eINSTANCE.getElse();

    /**
     * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELSE__INSTRUCTIONS = eINSTANCE.getElse_Instructions();

    /**
     * The meta object literal for the '{@link org.xtext.plantuml.impl.GroupingMessagesImpl <em>Grouping Messages</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.GroupingMessagesImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getGroupingMessages()
     * @generated
     */
    EClass GROUPING_MESSAGES = eINSTANCE.getGroupingMessages();

    /**
     * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GROUPING_MESSAGES__INSTRUCTIONS = eINSTANCE.getGroupingMessages_Instructions();

  }

} //PlantumlPackage
