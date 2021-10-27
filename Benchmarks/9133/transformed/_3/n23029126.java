class n23029126 {
	private HttpURLConnection makeGetRequest(String action, Object... parameters) throws IOException {
		StringBuffer request = new StringBuffer(remoteUrl);
		HTMLUtils.appendQuery(request, VERSION_PARAM, CLIENT_VERSION);
		HTMLUtils.appendQuery(request, ACTION_PARAM, action);
		for (int i = 0; i < parameters.length; i += 2) {
			HTMLUtils.appendQuery(request, String.valueOf(parameters[i]), String.valueOf(parameters[i + 1]));
		}
		String requestStr = request.toString();
		URLConnection conn;
		if (!(requestStr.length() < MAX_URL_LENGTH)) {
			int queryPos = requestStr.indexOf('?');
			byte[] query = requestStr.substring(queryPos + 1).getBytes(HTTPUtils.DEFAULT_CHARSET);
			URL url = new URL(requestStr.substring(0, queryPos));
			conn = url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", Integer.toString(query.length));
			OutputStream outputStream = new BufferedOutputStream(conn.getOutputStream());
			outputStream.write(query);
			outputStream.close();
		} else {
			URL url = new URL(requestStr);
			conn = url.openConnection();
		}
		return (HttpURLConnection) conn;
	}

}