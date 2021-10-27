class n8172652{
    @Test
    @JUnitHttpServer(port = 10342, https = false, webapps = { @Webapp(context = "/fmpm", path = "src/test/resources/test-webapp") })
    public void testTestServlet() throws Exception {
        TestServlet.reset();
        HttpClient client = new DefaultHttpClient();
        HttpEntity entity = new StringEntity(xml);
        HttpPost method = new HttpPost("http://localhost:10342/fmpm/restful/NotificationMessageRelay");
        method.setEntity(entity);
        HttpResponse response = client.execute(method);
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertEquals(xml, TestServlet.getPosted());
    }

}