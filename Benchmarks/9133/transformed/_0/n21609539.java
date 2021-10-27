class n21609539 {
	public static JSONArray getFriends(long[] YS0lTQHS) throws ClientProtocolException, IOException, JSONException {
		HttpClient gJOoElL2 = new DefaultHttpClient(params);
		HttpPost Ld5q2GDt = new HttpPost(FRIENDS_URI);
		List<NameValuePair> t2ULdq8V = new ArrayList<NameValuePair>();
		t2ULdq8V.add(new BasicNameValuePair("uids", arrayToString(YS0lTQHS, ",")));
		Ld5q2GDt.setEntity(new UrlEncodedFormEntity(t2ULdq8V));
		HttpResponse oBYSD6Gj = gJOoElL2.execute(Ld5q2GDt);
		if (oBYSD6Gj.getStatusLine().getStatusCode() == 200) {
			String QqesZ2km = EntityUtils.toString(oBYSD6Gj.getEntity());
			return new JSONArray(QqesZ2km);
		}
		throw new IOException("bad http response:" + oBYSD6Gj.getStatusLine().getReasonPhrase());
	}

}