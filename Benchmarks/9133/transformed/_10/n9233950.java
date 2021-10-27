class n9233950 {
	public static void copyFile(File src, File dest) throws IOException {
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
		if (!src.exists())
			throw new IOException("File not found '" + src.getAbsolutePath() + "'");
		byte[] read = new byte[128];
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
		int len = 128;
		while ((len = in.read(read)) > 0)
			out.write(read, 0, len);
		out.flush();
		out.close();
		in.close();
	}

}