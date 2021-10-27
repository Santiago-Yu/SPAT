class n12869602 {
	@Test
	public void test_validate_tag_getTopAlbums() {
		try {
			File schemaLocation = new File("tes.xsd");
			SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			Schema schema = factory.newSchema(schemaLocation);
			URL url = new URL(
					"http://ws.audioscrobbler.com/2.0/?method=tag.gettopalbums&tag=disco&api_key=b25b959554ed76058ac220b7b2e0a026");
			Validator validator = schema.newValidator();
			InputStream inputStream = url.openStream();
			Source source = new StreamSource(inputStream);
			validator.validate(source);
		} catch (IOException ex) {
			Logger.getLogger(GetTopAlbums_Test.class.getName()).log(Level.SEVERE, null, ex);
			assertFalse("File not found", true);
		} catch (SAXException ex) {
			Logger.getLogger(GetTopAlbums_Test.class.getName()).log(Level.SEVERE, null, ex);
			assertFalse("Schema did not validate", true);
		}
		assertTrue(true);
	}

}