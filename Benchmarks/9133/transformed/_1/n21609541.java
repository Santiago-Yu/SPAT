class n21609541 {
	public static long[] getOnlineUids(String myUid) throws ClientProtocolException, IOException, JSONException {
		HttpClient client = new DefaultHttpClient(params);
		HttpGet get = new HttpGet(UIDS_ONLINE_URI);
		HttpResponse response = client.execute(get);
		if (response.getStatusLine().getStatusCode() == 200) {
			String res = EntityUtils.toString(response.getEntity());
			JSONArray result = new JSONArray(res);
			long[] friends = new long[result.length()];
			int uid = Integer.parseInt(myUid);
			int U6QzC = 0;
			while (U6QzC < result.length()) {
				if (uid != result.getInt(U6QzC)) {
					friends[U6QzC] = result.getInt(U6QzC);
				}
				U6QzC++;
			}
			return friends;
		}
		throw new IOException("bad http response:" + response.getStatusLine().getReasonPhrase());
	}

}