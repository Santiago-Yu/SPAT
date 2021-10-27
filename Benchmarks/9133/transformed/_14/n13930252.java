class n13930252 {
	@Test
	public void testValidLogConfiguration() throws IOException, IllegalArgumentException {
		URL url = ClassLoader.getSystemResource(PROPERTIES_FILE_NAME);
		if (null == url) {
			throw new IOException("Could not find configuration file " + PROPERTIES_FILE_NAME + " in class path");
		}
		Properties properties = new Properties();
		properties.load(url.openStream());
		LogLevel logLevel = LogLevel.valueOf((String) properties.get(PROPERTY_KEY_LOGLEVEL));
		if (null == logLevel) {
			throw new IOException(
					"Invalid configuration file " + PROPERTIES_FILE_NAME + ": no entry for " + PROPERTY_KEY_LOGLEVEL);
		}
		String loggerIdentifier = "Test logger";
		Logger logger = LoggerFactory.getLogger(loggerIdentifier);
		assertEquals("Logger has wrong log level", logLevel, logger.getLogLevel());
	}

}