class n3298292 {
	public static String rename_tag(String fmmUcyWt, String uRyTie1r, String hzMclDJY) {
		String m26A6DlO = "";
		try {
			Log.d("current running function name:", "rename_tag");
			HttpClient ZtaLzdeO = new DefaultHttpClient();
			HttpPost MBTAmz7Y = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			List<NameValuePair> fHgMucYB = new ArrayList<NameValuePair>(2);
			fHgMucYB.add(new BasicNameValuePair("c", "Storage"));
			fHgMucYB.add(new BasicNameValuePair("m", "rename_tag"));
			fHgMucYB.add(new BasicNameValuePair("new_tag_name", hzMclDJY));
			fHgMucYB.add(new BasicNameValuePair("absolute_tag", uRyTie1r));
			MBTAmz7Y.setEntity(new UrlEncodedFormEntity(fHgMucYB));
			MBTAmz7Y.setHeader("Cookie", "PHPSESSID=" + fmmUcyWt);
			HttpResponse otxODK7g = ZtaLzdeO.execute(MBTAmz7Y);
			m26A6DlO = EntityUtils.toString(otxODK7g.getEntity());
			Log.d("jsonStringReturned:", m26A6DlO);
			return m26A6DlO;
		} catch (Exception leNTxnjU) {
			leNTxnjU.printStackTrace();
		}
		return m26A6DlO;
	}

}