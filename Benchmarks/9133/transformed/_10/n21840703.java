class n21840703 {
	@Test
	public void parse() throws Exception {
		HtmlParser parser = new HtmlParser();
		URL url = new URL("http://www.oki.com");
		byte[] bytes = FileUtilities.getContents(url.openStream(), Integer.MAX_VALUE).toByteArray();
		OutputStream parsed = parser.parse(new ByteArrayInputStream(bytes), new ByteArrayOutputStream());
		assertTrue(parsed.toString().indexOf("Oki") > -1);
	}

}