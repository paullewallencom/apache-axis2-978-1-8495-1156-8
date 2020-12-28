import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axiom.om.impl.builder.StAXBuilder;
import org.apache.axiom.om.OMElement;

import java.io.ByteArrayInputStream;

public class Code7 {
    public static void main(String[] args) throws Exception{
        String xmlStream = "<ns:book xmlns:ns=\"axis2\" type=\"web-services\"><ns:name></ns:name><ns:isbn></ns:isbn></ns:book>";
        //Create an input stream for the string
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xmlStream.getBytes());
        //create a builder. Since we want the XML as a plain XML, we can just use
        //the plain OMBuilder
        StAXBuilder builder = new StAXOMBuilder(byteArrayInputStream);
        //return the root element.
        OMElement root = builder.getDocumentElement();
        root.serializeAndConsume(System.out);
        root.serialize(System.out);
    }
}