package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;

import com.amalto.workbench.dialogs.ComplexTypeInputDialog;
import com.amalto.workbench.dialogs.SimpleTypeInputDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.utils.EImage;
import com.amalto.workbench.utils.ImageCache;

public class XSDNewSimpleTypeDefinition extends UndoAction implements SelectionListener {

	private SimpleTypeInputDialog dialog;
	String typeName = null;
	boolean builtIn = false;
	public XSDNewSimpleTypeDefinition(DataModelMainPage page) {
		super(page);
		setImageDescriptor(ImageCache.getImage(EImage.ADD_OBJ.getPath()));
		setText("Create a Simpe Type");
		setToolTipText("Create a new simple Type");
		setDescription(getToolTipText());
		// TODO Auto-generated constructor stub
	}

	public IStatus doAction() {
		
		List<String> customTypes = new ArrayList<String>();
		List<String> builtInTypes = new ArrayList<String>();
		
		for (Iterator iter =  schema.getTypeDefinitions().iterator(); iter.hasNext(); ) {
			XSDTypeDefinition type = (XSDTypeDefinition) iter.next();
			if (type instanceof XSDSimpleTypeDefinition)
				customTypes.add(type.getName());
		}
		
//		ArrayList builtInTypes = new ArrayList();
		for (Iterator iter =  schema.getSchemaForSchema().getTypeDefinitions().iterator(); iter.hasNext(); ) {
			XSDTypeDefinition type = (XSDTypeDefinition) iter.next();
			if (type instanceof XSDSimpleTypeDefinition)
				builtInTypes.add(type.getName());
		}
		

		dialog = new SimpleTypeInputDialog(this, page.getSite().getShell(),"New Simple Type", customTypes,builtInTypes);
		
		dialog.setBlockOnOpen(true);
		int ret = dialog.open();
		if (ret == Dialog.CANCEL) {
			return Status.CANCEL_STATUS;
		}
		
		
		
		
		
    	XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();
    	XSDSimpleTypeDefinition typedef = factory.createXSDSimpleTypeDefinition();
    	//set new one
		if (builtIn) {
//			typedef.setBaseTypeDefinition(schema.resolveSimpleTypeDefinition(schema.getSchemaForSchemaNamespace(), typeName));
		} else {
			//check if simple type definition already exists
			XSDSimpleTypeDefinition std = schema.resolveSimpleTypeDefinition(typeName);
			if (!schema.getTypeDefinitions().contains(std)) {
				std.setBaseTypeDefinition(schema.resolveSimpleTypeDefinition(schema.getSchemaForSchemaNamespace(), "string"));
				schema.getContents().add(std);
			}
			typedef.setBaseTypeDefinition(std);
		}
		
		//remove current facets
		typedef.getFacetContents().removeAll(typedef.getFacetContents());
		
		typedef.updateElement();
		
//		XSDModelGroup group = factory.createXSDModelGroup();
//		XSDParticle subParticle = null;
//		XSDElementDeclaration subElement = null;
//		
//		subElement = factory.createXSDElementDeclaration();
//		subElement.setName("subelement");
//		subElement.setTypeDefinition(schema.resolveSimpleTypeDefinition(schema.getSchemaForSchemaNamespace(), "string"));
//		
//		subParticle = factory.createXSDParticle();
//		subParticle.setMinOccurs(1);
//		subParticle.setMaxOccurs(1);
//		subParticle.setContent(subElement);
//		subParticle.updateElement();
		
//		if (isChoice)
//			group.setCompositor(XSDCompositor.CHOICE_LITERAL);
//		else if (isAll)
//			group.setCompositor(XSDCompositor.ALL_LITERAL);
//		else
//			group.setCompositor(XSDCompositor.SEQUENCE_LITERAL);
//		group.getContents().add(0,subParticle);
//		group.updateElement();
   			
//		XSDComplexTypeDefinition complexType = factory.createXSDComplexTypeDefinition();
//		//complexType.setDerivationMethod(XSDDerivationMethod.EXTENSION_LITERAL);
//		complexType.setName(typeName);
//		schema.getContents().add(complexType);
//		
//		complexType.updateElement();
//		

		//add the group
//		XSDParticle groupParticle  = factory.createXSDParticle();
//		groupParticle.setMinOccurs(1);
//		groupParticle.setMaxOccurs(1);
//		groupParticle.setContent(group);
//		groupParticle.updateElement();
		
//		complexType.setContent(groupParticle);       			
//		complexType.updateElement();
		
		page.refresh();
		page.markDirty();
		return Status.OK_STATUS;
	}
	
	public void widgetSelected(SelectionEvent e) {
		if (dialog.getReturnCode()==-1) return;
		typeName = dialog.getTypeName();
		builtIn = dialog.isBuiltIn();
		
		//if built in, check that the type actually exists
		if (builtIn) {
			boolean found =false;
            for (Iterator iter =  schema.getSchemaForSchema().getTypeDefinitions().iterator(); iter.hasNext(); ) {
				XSDTypeDefinition type = (XSDTypeDefinition) iter.next();
				if (type instanceof XSDSimpleTypeDefinition)
					if (type.getName().equals(typeName)) {
						found = true;
						break;
					}
            }
            if (!found) {
    			MessageDialog.openError(
    					page.getSite().getShell(),
    					"Error", 
    					"The built-in type "+typeName+" does not exist"
    			);            	
				return;
			}			
		}
		dialog.close();		
	}
		
	
	public void widgetDefaultSelected(SelectionEvent e) {

	}
	
	private boolean validateType()
	{
		if (! "".equals(typeName)) {
			EList list = schema.getTypeDefinitions();
			for (Iterator iter = list.iterator(); iter.hasNext(); ) {
				XSDTypeDefinition td = (XSDTypeDefinition) iter.next();
				if (td.getName().equals(typeName)) {
					if (td instanceof XSDSimpleTypeDefinition) {
						MessageDialog.openError(
								page.getSite().getShell(),
								"Error", 
								"This type \""+typeName+"\" already exists as a Simple Type"
						);
						return false;
					}
				}
			}//for
		}
		else
		{
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"Please enter the Simple Type name"
			);
			return false;
		}
		
		return true;
	}
}
