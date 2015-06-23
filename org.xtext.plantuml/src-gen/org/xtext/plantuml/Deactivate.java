/**
 */
package org.xtext.plantuml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deactivate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.plantuml.Deactivate#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see org.xtext.plantuml.PlantumlPackage#getDeactivate()
 * @model
 * @generated
 */
public interface Deactivate extends Instruction
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
   * @see #setId(Activate)
   * @see org.xtext.plantuml.PlantumlPackage#getDeactivate_Id()
   * @model
   * @generated
   */
  Activate getId();

  /**
   * Sets the value of the '{@link org.xtext.plantuml.Deactivate#getId <em>Id</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' reference.
   * @see #getId()
   * @generated
   */
  void setId(Activate value);

} // Deactivate
