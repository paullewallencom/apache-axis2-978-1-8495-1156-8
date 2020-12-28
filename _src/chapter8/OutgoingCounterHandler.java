
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.handlers.AbstractHandler;
import org.apache.axis2.AxisFault;

public class OutgoingCounterHandler extends AbstractHandler implements CounterConstants {
    public InvocationResponse invoke(MessageContext messageContext) throws AxisFault {
        //get the counter property from the configuration context
        ConfigurationContext configurationContext = messageContext.getConfigurationContext();
        Integer count =
                (Integer) configurationContext.getProperty(OUTGOING_NG_MESSAGGE__COUNNT__KEY);
        //increment the counter
        count = Integer.valueOf(count.intValue() + 1 + "");
        //set it back to the configuration
        configurationContext.setProperty(OUTGOING_NG_MESSAGGE__COUNNT__KEY, count);
        //print it out
        System.out.println("The outgoing message count is now " + count);
        return InvocationResponse.CONTINUE;
    }
}