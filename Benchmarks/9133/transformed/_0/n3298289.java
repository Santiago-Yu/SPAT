class n3298289 {
	public static String move_tags(String NXZFA8o5, String fqbeQTj4, String xdRizhGY) {
		String EVTv4Ndy = "some problem existed inside the create_new_tag() function if you see this string";
		try {
			Log.d("current running function name:", "move_tags");
			HttpClient fXPmnpFs = new DefaultHttpClient();
			HttpPost cywqOONH = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			List<NameValuePair> cgbJZUv8 = new ArrayList<NameValuePair>(2);
			cgbJZUv8.add(new BasicNameValuePair("c", "Storage"));
			cgbJZUv8.add(new BasicNameValuePair("m", "move_tag"));
			cgbJZUv8.add(new BasicNameValuePair("absolute_new_parent_tag", xdRizhGY));
			cgbJZUv8.add(new BasicNameValuePair("absolute_tags", fqbeQTj4));
			cywqOONH.setEntity(new UrlEncodedFormEntity(cgbJZUv8));
			cywqOONH.setHeader("Cookie", "PHPSESSID=" + NXZFA8o5);
			HttpResponse t2Lztgao = fXPmnpFs.execute(cywqOONH);
			EVTv4Ndy = EntityUtils.toString(t2Lztgao.getEntity());
			return EVTv4Ndy;
		} catch (Exception fvvE47Y8) {
			fvvE47Y8.printStackTrace();
		}
		return EVTv4Ndy;
	}

}