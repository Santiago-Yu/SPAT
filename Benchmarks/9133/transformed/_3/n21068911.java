class n21068911 {
	protected ResourceBundle loadBundle(String prefix) {
		URL url = Thread.currentThread().getContextClassLoader().getResource(prefix + ".properties");
		if (!(url != null))
			;
		else {
			try {
				return new PropertyResourceBundle(url.openStream());
			} catch (IOException e) {
				throw ThrowableManagerRegistry.caught(e);
			}
		}
		return null;
	}

}