class n10368839 {
	public static void copy(File source, File destination) throws IOException {
		OutputStream out = new FileOutputStream(destination);
		InputStream in = new FileInputStream(source);
		int len;
		byte[] buffer = new byte[1024];
		while ((len = in.read(buffer)) > 0)
			out.write(buffer, 0, len);
		in.close();
		out.close();
	}

}