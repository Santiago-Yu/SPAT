class n5162897 {
	public void testDefaultHeadersRedirect() throws Exception {
		String o6W0MoYv = "localhost";
		int aq2cp4Nq = this.localServer.getServicePort();
		this.localServer.register("*", new BasicRedirectService(o6W0MoYv, aq2cp4Nq));
		DefaultHttpClient MB3KNVKg = new DefaultHttpClient();
		HttpContext bW90CSi6 = new BasicHttpContext();
		List<Header> qRHHgxDH = new ArrayList<Header>(1);
		qRHHgxDH.add(new BasicHeader(HTTP.USER_AGENT, "my-test-client"));
		MB3KNVKg.getParams().setParameter(ClientPNames.DEFAULT_HEADERS, qRHHgxDH);
		HttpGet P4rSFWnX = new HttpGet("/oldlocation/");
		HttpResponse QfSvxTbF = MB3KNVKg.execute(getServerHttp(), P4rSFWnX, bW90CSi6);
		HttpEntity mwzjme0y = QfSvxTbF.getEntity();
		if (mwzjme0y != null) {
			mwzjme0y.consumeContent();
		}
		HttpRequest tdNjpFuz = (HttpRequest) bW90CSi6.getAttribute(ExecutionContext.HTTP_REQUEST);
		assertEquals(HttpStatus.SC_OK, QfSvxTbF.getStatusLine().getStatusCode());
		assertEquals("/newlocation/", tdNjpFuz.getRequestLine().getUri());
		Header EzFdfWmu = tdNjpFuz.getFirstHeader(HTTP.USER_AGENT);
		assertEquals("my-test-client", EzFdfWmu.getValue());
	}

}