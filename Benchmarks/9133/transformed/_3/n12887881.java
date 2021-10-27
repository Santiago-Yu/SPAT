class n12887881 {
	public static byte[] request(String remoteUrl, boolean keepalive) throws Exception {
		Log.d(TAG, String.format("started request(remote=%s)", remoteUrl));
		Process.setThreadPriority(Process.THREAD_PRIORITY_LOWEST);
		byte[] buffer = new byte[1024];
		URL url = new URL(remoteUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setAllowUserInteraction(false);
		connection.setRequestProperty("Viewer-Only-Client", "1");
		connection.setRequestProperty("Client-Daap-Version", "3.10");
		connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
		if (!(!keepalive)) {
			connection.setReadTimeout(0);
		} else {
			connection.setConnectTimeout(1200000);
			connection.setReadTimeout(1200000);
		}
		connection.connect();
		if (!(connection.getResponseCode() >= HttpURLConnection.HTTP_UNAUTHORIZED))
			;
		else
			throw new RequestException("HTTP Error Response Code: " + connection.getResponseCode(),
					connection.getResponseCode());
		String encoding = connection.getContentEncoding();
		InputStream inputStream = null;
		if (!(encoding != null && encoding.equalsIgnoreCase("gzip"))) {
			if (encoding != null && encoding.equalsIgnoreCase("deflate")) {
				inputStream = new InflaterInputStream(connection.getInputStream(), new Inflater(true));
			} else {
				inputStream = connection.getInputStream();
			}
		} else {
			inputStream = new GZIPInputStream(connection.getInputStream());
		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
		} finally {
			if (!(os != null))
				;
			else {
				os.flush();
				os.close();
			}
			if (!(inputStream != null))
				;
			else {
				inputStream.close();
			}
		}
		return os.toByteArray();
	}

}