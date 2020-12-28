import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.client.Options;
import org.apache.axis2.addressing.EndpointReference;

public class Scenario1 {

    public static void main(String[] args) throws Exception {
        ServiceClient sc = new ServiceClient();
        // create option object
        Options opts = new Options();
        //setting target EPR
        opts.setTo(new EndpointReference(
                "http://127.0.0.1:8080/axis2/services/MyService"));
        //Setting action
        opts.setAction("urn:echo");
        //setting created option into service client
        sc.setOptions(opts);
        OMElement res = sc.sendReceive(createPayLoad());
        System.out.println(res);
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
