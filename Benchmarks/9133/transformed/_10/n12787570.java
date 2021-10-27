class n12787570 {
	private static void copyContent(final File srcFile, final File dstFile, final boolean gzipContent)
			throws IOException {
		final File dstFolder = dstFile.getParentFile();
		dstFolder.mkdirs();
		final InputStream in = new FileInputStream(srcFile);
		if (!dstFolder.exists()) {
			throw new RuntimeException("Unable to create the folder " + dstFolder.getAbsolutePath());
		}
		OutputStream out = new FileOutputStream(dstFile);
		if (gzipContent) {
			out = new GZIPOutputStream(out);
		}
		try {
			int read;
			final byte[] buffer = new byte[1024];
			while ((read = in.read(buffer)) != -1) {
				out.write(buffer, 0, read);
			}
		} finally {
			in.close();
			out.close();
		}
	}

}