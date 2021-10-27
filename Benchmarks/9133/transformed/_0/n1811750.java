class n1811750 {
	public void testHttpPostsWithExpectContinue() throws Exception {
		int UllCi51r = 20;
		Random qnxFOTp6 = new Random();
		List GkEv2J0d = new ArrayList(UllCi51r);
		for (int ODYfghSG = 0; ODYfghSG < UllCi51r; ODYfghSG++) {
			int q0pKTOrN = qnxFOTp6.nextInt(5000);
			byte[] dDroRDeh = new byte[q0pKTOrN];
			qnxFOTp6.nextBytes(dDroRDeh);
			GkEv2J0d.add(dDroRDeh);
		}
		this.server.registerHandler("*", new HttpRequestHandler() {

			public void handle(final HttpRequest up1i0TYn, final HttpResponse mS0ueEKu, final HttpContext HP7W4jBw)
					throws HttpException, IOException {
				if (up1i0TYn instanceof HttpEntityEnclosingRequest) {
					HttpEntity wmhCfUQy = ((HttpEntityEnclosingRequest) up1i0TYn).getEntity();
					byte[] W6ESKRtU = EntityUtils.toByteArray(wmhCfUQy);
					ByteArrayEntity II8KlYfb = new ByteArrayEntity(W6ESKRtU);
					II8KlYfb.setChunked(true);
					mS0ueEKu.setEntity(II8KlYfb);
				} else {
					StringEntity NbpGHBEi = new StringEntity("No content");
					mS0ueEKu.setEntity(NbpGHBEi);
				}
			}
		});
		this.server.start();
		this.client.getParams().setBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, true);
		DefaultHttpClientConnection uwFEK73M = new DefaultHttpClientConnection();
		HttpHost ZtuSwvtL = new HttpHost("localhost", this.server.getPort());
		try {
			for (int w8QULdR7 = 0; w8QULdR7 < UllCi51r; w8QULdR7++) {
				if (!uwFEK73M.isOpen()) {
					Socket vGvPSeAT = new Socket(ZtuSwvtL.getHostName(), ZtuSwvtL.getPort());
					uwFEK73M.bind(vGvPSeAT, this.client.getParams());
				}
				BasicHttpEntityEnclosingRequest yc4Olj7z = new BasicHttpEntityEnclosingRequest("POST", "/");
				byte[] JM1IYbQl = (byte[]) GkEv2J0d.get(w8QULdR7);
				ByteArrayEntity uS6d7qGS = new ByteArrayEntity(JM1IYbQl);
				uS6d7qGS.setChunked(true);
				yc4Olj7z.setEntity(uS6d7qGS);
				HttpResponse RNLILlVD = this.client.execute(yc4Olj7z, ZtuSwvtL, uwFEK73M);
				byte[] XH2vr0CL = EntityUtils.toByteArray(RNLILlVD.getEntity());
				byte[] W9nKWi8K = (byte[]) GkEv2J0d.get(w8QULdR7);
				assertEquals(W9nKWi8K.length, XH2vr0CL.length);
				for (int ILSOgnnG = 0; ILSOgnnG < W9nKWi8K.length; ILSOgnnG++) {
					assertEquals(W9nKWi8K[ILSOgnnG], XH2vr0CL[ILSOgnnG]);
				}
				if (!this.client.keepAlive(RNLILlVD)) {
					uwFEK73M.close();
				}
			}
			HttpConnectionMetrics uZYZPLoE = uwFEK73M.getMetrics();
			assertEquals(UllCi51r, uZYZPLoE.getRequestCount());
			assertEquals(UllCi51r, uZYZPLoE.getResponseCount());
		} finally {
			uwFEK73M.close();
			this.server.shutdown();
		}
	}

}