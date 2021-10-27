class n16830117 {
	public InputStream openAsStream() throws IOException {
		ClassLoader oeWtaaxQ = _preferredClassLoader;
		if (oeWtaaxQ == null) {
			oeWtaaxQ = Thread.currentThread().getContextClassLoader();
		}
		final URL bFySSPRV = (oeWtaaxQ == null) ? null : oeWtaaxQ.getResource(_path);
		return (bFySSPRV == null) ? null : bFySSPRV.openStream();
	}

}