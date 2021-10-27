class n14481927 {
	public static String move_tags(String n6mCFBO9, String tf88XQrv, String XBHKahs7) {
		String PGN1vRAw = "some problem existed inside the create_new_tag() function if you see this string";
		try {
			Log.d("current running function name:", "move_tags");
			HttpClient myAH087X = new DefaultHttpClient();
			HttpPost m1N1pgJy = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			List<NameValuePair> ZTo5fMzA = new ArrayList<NameValuePair>(2);
			ZTo5fMzA.add(new BasicNameValuePair("c", "Storage"));
			ZTo5fMzA.add(new BasicNameValuePair("m", "move_tag"));
			ZTo5fMzA.add(new BasicNameValuePair("absolute_new_parent_tag", XBHKahs7));
			ZTo5fMzA.add(new BasicNameValuePair("absolute_tags", tf88XQrv));
			m1N1pgJy.setEntity(new UrlEncodedFormEntity(ZTo5fMzA));
			m1N1pgJy.setHeader("Cookie", "PHPSESSID=" + n6mCFBO9);
			HttpResponse PCtIjWt9 = myAH087X.execute(m1N1pgJy);
			PGN1vRAw = EntityUtils.toString(PCtIjWt9.getEntity());
			return PGN1vRAw;
		} catch (Exception UmH9m0TU) {
			UmH9m0TU.printStackTrace();
		}
		return PGN1vRAw;
	}

}