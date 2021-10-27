class n14481930 {
	public static String rename_tag(String fnEitdOO, String wXdfzYqW, String hNznR3LF) {
		String ZQDDLvY2 = "";
		try {
			Log.d("current running function name:", "rename_tag");
			HttpClient sduZY3EN = new DefaultHttpClient();
			HttpPost ZeJC75vJ = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			List<NameValuePair> GpZnWVKU = new ArrayList<NameValuePair>(2);
			GpZnWVKU.add(new BasicNameValuePair("c", "Storage"));
			GpZnWVKU.add(new BasicNameValuePair("m", "rename_tag"));
			GpZnWVKU.add(new BasicNameValuePair("new_tag_name", hNznR3LF));
			GpZnWVKU.add(new BasicNameValuePair("absolute_tag", wXdfzYqW));
			ZeJC75vJ.setEntity(new UrlEncodedFormEntity(GpZnWVKU));
			ZeJC75vJ.setHeader("Cookie", "PHPSESSID=" + fnEitdOO);
			HttpResponse boF9DWPc = sduZY3EN.execute(ZeJC75vJ);
			ZQDDLvY2 = EntityUtils.toString(boF9DWPc.getEntity());
			Log.d("jsonStringReturned:", ZQDDLvY2);
			return ZQDDLvY2;
		} catch (Exception WO10IN9H) {
			WO10IN9H.printStackTrace();
		}
		return ZQDDLvY2;
	}

}