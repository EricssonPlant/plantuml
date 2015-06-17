/**
 */
package org.xtext.plantuml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.plantuml.Instruction#getName1 <em>Name1</em>}</li>
 *   <li>{@link org.xtext.plantuml.Instruction#getName2 <em>Name2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.plantuml.PlantumlPackage#getInstruction()
 * @model
 * @generated
 */
public interface Instruction extends EObject
{
  /**
   * Returns the value of the '<em><b>Name1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name1</em>' attribute.
   * @see #setName1(String)
   * @see org.xtext.plantuml.PlantumlPackage#getInstruction_Name1()
   * @model
   * @generated
   */
  String getName1();

  /**
   * Sets the value of the '{@link org.xtext.plantuml.Instruction#getName1 <em>Name1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name1</em>' attribute.
   * @see #getName1()
   * @generated
   */
  void setName1(String value);

  /**
   * Returns the value of the '<em><b>Name2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name2</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name2</em>' attribute.
   * @see #setName2(String)
   * @see org.xtext.plantuml.PlantumlPackage#getInstruction_Name2()
   * @model
   * @generated
   */
  String getName2();

  /**
   * Sets the value of the '{@link org.xtext.plantuml.Instruction#getName2 <em>Name2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name2</em>' attribute.
   * @see #getName2()
   * @generated
   */
  void setName2(String value);

} // Instruction
