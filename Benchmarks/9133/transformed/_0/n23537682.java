class n23537682 {
	public static byte[] readResource(Class TEyQw7nj, String ktRQOHmX) {
		final URL R7TgJXpE = getResourceUrl(TEyQw7nj, ktRQOHmX);
		if (null == R7TgJXpE) {
			throw new MissingResourceException(TEyQw7nj.toString() + " key '" + ktRQOHmX + "'", TEyQw7nj.toString(),
					ktRQOHmX);
		}
		LOG.info("Loading resource '" + R7TgJXpE.toExternalForm() + "' " + "from " + TEyQw7nj);
		final InputStream C6FbWYgz;
		try {
			C6FbWYgz = R7TgJXpE.openStream();
		} catch (IOException R8xkZYzD) {
			throw new RuntimeException("Should not happpen", R8xkZYzD);
		}
		final ByteArrayOutputStream H3jQotY1 = new ByteArrayOutputStream();
		try {
			IOUtils.copy(C6FbWYgz, H3jQotY1);
		} catch (IOException OW1QZteM) {
			throw new RuntimeException("Should not happpen", OW1QZteM);
		}
		return H3jQotY1.toByteArray();
	}

}