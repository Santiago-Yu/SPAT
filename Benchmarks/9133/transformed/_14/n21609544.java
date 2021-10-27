class n21609544 {
	public static JSONObject delete(String uid) throws ClientProtocolException, IOException, JSONException {
		HttpClient client = new DefaultHttpClient(params);
		HttpGet get = new HttpGet(DELETE_URI + "?uid=" + uid);
		HttpResponse response = client.execute(get);
		if (200 == response.getStatusLine().getStatusCode()) {
			String res = EntityUtils.toString(response.getEntity());
			return new JSONObject(res);
		}
		throw new IOException("bad http response:" + response.getStatusLine().getReasonPhrase());
	}

}