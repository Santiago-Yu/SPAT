class n23677118 {
	public static void copyFile5(File srcFile, File destFile) throws IOException {
		OutputStream out = new FileOutputStream(destFile);
		InputStream in = new FileInputStream(srcFile);
		IOUtils.copyLarge(in, out);
		in.close();
		out.close();
	}

}