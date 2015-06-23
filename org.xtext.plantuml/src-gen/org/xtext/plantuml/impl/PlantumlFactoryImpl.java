/**
 */
package org.xtext.plantuml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xtext.plantuml.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PlantumlFactoryImpl extends EFactoryImpl implements PlantumlFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PlantumlFactory init()
  {
    try
    {
      PlantumlFactory thePlantumlFactory = (PlantumlFactory)EPackage.Registry.INSTANCE.getEFactory(PlantumlPackage.eNS_URI);
      if (thePlantumlFactory != null)
      {
        return thePlantumlFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PlantumlFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PlantumlFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case PlantumlPackage.MODEL: return createModel();
      case PlantumlPackage.DIAGRAM: return createDiagram();
      case PlantumlPackage.INSTRUCTION: return createInstruction();
      case PlantumlPackage.ARROW: return createArrow();
      case PlantumlPackage.DEFINITION: return createDefinition();
      case PlantumlPackage.ALT_ELSE: return createAltElse();
      case PlantumlPackage.ELSE: return createElse();
      case PlantumlPackage.GROUPING_MESSAGES: return createGroupingMessages();
      case PlantumlPackage.NOTE: return createNote();
      case PlantumlPackage.REFERENCE: return createReference();
      case PlantumlPackage.ACTIVATE: return createActivate();
      case PlantumlPackage.DEACTIVATE: return createDeactivate();
      case PlantumlPackage.BOX: return createBox();
      case PlantumlPackage.GROUPING_MESSAGE: return createGroupingMessage();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Diagram createDiagram()
  {
    DiagramImpl diagram = new DiagramImpl();
    return diagram;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Instruction createInstruction()
  {
    InstructionImpl instruction = new InstructionImpl();
    return instruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arrow createArrow()
  {
    ArrowImpl arrow = new ArrowImpl();
    return arrow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Definition createDefinition()
  {
    DefinitionImpl definition = new DefinitionImpl();
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AltElse createAltElse()
  {
    AltElseImpl altElse = new AltElseImpl();
    return altElse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Else createElse()
  {
    ElseImpl else_ = new ElseImpl();
    return else_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GroupingMessages createGroupingMessages()
  {
    GroupingMessagesImpl groupingMessages = new GroupingMessagesImpl();
    return groupingMessages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Note createNote()
  {
    NoteImpl note = new NoteImpl();
    return note;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reference createReference()
  {
    ReferenceImpl reference = new ReferenceImpl();
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Activate createActivate()
  {
    ActivateImpl activate = new ActivateImpl();
    return activate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Deactivate createDeactivate()
  {
    DeactivateImpl deactivate = new DeactivateImpl();
    return deactivate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Box createBox()
  {
    BoxImpl box = new BoxImpl();
    return box;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GroupingMessage createGroupingMessage()
  {
    GroupingMessageImpl groupingMessage = new GroupingMessageImpl();
    return groupingMessage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PlantumlPackage getPlantumlPackage()
  {
    return (PlantumlPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PlantumlPackage getPackage()
  {
    return PlantumlPackage.eINSTANCE;
  }

} //PlantumlFactoryImpl
