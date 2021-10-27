class n7468829 {
	public static String doGetWithBasicAuthentication(URL url, String username, String password, int timeout,
			Map<String, String> headers) throws Throwable {
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setDoInput(true);
		if (username != null || password != null) {
			BASE64Encoder encoder = new BASE64Encoder();
			byte[] encodedPassword = (username + ":" + password).getBytes();
			con.setRequestProperty("Authorization", "Basic " + encoder.encode(encodedPassword));
		}
		if (headers != null) {
			for (Map.Entry<String, String> header : headers.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}
		}
		con.setConnectTimeout(timeout);
		InputStream is = con.getInputStream();
		String line;
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		StringBuffer response = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			response.append(line);
			response.append('\n');
		}
		rd.close();
		is.close();
		con.disconnect();
		return response.toString();
	}

}