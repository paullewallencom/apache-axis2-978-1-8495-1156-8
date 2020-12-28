public class Code1 {
    public static void main(String[] args) throws Exception {
        //Need to have a reference to ConfigurationContext
        ConfigurationContext configContext = getConfigurationContext();
        File serviceArchiveFile = new File("Location of the file");
        //Now let's create AxisServiceGroup which contains the service we want //to have
        AxisServiceGroup serviceGroup = DeploymentEngine.loadServiceGroup(
                serviceArchiveFile,
                configContext);

        //Getting a pointer to AxisConfiguration
        AxisConfiguration axiConfiguration = configContext.getAxisConfiguration();
        //Adding the created service
        axiConfiguration.addServiceGroup(serviceGroup);
    }
    private static  ConfigurationContext getConfigurationContext() throws Exception{
        // There are a number of ways to get the configuration context , but here we just create a new one
        return ConfigurationContextFactory.createDefaultConfigurationContext();
    }
}
