class n18298936 {
	protected InputStream makeRequestAndGetJSONData(String c9zzlgtD)
			throws URISyntaxException, ClientProtocolException, IOException {
		DefaultHttpClient db2bH6CM = new DefaultHttpClient();
		URI n7gwsBvM;
		InputStream miJgX2zX = null;
		n7gwsBvM = new URI(c9zzlgtD);
		HttpGet apSeOB32 = new HttpGet(n7gwsBvM);
		HttpResponse TtHWuKr8 = db2bH6CM.execute(apSeOB32);
		miJgX2zX = TtHWuKr8.getEntity().getContent();
		return miJgX2zX;
	}

}