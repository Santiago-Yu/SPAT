class n2736180 {
	public static byte[] getURLContent(String urlPath) {
		InputStream inStream = null;
		HttpURLConnection conn = null;
		byte[] buffer = null;
		try {
			URL url = new URL(urlPath);
			HttpURLConnection.setFollowRedirects(false);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setDefaultUseCaches(false);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(60000);
			conn.connect();
			int repCode = conn.getResponseCode();
			if (repCode == 200) {
				inStream = conn.getInputStream();
				int contentLength = conn.getContentLength();
				buffer = getResponseBody(inStream, contentLength);
			}
		} catch (Exception ex) {
			logger.error("", ex);
		} finally {
			try {
				if (inStream != null) {
					inStream.close();
				}
				if (conn != null) {
					conn.disconnect();
				}
			} catch (Exception ex) {
			}
		}
		return buffer;
	}

}