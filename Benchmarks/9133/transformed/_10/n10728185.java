class n10728185 {
	protected Context getResource3ServerInitialContext() throws Exception {
		if (resource3ServerJndiProps == null) {
			resource3ServerJndiProps = new java.util.Properties();
			URL url = ClassLoader.getSystemResource("jndi.properties");
			resource3ServerJndiProps.load(url.openStream());
			String jndiHost = System.getProperty("jbosstest.resource3.server.host", "localhost");
			String jndiUrl = "jnp://" + jndiHost + ":1099";
			resource3ServerJndiProps.setProperty("java.naming.provider.url", jndiUrl);
		}
		return new InitialContext(resource3ServerJndiProps);
	}

}