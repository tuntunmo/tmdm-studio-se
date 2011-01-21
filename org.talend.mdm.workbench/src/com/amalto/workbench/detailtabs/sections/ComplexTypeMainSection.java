package com.amalto.workbench.detailtabs.sections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xsd.XSDComplexTypeDefinition;

import com.amalto.workbench.detailtabs.sections.composites.ComplexTypeConfigComposite;
import com.amalto.workbench.detailtabs.sections.model.ISubmittable;
import com.amalto.workbench.detailtabs.sections.model.complextype.ComplexTypeWrapper;

public class ComplexTypeMainSection extends CommitBarListenerSection<XSDComplexTypeDefinition> {

    private ComplexTypeConfigComposite compComplexType;

    private XSDComplexTypeDefinition complexType;

    @Override
    protected ISubmittable getSubmittedObj() {
        return new ComplexTypeWrapper(complexType, compComplexType.getTypeName(), compComplexType.getExtends(),
                compComplexType.getGroupTypeCompositor());
    }

    @Override
    protected XSDComplexTypeDefinition getEditedObj() {
        return complexType;
    }

    @Override
    protected void initUIContents(XSDComplexTypeDefinition editedObj) {

        this.complexType = editedObj;

        compComplexType.setComplexType(complexType);
    }

    @Override
    protected String getSectionTitle() {
        return "Main";
    }

    @Override
    protected void createControlsInSection(Composite compSectionClient) {
        compComplexType = new ComplexTypeConfigComposite(compSectionClient, SWT.NONE);
    }

}