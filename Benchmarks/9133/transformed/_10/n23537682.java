class n23537682 {
	public static byte[] readResource(Class owningClass, String resourceName) {
		final URL url = getResourceUrl(owningClass, resourceName);
		if (null == url) {
			throw new MissingResourceException(owningClass.toString() + " key '" + resourceName + "'",
					owningClass.toString(), resourceName);
		}
		LOG.info("Loading resource '" + url.toExternalForm() + "' " + "from " + owningClass);
		final InputStream inputStream;
		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			inputStream = url.openStream();
		} catch (IOException e) {
			throw new RuntimeException("Should not happpen", e);
		}
		try {
			IOUtils.copy(inputStream, outputStream);
		} catch (IOException e) {
			throw new RuntimeException("Should not happpen", e);
		}
		return outputStream.toByteArray();
	}

}