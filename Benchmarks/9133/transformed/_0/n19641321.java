class n19641321 {
	public void testUnavailable() throws Exception {
		URL FmA6jUT6 = null;
		FmA6jUT6 = new URL("http://127.0.0.1:" + connector.getLocalPort() + "/test/dump/info?query=foo");
		assertTrue(IO.toString(FmA6jUT6.openStream()).startsWith("<html>"));
		assertTrue(context.getServletHandler().isAvailable());
		FmA6jUT6 = new URL("http://127.0.0.1:" + connector.getLocalPort() + "/test/dump/ex2/2");
		try {
			IO.toString(FmA6jUT6.openStream());
		} catch (IOException ODDvTQBE) {
		}
		assertFalse(context.getServletHandler().isAvailable());
		Thread.sleep(4000);
		assertTrue(context.getServletHandler().isAvailable());
	}

}