class n1677875 {
	public static String rename_tag(String Di8dzbFD, String YRBy5ECk, String HD04cBE9) {
		String Mma5gSjS = "";
		try {
			Log.d("current running function name:", "rename_tag");
			HttpClient jdmWEbb1 = new DefaultHttpClient();
			HttpPost AuRAebuV = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			List<NameValuePair> cHppF5G1 = new ArrayList<NameValuePair>(2);
			cHppF5G1.add(new BasicNameValuePair("c", "Storage"));
			cHppF5G1.add(new BasicNameValuePair("m", "rename_tag"));
			cHppF5G1.add(new BasicNameValuePair("new_tag_name", HD04cBE9));
			cHppF5G1.add(new BasicNameValuePair("absolute_tag", YRBy5ECk));
			AuRAebuV.setEntity(new UrlEncodedFormEntity(cHppF5G1));
			AuRAebuV.setHeader("Cookie", "PHPSESSID=" + Di8dzbFD);
			HttpResponse Ih5XNrna = jdmWEbb1.execute(AuRAebuV);
			Mma5gSjS = EntityUtils.toString(Ih5XNrna.getEntity());
			Log.d("jsonStringReturned:", Mma5gSjS);
			return Mma5gSjS;
		} catch (Exception TSKluVGB) {
			TSKluVGB.printStackTrace();
		}
		return Mma5gSjS;
	}

}