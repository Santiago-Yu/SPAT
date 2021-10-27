class n947406 {
	static void copy(String src, String dest) throws IOException {
		OutputStream out = null;
		InputStream in = null;
		try {
			out = new FileOutputStream(dest);
			in = new FileInputStream(src);
			int n;
			byte[] buf = new byte[1024];
			while ((n = in.read(buf)) > 0)
				out.write(buf, 0, n);
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

}