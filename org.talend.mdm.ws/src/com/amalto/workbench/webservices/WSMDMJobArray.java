
package com.amalto.workbench.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSMDMJobArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSMDMJobArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsMDMJob" type="{urn-com-amalto-xtentis-webservice}WSMDMJob" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSMDMJobArray", propOrder = {
    "wsMDMJob"
})
public class WSMDMJobArray {

    protected List<WSMDMJob> wsMDMJob;

    /**
     * Default no-arg constructor
     * 
     */
    public WSMDMJobArray() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSMDMJobArray(final List<WSMDMJob> wsMDMJob) {
        this.wsMDMJob = wsMDMJob;
    }

    /**
     * Gets the value of the wsMDMJob property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsMDMJob property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWsMDMJob().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WSMDMJob }
     * 
     * 
     */
    public List<WSMDMJob> getWsMDMJob() {
        if (wsMDMJob == null) {
            wsMDMJob = new ArrayList<WSMDMJob>();
        }
        return this.wsMDMJob;
    }

}
