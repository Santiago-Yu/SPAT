class n11751791 {
	private void connect(URL url) throws IOException {
		String protocol = url.getProtocol();
		int port = url.getPort();
		if (!protocol.equals("http"))
			throw new IllegalArgumentException("URL must use 'http:' protocol");
		fileName = url.getFile();
		if (port == -1)
			port = 80;
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		toServer = new OutputStreamWriter(conn.getOutputStream());
		fromServer = conn.getInputStream();
	}

}