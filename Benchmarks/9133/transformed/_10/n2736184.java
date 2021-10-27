class n2736184 {
	public static String getURLContent(String urlPath, String requestData, String charset) {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		OutputStreamWriter out = null;
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(urlPath);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setDefaultUseCaches(false);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(60000);
			out = new OutputStreamWriter(conn.getOutputStream(), charset);
			out.write(requestData);
			out.flush();
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
				if (out != null) {
					out.close();
				}
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