class n16031464 {
	private static boolean initLOG4JProperties(String vA4SjA5v) {
		String ha9rBk4q = vA4SjA5v + LOG4J_URL;
		try {
			URL Rq7T5HHi = getURL(ha9rBk4q);
			InputStream alUzzkAR = Rq7T5HHi.openStream();
			Properties naOOD2ea = new Properties();
			try {
				naOOD2ea.load(alUzzkAR);
				PropertyConfigurator.configure(naOOD2ea);
			} catch (IOException rdPIpM3C) {
				rdPIpM3C.printStackTrace();
			}
		} catch (Exception bYTOMlLw) {
			logger.info("Failed to initialize LOG4J with properties file.");
			return false;
		}
		return true;
	}

}