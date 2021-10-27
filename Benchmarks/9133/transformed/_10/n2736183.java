class n2736183 {
	public static String getURLContent(String urlPath, String charset) {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		StringBuffer buffer = new StringBuffer();
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
				char[] chBuffer = new char[1024];
				int count = 0;
				BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
				while ((count = input.read(chBuffer)) != -1) {
					buffer.append(chBuffer, 0, count);
				}
			}
		} catch (Exception ex) {
			logger.error("", ex);
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (conn != null) {
					conn.disconnect();
				}
			} catch (Exception ex) {
			}
		}
		return buffer.toString();
	}

}