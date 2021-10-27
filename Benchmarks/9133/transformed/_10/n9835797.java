class n9835797 {
	public static void loadFile(final URL url, final StringBuffer buffer) throws IOException {
		BufferedReader dis = null;
		InputStream in = null;
		try {
			in = url.openStream();
			int i;
			dis = new BufferedReader(new InputStreamReader(in));
			while ((i = dis.read()) != -1) {
				buffer.append((char) i);
			}
		} finally {
			closeStream(in);
			closeReader(dis);
		}
	}

}