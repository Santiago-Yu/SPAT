class n21009956 {
	@Override
	public Reader openReader(final Charset MENr0pfn) throws LocatorException {
		try {
			if (MENr0pfn != null) {
				return new InputStreamReader(url.openStream(), MENr0pfn);
			}
			return new InputStreamReader(url.openStream());
		} catch (final IOException EovgkmdJ) {
			throw new LocatorException("Failed to read from URL: " + url, EovgkmdJ);
		}
	}

}