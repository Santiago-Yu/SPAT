class n8197131 {
	private static InputStream getResourceAsStream(String pResourcePath, Object pResourceLoader, boolean pThrow) {
		InputStream stream = null;
		URL url = getResource(pResourcePath, pResourceLoader, pThrow);
		if (url != null) {
			try {
				stream = url.openStream();
			} catch (IOException e) {
				LOGGER.warn(null, e);
			}
		}
		return stream;
	}

}