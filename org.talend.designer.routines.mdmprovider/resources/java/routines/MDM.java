// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package routines;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class MDM {

    /**
     * getFK: Return one of the FK component by position in a mangled FK
     * (FKs are mangled in MDM to accommodate for compound keys)
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} MDM
     * 
     * {param} string(FKs) mangledFK: original mangled FK.
     * 
     * {param} int(0) pos: key position (starts at 0)
     * 
     * {example} getFK(FKs,0) # 12345
     */
    public static String getFK(String mangledFK, int pos) {
        if (mangledFK == null) {
            return null;
        }
        Pattern p = Pattern.compile("(\\[[^\\[\\]]*\\])");
        Matcher m = p.matcher(mangledFK.trim());        
        int i = 0;
        while (m.find()) {
            if(i == pos){
                String targetValue = m.group(0);
                return targetValue.substring(1, targetValue.length()-1);
            }
            i++;
        }
        return null;
    }
    
    /**
     * createFK: Return the Fk string by a singleKey
     * (FKs are mangled in MDM to accommodate for compound keys)
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} MDM
     * 
     * {param} string singleKey: original key.
     * 
     * 
     * {example} createFK("0") # return "[0]"
     */
    public static  String createFK(String singleKey){
    	return "["+singleKey+"]";
    }
    
    /**
     * createFK: Return the Fk string by a key list
     * (FKs are mangled in MDM to accommodate for compound keys)
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} MDM
     * 
     * {param} string singleKey: original key array.
     * 
     * 
     * {example} createFK({"0","1"}) # return "[0][1]"
     */
    public static String createFK(String[] keys){
    	StringBuffer sb=new StringBuffer();
    	for(String key :keys){
    		sb.append("[").append(key).append("]");
    	}
    	return sb.toString();
    }
    
    /**
     * get repeating element in xmlString according to the xpath & position
     * 
     * {talendTypes} String
     * 
     * {Category} MDM
     * 
     * {param} string(xml) xml: xml
     * 
     * {param} string(xpath) xpath: xpath.
     * 
     * {param} int(0) position: position.
     */
    public static String getRepeatingElement(String xml, String xpath, int position)throws Exception{

		Node node =parse(xml);
		NodeList list= getNodeList(node,xpath,false);	
		for(int i=0; i<list.getLength(); i++){
			if(i==position){
				Node n=list.item(i);
				return n.getNodeValue();
			}
		}
		return null;
    }
    
    /**
     * check repeating elements in xmlString according to xpath & text
     * 
     * {talendTypes} Boolean
     * 
     * {Category} MDM
     * 
     * {param} string(xml) xml: xml.
     * 
     * {param} string(xpath) xpath: xpath.
     * 
     * {param} String(text) text: text.
     */
    public static boolean hasRepeatingElement(String xml, String xpath, String text)throws Exception{
    	Node node =parse(xml);
		NodeList list= getNodeList(node,xpath,false);	
		for(int i=0; i<list.getLength(); i++){			
			Node n=list.item(i);
			if(n.getNodeValue().equals(text)){
				return true;
			}
		}
		return false;
    }
    
    /**
     * list repeating elements in xmlString according to xpath & delimiter
     * 
     * {talendTypes} String
     * 
     * {Category} MDM
     * 
     * {param} string(xml) xml: xml.
     * 
     * {param} string(xpath) xpath: xpath.
     * 
     * {param} char(delimiter) delimiter: delimiter.
     */
    public static String listRepeatingElement(String xml, String xpath, char delimiter)throws Exception{
    	Node node =parse(xml);
    	
		NodeList list= getNodeList(node,xpath,false);	
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<list.getLength(); i++){			
			Node n=list.item(i);
			sb.append(n.getNodeValue());
			if(i>=0 && i<list.getLength()-1){
				sb.append(delimiter);
			}
		}
		return sb.toString();
    }
    
	/**
	 * add repeating elements in xmlString according to xpath & text
	 * 
     * {talendTypes} String
     * 
     * {Category} MDM
     * 
     * {param} string(xml) xml: xml
     * 
     * {param} string(xpath) xpath: xpath
     * 
     * {param} String(text) text: text
	 */
	public static String addRepeatingElement(String xml, String xpath, String text)throws Exception{
		Node node =parse(xml);
    	
	    int pos= xpath.lastIndexOf('/');
	    String name=xpath.substring(pos+1);
	    String parentPath=xpath.substring(0,pos);
	    NodeList plist= getNodeList(node,parentPath,true);	
	    if(plist.getLength()>0){
	    	Element el=node.getOwnerDocument().createElement(name);
	    	el.setTextContent(text);
	    	Node nn=plist.item(0).appendChild(el);
	    	System.out.println(nn);
	    }
		
		return nodeToString(node, true);
	}
	
    /**
     * Generate an <error code="X">msg</error> fragment
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} MDM
     * 
     * {param} string msg: error message.
     * 
     * {param} int(0) code: error code, (1:ERROR, 0:NORMAL)
     * 
     * {example} genErrMsg("test message",0) #  return <error code="0">test message</error>
     */
    public static String createReturnMessage(String msg, int code){
    	return "<error code=\""+code+"\">" + msg +"</error>";
    }
    
    
    //Utility methods
    /**
     * Get a nodelist from an xPath
     * 
     * @throws Exception
     */
	private static NodeList getNodeList(Node contextNode, String xPath, boolean isParent) throws Exception {
        if (!xPath.matches(".*@[^/\\]]+")) // attribute
            if (!xPath.endsWith(")") && !isParent) // function
                xPath += "/text()";
    	XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        XPathExpression expr 
         = xpath.compile(xPath);

        Object result = expr.evaluate(contextNode, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        return nodes;
    }
	
	
	/**
	 * parse the xml
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	private static Node parse(String xml)throws Exception{
	    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true); // never forget this!
	    DocumentBuilder builder = domFactory.newDocumentBuilder();
	    Document doc = builder.parse(new InputSource(new StringReader(xml)));
	    return doc.getDocumentElement();
	}
    /**
     * Generates an xml string from a node with or without the xml declaration (not pretty formatted)
     * 
     * @param n the node
     * @return the xml string
     * @throws TransformerException
     */
    private static String nodeToString(Node n, boolean omitXMLDeclaration) throws TransformerException {
        StringWriter sw = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        if (omitXMLDeclaration)
            transformer.setOutputProperty("omit-xml-declaration", "yes");
        else
            transformer.setOutputProperty("omit-xml-declaration", "no");
        transformer.setOutputProperty("indent", "yes");
        transformer.transform(new DOMSource(n), new StreamResult(sw));
        if (sw == null)
            return null;
        return sw.toString().replaceAll("\r\n", "\n");
    }
    
}
