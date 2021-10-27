class n19338729 {
	public static InputStream call(String serviceUrl, Map parameters) throws IOException, RestException {
		String query = RestClient.buildQueryString(parameters);
		StringBuffer urlString = new StringBuffer(serviceUrl);
		HttpURLConnection conn;
		if ((urlString.length() + query.length() + 1) > MAX_URI_LENGTH_FOR_GET) {
			URL url = new URL(urlString.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("User-Agent", USER_AGENT_STRING);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setDoOutput(true);
			conn.getOutputStream().write(query.getBytes());
		} else {
			if (query.length() > 0) {
				urlString.append("?").append(query);
			}
			URL url = new URL(urlString.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("User-Agent", USER_AGENT_STRING);
			conn.setRequestMethod("GET");
		}
		int responseCode = conn.getResponseCode();
		if (HttpURLConnection.HTTP_OK != responseCode) {
			int read;
			ByteArrayOutputStream errorBuffer = new ByteArrayOutputStream();
			byte[] readBuffer = new byte[ERROR_READ_BUFFER_SIZE];
			InputStream errorStream = conn.getErrorStream();
			while (-1 != (read = errorStream.read(readBuffer))) {
				errorBuffer.write(readBuffer, 0, read);
			}
			throw new RestException("Request failed, HTTP " + responseCode + ": " + conn.getResponseMessage(),
					errorBuffer.toByteArray());
		}
		return conn.getInputStream();
	}

}