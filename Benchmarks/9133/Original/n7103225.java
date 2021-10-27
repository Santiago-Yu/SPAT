class n7103225{
    public void testGetWithKeepAlive() throws Exception {
        HttpGet request = new HttpGet(baseUri + "/test");
        HttpResponse response = client.execute(request);
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertEquals("test", TestUtil.getResponseAsString(response));
        response = client.execute(request);
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertEquals("test", TestUtil.getResponseAsString(response));
    }

}