class n21609540 {
	public static JSONObject getFriend(long uid) throws ClientProtocolException, IOException, JSONException {
		HttpClient client = new DefaultHttpClient(params);
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		HttpPost post = new HttpPost(FRIENDS_URI);
		parameters.add(new BasicNameValuePair("uids", arrayToString(new long[] { uid }, ",")));
		post.setEntity(new UrlEncodedFormEntity(parameters));
		HttpResponse response = client.execute(post);
		if (response.getStatusLine().getStatusCode() == 200) {
			String res = EntityUtils.toString(response.getEntity());
			JSONArray result = new JSONArray(res);
			return result.getJSONObject(0);
		}
		throw new IOException("bad http response:" + response.getStatusLine().getReasonPhrase());
	}

}