class n3298287 {
	public static String remove_tag(String ATvJzd43, String rJ5cYQgh) {
		String WRZ40m3W = "some problem existed inside the create_new_tag() function if you see this string";
		try {
			Log.d("current running function name:", "remove_tag");
			HttpClient y47hfA4P = new DefaultHttpClient();
			HttpPost hv8S2IPj = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			List<NameValuePair> WrrHxomW = new ArrayList<NameValuePair>(2);
			WrrHxomW.add(new BasicNameValuePair("c", "Storage"));
			WrrHxomW.add(new BasicNameValuePair("m", "remove_tag"));
			WrrHxomW.add(new BasicNameValuePair("absolute_tags", rJ5cYQgh));
			hv8S2IPj.setEntity(new UrlEncodedFormEntity(WrrHxomW));
			hv8S2IPj.setHeader("Cookie", "PHPSESSID=" + ATvJzd43);
			HttpResponse SJko2ZVp = y47hfA4P.execute(hv8S2IPj);
			WRZ40m3W = EntityUtils.toString(SJko2ZVp.getEntity());
			Log.d("jsonStringReturned:", WRZ40m3W);
			return WRZ40m3W;
		} catch (Exception uFXC5wMQ) {
			uFXC5wMQ.printStackTrace();
		}
		return WRZ40m3W;
	}

}