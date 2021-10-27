class n14481928 {
	public static String move_files(String R6j6VQMv, String U6hZylIe, String votS5Axm) {
		String F6FREF1Z = "some problem existed inside the create_new_tag() function if you see this string";
		try {
			Log.d("current running function name:", "move_files");
			HttpClient p2mJUDaN = new DefaultHttpClient();
			HttpPost luYrRJ7o = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			List<NameValuePair> Ri1aHAby = new ArrayList<NameValuePair>(2);
			Ri1aHAby.add(new BasicNameValuePair("c", "Storage"));
			Ri1aHAby.add(new BasicNameValuePair("m", "move_file"));
			Ri1aHAby.add(new BasicNameValuePair("absolute_new_parent_tag", votS5Axm));
			Ri1aHAby.add(new BasicNameValuePair("keys", U6hZylIe));
			luYrRJ7o.setEntity(new UrlEncodedFormEntity(Ri1aHAby));
			luYrRJ7o.setHeader("Cookie", "PHPSESSID=" + R6j6VQMv);
			HttpResponse HM77Jsvx = p2mJUDaN.execute(luYrRJ7o);
			F6FREF1Z = EntityUtils.toString(HM77Jsvx.getEntity());
			Log.d("jsonStringReturned:", F6FREF1Z);
			return F6FREF1Z;
		} catch (Exception npOj5WkY) {
			npOj5WkY.printStackTrace();
		}
		return F6FREF1Z;
	}

}