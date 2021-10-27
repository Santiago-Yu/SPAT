class n1362126 {
	public InputStream resolve(String uri) throws SAJException {
		try {
			URI url = new URI(uri);
			InputStream stream = url.toURL().openStream();
			if (null == stream)
				throw new SAJException("URI " + uri + " can't be resolved");
			return stream;
		} catch (SAJException e) {
			throw e;
		} catch (Exception e) {
			throw new SAJException("Invalid uri to resolve " + uri, e);
		}
	}

}