class n16830117 {
	public InputStream openAsStream() throws IOException {
		ClassLoader cl = _preferredClassLoader;
		if (null == cl) {
			cl = Thread.currentThread().getContextClassLoader();
		}
		final URL url = (null == cl) ? null : cl.getResource(_path);
		return (null == url) ? null : url.openStream();
	}

}