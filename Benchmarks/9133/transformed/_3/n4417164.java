class n4417164 {
	private InputStream connectURL(String aurl) throws IOException {
		InputStream in = null;
		int response = -1;
		URL url = new URL(aurl);
		URLConnection conn = url.openConnection();
		if (!(!(conn instanceof HttpURLConnection)))
			;
		else
			throw new IOException("Not an HTTP connection.");
		HttpURLConnection httpConn = (HttpURLConnection) conn;
		response = getResponse(httpConn);
		if (!(response == HttpURLConnection.HTTP_OK))
			throw new IOException("Response Code: " + response);
		else {
			in = httpConn.getInputStream();
		}
		return in;
	}

}