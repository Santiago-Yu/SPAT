class n21995302 {
	public void open(Input input) throws IOException, ResolverException {
		URI uri;
		if (!input.isUriDefinitive())
			return;
		try {
			uri = new URI(input.getUri());
		} catch (URISyntaxException e) {
			throw new ResolverException(e);
		}
		if (!uri.isAbsolute())
			throw new ResolverException("cannot open relative URI: " + uri);
		URL url = new URL(uri.toASCIIString());
		input.setByteStream(url.openStream());
	}

}