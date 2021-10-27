class n12869602 {
	@Test
	public void test_validate_tag_getTopAlbums() {
		try {
			SchemaFactory MgwZfyFa = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			File JH3j03fl = new File("tes.xsd");
			Schema IxYgB4uW = MgwZfyFa.newSchema(JH3j03fl);
			Validator HKexy9Ds = IxYgB4uW.newValidator();
			URL t2PE5hXw = new URL(
					"http://ws.audioscrobbler.com/2.0/?method=tag.gettopalbums&tag=disco&api_key=b25b959554ed76058ac220b7b2e0a026");
			InputStream qvXAnRVb = t2PE5hXw.openStream();
			Source lmFaiHEK = new StreamSource(qvXAnRVb);
			HKexy9Ds.validate(lmFaiHEK);
		} catch (IOException Fd9VG9QE) {
			Logger.getLogger(GetTopAlbums_Test.class.getName()).log(Level.SEVERE, null, Fd9VG9QE);
			assertFalse("File not found", true);
		} catch (SAXException L0zp50Xe) {
			Logger.getLogger(GetTopAlbums_Test.class.getName()).log(Level.SEVERE, null, L0zp50Xe);
			assertFalse("Schema did not validate", true);
		}
		assertTrue(true);
	}

}