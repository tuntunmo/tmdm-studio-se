
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSGetRoutingOrderV2PKsByCriteria complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSGetRoutingOrderV2PKsByCriteria">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsSearchCriteria" type="{urn-com-amalto-xtentis-webservice}WSRoutingOrderV2SearchCriteria"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSGetRoutingOrderV2PKsByCriteria", propOrder = {
    "wsSearchCriteria"
})
public class WSGetRoutingOrderV2PKsByCriteria {

    @XmlElement(required = true)
    protected WSRoutingOrderV2SearchCriteria wsSearchCriteria;

    /**
     * Default no-arg constructor
     * 
     */
    public WSGetRoutingOrderV2PKsByCriteria() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSGetRoutingOrderV2PKsByCriteria(final WSRoutingOrderV2SearchCriteria wsSearchCriteria) {
        this.wsSearchCriteria = wsSearchCriteria;
    }

    /**
     * Gets the value of the wsSearchCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link WSRoutingOrderV2SearchCriteria }
     *     
     */
    public WSRoutingOrderV2SearchCriteria getWsSearchCriteria() {
        return wsSearchCriteria;
    }

    /**
     * Sets the value of the wsSearchCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSRoutingOrderV2SearchCriteria }
     *     
     */
    public void setWsSearchCriteria(WSRoutingOrderV2SearchCriteria value) {
        this.wsSearchCriteria = value;
    }

}
