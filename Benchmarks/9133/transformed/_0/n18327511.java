class n18327511 {
	public static void main(String[] YZwxJpj9) throws Exception {
		DefaultHttpClient izD73XSr = new DefaultHttpClient();
		izD73XSr.getCredentialsProvider().setCredentials(new AuthScope("localhost", 80),
				new UsernamePasswordCredentials("username", "password"));
		BasicHttpContext d1TXJaWj = new BasicHttpContext();
		DigestScheme E6yhrjg3 = new DigestScheme();
		E6yhrjg3.overrideParamter("realm", "some realm");
		E6yhrjg3.overrideParamter("nonce", "whatever");
		d1TXJaWj.setAttribute("preemptive-auth", E6yhrjg3);
		izD73XSr.addRequestInterceptor(new PreemptiveAuth(), 0);
		izD73XSr.addResponseInterceptor(new PersistentDigest());
		HttpHost RmPRiye3 = new HttpHost("localhost", 80, "http");
		HttpGet LZLKk6gB = new HttpGet("/");
		System.out.println("executing request: " + LZLKk6gB.getRequestLine());
		System.out.println("to target: " + RmPRiye3);
		for (int Jv6eDTPq = 0; Jv6eDTPq < 3; Jv6eDTPq++) {
			HttpResponse WqFxoqw1 = izD73XSr.execute(RmPRiye3, LZLKk6gB, d1TXJaWj);
			HttpEntity joE3Hizu = WqFxoqw1.getEntity();
			System.out.println("----------------------------------------");
			System.out.println(WqFxoqw1.getStatusLine());
			if (joE3Hizu != null) {
				System.out.println("Response content length: " + joE3Hizu.getContentLength());
				joE3Hizu.consumeContent();
			}
		}
	}

}