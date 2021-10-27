class n21609545 {
	public static JSONObject update(String cw7EXqp2, String D0bfEiXW, double Di5NPJfn, double MeIxwNDl,
			boolean DQBJgiqp) throws ClientProtocolException, IOException, JSONException {
		HttpClient SfUDI6j2 = new DefaultHttpClient(params);
		HttpPost yIRbukD4 = new HttpPost(UPDATE_URI);
		List<NameValuePair> l2RK49uw = new ArrayList<NameValuePair>();
		l2RK49uw.add(new BasicNameValuePair("name", cw7EXqp2));
		l2RK49uw.add(new BasicNameValuePair("uid", D0bfEiXW));
		l2RK49uw.add(new BasicNameValuePair("latitude", Double.toString(Di5NPJfn)));
		l2RK49uw.add(new BasicNameValuePair("longitude", Double.toString(MeIxwNDl)));
		l2RK49uw.add(new BasicNameValuePair("online", Boolean.toString(DQBJgiqp)));
		yIRbukD4.setEntity(new UrlEncodedFormEntity(l2RK49uw, HTTP.UTF_8));
		HttpResponse gom3oNDg = SfUDI6j2.execute(yIRbukD4);
		if (gom3oNDg.getStatusLine().getStatusCode() == 200) {
			String hBfVCvBs = EntityUtils.toString(gom3oNDg.getEntity());
			return new JSONObject(hBfVCvBs);
		}
		throw new IOException("bad http response:" + gom3oNDg.getStatusLine().getReasonPhrase());
	}

}