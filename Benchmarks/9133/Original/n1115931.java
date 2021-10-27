class n1115931{
    public void testSetRequestProperty() throws Exception {
        MockHTTPServer httpServer = new MockHTTPServer("HTTP Server for User-Specified Request Property", 2);
        httpServer.start();
        synchronized (bound) {
            if (!httpServer.started) {
                bound.wait(5000);
            }
        }
        HttpURLConnection urlConnection = (HttpURLConnection) new URL("http://localhost:" + httpServer.port()).openConnection();
        assertEquals(0, urlConnection.getRequestProperties().size());
        final String PROPERTY1 = "Accept";
        final String PROPERTY2 = "Connection";
        urlConnection.setRequestProperty(PROPERTY1, null);
        urlConnection.setRequestProperty(PROPERTY1, null);
        urlConnection.setRequestProperty(PROPERTY2, "keep-alive");
        assertEquals(2, urlConnection.getRequestProperties().size());
        assertNull(urlConnection.getRequestProperty(PROPERTY1));
        assertEquals("keep-alive", urlConnection.getRequestProperty(PROPERTY2));
        urlConnection.setRequestProperty(PROPERTY1, "/");
        urlConnection.setRequestProperty(PROPERTY2, null);
        assertEquals("/", urlConnection.getRequestProperty(PROPERTY1));
        assertNull(urlConnection.getRequestProperty(PROPERTY2));
    }

}