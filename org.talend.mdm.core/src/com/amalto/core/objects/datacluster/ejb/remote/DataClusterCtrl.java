/*
 * Generated by XDoclet - Do not edit!
 */
package com.amalto.core.objects.datacluster.ejb.remote;

/**
 * Remote interface for DataClusterCtrl.
 * @xdoclet-generated at 15-10-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface DataClusterCtrl
   extends javax.ejb.EJBObject
{
   /**
    * Creates or updates a datacluster
    * @throwsXtentisxception 
    */
   public com.amalto.core.objects.datacluster.ejb.DataClusterPOJOPK putDataCluster( com.amalto.core.objects.datacluster.ejb.DataClusterPOJO dataCluster )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Get datacluster
    * @throws XtentisException
    */
   public com.amalto.core.objects.datacluster.ejb.DataClusterPOJO getDataCluster( com.amalto.core.objects.datacluster.ejb.DataClusterPOJOPK pk )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Get a DataCluster - no exception is thrown: returns null if not found
    * @throws XtentisException
    */
   public com.amalto.core.objects.datacluster.ejb.DataClusterPOJO existsDataCluster( com.amalto.core.objects.datacluster.ejb.DataClusterPOJOPK pk )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Remove a Data Cluster The physical remove is performed on a separate Thred
    * @throws XtentisException
    */
   public com.amalto.core.objects.datacluster.ejb.DataClusterPOJOPK removeDataCluster( com.amalto.core.objects.datacluster.ejb.DataClusterPOJOPK pk )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Retrieve all DataCluster PKs
    * @throws XtentisException
    */
   public java.util.Collection getDataClusterPKs( java.lang.String regex )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Add this string words to the vocabulary - ignore xml tags
    * @throws XtentisException
    */
   public int addToVocabulary( com.amalto.core.objects.datacluster.ejb.DataClusterPOJOPK pk,java.lang.String string )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Spell checks a sentence and return possible spellings
    * @throws XtentisException
    */
   public java.util.Collection spellCheck( com.amalto.core.objects.datacluster.ejb.DataClusterPOJOPK dcpk,java.lang.String sentence,int treshold,boolean ignoreNonExistantWords )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

}
