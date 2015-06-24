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
   * The meta object id for the '{@link org.xtext.plantuml.impl.PlantumlImpl <em>Plantuml</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.PlantumlImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getPlantuml()
   * @generated
   */
  int PLANTUML = 0;

  /**
   * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLANTUML__DIAGRAMS = 0;

  /**
   * The number of structural features of the '<em>Plantuml</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLANTUML_FEATURE_COUNT = 1;

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
   * The number of structural features of the '<em>Instruction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTRUCTION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.ArrowImpl <em>Arrow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.ArrowImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getArrow()
   * @generated
   */
  int ARROW = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROW__NAME = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Arrow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROW_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.DefinitionImpl <em>Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.DefinitionImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getDefinition()
   * @generated
   */
  int DEFINITION = 4;

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
  int ALT_ELSE = 5;

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
  int ELSE = 6;

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
  int GROUPING_MESSAGES = 7;

  /**
   * The number of structural features of the '<em>Grouping Messages</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUPING_MESSAGES_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.NoteImpl <em>Note</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.NoteImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getNote()
   * @generated
   */
  int NOTE = 8;

  /**
   * The feature id for the '<em><b>Rid</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOTE__RID = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rids</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOTE__RIDS = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Lid</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOTE__LID = INSTRUCTION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Lids</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOTE__LIDS = INSTRUCTION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Oid</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOTE__OID = INSTRUCTION_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Oids</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOTE__OIDS = INSTRUCTION_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Note</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOTE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.ReferenceImpl <em>Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.ReferenceImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getReference()
   * @generated
   */
  int REFERENCE = 9;

  /**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__ID = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ids</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__IDS = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.ActivateImpl <em>Activate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.ActivateImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getActivate()
   * @generated
   */
  int ACTIVATE = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVATE__NAME = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Activate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVATE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.DeactivateImpl <em>Deactivate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.DeactivateImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getDeactivate()
   * @generated
   */
  int DEACTIVATE = 11;

  /**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEACTIVATE__ID = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Deactivate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEACTIVATE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.BoxImpl <em>Box</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.BoxImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getBox()
   * @generated
   */
  int BOX = 12;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOX__DEFINITIONS = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Box</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOX_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.plantuml.impl.GroupingMessageImpl <em>Grouping Message</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.plantuml.impl.GroupingMessageImpl
   * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getGroupingMessage()
   * @generated
   */
  int GROUPING_MESSAGE = 13;

  /**
   * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUPING_MESSAGE__INSTRUCTIONS = GROUPING_MESSAGES_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Grouping Message</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUPING_MESSAGE_FEATURE_COUNT = GROUPING_MESSAGES_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.xtext.plantuml.Plantuml <em>Plantuml</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plantuml</em>'.
   * @see org.xtext.plantuml.Plantuml
   * @generated
   */
  EClass getPlantuml();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.plantuml.Plantuml#getDiagrams <em>Diagrams</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Diagrams</em>'.
   * @see org.xtext.plantuml.Plantuml#getDiagrams()
   * @see #getPlantuml()
   * @generated
   */
  EReference getPlantuml_Diagrams();

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
   * Returns the meta object for class '{@link org.xtext.plantuml.Arrow <em>Arrow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Arrow</em>'.
   * @see org.xtext.plantuml.Arrow
   * @generated
   */
  EClass getArrow();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.plantuml.Arrow#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Name</em>'.
   * @see org.xtext.plantuml.Arrow#getName()
   * @see #getArrow()
   * @generated
   */
  EAttribute getArrow_Name();

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
   * Returns the meta object for class '{@link org.xtext.plantuml.Note <em>Note</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Note</em>'.
   * @see org.xtext.plantuml.Note
   * @generated
   */
  EClass getNote();

  /**
   * Returns the meta object for the reference '{@link org.xtext.plantuml.Note#getRid <em>Rid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Rid</em>'.
   * @see org.xtext.plantuml.Note#getRid()
   * @see #getNote()
   * @generated
   */
  EReference getNote_Rid();

  /**
   * Returns the meta object for the reference list '{@link org.xtext.plantuml.Note#getRids <em>Rids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Rids</em>'.
   * @see org.xtext.plantuml.Note#getRids()
   * @see #getNote()
   * @generated
   */
  EReference getNote_Rids();

  /**
   * Returns the meta object for the reference '{@link org.xtext.plantuml.Note#getLid <em>Lid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Lid</em>'.
   * @see org.xtext.plantuml.Note#getLid()
   * @see #getNote()
   * @generated
   */
  EReference getNote_Lid();

  /**
   * Returns the meta object for the reference list '{@link org.xtext.plantuml.Note#getLids <em>Lids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Lids</em>'.
   * @see org.xtext.plantuml.Note#getLids()
   * @see #getNote()
   * @generated
   */
  EReference getNote_Lids();

  /**
   * Returns the meta object for the reference '{@link org.xtext.plantuml.Note#getOid <em>Oid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Oid</em>'.
   * @see org.xtext.plantuml.Note#getOid()
   * @see #getNote()
   * @generated
   */
  EReference getNote_Oid();

  /**
   * Returns the meta object for the reference list '{@link org.xtext.plantuml.Note#getOids <em>Oids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Oids</em>'.
   * @see org.xtext.plantuml.Note#getOids()
   * @see #getNote()
   * @generated
   */
  EReference getNote_Oids();

  /**
   * Returns the meta object for class '{@link org.xtext.plantuml.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference</em>'.
   * @see org.xtext.plantuml.Reference
   * @generated
   */
  EClass getReference();

  /**
   * Returns the meta object for the reference '{@link org.xtext.plantuml.Reference#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see org.xtext.plantuml.Reference#getId()
   * @see #getReference()
   * @generated
   */
  EReference getReference_Id();

  /**
   * Returns the meta object for the reference list '{@link org.xtext.plantuml.Reference#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Ids</em>'.
   * @see org.xtext.plantuml.Reference#getIds()
   * @see #getReference()
   * @generated
   */
  EReference getReference_Ids();

  /**
   * Returns the meta object for class '{@link org.xtext.plantuml.Activate <em>Activate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Activate</em>'.
   * @see org.xtext.plantuml.Activate
   * @generated
   */
  EClass getActivate();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.plantuml.Activate#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.plantuml.Activate#getName()
   * @see #getActivate()
   * @generated
   */
  EAttribute getActivate_Name();

  /**
   * Returns the meta object for class '{@link org.xtext.plantuml.Deactivate <em>Deactivate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Deactivate</em>'.
   * @see org.xtext.plantuml.Deactivate
   * @generated
   */
  EClass getDeactivate();

  /**
   * Returns the meta object for the reference '{@link org.xtext.plantuml.Deactivate#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see org.xtext.plantuml.Deactivate#getId()
   * @see #getDeactivate()
   * @generated
   */
  EReference getDeactivate_Id();

  /**
   * Returns the meta object for class '{@link org.xtext.plantuml.Box <em>Box</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Box</em>'.
   * @see org.xtext.plantuml.Box
   * @generated
   */
  EClass getBox();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.plantuml.Box#getDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definitions</em>'.
   * @see org.xtext.plantuml.Box#getDefinitions()
   * @see #getBox()
   * @generated
   */
  EReference getBox_Definitions();

  /**
   * Returns the meta object for class '{@link org.xtext.plantuml.GroupingMessage <em>Grouping Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Grouping Message</em>'.
   * @see org.xtext.plantuml.GroupingMessage
   * @generated
   */
  EClass getGroupingMessage();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.plantuml.GroupingMessage#getInstructions <em>Instructions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Instructions</em>'.
   * @see org.xtext.plantuml.GroupingMessage#getInstructions()
   * @see #getGroupingMessage()
   * @generated
   */
  EReference getGroupingMessage_Instructions();

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
     * The meta object literal for the '{@link org.xtext.plantuml.impl.PlantumlImpl <em>Plantuml</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.PlantumlImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getPlantuml()
     * @generated
     */
    EClass PLANTUML = eINSTANCE.getPlantuml();

    /**
     * The meta object literal for the '<em><b>Diagrams</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLANTUML__DIAGRAMS = eINSTANCE.getPlantuml_Diagrams();

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
     * The meta object literal for the '{@link org.xtext.plantuml.impl.ArrowImpl <em>Arrow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.ArrowImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getArrow()
     * @generated
     */
    EClass ARROW = eINSTANCE.getArrow();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARROW__NAME = eINSTANCE.getArrow_Name();

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
     * The meta object literal for the '{@link org.xtext.plantuml.impl.NoteImpl <em>Note</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.NoteImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getNote()
     * @generated
     */
    EClass NOTE = eINSTANCE.getNote();

    /**
     * The meta object literal for the '<em><b>Rid</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOTE__RID = eINSTANCE.getNote_Rid();

    /**
     * The meta object literal for the '<em><b>Rids</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOTE__RIDS = eINSTANCE.getNote_Rids();

    /**
     * The meta object literal for the '<em><b>Lid</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOTE__LID = eINSTANCE.getNote_Lid();

    /**
     * The meta object literal for the '<em><b>Lids</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOTE__LIDS = eINSTANCE.getNote_Lids();

    /**
     * The meta object literal for the '<em><b>Oid</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOTE__OID = eINSTANCE.getNote_Oid();

    /**
     * The meta object literal for the '<em><b>Oids</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOTE__OIDS = eINSTANCE.getNote_Oids();

    /**
     * The meta object literal for the '{@link org.xtext.plantuml.impl.ReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.ReferenceImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getReference()
     * @generated
     */
    EClass REFERENCE = eINSTANCE.getReference();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__ID = eINSTANCE.getReference_Id();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__IDS = eINSTANCE.getReference_Ids();

    /**
     * The meta object literal for the '{@link org.xtext.plantuml.impl.ActivateImpl <em>Activate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.ActivateImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getActivate()
     * @generated
     */
    EClass ACTIVATE = eINSTANCE.getActivate();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTIVATE__NAME = eINSTANCE.getActivate_Name();

    /**
     * The meta object literal for the '{@link org.xtext.plantuml.impl.DeactivateImpl <em>Deactivate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.DeactivateImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getDeactivate()
     * @generated
     */
    EClass DEACTIVATE = eINSTANCE.getDeactivate();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEACTIVATE__ID = eINSTANCE.getDeactivate_Id();

    /**
     * The meta object literal for the '{@link org.xtext.plantuml.impl.BoxImpl <em>Box</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.BoxImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getBox()
     * @generated
     */
    EClass BOX = eINSTANCE.getBox();

    /**
     * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOX__DEFINITIONS = eINSTANCE.getBox_Definitions();

    /**
     * The meta object literal for the '{@link org.xtext.plantuml.impl.GroupingMessageImpl <em>Grouping Message</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.plantuml.impl.GroupingMessageImpl
     * @see org.xtext.plantuml.impl.PlantumlPackageImpl#getGroupingMessage()
     * @generated
     */
    EClass GROUPING_MESSAGE = eINSTANCE.getGroupingMessage();

    /**
     * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GROUPING_MESSAGE__INSTRUCTIONS = eINSTANCE.getGroupingMessage_Instructions();

  }

} //PlantumlPackage
