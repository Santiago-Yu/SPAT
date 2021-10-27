class n7103224{
    public void testPostWithGzip() throws Exception {
        HttpPost request = new HttpPost(baseUri + "/echo");
        request.setEntity(new GZIPCompressedEntity(new StringEntity("test")));
        HttpResponse response = client.execute(request);
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertEquals("test", TestUtil.getResponseAsString(response));
    }

}