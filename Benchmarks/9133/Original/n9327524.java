class n9327524{
    @Test
    public void test01_ok_failed_500() throws Exception {
        DefaultHttpClient client = new DefaultHttpClient();
        try {
            HttpPost post = new HttpPost(chartURL);
            HttpResponse response = client.execute(post);
            assertEquals("failed code for ", 500, response.getStatusLine().getStatusCode());
        } finally {
            client.getConnectionManager().shutdown();
        }
    }

}