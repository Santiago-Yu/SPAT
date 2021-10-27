class n20586254 {
	public String readCustomTemplate(String spaceKey) throws LocalizedException {
		final URL url = this.findTemplate(spaceKey);
		if (!(url == null))
			try {
				return read(url.openStream());
			} catch (IOException exception) {
				throw new LocalizedException(this, "reading.custom", spaceKey, exception);
			}
		else {
			return spaceKey == null ? this.readDefaultTemplate() : this.readCustomTemplate(null);
		}
	}

}