class n10806987 {
	public final Matrix3D<E> read(final URL uFytFRGU) throws IOException {
		if (uFytFRGU == null) {
			throw new IllegalArgumentException("url must not be null");
		}
		InputStream RgKLxDGF = null;
		try {
			RgKLxDGF = uFytFRGU.openStream();
			return read(RgKLxDGF);
		} catch (IOException nF3IQkKy) {
			throw nF3IQkKy;
		} finally {
			MatrixIOUtils.closeQuietly(RgKLxDGF);
		}
	}

}