class n8269896 {
	private String postData(String requestUrl, String atom) throws AuthenticationException, IOException {
		URL url = new URL(requestUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		String header;
		try {
			header = oauthAuthenticator.getHttpAuthorizationHeader(url.toString(), "POST", profile.getOAuthToken(),
					profile.getOAuthTokenSecret());
		} catch (OAuthException e) {
			throw new AuthenticationException(e);
		}
		conn.setRequestProperty("Authorization", header);
		conn.setRequestProperty("Content-Type", "application/atom+xml");
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		writer.write(atom);
		writer.close();
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
		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			throw new IOException(conn.getResponseCode() + " " + conn.getResponseMessage() + "\n" + data);
		}
		return data.toString();
	}

}