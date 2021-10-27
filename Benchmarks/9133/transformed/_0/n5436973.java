class n5436973 {
	public String httpToStringStupid(String XhgvcFWk)
			throws IllegalStateException, IOException, HttpException, InterruptedException, URISyntaxException {
		String x38nkN1G = null;
		getParams().setParameter(ClientPNames.COOKIE_POLICY,
				org.apache.http.client.params.CookiePolicy.BROWSER_COMPATIBILITY);
		getParams().setParameter(HttpConnectionParams.SO_TIMEOUT, getPreferenceService().getSearchSocketTimeout());
		HttpGet S5Z9GuFh = new HttpGet(XhgvcFWk);
		S5Z9GuFh.getParams().setParameter(HttpConnectionParams.SO_TIMEOUT,
				getPreferenceService().getSearchSocketTimeout());
		HttpResponse mdYK7hcT = execute(S5Z9GuFh);
		HttpEntity LqreSNUv = mdYK7hcT.getEntity();
		x38nkN1G = IOUtils.toString(LqreSNUv.getContent(), "UTF-8");
		return x38nkN1G;
	}

}