import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMNamespace;

public class Scenario5 {
    public static void main(String[] args) throws Exception {
        ServiceClient sc = new ServiceClient();
        Options opts = new Options();
        opts.setTo(new EndpointReference("http://127.0.0.1:8080/axis2/services/MyService"));
        opts.setAction("urn:update");
        sc.setOptions(opts);
        sc.sendRobust(createPayLoad());
    }

    public static OMElement createPayLoad() {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(
                "http://ws.apache.org/axis2", "ns1");
        OMElement method = fac.createOMElement("update", omNs);
        OMElement value = fac.createOMElement("value", omNs);
        value.setText("10");
        method.addChild(value);
        return method;
    }
}
