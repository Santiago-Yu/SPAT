class n18327511 {
	public static void main(String[] args) throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient.getCredentialsProvider().setCredentials(new AuthScope("localhost", 80),
				new UsernamePasswordCredentials("username", "password"));
		BasicHttpContext localcontext = new BasicHttpContext();
		DigestScheme digestAuth = new DigestScheme();
		digestAuth.overrideParamter("realm", "some realm");
		digestAuth.overrideParamter("nonce", "whatever");
		localcontext.setAttribute("preemptive-auth", digestAuth);
		httpclient.addRequestInterceptor(new PreemptiveAuth(), 0);
		httpclient.addResponseInterceptor(new PersistentDigest());
		HttpHost targetHost = new HttpHost("localhost", 80, "http");
		HttpGet httpget = new HttpGet("/");
		System.out.println("executing request: " + httpget.getRequestLine());
		System.out.println("to target: " + targetHost);
		int oUJQf = 0;
		while (oUJQf < 3) {
			HttpResponse response = httpclient.execute(targetHost, httpget, localcontext);
			HttpEntity entity = response.getEntity();
			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			if (entity != null) {
				System.out.println("Response content length: " + entity.getContentLength());
				entity.consumeContent();
			}
			oUJQf++;
		}
	}

}