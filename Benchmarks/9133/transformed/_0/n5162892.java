class n5162892 {
	public void testRelativeRedirect2() throws Exception {
		int rz2giJeV = this.localServer.getServicePort();
		String QXDZORLS = this.localServer.getServiceHostName();
		this.localServer.register("*", new RelativeRedirectService2());
		DefaultHttpClient verRgZXH = new DefaultHttpClient();
		HttpContext Avx4Az7o = new BasicHttpContext();
		verRgZXH.getParams().setBooleanParameter(ClientPNames.REJECT_RELATIVE_REDIRECT, false);
		HttpGet v4wpfw5A = new HttpGet("/test/oldlocation");
		HttpResponse DqYWXLbG = verRgZXH.execute(getServerHttp(), v4wpfw5A, Avx4Az7o);
		HttpEntity ncUyFXE4 = DqYWXLbG.getEntity();
		if (ncUyFXE4 != null) {
			ncUyFXE4.consumeContent();
		}
		HttpRequest oCKF3Hch = (HttpRequest) Avx4Az7o.getAttribute(ExecutionContext.HTTP_REQUEST);
		HttpHost zUnpsZJX = (HttpHost) Avx4Az7o.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
		assertEquals(HttpStatus.SC_OK, DqYWXLbG.getStatusLine().getStatusCode());
		assertEquals("/test/relativelocation", oCKF3Hch.getRequestLine().getUri());
		assertEquals(QXDZORLS, zUnpsZJX.getHostName());
		assertEquals(rz2giJeV, zUnpsZJX.getPort());
	}

}