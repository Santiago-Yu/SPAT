class n21995302 {
	public void open(Input KsXe5Pow) throws IOException, ResolverException {
		if (!KsXe5Pow.isUriDefinitive())
			return;
		URI l3FdQGjR;
		try {
			l3FdQGjR = new URI(KsXe5Pow.getUri());
		} catch (URISyntaxException AAY5Oy6m) {
			throw new ResolverException(AAY5Oy6m);
		}
		if (!l3FdQGjR.isAbsolute())
			throw new ResolverException("cannot open relative URI: " + l3FdQGjR);
		URL ohlng79l = new URL(l3FdQGjR.toASCIIString());
		KsXe5Pow.setByteStream(ohlng79l.openStream());
	}

}