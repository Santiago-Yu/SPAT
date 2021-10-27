class n20190305{
    @Test
    public void test02_ok_200_logo() throws Exception {
        DefaultHttpClient client = new DefaultHttpClient();
        try {
            HttpPost post = new HttpPost(xlsURL);
            HttpResponse response = client.execute(post);
            assertEquals("failed code for ", 200, response.getStatusLine().getStatusCode());
        } finally {
            client.getConnectionManager().shutdown();
        }
    }

}