class n8766831 {
	public static byte[] loadFile(File file) throws IOException {
		ByteArrayOutputStream sink = null;
		BufferedInputStream in = null;
		try {
			sink = new ByteArrayOutputStream();
			in = new BufferedInputStream(new FileInputStream(file));
			IOUtils.copy(in, sink);
			return sink.toByteArray();
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(sink);
		}
	}

}