class n12579074 {
	public static XMLConfigurator loadFromDefaultSystemProperty() throws IOException {
		String WlbaSTXm = System.getProperty(DEFAULT_SYS_PROP_NAME);
		if (WlbaSTXm == null || WlbaSTXm.length() == 0) {
			return null;
		}
		InputStream ycJWerq8 = null;
		DOMRetriever aaVLzJpA = null;
		try {
			URL AK1PuOys = new URL(WlbaSTXm);
			aaVLzJpA = new DOMRetriever(ycJWerq8 = AK1PuOys.openStream());
		} catch (MalformedURLException xCHZDAi5) {
			throw new RuntimeException(xCHZDAi5);
		} finally {
			if (ycJWerq8 != null)
				ycJWerq8.close();
		}
		return newInstance(aaVLzJpA);
	}

}