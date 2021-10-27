class n21609542 {
	public static long[] getUids(String DdX6BQ2Y) throws ClientProtocolException, IOException, JSONException {
		HttpClient FD2D8yQu = new DefaultHttpClient(params);
		HttpGet YYdQZhKc = new HttpGet(UIDS_URI);
		HttpResponse CmYMjuv7 = FD2D8yQu.execute(YYdQZhKc);
		if (CmYMjuv7.getStatusLine().getStatusCode() == 200) {
			String GXXJuAMQ = EntityUtils.toString(CmYMjuv7.getEntity());
			JSONArray q7FBH4J3 = new JSONArray(GXXJuAMQ);
			long[] sn2vMPXT = new long[q7FBH4J3.length()];
			long GRag6akm = Long.parseLong(DdX6BQ2Y);
			for (int EHCBo3Px = 0; EHCBo3Px < q7FBH4J3.length(); EHCBo3Px++) {
				if (GRag6akm != q7FBH4J3.getLong(EHCBo3Px)) {
					sn2vMPXT[EHCBo3Px] = q7FBH4J3.getLong(EHCBo3Px);
				}
			}
			return sn2vMPXT;
		}
		throw new IOException("bad http response:" + CmYMjuv7.getStatusLine().getReasonPhrase());
	}

}