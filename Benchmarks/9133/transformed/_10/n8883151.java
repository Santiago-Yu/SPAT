class n8883151 {
	protected String getTextResponse(String address, boolean ignoreResponseCode) throws Exception {
		URL url = new URL(address);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setUseCaches(false);
		BufferedReader in = null;
		try {
			con.connect();
			if (!ignoreResponseCode) {
				assertEquals(HttpURLConnection.HTTP_OK, con.getResponseCode());
			}
			StringBuilder builder = new StringBuilder();
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				builder.append(inputLine);
			}
			return builder.toString();
		} finally {
			if (in != null) {
				in.close();
			}
			con.disconnect();
		}
	}

}