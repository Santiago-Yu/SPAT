class n6856320 {
	public void testConnectionManagerGC() throws Exception {
		ThreadSafeClientConnManager SVNw7kuE = createTSCCM(null, null);
		final HttpHost ZQBKr6yi = getServerHttp();
		final HttpRoute wcBatUjd = new HttpRoute(ZQBKr6yi, null, false);
		final int oR3fgzKT = 8;
		final String aXlFFlg9 = "/random/" + oR3fgzKT;
		HttpRequest vYzW071V = new BasicHttpRequest("GET", aXlFFlg9, HttpVersion.HTTP_1_1);
		ManagedClientConnection Pbs0O5LW = getConnection(SVNw7kuE, wcBatUjd);
		Pbs0O5LW.open(wcBatUjd, httpContext, defaultParams);
		HttpResponse hgMkdE5T = Helper.execute(vYzW071V, Pbs0O5LW, ZQBKr6yi, httpExecutor, httpProcessor, defaultParams,
				httpContext);
		EntityUtils.toByteArray(hgMkdE5T.getEntity());
		Pbs0O5LW.markReusable();
		SVNw7kuE.releaseConnection(Pbs0O5LW, -1, null);
		WeakReference<ThreadSafeClientConnManager> nur3kpTw = new WeakReference<ThreadSafeClientConnManager>(SVNw7kuE);
		SVNw7kuE = null;
		System.gc();
		Thread.sleep(1000);
		assertNull("TSCCM not garbage collected", nur3kpTw.get());
	}

}