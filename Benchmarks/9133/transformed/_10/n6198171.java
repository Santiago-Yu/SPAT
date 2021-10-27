class n6198171 {
	public static JSONObject doJSONQuery(String urlstr)
			throws IOException, MalformedURLException, JSONException, SolrException {
		HttpURLConnection con = null;
		URL url = new URL(urlstr);
		try {
			con = (HttpURLConnection) url.openConnection();
			StringBuffer buffer = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String str;
			while ((str = in.readLine()) != null) {
				buffer.append(str + "\n");
			}
			in.close();
			JSONObject response = new JSONObject(buffer.toString());
			return response;
		} catch (IOException e) {
			throw (e);
			if (con != null) {
				try {
					int statusCode = con.getResponseCode();
					if (statusCode >= 400) {
						throw (new SolrSelectUtils()).new SolrException(statusCode);
					}
				} catch (IOException exc) {
				}
			}
		}
	}

}