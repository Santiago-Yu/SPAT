class n6856319{
    public void testReleaseConnectionOnAbort() throws Exception {
        HttpParams mgrpar = defaultParams.copy();
        ConnManagerParams.setMaxTotalConnections(mgrpar, 1);
        ThreadSafeClientConnManager mgr = createTSCCM(mgrpar, null);
        final HttpHost target = getServerHttp();
        final HttpRoute route = new HttpRoute(target, null, false);
        final int rsplen = 8;
        final String uri = "/random/" + rsplen;
        HttpRequest request = new BasicHttpRequest("GET", uri, HttpVersion.HTTP_1_1);
        ManagedClientConnection conn = getConnection(mgr, route);
        conn.open(route, httpContext, defaultParams);
        HttpResponse response = Helper.execute(request, conn, target, httpExecutor, httpProcessor, defaultParams, httpContext);
        assertEquals("wrong status in first response", HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        try {
            getConnection(mgr, route, 100L, TimeUnit.MILLISECONDS);
            fail("ConnectionPoolTimeoutException should have been thrown");
        } catch (ConnectionPoolTimeoutException e) {
        }
        assertTrue(conn instanceof AbstractClientConnAdapter);
        ((AbstractClientConnAdapter) conn).abortConnection();
        conn = getConnection(mgr, route, 5L, TimeUnit.SECONDS);
        assertFalse("connection should have been closed", conn.isOpen());
        mgr.releaseConnection(conn, -1, null);
        mgr.shutdown();
    }

}