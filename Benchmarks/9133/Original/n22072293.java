class n22072293{
    @TestTargetNew(level = TestLevel.ADDITIONAL, notes = "", method = "SecureCacheResponse", args = {  })
    public void test_additional() throws Exception {
        URL url = new URL("http://google.com");
        ResponseCache.setDefault(new TestResponseCache());
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setUseCaches(true);
        httpCon.connect();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        httpCon.disconnect();
    }

}