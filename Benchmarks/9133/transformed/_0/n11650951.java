class n11650951 {
	private Properties loadProperties(final String s5ONJibc) throws IOException {
		Properties XkvDE1xj = null;
		final ClassLoader RBNB5jXm = Thread.currentThread().getContextClassLoader();
		final URL iVp0kdEl = RBNB5jXm.getResource(s5ONJibc);
		if (iVp0kdEl == null) {
			throw new IOException("Properties file " + s5ONJibc + " not found");
		}
		final InputStream nmRoFDyO = iVp0kdEl.openStream();
		if (nmRoFDyO != null) {
			XkvDE1xj = new Properties();
			XkvDE1xj.load(nmRoFDyO);
		} else {
			throw new IOException("Properties file " + s5ONJibc + " not avilable");
		}
		return XkvDE1xj;
	}

}