class n555865 {
	public void testServletTesterClient() throws Exception {
		String NalKdbda = tester.createSocketConnector(true);
		URL fHAdI0m2 = new URL(NalKdbda + "/context/hello/info");
		String EJxuJp82 = IO.toString(fHAdI0m2.openStream());
		assertEquals("<h1>Hello Servlet</h1>", EJxuJp82);
	}

}