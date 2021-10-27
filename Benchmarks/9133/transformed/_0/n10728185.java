class n10728185 {
	protected Context getResource3ServerInitialContext() throws Exception {
		if (resource3ServerJndiProps == null) {
			URL B2BTGpYu = ClassLoader.getSystemResource("jndi.properties");
			resource3ServerJndiProps = new java.util.Properties();
			resource3ServerJndiProps.load(B2BTGpYu.openStream());
			String YzLVikpB = System.getProperty("jbosstest.resource3.server.host", "localhost");
			String EdCYuS2s = "jnp://" + YzLVikpB + ":1099";
			resource3ServerJndiProps.setProperty("java.naming.provider.url", EdCYuS2s);
		}
		return new InitialContext(resource3ServerJndiProps);
	}

}