/*
 * Generated by XDoclet - Do not edit!
 */
package com.amalto.core.objects.transformers.v2.ejb.remote;

/**
 * Remote interface for TransformerV2Ctrl.
 * @xdoclet-generated at 29-07-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface TransformerV2Ctrl
   extends javax.ejb.EJBObject
{
   /**
    * Creates or updates a Transformer
    * @throws XtentisException
    */
   public com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK putTransformer( com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJO transformer )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Get item
    * @throws XtentisException
    */
   public com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJO getTransformer( com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK pk )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Get a Transformer - no exception is thrown: returns null if not found
    * @throws XtentisException
    */
   public com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJO existsTransformer( com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK pk )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Remove an item
    * @throws XtentisException
    */
   public com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK removeTransformer( com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK pk )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Retrieve all Transformer PKS
    * @throws XtentisException
    */
   public java.util.Collection getTransformerPKs( java.lang.String regex )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Read an item and process it through a transformer. The content of the item is mapped to the {@link #DEFAULT_VARIABLE} variable
    * @param transformerV2POJOPK
    * @param itemPOJOPK
    * @return The pipeline after the transformer is run
    * @throws XtentisException
    */
   public com.amalto.core.objects.transformers.v2.util.TransformerContext extractThroughTransformer( com.amalto.core.objects.transformers.v2.ejb.TransformerV2POJOPK transformerV2POJOPK,com.amalto.core.ejb.ItemPOJOPK itemPOJOPK )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Executes theTransformer
    * @throws XtentisException
    */
   public com.amalto.core.objects.backgroundjob.ejb.BackgroundJobPOJOPK executeAsJob( com.amalto.core.objects.transformers.v2.util.TransformerContext context,com.amalto.core.objects.transformers.v2.util.TransformerCallBack callBack )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Executes the Transformer Asynchronously by specifying the universe<br/> The user must have the 'administration" role
    * @throws XtentisException
    */
   public void execute( com.amalto.core.objects.universe.ejb.UniversePOJO universe,com.amalto.core.objects.transformers.v2.util.TransformerContext context,com.amalto.core.objects.transformers.v2.util.TransformerCallBack callBack )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Executes the Transformer Asynchronously
    * @throws XtentisException
    */
   public void execute( com.amalto.core.objects.transformers.v2.util.TransformerContext context,com.amalto.core.objects.transformers.v2.util.TransformerCallBack callBack )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Executes the Transformer Synchronously The Typed Content passed is stored in the DEFAULT pipeline variable
    * @throws XtentisException
    */
   public void execute( com.amalto.core.objects.transformers.v2.util.TransformerContext context,com.amalto.core.objects.transformers.v2.util.TypedContent content,com.amalto.core.objects.transformers.v2.util.TransformerCallBack callBack )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Executes the Transformer and returns only when it is done
    * @throws XtentisException
    * @return the TransformerCOntext at the end of the execution
    */
   public com.amalto.core.objects.transformers.v2.util.TransformerContext executeUntilDone( com.amalto.core.objects.transformers.v2.util.TransformerContext context )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

   /**
    * Executes the Transformer and returns only when it is done The Typed Content passed is stored in the DEFAULT pipeline variable
    * @throws XtentisException
    */
   public com.amalto.core.objects.transformers.v2.util.TransformerContext executeUntilDone( com.amalto.core.objects.transformers.v2.util.TransformerContext context,com.amalto.core.objects.transformers.v2.util.TypedContent content )
      throws com.amalto.core.util.XtentisException, java.rmi.RemoteException;

}
