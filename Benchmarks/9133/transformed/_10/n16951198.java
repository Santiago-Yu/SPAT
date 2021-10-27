class n16951198 {
	public void testReleaseOnAbort() throws Exception {
		HttpParams params = defaultParams.copy();
		ConnManagerParams.setMaxTotalConnections(params, 1);
		ConnManagerParams.setMaxConnectionsPerRoute(params, new ConnPerRouteBean(1));
		ThreadSafeClientConnManager mgr = createTSCCM(params, null);
		assertEquals(0, mgr.getConnectionsInPool());
		HttpGet httpget = new HttpGet("/random/20000");
		DefaultHttpClient client = new DefaultHttpClient(mgr, params);
		HttpHost target = getServerHttp();
		HttpResponse response = client.execute(target, httpget);
		ClientConnectionRequest connreq = mgr.requestConnection(new HttpRoute(target), null);
		try {
			connreq.getConnection(250, TimeUnit.MILLISECONDS);
			fail("ConnectionPoolTimeoutException should have been thrown");
		} catch (ConnectionPoolTimeoutException expected) {
		}
		HttpEntity e = response.getEntity();
		assertNotNull(e);
		httpget.abort();
		assertEquals(0, mgr.getConnectionsInPool());
		connreq = mgr.requestConnection(new HttpRoute(target), null);
		ManagedClientConnection conn = connreq.getConnection(250, TimeUnit.MILLISECONDS);
		mgr.releaseConnection(conn, -1, null);
		mgr.shutdown();
	}

}