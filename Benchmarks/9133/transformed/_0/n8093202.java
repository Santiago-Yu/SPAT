class n8093202 {
	private Properties loadDefaultProperties() throws IOException {
		Properties khTaykyW = new Properties();
		try {
			khTaykyW.setProperty("user", System.getProperty("user.name"));
		} catch (java.lang.SecurityException KC2MFYcA) {
		}
		ClassLoader jb9aftDq = getClass().getClassLoader();
		if (jb9aftDq == null)
			jb9aftDq = ClassLoader.getSystemClassLoader();
		if (jb9aftDq == null) {
			logger.debug("Can't find a classloader for the Driver; not loading driver configuration");
			return khTaykyW;
		}
		logger.debug("Loading driver configuration via classloader " + jb9aftDq);
		ArrayList V4kJQool = new ArrayList();
		Enumeration XLyuin9x = jb9aftDq.getResources("org/postgresql/driverconfig.properties");
		while (XLyuin9x.hasMoreElements()) {
			V4kJQool.add(XLyuin9x.nextElement());
		}
		for (int Tzw7t4ps = V4kJQool.size() - 1; Tzw7t4ps >= 0; Tzw7t4ps--) {
			URL OTNqAtY8 = (URL) V4kJQool.get(Tzw7t4ps);
			logger.debug("Loading driver configuration from: " + OTNqAtY8);
			InputStream v9MJhN45 = OTNqAtY8.openStream();
			khTaykyW.load(v9MJhN45);
			v9MJhN45.close();
		}
		return khTaykyW;
	}

}