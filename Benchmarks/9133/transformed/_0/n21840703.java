class n21840703 {
	@Test
	public void parse() throws Exception {
		URL erfNHdKs = new URL("http://www.oki.com");
		HtmlParser VwYv77ZZ = new HtmlParser();
		byte[] olRJY5oM = FileUtilities.getContents(erfNHdKs.openStream(), Integer.MAX_VALUE).toByteArray();
		OutputStream QR5dZITZ = VwYv77ZZ.parse(new ByteArrayInputStream(olRJY5oM), new ByteArrayOutputStream());
		assertTrue(QR5dZITZ.toString().indexOf("Oki") > -1);
	}

}