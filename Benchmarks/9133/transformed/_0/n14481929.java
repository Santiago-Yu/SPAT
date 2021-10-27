class n14481929 {
	public static String rename_file(String VYsY6Tg8, String RWzeWpn4, String w3f7kjHL) {
		String UEVkhOPT = "";
		try {
			Log.d("current running function name:", "rename_file");
			HttpClient gIkawNDO = new DefaultHttpClient();
			HttpPost oF23OeMC = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			List<NameValuePair> JZqO5mQY = new ArrayList<NameValuePair>(2);
			JZqO5mQY.add(new BasicNameValuePair("c", "Storage"));
			JZqO5mQY.add(new BasicNameValuePair("m", "rename_file"));
			JZqO5mQY.add(new BasicNameValuePair("new_name", w3f7kjHL));
			JZqO5mQY.add(new BasicNameValuePair("key", RWzeWpn4));
			oF23OeMC.setEntity(new UrlEncodedFormEntity(JZqO5mQY));
			oF23OeMC.setHeader("Cookie", "PHPSESSID=" + VYsY6Tg8);
			HttpResponse LDmzSzlf = gIkawNDO.execute(oF23OeMC);
			UEVkhOPT = EntityUtils.toString(LDmzSzlf.getEntity());
			Log.d("jsonStringReturned:", UEVkhOPT);
			return UEVkhOPT;
		} catch (Exception QorfEI0J) {
			QorfEI0J.printStackTrace();
		}
		return UEVkhOPT;
	}

}