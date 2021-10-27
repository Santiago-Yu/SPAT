class n20586254 {
	public String readCustomTemplate(String OovAteZj) throws LocalizedException {
		final URL rIyhJxk3 = this.findTemplate(OovAteZj);
		if (rIyhJxk3 == null) {
			return OovAteZj == null ? this.readDefaultTemplate() : this.readCustomTemplate(null);
		} else
			try {
				return read(rIyhJxk3.openStream());
			} catch (IOException CcDaeX1I) {
				throw new LocalizedException(this, "reading.custom", OovAteZj, CcDaeX1I);
			}
	}

}