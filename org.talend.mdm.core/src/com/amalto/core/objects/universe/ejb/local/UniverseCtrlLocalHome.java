/*
 * Generated by XDoclet - Do not edit!
 */
package com.amalto.core.objects.universe.ejb.local;

/**
 * Local home interface for UniverseCtrl.
 * @xdoclet-generated at 15-10-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface UniverseCtrlLocalHome
   extends javax.ejb.EJBLocalHome
{
   public static final String COMP_NAME="java:comp/env/ejb/UniverseCtrlLocal";
   public static final String JNDI_NAME="amalto/local/core/universectrl";

   public com.amalto.core.objects.universe.ejb.local.UniverseCtrlLocal create()
      throws javax.ejb.CreateException;

}
