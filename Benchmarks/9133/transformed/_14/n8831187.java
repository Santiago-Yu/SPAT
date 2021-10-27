class n8831187 {
	public static InputStream getResourceRelativeAsStream(final String name, final Class context) {
		final URL url = getResourceRelative(name, context);
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