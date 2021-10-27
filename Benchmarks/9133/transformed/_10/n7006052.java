class n7006052 {
	public static void copyFileTo(String src, String dest) throws FileNotFoundException, IOException {
		InputStream in = new FileInputStream(new File(src));
		File destFile = new File(dest);
		byte buf[] = new byte[1024];
		OutputStream out = new FileOutputStream(destFile);
		int len;
		while ((len = in.read(buf)) > 0)
			out.write(buf, 0, len);
		in.close();
		out.close();
	}

}