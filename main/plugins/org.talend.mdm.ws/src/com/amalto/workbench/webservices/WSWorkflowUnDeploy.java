
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSWorkflowUnDeploy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSWorkflowUnDeploy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="uuid" type="{urn-com-amalto-xtentis-webservice}WSWorkflowProcessDefinitionUUID"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSWorkflowUnDeploy", propOrder = {

})
public class WSWorkflowUnDeploy {

    @XmlElement(required = true)
    protected WSWorkflowProcessDefinitionUUID uuid;

    /**
     * Default no-arg constructor
     * 
     */
    public WSWorkflowUnDeploy() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSWorkflowUnDeploy(final WSWorkflowProcessDefinitionUUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Gets the value of the uuid property.
     * 
     * @return
     *     possible object is
     *     {@link WSWorkflowProcessDefinitionUUID }
     *     
     */
    public WSWorkflowProcessDefinitionUUID getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSWorkflowProcessDefinitionUUID }
     *     
     */
    public void setUuid(WSWorkflowProcessDefinitionUUID value) {
        this.uuid = value;
    }

}
