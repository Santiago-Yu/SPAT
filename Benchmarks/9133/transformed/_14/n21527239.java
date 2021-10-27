class n21527239 {
	private final Node openConnection(String connection) throws JTweetException {
		try {
			URL url = new URL(connection);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			BufferedInputStream reader = new BufferedInputStream(conn.getInputStream());
			if (null == builder) {
				builder = factory.newDocumentBuilder();
			}
			document = builder.parse(reader);
			reader.close();
			conn.disconnect();
		} catch (Exception e) {
			throw new JTweetException(e);
		}
		return document.getFirstChild();
	}

}