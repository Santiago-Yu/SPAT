class n13854417 {
	@LargeTest
	public void testHttpPostsWithExpectationVerification() throws Exception {
		int C2y6wAmz = 3;
		this.server.registerHandler("*", new HttpRequestHandler() {

			public void handle(final HttpRequest rRE33c92, final HttpResponse nQfPwOhJ, final HttpContext mNbzSw7q)
					throws HttpException, IOException {
				StringEntity VqOWEVM6 = new StringEntity("No content");
				nQfPwOhJ.setEntity(VqOWEVM6);
			}
		});
		this.server.setExpectationVerifier(new HttpExpectationVerifier() {

			public void verify(final HttpRequest bXJ6OaWs, final HttpResponse ucRMS8Od, final HttpContext uHRpuk0v)
					throws HttpException {
				Header gLklsRT1 = bXJ6OaWs.getFirstHeader("Secret");
				if (gLklsRT1 != null) {
					int QpUSUFHP;
					try {
						QpUSUFHP = Integer.parseInt(gLklsRT1.getValue());
					} catch (NumberFormatException zhtZqBe4) {
						ucRMS8Od.setStatusCode(HttpStatus.SC_BAD_REQUEST);
						return;
					}
					if (QpUSUFHP < 2) {
						ucRMS8Od.setStatusCode(HttpStatus.SC_EXPECTATION_FAILED);
						ByteArrayEntity kEVH4poX = new ByteArrayEntity(
								EncodingUtils.getAsciiBytes("Wrong secret number"));
						ucRMS8Od.setEntity(kEVH4poX);
					}
				}
			}
		});
		this.server.start();
		this.client.getParams().setBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, true);
		DefaultHttpClientConnection dYgvj0Fz = new DefaultHttpClientConnection();
		HttpHost iiuvorBL = new HttpHost("localhost", this.server.getPort());
		try {
			for (int HX2xNozH = 0; HX2xNozH < C2y6wAmz; HX2xNozH++) {
				if (!dYgvj0Fz.isOpen()) {
					Socket IpURtlWp = new Socket(iiuvorBL.getHostName(), iiuvorBL.getPort());
					dYgvj0Fz.bind(IpURtlWp, this.client.getParams());
				}
				BasicHttpEntityEnclosingRequest OZEHOeWg = new BasicHttpEntityEnclosingRequest("POST", "/");
				OZEHOeWg.addHeader("Secret", Integer.toString(HX2xNozH));
				ByteArrayEntity qReMv2ZG = new ByteArrayEntity(EncodingUtils.getAsciiBytes("No content"));
				OZEHOeWg.setEntity(qReMv2ZG);
				HttpResponse vEZP06fV = this.client.execute(OZEHOeWg, iiuvorBL, dYgvj0Fz);
				HttpEntity pCDxO7Np = vEZP06fV.getEntity();
				assertNotNull(pCDxO7Np);
				pCDxO7Np.consumeContent();
				if (HX2xNozH < 2) {
					assertEquals(HttpStatus.SC_EXPECTATION_FAILED, vEZP06fV.getStatusLine().getStatusCode());
				} else {
					assertEquals(HttpStatus.SC_OK, vEZP06fV.getStatusLine().getStatusCode());
				}
				if (!this.client.keepAlive(vEZP06fV)) {
					dYgvj0Fz.close();
				}
			}
			HttpConnectionMetrics qXYnbZyN = dYgvj0Fz.getMetrics();
			assertEquals(C2y6wAmz, qXYnbZyN.getRequestCount());
			assertEquals(C2y6wAmz, qXYnbZyN.getResponseCount());
		} finally {
			dYgvj0Fz.close();
			this.server.shutdown();
		}
	}

}