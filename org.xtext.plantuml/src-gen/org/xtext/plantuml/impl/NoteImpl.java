/**
 */
package org.xtext.plantuml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.xtext.plantuml.Definition;
import org.xtext.plantuml.Note;
import org.xtext.plantuml.PlantumlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Note</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.plantuml.impl.NoteImpl#getRid <em>Rid</em>}</li>
 *   <li>{@link org.xtext.plantuml.impl.NoteImpl#getRids <em>Rids</em>}</li>
 *   <li>{@link org.xtext.plantuml.impl.NoteImpl#getLid <em>Lid</em>}</li>
 *   <li>{@link org.xtext.plantuml.impl.NoteImpl#getLids <em>Lids</em>}</li>
 *   <li>{@link org.xtext.plantuml.impl.NoteImpl#getOid <em>Oid</em>}</li>
 *   <li>{@link org.xtext.plantuml.impl.NoteImpl#getOids <em>Oids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NoteImpl extends InstructionImpl implements Note
{
  /**
   * The cached value of the '{@link #getRid() <em>Rid</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRid()
   * @generated
   * @ordered
   */
  protected Definition rid;

  /**
   * The cached value of the '{@link #getRids() <em>Rids</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRids()
   * @generated
   * @ordered
   */
  protected EList<Definition> rids;

  /**
   * The cached value of the '{@link #getLid() <em>Lid</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLid()
   * @generated
   * @ordered
   */
  protected Definition lid;

  /**
   * The cached value of the '{@link #getLids() <em>Lids</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLids()
   * @generated
   * @ordered
   */
  protected EList<Definition> lids;

  /**
   * The cached value of the '{@link #getOid() <em>Oid</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOid()
   * @generated
   * @ordered
   */
  protected Definition oid;

  /**
   * The cached value of the '{@link #getOids() <em>Oids</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOids()
   * @generated
   * @ordered
   */
  protected EList<Definition> oids;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NoteImpl()
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
    return PlantumlPackage.Literals.NOTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Definition getRid()
  {
    if (rid != null && rid.eIsProxy())
    {
      InternalEObject oldRid = (InternalEObject)rid;
      rid = (Definition)eResolveProxy(oldRid);
      if (rid != oldRid)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PlantumlPackage.NOTE__RID, oldRid, rid));
      }
    }
    return rid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Definition basicGetRid()
  {
    return rid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRid(Definition newRid)
  {
    Definition oldRid = rid;
    rid = newRid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PlantumlPackage.NOTE__RID, oldRid, rid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Definition> getRids()
  {
    if (rids == null)
    {
      rids = new EObjectResolvingEList<Definition>(Definition.class, this, PlantumlPackage.NOTE__RIDS);
    }
    return rids;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Definition getLid()
  {
    if (lid != null && lid.eIsProxy())
    {
      InternalEObject oldLid = (InternalEObject)lid;
      lid = (Definition)eResolveProxy(oldLid);
      if (lid != oldLid)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PlantumlPackage.NOTE__LID, oldLid, lid));
      }
    }
    return lid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Definition basicGetLid()
  {
    return lid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLid(Definition newLid)
  {
    Definition oldLid = lid;
    lid = newLid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PlantumlPackage.NOTE__LID, oldLid, lid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Definition> getLids()
  {
    if (lids == null)
    {
      lids = new EObjectResolvingEList<Definition>(Definition.class, this, PlantumlPackage.NOTE__LIDS);
    }
    return lids;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Definition getOid()
  {
    if (oid != null && oid.eIsProxy())
    {
      InternalEObject oldOid = (InternalEObject)oid;
      oid = (Definition)eResolveProxy(oldOid);
      if (oid != oldOid)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PlantumlPackage.NOTE__OID, oldOid, oid));
      }
    }
    return oid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Definition basicGetOid()
  {
    return oid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOid(Definition newOid)
  {
    Definition oldOid = oid;
    oid = newOid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PlantumlPackage.NOTE__OID, oldOid, oid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Definition> getOids()
  {
    if (oids == null)
    {
      oids = new EObjectResolvingEList<Definition>(Definition.class, this, PlantumlPackage.NOTE__OIDS);
    }
    return oids;
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
      case PlantumlPackage.NOTE__RID:
        if (resolve) return getRid();
        return basicGetRid();
      case PlantumlPackage.NOTE__RIDS:
        return getRids();
      case PlantumlPackage.NOTE__LID:
        if (resolve) return getLid();
        return basicGetLid();
      case PlantumlPackage.NOTE__LIDS:
        return getLids();
      case PlantumlPackage.NOTE__OID:
        if (resolve) return getOid();
        return basicGetOid();
      case PlantumlPackage.NOTE__OIDS:
        return getOids();
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
      case PlantumlPackage.NOTE__RID:
        setRid((Definition)newValue);
        return;
      case PlantumlPackage.NOTE__RIDS:
        getRids().clear();
        getRids().addAll((Collection<? extends Definition>)newValue);
        return;
      case PlantumlPackage.NOTE__LID:
        setLid((Definition)newValue);
        return;
      case PlantumlPackage.NOTE__LIDS:
        getLids().clear();
        getLids().addAll((Collection<? extends Definition>)newValue);
        return;
      case PlantumlPackage.NOTE__OID:
        setOid((Definition)newValue);
        return;
      case PlantumlPackage.NOTE__OIDS:
        getOids().clear();
        getOids().addAll((Collection<? extends Definition>)newValue);
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
      case PlantumlPackage.NOTE__RID:
        setRid((Definition)null);
        return;
      case PlantumlPackage.NOTE__RIDS:
        getRids().clear();
        return;
      case PlantumlPackage.NOTE__LID:
        setLid((Definition)null);
        return;
      case PlantumlPackage.NOTE__LIDS:
        getLids().clear();
        return;
      case PlantumlPackage.NOTE__OID:
        setOid((Definition)null);
        return;
      case PlantumlPackage.NOTE__OIDS:
        getOids().clear();
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
      case PlantumlPackage.NOTE__RID:
        return rid != null;
      case PlantumlPackage.NOTE__RIDS:
        return rids != null && !rids.isEmpty();
      case PlantumlPackage.NOTE__LID:
        return lid != null;
      case PlantumlPackage.NOTE__LIDS:
        return lids != null && !lids.isEmpty();
      case PlantumlPackage.NOTE__OID:
        return oid != null;
      case PlantumlPackage.NOTE__OIDS:
        return oids != null && !oids.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //NoteImpl
