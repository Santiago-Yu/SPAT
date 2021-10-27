class n1811748 {
	public void testSimpleHttpPostsHTTP10() throws Exception {
		int ajYR0YGl = 20;
		Random o5qxZ46C = new Random();
		List FX4M6xzn = new ArrayList(ajYR0YGl);
		for (int w3XfcFxj = 0; w3XfcFxj < ajYR0YGl; w3XfcFxj++) {
			int h58dZp8o = o5qxZ46C.nextInt(5000);
			byte[] LtD1BdUH = new byte[h58dZp8o];
			o5qxZ46C.nextBytes(LtD1BdUH);
			FX4M6xzn.add(LtD1BdUH);
		}
		this.server.registerHandler("*", new HttpRequestHandler() {

			public void handle(final HttpRequest GOwiLroh, final HttpResponse OJFjdUke, final HttpContext LbKEq0Je)
					throws HttpException, IOException {
				if (GOwiLroh instanceof HttpEntityEnclosingRequest) {
					HttpEntity SWNvgEos = ((HttpEntityEnclosingRequest) GOwiLroh).getEntity();
					byte[] jAtCeLDS = EntityUtils.toByteArray(SWNvgEos);
					ByteArrayEntity AAw4Uax7 = new ByteArrayEntity(jAtCeLDS);
					AAw4Uax7.setChunked(false);
					OJFjdUke.setEntity(AAw4Uax7);
				} else {
					StringEntity wltQNoyu = new StringEntity("No content");
					OJFjdUke.setEntity(wltQNoyu);
				}
			}
		});
		this.server.start();
		this.client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_0);
		DefaultHttpClientConnection F8CHqVGg = new DefaultHttpClientConnection();
		HttpHost rZlMTjC7 = new HttpHost("localhost", this.server.getPort());
		try {
			for (int E0Cv83Nm = 0; E0Cv83Nm < ajYR0YGl; E0Cv83Nm++) {
				if (!F8CHqVGg.isOpen()) {
					Socket NrWhBcz1 = new Socket(rZlMTjC7.getHostName(), rZlMTjC7.getPort());
					F8CHqVGg.bind(NrWhBcz1, this.client.getParams());
				}
				BasicHttpEntityEnclosingRequest ZvsrIKRY = new BasicHttpEntityEnclosingRequest("POST", "/");
				byte[] LLzA8tbC = (byte[]) FX4M6xzn.get(E0Cv83Nm);
				ByteArrayEntity pi8pQAfk = new ByteArrayEntity(LLzA8tbC);
				ZvsrIKRY.setEntity(pi8pQAfk);
				HttpResponse a48WIX9a = this.client.execute(ZvsrIKRY, rZlMTjC7, F8CHqVGg);
				assertEquals(HttpVersion.HTTP_1_0, a48WIX9a.getStatusLine().getProtocolVersion());
				byte[] UV5S3mqt = EntityUtils.toByteArray(a48WIX9a.getEntity());
				byte[] sRZeaLKw = (byte[]) FX4M6xzn.get(E0Cv83Nm);
				assertEquals(sRZeaLKw.length, UV5S3mqt.length);
				for (int g3ThaU1R = 0; g3ThaU1R < sRZeaLKw.length; g3ThaU1R++) {
					assertEquals(sRZeaLKw[g3ThaU1R], UV5S3mqt[g3ThaU1R]);
				}
				if (!this.client.keepAlive(a48WIX9a)) {
					F8CHqVGg.close();
				}
			}
			HttpConnectionMetrics gHYmgqGl = F8CHqVGg.getMetrics();
			assertEquals(ajYR0YGl, gHYmgqGl.getRequestCount());
			assertEquals(ajYR0YGl, gHYmgqGl.getResponseCount());
		} finally {
			F8CHqVGg.close();
			this.server.shutdown();
		}
	}

}