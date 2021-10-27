class n5870262 {
	@Test
	public void testDoGet() throws Exception {
		HttpHost wp6N7C8Z = new HttpHost("localhost", 8080, "http");
		DefaultHttpClient gZFBDtrd = new DefaultHttpClient();
		gZFBDtrd.getCredentialsProvider().setCredentials(new AuthScope(wp6N7C8Z.getHostName(), wp6N7C8Z.getPort()),
				new UsernamePasswordCredentials("vince", "test56"));
		try {
			HttpGet qqQYi2Gy = new HttpGet(
					"http://localhost:8080/objectwiz/api?invokeFacetOperation=createNewEntity&objectClassName=org.objectwiz.testapp.jee5.addressbook.Person&applicationName=addressbook&methodReference=persist(E)&args=(lastname=toto)");
			System.out.println("executing request " + qqQYi2Gy.getURI());
			HttpResponse K8IRn62g = gZFBDtrd.execute(qqQYi2Gy);
			HttpEntity RNJ7Hmaj = K8IRn62g.getEntity();
			Header[] WsyYKdFE = K8IRn62g.getAllHeaders();
			for (int Y4xNvic1 = 0; Y4xNvic1 < WsyYKdFE.length; Y4xNvic1++) {
				Header wSYXLkeb = WsyYKdFE[Y4xNvic1];
				System.out.println(wSYXLkeb.getName() + "/" + wSYXLkeb.getValue());
			}
			assertEquals(K8IRn62g.getStatusLine().getStatusCode(), 200);
			System.out.println("----------------------------------------");
			if (RNJ7Hmaj != null) {
				System.out.println("response content length" + RNJ7Hmaj.getContentLength());
				System.out.println(RNJ7Hmaj.getContentType().getName() + "/" + RNJ7Hmaj.getContentType().getValue());
			}
			qqQYi2Gy.abort();
		} finally {
			gZFBDtrd.getConnectionManager().shutdown();
		}
	}

}