/**
 */
package org.xtext.plantuml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alt Else</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.plantuml.AltElse#getInstructions <em>Instructions</em>}</li>
 *   <li>{@link org.xtext.plantuml.AltElse#getElses <em>Elses</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.plantuml.PlantumlPackage#getAltElse()
 * @model
 * @generated
 */
public interface AltElse extends Instruction
{
  /**
   * Returns the value of the '<em><b>Instructions</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.plantuml.Instruction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instructions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instructions</em>' containment reference list.
   * @see org.xtext.plantuml.PlantumlPackage#getAltElse_Instructions()
   * @model containment="true"
   * @generated
   */
  EList<Instruction> getInstructions();

  /**
   * Returns the value of the '<em><b>Elses</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.plantuml.Else}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elses</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elses</em>' containment reference list.
   * @see org.xtext.plantuml.PlantumlPackage#getAltElse_Elses()
   * @model containment="true"
   * @generated
   */
  EList<Else> getElses();

} // AltElse
