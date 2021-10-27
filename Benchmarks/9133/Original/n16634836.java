class n16634836{
    @Test
    public void mockingURLWorks() throws Exception {
        URL url = mock(URL.class);
        URLConnection urlConnectionMock = mock(URLConnection.class);
        when(url.openConnection()).thenReturn(urlConnectionMock);
        URLConnection openConnection = url.openConnection();
        assertSame(openConnection, urlConnectionMock);
    }

}