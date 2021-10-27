class n11650951 {
	private Properties loadProperties(final String propertiesName) throws IOException {
		final ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties bundle = null;
		final URL url = loader.getResource(propertiesName);
		if (url == null) {
			throw new IOException("Properties file " + propertiesName + " not found");
		}
		final InputStream is = url.openStream();
		if (is != null) {
			bundle = new Properties();
			bundle.load(is);
		} else {
			throw new IOException("Properties file " + propertiesName + " not avilable");
		}
		return bundle;
	}

}