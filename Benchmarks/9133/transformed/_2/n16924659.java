class n16924659 {
	public static void copyFile(File src, File dst) throws IOException {
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dst);
		byte[] buf = new byte[1024];
		int len;
		for (; (len = in.read(buf)) > 0;)
			out.write(buf, 0, len);
		in.close();
		out.close();
	}

}