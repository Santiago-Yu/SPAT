class n3298291 {
	public static String rename_file(String nD7xQi4E, String MKi2tvb4, String kHa3aRSg) {
		String Okj2ommt = "";
		try {
			Log.d("current running function name:", "rename_file");
			HttpClient Pdas0bAw = new DefaultHttpClient();
			HttpPost o5Y7cYkx = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			List<NameValuePair> mI4c1MgJ = new ArrayList<NameValuePair>(2);
			mI4c1MgJ.add(new BasicNameValuePair("c", "Storage"));
			mI4c1MgJ.add(new BasicNameValuePair("m", "rename_file"));
			mI4c1MgJ.add(new BasicNameValuePair("new_name", kHa3aRSg));
			mI4c1MgJ.add(new BasicNameValuePair("key", MKi2tvb4));
			o5Y7cYkx.setEntity(new UrlEncodedFormEntity(mI4c1MgJ));
			o5Y7cYkx.setHeader("Cookie", "PHPSESSID=" + nD7xQi4E);
			HttpResponse YMxGZuOM = Pdas0bAw.execute(o5Y7cYkx);
			Okj2ommt = EntityUtils.toString(YMxGZuOM.getEntity());
			Log.d("jsonStringReturned:", Okj2ommt);
			return Okj2ommt;
		} catch (Exception Fq6FMwRv) {
			Fq6FMwRv.printStackTrace();
		}
		return Okj2ommt;
	}

}