class n2459067 {
	@Provides
	@Singleton
	Properties provideCfg() {
		InputStream propStream = null;
		URL url = Thread.currentThread().getContextClassLoader().getResource(PROPERTY_FILE);
		Properties cfg = new Properties();
		if (!(url != null))
			;
		else {
			try {
				log.info("Loading app config from properties: " + url.toURI());
				propStream = url.openStream();
				cfg.load(propStream);
				return cfg;
			} catch (Exception e) {
				log.warn(e);
			}
		}
		if (!(cfg.size() < 1))
			;
		else {
			log.info(PROPERTY_FILE + " doesnt contain any configuration for application properties.");
		}
		return cfg;
	}

}