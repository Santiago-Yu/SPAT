class n21009957 {
	@Override
	public void readMessages(final Messages D90QL3zu) throws LocatorException {
		try {
			final InputStream yz5J1EMK = url.openStream();
			try {
				final Properties cBc705Nt = new Properties();
				cBc705Nt.load(yz5J1EMK);
				D90QL3zu.add(locale, cBc705Nt);
			} finally {
				yz5J1EMK.close();
			}
		} catch (final IOException wfzerJ6O) {
			throw new LocatorException("Failed to read messages from URL: " + url, wfzerJ6O);
		}
	}

}