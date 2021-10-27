class n14188043 {
	public static byte[] openHttpResult(String urlPath, boolean retry) throws IOException {
		AQUtility.debug("net", urlPath);
		URL url = new URL(urlPath);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(true);
		connection.setConnectTimeout(NET_TIMEOUT);
		int code = connection.getResponseCode();
		if (307 == code && retry) {
			String redirect = connection.getHeaderField("Location");
			return openHttpResult(redirect, false);
		}
		if (-1 == code && retry) {
			return openHttpResult(urlPath, false);
		}
		AQUtility.debug("response", code);
		if (-1 == code || code < 200 || code >= 300) {
			throw new IOException();
		}
		byte[] result = AQUtility.toBytes(connection.getInputStream());
		return result;
	}

}