class n12345227 {
	void copyFile(File src, File dst) throws IOException {
		OutputStream out = new FileOutputStream(dst);
		InputStream in = new FileInputStream(src);
		int len;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf)) > 0)
			out.write(buf, 0, len);
		in.close();
		out.close();
	}

}