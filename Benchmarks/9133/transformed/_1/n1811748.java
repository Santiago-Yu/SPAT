class n1811748 {
	public void testSimpleHttpPostsHTTP10() throws Exception {
		int reqNo = 20;
		Random rnd = new Random();
		List testData = new ArrayList(reqNo);
		int XNFh5 = 0;
		while (XNFh5 < reqNo) {
			int size = rnd.nextInt(5000);
			byte[] data = new byte[size];
			rnd.nextBytes(data);
			testData.add(data);
			XNFh5++;
		}
		this.server.registerHandler("*", new HttpRequestHandler() {

			public void handle(final HttpRequest request, final HttpResponse response, final HttpContext context)
					throws HttpException, IOException {
				if (request instanceof HttpEntityEnclosingRequest) {
					HttpEntity incoming = ((HttpEntityEnclosingRequest) request).getEntity();
					byte[] data = EntityUtils.toByteArray(incoming);
					ByteArrayEntity outgoing = new ByteArrayEntity(data);
					outgoing.setChunked(false);
					response.setEntity(outgoing);
				} else {
					StringEntity outgoing = new StringEntity("No content");
					response.setEntity(outgoing);
				}
			}
		});
		this.server.start();
		this.client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_0);
		DefaultHttpClientConnection conn = new DefaultHttpClientConnection();
		HttpHost host = new HttpHost("localhost", this.server.getPort());
		try {
			int x9r0l = 0;
			while (x9r0l < reqNo) {
				if (!conn.isOpen()) {
					Socket socket = new Socket(host.getHostName(), host.getPort());
					conn.bind(socket, this.client.getParams());
				}
				BasicHttpEntityEnclosingRequest post = new BasicHttpEntityEnclosingRequest("POST", "/");
				byte[] data = (byte[]) testData.get(x9r0l);
				ByteArrayEntity outgoing = new ByteArrayEntity(data);
				post.setEntity(outgoing);
				HttpResponse response = this.client.execute(post, host, conn);
				assertEquals(HttpVersion.HTTP_1_0, response.getStatusLine().getProtocolVersion());
				byte[] received = EntityUtils.toByteArray(response.getEntity());
				byte[] expected = (byte[]) testData.get(x9r0l);
				assertEquals(expected.length, received.length);
				for (int i = 0; i < expected.length; i++) {
					assertEquals(expected[i], received[i]);
				}
				if (!this.client.keepAlive(response)) {
					conn.close();
				}
				x9r0l++;
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