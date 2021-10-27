class n15354003 {
	public void testAddCommandProcessor() throws Exception {
		int port = DEFAULT_PORT;
		String host = "localhost";
		URL url = new URL("http://" + host + ":" + port + "/nonexistant");
		URLConnection connection = null;
		server.invoke(name, "addCommandProcessor", new Object[] { "nonexistant", new DummyCommandProcessor() },
				new String[] { "java.lang.String", "mx4j.tools.adaptor.http.HttpCommandProcessor" });
		connection = url.openConnection();
		assertEquals(200, ((HttpURLConnection) connection).getResponseCode());
		server.invoke(name, "removeCommandProcessor", new Object[] { "nonexistant" },
				new String[] { "java.lang.String" });
		connection = url.openConnection();
		assertEquals(404, ((HttpURLConnection) connection).getResponseCode());
		server.invoke(name, "addCommandProcessor",
				new Object[] { "nonexistant", "test.mx4j.tools.adaptor.http.HttpAdaptorTest$DummyCommandProcessor" },
				new String[] { "java.lang.String", "java.lang.String" });
		connection = url.openConnection();
		assertEquals(200, ((HttpURLConnection) connection).getResponseCode());
	}

}