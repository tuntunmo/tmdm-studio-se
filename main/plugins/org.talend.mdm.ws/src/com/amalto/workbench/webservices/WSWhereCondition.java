
package com.amalto.workbench.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Use this object to write where conditions.
 * 			
 * 
 * <p>Java class for WSWhereCondition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSWhereCondition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="leftPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operator" type="{urn-com-amalto-xtentis-webservice}WSWhereOperator"/>
 *         &lt;element name="rightValueOrPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stringPredicate" type="{urn-com-amalto-xtentis-webservice}WSStringPredicate"/>
 *         &lt;element name="spellCheck" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSWhereCondition", propOrder = {
    "leftPath",
    "operator",
    "rightValueOrPath",
    "stringPredicate",
    "spellCheck"
})
public class WSWhereCondition {

    @XmlElement(nillable = true)
    protected String leftPath;
    @XmlElement(required = true, nillable = true)
    protected WSWhereOperator operator;
    @XmlElement(nillable = true)
    protected String rightValueOrPath;
    @XmlElement(required = true, nillable = true)
    protected WSStringPredicate stringPredicate;
    protected boolean spellCheck;

    /**
     * Default no-arg constructor
     * 
     */
    public WSWhereCondition() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSWhereCondition(final String leftPath, final WSWhereOperator operator, final String rightValueOrPath, final WSStringPredicate stringPredicate, final boolean spellCheck) {
        this.leftPath = leftPath;
        this.operator = operator;
        this.rightValueOrPath = rightValueOrPath;
        this.stringPredicate = stringPredicate;
        this.spellCheck = spellCheck;
    }

    /**
     * Gets the value of the leftPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeftPath() {
        return leftPath;
    }

    /**
     * Sets the value of the leftPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeftPath(String value) {
        this.leftPath = value;
    }

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link WSWhereOperator }
     *     
     */
    public WSWhereOperator getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSWhereOperator }
     *     
     */
    public void setOperator(WSWhereOperator value) {
        this.operator = value;
    }

    /**
     * Gets the value of the rightValueOrPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRightValueOrPath() {
        return rightValueOrPath;
    }

    /**
     * Sets the value of the rightValueOrPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRightValueOrPath(String value) {
        this.rightValueOrPath = value;
    }

    /**
     * Gets the value of the stringPredicate property.
     * 
     * @return
     *     possible object is
     *     {@link WSStringPredicate }
     *     
     */
    public WSStringPredicate getStringPredicate() {
        return stringPredicate;
    }

    /**
     * Sets the value of the stringPredicate property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSStringPredicate }
     *     
     */
    public void setStringPredicate(WSStringPredicate value) {
        this.stringPredicate = value;
    }

    /**
     * Gets the value of the spellCheck property.
     * 
     */
    public boolean isSpellCheck() {
        return spellCheck;
    }

    /**
     * Sets the value of the spellCheck property.
     * 
     */
    public void setSpellCheck(boolean value) {
        this.spellCheck = value;
    }

}
