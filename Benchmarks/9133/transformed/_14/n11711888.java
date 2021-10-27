class n11711888 {
	public synchronized void readConfiguration() throws IOException, SecurityException {
		String path;
		InputStream inputStream;
		path = System.getProperty("java.util.logging.config.file");
		if ((null == path) || (0 == path.length())) {
			String url = (System.getProperty("gnu.classpath.home.url") + "/logging.properties");
			inputStream = new URL(url).openStream();
		} else
			inputStream = new java.io.FileInputStream(path);
		try {
			readConfiguration(inputStream);
		} finally {
			inputStream.close();
		}
	}

}