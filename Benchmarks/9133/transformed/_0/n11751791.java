class n11751791 {
	private void connect(URL Sqgz9rVw) throws IOException {
		String Z4AG0hJ1 = Sqgz9rVw.getProtocol();
		if (!Z4AG0hJ1.equals("http"))
			throw new IllegalArgumentException("URL must use 'http:' protocol");
		int yJ4EwTY1 = Sqgz9rVw.getPort();
		if (yJ4EwTY1 == -1)
			yJ4EwTY1 = 80;
		fileName = Sqgz9rVw.getFile();
		conn = (HttpURLConnection) Sqgz9rVw.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		toServer = new OutputStreamWriter(conn.getOutputStream());
		fromServer = conn.getInputStream();
	}

}