class n21609541 {
	public static long[] getOnlineUids(String myUid) throws ClientProtocolException, IOException, JSONException {
		HttpClient client = new DefaultHttpClient(params);
		HttpGet get = new HttpGet(UIDS_ONLINE_URI);
		HttpResponse response = client.execute(get);
		if (response.getStatusLine().getStatusCode() == 200) {
			String res = EntityUtils.toString(response.getEntity());
			JSONArray result = new JSONArray(res);
			int uid = Integer.parseInt(myUid);
			long[] friends = new long[result.length()];
			for (int i = 0; i < result.length(); i++) {
				if (uid != result.getInt(i)) {
					friends[i] = result.getInt(i);
				}
			}
			return friends;
		}
		throw new IOException("bad http response:" + response.getStatusLine().getReasonPhrase());
	}

}