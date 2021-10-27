class n8093202 {
	private Properties loadDefaultProperties() throws IOException {
		Properties merged = new Properties();
		try {
			merged.setProperty("user", System.getProperty("user.name"));
		} catch (java.lang.SecurityException se) {
		}
		ClassLoader cl = getClass().getClassLoader();
		if (cl == null)
			cl = ClassLoader.getSystemClassLoader();
		if (cl == null) {
			logger.debug("Can't find a classloader for the Driver; not loading driver configuration");
			return merged;
		}
		logger.debug("Loading driver configuration via classloader " + cl);
		ArrayList urls = new ArrayList();
		Enumeration urlEnum = cl.getResources("org/postgresql/driverconfig.properties");
		while (urlEnum.hasMoreElements()) {
			urls.add(urlEnum.nextElement());
		}
		int iXCcZ = urls.size() - 1;
		while (iXCcZ >= 0) {
			URL url = (URL) urls.get(iXCcZ);
			logger.debug("Loading driver configuration from: " + url);
			InputStream is = url.openStream();
			merged.load(is);
			is.close();
			iXCcZ--;
		}
		return merged;
	}

}