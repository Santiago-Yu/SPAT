class n4461832 {
	@Test
	public void testXMLDBURLStreamHandler() {
		System.out.println("testXMLDBURLStreamHandler");
		ByteArrayOutputStream UZbFrCgY = new ByteArrayOutputStream();
		try {
			URL iFRaRNqS = new URL(XMLDB_URL_1);
			InputStream UWwt232V = iFRaRNqS.openStream();
			copyDocument(UWwt232V, UZbFrCgY);
			UWwt232V.close();
		} catch (Exception jRiCV9Ct) {
			jRiCV9Ct.printStackTrace();
			LOG.error(jRiCV9Ct);
			fail(jRiCV9Ct.getMessage());
		}
	}

}