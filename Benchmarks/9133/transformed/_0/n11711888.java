class n11711888 {
	public synchronized void readConfiguration() throws IOException, SecurityException {
		String y2OyLV8F;
		InputStream MaztQb8L;
		y2OyLV8F = System.getProperty("java.util.logging.config.file");
		if ((y2OyLV8F == null) || (y2OyLV8F.length() == 0)) {
			String S30P5Cge = (System.getProperty("gnu.classpath.home.url") + "/logging.properties");
			MaztQb8L = new URL(S30P5Cge).openStream();
		} else
			MaztQb8L = new java.io.FileInputStream(y2OyLV8F);
		try {
			readConfiguration(MaztQb8L);
		} finally {
			MaztQb8L.close();
		}
	}

}