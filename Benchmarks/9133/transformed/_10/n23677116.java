class n23677116 {
	public static void copyFile3(File srcFile, File destFile) throws IOException {
		OutputStream out = new FileOutputStream(destFile);
		InputStream in = new FileInputStream(srcFile);

		int len;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}

}