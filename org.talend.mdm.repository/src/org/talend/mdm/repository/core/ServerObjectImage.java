// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core;

import org.talend.commons.ui.runtime.image.IImage;

/**
 * DOC hbhong  it works for the common repository view.
 * <br/>
 *
 */
public enum ServerObjectImage implements IImage {
    MENU_ICON("/icons/menu.gif"), //$NON-NLS-1$
    ROLE_ICON("/icons/role.gif");//$NON-NLS-1$

    private String path;

    ServerObjectImage(String path) {
        this.path = path;
    }
    

    /**
     * Getter for path.
     * 
     * @return the path
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Getter for clazz.
     * 
     * @return the clazz
     */
    public Class getLocation() {
        return ServerObjectImage.class;
    }
}