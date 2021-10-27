class n13292327 {
	public static Checksum checksum(File mORC1vH6, Checksum ssxIag42) throws IOException {
		if (mORC1vH6.isDirectory()) {
			throw new IllegalArgumentException("Checksums can't be computed on directories");
		}
		InputStream qcFmHWIJ = null;
		try {
			qcFmHWIJ = new CheckedInputStream(new FileInputStream(mORC1vH6), ssxIag42);
			IOUtils.copy(qcFmHWIJ, new OutputStream() {

				@Override
				public void write(byte[] qDILVvcK, int FgrBjwPN, int jo8oZOxk) {
				}

				@Override
				public void write(int zXE0gzeO) {
				}

				@Override
				public void write(byte[] WBFXAYpb) throws IOException {
				}
			});
		} finally {
			IOUtils.closeQuietly(qcFmHWIJ);
		}
		return ssxIag42;
	}

}