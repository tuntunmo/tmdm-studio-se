package com.amalto.workbench.detailtabs.sections.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xsd.XSDIdentityConstraintCategory;

import com.amalto.workbench.detailtabs.sections.model.KeyWrapper;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

public class KeyWrapperLabelProvider implements ILabelProvider {

    public Image getImage(Object element) {

        if (element instanceof KeyWrapper) {
            if (((KeyWrapper) element).getType().equals(XSDIdentityConstraintCategory.UNIQUE_LITERAL))
                return ImageCache.getCreatedImage(EImage.KEYS.getPath());
            return ImageCache.getCreatedImage(EImage.PRIMARYKEY.getPath());
        }

        return null;
    }

    public String getText(Object element) {

        if (element instanceof KeyWrapper)
            return ((KeyWrapper) element).getName();

        return "";
    }

    public void addListener(ILabelProviderListener listener) {
    }

    public void dispose() {
    }

    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

    public void removeListener(ILabelProviderListener listener) {
    }

}
