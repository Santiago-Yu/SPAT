class n19930844{
    public void testRegisterFactory() throws Exception {
        try {
            new URL("classpath:/");
            fail("MalformedURLException expected");
        } catch (MalformedURLException e) {
            assertTrue(true);
        }
        ClasspathURLConnection.registerFactory();
        URL url = new URL("classpath:/dummy.txt");
        try {
            url.openStream();
            fail("IOException expected");
        } catch (IOException e) {
            assertTrue(true);
        }
        ClasspathURLConnection.registerFactory();
        url = new URL("classpath:/net/sf/alster/xsl/alster.xml");
        InputStream in = url.openStream();
        assertEquals('<', in.read());
        in.close();
    }

}