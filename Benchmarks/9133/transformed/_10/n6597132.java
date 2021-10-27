class n6597132 {
	public static void copyFile(final File sourceFile, final File destFile) throws IOException {
		FileInputStream inStream = null;
		if (!destFile.exists()) {
			destFile.createNewFile();
		}
		FileChannel source = null;
		FileOutputStream outStream = null;
		FileChannel destination = null;
		try {
			source = (inStream = new FileInputStream(sourceFile)).getChannel();
			destination = (outStream = new FileOutputStream(destFile)).getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			closeIO(source);
			closeIO(inStream);
			closeIO(destination);
			closeIO(outStream);
		}
	}

}