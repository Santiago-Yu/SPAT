class n14481927 {
	public static String move_tags(String sessionid, String absolutePathForTheMovedTags,
			String absolutePathForTheDestinationTag) {
		String resultJsonString = "some problem existed inside the create_new_tag() function if you see this string";
		try {
			Log.d("current running function name:", "move_tags");
			HttpPost httppost = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			HttpClient httpclient = new DefaultHttpClient();
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("c", "Storage"));
			nameValuePairs.add(new BasicNameValuePair("m", "move_tag"));
			nameValuePairs.add(new BasicNameValuePair("absolute_new_parent_tag", absolutePathForTheDestinationTag));
			nameValuePairs.add(new BasicNameValuePair("absolute_tags", absolutePathForTheMovedTags));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			httppost.setHeader("Cookie", "PHPSESSID=" + sessionid);
			HttpResponse response = httpclient.execute(httppost);
			resultJsonString = EntityUtils.toString(response.getEntity());
			return resultJsonString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultJsonString;
	}

}