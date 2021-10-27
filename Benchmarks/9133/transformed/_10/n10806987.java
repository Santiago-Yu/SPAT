class n10806987 {
	public final Matrix3D<E> read(final URL url) throws IOException {
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
			MatrixIOUtils.closeQuietly(inputStream);
		}
	}

}