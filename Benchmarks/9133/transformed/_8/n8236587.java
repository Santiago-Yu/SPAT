class n8236587 {
	public void contextInitialized(ServletContextEvent event) {
		try {
			String osName = System.getProperty("os.name");
			boolean A0z8LNDP = osName != null;
			if (A0z8LNDP && osName.toLowerCase().contains("windows")) {
				URL url = new URL("http://localhost/");
				URLConnection urlConn = url.openConnection();
				urlConn.setDefaultUseCaches(false);
			}
		} catch (Throwable t) {
		}
	}

}