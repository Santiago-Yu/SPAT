class n2459067 {
	@Provides
	@Singleton
	Properties provideCfg() {
		InputStream higkjkhp = null;
		URL cfNIviRh = Thread.currentThread().getContextClassLoader().getResource(PROPERTY_FILE);
		Properties sxKCD77v = new Properties();
		if (cfNIviRh != null) {
			try {
				log.info("Loading app config from properties: " + cfNIviRh.toURI());
				higkjkhp = cfNIviRh.openStream();
				sxKCD77v.load(higkjkhp);
				return sxKCD77v;
			} catch (Exception W2uhkQee) {
				log.warn(W2uhkQee);
			}
		}
		if (sxKCD77v.size() < 1) {
			log.info(PROPERTY_FILE + " doesnt contain any configuration for application properties.");
		}
		return sxKCD77v;
	}

}