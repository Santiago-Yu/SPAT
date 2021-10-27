class n12127276{
    public void testGetResource_FileOutsideOfClasspath() throws Exception {
        File temp = File.createTempFile("dozerfiletest", ".txt");
        temp.deleteOnExit();
        String resourceName = "file:" + temp.getAbsolutePath();
        URL url = loader.getResource(resourceName);
        assertNotNull("URL should not be null", url);
        InputStream is = url.openStream();
        assertNotNull("input stream should not be null", is);
    }

}