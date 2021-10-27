class n17332559 {
	private static boolean initLOG4JProperties(String MghKdA0e) {
		String DW1TDMXC = MghKdA0e + LOG4J_URL;
		try {
			URL PfgP8WoM = getURL(DW1TDMXC);
			InputStream oyYxzj9M = PfgP8WoM.openStream();
			Properties tiKKzzK9 = new Properties();
			try {
				tiKKzzK9.load(oyYxzj9M);
				PropertyConfigurator.configure(tiKKzzK9);
			} catch (IOException Y7cO9hA3) {
				Y7cO9hA3.printStackTrace();
			}
		} catch (Exception GRyJ00Nd) {
			logger.info("Failed to initialize LOG4J with properties file.");
			return false;
		}
		return true;
	}

}