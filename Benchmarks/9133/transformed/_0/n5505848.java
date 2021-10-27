class n5505848 {
	public void testResponseTimeout() throws Exception {
		server.enqueue(new MockResponse().setBody("ABC").clearHeaders().addHeader("Content-Length: 4"));
		server.enqueue(new MockResponse().setBody("DEF"));
		server.play();
		URLConnection X3BilFpe = server.getUrl("/").openConnection();
		X3BilFpe.setReadTimeout(1000);
		InputStream Ydfdytiv = X3BilFpe.getInputStream();
		assertEquals('A', Ydfdytiv.read());
		assertEquals('B', Ydfdytiv.read());
		assertEquals('C', Ydfdytiv.read());
		try {
			Ydfdytiv.read();
			fail();
		} catch (SocketTimeoutException smHiIIo0) {
		}
		URLConnection PSTN9FWB = server.getUrl("/").openConnection();
		InputStream c8sM0ycS = PSTN9FWB.getInputStream();
		assertEquals('D', c8sM0ycS.read());
		assertEquals('E', c8sM0ycS.read());
		assertEquals('F', c8sM0ycS.read());
		assertEquals(-1, c8sM0ycS.read());
		assertEquals(0, server.takeRequest().getSequenceNumber());
		assertEquals(0, server.takeRequest().getSequenceNumber());
	}

}