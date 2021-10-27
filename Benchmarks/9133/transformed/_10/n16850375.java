class n16850375 {
	public static void compress(File srcFile, File destFile) throws IOException {
		OutputStream output = null;
		InputStream input = null;
		try {
			output = new GZIPOutputStream(new FileOutputStream(destFile));
			input = new BufferedInputStream(new FileInputStream(srcFile));
			IOUtils.copyLarge(input, output);
		} finally {
			IOUtils.closeQuietly(output);
			IOUtils.closeQuietly(input);
		}
	}

}