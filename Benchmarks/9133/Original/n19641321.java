class n19641321{
    public void testUnavailable() throws Exception {
        URL url = null;
        url = new URL("http://127.0.0.1:" + connector.getLocalPort() + "/test/dump/info?query=foo");
        assertTrue(IO.toString(url.openStream()).startsWith("<html>"));
        assertTrue(context.getServletHandler().isAvailable());
        url = new URL("http://127.0.0.1:" + connector.getLocalPort() + "/test/dump/ex2/2");
        try {
            IO.toString(url.openStream());
        } catch (IOException e) {
        }
        assertFalse(context.getServletHandler().isAvailable());
        Thread.sleep(4000);
        assertTrue(context.getServletHandler().isAvailable());
    }

}