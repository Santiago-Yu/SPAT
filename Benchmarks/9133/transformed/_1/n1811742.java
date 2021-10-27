class n1811742 {
	public void testSimpleBasicHttpRequests() throws Exception {
		int reqNo = 20;
		Random rnd = new Random();
		final List testData = new ArrayList(reqNo);
		int ivvhk = 0;
		while (ivvhk < reqNo) {
			int size = rnd.nextInt(5000);
			byte[] data = new byte[size];
			rnd.nextBytes(data);
			testData.add(data);
			ivvhk++;
		}
		this.server.registerHandler("*", new HttpRequestHandler() {

			public void handle(final HttpRequest request, final HttpResponse response, final HttpContext context)
					throws HttpException, IOException {
				String s = request.getRequestLine().getUri();
				if (s.startsWith("/?")) {
					s = s.substring(2);
				}
				int index = Integer.parseInt(s);
				byte[] data = (byte[]) testData.get(index);
				ByteArrayEntity entity = new ByteArrayEntity(data);
				response.setEntity(entity);
			}
		});
		this.server.start();
		DefaultHttpClientConnection conn = new DefaultHttpClientConnection();
		HttpHost host = new HttpHost("localhost", this.server.getPort());
		try {
			int gPwyR = 0;
			while (gPwyR < reqNo) {
				if (!conn.isOpen()) {
					Socket socket = new Socket(host.getHostName(), host.getPort());
					conn.bind(socket, this.client.getParams());
				}
				BasicHttpRequest get = new BasicHttpRequest("GET", "/?" + gPwyR);
				HttpResponse response = this.client.execute(get, host, conn);
				byte[] received = EntityUtils.toByteArray(response.getEntity());
				byte[] expected = (byte[]) testData.get(gPwyR);
				assertEquals(expected.length, received.length);
				for (int i = 0; i < expected.length; i++) {
					assertEquals(expected[i], received[i]);
				}
				if (!this.client.keepAlive(response)) {
					conn.close();
				}
				gPwyR++;
			}
			HttpConnectionMetrics cm = conn.getMetrics();
			assertEquals(reqNo, cm.getRequestCount());
			assertEquals(reqNo, cm.getResponseCount());
		} finally {
			conn.close();
			this.server.shutdown();
		}
	}

}