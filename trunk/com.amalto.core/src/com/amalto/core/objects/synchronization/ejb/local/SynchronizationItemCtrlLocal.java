/*
 * Generated by XDoclet - Do not edit!
 */
package com.amalto.core.objects.synchronization.ejb.local;

/**
 * Local interface for SynchronizationItemCtrl.
 * @xdoclet-generated at 29-07-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface SynchronizationItemCtrlLocal
   extends javax.ejb.EJBLocalObject
{
   /**
    * Creates or updates a SynchronizationItem
    * @throws XtentisException
    */
   public com.amalto.core.objects.synchronization.ejb.SynchronizationItemPOJOPK putSynchronizationItem( com.amalto.core.objects.synchronization.ejb.SynchronizationItemPOJO synchronizationItem ) throws com.amalto.core.util.XtentisException;

   /**
    * Get SynchronizationItem
    * @throws XtentisException
    */
   public com.amalto.core.objects.synchronization.ejb.SynchronizationItemPOJO getSynchronizationItem( com.amalto.core.objects.synchronization.ejb.SynchronizationItemPOJOPK pk ) throws com.amalto.core.util.XtentisException;

   /**
    * Get a SynchronizationItem - no exception is thrown: returns null if not found
    * @throws XtentisException
    */
   public com.amalto.core.objects.synchronization.ejb.SynchronizationItemPOJO existsSynchronizationItem( com.amalto.core.objects.synchronization.ejb.SynchronizationItemPOJOPK pk ) throws com.amalto.core.util.XtentisException;

   /**
    * Remove an item
    * @throws XtentisException
    */
   public com.amalto.core.objects.synchronization.ejb.SynchronizationItemPOJOPK removeSynchronizationItem( com.amalto.core.objects.synchronization.ejb.SynchronizationItemPOJOPK pk ) throws com.amalto.core.util.XtentisException;

   /**
    * Retrieve all SynchronizationItem PKS
    * @throws XtentisException
    */
   public java.util.Collection getSynchronizationItemPKs( java.lang.String regex ) throws com.amalto.core.util.XtentisException;

   /**
    * Get a SynchronizationItem - no exception is thrown: returns null if not found
    * @throws XtentisException
    */
   public com.amalto.core.objects.synchronization.ejb.SynchronizationItemPOJO resolveSynchronization( com.amalto.core.objects.synchronization.ejb.SynchronizationItemPOJOPK pk,java.lang.String resolvedProjection ) throws com.amalto.core.util.XtentisException;

}
