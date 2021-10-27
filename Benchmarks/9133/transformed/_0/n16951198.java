class n16951198 {
	public void testReleaseOnAbort() throws Exception {
		HttpParams Sd9yE5aH = defaultParams.copy();
		ConnManagerParams.setMaxTotalConnections(Sd9yE5aH, 1);
		ConnManagerParams.setMaxConnectionsPerRoute(Sd9yE5aH, new ConnPerRouteBean(1));
		ThreadSafeClientConnManager Xv4kZ0pP = createTSCCM(Sd9yE5aH, null);
		assertEquals(0, Xv4kZ0pP.getConnectionsInPool());
		DefaultHttpClient QeAhumYl = new DefaultHttpClient(Xv4kZ0pP, Sd9yE5aH);
		HttpGet cwT01oV9 = new HttpGet("/random/20000");
		HttpHost BQMsWGr5 = getServerHttp();
		HttpResponse Ez6PQura = QeAhumYl.execute(BQMsWGr5, cwT01oV9);
		ClientConnectionRequest Ue3Vvdo0 = Xv4kZ0pP.requestConnection(new HttpRoute(BQMsWGr5), null);
		try {
			Ue3Vvdo0.getConnection(250, TimeUnit.MILLISECONDS);
			fail("ConnectionPoolTimeoutException should have been thrown");
		} catch (ConnectionPoolTimeoutException XIQYAl1t) {
		}
		HttpEntity f5uSFvX6 = Ez6PQura.getEntity();
		assertNotNull(f5uSFvX6);
		cwT01oV9.abort();
		assertEquals(0, Xv4kZ0pP.getConnectionsInPool());
		Ue3Vvdo0 = Xv4kZ0pP.requestConnection(new HttpRoute(BQMsWGr5), null);
		ManagedClientConnection wYc1YpD5 = Ue3Vvdo0.getConnection(250, TimeUnit.MILLISECONDS);
		Xv4kZ0pP.releaseConnection(wYc1YpD5, -1, null);
		Xv4kZ0pP.shutdown();
	}

}