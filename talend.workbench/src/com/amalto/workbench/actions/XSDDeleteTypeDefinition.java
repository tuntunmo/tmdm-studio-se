package com.amalto.workbench.actions;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.providers.ISchemaContentProvider;
import com.amalto.workbench.utils.EImage;
import com.amalto.workbench.utils.ImageCache;
import com.amalto.workbench.utils.Util;

public class XSDDeleteTypeDefinition extends  UndoAction{
	
	private XSDComplexTypeDefinition xsdCmpexType;
	private XSDSimpleTypeDefinition xsdSimpType;
	public XSDDeleteTypeDefinition(DataModelMainPage page) {
		super(page);
		setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
		setText("Delete type definition");
		setToolTipText("Remove a type definition from the XSD Schema context");
		setDescription(getToolTipText());
	}
	
	public void run(Object toDel)
	{
		if (!(toDel instanceof XSDComplexTypeDefinition||toDel instanceof XSDSimpleTypeDefinition)) {
			return;
		}
		if(toDel instanceof XSDComplexTypeDefinition)
			xsdCmpexType = (XSDComplexTypeDefinition) toDel;
		else
			xsdSimpType = (XSDSimpleTypeDefinition) toDel;
		run();
	}
	
	public IStatus doAction() {
		IStructuredSelection selection = (IStructuredSelection) page.getTreeViewer().getSelection();
		XSDSchema schema = ((ISchemaContentProvider)page.getTreeViewer().getContentProvider()).getXsdSchema();
		
		if (selection.getFirstElement() instanceof XSDSimpleTypeDefinition) {
			XSDSimpleTypeDefinition simpleType = (XSDSimpleTypeDefinition)selection.getFirstElement();
			if(xsdSimpType!=null)
				simpleType = xsdSimpType;
			List<XSDElementDeclaration> list = Util.findElementsUsingType(schema, null, simpleType.getName());
			if(!list.isEmpty()){
				MessageDialog
				.openWarning(page.getSite().getShell(), "Warnning",
						"The Simple type definition : " + simpleType.getName() + " is being referred to by Elements");
				xsdSimpType = null;
				return Status.CANCEL_STATUS;
			}//iif(!list.isEmpty())
			schema.getContents().remove(simpleType);
		}//if (selection.getFirstElement()
		else{

			XSDComplexTypeDefinition complxType = (XSDComplexTypeDefinition)selection.getFirstElement();
			if (xsdCmpexType != null) {
				complxType = xsdCmpexType;
			}
			List<XSDElementDeclaration> list = Util.findElementsUsingType(schema, null, complxType.getName());
			if (!list.isEmpty())
			{
				MessageDialog
						.openWarning(page.getSite().getShell(), "Warnning",
								"The Complex type definition : " + complxType.getName() + " is being referred to by Elements");
				xsdCmpexType = null;
				return Status.CANCEL_STATUS;
			}
			schema.getContents().remove(complxType);
		}

		
		xsdCmpexType = null;
		page.refresh();
		page.markDirty();
		
		return Status.OK_STATUS;
	}
	
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	
    public void setXSDTODel(XSDComplexTypeDefinition elem) {
    	xsdCmpexType = elem;
	}
}
