/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties;

import org.talend.core.model.repository.ERepositoryObjectType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getRepObjType <em>Rep Obj Type</em>}</li>
 *   <li>{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getContainerItem()
 * @model
 * @generated
 */
public interface ContainerItem extends MDMItem {
    /**
     * Returns the value of the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label</em>' attribute.
     * @see #setLabel(String)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getContainerItem_Label()
     * @model
     * @generated
     */
    String getLabel();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel(String value);

    /**
     * Returns the value of the '<em><b>Rep Obj Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rep Obj Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rep Obj Type</em>' attribute.
     * @see #setRepObjType(ERepositoryObjectType)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getContainerItem_RepObjType()
     * @model dataType="org.talend.mdm.repository.model.mdmproperties.ERepositoryObjectType"
     * @generated
     */
    ERepositoryObjectType getRepObjType();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getRepObjType <em>Rep Obj Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rep Obj Type</em>' attribute.
     * @see #getRepObjType()
     * @generated
     */
    void setRepObjType(ERepositoryObjectType value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.talend.mdm.repository.model.mdmproperties.ContainerType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see org.talend.mdm.repository.model.mdmproperties.ContainerType
     * @see #setType(ContainerType)
     * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage#getContainerItem_Type()
     * @model
     * @generated
     */
    ContainerType getType();

    /**
     * Sets the value of the '{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see org.talend.mdm.repository.model.mdmproperties.ContainerType
     * @see #getType()
     * @generated
     */
    void setType(ContainerType value);

} // ContainerItem