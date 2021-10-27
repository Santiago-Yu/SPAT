class n6243267 {
	public Graph<N, E> read(final URL url) throws IOException {
		InputStream inputStream = null;
		if (url == null) {
			throw new IllegalArgumentException("url must not be null");
		}
		try {
			inputStream = url.openStream();
			return read(inputStream);
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
			}
		}
	}

}