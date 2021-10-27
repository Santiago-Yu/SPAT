class n16830117 {
	public InputStream openAsStream() throws IOException {
		ClassLoader cl = _preferredClassLoader;
		cl = (cl == null) ? Thread.currentThread().getContextClassLoader() : cl;
		final URL url = (cl == null) ? null : cl.getResource(_path);
		return (url == null) ? null : url.openStream();
	}

}