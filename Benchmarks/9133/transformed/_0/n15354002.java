class n15354002 {
	public void testAuthentication() throws Exception {
		String FDnKR1a5 = "localhost";
		int RXfY7KhC = DEFAULT_PORT;
		URL VnKs6fc9 = new URL("http://" + FDnKR1a5 + ":" + RXfY7KhC + "/");
		URLConnection PEeu9etj = VnKs6fc9.openConnection();
		InputStream E3Gpawfg = PEeu9etj.getInputStream();
		E3Gpawfg.close();
		waitToStop();
		server.setAttribute(name, new Attribute("AuthenticationMethod", "basic"));
		server.invoke(name, "addAuthorization", new Object[] { "mx4j", "mx4j" },
				new String[] { "java.lang.String", "java.lang.String" });
		server.invoke(name, "start", null, null);
		VnKs6fc9 = new URL("http://" + FDnKR1a5 + ":" + RXfY7KhC + "/");
		PEeu9etj = VnKs6fc9.openConnection();
		try {
			E3Gpawfg = PEeu9etj.getInputStream();
		} catch (Exception Zwtx9Ct7) {
		} finally {
			E3Gpawfg.close();
		}
		assertEquals(((HttpURLConnection) PEeu9etj).getResponseCode(), 401);
		VnKs6fc9 = new URL("http://" + FDnKR1a5 + ":" + RXfY7KhC + "/");
		PEeu9etj = VnKs6fc9.openConnection();
		PEeu9etj.setRequestProperty("Authorization", "basic bXg0ajpteDRq");
		E3Gpawfg = PEeu9etj.getInputStream();
		E3Gpawfg.close();
		waitToStop();
		server.setAttribute(name, new Attribute("AuthenticationMethod", "none"));
	}

}