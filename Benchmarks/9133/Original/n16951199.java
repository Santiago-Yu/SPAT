class n16951199{
    public void testReleaseOnIOException() throws Exception {
        localServer.register("/dropdead", new HttpRequestHandler() {

            public void handle(final HttpRequest request, final HttpResponse response, final HttpContext context) throws HttpException, IOException {
                BasicHttpEntity entity = new BasicHttpEntity() {

                    @Override
                    public void writeTo(final OutputStream outstream) throws IOException {
                        byte[] tmp = new byte[5];
                        outstream.write(tmp);
                        outstream.flush();
                        DefaultHttpServerConnection conn = (DefaultHttpServerConnection) context.getAttribute(ExecutionContext.HTTP_CONNECTION);
                        try {
                            conn.sendResponseHeader(response);
                        } catch (HttpException ignore) {
                        }
                    }
                };
                entity.setChunked(true);
                response.setEntity(entity);
            }
        });
        HttpParams params = defaultParams.copy();
        ConnManagerParams.setMaxTotalConnections(params, 1);
        ConnManagerParams.setMaxConnectionsPerRoute(params, new ConnPerRouteBean(1));
        ThreadSafeClientConnManager mgr = createTSCCM(params, null);
        assertEquals(0, mgr.getConnectionsInPool());
        DefaultHttpClient client = new DefaultHttpClient(mgr, params);
        HttpGet httpget = new HttpGet("/dropdead");
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
        try {
            EntityUtils.toByteArray(e);
            fail("MalformedChunkCodingException should have been thrown");
        } catch (MalformedChunkCodingException expected) {
        }
        assertEquals(0, mgr.getConnectionsInPool());
        connreq = mgr.requestConnection(new HttpRoute(target), null);
        ManagedClientConnection conn = connreq.getConnection(250, TimeUnit.MILLISECONDS);
        mgr.releaseConnection(conn, -1, null);
        mgr.shutdown();
    }

}