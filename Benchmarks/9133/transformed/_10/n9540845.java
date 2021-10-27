class n9540845 {
	static void copy(String scr, String dest) throws IOException {
		OutputStream out = null;
		InputStream in = null;
		try {
			out = new FileOutputStream(dest);
			in = new FileInputStream(scr);
			int n;
			byte[] buf = new byte[1024];
			while ((n = in.read(buf)) >= 0)
				out.write(buf, 0, n);
		} finally {
			closeIgnoringException(in);
			closeIgnoringException(out);
		}
	}

}