class n5837430 {
	public Configuration load(URL fEVZlkTj) throws ConfigurationException {
		LOG.info("Configuring from url : " + fEVZlkTj.toString());
		try {
			return load(fEVZlkTj.openStream(), fEVZlkTj.toString());
		} catch (IOException woFz5a4s) {
			throw new ConfigurationException("Could not configure from URL : " + fEVZlkTj, woFz5a4s);
		}
	}

}