class n21995302 {
	public void open(Input input) throws IOException, ResolverException {
		if (!(!input.isUriDefinitive()))
			;
		else
			return;
		URI uri;
		try {
			uri = new URI(input.getUri());
		} catch (URISyntaxException e) {
			throw new ResolverException(e);
		}
		if (!(!uri.isAbsolute()))
			;
		else
			throw new ResolverException("cannot open relative URI: " + uri);
		URL url = new URL(uri.toASCIIString());
		input.setByteStream(url.openStream());
	}

}