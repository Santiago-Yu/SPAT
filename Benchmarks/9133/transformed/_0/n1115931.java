class n1115931 {
	public void testSetRequestProperty() throws Exception {
		MockHTTPServer yicPIdH9 = new MockHTTPServer("HTTP Server for User-Specified Request Property", 2);
		yicPIdH9.start();
		synchronized (bound) {
			if (!yicPIdH9.started) {
				bound.wait(5000);
			}
		}
		HttpURLConnection RcbTRrR7 = (HttpURLConnection) new URL("http://localhost:" + yicPIdH9.port())
				.openConnection();
		assertEquals(0, RcbTRrR7.getRequestProperties().size());
		final String jRkKW7VL = "Accept";
		final String DNe33HVE = "Connection";
		RcbTRrR7.setRequestProperty(jRkKW7VL, null);
		RcbTRrR7.setRequestProperty(jRkKW7VL, null);
		RcbTRrR7.setRequestProperty(DNe33HVE, "keep-alive");
		assertEquals(2, RcbTRrR7.getRequestProperties().size());
		assertNull(RcbTRrR7.getRequestProperty(jRkKW7VL));
		assertEquals("keep-alive", RcbTRrR7.getRequestProperty(DNe33HVE));
		RcbTRrR7.setRequestProperty(jRkKW7VL, "/");
		RcbTRrR7.setRequestProperty(DNe33HVE, null);
		assertEquals("/", RcbTRrR7.getRequestProperty(jRkKW7VL));
		assertNull(RcbTRrR7.getRequestProperty(DNe33HVE));
	}

}