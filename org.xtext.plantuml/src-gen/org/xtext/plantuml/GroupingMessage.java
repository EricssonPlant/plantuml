/**
 */
package org.xtext.plantuml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grouping Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.plantuml.GroupingMessage#getInstructions <em>Instructions</em>}</li>
 * </ul>
 *
 * @see org.xtext.plantuml.PlantumlPackage#getGroupingMessage()
 * @model
 * @generated
 */
public interface GroupingMessage extends GroupingMessages
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
   * @see org.xtext.plantuml.PlantumlPackage#getGroupingMessage_Instructions()
   * @model containment="true"
   * @generated
   */
  EList<Instruction> getInstructions();

} // GroupingMessage
