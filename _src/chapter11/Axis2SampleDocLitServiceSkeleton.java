public class Axis2SampleDocLitServiceSkeleton {
    public org.apache.axis2.userguide.xsd.EchoStringReturn echoString(
            org.apache.axis2.userguide.xsd.EchoStringParam echoStringParam) {
        EchoStringReturn response = new EchoStringReturn();
        response.setEchoStringReturn(echoStringParam.getEchoStringParam());
        return response;
    }

    public org.apache.axis2.userguide.xsd.EchoStringArrayReturn echoStringArray(
            org.apache.axis2.userguide.xsd.EchoStringArrayParam echoStringArrayParam) {
        throw new java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#echoStringArray");
    }

    public org.apache.axis2.userguide.xsd.EchoStructReturn echoStruct(
            org.apache.axis2.userguide.xsd.EchoStructParam echoStructParam) {
        throw new java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#echoStruct");
    }
}
