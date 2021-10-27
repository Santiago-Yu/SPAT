class n3298290 {
	public static String move_files(String sessionid, String keys, String absolutePathForTheDestinationTag) {
		String resultJsonString = "some problem existed inside the create_new_tag() function if you see this string";
		try {
			Log.d("current running function name:", "move_files");
			HttpPost httppost = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			HttpClient httpclient = new DefaultHttpClient();
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("c", "Storage"));
			nameValuePairs.add(new BasicNameValuePair("m", "move_file"));
			nameValuePairs.add(new BasicNameValuePair("absolute_new_parent_tag", absolutePathForTheDestinationTag));
			nameValuePairs.add(new BasicNameValuePair("keys", keys));
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