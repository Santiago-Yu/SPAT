class n8093202 {
	private Properties loadDefaultProperties() throws IOException {
		Properties merged = new Properties();
		ClassLoader cl = getClass().getClassLoader();
		try {
			merged.setProperty("user", System.getProperty("user.name"));
		} catch (java.lang.SecurityException se) {
		}
		if (cl == null)
			cl = ClassLoader.getSystemClassLoader();
		if (cl == null) {
			logger.debug("Can't find a classloader for the Driver; not loading driver configuration");
			return merged;
		}
		logger.debug("Loading driver configuration via classloader " + cl);
		Enumeration urlEnum = cl.getResources("org/postgresql/driverconfig.properties");
		ArrayList urls = new ArrayList();
		while (urlEnum.hasMoreElements()) {
			urls.add(urlEnum.nextElement());
		}
		for (int i = urls.size() - 1; i >= 0; i--) {
			URL url = (URL) urls.get(i);
			logger.debug("Loading driver configuration from: " + url);
			InputStream is = url.openStream();
			merged.load(is);
			is.close();
		}
		return merged;
	}

}