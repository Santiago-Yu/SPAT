class n22431486 {
	public static String doPostEntity(String hjq3XGRE, List<NameValuePair> VAYgAX6E) {
		try {
			OauthUtil lvQubYOH = new OauthUtil();
			URI OL7TFbGv = new URI(hjq3XGRE);
			HttpClient lQ9UWJf7 = lvQubYOH.getNewHttpClient();
			HttpPost GxXiY3ad = new HttpPost(OL7TFbGv);
			GxXiY3ad.setEntity(new UrlEncodedFormEntity(VAYgAX6E, HTTP.UTF_8));
			HttpResponse GuN0JqNh = lQ9UWJf7.execute(GxXiY3ad);
			if (GuN0JqNh.getStatusLine().getStatusCode() == 200) {
				String FP36pYX4 = EntityUtils.toString(GuN0JqNh.getEntity());
				Log.i("DEBUG", "result: " + FP36pYX4);
				String ru5dynyZ;
				try {
					JSONObject Gk1a5Bf8 = new JSONObject(FP36pYX4);
					ru5dynyZ = Gk1a5Bf8.getString("access_token");
				} catch (Exception cUi6AAAV) {
					ru5dynyZ = FP36pYX4.substring(FP36pYX4.indexOf("access_token=") + 13);
				}
				return ru5dynyZ;
			}
		} catch (Exception WZUGgsVs) {
			Log.i("DEBUG", WZUGgsVs.toString());
		}
		return null;
	}

}