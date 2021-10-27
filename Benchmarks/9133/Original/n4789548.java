class n4789548{
    public void testGetContentInputStream() {
        URL url;
        try {
            url = new URL("http://www.wurzer.org/" + "Homepage/Publikationen/Eintrage/2009/10/7_Wissen_dynamisch_organisieren_files/" + "KnowTech%202009%20-%20Wissen%20dynamisch%20organisieren.pdf");
            InputStream in = url.openStream();
            Content c = provider.getContent(in);
            assertNotNull(c);
            assertTrue(!c.getFulltext().isEmpty());
            assertTrue(c.getModificationDate() < System.currentTimeMillis());
            assertTrue(c.getAttributes().size() > 0);
            assertEquals("KnowTech 2009 - Wissen dynamisch organisieren", c.getAttributeByName("Title").getValue());
            assertEquals("Joerg Wurzer", c.getAttributeByName("Author").getValue());
            assertEquals("Pages", c.getAttributeByName("Creator").getValue());
            assertNull(c.getAttributeByName("Keywords"));
            assertTrue(c.getFulltext().startsWith("Wissen dynamisch organisieren"));
            assertTrue(c.getAttributeByName("Author").isKey());
            assertTrue(!c.getAttributeByName("Producer").isKey());
        } catch (MalformedURLException e) {
            fail("Malformed url - " + e.getMessage());
        } catch (IOException e) {
            fail("Couldn't read file - " + e.getMessage());
        }
    }

}