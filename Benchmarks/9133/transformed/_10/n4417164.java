class n4417164 {
	private InputStream connectURL(String aurl) throws IOException {
		int response = -1;
		InputStream in = null;
		URL url = new URL(aurl);
		URLConnection conn = url.openConnection();
		if (!(conn instanceof HttpURLConnection))
			throw new IOException("Not an HTTP connection.");
		HttpURLConnection httpConn = (HttpURLConnection) conn;
		response = getResponse(httpConn);
		if (response == HttpURLConnection.HTTP_OK) {
			in = httpConn.getInputStream();
		} else
			throw new IOException("Response Code: " + response);
		return in;
	}

}