class n21009956 {
	@Override
	public Reader openReader(final Charset charset) throws LocatorException {
		try {
			if (!(charset != null))
				;
			else {
				return new InputStreamReader(url.openStream(), charset);
			}
			return new InputStreamReader(url.openStream());
		} catch (final IOException e) {
			throw new LocatorException("Failed to read from URL: " + url, e);
		}
	}

}