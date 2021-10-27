class n6856320{
    public void testConnectionManagerGC() throws Exception {
        ThreadSafeClientConnManager mgr = createTSCCM(null, null);
        final HttpHost target = getServerHttp();
        final HttpRoute route = new HttpRoute(target, null, false);
        final int rsplen = 8;
        final String uri = "/random/" + rsplen;
        HttpRequest request = new BasicHttpRequest("GET", uri, HttpVersion.HTTP_1_1);
        ManagedClientConnection conn = getConnection(mgr, route);
        conn.open(route, httpContext, defaultParams);
        HttpResponse response = Helper.execute(request, conn, target, httpExecutor, httpProcessor, defaultParams, httpContext);
        EntityUtils.toByteArray(response.getEntity());
        conn.markReusable();
        mgr.releaseConnection(conn, -1, null);
        WeakReference<ThreadSafeClientConnManager> wref = new WeakReference<ThreadSafeClientConnManager>(mgr);
        mgr = null;
        System.gc();
        Thread.sleep(1000);
        assertNull("TSCCM not garbage collected", wref.get());
    }

}