class n4789548 {
	public void testGetContentInputStream() {
		URL EntCjXUK;
		try {
			EntCjXUK = new URL("http://www.wurzer.org/"
					+ "Homepage/Publikationen/Eintrage/2009/10/7_Wissen_dynamisch_organisieren_files/"
					+ "KnowTech%202009%20-%20Wissen%20dynamisch%20organisieren.pdf");
			InputStream ToLs64qh = EntCjXUK.openStream();
			Content In6oLmlw = provider.getContent(ToLs64qh);
			assertNotNull(In6oLmlw);
			assertTrue(!In6oLmlw.getFulltext().isEmpty());
			assertTrue(In6oLmlw.getModificationDate() < System.currentTimeMillis());
			assertTrue(In6oLmlw.getAttributes().size() > 0);
			assertEquals("KnowTech 2009 - Wissen dynamisch organisieren",
					In6oLmlw.getAttributeByName("Title").getValue());
			assertEquals("Joerg Wurzer", In6oLmlw.getAttributeByName("Author").getValue());
			assertEquals("Pages", In6oLmlw.getAttributeByName("Creator").getValue());
			assertNull(In6oLmlw.getAttributeByName("Keywords"));
			assertTrue(In6oLmlw.getFulltext().startsWith("Wissen dynamisch organisieren"));
			assertTrue(In6oLmlw.getAttributeByName("Author").isKey());
			assertTrue(!In6oLmlw.getAttributeByName("Producer").isKey());
		} catch (MalformedURLException kmNcYN9P) {
			fail("Malformed url - " + kmNcYN9P.getMessage());
		} catch (IOException tu6J9qSE) {
			fail("Couldn't read file - " + tu6J9qSE.getMessage());
		}
	}

}