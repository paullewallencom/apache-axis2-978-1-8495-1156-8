import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXBuilder;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axiom.om.xpath.AXIOMXPath;

import java.io.ByteArrayInputStream;

public class Code8 {
    public static void main(String[] args)throws Exception{
        String xmlStream = "<book type=\"web-services\"><name></name><isbn>56789</isbn></book>";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream
                (xmlStream.getBytes());
        StAXBuilder builder = new StAXOMBuilder(byteArrayInputStream);
        OMElement root = builder.getDocumentElement();
        AXIOMXPath xpath = new AXIOMXPath("/book/isbn[1]");
        OMElement selectedNode = (OMElement) xpath.selectSingleNode(root);
        System.out.println(selectedNode.getText());
    }
}