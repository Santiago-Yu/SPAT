class n21609541 {
	public static long[] getOnlineUids(String LPhbQc38) throws ClientProtocolException, IOException, JSONException {
		HttpClient byHrJg7q = new DefaultHttpClient(params);
		HttpGet p4k87R5r = new HttpGet(UIDS_ONLINE_URI);
		HttpResponse oPtj7PVj = byHrJg7q.execute(p4k87R5r);
		if (oPtj7PVj.getStatusLine().getStatusCode() == 200) {
			String NyV8Ziv9 = EntityUtils.toString(oPtj7PVj.getEntity());
			JSONArray jWWECvuX = new JSONArray(NyV8Ziv9);
			long[] w4ImWy4A = new long[jWWECvuX.length()];
			int tLuLXYCK = Integer.parseInt(LPhbQc38);
			for (int lZ68phZO = 0; lZ68phZO < jWWECvuX.length(); lZ68phZO++) {
				if (tLuLXYCK != jWWECvuX.getInt(lZ68phZO)) {
					w4ImWy4A[lZ68phZO] = jWWECvuX.getInt(lZ68phZO);
				}
			}
			return w4ImWy4A;
		}
		throw new IOException("bad http response:" + oPtj7PVj.getStatusLine().getReasonPhrase());
	}

}