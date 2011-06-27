/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.mdm.repository.model.mdmproperties.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.talend.core.model.properties.Item;
import org.talend.mdm.repository.model.mdmproperties.*;
import org.talend.mdm.repository.model.mdmproperties.MDMItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage
 * @generated
 */
public class MdmpropertiesAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static MdmpropertiesPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MdmpropertiesAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = MdmpropertiesPackage.eINSTANCE;
        }
    }

	/**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
	@Override
	public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

	/**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected MdmpropertiesSwitch<Adapter> modelSwitch =
		new MdmpropertiesSwitch<Adapter>() {
            @Override
            public Adapter caseMDMItem(MDMItem object) {
                return createMDMItemAdapter();
            }
            @Override
            public Adapter caseMDMServerDefItem(MDMServerDefItem object) {
                return createMDMServerDefItemAdapter();
            }
            @Override
            public Adapter caseMDMServerObjectItem(MDMServerObjectItem object) {
                return createMDMServerObjectItemAdapter();
            }
            @Override
            public Adapter caseWSMenuItem(WSMenuItem object) {
                return createWSMenuItemAdapter();
            }
            @Override
            public Adapter caseWSRoleItem(WSRoleItem object) {
                return createWSRoleItemAdapter();
            }
            @Override
            public Adapter caseContainerItem(ContainerItem object) {
                return createContainerItemAdapter();
            }
            @Override
            public Adapter caseItem(Item object) {
                return createItemAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

	/**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
	@Override
	public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


	/**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.MDMItem <em>MDM Item</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.MDMItem
     * @generated
     */
	public Adapter createMDMItemAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem <em>MDM Server Def Item</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem
     * @generated
     */
	public Adapter createMDMServerDefItemAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem <em>MDM Server Object Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem
     * @generated
     */
    public Adapter createMDMServerObjectItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WSMenuItem <em>WS Menu Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WSMenuItem
     * @generated
     */
    public Adapter createWSMenuItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.WSRoleItem <em>WS Role Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.WSRoleItem
     * @generated
     */
    public Adapter createWSRoleItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.mdm.repository.model.mdmproperties.ContainerItem <em>Container Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.mdm.repository.model.mdmproperties.ContainerItem
     * @generated
     */
    public Adapter createContainerItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.Item
     * @generated
     */
	public Adapter createItemAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
	public Adapter createEObjectAdapter() {
        return null;
    }

} //MdmpropertiesAdapterFactory