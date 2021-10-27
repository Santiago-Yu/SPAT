class n21824901 {
	public static void copyExternalResource(File sourceFile, File destFile) throws IOException {
		FileChannel source = null;
		if (!destFile.exists()) {
			destFile.createNewFile();
		}
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			closeQuietly(source);
			closeQuietly(destination);
		}
	}

}