class n19758418 {
	public static String post(String strUrl, String data) throws Exception {
		URL url = new URL(strUrl);
		final String method = "POST", host = url.getHost();
		final String contentType = "application/x-www-form-urlencoded";
		final int contentLength = getContentLength(data);
		final String encoding = "UTF-8", connection = "Close";
		Config.log(DEBUG,
				"Sending data to: " + url + " (host=" + host + ", encoding=" + encoding + ", method=" + method
						+ ", Content-Type=" + contentType + ", Content-Length=" + contentLength + ", Connection="
						+ connection + "):" + "\r\n" + data);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod(method);
		conn.setRequestProperty("host", host);
		conn.setRequestProperty("content-type", contentType);
		conn.setRequestProperty("Content-Encoding", encoding);
		conn.setRequestProperty("content-length", contentLength + "");
		conn.setRequestProperty("connection", connection);
		if (tools.valid(Config.JSON_RPC_WEBSERVER_USERNAME) && tools.valid(Config.JSON_RPC_WEBSERVER_PASSWORD)) {
			String authString = Config.JSON_RPC_WEBSERVER_USERNAME + ":" + Config.JSON_RPC_WEBSERVER_PASSWORD;
			String authStringEnc = new sun.misc.BASE64Encoder().encode(authString.getBytes());
			conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
		}
		conn.setReadTimeout((int) (Config.JSON_RPC_TIMEOUT_SECONDS * 1000));
		OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
		writer.write(data);
		writer.flush();
		writer.close();
		int responseCode = 400;
		try {
			responseCode = conn.getResponseCode();
		} catch (Exception x) {
			Config.log(ERROR, "Failed to get response code from HTTP Server. Check your URL and username/password.", x);
		}
		String response = readStream(responseCode == 200 ? conn.getInputStream() : conn.getErrorStream());
		if (response == null) {
			return null;
		}
		Config.log(DEBUG, "Raw response from POST. Response Code = " + conn.getResponseCode() + " ("
				+ conn.getResponseMessage() + "):\r\n" + response);
		return response.toString();
	}

}