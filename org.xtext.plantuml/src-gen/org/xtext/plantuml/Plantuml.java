/**
 */
package org.xtext.plantuml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plantuml</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.plantuml.Plantuml#getDiagrams <em>Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.plantuml.PlantumlPackage#getPlantuml()
 * @model
 * @generated
 */
public interface Plantuml extends EObject
{
  /**
   * Returns the value of the '<em><b>Diagrams</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.plantuml.Diagram}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Diagrams</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Diagrams</em>' containment reference list.
   * @see org.xtext.plantuml.PlantumlPackage#getPlantuml_Diagrams()
   * @model containment="true"
   * @generated
   */
  EList<Diagram> getDiagrams();

} // Plantuml
