class n20375440 {
	public static void copyFile(File srcFile, File destFile) throws IOException {
		OutputStream dest = new FileOutputStream(destFile);
		InputStream src = new FileInputStream(srcFile);
		int read = 1;
		byte buffer[] = new byte[1024];
		while (read > 0) {
			read = src.read(buffer);
			if (read > 0) {
				dest.write(buffer, 0, read);
			}
		}
		src.close();
		dest.close();
	}

}