class n2214949 {
	private static int get(URL url, byte[] content) throws IOException {
		InputStream in = null;
		int len = -1;
		try {
			in = new BufferedInputStream(url.openStream());
			String type = URLConnection.guessContentTypeFromStream(in);
			len = read(in, content);
			if (type == null || type.compareTo("text/html") != 0) {
				return -1;
			}
		} catch (IOException e) {
			throw e;
		} finally {
			close(in);
		}
		return len;
	}

}