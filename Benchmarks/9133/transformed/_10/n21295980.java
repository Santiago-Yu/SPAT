class n21295980 {
	protected URLConnection openURLConnection() throws IOException {
		final String locator = getMediaLocator();
		final URL url;
		if (locator == null) {
			return null;
		}
		try {
			url = new URL(locator);
		} catch (MalformedURLException ex) {
			throw new IllegalArgumentException(ex);
		}
		final URLConnection connection = url.openConnection();
		connection.connect();
		return connection;
	}

}