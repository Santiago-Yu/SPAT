class n5162892 {
	public void testRelativeRedirect2() throws Exception {
		int port = this.localServer.getServicePort();
		String host = this.localServer.getServiceHostName();
		this.localServer.register("*", new RelativeRedirectService2());
		HttpContext context = new BasicHttpContext();
		DefaultHttpClient client = new DefaultHttpClient();
		client.getParams().setBooleanParameter(ClientPNames.REJECT_RELATIVE_REDIRECT, false);
		HttpGet httpget = new HttpGet("/test/oldlocation");
		HttpResponse response = client.execute(getServerHttp(), httpget, context);
		HttpEntity e = response.getEntity();
		if (e != null) {
			e.consumeContent();
		}
		HttpRequest reqWrapper = (HttpRequest) context.getAttribute(ExecutionContext.HTTP_REQUEST);
		HttpHost targetHost = (HttpHost) context.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
		assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
		assertEquals("/test/relativelocation", reqWrapper.getRequestLine().getUri());
		assertEquals(host, targetHost.getHostName());
		assertEquals(port, targetHost.getPort());
	}

}