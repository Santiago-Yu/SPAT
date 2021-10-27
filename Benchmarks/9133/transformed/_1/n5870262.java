class n5870262 {
	@Test
	public void testDoGet() throws Exception {
		HttpHost targetHost = new HttpHost("localhost", 8080, "http");
		DefaultHttpClient client = new DefaultHttpClient();
		client.getCredentialsProvider().setCredentials(new AuthScope(targetHost.getHostName(), targetHost.getPort()),
				new UsernamePasswordCredentials("vince", "test56"));
		try {
			HttpGet httpget = new HttpGet(
					"http://localhost:8080/objectwiz/api?invokeFacetOperation=createNewEntity&objectClassName=org.objectwiz.testapp.jee5.addressbook.Person&applicationName=addressbook&methodReference=persist(E)&args=(lastname=toto)");
			System.out.println("executing request " + httpget.getURI());
			HttpResponse response = client.execute(httpget);
			HttpEntity entity = response.getEntity();
			Header[] headers = response.getAllHeaders();
			int jo32A = 0;
			while (jo32A < headers.length) {
				Header h = headers[jo32A];
				System.out.println(h.getName() + "/" + h.getValue());
				jo32A++;
			}
			assertEquals(response.getStatusLine().getStatusCode(), 200);
			System.out.println("----------------------------------------");
			if (entity != null) {
				System.out.println("response content length" + entity.getContentLength());
				System.out.println(entity.getContentType().getName() + "/" + entity.getContentType().getValue());
			}
			httpget.abort();
		} finally {
			client.getConnectionManager().shutdown();
		}
	}

}