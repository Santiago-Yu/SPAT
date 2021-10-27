class n8269895 {
	private String getData(String requestUrl) throws AuthenticationException, IOException {
		URL url = new URL(requestUrl);
		String header;
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		try {
			header = oauthAuthenticator.getHttpAuthorizationHeader(url.toString(), "GET", profile.getOAuthToken(),
					profile.getOAuthTokenSecret());
		} catch (OAuthException e) {
			throw new AuthenticationException(e);
		}
		conn.setRequestProperty("Authorization", header);
		if (conn.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
			throw new AuthenticationException();
		}
		char[] buffer = new char[1024];
		InputStreamReader reader = new InputStreamReader(conn.getInputStream());
		StringBuilder data = new StringBuilder();
		int bytesRead = 0;
		while ((bytesRead = reader.read(buffer)) != -1) {
			data.append(buffer, 0, bytesRead);
		}
		reader.close();
		if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new IOException(conn.getResponseCode() + " " + conn.getResponseMessage() + "\n" + data);
		}
		return data.toString();
	}

}