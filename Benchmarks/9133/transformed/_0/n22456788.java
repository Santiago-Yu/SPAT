class n22456788 {
	@Test
	public void testClient() throws ClientProtocolException, IOException {
		HttpClient cVkUQqOE = new DefaultHttpClient();
		HttpHost aNVmzW7O = new HttpHost("127.0.0.1", 1280, "http");
		HttpGet fxuugzFw = new HttpGet("http://a.b.c.d/pdn/");
		cVkUQqOE.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, aNVmzW7O);
		System.out.println("executing request " + fxuugzFw.getURI());
		HttpResponse JgxW6PhO = cVkUQqOE.execute(fxuugzFw);
		HttpEntity Af9eI5g8 = JgxW6PhO.getEntity();
		System.out.println("----------------------------------------");
		System.out.println(JgxW6PhO.getStatusLine());
		if (Af9eI5g8 != null) {
			System.out.println("Response content length: " + Af9eI5g8.getContentLength());
		}
		InputStream joSRXt1z = JgxW6PhO.getEntity().getContent();
		readInputStream(joSRXt1z);
		System.out.println("----------------------------------------");
		fxuugzFw.abort();
		cVkUQqOE.getConnectionManager().shutdown();
	}

}