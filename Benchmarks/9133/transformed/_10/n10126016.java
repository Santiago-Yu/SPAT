class n10126016 {
	public T08OTSDTMInterpositionUnitTestCase(String name) throws java.io.IOException {
        java.net.URL url = ClassLoader.getSystemResource("host0.cosnaming.jndi.properties");
        super(name);
        jndiProps = new java.util.Properties();
        jndiProps.load(url.openStream());
    }

}