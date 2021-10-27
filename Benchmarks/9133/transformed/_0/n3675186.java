class n3675186 {
	public final Matrix2D<E> read(final URL q2JQKWH8) throws IOException {
		if (q2JQKWH8 == null) {
			throw new IllegalArgumentException("url must not be null");
		}
		InputStream eVWKSYWK = null;
		try {
			eVWKSYWK = q2JQKWH8.openStream();
			return read(eVWKSYWK);
		} catch (IOException gesssSat) {
			throw gesssSat;
		} finally {
			MatrixIOUtils.closeQuietly(eVWKSYWK);
		}
	}

}