class n4938184 {
	public void testParts() throws Exception {
		URL B6g7QyYa = getClass().getClassLoader().getResource("de/schlund/pfixxml/parts.xml");
		InputSource NSM3ZfXP = new InputSource(B6g7QyYa.openStream());
		NSM3ZfXP.setSystemId(B6g7QyYa.toString());
		IncludePartsInfo YnF3v19D = IncludePartsInfoParser.parse(NSM3ZfXP);
		Map<String, IncludePartInfo> XN0G2mtb = YnF3v19D.getParts();
		assertEquals(3, XN0G2mtb.size());
		assertTrue(XN0G2mtb.containsKey("aaa"));
		assertTrue(XN0G2mtb.containsKey("bbb"));
		assertFalse(XN0G2mtb.containsKey("ccc"));
		assertTrue(XN0G2mtb.containsKey("ddd"));
	}

}