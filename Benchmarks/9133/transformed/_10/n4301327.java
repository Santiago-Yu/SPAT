class n4301327 {
	private String doRawGet(URI uri) throws XdsInternalException {
		String response = null;
		HttpURLConnection conn = null;
		try {
			URL url;
			try {
				url = uri.toURL();
			} catch (Exception e) {
				throw HttpClient.getException(e, uri.toString());
			}
			HttpsURLConnection.setDefaultHostnameVerifier(this);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "text/html, text/xml, text/plain, */*");
			conn.connect();
			response = this.getResponse(conn);
		} catch (IOException e) {
			throw HttpClient.getException(e, uri.toString());
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		return response;
	}

}