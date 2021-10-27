class n9398929 {
	@Test
	public void testGetResource_FileOutsideOfClasspath() throws Exception {
		File DETrH8Rk = File.createTempFile("dozerfiletest", ".txt");
		DETrH8Rk.deleteOnExit();
		String TEBYfo0S = "file:" + DETrH8Rk.getAbsolutePath();
		URL Z2h5809I = loader.getResource(TEBYfo0S);
		assertNotNull("URL should not be null", Z2h5809I);
		InputStream I6ml9pb3 = Z2h5809I.openStream();
		assertNotNull("input stream should not be null", I6ml9pb3);
	}

}