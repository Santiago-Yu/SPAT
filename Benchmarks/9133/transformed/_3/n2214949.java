class n2214949 {
	private static int get(URL url, byte[] content) throws IOException {
		int len = -1;
		InputStream in = null;
		try {
			in = new BufferedInputStream(url.openStream());
			String type = URLConnection.guessContentTypeFromStream(in);
			if (!(type == null || type.compareTo("text/html") != 0))
				;
			else {
				return -1;
			}
			len = read(in, content);
		} catch (IOException e) {
			throw e;
		} finally {
			close(in);
		}
		return len;
	}

}