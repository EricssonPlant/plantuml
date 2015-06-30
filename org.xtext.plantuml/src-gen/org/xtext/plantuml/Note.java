/**
 */
package org.xtext.plantuml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Note</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.plantuml.Note#getRid <em>Rid</em>}</li>
 *   <li>{@link org.xtext.plantuml.Note#getRids <em>Rids</em>}</li>
 *   <li>{@link org.xtext.plantuml.Note#getLid <em>Lid</em>}</li>
 *   <li>{@link org.xtext.plantuml.Note#getLids <em>Lids</em>}</li>
 *   <li>{@link org.xtext.plantuml.Note#getOid <em>Oid</em>}</li>
 *   <li>{@link org.xtext.plantuml.Note#getOids <em>Oids</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.plantuml.PlantumlPackage#getNote()
 * @model
 * @generated
 */
public interface Note extends Instruction
{
  /**
   * Returns the value of the '<em><b>Rid</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rid</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rid</em>' reference.
   * @see #setRid(Definition)
   * @see org.xtext.plantuml.PlantumlPackage#getNote_Rid()
   * @model
   * @generated
   */
  Definition getRid();

  /**
   * Sets the value of the '{@link org.xtext.plantuml.Note#getRid <em>Rid</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rid</em>' reference.
   * @see #getRid()
   * @generated
   */
  void setRid(Definition value);

  /**
   * Returns the value of the '<em><b>Rids</b></em>' reference list.
   * The list contents are of type {@link org.xtext.plantuml.Definition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rids</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rids</em>' reference list.
   * @see org.xtext.plantuml.PlantumlPackage#getNote_Rids()
   * @model
   * @generated
   */
  EList<Definition> getRids();

  /**
   * Returns the value of the '<em><b>Lid</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lid</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lid</em>' reference.
   * @see #setLid(Definition)
   * @see org.xtext.plantuml.PlantumlPackage#getNote_Lid()
   * @model
   * @generated
   */
  Definition getLid();

  /**
   * Sets the value of the '{@link org.xtext.plantuml.Note#getLid <em>Lid</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lid</em>' reference.
   * @see #getLid()
   * @generated
   */
  void setLid(Definition value);

  /**
   * Returns the value of the '<em><b>Lids</b></em>' reference list.
   * The list contents are of type {@link org.xtext.plantuml.Definition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lids</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lids</em>' reference list.
   * @see org.xtext.plantuml.PlantumlPackage#getNote_Lids()
   * @model
   * @generated
   */
  EList<Definition> getLids();

  /**
   * Returns the value of the '<em><b>Oid</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Oid</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Oid</em>' reference.
   * @see #setOid(Definition)
   * @see org.xtext.plantuml.PlantumlPackage#getNote_Oid()
   * @model
   * @generated
   */
  Definition getOid();

  /**
   * Sets the value of the '{@link org.xtext.plantuml.Note#getOid <em>Oid</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Oid</em>' reference.
   * @see #getOid()
   * @generated
   */
  void setOid(Definition value);

  /**
   * Returns the value of the '<em><b>Oids</b></em>' reference list.
   * The list contents are of type {@link org.xtext.plantuml.Definition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Oids</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Oids</em>' reference list.
   * @see org.xtext.plantuml.PlantumlPackage#getNote_Oids()
   * @model
   * @generated
   */
  EList<Definition> getOids();

} // Note
