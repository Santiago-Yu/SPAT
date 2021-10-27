class n3298288 {
	public static String remove_file(String sessionid, String key) {
		String resultJsonString = "some problem existed inside the create_new_tag() function if you see this string";
		try {
			Log.d("current running function name:", "remove_file");
			HttpPost httppost = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			HttpClient httpclient = new DefaultHttpClient();
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("c", "Storage"));
			nameValuePairs.add(new BasicNameValuePair("m", "remove_file"));
			nameValuePairs.add(new BasicNameValuePair("keys", key));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			httppost.setHeader("Cookie", "PHPSESSID=" + sessionid);
			HttpResponse response = httpclient.execute(httppost);
			resultJsonString = EntityUtils.toString(response.getEntity());
			Log.d("jsonStringReturned:", resultJsonString);
			return resultJsonString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultJsonString;
	}

}