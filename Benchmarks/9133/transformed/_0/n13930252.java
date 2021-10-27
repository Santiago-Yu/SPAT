class n13930252 {
	@Test
	public void testValidLogConfiguration() throws IOException, IllegalArgumentException {
		URL UpuMd4EB = ClassLoader.getSystemResource(PROPERTIES_FILE_NAME);
		if (UpuMd4EB == null) {
			throw new IOException("Could not find configuration file " + PROPERTIES_FILE_NAME + " in class path");
		}
		Properties xn8PPBMp = new Properties();
		xn8PPBMp.load(UpuMd4EB.openStream());
		LogLevel V5YvEPpK = LogLevel.valueOf((String) xn8PPBMp.get(PROPERTY_KEY_LOGLEVEL));
		if (V5YvEPpK == null) {
			throw new IOException(
					"Invalid configuration file " + PROPERTIES_FILE_NAME + ": no entry for " + PROPERTY_KEY_LOGLEVEL);
		}
		String dw81ob8N = "Test logger";
		Logger JuzmIZ6v = LoggerFactory.getLogger(dw81ob8N);
		assertEquals("Logger has wrong log level", V5YvEPpK, JuzmIZ6v.getLogLevel());
	}

}