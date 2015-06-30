/**
 */
package org.xtext.plantuml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.plantuml.Diagram#getInstructions <em>Instructions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.plantuml.PlantumlPackage#getDiagram()
 * @model
 * @generated
 */
public interface Diagram extends EObject
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
   * @see org.xtext.plantuml.PlantumlPackage#getDiagram_Instructions()
   * @model containment="true"
   * @generated
   */
  EList<Instruction> getInstructions();

} // Diagram
