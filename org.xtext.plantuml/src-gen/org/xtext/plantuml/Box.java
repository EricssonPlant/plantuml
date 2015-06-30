/**
 */
package org.xtext.plantuml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.plantuml.Box#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.plantuml.PlantumlPackage#getBox()
 * @model
 * @generated
 */
public interface Box extends Instruction
{
  /**
   * Returns the value of the '<em><b>Definitions</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.plantuml.Definition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Definitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definitions</em>' containment reference list.
   * @see org.xtext.plantuml.PlantumlPackage#getBox_Definitions()
   * @model containment="true"
   * @generated
   */
  EList<Definition> getDefinitions();

} // Box
