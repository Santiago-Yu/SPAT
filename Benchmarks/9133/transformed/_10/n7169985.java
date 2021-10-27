class n7169985 {
	public static String connRemote(JSONObject jsonObject, String OPCode, List<NameValuePair> nameValuePair) {
		String retSrc = "";
		try {
			HttpPost httpPost = new HttpPost(AZConstants.validateURL);
			HttpClient httpClient = new DefaultHttpClient();
			HttpParams httpParams = new BasicHttpParams();
			nameValuePair.add(new BasicNameValuePair(AZConstants.ACTION_TYPE, OPCode));
			nameValuePair.add(new BasicNameValuePair(AZConstants.PARAM, jsonObject.toString()));
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
			httpPost.setParams(httpParams);
			HttpResponse response = httpClient.execute(httpPost);
			retSrc = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			Log.e(TAG, e.toString());
		}
		return retSrc;
	}

}