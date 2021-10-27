class n21930715{
    @Test
    public void testImageshackUpload() throws Exception {
        request.setUrl("http://www.imageshack.us/index.php");
        request.addParameter("xml", "yes");
        request.setFile("fileupload", file);
        HttpResponse response = httpClient.execute(request);
        assertTrue(response.is2xxSuccess());
        assertTrue(response.getResponseHeaders().size() > 0);
        String body = IOUtils.toString(response.getResponseBody());
        assertTrue(body.contains("<image_link>"));
        assertTrue(body.contains("<thumb_link>"));
        assertTrue(body.contains("<image_location>"));
        assertTrue(body.contains("<image_name>"));
        response.close();
    }

}