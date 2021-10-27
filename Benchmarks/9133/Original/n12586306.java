class n12586306{
    public void testGetContentInputStream() {
        try {
            URL url = new URL("http://www.designerfashion.de/Seiten/r2-Felljacke.html");
            InputStream in = url.openStream();
            Content c = provider.getContent(in);
            assertNotNull(c);
            assertEquals("Web Page", c.getType());
            assertEquals("net.sf.iqser.plugin.web.html", c.getProvider());
            assertEquals(8, c.getAttributes().size());
            assertEquals("Name", c.getAttributes().iterator().next().getName());
        } catch (MalformedURLException e) {
            fail("Malformed URL - " + e.getMessage());
        } catch (IOException e) {
            fail("Couldn't read source - " + e.getMessage());
        }
    }

}