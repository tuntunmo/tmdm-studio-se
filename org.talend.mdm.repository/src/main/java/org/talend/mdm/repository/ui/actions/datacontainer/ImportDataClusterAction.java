// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.actions.datacontainer;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.talend.mdm.repository.core.service.DataClusterService;
import org.talend.mdm.repository.core.service.DataClusterService.ImportContentProcess;
import org.talend.mdm.repository.core.service.RepositoryWebServiceAdapter;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.ui.dialogs.message.MultiStatusDialog;
import org.talend.mdm.repository.utils.IOUtil;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class ImportDataClusterAction extends AbstractDataClusterAction {

    private static Logger log = Logger.getLogger(ImportDataClusterAction.class);

    /**
     * DOC hbhong ImportDataClusterAction constructor comment.
     * 
     * @param text
     */
    public ImportDataClusterAction() {
        super(Messages.ImportDataClusterAction_title);
        setImageDescriptor(ImageCache.getImage(EImage.IMPORT.getPath()));
    }

    protected void doRun() {
        FileDialog fd = new FileDialog(getShell(), SWT.OPEN);
        fd.setFilterExtensions(new String[] { "*.zip" }); //$NON-NLS-1$
        String fPath = fd.open();
        if (fPath != null) {
            DataClusterService dataClusterService = DataClusterService.getIntance();
            File tempFolder = IOUtil.getTempFolder();
            String tempFolderPath = tempFolder.getAbsolutePath();
            dataClusterService.unZipFile(fPath, tempFolderPath);
            String dName = dataClusterService.loadIndexFile(tempFolderPath);
            if (dName == null) {
                MessageDialog.openError(getShell(), Messages.Common_Error, Messages.ImportDataClusterAction_errorFormat);
                return;
            }
            tempFolderPath += File.separator + dName;
            //
            SelectServerDefDialog dialog = new SelectServerDefDialog(getShell());
            if (dialog.open() == IDialogConstants.OK_ID) {
                MDMServerDef serverDef = dialog.getSelectedServerDef().getDecryptedServerDef();
                try {

                    XtentisPort port = RepositoryWebServiceAdapter.getXtentisPort(serverDef);

                    if (!dataClusterService.isExistDataCluster(port, dName)) {
                        if (MessageDialog.openQuestion(getShell(), Messages.ImportDataClusterAction_createDataClusterTitle,
                                Messages.bind(Messages.ImportDataClusterAction_createConfirm, dName))) {
                            dataClusterService.createDataCluster(port, dName);
                        } else {
                            return;
                        }
                    }

                    ImportContentProcess process = dataClusterService
                            .getNewImportContentProcess(serverDef, dName,
                            tempFolderPath);
                    try {
                        IProgressService progressService = PlatformUI.getWorkbench().getProgressService();
                        progressService.run(true, true, process);

                    } catch (InvocationTargetException e) {
                        log.error(e.getMessage(), e);
                    } catch (InterruptedException e) {
                    }
                    MultiStatus multiStatus = process.getImportStatus();
                    if (multiStatus != null && multiStatus.getChildren().length > 0) {
                        MultiStatusDialog statusDialog = new MultiStatusDialog(getShell(), multiStatus.getMessage(), multiStatus);
                        statusDialog.open();
                    } else {
                        // show success info
                        MessageDialog.openInformation(getShell(), Messages.ImportDataClusterAction_importTitle,
                                Messages.bind(Messages.ImportDataClusterAction_successImport, dName));
                    }
                } catch (XtentisException e) {
                    log.error(e.getMessage(), e);
                } finally {
                    IOUtil.cleanFolder(tempFolder);
                }

            }
        }
    }

}
