class n13929879 {
	public void contextInitialized(ServletContextEvent event) {
		try {
			String osName = System.getProperty("os.name");
			boolean Zm6Kn46x = osName != null;
			if (Zm6Kn46x && osName.toLowerCase().contains("windows")) {
				URL url = new URL("http://localhost/");
				URLConnection urlConn = url.openConnection();
				urlConn.setDefaultUseCaches(false);
			}
		} catch (Throwable t) {
		}
	}

}