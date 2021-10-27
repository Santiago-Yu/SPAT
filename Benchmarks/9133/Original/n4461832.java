class n4461832{
    @Test
    public void testXMLDBURLStreamHandler() {
        System.out.println("testXMLDBURLStreamHandler");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            URL url = new URL(XMLDB_URL_1);
            InputStream is = url.openStream();
            copyDocument(is, baos);
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            LOG.error(ex);
            fail(ex.getMessage());
        }
    }

}