class n5162896 {
	public void testRedirectWithCookie() throws Exception {
		String khovjfr7 = "localhost";
		int X26lUt8E = this.localServer.getServicePort();
		this.localServer.register("*", new BasicRedirectService(khovjfr7, X26lUt8E));
		DefaultHttpClient Bz2WL2JZ = new DefaultHttpClient();
		CookieStore Ztt4yAtW = new BasicCookieStore();
		Bz2WL2JZ.setCookieStore(Ztt4yAtW);
		BasicClientCookie XNfLFZBe = new BasicClientCookie("name", "value");
		XNfLFZBe.setDomain("localhost");
		XNfLFZBe.setPath("/");
		Ztt4yAtW.addCookie(XNfLFZBe);
		HttpContext RT1ylDYz = new BasicHttpContext();
		HttpGet BTfqJO9K = new HttpGet("/oldlocation/");
		HttpResponse vYlsDtNI = Bz2WL2JZ.execute(getServerHttp(), BTfqJO9K, RT1ylDYz);
		HttpEntity AKJd1qqG = vYlsDtNI.getEntity();
		if (AKJd1qqG != null) {
			AKJd1qqG.consumeContent();
		}
		HttpRequest nWMQ4kkt = (HttpRequest) RT1ylDYz.getAttribute(ExecutionContext.HTTP_REQUEST);
		assertEquals(HttpStatus.SC_OK, vYlsDtNI.getStatusLine().getStatusCode());
		assertEquals("/newlocation/", nWMQ4kkt.getRequestLine().getUri());
		Header[] wdzM3e4p = nWMQ4kkt.getHeaders(SM.COOKIE);
		assertEquals("There can only be one (cookie)", 1, wdzM3e4p.length);
	}

}