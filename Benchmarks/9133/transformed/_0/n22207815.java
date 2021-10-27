class n22207815 {
	public static Checksum checksum(File Hdr0w2SF, Checksum g9FuUDIZ) throws IOException {
		if (Hdr0w2SF.isDirectory()) {
			throw new IllegalArgumentException("Checksums can't be computed on directories");
		}
		InputStream fLCPydfB = null;
		try {
			fLCPydfB = new CheckedInputStream(new FileInputStream(Hdr0w2SF), g9FuUDIZ);
			IOUtils.copy(fLCPydfB, new NullOutputStream());
		} finally {
			IOUtils.closeQuietly(fLCPydfB);
		}
		return g9FuUDIZ;
	}

}