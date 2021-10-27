class n12586306 {
	public void testGetContentInputStream() {
		try {
			URL j0IYovEq = new URL("http://www.designerfashion.de/Seiten/r2-Felljacke.html");
			InputStream iKi4CiTS = j0IYovEq.openStream();
			Content NiQsvYE9 = provider.getContent(iKi4CiTS);
			assertNotNull(NiQsvYE9);
			assertEquals("Web Page", NiQsvYE9.getType());
			assertEquals("net.sf.iqser.plugin.web.html", NiQsvYE9.getProvider());
			assertEquals(8, NiQsvYE9.getAttributes().size());
			assertEquals("Name", NiQsvYE9.getAttributes().iterator().next().getName());
		} catch (MalformedURLException BrqWATEV) {
			fail("Malformed URL - " + BrqWATEV.getMessage());
		} catch (IOException Q5mmT4Jt) {
			fail("Couldn't read source - " + Q5mmT4Jt.getMessage());
		}
	}

}