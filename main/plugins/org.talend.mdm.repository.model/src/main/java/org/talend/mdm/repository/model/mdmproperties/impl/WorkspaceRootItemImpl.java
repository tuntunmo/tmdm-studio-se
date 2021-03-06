/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.talend.core.model.properties.FolderItem;
import org.talend.core.model.properties.FolderType;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.PropertiesPackage;

import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;
import org.talend.mdm.repository.model.mdmproperties.WorkspaceRootItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workspace Root Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WorkspaceRootItemImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WorkspaceRootItemImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.impl.WorkspaceRootItemImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkspaceRootItemImpl extends MDMItemImpl implements WorkspaceRootItem {
    /**
     * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChildren()
     * @generated
     * @ordered
     */
    protected EList children;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final FolderType TYPE_EDEFAULT = FolderType.FOLDER_LITERAL;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected FolderType type = TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected static final String LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected String label = LABEL_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WorkspaceRootItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MdmpropertiesPackage.Literals.WORKSPACE_ROOT_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getChildren() {
        if (children == null) {
            children = new EObjectResolvingEList<Item>(Item.class, this, MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__CHILDREN);
        }
        return children;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FolderType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(FolderType newType) {
        FolderType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLabel() {
        return label;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabel(String newLabel) {
        String oldLabel = label;
        label = newLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__CHILDREN:
                return getChildren();
            case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__TYPE:
                return getType();
            case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__LABEL:
                return getLabel();
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
            case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__CHILDREN:
                getChildren().clear();
                getChildren().addAll((Collection<? extends Item>)newValue);
                return;
            case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__TYPE:
                setType((FolderType)newValue);
                return;
            case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__LABEL:
                setLabel((String)newValue);
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
            case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__CHILDREN:
                getChildren().clear();
                return;
            case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__TYPE:
                setType(TYPE_EDEFAULT);
                return;
            case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__LABEL:
                setLabel(LABEL_EDEFAULT);
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
            case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__CHILDREN:
                return children != null && !children.isEmpty();
            case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__TYPE:
                return type != TYPE_EDEFAULT;
            case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == FolderItem.class) {
            switch (derivedFeatureID) {
                case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__CHILDREN: return PropertiesPackage.FOLDER_ITEM__CHILDREN;
                case MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__TYPE: return PropertiesPackage.FOLDER_ITEM__TYPE;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == FolderItem.class) {
            switch (baseFeatureID) {
                case PropertiesPackage.FOLDER_ITEM__CHILDREN: return MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__CHILDREN;
                case PropertiesPackage.FOLDER_ITEM__TYPE: return MdmpropertiesPackage.WORKSPACE_ROOT_ITEM__TYPE;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (type: ");
        result.append(type);
        result.append(", label: ");
        result.append(label);
        result.append(')');
        return result.toString();
    }

} //WorkspaceRootItemImpl
