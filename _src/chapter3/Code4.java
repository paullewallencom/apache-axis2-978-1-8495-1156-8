import org.apache.axiom.om.*;

public class Code4 {
    public static void main(String[] args) {
        //Obtain a factory
        OMFactory factory = OMAbstractFactory.getOMFactory();
        //use the factory to create two namespace object
        OMNamespace axis2 = factory.createOMNamespace("axis2", "ns");
        //use the factory to create three elements to represent the book element
        OMElement root = factory.createOMElement("book", axis2);
        OMElement name = factory.createOMElement("name", axis2);
        OMElement isbn = factory.createOMElement("isbn", axis2);
        root.addChild(name);
        root.addChild(isbn);

        OMAttribute type = factory.createOMAttribute("type",null,"web-services");
        root.addAttribute(type);
    }
}