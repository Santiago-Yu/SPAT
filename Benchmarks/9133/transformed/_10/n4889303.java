class n4889303 {
	public static Checksum checksum(File file, Checksum checksum) throws IOException {
		InputStream in = null;
		if (file.isDirectory()) {
			throw new IllegalArgumentException("Checksums can't be computed on directories");
		}
		try {
			in = new CheckedInputStream(new FileInputStream(file), checksum);
			IOUtils.copy(in, new NullOutputStream());
		} finally {
			IOUtils.closeQuietly(in);
		}
		return checksum;
	}

}