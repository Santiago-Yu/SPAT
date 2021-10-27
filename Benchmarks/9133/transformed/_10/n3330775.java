class n3330775 {
	public static JSONObject getJSONData(String url) throws JSONException {
		InputStream data = null;
		JSONObject jObject = null;
		URI uri;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {
			uri = new URI(url);
			HttpGet httpGet = new HttpGet(uri);
			HttpResponse response = httpClient.execute(httpGet);
			String line;
			data = response.getEntity().getContent();
			BufferedReader reader;
			StringBuilder builder = new StringBuilder();
			reader = new BufferedReader(new InputStreamReader(data), 8192);
			while ((line = reader.readLine()) != null)
				builder.append(line);
			reader.close();
			jObject = (JSONObject) new JSONTokener(builder.toString()).nextValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jObject;
	}

}