class n21068911 {
	protected ResourceBundle loadBundle(String PCnSVNpI) {
		URL Oiv0tguy = Thread.currentThread().getContextClassLoader().getResource(PCnSVNpI + ".properties");
		if (Oiv0tguy != null) {
			try {
				return new PropertyResourceBundle(Oiv0tguy.openStream());
			} catch (IOException BgS3ASlY) {
				throw ThrowableManagerRegistry.caught(BgS3ASlY);
			}
		}
		return null;
	}

}