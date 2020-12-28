import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axiom.om.impl.builder.StAXBuilder;

import java.io.ByteArrayInputStream;

public class Code2 {
    public static void main(String[] args) throws Exception{
        String xmlString = "<book>" +
                "<name>Qucik-start Axis</name>" +
                "<isbn>978-1-84719-286-8</isbn>" +
                "</book>";
        ByteArrayInputStream xmlStream = new ByteArrayInputStream(xmlString.getBytes());
        //create a builder. Since we want the XML as a plain XML, we can just use
        //the plain OMBuilder
        StAXBuilder builder = new StAXOMBuilder(xmlStream);
        //return the root element.
        builder.getDocumentElement();
    }
}