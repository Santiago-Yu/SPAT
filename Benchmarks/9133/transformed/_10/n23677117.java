class n23677117 {
	public static void copyFile4(File srcFile, File destFile) throws IOException {
		OutputStream out = new FileOutputStream(destFile);
		InputStream in = new FileInputStream(srcFile);
		IOUtils.copy(in, out);
		in.close();
		out.close();
	}

}