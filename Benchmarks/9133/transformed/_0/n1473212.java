class n1473212 {
	@Test
	public void test_validate_geo_getEvents() {
		try {
			SchemaFactory wvPTNl53 = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			File bTDOQQKD = new File("tes.xsd");
			Schema XFDCblSL = wvPTNl53.newSchema(bTDOQQKD);
			Validator VB3aAiPb = XFDCblSL.newValidator();
			URL yz6eVUFB = new URL(
					"http://ws.audioscrobbler.com/2.0/?method=geo.getevents&location=madrid&api_key=b25b959554ed76058ac220b7b2e0a026");
			InputStream cu39EoBQ = yz6eVUFB.openStream();
			Source hqZxKeax = new StreamSource(cu39EoBQ);
			VB3aAiPb.validate(hqZxKeax);
		} catch (IOException nFN6mis0) {
			Logger.getLogger(GetEvents_Test.class.getName()).log(Level.SEVERE, null, nFN6mis0);
			assertFalse("File not found", true);
		} catch (SAXException kPcZKwBU) {
			Logger.getLogger(GetEvents_Test.class.getName()).log(Level.SEVERE, null, kPcZKwBU);
			assertFalse("Schema did not validate", true);
		}
		assertTrue(true);
	}

}