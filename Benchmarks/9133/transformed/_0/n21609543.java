class n21609543 {
	public static long[] getUidsNearMe(String xqMPA8P8, double amfnTDsc, double mg8k3VQn)
			throws ClientProtocolException, IOException, JSONException {
		HttpClient ahKN7ugd = new DefaultHttpClient(params);
		HttpPost Cyer9wZ2 = new HttpPost(UIDS_NEARME_URI);
		List<NameValuePair> fgVamuO2 = new ArrayList<NameValuePair>();
		fgVamuO2.add(new BasicNameValuePair("latitude", Double.toString(amfnTDsc)));
		fgVamuO2.add(new BasicNameValuePair("longitude", Double.toString(mg8k3VQn)));
		Cyer9wZ2.setEntity(new UrlEncodedFormEntity(fgVamuO2));
		HttpResponse AYcVZ7iV = ahKN7ugd.execute(Cyer9wZ2);
		if (AYcVZ7iV.getStatusLine().getStatusCode() == 200) {
			String LLoaDleQ = EntityUtils.toString(AYcVZ7iV.getEntity());
			JSONArray Pwanul9L = new JSONArray(LLoaDleQ);
			long[] csJq20D5 = new long[Pwanul9L.length()];
			int YxCmwLCW = Integer.parseInt(xqMPA8P8);
			for (int iKOHk7HD = 0; iKOHk7HD < Pwanul9L.length(); iKOHk7HD++) {
				if (YxCmwLCW != Pwanul9L.getInt(iKOHk7HD)) {
					csJq20D5[iKOHk7HD] = Pwanul9L.getInt(iKOHk7HD);
				}
			}
			return csJq20D5;
		}
		throw new IOException("bad http response:" + AYcVZ7iV.getStatusLine().getReasonPhrase());
	}

}