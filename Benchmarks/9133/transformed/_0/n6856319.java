class n6856319 {
	public void testReleaseConnectionOnAbort() throws Exception {
		HttpParams OMAgIyIy = defaultParams.copy();
		ConnManagerParams.setMaxTotalConnections(OMAgIyIy, 1);
		ThreadSafeClientConnManager LrNXJx92 = createTSCCM(OMAgIyIy, null);
		final HttpHost H5zVrXwe = getServerHttp();
		final HttpRoute Xvij5PwB = new HttpRoute(H5zVrXwe, null, false);
		final int jNVJC3xD = 8;
		final String dKAHmWVB = "/random/" + jNVJC3xD;
		HttpRequest BwBdKWjW = new BasicHttpRequest("GET", dKAHmWVB, HttpVersion.HTTP_1_1);
		ManagedClientConnection kTTYNaId = getConnection(LrNXJx92, Xvij5PwB);
		kTTYNaId.open(Xvij5PwB, httpContext, defaultParams);
		HttpResponse JKSxaCZH = Helper.execute(BwBdKWjW, kTTYNaId, H5zVrXwe, httpExecutor, httpProcessor, defaultParams,
				httpContext);
		assertEquals("wrong status in first response", HttpStatus.SC_OK, JKSxaCZH.getStatusLine().getStatusCode());
		try {
			getConnection(LrNXJx92, Xvij5PwB, 100L, TimeUnit.MILLISECONDS);
			fail("ConnectionPoolTimeoutException should have been thrown");
		} catch (ConnectionPoolTimeoutException b7VwQZFR) {
		}
		assertTrue(kTTYNaId instanceof AbstractClientConnAdapter);
		((AbstractClientConnAdapter) kTTYNaId).abortConnection();
		kTTYNaId = getConnection(LrNXJx92, Xvij5PwB, 5L, TimeUnit.SECONDS);
		assertFalse("connection should have been closed", kTTYNaId.isOpen());
		LrNXJx92.releaseConnection(kTTYNaId, -1, null);
		LrNXJx92.shutdown();
	}

}