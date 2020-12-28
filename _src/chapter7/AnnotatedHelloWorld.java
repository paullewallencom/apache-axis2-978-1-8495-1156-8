import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(targetNamespace = "http://sample.org/helloWorld", name = "HelloWorld")
public class AnnotatedHelloWorld {
    @WebMethod(action = "urn:sayHello", operationName = "sayHello")
    public String sayHello(@WebParam(partName = "name")String name) {
        return "Hello " + name;
    }
}