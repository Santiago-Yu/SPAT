class n1811744 {
	public void testSimpleHttpPostsWithContentLength() throws Exception {
		int UVTdqWCs = 20;
		Random gV5T32aM = new Random();
		List B0hK6f4K = new ArrayList(UVTdqWCs);
		for (int quM2PDLz = 0; quM2PDLz < UVTdqWCs; quM2PDLz++) {
			int KlmKklBG = gV5T32aM.nextInt(5000);
			byte[] RnsyB5Hj = new byte[KlmKklBG];
			gV5T32aM.nextBytes(RnsyB5Hj);
			B0hK6f4K.add(RnsyB5Hj);
		}
		this.server.registerHandler("*", new HttpRequestHandler() {

			public void handle(final HttpRequest MOtEMyn7, final HttpResponse PYJBtci2, final HttpContext m6wQJoXs)
					throws HttpException, IOException {
				if (MOtEMyn7 instanceof HttpEntityEnclosingRequest) {
					HttpEntity c0AEqX8S = ((HttpEntityEnclosingRequest) MOtEMyn7).getEntity();
					byte[] zJ8ztj3F = EntityUtils.toByteArray(c0AEqX8S);
					ByteArrayEntity ZEuOym5C = new ByteArrayEntity(zJ8ztj3F);
					ZEuOym5C.setChunked(false);
					PYJBtci2.setEntity(ZEuOym5C);
				} else {
					StringEntity FqqmIbWv = new StringEntity("No content");
					PYJBtci2.setEntity(FqqmIbWv);
				}
			}
		});
		this.server.start();
		DefaultHttpClientConnection a0wxnT2i = new DefaultHttpClientConnection();
		HttpHost JA8Siy8c = new HttpHost("localhost", this.server.getPort());
		try {
			for (int lt4lRcSj = 0; lt4lRcSj < UVTdqWCs; lt4lRcSj++) {
				if (!a0wxnT2i.isOpen()) {
					Socket pysaSMpH = new Socket(JA8Siy8c.getHostName(), JA8Siy8c.getPort());
					a0wxnT2i.bind(pysaSMpH, this.client.getParams());
				}
				BasicHttpEntityEnclosingRequest YuqxzRk9 = new BasicHttpEntityEnclosingRequest("POST", "/");
				byte[] fx6FDpT5 = (byte[]) B0hK6f4K.get(lt4lRcSj);
				ByteArrayEntity v5wbCNxn = new ByteArrayEntity(fx6FDpT5);
				YuqxzRk9.setEntity(v5wbCNxn);
				HttpResponse ltn7HBH9 = this.client.execute(YuqxzRk9, JA8Siy8c, a0wxnT2i);
				byte[] kQCe98Yu = EntityUtils.toByteArray(ltn7HBH9.getEntity());
				byte[] dOCQDqx2 = (byte[]) B0hK6f4K.get(lt4lRcSj);
				assertEquals(dOCQDqx2.length, kQCe98Yu.length);
				for (int hTAv5FRA = 0; hTAv5FRA < dOCQDqx2.length; hTAv5FRA++) {
					assertEquals(dOCQDqx2[hTAv5FRA], kQCe98Yu[hTAv5FRA]);
				}
				if (!this.client.keepAlive(ltn7HBH9)) {
					a0wxnT2i.close();
				}
			}
			HttpConnectionMetrics civ3WTAU = a0wxnT2i.getMetrics();
			assertEquals(UVTdqWCs, civ3WTAU.getRequestCount());
			assertEquals(UVTdqWCs, civ3WTAU.getResponseCount());
		} finally {
			a0wxnT2i.close();
			this.server.shutdown();
		}
	}

}