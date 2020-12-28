import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMNamespace;

public class TransportSessionClient {
    public static void main(String[] args) throws Exception {
        ServiceClient sc = new ServiceClient();
        Options opts = new Options();
        opts.setTo(new EndpointReference(
                "http://127.0.0.1:8000/axis2/services/MyService"));
        opts.setAction("urn:add");
        opts.setManageSession(true);
        sc.setOptions(opts);
        OMElement ele = sc.sendReceive(createPayLoad(10));
        System.out.println(ele.getFirstElement().getText());
        ele = sc.sendReceive(createPayLoad(10));
        System.out.println(ele.getFirstElement().getText());
    }

     public static OMElement createPayLoad(int intVValue) {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(
                "http://ws.apache.org/axis2", "ns1");
        OMElement method = fac.createOMElement("add", omNs);
        OMElement value = fac.createOMElement("args", omNs);
        value.setText("" + intVValue);
        method.addChild(value);
        return method;
    }
}
