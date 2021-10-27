class n7468828 {
	public static String doGetWithBasicAuthentication(URL url, String username, String password, int timeout)
			throws Throwable {
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setDoInput(true);
		BASE64Encoder encoder = new BASE64Encoder();
		byte[] encodedPassword = (username + ":" + password).getBytes();
		con.setRequestProperty("Authorization", "Basic " + encoder.encode(encodedPassword));
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