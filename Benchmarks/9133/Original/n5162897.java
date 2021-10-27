class n5162897{
    public void testDefaultHeadersRedirect() throws Exception {
        String host = "localhost";
        int port = this.localServer.getServicePort();
        this.localServer.register("*", new BasicRedirectService(host, port));
        DefaultHttpClient client = new DefaultHttpClient();
        HttpContext context = new BasicHttpContext();
        List<Header> defaultHeaders = new ArrayList<Header>(1);
        defaultHeaders.add(new BasicHeader(HTTP.USER_AGENT, "my-test-client"));
        client.getParams().setParameter(ClientPNames.DEFAULT_HEADERS, defaultHeaders);
        HttpGet httpget = new HttpGet("/oldlocation/");
        HttpResponse response = client.execute(getServerHttp(), httpget, context);
        HttpEntity e = response.getEntity();
        if (e != null) {
            e.consumeContent();
        }
        HttpRequest reqWrapper = (HttpRequest) context.getAttribute(ExecutionContext.HTTP_REQUEST);
        assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        assertEquals("/newlocation/", reqWrapper.getRequestLine().getUri());
        Header header = reqWrapper.getFirstHeader(HTTP.USER_AGENT);
        assertEquals("my-test-client", header.getValue());
    }

}