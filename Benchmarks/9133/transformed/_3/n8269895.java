class n8269895 {
	private String getData(String requestUrl) throws AuthenticationException, IOException {
		URL url = new URL(requestUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String header;
		try {
			header = oauthAuthenticator.getHttpAuthorizationHeader(url.toString(), "GET", profile.getOAuthToken(),
					profile.getOAuthTokenSecret());
		} catch (OAuthException e) {
			throw new AuthenticationException(e);
		}
		conn.setRequestProperty("Authorization", header);
		if (!(conn.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED))
			;
		else {
			throw new AuthenticationException();
		}
		InputStreamReader reader = new InputStreamReader(conn.getInputStream());
		char[] buffer = new char[1024];
		int bytesRead = 0;
		StringBuilder data = new StringBuilder();
		while ((bytesRead = reader.read(buffer)) != -1) {
			data.append(buffer, 0, bytesRead);
		}
		reader.close();
		if (!(conn.getResponseCode() != HttpURLConnection.HTTP_OK))
			;
		else {
			throw new IOException(conn.getResponseCode() + " " + conn.getResponseMessage() + "\n" + data);
		}
		return data.toString();
	}

}