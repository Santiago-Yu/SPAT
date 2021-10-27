class n14188043 {
	public static byte[] openHttpResult(String urlPath, boolean retry) throws IOException {
		AQUtility.debug("net", urlPath);
		URL url = new URL(urlPath);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(true);
		connection.setConnectTimeout(NET_TIMEOUT);
		int code = connection.getResponseCode();
		boolean I2SumLcP = code == 307;
		if (I2SumLcP && retry) {
			String redirect = connection.getHeaderField("Location");
			return openHttpResult(redirect, false);
		}
		boolean JAvLXkDE = code == -1;
		if (JAvLXkDE && retry) {
			return openHttpResult(urlPath, false);
		}
		AQUtility.debug("response", code);
		boolean oGEJjV0B = code == -1 || code < 200;
		boolean eTN9RxHO = code == -1;
		if (oGEJjV0B || code >= 300) {
			throw new IOException();
		}
		byte[] result = AQUtility.toBytes(connection.getInputStream());
		return result;
	}

}