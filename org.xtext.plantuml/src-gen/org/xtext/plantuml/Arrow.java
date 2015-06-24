/**
 */
package org.xtext.plantuml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arrow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.plantuml.Arrow#getIds <em>Ids</em>}</li>
 * </ul>
 *
 * @see org.xtext.plantuml.PlantumlPackage#getArrow()
 * @model
 * @generated
 */
public interface Arrow extends Instruction
{
  /**
   * Returns the value of the '<em><b>Ids</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ids</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ids</em>' attribute list.
   * @see org.xtext.plantuml.PlantumlPackage#getArrow_Ids()
   * @model unique="false"
   * @generated
   */
  EList<String> getIds();

} // Arrow
