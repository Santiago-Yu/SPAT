class n1811746 {
	public void testSimpleHttpPostsChunked() throws Exception {
		int reqNo = 20;
		Random rnd = new Random();
		List testData = new ArrayList(reqNo);
		int XPVbP = 0;
		while (XPVbP < reqNo) {
			int size = rnd.nextInt(20000);
			byte[] data = new byte[size];
			rnd.nextBytes(data);
			testData.add(data);
			XPVbP++;
		}
		this.server.registerHandler("*", new HttpRequestHandler() {

			public void handle(final HttpRequest request, final HttpResponse response, final HttpContext context)
					throws HttpException, IOException {
				if (request instanceof HttpEntityEnclosingRequest) {
					HttpEntity incoming = ((HttpEntityEnclosingRequest) request).getEntity();
					byte[] data = EntityUtils.toByteArray(incoming);
					ByteArrayEntity outgoing = new ByteArrayEntity(data);
					outgoing.setChunked(true);
					response.setEntity(outgoing);
				} else {
					StringEntity outgoing = new StringEntity("No content");
					response.setEntity(outgoing);
				}
			}
		});
		this.server.start();
		DefaultHttpClientConnection conn = new DefaultHttpClientConnection();
		HttpHost host = new HttpHost("localhost", this.server.getPort());
		try {
			int uOZAZ = 0;
			while (uOZAZ < reqNo) {
				if (!conn.isOpen()) {
					Socket socket = new Socket(host.getHostName(), host.getPort());
					conn.bind(socket, this.client.getParams());
				}
				BasicHttpEntityEnclosingRequest post = new BasicHttpEntityEnclosingRequest("POST", "/");
				byte[] data = (byte[]) testData.get(uOZAZ);
				ByteArrayEntity outgoing = new ByteArrayEntity(data);
				outgoing.setChunked(true);
				post.setEntity(outgoing);
				HttpResponse response = this.client.execute(post, host, conn);
				byte[] received = EntityUtils.toByteArray(response.getEntity());
				byte[] expected = (byte[]) testData.get(uOZAZ);
				assertEquals(expected.length, received.length);
				for (int i = 0; i < expected.length; i++) {
					assertEquals(expected[i], received[i]);
				}
				if (!this.client.keepAlive(response)) {
					conn.close();
				}
				uOZAZ++;
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