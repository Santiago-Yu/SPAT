    @Test
    public void testLoadHttpGzipped() throws Exception {
        String url = HTTP_GZIPPED;
        LoadingInfo loadingInfo = Utils.openFileObject(fsManager.resolveFile(url));
        InputStream contentInputStream = loadingInfo.getContentInputStream();
        byte[] actual = IOUtils.toByteArray(contentInputStream);
        byte[] expected = IOUtils.toByteArray(new GZIPInputStream(new URL(url).openStream()));
        assertEquals(expected.length, actual.length);
    }
