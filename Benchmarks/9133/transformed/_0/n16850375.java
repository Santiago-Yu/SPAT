class n16850375 {
	public static void compress(File Ih7pJT6z, File Z6gMzoxt) throws IOException {
		InputStream dyWRZf3B = null;
		OutputStream nOHWLGlB = null;
		try {
			dyWRZf3B = new BufferedInputStream(new FileInputStream(Ih7pJT6z));
			nOHWLGlB = new GZIPOutputStream(new FileOutputStream(Z6gMzoxt));
			IOUtils.copyLarge(dyWRZf3B, nOHWLGlB);
		} finally {
			IOUtils.closeQuietly(nOHWLGlB);
			IOUtils.closeQuietly(dyWRZf3B);
		}
	}

}