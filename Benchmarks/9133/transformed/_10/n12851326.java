class n12851326 {
	private static boolean initLOG4JProperties(String homeDir) {
		String Log4jURL = homeDir + LOG4J_URL;
		try {
			URL log4jurl = getURL(Log4jURL);
			Properties propertiesLog4j = new Properties();
			InputStream inStreamLog4j = log4jurl.openStream();
			try {
				propertiesLog4j.load(inStreamLog4j);
				PropertyConfigurator.configure(propertiesLog4j);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.info("Failed to initialize LOG4J with properties file.");
			return false;
		}
		return true;
	}

}