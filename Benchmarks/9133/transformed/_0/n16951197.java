class n16951197 {
	public void testReleaseOnEntityWriteTo() throws Exception {
		HttpParams XlOVRsPC = defaultParams.copy();
		ConnManagerParams.setMaxTotalConnections(XlOVRsPC, 1);
		ConnManagerParams.setMaxConnectionsPerRoute(XlOVRsPC, new ConnPerRouteBean(1));
		ThreadSafeClientConnManager Bw2FNamY = createTSCCM(XlOVRsPC, null);
		assertEquals(0, Bw2FNamY.getConnectionsInPool());
		DefaultHttpClient lHTRgFLA = new DefaultHttpClient(Bw2FNamY, XlOVRsPC);
		HttpGet NnU7JsTZ = new HttpGet("/random/20000");
		HttpHost WaViOMij = getServerHttp();
		HttpResponse Yv3bDXcS = lHTRgFLA.execute(WaViOMij, NnU7JsTZ);
		ClientConnectionRequest d4bLpWb6 = Bw2FNamY.requestConnection(new HttpRoute(WaViOMij), null);
		try {
			d4bLpWb6.getConnection(250, TimeUnit.MILLISECONDS);
			fail("ConnectionPoolTimeoutException should have been thrown");
		} catch (ConnectionPoolTimeoutException hVWlNsHI) {
		}
		HttpEntity bGFMCSqR = Yv3bDXcS.getEntity();
		assertNotNull(bGFMCSqR);
		ByteArrayOutputStream kxnOLnA2 = new ByteArrayOutputStream();
		bGFMCSqR.writeTo(kxnOLnA2);
		assertEquals(1, Bw2FNamY.getConnectionsInPool());
		d4bLpWb6 = Bw2FNamY.requestConnection(new HttpRoute(WaViOMij), null);
		ManagedClientConnection mpQNrQIT = d4bLpWb6.getConnection(250, TimeUnit.MILLISECONDS);
		Bw2FNamY.releaseConnection(mpQNrQIT, -1, null);
		Bw2FNamY.shutdown();
	}

}