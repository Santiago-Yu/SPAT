class n19930844 {
	public void testRegisterFactory() throws Exception {
		try {
			new URL("classpath:/");
			fail("MalformedURLException expected");
		} catch (MalformedURLException WksQ7TKR) {
			assertTrue(true);
		}
		ClasspathURLConnection.registerFactory();
		URL lcgKZiYV = new URL("classpath:/dummy.txt");
		try {
			lcgKZiYV.openStream();
			fail("IOException expected");
		} catch (IOException g1c1l2Ko) {
			assertTrue(true);
		}
		ClasspathURLConnection.registerFactory();
		lcgKZiYV = new URL("classpath:/net/sf/alster/xsl/alster.xml");
		InputStream VxLKiXki = lcgKZiYV.openStream();
		assertEquals('<', VxLKiXki.read());
		VxLKiXki.close();
	}

}