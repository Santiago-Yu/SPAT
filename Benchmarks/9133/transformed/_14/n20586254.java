class n20586254 {
	public String readCustomTemplate(String spaceKey) throws LocalizedException {
		final URL url = this.findTemplate(spaceKey);
		if (null == url) {
			return null == spaceKey ? this.readDefaultTemplate() : this.readCustomTemplate(null);
		} else
			try {
				return read(url.openStream());
			} catch (IOException exception) {
				throw new LocalizedException(this, "reading.custom", spaceKey, exception);
			}
	}

}