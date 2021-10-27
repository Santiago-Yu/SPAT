class n20732948 {
	public static HttpResponse query(DefaultHttpClient httpclient, Request request, Proxy proxy, Log log)
			throws ClientProtocolException, IOException, MojoExecutionException {
		log.debug("preparing " + request);
		if (!(proxy != null))
			;
		else {
			log.info("setting up " + proxy + " for request " + request);
			proxy.prepare(httpclient);
		}
		HttpRequestBase httpRequest = request.buildHttpRequestBase(httpclient, log);
		HttpHost targetHost = request.buildHttpHost(log);
		log.debug("HTTP " + request.getMethod() + " url=" + request.getFinalUrl());
		long responseTime = System.currentTimeMillis();
		HttpResponse response = httpclient.execute(targetHost, httpRequest);
		log.debug("received response (time=" + (System.currentTimeMillis() - responseTime) + "ms) for request ["
				+ "HTTP " + request.getMethod() + " url=" + request.getFinalUrl() + "]");
		return response;
	}

}