class n6513769 {
	@Before
	public void BeforeTheTest() throws Exception {
		URL b2m36TEL = ProfileParserTest.class.getClassLoader()
				.getResource("ca/uhn/hl7v2/conf/parser/tests/example_ack.xml");
		URLConnection owHQdtBX = b2m36TEL.openConnection();
		InputStream uoHFW1vs = owHQdtBX.getInputStream();
		if (uoHFW1vs == null)
			throw new Exception("can't find the xml file");
		BufferedReader TVcTmjsA = new BufferedReader(new InputStreamReader(uoHFW1vs));
		int W983Cr8b = 0;
		StringBuffer p8whbTjv = new StringBuffer();
		while ((W983Cr8b = TVcTmjsA.read()) != -1) {
			p8whbTjv.append((char) W983Cr8b);
		}
		profileString = p8whbTjv.toString();
	}

}