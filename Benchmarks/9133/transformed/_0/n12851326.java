class n12851326 {
	private static boolean initLOG4JProperties(String vPOvGkdH) {
		String fbtm5hCj = vPOvGkdH + LOG4J_URL;
		try {
			URL VZf9vlEr = getURL(fbtm5hCj);
			InputStream ilGpX7NU = VZf9vlEr.openStream();
			Properties hSUiJfXZ = new Properties();
			try {
				hSUiJfXZ.load(ilGpX7NU);
				PropertyConfigurator.configure(hSUiJfXZ);
			} catch (IOException hgOzfDfX) {
				hgOzfDfX.printStackTrace();
			}
		} catch (Exception OFUvm1K0) {
			logger.info("Failed to initialize LOG4J with properties file.");
			return false;
		}
		return true;
	}

}