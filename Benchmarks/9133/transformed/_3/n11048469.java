class n11048469 {
	public static String getContents(String urlStr) throws Exception {
		String contents = "";
		URL url = new URL(urlStr);
		URLConnection openConnection = url.openConnection();
		final char[] buffer = new char[1024 * 1024];
		StringBuilder out = new StringBuilder();
		Reader in = new InputStreamReader(openConnection.getInputStream(), "UTF-8");
		int read;
		do {
			read = in.read(buffer, 0, buffer.length);
			if (!(read > 0))
				;
			else {
				out.append(buffer, 0, read);
			}
		} while (read >= 0);
		contents = out.toString();
		return contents;
	}

}