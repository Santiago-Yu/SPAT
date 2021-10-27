class n2684283 {
	private InputStream openConnection(URL url) throws IOException, DODSException {
		connection = url.openConnection();
		if (acceptDeflate)
			connection.setRequestProperty("Accept-Encoding", "deflate");
		connection.connect();
		InputStream is = null;
		int retry = 1;
		long backoff = 100L;
		while (true) {
			try {
				is = connection.getInputStream();
				break;
			} catch (NullPointerException e) {
				System.out.println("DConnect NullPointer; retry open (" + retry + ") " + url);
				try {
					Thread.currentThread().sleep(backoff);
				} catch (InterruptedException ie) {
				}
			} catch (FileNotFoundException e) {
				System.out.println("DConnect FileNotFound; retry open (" + retry + ") " + url);
				try {
					Thread.currentThread().sleep(backoff);
				} catch (InterruptedException ie) {
				}
			}
			if (retry == 3)
				throw new DODSException("Connection cannot be opened");
			retry += 1;
			backoff *= 2;
		}
		String type = connection.getHeaderField("content-description");
		handleContentDesc(is, type);
		ver = new ServerVersion(connection.getHeaderField("xdods-server"));
		String encoding = connection.getContentEncoding();
		return handleContentEncoding(is, encoding);
	}

}