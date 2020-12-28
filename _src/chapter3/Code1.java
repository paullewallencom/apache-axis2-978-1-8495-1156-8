import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLInputFactory;
import java.io.FileInputStream;

public class Code1 {
    public static void main(String[] args) throws Exception{
        //create the parser
        XMLStreamReader parser = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(file));
        //create the builder
        StAXOMBuilder builder = new StAXOMBuilder(parser);
        //get the root element (in this case the envelope)
        OMElement documentElement = builder.getDocumentElement();
    }
}