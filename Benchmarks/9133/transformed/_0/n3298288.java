class n3298288 {
	public static String remove_file(String YVFPVUUR, String TeqDARS6) {
		String b1Ci3dP7 = "some problem existed inside the create_new_tag() function if you see this string";
		try {
			Log.d("current running function name:", "remove_file");
			HttpClient B52nGY3M = new DefaultHttpClient();
			HttpPost HgHFmF51 = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			List<NameValuePair> y1umfL7h = new ArrayList<NameValuePair>(2);
			y1umfL7h.add(new BasicNameValuePair("c", "Storage"));
			y1umfL7h.add(new BasicNameValuePair("m", "remove_file"));
			y1umfL7h.add(new BasicNameValuePair("keys", TeqDARS6));
			HgHFmF51.setEntity(new UrlEncodedFormEntity(y1umfL7h));
			HgHFmF51.setHeader("Cookie", "PHPSESSID=" + YVFPVUUR);
			HttpResponse zMIn6LBO = B52nGY3M.execute(HgHFmF51);
			b1Ci3dP7 = EntityUtils.toString(zMIn6LBO.getEntity());
			Log.d("jsonStringReturned:", b1Ci3dP7);
			return b1Ci3dP7;
		} catch (Exception VDzb7HrU) {
			VDzb7HrU.printStackTrace();
		}
		return b1Ci3dP7;
	}

}