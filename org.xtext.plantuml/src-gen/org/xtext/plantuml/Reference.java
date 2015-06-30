/**
 */
package org.xtext.plantuml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.plantuml.Reference#getId <em>Id</em>}</li>
 *   <li>{@link org.xtext.plantuml.Reference#getIds <em>Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.plantuml.PlantumlPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends Instruction
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' reference.
   * @see #setId(Definition)
   * @see org.xtext.plantuml.PlantumlPackage#getReference_Id()
   * @model
   * @generated
   */
  Definition getId();

  /**
   * Sets the value of the '{@link org.xtext.plantuml.Reference#getId <em>Id</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' reference.
   * @see #getId()
   * @generated
   */
  void setId(Definition value);

  /**
   * Returns the value of the '<em><b>Ids</b></em>' reference list.
   * The list contents are of type {@link org.xtext.plantuml.Definition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ids</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ids</em>' reference list.
   * @see org.xtext.plantuml.PlantumlPackage#getReference_Ids()
   * @model
   * @generated
   */
  EList<Definition> getIds();

} // Reference
