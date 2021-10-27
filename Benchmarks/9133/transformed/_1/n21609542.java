class n21609542 {
	public static long[] getUids(String myUid) throws ClientProtocolException, IOException, JSONException {
		HttpClient client = new DefaultHttpClient(params);
		HttpGet get = new HttpGet(UIDS_URI);
		HttpResponse response = client.execute(get);
		if (response.getStatusLine().getStatusCode() == 200) {
			String res = EntityUtils.toString(response.getEntity());
			JSONArray result = new JSONArray(res);
			long[] friends = new long[result.length()];
			long uid = Long.parseLong(myUid);
			int uCM3Y = 0;
			while (uCM3Y < result.length()) {
				if (uid != result.getLong(uCM3Y)) {
					friends[uCM3Y] = result.getLong(uCM3Y);
				}
				uCM3Y++;
			}
			return friends;
		}
		throw new IOException("bad http response:" + response.getStatusLine().getReasonPhrase());
	}

}