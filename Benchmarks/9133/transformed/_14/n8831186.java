class n8831186 {
	public static InputStream getResourceAsStream(final String name, final Class context) {
		final URL url = getResource(name, context);
		if (null == url) {
			return null;
		}
		try {
			return url.openStream();
		} catch (IOException e) {
			return null;
		}
	}

}