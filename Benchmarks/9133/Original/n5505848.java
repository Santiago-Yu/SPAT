class n5505848{
    public void testResponseTimeout() throws Exception {
        server.enqueue(new MockResponse().setBody("ABC").clearHeaders().addHeader("Content-Length: 4"));
        server.enqueue(new MockResponse().setBody("DEF"));
        server.play();
        URLConnection urlConnection = server.getUrl("/").openConnection();
        urlConnection.setReadTimeout(1000);
        InputStream in = urlConnection.getInputStream();
        assertEquals('A', in.read());
        assertEquals('B', in.read());
        assertEquals('C', in.read());
        try {
            in.read();
            fail();
        } catch (SocketTimeoutException expected) {
        }
        URLConnection urlConnection2 = server.getUrl("/").openConnection();
        InputStream in2 = urlConnection2.getInputStream();
        assertEquals('D', in2.read());
        assertEquals('E', in2.read());
        assertEquals('F', in2.read());
        assertEquals(-1, in2.read());
        assertEquals(0, server.takeRequest().getSequenceNumber());
        assertEquals(0, server.takeRequest().getSequenceNumber());
    }

}