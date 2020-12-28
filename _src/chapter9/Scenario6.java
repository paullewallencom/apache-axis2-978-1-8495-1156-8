import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.Options;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMNamespace;

public class Scenario6 {
    public static void main(String[] args) throws Exception {
        ServiceClient sc = new ServiceClient();

        OperationClient opClient = sc.createClient(
                ServiceClient.ANON_OUT_IN_OP);
        //creating message context
        MessageContext outMsgCtx = new MessageContext();
        //assigning message context's option object into instance variable
        Options opts = outMsgCtx.getOptions();
        //setting properties into option
        opts.setTo(new EndpointReference(
                "http://127.0.0.1:8000/axis2/services/MyService"));
        opts.setAction("urn:echo");
        outMsgCtx.setEnvelope(creatSOAPEnvelop());

        opClient.addMessageContext(outMsgCtx);

        //pass message label as method argument
        MessageContext inMsgtCtx = opClient.getMessageContext("In");
        SOAPEnvelope response = inMsgtCtx.getEnvelope();
        System.out.println(response);
    }

    public static SOAPEnvelope creatSOAPEnvelop() {
        SOAPFactory fac = OMAbstractFactory.getSOAP11Factory();
        SOAPEnvelope envelope = fac.getDefaultEnvelope();
        OMNamespace omNs = fac.createOMNamespace(
                "http://ws.apache.org/axis2", "ns1");
        OMElement method = fac.createOMElement("echo", omNs);
        OMElement value = fac.createOMElement("echo", omNs);
        value.setText("Hello");
        method.addChild(value);
        envelope.getBody().addChild(method);
        return envelope;
    }
}
