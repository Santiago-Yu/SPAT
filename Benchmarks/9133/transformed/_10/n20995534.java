class n20995534 {
	private static Properties loadPropertiesFromClasspath(String path) {
		Properties props = new Properties();
		Enumeration<URL> locations;
		try {
			locations = Thread.currentThread().getContextClassLoader().getResources(path);
			while (locations.hasMoreElements()) {
				URL url = locations.nextElement();
				InputStream in = url.openStream();
				props.load(in);
				in.close();
				logger.config("Load properties from " + url);
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "load properties from classpath \"" + path + "\" failed", e);
		}
		return props;
	}

}