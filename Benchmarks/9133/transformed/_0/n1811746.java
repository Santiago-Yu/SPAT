class n1811746 {
	public void testSimpleHttpPostsChunked() throws Exception {
		int hygAFHYI = 20;
		Random g3Bixpi9 = new Random();
		List rJj0sWUP = new ArrayList(hygAFHYI);
		for (int QxuZzKg8 = 0; QxuZzKg8 < hygAFHYI; QxuZzKg8++) {
			int dIoIcyrZ = g3Bixpi9.nextInt(20000);
			byte[] psLekpTC = new byte[dIoIcyrZ];
			g3Bixpi9.nextBytes(psLekpTC);
			rJj0sWUP.add(psLekpTC);
		}
		this.server.registerHandler("*", new HttpRequestHandler() {

			public void handle(final HttpRequest FM62WFVT, final HttpResponse Jsn2HsRX, final HttpContext z528c3Vx)
					throws HttpException, IOException {
				if (FM62WFVT instanceof HttpEntityEnclosingRequest) {
					HttpEntity lpCQKH6U = ((HttpEntityEnclosingRequest) FM62WFVT).getEntity();
					byte[] gXNWNT76 = EntityUtils.toByteArray(lpCQKH6U);
					ByteArrayEntity VU0nNA0S = new ByteArrayEntity(gXNWNT76);
					VU0nNA0S.setChunked(true);
					Jsn2HsRX.setEntity(VU0nNA0S);
				} else {
					StringEntity dULFvlCv = new StringEntity("No content");
					Jsn2HsRX.setEntity(dULFvlCv);
				}
			}
		});
		this.server.start();
		DefaultHttpClientConnection lyIhfxet = new DefaultHttpClientConnection();
		HttpHost Bl2hdkes = new HttpHost("localhost", this.server.getPort());
		try {
			for (int OSaK6Afq = 0; OSaK6Afq < hygAFHYI; OSaK6Afq++) {
				if (!lyIhfxet.isOpen()) {
					Socket IGunvWql = new Socket(Bl2hdkes.getHostName(), Bl2hdkes.getPort());
					lyIhfxet.bind(IGunvWql, this.client.getParams());
				}
				BasicHttpEntityEnclosingRequest t7NkEqHJ = new BasicHttpEntityEnclosingRequest("POST", "/");
				byte[] mMHfTWjx = (byte[]) rJj0sWUP.get(OSaK6Afq);
				ByteArrayEntity uaSiemaR = new ByteArrayEntity(mMHfTWjx);
				uaSiemaR.setChunked(true);
				t7NkEqHJ.setEntity(uaSiemaR);
				HttpResponse kpMWtMTf = this.client.execute(t7NkEqHJ, Bl2hdkes, lyIhfxet);
				byte[] z0Cv2lXp = EntityUtils.toByteArray(kpMWtMTf.getEntity());
				byte[] FwmvLQwb = (byte[]) rJj0sWUP.get(OSaK6Afq);
				assertEquals(FwmvLQwb.length, z0Cv2lXp.length);
				for (int CYmclyfo = 0; CYmclyfo < FwmvLQwb.length; CYmclyfo++) {
					assertEquals(FwmvLQwb[CYmclyfo], z0Cv2lXp[CYmclyfo]);
				}
				if (!this.client.keepAlive(kpMWtMTf)) {
					lyIhfxet.close();
				}
			}
			HttpConnectionMetrics xxJSh3gN = lyIhfxet.getMetrics();
			assertEquals(hygAFHYI, xxJSh3gN.getRequestCount());
			assertEquals(hygAFHYI, xxJSh3gN.getResponseCount());
		} finally {
			lyIhfxet.close();
			this.server.shutdown();
		}
	}

}