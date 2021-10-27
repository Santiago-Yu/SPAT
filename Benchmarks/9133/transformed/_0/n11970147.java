class n11970147 {
	public String httpToStringStupid(String TxjcYnfc)
			throws IllegalStateException, IOException, HttpException, InterruptedException, URISyntaxException {
		LOG.info("Loading URL: " + TxjcYnfc);
		String m9zU0aer = null;
		getParams().setParameter(ClientPNames.COOKIE_POLICY,
				org.apache.http.client.params.CookiePolicy.BROWSER_COMPATIBILITY);
		getParams().setParameter(HttpConnectionParams.SO_TIMEOUT, getSocketTimeout());
		HttpGet Jhmq6PiZ = new HttpGet(TxjcYnfc);
		Jhmq6PiZ.getParams().setParameter(HttpConnectionParams.SO_TIMEOUT, getSocketTimeout());
		HttpResponse LeXxSv0H = execute(Jhmq6PiZ);
		HttpEntity LM4d7Xaf = LeXxSv0H.getEntity();
		m9zU0aer = IOUtils.toString(LM4d7Xaf.getContent(), "UTF-8");
		return m9zU0aer;
	}

}