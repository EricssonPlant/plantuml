/**
 */
package org.xtext.plantuml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.plantuml.AltElse;
import org.xtext.plantuml.Else;
import org.xtext.plantuml.Instruction;
import org.xtext.plantuml.PlantumlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alt Else</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.plantuml.impl.AltElseImpl#getInstructions <em>Instructions</em>}</li>
 *   <li>{@link org.xtext.plantuml.impl.AltElseImpl#getElses <em>Elses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AltElseImpl extends InstructionImpl implements AltElse
{
  /**
   * The cached value of the '{@link #getInstructions() <em>Instructions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstructions()
   * @generated
   * @ordered
   */
  protected EList<Instruction> instructions;

  /**
   * The cached value of the '{@link #getElses() <em>Elses</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElses()
   * @generated
   * @ordered
   */
  protected EList<Else> elses;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AltElseImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return PlantumlPackage.Literals.ALT_ELSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Instruction> getInstructions()
  {
    if (instructions == null)
    {
      instructions = new EObjectContainmentEList<Instruction>(Instruction.class, this, PlantumlPackage.ALT_ELSE__INSTRUCTIONS);
    }
    return instructions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Else> getElses()
  {
    if (elses == null)
    {
      elses = new EObjectContainmentEList<Else>(Else.class, this, PlantumlPackage.ALT_ELSE__ELSES);
    }
    return elses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case PlantumlPackage.ALT_ELSE__INSTRUCTIONS:
        return ((InternalEList<?>)getInstructions()).basicRemove(otherEnd, msgs);
      case PlantumlPackage.ALT_ELSE__ELSES:
        return ((InternalEList<?>)getElses()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case PlantumlPackage.ALT_ELSE__INSTRUCTIONS:
        return getInstructions();
      case PlantumlPackage.ALT_ELSE__ELSES:
        return getElses();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PlantumlPackage.ALT_ELSE__INSTRUCTIONS:
        getInstructions().clear();
        getInstructions().addAll((Collection<? extends Instruction>)newValue);
        return;
      case PlantumlPackage.ALT_ELSE__ELSES:
        getElses().clear();
        getElses().addAll((Collection<? extends Else>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case PlantumlPackage.ALT_ELSE__INSTRUCTIONS:
        getInstructions().clear();
        return;
      case PlantumlPackage.ALT_ELSE__ELSES:
        getElses().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case PlantumlPackage.ALT_ELSE__INSTRUCTIONS:
        return instructions != null && !instructions.isEmpty();
      case PlantumlPackage.ALT_ELSE__ELSES:
        return elses != null && !elses.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AltElseImpl
