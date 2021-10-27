class n16850376 {
	public static void uncompress(File srcFile, File destFile) throws IOException {
		OutputStream output = null;
		InputStream input = null;
		try {
			output = new BufferedOutputStream(new FileOutputStream(destFile));
			input = new GZIPInputStream(new FileInputStream(srcFile));
			IOUtils.copyLarge(input, output);
		} finally {
			IOUtils.closeQuietly(output);
			IOUtils.closeQuietly(input);
		}
	}

}