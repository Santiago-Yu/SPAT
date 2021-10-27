class n15854397 {
	public static Checksum checksum(File GDkvq8GZ, Checksum TFZeLe67) throws IOException {
		if (GDkvq8GZ.isDirectory()) {
			throw new IllegalArgumentException("Checksums can't be computed on directories");
		}
		InputStream c4OyBaeI = null;
		try {
			c4OyBaeI = new CheckedInputStream(new FileInputStream(GDkvq8GZ), TFZeLe67);
			IOUtils.copy(c4OyBaeI, NULL_OUTPUT_STREAM);
		} finally {
			IOUtils.close(c4OyBaeI);
		}
		return TFZeLe67;
	}

}