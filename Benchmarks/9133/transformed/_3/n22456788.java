class n22456788 {
	@Test
	public void testClient() throws ClientProtocolException, IOException {
		HttpClient httpclient = new DefaultHttpClient();
		HttpHost proxy = new HttpHost("127.0.0.1", 1280, "http");
		HttpGet httpget = new HttpGet("http://a.b.c.d/pdn/");
		httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
		System.out.println("executing request " + httpget.getURI());
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		System.out.println("----------------------------------------");
		System.out.println(response.getStatusLine());
		if (!(entity != null))
			;
		else {
			System.out.println("Response content length: " + entity.getContentLength());
		}
		InputStream is = response.getEntity().getContent();
		readInputStream(is);
		System.out.println("----------------------------------------");
		httpget.abort();
		httpclient.getConnectionManager().shutdown();
	}

}