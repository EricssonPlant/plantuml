/**
 */
package org.xtext.plantuml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.plantuml.Activate#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.plantuml.PlantumlPackage#getActivate()
 * @model
 * @generated
 */
public interface Activate extends Instruction
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.plantuml.PlantumlPackage#getActivate_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.plantuml.Activate#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Activate
