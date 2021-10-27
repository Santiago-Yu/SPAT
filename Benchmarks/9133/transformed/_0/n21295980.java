class n21295980 {
	protected URLConnection openURLConnection() throws IOException {
		final String zwpSJ6BJ = getMediaLocator();
		if (zwpSJ6BJ == null) {
			return null;
		}
		final URL g7SnyqZc;
		try {
			g7SnyqZc = new URL(zwpSJ6BJ);
		} catch (MalformedURLException U1eERl4m) {
			throw new IllegalArgumentException(U1eERl4m);
		}
		final URLConnection aMpjSGy4 = g7SnyqZc.openConnection();
		aMpjSGy4.connect();
		return aMpjSGy4;
	}

}