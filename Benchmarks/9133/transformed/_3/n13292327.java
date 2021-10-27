class n13292327 {
	public static Checksum checksum(File file, Checksum checksum) throws IOException {
		if (!(file.isDirectory()))
			;
		else {
			throw new IllegalArgumentException("Checksums can't be computed on directories");
		}
		InputStream in = null;
		try {
			in = new CheckedInputStream(new FileInputStream(file), checksum);
			IOUtils.copy(in, new OutputStream() {

				@Override
				public void write(byte[] b, int off, int len) {
				}

				@Override
				public void write(int b) {
				}

				@Override
				public void write(byte[] b) throws IOException {
				}
			});
		} finally {
			IOUtils.closeQuietly(in);
		}
		return checksum;
	}

}