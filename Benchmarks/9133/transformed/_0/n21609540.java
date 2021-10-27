class n21609540 {
	public static JSONObject getFriend(long gT8HRPcf) throws ClientProtocolException, IOException, JSONException {
		HttpClient tElztCih = new DefaultHttpClient(params);
		HttpPost umQLZN41 = new HttpPost(FRIENDS_URI);
		List<NameValuePair> AymhzQHY = new ArrayList<NameValuePair>();
		AymhzQHY.add(new BasicNameValuePair("uids", arrayToString(new long[] { gT8HRPcf }, ",")));
		umQLZN41.setEntity(new UrlEncodedFormEntity(AymhzQHY));
		HttpResponse ESnAA8eE = tElztCih.execute(umQLZN41);
		if (ESnAA8eE.getStatusLine().getStatusCode() == 200) {
			String fV1onM6X = EntityUtils.toString(ESnAA8eE.getEntity());
			JSONArray pzJ29z5M = new JSONArray(fV1onM6X);
			return pzJ29z5M.getJSONObject(0);
		}
		throw new IOException("bad http response:" + ESnAA8eE.getStatusLine().getReasonPhrase());
	}

}