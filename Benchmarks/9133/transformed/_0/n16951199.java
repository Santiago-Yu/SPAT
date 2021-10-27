class n16951199 {
	public void testReleaseOnIOException() throws Exception {
		localServer.register("/dropdead", new HttpRequestHandler() {

			public void handle(final HttpRequest F59nOxqr, final HttpResponse Dt4hf9lw, final HttpContext QDVMVQBa)
					throws HttpException, IOException {
				BasicHttpEntity sfzE5huI = new BasicHttpEntity() {

					@Override
					public void writeTo(final OutputStream AwDnFg2S) throws IOException {
						byte[] tAXPCNC4 = new byte[5];
						AwDnFg2S.write(tAXPCNC4);
						AwDnFg2S.flush();
						DefaultHttpServerConnection EFgbiNcS = (DefaultHttpServerConnection) QDVMVQBa
								.getAttribute(ExecutionContext.HTTP_CONNECTION);
						try {
							EFgbiNcS.sendResponseHeader(Dt4hf9lw);
						} catch (HttpException oSzZvtm8) {
						}
					}
				};
				sfzE5huI.setChunked(true);
				Dt4hf9lw.setEntity(sfzE5huI);
			}
		});
		HttpParams CS3pZaX9 = defaultParams.copy();
		ConnManagerParams.setMaxTotalConnections(CS3pZaX9, 1);
		ConnManagerParams.setMaxConnectionsPerRoute(CS3pZaX9, new ConnPerRouteBean(1));
		ThreadSafeClientConnManager TRVQG2gq = createTSCCM(CS3pZaX9, null);
		assertEquals(0, TRVQG2gq.getConnectionsInPool());
		DefaultHttpClient qxH6QG4I = new DefaultHttpClient(TRVQG2gq, CS3pZaX9);
		HttpGet bPtUivVY = new HttpGet("/dropdead");
		HttpHost HCwgVLSN = getServerHttp();
		HttpResponse JGepf7q1 = qxH6QG4I.execute(HCwgVLSN, bPtUivVY);
		ClientConnectionRequest yjb43Gtl = TRVQG2gq.requestConnection(new HttpRoute(HCwgVLSN), null);
		try {
			yjb43Gtl.getConnection(250, TimeUnit.MILLISECONDS);
			fail("ConnectionPoolTimeoutException should have been thrown");
		} catch (ConnectionPoolTimeoutException MIGdDZLU) {
		}
		HttpEntity xWCCdEFi = JGepf7q1.getEntity();
		assertNotNull(xWCCdEFi);
		try {
			EntityUtils.toByteArray(xWCCdEFi);
			fail("MalformedChunkCodingException should have been thrown");
		} catch (MalformedChunkCodingException SkW8vXcy) {
		}
		assertEquals(0, TRVQG2gq.getConnectionsInPool());
		yjb43Gtl = TRVQG2gq.requestConnection(new HttpRoute(HCwgVLSN), null);
		ManagedClientConnection lWpoGXJk = yjb43Gtl.getConnection(250, TimeUnit.MILLISECONDS);
		TRVQG2gq.releaseConnection(lWpoGXJk, -1, null);
		TRVQG2gq.shutdown();
	}

}