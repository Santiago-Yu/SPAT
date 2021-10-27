class n7169984 {
	public static String connRemote(JSONObject WNK5a9CD, String gC2lxHcS) {
		String unDlcrPD = "";
		try {
			HttpClient j7NSxnrr = new DefaultHttpClient();
			HttpPost ALYb3ARB = new HttpPost(AZConstants.validateURL);
			HttpParams qXXLud9y = new BasicHttpParams();
			List<NameValuePair> newhS9u5 = new ArrayList<NameValuePair>();
			newhS9u5.add(new BasicNameValuePair(AZConstants.ACTION_TYPE, gC2lxHcS));
			newhS9u5.add(new BasicNameValuePair(AZConstants.PARAM, WNK5a9CD.toString()));
			ALYb3ARB.setEntity(new UrlEncodedFormEntity(newhS9u5));
			ALYb3ARB.setParams(qXXLud9y);
			HttpResponse a4Xb5SlS = j7NSxnrr.execute(ALYb3ARB);
			unDlcrPD = EntityUtils.toString(a4Xb5SlS.getEntity());
		} catch (Exception Mm0xYckm) {
			Log.e(TAG, Mm0xYckm.toString());
		}
		return unDlcrPD;
	}

}