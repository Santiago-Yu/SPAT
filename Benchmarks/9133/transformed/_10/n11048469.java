class n11048469 {
	public static String getContents(String urlStr) throws Exception {
		URL url = new URL(urlStr);
		String contents = "";
		final char[] buffer = new char[1024 * 1024];
		URLConnection openConnection = url.openConnection();
		Reader in = new InputStreamReader(openConnection.getInputStream(), "UTF-8");
		StringBuilder out = new StringBuilder();
		int read;
		do {
			read = in.read(buffer, 0, buffer.length);
			if (read > 0) {
				out.append(buffer, 0, read);
			}
		} while (read >= 0);
		contents = out.toString();
		return contents;
	}

}