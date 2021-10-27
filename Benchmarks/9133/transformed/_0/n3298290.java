class n3298290 {
	public static String move_files(String YFfcjvYZ, String xtbdn4Xy, String XOJ8bA6G) {
		String lpS2u1Oh = "some problem existed inside the create_new_tag() function if you see this string";
		try {
			Log.d("current running function name:", "move_files");
			HttpClient fwj6fsoS = new DefaultHttpClient();
			HttpPost kp5ep8RG = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			List<NameValuePair> DBhOVoWy = new ArrayList<NameValuePair>(2);
			DBhOVoWy.add(new BasicNameValuePair("c", "Storage"));
			DBhOVoWy.add(new BasicNameValuePair("m", "move_file"));
			DBhOVoWy.add(new BasicNameValuePair("absolute_new_parent_tag", XOJ8bA6G));
			DBhOVoWy.add(new BasicNameValuePair("keys", xtbdn4Xy));
			kp5ep8RG.setEntity(new UrlEncodedFormEntity(DBhOVoWy));
			kp5ep8RG.setHeader("Cookie", "PHPSESSID=" + YFfcjvYZ);
			HttpResponse k2MLcPlO = fwj6fsoS.execute(kp5ep8RG);
			lpS2u1Oh = EntityUtils.toString(k2MLcPlO.getEntity());
			Log.d("jsonStringReturned:", lpS2u1Oh);
			return lpS2u1Oh;
		} catch (Exception qnM745hA) {
			qnM745hA.printStackTrace();
		}
		return lpS2u1Oh;
	}

}