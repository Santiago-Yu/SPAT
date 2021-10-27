class n1677874 {
	public static String rename_file(String p9Xqa0KY, String ENUN7k5C, String uy6MwozF) {
		String mMp95vuP = "";
		try {
			Log.d("current running function name:", "rename_file");
			HttpClient pQlERrBw = new DefaultHttpClient();
			HttpPost OFhFP4J9 = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			List<NameValuePair> zSSFVXTT = new ArrayList<NameValuePair>(2);
			zSSFVXTT.add(new BasicNameValuePair("c", "Storage"));
			zSSFVXTT.add(new BasicNameValuePair("m", "rename_file"));
			zSSFVXTT.add(new BasicNameValuePair("new_name", uy6MwozF));
			zSSFVXTT.add(new BasicNameValuePair("key", ENUN7k5C));
			OFhFP4J9.setEntity(new UrlEncodedFormEntity(zSSFVXTT));
			OFhFP4J9.setHeader("Cookie", "PHPSESSID=" + p9Xqa0KY);
			HttpResponse mIXnjN4T = pQlERrBw.execute(OFhFP4J9);
			mMp95vuP = EntityUtils.toString(mIXnjN4T.getEntity());
			Log.d("jsonStringReturned:", mMp95vuP);
			return mMp95vuP;
		} catch (Exception zH7oDxNH) {
			zH7oDxNH.printStackTrace();
		}
		return mMp95vuP;
	}

}