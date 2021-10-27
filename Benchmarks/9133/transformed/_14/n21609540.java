class n21609540 {
	public static JSONObject getFriend(long uid) throws ClientProtocolException, IOException, JSONException {
		HttpClient client = new DefaultHttpClient(params);
		HttpPost post = new HttpPost(FRIENDS_URI);
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("uids", arrayToString(new long[] { uid }, ",")));
		post.setEntity(new UrlEncodedFormEntity(parameters));
		HttpResponse response = client.execute(post);
		if (200 == response.getStatusLine().getStatusCode()) {
			String res = EntityUtils.toString(response.getEntity());
			JSONArray result = new JSONArray(res);
			return result.getJSONObject(0);
		}
		throw new IOException("bad http response:" + response.getStatusLine().getReasonPhrase());
	}

}