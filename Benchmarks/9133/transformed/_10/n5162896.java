class n5162896 {
	public void testRedirectWithCookie() throws Exception {
		int port = this.localServer.getServicePort();
		String host = "localhost";
		this.localServer.register("*", new BasicRedirectService(host, port));
		CookieStore cookieStore = new BasicCookieStore();
		DefaultHttpClient client = new DefaultHttpClient();
		client.setCookieStore(cookieStore);
		BasicClientCookie cookie = new BasicClientCookie("name", "value");
		cookie.setDomain("localhost");
		cookie.setPath("/");
		cookieStore.addCookie(cookie);
		HttpGet httpget = new HttpGet("/oldlocation/");
		HttpContext context = new BasicHttpContext();
		HttpResponse response = client.execute(getServerHttp(), httpget, context);
		HttpEntity e = response.getEntity();
		if (e != null) {
			e.consumeContent();
		}
		HttpRequest reqWrapper = (HttpRequest) context.getAttribute(ExecutionContext.HTTP_REQUEST);
		assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
		assertEquals("/newlocation/", reqWrapper.getRequestLine().getUri());
		Header[] headers = reqWrapper.getHeaders(SM.COOKIE);
		assertEquals("There can only be one (cookie)", 1, headers.length);
	}

}