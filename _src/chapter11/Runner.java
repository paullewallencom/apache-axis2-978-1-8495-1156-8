public class Runner {
    public static void main(String[] args) {
        Axis2SampleDocLitServiceStub stub = new Axis2SampleDocLitServiceStub();
        Axis2SampleDocLitServiceStub.EchoStringParam request = new Axis2SampleDocLitServiceStub.EchoStringParam();
        request.setEchoStringParam("Hello");
        Axis2SampleDocLitServiceStub.EchoStringReturn response = stub.echoString(request);
    }
}
