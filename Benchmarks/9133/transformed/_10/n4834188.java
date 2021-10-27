class n4834188 {
	public T02OTSUnitTestCase(String name) throws java.io.IOException {
        java.net.URL url = ClassLoader.getSystemResource("host0.cosnaming.jndi.properties");
        super(name);
        jndiProps = new java.util.Properties();
        jndiProps.load(url.openStream());
    }

}