
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSExistsRoutingOrderV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSExistsRoutingOrderV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsRoutingOrderPK" type="{urn-com-amalto-xtentis-webservice}WSRoutingOrderV2PK"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSExistsRoutingOrderV2", propOrder = {
    "wsRoutingOrderPK"
})
public class WSExistsRoutingOrderV2 {

    @XmlElement(required = true)
    protected WSRoutingOrderV2PK wsRoutingOrderPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WSExistsRoutingOrderV2() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSExistsRoutingOrderV2(final WSRoutingOrderV2PK wsRoutingOrderPK) {
        this.wsRoutingOrderPK = wsRoutingOrderPK;
    }

    /**
     * Gets the value of the wsRoutingOrderPK property.
     * 
     * @return
     *     possible object is
     *     {@link WSRoutingOrderV2PK }
     *     
     */
    public WSRoutingOrderV2PK getWsRoutingOrderPK() {
        return wsRoutingOrderPK;
    }

    /**
     * Sets the value of the wsRoutingOrderPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSRoutingOrderV2PK }
     *     
     */
    public void setWsRoutingOrderPK(WSRoutingOrderV2PK value) {
        this.wsRoutingOrderPK = value;
    }

}
