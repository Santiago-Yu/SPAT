class n20732948 {
	public static HttpResponse query(DefaultHttpClient iJbRVm86, Request KvQn91mH, Proxy rsbgtxGT, Log KAyEe0bC)
			throws ClientProtocolException, IOException, MojoExecutionException {
		KAyEe0bC.debug("preparing " + KvQn91mH);
		if (rsbgtxGT != null) {
			KAyEe0bC.info("setting up " + rsbgtxGT + " for request " + KvQn91mH);
			rsbgtxGT.prepare(iJbRVm86);
		}
		HttpRequestBase O5HUtyse = KvQn91mH.buildHttpRequestBase(iJbRVm86, KAyEe0bC);
		HttpHost fYQXPk2W = KvQn91mH.buildHttpHost(KAyEe0bC);
		KAyEe0bC.debug("HTTP " + KvQn91mH.getMethod() + " url=" + KvQn91mH.getFinalUrl());
		long U7Pw44Yv = System.currentTimeMillis();
		HttpResponse DJSD8dFe = iJbRVm86.execute(fYQXPk2W, O5HUtyse);
		KAyEe0bC.debug("received response (time=" + (System.currentTimeMillis() - U7Pw44Yv) + "ms) for request ["
				+ "HTTP " + KvQn91mH.getMethod() + " url=" + KvQn91mH.getFinalUrl() + "]");
		return DJSD8dFe;
	}

}