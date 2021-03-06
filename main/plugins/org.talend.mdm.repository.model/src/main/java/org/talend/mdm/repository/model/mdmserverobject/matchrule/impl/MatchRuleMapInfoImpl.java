/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmserverobject.matchrule.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.mdm.repository.model.mdmserverobject.matchrule.EntityMapInfo;
import org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRuleMapInfo;
import org.talend.mdm.repository.model.mdmserverobject.matchrule.MatchRulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.MatchRuleMapInfoImpl#getEntityMapInfos <em>Entity Map Infos</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmserverobject.matchrule.impl.MatchRuleMapInfoImpl#getModelName <em>Model Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatchRuleMapInfoImpl extends EObjectImpl implements MatchRuleMapInfo {
    /**
     * The cached value of the '{@link #getEntityMapInfos() <em>Entity Map Infos</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntityMapInfos()
     * @generated
     * @ordered
     */
    protected EList<EntityMapInfo> entityMapInfos;

    /**
     * The default value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModelName()
     * @generated
     * @ordered
     */
    protected static final String MODEL_NAME_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModelName()
     * @generated
     * @ordered
     */
    protected String modelName = MODEL_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MatchRuleMapInfoImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MatchRulePackage.Literals.MATCH_RULE_MAP_INFO;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<EntityMapInfo> getEntityMapInfos() {
        if (entityMapInfos == null) {
            entityMapInfos = new EObjectContainmentWithInverseEList<EntityMapInfo>(EntityMapInfo.class, this, MatchRulePackage.MATCH_RULE_MAP_INFO__ENTITY_MAP_INFOS, MatchRulePackage.ENTITY_MAP_INFO__PARENT);
        }
        return entityMapInfos;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setModelName(String newModelName) {
        String oldModelName = modelName;
        modelName = newModelName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MatchRulePackage.MATCH_RULE_MAP_INFO__MODEL_NAME, oldModelName, modelName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MatchRulePackage.MATCH_RULE_MAP_INFO__ENTITY_MAP_INFOS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEntityMapInfos()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MatchRulePackage.MATCH_RULE_MAP_INFO__ENTITY_MAP_INFOS:
                return ((InternalEList<?>)getEntityMapInfos()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MatchRulePackage.MATCH_RULE_MAP_INFO__ENTITY_MAP_INFOS:
                return getEntityMapInfos();
            case MatchRulePackage.MATCH_RULE_MAP_INFO__MODEL_NAME:
                return getModelName();
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
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MatchRulePackage.MATCH_RULE_MAP_INFO__ENTITY_MAP_INFOS:
                getEntityMapInfos().clear();
                getEntityMapInfos().addAll((Collection<? extends EntityMapInfo>)newValue);
                return;
            case MatchRulePackage.MATCH_RULE_MAP_INFO__MODEL_NAME:
                setModelName((String)newValue);
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
    public void eUnset(int featureID) {
        switch (featureID) {
            case MatchRulePackage.MATCH_RULE_MAP_INFO__ENTITY_MAP_INFOS:
                getEntityMapInfos().clear();
                return;
            case MatchRulePackage.MATCH_RULE_MAP_INFO__MODEL_NAME:
                setModelName(MODEL_NAME_EDEFAULT);
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
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case MatchRulePackage.MATCH_RULE_MAP_INFO__ENTITY_MAP_INFOS:
                return entityMapInfos != null && !entityMapInfos.isEmpty();
            case MatchRulePackage.MATCH_RULE_MAP_INFO__MODEL_NAME:
                return MODEL_NAME_EDEFAULT == null ? modelName != null : !MODEL_NAME_EDEFAULT.equals(modelName);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (modelName: ");
        result.append(modelName);
        result.append(')');
        return result.toString();
    }

} //MatchRuleMapInfoImpl
