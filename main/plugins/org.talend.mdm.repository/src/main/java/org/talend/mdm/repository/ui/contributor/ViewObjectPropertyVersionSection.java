package org.talend.mdm.repository.ui.contributor;

import java.util.Iterator;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.talend.core.model.repository.IRepositoryViewObject;


public class ViewObjectPropertyVersionSection extends AbstractPropertySection {

    IRepositoryViewObject obj;

    private ViewObjectPropertyVersionComposite composite;

    public ViewObjectPropertyVersionSection() {
    }


    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);

        Composite compTop = getWidgetFactory().createComposite(parent);
        compTop.setLayout(new FormLayout());
        composite = new ViewObjectPropertyVersionComposite(compTop, SWT.NULL);
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection sel = (IStructuredSelection) selection;
            Iterator it = sel.iterator();
            while (it.hasNext()) {
                Object input = it.next();
                if (input instanceof IRepositoryViewObject) {
                    obj = (IRepositoryViewObject) input;
                    composite.setRepositoryObject(obj);
                    composite.setData();
                    composite.refresh();
                }
            }
        }
    }
}
