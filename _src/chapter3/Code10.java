import org.apache.axiom.om.*;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axiom.soap.SOAPEnvelope;

public class Code10 {
    public static void main(String[] args) {
        OMFactory factory = OMAbstractFactory.getOMFactory();
        OMNamespace axis2 = factory.createOMNamespace("axis2", "ns");
        OMElement root = factory.createOMElement("book", axis2);
        OMAttribute type = factory.createOMAttribute("type", null, "web-services");
        root.addAttribute(type);
        OMElement name = factory.createOMElement("name", axis2);
        OMElement isbn = factory.createOMElement("isbn", axis2);
        root.addChild(name);
        root.addChild(isbn);
        SOAPFactory soapFactory = OMAbstractFactory.getSOAP12Factory();
        //get the default envelope
        SOAPEnvelope env = soapFactory.getDefaultEnvelope();
        //add the created child
        env.getBody().addChild(root);
        System.out.println(env);
    }
}