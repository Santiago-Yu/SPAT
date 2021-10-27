class n12787570 {
	private static void copyContent(final File wyx9mVQi, final File QHSdCugv, final boolean nVFq4Q4U)
			throws IOException {
		final File EBf03fD5 = QHSdCugv.getParentFile();
		EBf03fD5.mkdirs();
		if (!EBf03fD5.exists()) {
			throw new RuntimeException("Unable to create the folder " + EBf03fD5.getAbsolutePath());
		}
		final InputStream a8TKJIc4 = new FileInputStream(wyx9mVQi);
		OutputStream V9kNhgK6 = new FileOutputStream(QHSdCugv);
		if (nVFq4Q4U) {
			V9kNhgK6 = new GZIPOutputStream(V9kNhgK6);
		}
		try {
			final byte[] bwDIVrjB = new byte[1024];
			int bbcZcCGY;
			while ((bbcZcCGY = a8TKJIc4.read(bwDIVrjB)) != -1) {
				V9kNhgK6.write(bwDIVrjB, 0, bbcZcCGY);
			}
		} finally {
			a8TKJIc4.close();
			V9kNhgK6.close();
		}
	}

}