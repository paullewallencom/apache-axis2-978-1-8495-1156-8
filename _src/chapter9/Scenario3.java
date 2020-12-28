import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

public class Scenario3 {
    public static void main(String[] args) throws Exception {
        ServiceClient sc = new ServiceClient();
        Options opts = new Options();
        opts.setTo(new EndpointReference(
                "http://127.0.0.1:8080/axis2/services/MyService"));
        //engaging addressing module
        sc.engageModule("addressing");
        // I need to use separate listener for my response
        opts.setUseSeparateListener(true);
        // Need to receive via TCP
        opts.setTransportInProtocol(Constants.TRANSPORT_TCP);
        opts.setAction("urn:echo");
        sc.setOptions(opts);
        sc.sendReceive(createPayLoad());
    }

    public static OMElement createPayLoad() {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(
                "http://ws.apache.org/axis2", "ns1");
        OMElement method = fac.createOMElement("echo", omNs);
        OMElement value = fac.createOMElement("value", omNs);
        value.setText("Hello , my first service utilization");
        method.addChild(value);
        return method;
    }
}
