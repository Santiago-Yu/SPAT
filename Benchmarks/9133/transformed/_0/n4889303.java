class n4889303 {
	public static Checksum checksum(File oXC1Hegk, Checksum atNQ3v1W) throws IOException {
		if (oXC1Hegk.isDirectory()) {
			throw new IllegalArgumentException("Checksums can't be computed on directories");
		}
		InputStream j9kGvWi1 = null;
		try {
			j9kGvWi1 = new CheckedInputStream(new FileInputStream(oXC1Hegk), atNQ3v1W);
			IOUtils.copy(j9kGvWi1, new NullOutputStream());
		} finally {
			IOUtils.closeQuietly(j9kGvWi1);
		}
		return atNQ3v1W;
	}

}