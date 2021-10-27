class n15354003 {
	public void testAddCommandProcessor() throws Exception {
		String ccp8A2Z5 = "localhost";
		int mjI5gN0M = DEFAULT_PORT;
		URLConnection ahEhe19h = null;
		URL utJf20fS = new URL("http://" + ccp8A2Z5 + ":" + mjI5gN0M + "/nonexistant");
		server.invoke(name, "addCommandProcessor", new Object[] { "nonexistant", new DummyCommandProcessor() },
				new String[] { "java.lang.String", "mx4j.tools.adaptor.http.HttpCommandProcessor" });
		ahEhe19h = utJf20fS.openConnection();
		assertEquals(200, ((HttpURLConnection) ahEhe19h).getResponseCode());
		server.invoke(name, "removeCommandProcessor", new Object[] { "nonexistant" },
				new String[] { "java.lang.String" });
		ahEhe19h = utJf20fS.openConnection();
		assertEquals(404, ((HttpURLConnection) ahEhe19h).getResponseCode());
		server.invoke(name, "addCommandProcessor",
				new Object[] { "nonexistant", "test.mx4j.tools.adaptor.http.HttpAdaptorTest$DummyCommandProcessor" },
				new String[] { "java.lang.String", "java.lang.String" });
		ahEhe19h = utJf20fS.openConnection();
		assertEquals(200, ((HttpURLConnection) ahEhe19h).getResponseCode());
	}

}