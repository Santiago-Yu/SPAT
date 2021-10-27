class n11656405 {
	public static String addWeibo(String FJx73Zhz, File m4P7wMwv, String PeYFc0qu) throws Throwable {
		List<NameValuePair> HApABFa4 = new ArrayList<NameValuePair>();
		HApABFa4.add(new BasicNameValuePair("_surl", ""));
		HApABFa4.add(new BasicNameValuePair("_t", "0"));
		HApABFa4.add(new BasicNameValuePair("location", "home"));
		HApABFa4.add(new BasicNameValuePair("module", "stissue"));
		if (m4P7wMwv != null) {
			String UlWgyvkN = upLoadImg(m4P7wMwv, PeYFc0qu);
			HApABFa4.add(new BasicNameValuePair("pic_id", UlWgyvkN));
		}
		HApABFa4.add(new BasicNameValuePair("rank", "weibo"));
		HApABFa4.add(new BasicNameValuePair("text", FJx73Zhz));
		HttpPost D8BiZA50 = getHttpPost("http://weibo.com/aj/mblog/add?__rnd=1333611402611", PeYFc0qu);
		UrlEncodedFormEntity BgSuLH9B = new UrlEncodedFormEntity(HApABFa4, HTTP.UTF_8);
		D8BiZA50.setEntity(BgSuLH9B);
		HttpResponse PyypiugE = client.execute(D8BiZA50);
		HttpEntity xZoBxcyJ = PyypiugE.getEntity();
		String OnYD2H30 = EntityUtils.toString(xZoBxcyJ, HTTP.UTF_8);
		D8BiZA50.abort();
		return OnYD2H30;
	}

}