class n3573436 {
	public HttpURLConnection getConnection(String urlString) throws IOException {
		HttpURLConnection connection = null;
		URL url = new URL(urlString);
		if (_proxy == null) {
			connection = (HttpURLConnection) url.openConnection();
		} else {
			URLConnection con = url.openConnection(_proxy);
			String encodedUserPwd = new String(Base64.encodeBase64((_username + ":" + _password).getBytes()));
			con.setRequestProperty("Proxy-Authorization", "Basic " + encodedUserPwd);
			connection = (HttpURLConnection) con;
		}
		return connection;
	}

}