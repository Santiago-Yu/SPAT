class n5404510{
    @MediumTest
    public void testUrlRewriteRules() throws Exception {
        ContentResolver resolver = getContext().getContentResolver();
        GoogleHttpClient client = new GoogleHttpClient(resolver, "Test", false);
        Settings.Gservices.putString(resolver, "url:test", "http://foo.bar/ rewrite " + mServerUrl + "new/");
        Settings.Gservices.putString(resolver, "digest", mServerUrl);
        try {
            HttpGet method = new HttpGet("http://foo.bar/path");
            HttpResponse response = client.execute(method);
            String body = EntityUtils.toString(response.getEntity());
            assertEquals("/new/path", body);
        } finally {
            client.close();
        }
    }

}