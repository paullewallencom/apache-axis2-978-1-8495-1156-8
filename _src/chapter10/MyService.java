import org.apache.axis2.service.Lifecycle;
import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.AxisFault;

public class MyService implements Lifecycle {
    public void init(ServiceContext context) throws AxisFault {
        System.out.println("I'm inside init method ");
    }

    public void destroy(ServiceContext context) {
        System.out.println("I'm inside destroy method");
    }

    public String foo(String foo) {
        return foo;
    }

    public int add(int value) {
        MessageContext messageContext = MessageContext.getCurrentMessageContext();
        ServiceContext sc = messageContext.getServiceContext();
        Object previousValue = sc.getProperty("VALUE");
        int previousIntValue = 0;
        if (previousValue != null) {
            previousIntValue = Integer.parseInt((String) previousValue);
        }
        int currentVValue = previousIntValue + value;
        sc.setProperty("VALUE", "" + currentVValue);
        return currentVValue;
    }
}
