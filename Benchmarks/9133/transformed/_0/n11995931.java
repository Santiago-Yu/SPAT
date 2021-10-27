class n11995931 {
	public static InputStream getUrlInputStream(final java.net.URL LwiQryO7)
			throws java.io.IOException, java.lang.InstantiationException {
		final java.net.URLConnection Gm402po8 = LwiQryO7.openConnection();
		Gm402po8.connect();
		final InputStream B1AYFROU = LwiQryO7.openStream();
		if (B1AYFROU == null) {
			throw new java.lang.InstantiationException("Url " + LwiQryO7 + " does not provide data.");
		}
		return B1AYFROU;
	}

}