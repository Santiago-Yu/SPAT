class n21609539 {
	public static JSONArray getFriends(long[] uids) throws ClientProtocolException, IOException, JSONException {
		HttpClient client = new DefaultHttpClient(params);
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		HttpPost post = new HttpPost(FRIENDS_URI);
		parameters.add(new BasicNameValuePair("uids", arrayToString(uids, ",")));
		post.setEntity(new UrlEncodedFormEntity(parameters));
		HttpResponse response = client.execute(post);
		if (response.getStatusLine().getStatusCode() == 200) {
			String res = EntityUtils.toString(response.getEntity());
			return new JSONArray(res);
		}
		throw new IOException("bad http response:" + response.getStatusLine().getReasonPhrase());
	}

}