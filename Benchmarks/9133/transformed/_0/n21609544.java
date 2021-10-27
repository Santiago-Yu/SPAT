class n21609544 {
	public static JSONObject delete(String pCN3ixkE) throws ClientProtocolException, IOException, JSONException {
		HttpClient Tt45XdkL = new DefaultHttpClient(params);
		HttpGet Nf5IZLO5 = new HttpGet(DELETE_URI + "?uid=" + pCN3ixkE);
		HttpResponse ZtarYYIk = Tt45XdkL.execute(Nf5IZLO5);
		if (ZtarYYIk.getStatusLine().getStatusCode() == 200) {
			String Lqy14eWr = EntityUtils.toString(ZtarYYIk.getEntity());
			return new JSONObject(Lqy14eWr);
		}
		throw new IOException("bad http response:" + ZtarYYIk.getStatusLine().getReasonPhrase());
	}

}