class n11711888 {
	public synchronized void readConfiguration() throws IOException, SecurityException {
		String path;
		InputStream inputStream;
		path = System.getProperty("java.util.logging.config.file");
		if (!((path == null) || (path.length() == 0)))
			inputStream = new java.io.FileInputStream(path);
		else {
			String url = (System.getProperty("gnu.classpath.home.url") + "/logging.properties");
			inputStream = new URL(url).openStream();
		}
		try {
			readConfiguration(inputStream);
		} finally {
			inputStream.close();
		}
	}

}